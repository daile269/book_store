<%@page import="model.KhachHang"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ChangeInformation</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.min.js" integrity="sha384-Rx+T1VzGupg4BHQYs2gCW9It+akI2MM/mndMCy36UVfodzcJcF0GGLxZIzObiEfa" crossorigin="anonymous"></script>
<link rel="stylesheet" href="../../css/changeInformation.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css">

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
		
		String success = request.getAttribute("success")+"";
		success = (success.equals("null"))?"":success;
		
		
	
	KhachHang khachHang = (KhachHang) session.getAttribute("khachHang");
	if(khachHang==null){
	
%>
	
	<h1>Bạn chưa đăng nhập vào hệ thống hãy quay lại trang chủ</h1>
	<a href="../index.jsp">Quay lại trang chủ</a>
	<%}else{ %>
	
<div class="container">
  <form class="text-center" action="khach-hang" method="post">
  <input type="hidden" name ="action" value="changeInformation">
  <img class="mb-4" src="../../img/logo.jpg" alt="" width="400" height="200">
   <h1>Thay đổi thông tin khách hàng</h1>
   
   <div style="color:green; font-size:22px;"><%=success %></div>
   
   	<div class="d-flex justify-content-between">
   		<div class="text-start information_text ">
   	<h3 class="text-center">Thông tin khách hàng </h3></br>
   	<span>Họ và tên: <%=khachHang.getHoVaTen() %> </span></br>
   	<span>Giới tính: <%=khachHang.getGioiTinh() %> </span></br>
   	<span>Ngày sinh: <%=khachHang.getNgaySinh() %> </span></br>
   	<span>Đại chỉ: <%=khachHang.getDiaChi() %> </span></br>
   	<span>Địa chỉ nhận hàng: <%=khachHang.getDiaChiNhanHang() %> </span></br>
   	<span>Địa chỉ ghi hóa đơn: <%=khachHang.getDiaChiGhiHoaDon() %> </span></br>
   	<span>Số điện thoại: <%=khachHang.getSoDienThoai() %> </span></br>
   	<span>Email: <%=khachHang.getEmail() %> </span></br>
   	<span> <%=(khachHang.isDangKiNhanTin())?"Đồng ý nhận mail quảng cáo":"Không đồng ý nhận mail quảng cáo" %> </span></br>
   		</div>
   		<img class="mb-4" src="../../img/outstanding.jpg" alt="" width="900" height="360">
   	</div>
   
   <div class="row text-start">
		<div class="col-lg-6">
	
	<div class="text-center"><h1>Sửa thông tin khách hàng</h1></div>
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
		<img class="ms-5" src="../../img/logo.jpg" alt="" width="400" height="200">
		</div>
	<div class="col-lg-6">
	
	<div class="text-center"><h1>Sửa địa chỉ</h1></div>

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
 	 	<label for="dongYNhanMail" class="form-label">Đồng ý nhận email </label> 
  		<input type="checkbox" class="form-check-input" id="dongYNhanMail" name="dongYNhanMail" <%=(vl_dongYNhanMail.equals("on")?"checked":"unchecked") %> >
	</div>
	
	</div>
	</div>	
  	<input type="submit" id="submit" class="btn btn-primary form-control" value="Thay đổi thông tin khách hàng">
  	<a  class="btn btn-info w-100 py-2 my-2" href="../index.jsp">Trở lại</a>
  	 <p class="mt-5 mb-3 text-body-secondary">&copy; 2017–2023</p>
  </form>
</div>
<%} %>
	<%@include file="../footer.jsp" %>
</body>
</html>