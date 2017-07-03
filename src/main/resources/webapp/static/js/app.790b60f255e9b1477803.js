webpackJsonp([2],{

/***/ 101:
/***/ (function(module, exports, __webpack_require__) {

var Component = __webpack_require__(8)(
  /* script */
  __webpack_require__(77),
  /* template */
  __webpack_require__(103),
  /* styles */
  null,
  /* scopeId */
  null,
  /* moduleIdentifier (server only) */
  null
)

module.exports = Component.exports


/***/ }),

/***/ 102:
/***/ (function(module, exports) {

module.exports={render:function (){var _vm=this;var _h=_vm.$createElement;var _c=_vm._self._c||_h;
  return _c('div', {
    attrs: {
      "id": "app"
    }
  }, [_c('router-view')], 1)
},staticRenderFns: []}

/***/ }),

/***/ 103:
/***/ (function(module, exports) {

module.exports={render:function (){var _vm=this;var _h=_vm.$createElement;var _c=_vm._self._c||_h;
  return _c('div', {
    staticClass: "f-index pc-header container"
  }, [_c('el-menu', {
    staticClass: "el-menu-demo",
    attrs: {
      "theme": "dark",
      "mode": "horizontal"
    },
    on: {
      "select": _vm.handleSelect
    }
  }, [_c('el-submenu', {
    attrs: {
      "index": "2"
    }
  }, [_c('template', {
    slot: "title"
  }, [_vm._v("我的工作台")]), _vm._v(" "), _c('el-menu-item', {
    attrs: {
      "index": "/crossres"
    }
  }, [_vm._v("CrossReferences")]), _vm._v(" "), _c('el-menu-item', {
    attrs: {
      "index": "/"
    }
  }, [_vm._v("Cross")])], 2)], 1), _vm._v(" "), _c('div', {
    staticClass: "pc-body"
  }, [_c('router-view')], 1)], 1)
},staticRenderFns: []}

/***/ }),

/***/ 104:
/***/ (function(module, exports) {

module.exports={render:function (){var _vm=this;var _h=_vm.$createElement;var _c=_vm._self._c||_h;
  return _c('div', {
    staticClass: "f-treetable panel panel-success"
  }, [_c('div', {
    staticClass: "panel-heading",
    staticStyle: {
      "text-align": "left"
    }
  }, [_vm._v("\n        cross\n    ")]), _vm._v(" "), _c('div', {
    staticClass: "panel-body"
  }, [_c('div', {
    staticClass: "yz-treetable"
  }, [_c('table', {
    staticClass: "table table-bordered"
  }, [_vm._m(0), _vm._v(" "), _vm._m(1), _vm._v(" "), _c('tbody', _vm._l((_vm.dealData), function(item, $index) {
    return _c('tr', [_c('td'), _vm._v(" "), _c('td', {
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
  }))])])])])
},staticRenderFns: [function (){var _vm=this;var _h=_vm.$createElement;var _c=_vm._self._c||_h;
  return _c('colgroup', [_c('col', {
    attrs: {
      "width": "50px"
    }
  }), _vm._v(" "), _c('col', {
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
  return _c('thead', [_c('tr', [_c('th'), _vm._v(" "), _c('th', [_vm._v("序号")]), _vm._v(" "), _c('th', [_vm._v("服务名称")]), _vm._v(" "), _c('th', [_vm._v("地址")]), _vm._v(" "), _c('th', [_vm._v("状态")]), _vm._v(" "), _c('th', [_vm._v("操作")])])])
}]}

/***/ }),

/***/ 30:
/***/ (function(module, exports, __webpack_require__) {

function injectStyle (ssrContext) {
  __webpack_require__(98)
}
var Component = __webpack_require__(8)(
  /* script */
  __webpack_require__(76),
  /* template */
  __webpack_require__(104),
  /* styles */
  injectStyle,
  /* scopeId */
  null,
  /* moduleIdentifier (server only) */
  null
)

module.exports = Component.exports


/***/ }),

/***/ 32:
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0_vue__ = __webpack_require__(3);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1_vue_router__ = __webpack_require__(105);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__pages_index_vue__ = __webpack_require__(101);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__pages_index_vue___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_2__pages_index_vue__);




__WEBPACK_IMPORTED_MODULE_0_vue__["default"].use(__WEBPACK_IMPORTED_MODULE_1_vue_router__["a" /* default */]);

/* harmony default export */ __webpack_exports__["a"] = (new __WEBPACK_IMPORTED_MODULE_1_vue_router__["a" /* default */]({
    routes: [{
        path: '/',
        name: 'Hello',
        component: __WEBPACK_IMPORTED_MODULE_2__pages_index_vue___default.a,
        children: [{
            path: '/',
            name: 'Hello',
            component: function component(resolve) {
                return new Promise(function(resolve) { resolve(); }).then(function() { var __WEBPACK_AMD_REQUIRE_ARRAY__ = [__webpack_require__(30)]; (resolve.apply(null, __WEBPACK_AMD_REQUIRE_ARRAY__));}.bind(this)).catch(__webpack_require__.oe);
            }
        }, {
            path: 'crossres',
            name: 'croseeRes',
            component: function component(resolve) {
                return __webpack_require__.e/* require */(0).then(function() { var __WEBPACK_AMD_REQUIRE_ARRAY__ = [__webpack_require__(109)]; (resolve.apply(null, __WEBPACK_AMD_REQUIRE_ARRAY__));}.bind(this)).catch(__webpack_require__.oe);
            }
        }]
    }]
}));

/***/ }),

/***/ 34:
/***/ (function(module, exports) {

// removed by extract-text-webpack-plugin

/***/ }),

/***/ 35:
/***/ (function(module, exports, __webpack_require__) {

function injectStyle (ssrContext) {
  __webpack_require__(97)
}
var Component = __webpack_require__(8)(
  /* script */
  __webpack_require__(75),
  /* template */
  __webpack_require__(102),
  /* styles */
  injectStyle,
  /* scopeId */
  null,
  /* moduleIdentifier (server only) */
  null
)

module.exports = Component.exports


/***/ }),

/***/ 75:
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
Object.defineProperty(__webpack_exports__, "__esModule", { value: true });
//
//
//
//
//
//

/* harmony default export */ __webpack_exports__["default"] = ({
  name: 'app'
});

/***/ }),

/***/ 76:
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
            data: [],
            isIndeterminate: false,
            checkAll: false
        };
    },

    watch: {
        data: function data() {}
    },
    mounted: function mounted() {
        console.log('treeTable', this);
        this.getData();
    },
    methods: {
        getData: function getData() {
            var _this = this;
            this.$http({
                method: 'post',
                url: '/queryCrossServices.do',
                data: {}
            }).then(function (resp) {
                console.log(_this);

                var results = resp.data;
                var result = [];
                results.map(function (item, index) {
                    // console.log('map',item);
                    var obj = item;
                    obj.nodeList.map(function (childItem, childIndex) {
                        childItem.nodeList = childItem.referenceNodeList;
                    });
                    result.push(obj);
                });
                _this.data = result;
                _this.dealData = result;

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
            // console.log("toggle", e, t);
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
            if (item.nodeList.length === 0) {
                return;
            }
            for (var i = 0, ilength = item.nodeList.lenth; i < ilength; i++) {
                var childItem = item.nodeList[i];
                childItem.checkbox = bool;
                if (childItem.nodeList && childItem.nodeList.length !== 0) {
                    this.setChildCheckBoxStatus(childItem, bool);
                }
            }
        }
    }
});

/***/ }),

/***/ 77:
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
Object.defineProperty(__webpack_exports__, "__esModule", { value: true });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__components_treeTable_vue__ = __webpack_require__(30);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__components_treeTable_vue___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_0__components_treeTable_vue__);
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
    name: "serverBody",
    components: {
        serverTable: __WEBPACK_IMPORTED_MODULE_0__components_treeTable_vue___default.a
    },
    data: function data() {
        return {
            datas: []
        };
    },

    created: function created() {},
    methods: {

        handleSelect: function handleSelect(index) {
            console.log(index);

            this.$router.push(index);
        }
    }

});

/***/ }),

/***/ 78:
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
Object.defineProperty(__webpack_exports__, "__esModule", { value: true });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0_vue__ = __webpack_require__(3);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__App__ = __webpack_require__(35);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__App___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_1__App__);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__router__ = __webpack_require__(32);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3_element_ui__ = __webpack_require__(33);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3_element_ui___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_3_element_ui__);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4_element_ui_lib_theme_default_index_css__ = __webpack_require__(34);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4_element_ui_lib_theme_default_index_css___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_4_element_ui_lib_theme_default_index_css__);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_5_axios__ = __webpack_require__(31);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_5_axios___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_5_axios__);
// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.




__WEBPACK_IMPORTED_MODULE_0_vue__["default"].config.productionTip = false;



__WEBPACK_IMPORTED_MODULE_0_vue__["default"].use(__WEBPACK_IMPORTED_MODULE_3_element_ui___default.a);

// import yzView from './directives'

// Vue.use(yzView)



var $http = __WEBPACK_IMPORTED_MODULE_5_axios___default.a.create({
    baseURL: 'http://localhost:10000/monitor'
});

__WEBPACK_IMPORTED_MODULE_0_vue__["default"].prototype.$http = $http;

/* eslint-disable no-new */
new __WEBPACK_IMPORTED_MODULE_0_vue__["default"]({
    el: '#app',
    router: __WEBPACK_IMPORTED_MODULE_2__router__["a" /* default */],
    template: '<App/>',
    components: { App: __WEBPACK_IMPORTED_MODULE_1__App___default.a }
});

/***/ }),

/***/ 97:
/***/ (function(module, exports) {

// removed by extract-text-webpack-plugin

/***/ }),

/***/ 98:
/***/ (function(module, exports) {

// removed by extract-text-webpack-plugin

/***/ })

},[78]);
//# sourceMappingURL=app.790b60f255e9b1477803.js.map