(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["about"],{"0430":function(e,t,a){"use strict";var n=a("61de"),r=a.n(n);r.a},"0d4f":function(e,t,a){"use strict";a.r(t);var n=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("el-tabs",{staticClass:"content",attrs:{type:"border-card",value:"Features"}},[a("el-tab-pane",{attrs:{label:"功能选择",name:"Features"}},[a("el-row",[a("el-button",{attrs:{type:"success"},on:{click:function(t){return t.stopPropagation(),e.newUser(t)}}},[e._v("新增")])],1),a("el-table",{staticClass:"dataTable",attrs:{data:e.featuresInfo.data,border:!0}},[a("el-table-column",{attrs:{width:"150",align:"center",prop:"channelId",label:"渠道号"}}),a("el-table-column",{attrs:{width:"150",align:"center",prop:"userName",label:"账号"}}),a("el-table-column",{attrs:{width:"150",align:"center",prop:"channelName",label:"渠道名称"}}),a("el-table-column",{attrs:{width:"200",align:"center",prop:"date",label:"日期"}}),a("el-table-column",{attrs:{width:"150",align:"center",prop:"operate",label:"操作选项"},scopedSlots:e._u([{key:"default",fn:function(t){return[a("el-button",{attrs:{size:"mini",type:"success"},on:{click:function(a){e.addChannelId(t.$index)}}},[e._v("新增渠道号")])]}}])})],1),a("el-pagination",{staticClass:"pagination",attrs:{"current-page":e.featuresInfo.current_page,"page-sizes":[10,20],"page-size":e.featuresInfo.page_size,layout:"total, sizes, prev, pager, next, jumper",total:e.featuresInfo.table_total},on:{"size-change":e.featuresSizeChange,"current-change":e.featuresCurrentChange}})],1),a("el-dialog",{staticClass:"newUserDialog",attrs:{center:"",width:"600px",title:"添加管理员",visible:e.newUserDialog},on:{"update:visible":function(t){e.newUserDialog=t}}},[a("el-row",{staticStyle:{"margin-top":"10px"},attrs:{type:"flex",align:"middle",justify:"center"}},[a("el-col",{attrs:{offset:3,span:3}},[e._v("账号")]),a("el-col",{attrs:{span:12}},[a("el-input",{staticClass:"newUserInput",attrs:{placeholder:"请输入内容"},on:{blur:function(t){e.checkUserName(e.newUserInfo.userName)}},model:{value:e.newUserInfo.userName,callback:function(t){e.$set(e.newUserInfo,"userName",t)},expression:"newUserInfo.userName"}})],1)],1),a("el-row",{staticStyle:{"margin-top":"10px"},attrs:{type:"flex",align:"middle",justify:"center"}},[a("el-col",{attrs:{offset:3,span:3}},[e._v("密码")]),a("el-col",{attrs:{span:12}},[a("el-input",{staticClass:"newUserInput",attrs:{placeholder:"请输入内容",type:"password"},model:{value:e.newUserInfo.pwd,callback:function(t){e.$set(e.newUserInfo,"pwd",t)},expression:"newUserInfo.pwd"}})],1)],1),a("el-row",{staticStyle:{"margin-top":"10px"},attrs:{type:"flex",align:"middle",justify:"center"}},[a("el-col",{attrs:{offset:3,span:3}},[e._v("渠道名称")]),a("el-col",{attrs:{span:12}},[a("el-input",{staticClass:"newUserInput",attrs:{placeholder:"请输入内容"},model:{value:e.newUserInfo.channelName,callback:function(t){e.$set(e.newUserInfo,"channelName",t)},expression:"newUserInfo.channelName"}})],1)],1),a("el-row",{staticStyle:{"margin-top":"10px"},attrs:{type:"flex",align:"middle",justify:"center"}},[a("el-col",{attrs:{offset:3,span:3}},[e._v("渠道号")]),a("el-col",{attrs:{span:12}},[a("el-input",{staticClass:"newUserInput",attrs:{placeholder:"请输入内容"},model:{value:e.newUserInfo.channelId,callback:function(t){e.$set(e.newUserInfo,"channelId",t)},expression:"newUserInfo.channelId"}})],1)],1),a("div",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[a("el-button",{on:{click:e.clearNewUser}},[e._v("清 空")]),a("el-button",{attrs:{type:"primary"},on:{click:e.addNewUser}},[e._v("确 定")])],1)],1)],1)},r=[],s=(a("ac6a"),a("96cf"),a("1da1")),l=(a("cadf"),a("551c"),a("097d"),a("7c15")),c={name:"admin-system",data:function(){return{newUserDialog:!1,featuresInfo:{data:[],page_size:10,current_page:1,table_total:0},newUserInfo:{userName:"",pwd:"",channelName:"",channelId:""}}},mounted:function(){this.loadFeaturesData()},methods:{addChannelId:function(){var e=Object(s["a"])(regeneratorRuntime.mark(function e(t){var a,n,r,s;return regeneratorRuntime.wrap(function(e){while(1)switch(e.prev=e.next){case 0:return a=this.featuresInfo.data[t],e.prev=1,e.next=4,this.$prompt("请输入渠道ID","新增",{confirmButtonText:"确定",cancelButtonText:"取消"});case 4:return n=e.sent,r=n.value,e.next=8,Object(l["b"])(a.pid,r);case 8:return s=e.sent,e.next=11,this.$checkData(s.data);case 11:this.loadFeaturesData(),e.next=16;break;case 14:e.prev=14,e.t0=e["catch"](1);case 16:case"end":return e.stop()}},e,this,[[1,14]])}));return function(t){return e.apply(this,arguments)}}(),addNewUser:function(){var e=Object(s["a"])(regeneratorRuntime.mark(function e(){var t;return regeneratorRuntime.wrap(function(e){while(1)switch(e.prev=e.next){case 0:return e.prev=0,e.next=3,Object(l["c"])({loginName:this.newUserInfo.userName,password:this.newUserInfo.pwd,channelName:this.newUserInfo.channelName,channelId:this.newUserInfo.channelId});case 3:return t=e.sent,e.next=6,this.$checkData(t.data);case 6:this.$message({showClose:!0,message:"添加成功",type:"success"}),this.newUserDialog=!1,this.clearNewUser(),this.loadFeaturesData(),e.next=15;break;case 12:e.prev=12,e.t0=e["catch"](0),console.log(e.t0);case 15:case"end":return e.stop()}},e,this,[[0,12]])}));return function(){return e.apply(this,arguments)}}(),clearNewUser:function(){this.newUserInfo.userName="",this.newUserInfo.pwd="",this.newUserInfo.channelName="",this.newUserInfo.channelId=""},loadFeaturesData:function(){var e=Object(s["a"])(regeneratorRuntime.mark(function e(){var t,a,n=this;return regeneratorRuntime.wrap(function(e){while(1)switch(e.prev=e.next){case 0:return e.prev=0,e.next=3,Object(l["i"])(this.featuresInfo.current_page,this.featuresInfo.page_size);case 3:return t=e.sent,e.next=6,this.$checkData(t.data);case 6:a=e.sent,this.featuresInfo.table_total=a.total,this.featuresInfo.data=[],a.rows.forEach(function(e){n.featuresInfo.data.push({userName:e.loginName,channelName:e.channelName,channelId:e.channelId,date:e.createTime,pid:e.id})}),e.next=15;break;case 12:e.prev=12,e.t0=e["catch"](0),console.log(e.t0);case 15:case"end":return e.stop()}},e,this,[[0,12]])}));return function(){return e.apply(this,arguments)}}(),featuresCurrentChange:function(e){this.featuresInfo.current_page=e,this.loadFeaturesData()},featuresSizeChange:function(e){this.featuresInfo.page_size=e,this.loadFeaturesData()},newUser:function(){this.newUserDialog=!0}}},i=c,o=(a("0430"),a("2877")),u=Object(o["a"])(i,n,r,!1,null,"4b3e8cc0",null);u.options.__file="index.vue";t["default"]=u.exports},"0f14":function(e,t,a){"use strict";a.r(t);var n=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",{staticClass:"profit-page"},[a("div",{staticClass:"top"},[a("el-date-picker",{staticClass:"top-item",attrs:{format:"yyyy 年 MM 月 dd 日","value-format":"yyyy-MM-dd",type:"daterange","range-separator":"至","start-placeholder":"开始日期","end-placeholder":"结束日期"},model:{value:e.time,callback:function(t){e.time=t},expression:"time"}}),a("el-button",{staticClass:"top-item",on:{click:e.searchTableData}},[e._v("查询")]),a("el-button",{staticClass:"top-item",attrs:{type:"success"},on:{click:e.exportTableData}},[e._v("导出")]),a("el-button",{directives:[{name:"show",rawName:"v-show",value:e.showImportBtn,expression:"showImportBtn"}],staticClass:"top-item",attrs:{type:"primary"}},[a("input",{ref:"chooseFile",staticClass:"chooseFile",attrs:{type:"file"}}),e._v("\n      导入\n    ")])],1),a("el-table",{staticStyle:{width:"100%"},attrs:{data:e.tableData.data,border:""}},[a("el-table-column",{attrs:{align:"center",prop:"channelId",label:"渠道号",width:"180"}}),a("el-table-column",{attrs:{align:"center",prop:"endMoney",width:"180",label:"结算款"}}),a("el-table-column",{attrs:{align:"center",prop:"news",width:"180",label:"新增"}}),a("el-table-column",{attrs:{align:"center",prop:"info",width:"180",label:"信息费"}}),a("el-table-column",{attrs:{align:"center",prop:"date",width:"180",label:"日期"}})],1),a("el-pagination",{staticClass:"pagination",attrs:{"current-page":e.tableData.current_page,"page-sizes":[10,20],"page-size":e.tableData.page_size,layout:"total, sizes, prev, pager, next, jumper",total:e.tableData.total},on:{"size-change":e.tableDataSizeChange,"current-change":e.tableDataCurrentChange}})],1)},r=[],s=(a("ac6a"),a("96cf"),a("1da1")),l=(a("cadf"),a("551c"),a("097d"),a("7c15")),c={name:"profit-page",data:function(){return{time:"",tableData:{data:[],page_size:10,current_page:1,total:0},showImportBtn:!1}},mounted:function(){var e=this,t=JSON.parse(localStorage.getItem("user"));this.showImportBtn="admin"===t.loginName,this.loadTableData(),this.$refs.chooseFile.onchange=function(){var t=Object(s["a"])(regeneratorRuntime.mark(function t(a){var n;return regeneratorRuntime.wrap(function(t){while(1)switch(t.prev=t.next){case 0:return t.prev=0,t.next=3,Object(l["h"])({file:a.target.files[0]});case 3:return n=t.sent,t.next=6,e.$checkData(n.data);case 6:t.next=11;break;case 8:t.prev=8,t.t0=t["catch"](0),console.log(t.t0);case 11:case"end":return t.stop()}},t,this,[[0,8]])}));return function(e){return t.apply(this,arguments)}}()},methods:{exportTableData:function(){Object(l["d"])()},loadTableData:function(){var e=Object(s["a"])(regeneratorRuntime.mark(function e(){var t,a;return regeneratorRuntime.wrap(function(e){while(1)switch(e.prev=e.next){case 0:return e.prev=0,e.next=3,Object(l["e"])(this.tableData.current_page,this.tableData.page_size);case 3:return t=e.sent,e.next=6,this.$checkData(t.data);case 6:a=e.sent,console.log(t,a),this.updateTableData(a),e.next=14;break;case 11:e.prev=11,e.t0=e["catch"](0),console.log(e.t0);case 14:case"end":return e.stop()}},e,this,[[0,11]])}));return function(){return e.apply(this,arguments)}}(),searchTableData:function(){var e=Object(s["a"])(regeneratorRuntime.mark(function e(){var t,a;return regeneratorRuntime.wrap(function(e){while(1)switch(e.prev=e.next){case 0:return e.next=2,Object(l["g"])(this.tableData.current_page,this.tableData.page_size,this.time[0],this.time[1]);case 2:return t=e.sent,e.next=5,this.$checkData(t.data);case 5:a=e.sent,this.updateTableData(a);case 7:case"end":return e.stop()}},e,this)}));return function(){return e.apply(this,arguments)}}(),updateTableData:function(e){var t=this;this.tableData.data=[],this.tableData.total=e.total,e.rows.forEach(function(e){t.tableData.data.push({date:e.recordTime,endMoney:e.accountcleark,info:e.messageFee,news:e.newAdd,channelId:e.channelId})})},tableDataCurrentChange:function(e){this.tableData.current_page=e,this.loadTableData()},tableDataSizeChange:function(e){this.tableData.page_size=e,this.loadTableData()}}},i=c,o=(a("2ca6"),a("2877")),u=Object(o["a"])(i,n,r,!1,null,"17e4b39c",null);u.options.__file="index.vue";t["default"]=u.exports},"2ca6":function(e,t,a){"use strict";var n=a("aebf"),r=a.n(n);r.a},"61de":function(e,t,a){},aebf:function(e,t,a){}}]);
//# sourceMappingURL=about.3221099c.js.map