# cross-monitor
## 功能说明
全局监控所有注册到zookeeper上的服务端以及对应的客户端，提供检测各服务端节点状态、删除失效服务端节点、查询服务端对应客户端、查询客户端对服务端请求数据、响应结果、耗时等信息的功能。
## 架构说明
### 总体架构
![](https://github.com/njyjz/cross-monitor/raw/master/readme-elements/逻辑架构.png)
### 系统实现分层
![](https://github.com/njyjz/cross-monitor/raw/master/readme-elements/CrossMonitor实现分层.png)
### 注册中心服务端导向数据结构图
![](https://github.com/njyjz/cross-monitor/raw/master/readme-elements/zookeeper服务端导向数据结构图.png)
### 注册中心客户端导向数据结构图
![](https://github.com/njyjz/cross-monitor/raw/master/readme-elements/zookeeper客户端导向数据结构图.png)
## 系统界面
