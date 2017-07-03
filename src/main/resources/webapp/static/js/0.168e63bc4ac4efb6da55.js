webpackJsonp([0],{

/***/ 109:
/***/ (function(module, exports, __webpack_require__) {

function injectStyle (ssrContext) {
  __webpack_require__(113)
}
var Component = __webpack_require__(8)(
  /* script */
  __webpack_require__(111),
  /* template */
  __webpack_require__(114),
  /* styles */
  injectStyle,
  /* scopeId */
  null,
  /* moduleIdentifier (server only) */
  null
)

module.exports = Component.exports


/***/ }),

/***/ 111:
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
Object.defineProperty(__webpack_exports__, "__esModule", { value: true });
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//

/* harmony default export */ __webpack_exports__["default"] = ({
    name: "treeTable",
    componentName: "treeTable",
    props: {
        // data: Array
    },
    data: function data() {
        return {
            dealData: [],
            data: []
        };
    },

    watch: {},
    mounted: function mounted() {
        console.log('treeTable', this);
        this.getData();
    },
    methods: {
        getData: function getData() {
            var _this = this;
            this.$http({
                method: 'post',
                url: '/queryCrossReferences.do',
                data: {}

            }).then(function (resp) {
                console.log(resp);
                if (resp.status !== 200) {
                    _this.$message({
                        message: "加载失败",
                        type: "error"
                    });
                }

                var result = resp.data;
                if (result.length == 0 || result[1].serviceName === null) {
                    result = [];
                }
                _this.data = result;
                _this.dealData = result;
                _this.setParent(result, 1, -1);
            });
        },

        handleDeleteRow: function handleDeleteRow(item) {
            var obj = {
                serviceName: item.serviceName,
                serviceNodeAddr: item.serviceNodeAddr ? item.serviceNodeAddr : undefined
            };
            $.ajax({
                url: "http://localhost:10000/monitor/delServiceNode.do",
                type: "post",
                headers: {
                    Accept: "application/json",
                    "Content-Type": "application/json"
                },
                data: JSON.stringify(obj),
                dataType: "json",
                success: function success(e) {
                    //console.log(e);

                    _this.data = e;
                    _this.dealData = e;
                    _this.setParent(_this.data, 1, -1);
                },
                error: function error() {
                    console.log("更新用户服务请求失败！");
                }
            });
        },

        setParent: function setParent(data, level, n) {
            console.log(data, level, n);
            for (var a = data.length, r = 0; r < a; r++) {
                var item = data[r];
                item.checkbox = false;
                item.currentLevel = level;
                item.parentIndex = -1 == n ? null : n;
                if (item.nodeList && 0 != item.nodeList.length) {
                    var l = -1 === n ? r : item.parentIndex + "-" + r;
                    this.setParent(item.nodeList, level + 1, l);
                }
            }
        },
        iconStyle: function iconStyle(e) {
            return {
                marginLeft: 10 * e.currentLevel + "px"
            };
        },
        iconClass: function iconClass(e) {
            return e.nodeList && 0 != e.nodeList.length ? e.isOpen ? {
                "icon-open": !0
            } : {
                "icon-close": !0
            } : {
                "icon-default": !0
            };
        },
        toggleChildren: function toggleChildren(e, t) {
            console.log("toggle", e, t);
            e.nodeList && 0 != e.nodeList.length && (e.isOpen ? this.closeRow(e, t) : this.openRow(e, t));
        },
        openRow: function openRow(e, t) {
            if (!e.isOpen) {
                for (var n = 0; n < e.nodeList.length; n++) {
                    this.dealData.splice(t + n + 1, 0, e.nodeList[n]);
                }
                e.isOpen = true;
            }
        },
        closeRow: function closeRow(row, index) {
            console.log("-----", index, spliceLength);
            var spliceLength = 0;
            if (row.isOpen) {
                for (var i = index + 1, ilength = this.dealData.length; i < ilength; i++) {
                    var item = this.dealData[i];
                    if (item.currentLevel == row.currentLevel) {
                        spliceLength = i - index - 1;
                        break;
                    }
                    if (item.isOpen = true) {
                        item.isOpen = false;
                    }
                }
                console.log("-----", index, spliceLength);
                this.dealData.splice(index + 1, spliceLength);
                console.log(this.dealData);
                item.isOpen = false;
            }
            row.isOpen = false;
            // if (row.isOpen) {
            //     for (var n = e.currentLevel, a = 0, r = t + 1, o = this.dealData.length; r < o; r++) {
            //         var l = this.dealData[r];
            //         if (l.isOpen = !1, console.log(l.currentLevel >= n), l.currentLevel <= n) {
            //             a = r - t - 1;
            //             break
            //         }
            //     }
            //     console.log(a), this.dealData.splice(t + 1, a), e.isOpen = !1
            // }
        }
    }
});

/***/ }),

/***/ 112:
/***/ (function(module, exports, __webpack_require__) {

exports = module.exports = __webpack_require__(108)(true);
// imports


// module
exports.push([module.i, ".pc-header{height:60px}.f-treetable .td{text-align:left}.f-treetable .table-tree-icon{display:inline-block;margin-left:10px}.f-treetable .yz-icon{position:relative;display:inline-block;height:18px;width:18px}.f-treetable .yz-icon.icon-close{background:url(\"/static/img/server/folderClose.gif\") 2px -1px no-repeat}.f-treetable .yz-icon.icon-open{background:url(\"/static/img/server/folderOpen.gif\") 2px -1px no-repeat}.f-treetable .yz-icon.icon-default{background:url(\"/static/img/server/defaultLeaf.gif\") 2px -1px no-repeat}.btn-icon{display:inline-block;width:24px;height:24px;text-align:center}.btn-icon:hover{color:#20a0ff}", "", {"version":3,"sources":["D:/project/crossmoitor/crossmonitor/src/components/CrossReferences.vue"],"names":[],"mappings":"AACA,WACI,WAAY,CACf,AACD,iBACI,eAAiB,CACpB,AACD,8BACI,qBAAsB,AACtB,gBAAkB,CACrB,AACD,sBACI,kBAAmB,AACnB,qBAAsB,AACtB,YAAa,AACb,UAAY,CACf,AACD,iCACI,uEAAwE,CAC3E,AACD,gCACI,sEAAuE,CAC1E,AACD,mCACI,uEAAwE,CAC3E,AACD,UACI,qBAAsB,AACtB,WAAY,AACZ,YAAa,AACb,iBAAmB,CACtB,AACD,gBACI,aAAe,CAClB","file":"CrossReferences.vue","sourcesContent":["\n.pc-header {\r\n    height: 60px\n}\n.f-treetable .td {\r\n    text-align: left;\n}\n.f-treetable .table-tree-icon {\r\n    display: inline-block;\r\n    margin-left: 10px;\n}\n.f-treetable .yz-icon {\r\n    position: relative;\r\n    display: inline-block;\r\n    height: 18px;\r\n    width: 18px;\n}\n.f-treetable .yz-icon.icon-close {\r\n    background: url(\"/static/img/server/folderClose.gif\") 2px -1px no-repeat\n}\n.f-treetable .yz-icon.icon-open {\r\n    background: url(\"/static/img/server/folderOpen.gif\") 2px -1px no-repeat\n}\n.f-treetable .yz-icon.icon-default {\r\n    background: url(\"/static/img/server/defaultLeaf.gif\") 2px -1px no-repeat\n}\n.btn-icon {\r\n    display: inline-block;\r\n    width: 24px;\r\n    height: 24px;\r\n    text-align: center;\n}\n.btn-icon:hover {\r\n    color: #20a0ff;\n}\r\n"],"sourceRoot":""}]);

// exports


/***/ }),

/***/ 113:
/***/ (function(module, exports, __webpack_require__) {

// style-loader: Adds some css to the DOM by adding a <style> tag

// load the styles
var content = __webpack_require__(112);
if(typeof content === 'string') content = [[module.i, content, '']];
if(content.locals) module.exports = content.locals;
// add the styles to the DOM
var update = __webpack_require__(110)("073dd3c4", content, true);

/***/ }),

/***/ 114:
/***/ (function(module, exports) {

module.exports={render:function (){var _vm=this;var _h=_vm.$createElement;var _c=_vm._self._c||_h;
  return _c('div', {
    staticClass: "f-treetable panel panel-success"
  }, [_c('div', {
    staticClass: "panel-heading",
    staticStyle: {
      "text-align": "left"
    }
  }, [_vm._v("\n        CrossReferences\n    ")]), _vm._v(" "), _c('div', {
    staticClass: "panel-body"
  }, [_c('div', {
    staticClass: "yz-treetable"
  }, [_c('table', {
    staticClass: "table table-bordered"
  }, [_vm._m(0), _vm._v(" "), _vm._m(1), _vm._v(" "), _c('tbody', [_vm._l((_vm.dealData), function(item, $index) {
    return _c('tr', [_c('td', {
      staticStyle: {
        "text-align": "left"
      }
    }, [_c('div', {
      staticClass: "table-tree-icon",
      style: (_vm.iconStyle(item)),
      on: {
        "click": function($event) {
          _vm.toggleChildren(item, $index)
        }
      }
    }, [_c('i', {
      staticClass: "yz-icon",
      class: _vm.iconClass(item)
    })])]), _vm._v(" "), _c('td', [_vm._v(_vm._s(item.serviceName))]), _vm._v(" "), _c('td', [_vm._v(_vm._s(item.address))]), _vm._v(" "), _c('td', [_vm._v(_vm._s(item.status))]), _vm._v(" "), _c('td', [_c('div', {
      staticClass: "btn-icon",
      attrs: {
        "title": "删除"
      },
      on: {
        "click": function($event) {
          _vm.handleDeleteRow(item)
        }
      }
    }, [_c('i', {
      staticClass: "icon iconfont icon-shanchu"
    })])])])
  }), _vm._v(" "), (_vm.dealData.length == 0) ? _c('tr', [_c('td', {
    attrs: {
      "colspan": "5"
    }
  }, [_vm._v("\n                            没有数据\n                        ")])]) : _vm._e()], 2)])])])])
},staticRenderFns: [function (){var _vm=this;var _h=_vm.$createElement;var _c=_vm._self._c||_h;
  return _c('colgroup', [_c('col', {
    attrs: {
      "width": "100px"
    }
  }), _vm._v(" "), _c('col'), _vm._v(" "), _c('col', {
    attrs: {
      "width": "300px"
    }
  }), _vm._v(" "), _c('col', {
    attrs: {
      "width": "300px"
    }
  }), _vm._v(" "), _c('col', {
    attrs: {
      "width": "300px"
    }
  })])
},function (){var _vm=this;var _h=_vm.$createElement;var _c=_vm._self._c||_h;
  return _c('thead', [_c('tr', [_c('th', [_vm._v("序号")]), _vm._v(" "), _c('th', [_vm._v("服务名称")]), _vm._v(" "), _c('th', [_vm._v("地址")]), _vm._v(" "), _c('th', [_vm._v("状态")]), _vm._v(" "), _c('th', [_vm._v("操作")])])])
}]}

/***/ })

});
//# sourceMappingURL=0.168e63bc4ac4efb6da55.js.map