(function(e){function t(t){for(var r,o,u=t[0],c=t[1],s=t[2],l=0,f=[];l<u.length;l++)o=u[l],a[o]&&f.push(a[o][0]),a[o]=0;for(r in c)Object.prototype.hasOwnProperty.call(c,r)&&(e[r]=c[r]);d&&d(t);while(f.length)f.shift()();return i.push.apply(i,s||[]),n()}function n(){for(var e,t=0;t<i.length;t++){for(var n=i[t],r=!0,o=1;o<n.length;o++){var u=n[o];0!==a[u]&&(r=!1)}r&&(i.splice(t--,1),e=c(c.s=n[0]))}return e}var r={},o={app:0},a={app:0},i=[];function u(e){return c.p+"js/"+({about:"about"}[e]||e)+"."+{about:"3221099c"}[e]+".js"}function c(t){if(r[t])return r[t].exports;var n=r[t]={i:t,l:!1,exports:{}};return e[t].call(n.exports,n,n.exports,c),n.l=!0,n.exports}c.e=function(e){var t=[],n={about:1};o[e]?t.push(o[e]):0!==o[e]&&n[e]&&t.push(o[e]=new Promise(function(t,n){for(var r="css/"+({about:"about"}[e]||e)+"."+{about:"60b8ba6e"}[e]+".css",o=c.p+r,a=document.getElementsByTagName("link"),i=0;i<a.length;i++){var u=a[i],s=u.getAttribute("data-href")||u.getAttribute("href");if("stylesheet"===u.rel&&(s===r||s===o))return t()}var l=document.getElementsByTagName("style");for(i=0;i<l.length;i++){u=l[i],s=u.getAttribute("data-href");if(s===r||s===o)return t()}var f=document.createElement("link");f.rel="stylesheet",f.type="text/css",f.onload=t,f.onerror=function(t){var r=t&&t.target&&t.target.src||o,a=new Error("Loading CSS chunk "+e+" failed.\n("+r+")");a.request=r,n(a)},f.href=o;var d=document.getElementsByTagName("head")[0];d.appendChild(f)}).then(function(){o[e]=0}));var r=a[e];if(0!==r)if(r)t.push(r[2]);else{var i=new Promise(function(t,n){r=a[e]=[t,n]});t.push(r[2]=i);var s,l=document.getElementsByTagName("head")[0],f=document.createElement("script");f.charset="utf-8",f.timeout=120,c.nc&&f.setAttribute("nonce",c.nc),f.src=u(e),s=function(t){f.onerror=f.onload=null,clearTimeout(d);var n=a[e];if(0!==n){if(n){var r=t&&("load"===t.type?"missing":t.type),o=t&&t.target&&t.target.src,i=new Error("Loading chunk "+e+" failed.\n("+r+": "+o+")");i.type=r,i.request=o,n[1](i)}a[e]=void 0}};var d=setTimeout(function(){s({type:"timeout",target:f})},12e4);f.onerror=f.onload=s,l.appendChild(f)}return Promise.all(t)},c.m=e,c.c=r,c.d=function(e,t,n){c.o(e,t)||Object.defineProperty(e,t,{enumerable:!0,get:n})},c.r=function(e){"undefined"!==typeof Symbol&&Symbol.toStringTag&&Object.defineProperty(e,Symbol.toStringTag,{value:"Module"}),Object.defineProperty(e,"__esModule",{value:!0})},c.t=function(e,t){if(1&t&&(e=c(e)),8&t)return e;if(4&t&&"object"===typeof e&&e&&e.__esModule)return e;var n=Object.create(null);if(c.r(n),Object.defineProperty(n,"default",{enumerable:!0,value:e}),2&t&&"string"!=typeof e)for(var r in e)c.d(n,r,function(t){return e[t]}.bind(null,r));return n},c.n=function(e){var t=e&&e.__esModule?function(){return e["default"]}:function(){return e};return c.d(t,"a",t),t},c.o=function(e,t){return Object.prototype.hasOwnProperty.call(e,t)},c.p="/",c.oe=function(e){throw console.error(e),e};var s=window["webpackJsonp"]=window["webpackJsonp"]||[],l=s.push.bind(s);s.push=t,s=s.slice();for(var f=0;f<s.length;f++)t(s[f]);var d=l;i.push([0,"chunk-vendors"]),n()})({0:function(e,t,n){e.exports=n("56d7")},"56d7":function(e,t,n){"use strict";n.r(t);n("cadf"),n("551c"),n("097d");var r=n("2b0e"),o=function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("div",{attrs:{id:"app"}},[n("router-view")],1)},a=[],i=(n("7c55"),n("2877")),u={},c=Object(i["a"])(u,o,a,!1,null,null,null);c.options.__file="App.vue";var s=c.exports,l=n("8c4f"),f=function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("el-container",{staticClass:"container"},[n("el-aside",{staticClass:"left",attrs:{width:"200px"}},[n("el-menu",{staticStyle:{"overflow-x":"hidden",height:"100%"},attrs:{router:"","default-opened":"8","default-active":e.$route.path,"background-color":"#2f4050","text-color":"#fff","active-text-color":"#ffd04b"},on:{select:e.selectMenu}},e._l(e.nav,function(t,r){return n("el-submenu",{key:"-"+r,attrs:{index:r+""}},[n("template",{slot:"title"},[e._v(e._s(t.title))]),e._l(t.child,function(t,o){return n("el-menu-item-group",{key:r+"--"+o},[n("el-menu-item",{attrs:{index:t.path||r+"-"+o}},[e._v(e._s(t.title||t))])],1)})],2)}))],1),n("div",{staticStyle:{"overflow-x":"hidden",flex:"1","margin-left":"200px"}},[n("el-header",{staticStyle:{background:"#283847"}},[n("div",{staticClass:"title"},[e._v("\n        "+e._s(e.selectPage)+"\n      ")]),n("el-dropdown",{on:{command:e.showEditPswDialog}},[n("i",{staticClass:"el-icon-setting",staticStyle:{"margin-right":"15px",color:"#fff"}}),n("el-dropdown-menu",{attrs:{slot:"dropdown"},slot:"dropdown"},[n("el-dropdown-item",{attrs:{command:"0"}},[n("i",{staticClass:"el-icon-circle-close"}),e._v("退出")])],1)],1),n("span",{staticStyle:{color:"#fff"}},[e._v("你好, "+e._s(e.user.loginName))])],1),n("router-view"),n("el-footer",{staticStyle:{"line-height":"60px","font-size":"12px",color:"#999","box-sizing":"border-box"},attrs:{align:"center"}})],1)],1)},d=[],p=(n("96cf"),n("1da1")),h=n("7c15"),m={name:"index-page",data:function(){return{selectPage:"游戏分包报表",nav:[],user:{}}},mounted:function(){var e=Object(p["a"])(regeneratorRuntime.mark(function e(){var t,n;return regeneratorRuntime.wrap(function(e){while(1)switch(e.prev=e.next){case 0:return e.prev=0,e.next=3,Object(h["f"])();case 3:return t=e.sent,e.next=6,this.$checkData(t.data);case 6:n=e.sent,this.user=n,localStorage.setItem("user",JSON.stringify(n)),"admin"===n.loginName&&this.nav.push({title:"系统管理",child:[{title:"系统用户",path:"/systemAdmin"}]}),this.nav.push({title:"功能列表",child:[{title:"游戏分包报表",path:"/"}]}),e.next=16;break;case 13:e.prev=13,e.t0=e["catch"](0),window.location.href="/login.html";case 16:case"end":return e.stop()}},e,this,[[0,13]])}));return function(){return e.apply(this,arguments)}}(),methods:{selectMenu:function(e){var t=this;this.nav.some(function(n){return n.child.some(function(n){if(n.path===e)return t.selectPage=n.title,!0})})},showEditPswDialog:function(){var e=Object(p["a"])(regeneratorRuntime.mark(function e(t){return regeneratorRuntime.wrap(function(e){while(1)switch(e.prev=e.next){case 0:if(e.prev=0,"0"!==t){e.next=7;break}return e.next=4,Object(h["a"])();case 4:window.location.href="/login.html",e.next=8;break;case 7:case 8:e.next=13;break;case 10:e.prev=10,e.t0=e["catch"](0),console.log(e.t0);case 13:case"end":return e.stop()}},e,this,[[0,10]])}));return function(t){return e.apply(this,arguments)}}()}},g=m,v=(n("5a8a"),Object(i["a"])(g,f,d,!1,null,"280d2bf2",null));v.options.__file="index.vue";var b=v.exports;r["default"].use(l["a"]);var w=new l["a"]({routes:[{path:"/",component:b,children:[{path:"/",name:"profit-page",component:function(){return n.e("about").then(n.bind(null,"0f14"))}},{path:"/systemAdmin",name:"systemAdmin-page",component:function(){return n.e("about").then(n.bind(null,"0d4f"))}}]}]}),y=n("2f62");r["default"].use(y["a"]);var x=new y["a"].Store({state:{},mutations:{},actions:{}}),_=n("5c96"),O=n.n(_),S=(n("0fae"),n("bc3a")),k=n.n(S);n("8ba1"),n("7f7f"),n("ac6a");function j(e){var t=this;return new Promise(function(n,r){e.ErrorMsg?(t.$message({showClose:!0,message:e.ErrorMsg,type:"error"}),r(e.ErrorMsg)):n(e)})}r["default"].use(O.a),r["default"].prototype.$http=k.a,r["default"].prototype.$checkData=j,r["default"].config.productionTip=!1,new r["default"]({router:w,store:x,render:function(e){return e(s)}}).$mount("#app")},"5a8a":function(e,t,n){"use strict";var r=n("7d6d"),o=n.n(r);o.a},"5c48":function(e,t,n){},"7c15":function(e,t,n){"use strict";n.d(t,"d",function(){return c}),n.d(t,"f",function(){return s}),n.d(t,"a",function(){return l}),n.d(t,"i",function(){return f}),n.d(t,"c",function(){return d}),n.d(t,"b",function(){return p}),n.d(t,"e",function(){return h}),n.d(t,"g",function(){return m}),n.d(t,"h",function(){return g});n("96cf");var r=n("1da1"),o=n("be94"),a=n("bc3a"),i=n.n(a),u={transformRequest:[function(e){var t="";for(var n in e)t+=encodeURIComponent(n)+"="+encodeURIComponent(e[n])+"&";return t}],headers:{"Content-Type":"application/x-www-form-urlencoded"}};function c(){var e=arguments.length>0&&void 0!==arguments[0]?arguments[0]:null,t=arguments.length>1&&void 0!==arguments[1]?arguments[1]:null;window.open("subcontract/exportListGameSub.do?start=".concat(e,"&end=").concat(t))}function s(){return i.a.get("getUser.do")}function l(){return i.a.get("logout.do")}function f(e,t){return i.a.get("user/findPage.do?page=".concat(e,"&rows=").concat(t))}function d(e){return i()(Object(o["a"])({method:"POST",url:"user/saveUser.do",data:e},u))}function p(e,t){return i()(Object(o["a"])({method:"POST"},u,{url:"/user/addChannelId.do",data:{id:e,channelId:t}}))}function h(e,t){return i()({method:"get",url:"subcontract/findPage.do",params:{page:e,rows:t}})}function m(e,t,n,r){return i()({method:"get",url:"subcontract/findSearch.do",params:{page:e,rows:t,start:n,end:r}})}function g(e){return v.apply(this,arguments)}function v(){return v=Object(r["a"])(regeneratorRuntime.mark(function e(t){var n,r,o;return regeneratorRuntime.wrap(function(e){while(1)switch(e.prev=e.next){case 0:return n=t.file,r=new FormData,r.append("filename",n),o={headers:{"Content-Type":"multipart/form-data"}},e.abrupt("return",i.a.post("subcontract/importSubContract.do",r,o));case 5:case"end":return e.stop()}},e,this)})),v.apply(this,arguments)}},"7c55":function(e,t,n){"use strict";var r=n("5c48"),o=n.n(r);o.a},"7d6d":function(e,t,n){},"8ba1":function(e,t,n){}});
//# sourceMappingURL=app.0e018284.js.map