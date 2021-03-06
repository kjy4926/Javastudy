function getContextPath() {
    var hostIndex = location.href.indexOf( location.host ) + location.host.length;
    return location.href.substring( hostIndex, location.href.indexOf('/', hostIndex + 1) );
}

function idDuplicateCheck(_form){
	// 영문으로 시작하는 8~16자
	var regex  = /^[a-z][a-z0-9]{7,15}$/g
	var iv = document.getElementById('idResultInValid')
	var v = document.getElementById('idResultValid')
	// regex check
	if(!regex.test(_form.id.value)){
		if(_form.id.value.length==0){
			_form.id.className = 'form-control';
		}else{
			_form.id.className = 'form-control is-invalid';
		}
		iv.innerText = 'ID is invalid.'
		_form.dupck.value = 0 // 중복 체크 미실시
	}else{
		_form.id.className = 'form-control is-valid';
		v.innerText = 'ID is valid'
		_form.dupck.value = 0
	}
}
// 회원가입 입력 정보 검사
function pwdCheck(_form){
	var result = true;
	if(_form.pwd.value != _form.pwdck.value) result = false;
	return result;
}
// 회원가입
function dupCheck(_form){
	var iv = document.getElementById('idResultInValid')
	var v = document.getElementById('idResultValid')
	$.ajax({
		url:`${getContextPath()}/idcheck`,
		type:"POST",
		data:{userId: _form.id.value},
		success: function(result){
			if(result == 0){
				_form.dupck.value = 0 // 중복
				_form.id.className = 'form-control is-invalid';
				iv.innerText = 'Sorry, that username has been used.'
			}else{
				_form.dupck.value = 1 // 중복x
				_form.id.className = 'form-control is-valid';
				v.innerText = 'ID is available'
			}
		}
	});
}
function signUp(_form){
	var check = pwdCheck(_form)
	var dupcheck = _form.dupck.value==0 ? false : true
	if(check && dupcheck){
		return true
	}else{
		if(!check) alert("Password and password check input values are different.")
		else if(!dupcheck) alert("Please do a duplicate ID check.")
		return false
	}
}