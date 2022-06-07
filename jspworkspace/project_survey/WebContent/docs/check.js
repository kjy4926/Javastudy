/**
 * 
 */
function gameAddCheck(){
	if(document.gameAddForm.name.value==""){
		alert("게임 이름을 입력하세요.")
		document.gameAddForm.name.focus()
		return
	}
	if(document.gameAddForm.type.value==""){
		alert("게임 장르를 입력하세요.")
		document.gameAddForm.type.focus()
		return
	}
	document.gameAddForm.submit()
}
function gameDeleteCheck(){
	if(document.gameDelForm.name.value==""){
		alert("게임 이름을 입력하세요.")
		document.gameDelForm.name.focus()
		return
	}
	document.gameDelForm.submit()
}