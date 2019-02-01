//封装一个代替getElementById的方法
function byId(id) {
	// body...
	return typeof(id)==="string"?document.getElementById(id):id;
}
var index=0,
timer=null,
pics=byId("banner").getElementsByTagName("div"),
dots=byId("dots").getElementsByTagName("span"),
prev=byId("prev"),
next=byId("next"), 
len=pics.length,
subMenu=byId("sub-menu"),
menu=byId("menu-content");
innerBox=subMenu.getElementsByClassName("inner-box"),
menuItems = byId("menu-content").getElementsByTagName("div");


function slideImg(){
	var main=byId("main");
	//划过清除定时器，离开继续
	main.onmouseover=function(){
		//划过清除定时器
		if (timer) clearInterval();
	}
	main.onmouseout=function(){
		timer=setInterval(function(){
			index++;
			if(index>=len){
				index=0;
			}
			//切换图片
			changeImg();
		},3000);

	}
	//自动在main上触发鼠标离开事件
	main.onmouseout();

	//遍历所有点击，且绑定点击事件，点击圆点切换图片
	for (var d=0;d<len;d++) {
		//给所有span添加一个id的属性，值为d，作为当前span的索引
		dots[d].id=d;
		dots[d].onclick=function(){
		 	//改变index为当前span的索引
		 	index=this.id;
		 	//调用changeImg，实现切换图片
		 	changeImg();
		 }
	}
	//点击下一张
	next.onclick=function(){
		index++;
		if(index>=len) index=0;
		changeImg();
	}
	//上一张
	prev.onclick=function(){
		index--;
		if(index<0) index=len-1;
		changeImg();
	}
	//导航菜单
	//遍历主菜单，且绑定时间
	for (var m=0; m<menuItems.length; m++) {
		menuItems[m].setAttribute("data-index",m);
		menuItems[m].onmouseover=function(){
			subMenu.className='sub-menu';
			var idx=this.getAttribute("data-index");
			//遍历所有子菜单，将每一个都隐藏
			for(var j=0;j<innerBox.length;j++){
				innerBox[j].style.display="none";
				menuItems[j].style.background="none";
			}
			menuItems[idx].style.background='rgba(0,0,0,0.1)';
			innerBox[idx].style.display='block';
			}
	}
	menu.onmouseout=function(){
		subMenu.className="sub-menu hide";
	}
	subMenu.onmouseover=function(){
		this.className-"sub-menu";
	}
	subMenu.onmouseout=function(){
		subMenu.className="sub-menu hide";
	}
}



//切换图片
function changeImg(){
	//不管元素上有没有类，className属性设置的类会重写元素上的类
	//遍历banner下所有的div及dots下所有的span，将其隐藏
	 for(var i=0;i<len;i++){
    	pics[i].style.display= "none";
    	dots[i].className="";
   }
	//根据index找到当前div和当前span，将其当前显示出来和设为当前
	pics[index].style.display="block";
	dots[index].className="active";
}
slideImg();