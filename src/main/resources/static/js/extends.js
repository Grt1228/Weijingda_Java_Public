/*
	扩展easyui中的控件方法或修改其默认属性
 */
 
//翻页工具栏文字
if ($.fn.pagination){
	$.fn.pagination.defaults.showPageList=false;
	$.fn.pagination.defaults.beforePageText="第 <span id='currentPage'>1</span> 页  转到",
	$.fn.pagination.defaults.afterPageText = "页&nbsp; <a style='border:0;text-decoration:none; font-size:15px;font-weight:bold;color:#8DB2E3' href='javascript:void(0);' onclick='jumpPage()'>GO</a>&nbsp; 共 {pages} 页";
	$.fn.pagination.defaults.displayMsg ="当前{from}-{to} 条  共{total}条记录";
}

//分页控件上的点击"GO"实现 页面跳转方法
function jumpPage(){
  //设置键盘事件 并将其设置为按下回车
   var e=$.Event("keydown");
   e.keyCode=13;
   $("input.pagination-num:visible").trigger(e);//模拟页码框按下回车
}

if ($.fn.datagrid){
	$.fn.datagrid.defaults.loadMsg = '正在加载...';
}

//window窗体默认属性
$.fn.window.defaults.resizable=false;
$.fn.window.defaults.collapsible=false;
$.fn.window.defaults.minimizable=false;
$.fn.window.defaults.maximizable=false;
$.fn.window.defaults.shadow=false;
$.fn.window.defaults.modal=true;
$.fn.window.defaults.loadingMessage = '正在加载...';

//信息框按钮文字
if ($.messager){
	$.messager.defaults.ok = '确定';
	$.messager.defaults.cancel = '取消';
}


function goLogin(data) {
	if(data.status=="10"){
        $.messager.alert('提示','登陆过期，重新登陆!','warning',function(r){
            if (r){
                window.location.href="/login.html";
            }
        });
	}
}