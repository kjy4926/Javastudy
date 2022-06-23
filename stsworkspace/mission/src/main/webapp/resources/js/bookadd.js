function getContextPath() {
    var hostIndex = location.href.indexOf( location.host ) + location.host.length;
    return location.href.substring( hostIndex, location.href.indexOf('/', hostIndex + 1) );
}
function setImage(input){
    var file = input.files[0]

    var img = document.getElementById("image")
    img.src = URL.createObjectURL(file)
    img.style.visibility = 'visible'

    return file
}
function fileTransfer(form){
    var file = setImage(form.img)
    var contextPath = getContextPath()
    var formData = new FormData()
    formData.append("file", file)
    $.ajax({
        url: `${contextPath}/add/imageUpload`,
        method: "POST",
        processData : false,
        contentType : false,
        data : formData,
        dataType: 'json',
        success : function(result){
            alert("upload")
        }
    });
}