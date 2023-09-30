<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Register</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.min.js" integrity="sha384-Rx+T1VzGupg4BHQYs2gCW9It+akI2MM/mndMCy36UVfodzcJcF0GGLxZIzObiEfa" crossorigin="anonymous"></script>

<style type="text/css">
	.red{
	color: red;
	}
	</style>
</head>


<body>

	<jsp:include page="../header.jsp"></jsp:include>
<%

	String vl_hoVaTen = request.getAttribute("vl_hoVaTen")+"";
	String vl_gioiTinh = request.getAttribute("vl_gioiTinh")+"";
	String vl_ngaySinh = request.getAttribute("vl_ngaySinh")+"";
	String vl_diaChi = request.getAttribute("vl_diaChi")+"";
	String vl_diaChiNhanHang = request.getAttribute("vl_diaChiNhanHang")+"";
	String vl_diaChiGhiHoaDon = request.getAttribute("vl_diaChiGhiHoaDon")+"";
	String vl_soDienThoai = request.getAttribute("vl_soDienThoai")+"";
	String vl_email = request.getAttribute("vl_email")+"";
	String vl_dongYNhanMail = request.getAttribute("vl_dongYNhanMail")+"";
	
	vl_hoVaTen = (vl_hoVaTen.equals("null"))?"":vl_hoVaTen; 
	vl_gioiTinh = (vl_gioiTinh.equals("null"))?"":vl_gioiTinh;
	vl_ngaySinh = (vl_hoVaTen.equals("null"))?"":vl_ngaySinh;
	vl_diaChi = (vl_diaChi.equals("null"))?"":vl_diaChi;
	vl_diaChiNhanHang = (vl_diaChiNhanHang.equals("null"))?"":vl_diaChiNhanHang;
	vl_diaChiGhiHoaDon = (vl_diaChiGhiHoaDon.equals("null"))?"":vl_diaChiGhiHoaDon;
	vl_soDienThoai = (vl_soDienThoai.equals("null"))?"":vl_soDienThoai;
	vl_email = (vl_email.equals("null"))?"":vl_email;
	vl_dongYNhanMail = (vl_dongYNhanMail.equals("null"))?"":vl_dongYNhanMail;
	
	String err_TDN = request.getAttribute("err_TDN")+"";
	String err_MK = request.getAttribute("err_MK")+"";
	String err_sdt = request.getAttribute("err_sdt")+"";
	String err_email = request.getAttribute("err_email")+"";
	//show lỗi
	err_TDN = (err_TDN.equals("null"))?"":err_TDN;
	err_MK = (err_MK.equals("null"))?"":err_MK;
	err_sdt = (err_sdt.equals("null"))?"":err_sdt;
	err_email = (err_email.equals("null"))?"":err_email;
%>


<div class="container">
<div class="text-center d-flex justify-content-center align-items-center ">
	<img alt="" src="../../img/logo.jpg" width="100px" class="me-5">
	<h1>ĐĂNG KÝ TÀI KHOẢN</h1>
	  
</div>

	
	<form action="khach-hang" method="post">	
		<input type="hidden" name="action" value="register">
	<div class="row">
		<div class="col-lg-6">
		<div class="text-center"><h1>TÀI KHOẢN</h1></div>
		
		<div class="mb-3">
 	 	<label for="tenDangNhap" class="form-label">Tên đăng nhập:</label> 
	 	 	<span class = "red">*</span>
	 	 	<span class="red" id="err_TDN"><%=err_TDN %></span>
  		<input type="text" class="form-control" id="tenDangNhap" name="tenDangNhap" required="required" >
	</div>
	
	 <div class="mb-3">
 	 	<label for="matKhau" class="form-label">Mật khẩu:</label> 
	 	 	<span class = "red">*</span>
	 	 	<span class="red" id="err_TDN"><%=err_MK %></span>
  		<input type="password" class="form-control" id="matKhau" name="matKhau" placeholder="Nhập mật khẩu" required="required" >
	</div>
	<div class="mb-3">
 	 	<label for="nhapLaiMatKhau" class="form-label">Nhập lại mật khẩu:</label> 
 	 	<span class = "red">*</span>
 	 	<span id = "err_nhapLaiMatKhau" class="red"></span>
  		<input type="password" class="form-control" id="nhapLaiMatKhau" name="nhapLaiMatKhau" placeholder="Nhập lại mật khẩu" required="required" >
	</div>
	
	<div class="text-center"><h1>THÔNG TIN KHÁCH HÀNG</h1></div>
	
	 <div class="mb-3">
 	 	<label for="hoVaTen" class="form-label">Họ và tên:</label> <span class = "red">*</span>
  		<input type="text" class="form-control" id="hoVaTen" name="hoVaTen" placeholder="Nhập họ và tên" required="required" value=<%=vl_hoVaTen %>>
	</div>
	
	<div class="mb-3">
  		<label for="gioiTinh" class="form-label">Giới tính:</label>
	  	<select class="form-control" id="gioiTinh" name="gioiTinh" required="required" >
	  		<option>Chọn giới tính</option>
	  		<option value="Nam" <%=(vl_gioiTinh.equals("Nam")?"selected='selected'":"") %> >Nam</option>
	  		<option value="Nữ" <%=(vl_gioiTinh.equals("Nữ")?"selected='selected'":"") %> >Nữ</option>
	  		<option value="Khác" <%=(vl_gioiTinh.equals("Khác")?"selected='selected'":"") %> >Khác</option>
	  	</select>
	  	<div class="mb-3">
 	 	<label for="ngaySinh" class="form-label">Ngày sinh:</label> <span class = "red">*</span>
  		<input type="date" class="form-control" id="ngaySinh" name="ngaySinh" placeholder="Nhập ngày sinh" required="required" value=<%=vl_ngaySinh %>>
		</div>
	</div>
	
		</div>
	<div class="col-lg-6">
	
	<div class="text-center"><h1>ĐỊA CHỈ</h1></div>

	 <div class="mb-3">
 	 	<label for="diaChi" class="form-label">Địa chỉ:</label> <span class = "red">*</span>
  		<input type="text" class="form-control" id="diaChi" name="diaChi" placeholder="Nhập địa chỉ" required="required" value=<%=vl_diaChi %>>
	</div>
	
	 <div class="mb-3">
 	 	<label for="diaChiNhanHang" class="form-label">Địa chỉ nhận hàng:</label> <span class = "red">*</span>
  		<input type="text" class="form-control" id="diaChiNhanHang" name="diaChiNhanHang" placeholder="Nhập địa chỉ nhận hàng" required="required" value=<%=vl_diaChiNhanHang %>>
	</div>
	
	<div class="mb-3">
 	 	<label for="diaChiGhiHoaDon" class="form-label">Địa chỉ ghi hóa đơn:</label> <span class = "red">*</span>
  		<input type="text" class="form-control" id="diaChiGhiHoaDon" name="diaChiGhiHoaDon" placeholder="Nhập địa chỉ ghi hóa đơn" required="required" value=<%=vl_diaChiGhiHoaDon %>>
	</div>
	
	<div class="mb-3">
 	 	<label for="soDienThoai" class="form-label">Số điện thoại:</label>
 	 	 	<span class = "red">*</span>
 	 		<span class="red" id="err_TDN"><%=err_sdt %></span>
  		<input type="number" class="form-control" id="soDienThoai" name="soDienThoai" placeholder="Nhập số điện thoại" required="required" value=<%=vl_soDienThoai %>>
	</div>
	
	<div class="mb-3">
 	 	<label for="email" class="form-label">Email:</label>
 	 		<span class = "red">*</span>
 	 		<span class="red" id="err_TDN"><%=err_email %></span>
  		<input type="email" class="form-control" id="email" name="email" placeholder="Nhập Email" required="required" value=<%=vl_email %>>
	</div>
	
	<div class="mb-3">
 	 	<label for="dongYDieuKhoan" class="form-label">Đồng ý <a>với điều khoản</a> </label> <span class = "red">*</span>
  		<input type="checkbox" class="form-check-input" id="dongYDieuKhoan" name="dongYDieuKhoan" required="required">
	</div>
	
	<div class="mb-3">
 	 	<label for="dongYNhanMail" class="form-label">Đồng ý nhận email </label> 
  		<input type="checkbox" class="form-check-input" id="dongYNhanMail" name="dongYNhanMail" <%=(vl_dongYNhanMail.equals("on")?"checked":"unchecked") %> >
	</div>
	
	</div>
	</div>	
	 
	
	
	<input type="submit" id="submit" class="btn btn-primary form-control" value="Đăng Ký" style="visibility: hidden;">
	
	 <a class="btn btn-success form-control mt-3" href="login.jsp" >
        	Đăng nhập tài khoản đã có 
        </a>
	</form>
	</div>
	
	<%@include file="../footer.jsp" %>
</body>
<script src="../../javascript/register.js"></script>

</html>