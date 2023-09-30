var matKhauElm = document.getElementById("matKhau");
var matKhauNhapLaiElm = document.getElementById("nhapLaiMatKhau");
 matKhauNhapLaiElm.onkeyup= function(){
	
	err_nhapLaiMatKhau = document.getElementById("err_nhapLaiMatKhau"); 
	if(matKhauElm.value != matKhauNhapLaiElm.value){;
		err_nhapLaiMatKhau.innerHTML = "Mật khẩu nhập lại không đúng";
		
	}else {
		err_nhapLaiMatKhau.innerHTML = "";
	}
}

var elmKtdy = document.getElementById("dongYDieuKhoan");
var elmSubmit = document.getElementById("submit");
elmKtdy.onclick=function(){
	if(elmKtdy.checked == true){
		elmSubmit.style.visibility="visible";
	}else elmSubmit.style.visibility="hidden";
	
}
