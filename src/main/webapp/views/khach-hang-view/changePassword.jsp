<%@page import="model.KhachHang"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ChangePassword</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.min.js" integrity="sha384-Rx+T1VzGupg4BHQYs2gCW9It+akI2MM/mndMCy36UVfodzcJcF0GGLxZIzObiEfa" crossorigin="anonymous"></script>
<link rel="stylesheet" href="../../css/changePassword.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css">

</head>

<body>
		<jsp:include page="../header.jsp"></jsp:include>
<%

	String err_pass = request.getAttribute("err_pass")+"";
	String err_passAgain = request.getAttribute("err_passAgain")+"";
	String success = request.getAttribute("success")+"";
	err_pass = (err_pass.equals("null")?"":err_pass);
	err_passAgain = (err_passAgain.equals("null")?"":err_passAgain);
	success = (success.equals("null")?"":success);
	
	KhachHang khachHang = (KhachHang) session.getAttribute("khachHang");
	if(khachHang==null){
	
%>
	
	<h1>Bạn chưa đăng nhập vào hệ thống hãy quay lại trang chủ</h1>
	<a href="../index.jsp">Quay lại trang chủ</a>
	<%}else{ %>
<main class="form-signin w-100 m-auto">
  <form class="text-center" action="khach-hang" method="post">
   <input type="hidden" name="action" value="changePassword"> 
    <img class="mb-4" src="../../img/logo.jpg" alt="" width="72" height="57"><br>
    	
    <h1 class="h3 mb-3 fw-normal">Thay đổi mật khẩu</h1>
	<div class="text-start mb-2">
    	<i class="fa-solid fa-user ms-2"></i>
    	<span ><%=khachHang.getTenDangNhap() %><br>
    	 Họ và tên: <%=khachHang.getHoVaTen()%></span>
    	 <div class="text-start" style="color:green;"><%=success %></div>
    </div>
	
    <div class="form-floating">
      <input type="password" class="form-control" id="matKhauCu" name="matKhauCu" placeholder="Mật khẩu cũ">
      <label for="floatingInput">Mật khẩu cũ</label>
      <div class="text-start err"><%=err_pass %></div>
    </div>
   
    <div class="form-floating mt-2">
      <input type="password" class="form-control" id="matKhauMoi" name="matKhauMoi" placeholder="Mật khẩu mới">
      <label for="floatingPassword">Mật khẩu mới</label>
      <div class="text-start err"><%=err_passAgain %></div>
    </div>
    <div class="form-floating">
      <input type="password" class="form-control" id="nhapLaiMatKhauMoi" name="nhapLaiMatKhauMoi" placeholder="Nhập lại mật khẩu mới">
      <label for="floatingPassword">Nhập lại mật khẩu</label>
    </div>
    
    
    <button class="btn btn-primary w-100 py-2 my-2" type="submit">Thay đổi mật khẩu</button>
  
  		<a  class="btn btn-info w-100 py-2 my-2" href="../index.jsp">Trở lại</a>
    	
    
   
   
    <p class="mt-5 mb-3 text-body-secondary">&copy; 2017–2023</p>
  
  </form>
</main>
<%} %>
	<%@include file="../footer.jsp" %>
</body>
</html>