<%@page import="model.KhachHang"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ChangeAvatar</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.min.js" integrity="sha384-Rx+T1VzGupg4BHQYs2gCW9It+akI2MM/mndMCy36UVfodzcJcF0GGLxZIzObiEfa" crossorigin="anonymous"></script>
<link rel="stylesheet" href="../../css/changeInformation.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css">

</head>

<body>
		<jsp:include page="../header.jsp"></jsp:include>
<%
		
	String url = request.getScheme() + "://" +request.getServerName()+":" + request.getServerPort() + request.getContextPath();
		
	String duongDanAnh = request.getAttribute("duongDanAnh")+"";
	
	KhachHang khachHang = (KhachHang) session.getAttribute("khachHang");
	if(khachHang==null){
	
%>
	
	<h1>Bạn chưa đăng nhập vào hệ thống hãy quay lại trang chủ</h1>
	<a href="../index.jsp">Quay lại trang chủ</a>
	<%}else{ %>
	
<div class="container">
  <form class="text-center" action="khach-hang" method="post" enctype="multipart/form-data">
  	<input type="hidden" name ="action" value="changeAvatar">
  <img class="mb-4" src="../../img/logo.jpg" alt="" width="400" height="200">
   <h1>Thay đổi Avatar</h1>
   
 <%--   <div style="color:green; font-size:22px;"><%=success %></div> --%>
   
   	
   	<h3 class="text-center">Thông tin khách hàng </h3></br>
   	<img alt="Ảnh Avatar" src="<%=url%>/khach-hang-view/avatar/<%=duongDanAnh%>">
   	
   	<div class="mb-3">
 	 	<label for="duongDanAnh" class="form-label">Đường dẫn ảnh</label> 
  		<input type="file" class="form-control" id="duongDanAnh" name="duongDanAnh" required="required" >
	</div>
		<input type="submit" class="btn btn-primary " value="Lưu thông tin" name="submit">
  </form>
</div>
<%} %>
	<jsp:include page="../footer.jsp"></jsp:include>
</body>
</html>