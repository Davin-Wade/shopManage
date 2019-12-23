
function resetImg(filename) {
    // document.write(alert(filename));
    document.getElementById("pic").value = "upload/" + filename;
    document.getElementById("picImg").src = "upload/" + filename;
    }
