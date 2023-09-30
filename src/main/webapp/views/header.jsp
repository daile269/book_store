<%@page import="model.KhachHang"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String url = request.getScheme() + "://" +request.getServerName()+":" + request.getServerPort() + request.getContextPath();

%>

<nav class="navbar navbar-expand-lg bg-body-tertiary">
  <div class="container-fluid">
    <a class="navbar-brand" href="index.jsp">
    <img src="<%=url %>/img/logo.jpg" alt="Bootstrap" width="30" height="24">
    </a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="#">Trang chủ</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">Mua sách</a>
        </li>
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            Thể loại
          </a>
          <ul class="dropdown-menu">
            <li><a class="dropdown-item" href="#">Sách Khoa học- Công nghệ </a></li>
            <li><a class="dropdown-item" href="#">Sách Chính trị- Pháp Luật</a></li>
            <li><a class="dropdown-item" href="#">Sách Văn học- Nghệ thuật</a></li>
            <li><hr class="dropdown-divider"></li>
            <li><a class="dropdown-item" href="#">Sách Giáo Khoa</a></li>
             <li><a class="dropdown-item" href="#">Sách Thiếu Nhi</a></li>
              <li><a class="dropdown-item" href="#">Truyện Tiểu Thuyết</a></li>
          </ul>
        </li>
        <li class="nav-item">
          <a class="nav-link " href="#" >Tất cả sách</a>
        </li>
      </ul>
      <form class="d-flex me-6" role="search" style="white-space: nowrap;">
        <input class="form-control me-2" type="search" placeholder="Tìm kiếm" aria-label="Search">
        <button class="btn btn-outline-success" type="submit">Tìm kiếm</button>
        
      </form>
      <%
        	KhachHang khachHang = (KhachHang) session.getAttribute("khachHang");
        	if(khachHang==null){
        		
        	
        %>
        
        <a class="btn btn-primary ms-2" href="<%=url %>/views/khach-hang-view/login.jsp" >
        	Đăng nhập
        </a>
        <a class="btn btn-secondary ms-2" href="<%=url %>/views/khach-hang-view/register.jsp" >
        	Đăng ký
        </a>
        <%
        	}else {     
        %>
        <i class="fa-solid fa-user ms-2"></i>
	        <span><%=khachHang.getTenDangNhap() %></span> 
        <!-- Example split danger button -->
	<div class="btn-group ms-2 me-5">
	  <button type="button" class="btn btn-info">Tài khoản</button>
	  <button type="button" class="btn btn-info dropdown-toggle dropdown-toggle-split" data-bs-toggle="dropdown" aria-expanded="false">
	    
	  </button>
	  <ul class="dropdown-menu">
	    <li><a class="dropdown-item" href="#">Đơn hàng của tôi</a></li>
	    <li><a class="dropdown-item" href="#">Thông báo</a></li>
	    <li><a class="dropdown-item" href="../khach-hang-view/changeAvatar.jsp">Thay đổi Avatar</a></li>
	    <li><a class="dropdown-item" href="../khach-hang-view/changeInformation.jsp">Thay đổi thông tin</a></li>
	     <li><a class="dropdown-item" href="../khach-hang-view/changePassword.jsp">Đổi mật khẩu</a></li>
	    <li><hr class="dropdown-divider"></li>
	    <li><a class="dropdown-item" href="khach-hang-view/khach-hang?action=logout">Đăng xuất</a></li>
	  </ul>
	</div>
        <%-- 
        <div class="text-center ms-1">
	      	<i class="fa-solid fa-user"></i>
	        <span><%=khachHang.getTenDangNhap() %></span> 
	         <a class="btn btn-primary" href="logout" >
	        	Đăng xuất
	        </a>
        </div> 
        --%>
        
        <%} %>
       
    </div>
  </div>
</nav>
