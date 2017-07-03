package com.yjz.cross.monitor.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Map;
import java.util.Properties;

import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.factory.DefaultObjectFactory;
import org.apache.ibatis.reflection.factory.ObjectFactory;
import org.apache.ibatis.reflection.wrapper.DefaultObjectWrapperFactory;
import org.apache.ibatis.reflection.wrapper.ObjectWrapperFactory;
import org.apache.ibatis.session.RowBounds;

import com.yjz.cross.monitor.pojo.Pagination;

@Intercepts({@Signature(type = StatementHandler.class, method = "prepare", args = {Connection.class})})
public class PaginationInterceptor implements Interceptor
{
    
    // private static final Log logger = LogFactory.getLog(PaginationInterceptor.class);
    
    private static final ObjectFactory DEFAULT_OBJECT_FACTORY = new DefaultObjectFactory();
    
    private static final ObjectWrapperFactory DEFAULT_OBJECT_WRAPPER_FACTORY = new DefaultObjectWrapperFactory();
    
    private static String DEFAULT_PAGE_SQL_ID = ".*ByPage$"; // 需要拦截的ID(正则匹配)
    
    @Override
    public Object intercept(Invocation invocation)
        throws Throwable
    {
        StatementHandler statementHandler = (StatementHandler)invocation.getTarget();
        MetaObject metaStatementHandler =
            MetaObject.forObject(statementHandler, DEFAULT_OBJECT_FACTORY, DEFAULT_OBJECT_WRAPPER_FACTORY);
        // RowBounds rowBounds = (RowBounds)metaStatementHandler.getValue("delegate.rowBounds");
        // 分离代理对象链(由于目标类可能被多个拦截器拦截，从而形成多次代理，通过下面的两次循环可以分离出最原始的的目标类)
        while (metaStatementHandler.hasGetter("h"))
        {
            Object object = metaStatementHandler.getValue("h");
            metaStatementHandler = MetaObject.forObject(object, DEFAULT_OBJECT_FACTORY, DEFAULT_OBJECT_WRAPPER_FACTORY);
        }
        // 分离最后一个代理对象的目标类
        while (metaStatementHandler.hasGetter("target"))
        {
            Object object = metaStatementHandler.getValue("target");
            metaStatementHandler = MetaObject.forObject(object, DEFAULT_OBJECT_FACTORY, DEFAULT_OBJECT_WRAPPER_FACTORY);
        }
        
        // property在mybatis settings文件内配置
        // Configuration configuration = (Configuration)metaStatementHandler.getValue("delegate.configuration");
        
        MappedStatement mappedStatement = (MappedStatement)metaStatementHandler.getValue("delegate.mappedStatement");
        // 只重写需要分页的sql语句。通过MappedStatement的ID匹配，默认重写以Page结尾的MappedStatement的sql
        if (mappedStatement.getId().matches(DEFAULT_PAGE_SQL_ID))
        {
            BoundSql boundSql = (BoundSql)metaStatementHandler.getValue("delegate.boundSql");
            Object parameterObject = boundSql.getParameterObject();
            if (parameterObject == null)
            {
                throw new NullPointerException("parameterObject is null!");
            }
            else
            {
                String sql = boundSql.getSql();
                // 查询总条数的SQL语句
                String countSql = "select count(*) from (" + sql.substring(0, sql.length() - 1) + ") a";
                Connection connection = (Connection)invocation.getArgs()[0];
                PreparedStatement countStatement = connection.prepareStatement(countSql);
                ParameterHandler parameterHandler =
                    (ParameterHandler)metaStatementHandler.getValue("delegate.parameterHandler");
                parameterHandler.setParameters(countStatement);
                ResultSet rs = countStatement.executeQuery();
                
                Map<?, ?> parameter = (Map<?, ?>)boundSql.getParameterObject();
                Pagination page = (Pagination)parameter.get("page");
                if (rs.next())
                {
                    page.setTotalNumber(rs.getInt(1));
                    page.count();
                }
                
                // 重写sql
                String pageSql =
                    sql.substring(0, sql.length() - 1) + " LIMIT " + page.getDbIndex() + "," + page.getDbNumber();
                metaStatementHandler.setValue("delegate.boundSql.sql", pageSql);
                // 采用物理分页后，就不需要mybatis的内存分页了，所以重置下面的两个参数
                metaStatementHandler.setValue("delegate.rowBounds.offset", RowBounds.NO_ROW_OFFSET);
                metaStatementHandler.setValue("delegate.rowBounds.limit", RowBounds.NO_ROW_LIMIT);
            }
        }
        // 将执行权交给下一个拦截器
        return invocation.proceed();
    }
    
    @Override
    public Object plugin(Object target)
    {
        // 当目标类是StatementHandler类型时，才包装目标类，否者直接返回目标本身,减少目标被代理的
        if (target instanceof StatementHandler)
        {
            return Plugin.wrap(target, this);
        }
        else
        {
            return target;
        }
    }
    
    @Override
    public void setProperties(Properties target)
    {
        // TODO Auto-generated method stub
        
    }
    
}