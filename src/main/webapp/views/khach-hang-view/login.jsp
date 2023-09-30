<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.min.js" integrity="sha384-Rx+T1VzGupg4BHQYs2gCW9It+akI2MM/mndMCy36UVfodzcJcF0GGLxZIzObiEfa" crossorigin="anonymous"></script>
<link rel="stylesheet" href="../../css/login.css">

</head>
<body>
	<jsp:include page="../header.jsp"></jsp:include>
<%
	String err_msg = request.getAttribute("err_msg")+"";
	err_msg= (err_msg.equals("null")?"":err_msg);
%>
<main class="form-signin w-100 m-auto">
  <form class="text-center" action="khach-hang" method="post">
  	<input type="hidden" name = "action" value="login">
  	<i class="fa-solid fa-user ms-2"></i>
    <img class="mb-4" src="../../img/logo.jpg" alt="" width="72" height="57">
    <h1 class="h3 mb-3 fw-normal">Đăng nhập</h1>
	
		
	
    <div class="form-floating">
      <input type="text" class="form-control" id="tenDangNhap" name="tenDangNhap" placeholder="Tên đăng nhập">
      <label for="floatingInput">Tên đăng nhập</label>
    </div>
    <div class="form-floating">
      <input type="password" class="form-control" id="matKhau" name="matKhau" placeholder="Mật khẩu">
      <label for="floatingPassword">Mật khẩu</label>
    </div>

    <div class="form-check text-start my-3">
      <input class="form-check-input" type="checkbox" value="remember-me" id="remember-me" name="remember-me">
      <label >Ghi nhớ tài khoản này</label>
      
      
    </div>
    <div class="text-start err"><%=err_msg %></div>
    <button class="btn btn-primary w-100 py-2 my-2" type="submit">Đăng nhập</button>
    
    <a href="register.jsp">Đăng ký tài khoản</a>
   
    
    
    <p class="mt-5 mb-3 text-body-secondary">&copy; 2017–2023</p>
  </form>
</main>
	<jsp:include page="../footer.jsp"></jsp:include>
</body>

</html>