/*
	主页加载方法
*/
//系统时间显示
setInterval("document.getElementById('nowTime').innerHTML=new Date().toLocaleString()+' 星期'+'日一二三四五六'.charAt(new Date().getDay());",1000);
var setting = {
	data: {
		simpleData: {
			enable: true
		}
	},
	view: {
		selectedMulti: false
	},
	callback: {
		onClick:function(e, id, node){
			var zTree = $.fn.zTree.getZTreeObj("menuTree");
			if(node.isParent) {
				zTree.expandNode();
			} else {
				addTabs(node.name, node.file);
			}
		}
	}
};

var zNodes =[
	{ id:1, pId:0, name:"系统管理", open:true},
	{ id:11, pId:1, name:"数据备份", file:"backup.html"},
	{ id:12, pId:1, name:"权限管理", file:"authority.html"},
	{ id:13, pId:1, name:"角色管理", file:"role.html"},
	{ id:2, pId:0, name:"用户相关", open:true},
	{ id:21, pId:2, name:"用户管理", file:"/back/user/user.html"},
	{ id:22, pId:2, name:"成绩管理", file:"/back/user/score.html"},
    { id:3, pId:0, name:"功能相关", open:true},
    { id:31, pId:3, name:"失物招领", file:"/back/lostgood/lostgood.html"},
    { id:32, pId:3, name:"通讯录", file:"/back/phone/phone.html"},
    { id:33, pId:3, name:"四六级", file:"/back/cet/cet.html"},
    { id:34, pId:3, name:"校园新闻", file:"/back/news/news.html"},
    { id:35, pId:3, name:"用户反馈", file:"/back/idea/idea.html"},
    { id:36, pId:3, name:"图片管理", file:"/back/image/image.html"},
    { id:37, pId:3, name:"校历管理", file:"/back/calendar/calendar.html"},
    { id:38, pId:3, name:"地图点管理", file:"/back/map/point.html"},
    { id:39, pId:3, name:"地图分类管理", file:"/back/map/group.html"},
    { id:40, pId:3, name:"留言板", file:"/back/message/message.html"},
    { id:41, pId:3, name:"文本管理", file:"/back/text/text.html"}
];

$(function() {
	$.fn.zTree.init($("#menuTree"), setting, zNodes);
	var zTree = $.fn.zTree.getZTreeObj("menuTree");
	
	//中间部分tab
	$('#tabs').tabs({  
		border:false,
		fit:true,
		onSelect: function(title, index){
			var treeNode = zTree.getNodeByParam("name", title, null);
			zTree.selectNode(treeNode);
		}
	}); 
	
	$('.index_panel').panel({  
	  width:300,  
	  height:200,  
	  closable:true,
	  minimizable:true,
	  title: 'My Panel'
	});
	
});

//添加一个选项卡面板 
function addTabs(title, url, icon){
	if(!$('#tabs').tabs('exists', title)){
		$('#tabs').tabs('add',{  
			title:title,  
			content:'<iframe src="'+url+'" frameBorder="0" border="0" scrolling="no" style="width: 100%; height: 100%;"/>',  
			closable:true
		});
	} else {
		$('#tabs').tabs('select', title);
	}
}