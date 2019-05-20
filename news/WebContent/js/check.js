function $(){
	return document.getElentmentById(id);
}
function checkAll(){
	var name=$("name1");
	var mess=$("mess");
	if(name==""){
		mess.innerHTML="用户不能为空";
		return false;
	}
}