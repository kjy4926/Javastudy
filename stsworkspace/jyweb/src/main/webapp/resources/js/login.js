/**
login.js
 */
function getContextPath() {
    var hostIndex = location.href.indexOf( location.host ) + location.host.length;
    return location.href.substring( hostIndex, location.href.indexOf('/', hostIndex + 1) );
}
function login(_form){
	var id = _form.id.value
	var pwd = _form.pwd.value
	$.ajax({
		url:`${getContextPath()}/login/login.do`,
		type:"POST",
		data:{id: id,
			pwd: pwd},
		success: function(result){
			console.log(result)
			if(result == "true"){
				return true
			}else{
				alert("비밀번호 틀렸어요.")
				return false
			}
		}
	});
	return false
}