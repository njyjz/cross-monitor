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

var subNodeName = "subNodeList";

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
                console.log(_this);

                var results = resp.data;
                // var result = [];
                // results.map(function(item,index){
                //     console.log('map',item);
                //     var obj = item;

                //     obj[subNodeName].map(function(childItem,childIndex){
                //         childItem[subNodeName] = childItem.referenceNodeList;
                //     })
                //     result.push(obj);
                // })
                _this.data = results;
                _this.dealData = results;

                _this.setParent(_this.data, 1, -1);
            });
        },

        handleDeleteRow: function handleDeleteRow(item) {
            var _this = this;
            var confirmOk = function confirmOk() {
                _this.$http({
                    method: 'post',
                    url: '/delServiceNode.do',
                    data: {
                        serviceName: item.serviceName,
                        serviceNodeAddr: item.serviceNodeAddr
                    }

                }).then(function (resp) {
                    // console.log(resp);
                    _this.$message({
                        type: 'success',
                        message: resp.status
                    });
                });
            };
            _this.$confirm('确定删除此', '提示', {
                confirmButtonText: '确定',
                cancelButtonText: '取消',
                type: 'warning'
            }).then(function () {
                confirmOk();
            });
        },

        setParent: function setParent(data, level, n) {
            // console.log(data, level, n);
            for (var a = data.length, r = 0; r < a; r++) {
                var item = data[r];
                item.checkbox = false;
                item.currentLevel = level;
                item.parentIndex = -1 == n ? null : n;
                if (item[subNodeName] && 0 != item[subNodeName].length) {
                    var l = -1 === n ? r : item.parentIndex + "-" + r;
                    this.setParent(item[subNodeName], level + 1, l);
                }
            }
        },
        iconStyle: function iconStyle(e) {
            return {
                marginLeft: 10 * e.currentLevel + "px"
            };
        },
        iconClass: function iconClass(e) {
            return e[subNodeName] && 0 != e[subNodeName].length ? e.isOpen ? {
                "icon-open": !0
            } : {
                "icon-close": !0
            } : {
                "icon-default": !0
            };
        },
        toggleChildren: function toggleChildren(e, t) {
            // console.log("toggle", e, t);
            e[subNodeName] && 0 != e[subNodeName].length && (e.isOpen ? this.closeRow(e, t) : this.openRow(e, t));
        },
        openRow: function openRow(e, t) {
            if (!e.isOpen) {
                for (var n = 0; n < e[subNodeName].length; n++) {
                    this.dealData.splice(t + n + 1, 0, e[subNodeName][n]);
                }
                e.isOpen = true;
            }
        },
        closeRow: function closeRow(row, index) {
            // console.log("-----", index, spliceLength);
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
                // console.log("-----", index, spliceLength);
                this.dealData.splice(index + 1, spliceLength);
                // console.log(this.dealData)
                item.isOpen = false;
            }
            row.isOpen = false;
        },
        /**
         * 点击多选按钮 操作
         * @param  {[type]} item  [description]
         * @param  {[type]} index [description]
         * @return {[type]}       [description]
         */
        handleChangCheck: function handleChangCheck(item, index) {
            // console.log(item);
            this.setChildCheckBoxStatus(item, !item.checkbox);
            //return !item.checkbox;
        },

        setChildCheckBoxStatus: function setChildCheckBoxStatus(item, bool) {
            if (item[subNodeName].length === 0) {
                return;
            }
            for (var i = 0, ilength = item[subNodeName].lenth; i < ilength; i++) {
                var childItem = item[subNodeName][i];
                childItem.checkbox = bool;
                if (childItem[subNodeName] && childItem[subNodeName].length !== 0) {
                    this.setChildCheckBoxStatus(childItem, bool);
                }
            }
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
//# sourceMappingURL=0.js.map