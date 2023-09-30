<%@page import="model.KhachHang"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Book Store</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.min.js" integrity="sha384-Rx+T1VzGupg4BHQYs2gCW9It+akI2MM/mndMCy36UVfodzcJcF0GGLxZIzObiEfa" crossorigin="anonymous"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css">
</head>
<body>
	<!--Navbar  -->
		<jsp:include page="header.jsp"></jsp:include>
	
	<!--End Navbar  -->
	<!--Container  -->
	<div class="container" >
		<div class="row">
		<!--Menu Left  -->
			<jsp:include page="left.jsp"></jsp:include>
		<!--End menu Left  -->
			<div class="col-lg-9">
		
				<div id="carouselExampleIndicators" class="carousel slide">
  <div class="carousel-indicators">
    <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
    <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="1" aria-label="Slide 2"></button>
    <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="2" aria-label="Slide 3"></button>
  </div>
  <div class="carousel-inner">
    <div class="carousel-item active">
      <img src="https://img.freepik.com/free-vector/bookstore-building-facade-with-large-windows_107791-18843.jpg?w=1380&t=st=1694046404~exp=1694047004~hmac=678ad2fdeb11fc6a43b9ac88e242d6c5e38f85353017f6e575ae98e9cbf9e730" class="d-block w-100" alt="...">
    </div>
    <div class="carousel-item">
      <img src="https://img.freepik.com/free-vector/bookstore-aisle-interior-with-shelf-illustration_107791-20499.jpg?w=1380&t=st=1694046522~exp=1694047122~hmac=b3d19dda349228306cb308177aa9f2b9d692b7d8160884e0479eeb0ab0e28d7d" class="d-block w-100" alt="...">
    </div>
    <div class="carousel-item">
      <img src="https://img.freepik.com/free-vector/cartoon-bookstore-interior-with-books-shelves_107791-20532.jpg?w=1380&t=st=1694046612~exp=1694047212~hmac=b4071ba8bf0b088dc011c2ef2a852f932b4a215ba145e19f347abf0ee50bad0a" class="d-block w-100" alt="...">
    </div>
  </div>
  <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="prev">
    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
    <span class="visually-hidden">Previous</span>
  </button>
  <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="next">
    <span class="carousel-control-next-icon" aria-hidden="true"></span>
    <span class="visually-hidden">Next</span>
  </button>
</div>
<!--Product  -->
	<div class="row">
		<div class="col-lg-3 mb-3">
			<div class="card" style="width: 14rem;">
  <img src="https://product.hstatic.net/200000696663/product/287944486-573813814110642-6549025351161353719-n_e5d28fe927ad4b778d2c0a978e4e72b2_1024x1024.jpg" class="card-img-top" alt="...">
  <div class="card-body">
    <h5 class="card-title">Sayings of Youth</h5>
    <p class="card-text">Youth is the most beautiful journey of every person's life. But maybe that's why people place more dreams floating on it. Around here, we might be allowed to do crazy, possibly wrong things</p>
    <a href="#" class="btn btn-primary ms-5">Buy Now</a>
  </div>
</div>
		</div>
		
	<div class="col-lg-3 mb-3">
			<div class="card" style="width: 14rem;">
  <img src="https://product.hstatic.net/200000696663/product/287944486-573813814110642-6549025351161353719-n_e5d28fe927ad4b778d2c0a978e4e72b2_1024x1024.jpg" class="card-img-top" alt="...">
  <div class="card-body">
    <h5 class="card-title">Sayings of Youth</h5>
    <p class="card-text">Youth is the most beautiful journey of every person's life. But maybe that's why people place more dreams floating on it. Around here, we might be allowed to do crazy, possibly wrong things</p>
    <a href="#" class="btn btn-primary ms-5">Buy Now</a>
  </div>
</div>
		</div>
		<div class="col-lg-3 mb-3">
			<div class="card" style="width: 14rem;">
  <img src="https://product.hstatic.net/200000696663/product/287944486-573813814110642-6549025351161353719-n_e5d28fe927ad4b778d2c0a978e4e72b2_1024x1024.jpg" class="card-img-top" alt="...">
  <div class="card-body">
    <h5 class="card-title">Sayings of Youth</h5>
    <p class="card-text">Youth is the most beautiful journey of every person's life. But maybe that's why people place more dreams floating on it. Around here, we might be allowed to do crazy, possibly wrong things</p>
    <a href="#" class="btn btn-primary ms-5">Buy Now</a>
  </div>
</div>
		</div>
		<div class="col-lg-3 mb-3">
			<div class="card" style="width: 14rem;">
  <img src="https://product.hstatic.net/200000696663/product/287944486-573813814110642-6549025351161353719-n_e5d28fe927ad4b778d2c0a978e4e72b2_1024x1024.jpg" class="card-img-top" alt="...">
  <div class="card-body">
    <h5 class="card-title">Sayings of Youth</h5>
    <p class="card-text">Youth is the most beautiful journey of every person's life. But maybe that's why people place more dreams floating on it. Around here, we might be allowed to do crazy, possibly wrong things</p>
    <a href="#" class="btn btn-primary ms-5">Buy Now</a>
  </div>
</div>
		</div>
		<div class="col-lg-3 mb-3">
			<div class="card" style="width: 14rem;">
  <img src="https://product.hstatic.net/200000696663/product/287944486-573813814110642-6549025351161353719-n_e5d28fe927ad4b778d2c0a978e4e72b2_1024x1024.jpg" class="card-img-top" alt="...">
  <div class="card-body">
    <h5 class="card-title">Sayings of Youth</h5>
    <p class="card-text">Youth is the most beautiful journey of every person's life. But maybe that's why people place more dreams floating on it. Around here, we might be allowed to do crazy, possibly wrong things</p>
    <a href="#" class="btn btn-primary ms-5">Buy Now</a>
  </div>
</div>
		</div>
		<div class="col-lg-3 mb-3">
			<div class="card" style="width: 14rem;">
  <img src="https://product.hstatic.net/200000696663/product/287944486-573813814110642-6549025351161353719-n_e5d28fe927ad4b778d2c0a978e4e72b2_1024x1024.jpg" class="card-img-top" alt="...">
  <div class="card-body">
    <h5 class="card-title">Sayings of Youth</h5>
    <p class="card-text">Youth is the most beautiful journey of every person's life. But maybe that's why people place more dreams floating on it. Around here, we might be allowed to do crazy, possibly wrong things</p>
    <a href="#" class="btn btn-primary ms-5">Buy Now</a>
  </div>
</div>
		</div>
		<div class="col-lg-3 mb-3">
			<div class="card" style="width: 14rem;">
  <img src="https://product.hstatic.net/200000696663/product/287944486-573813814110642-6549025351161353719-n_e5d28fe927ad4b778d2c0a978e4e72b2_1024x1024.jpg" class="card-img-top" alt="...">
  <div class="card-body">
    <h5 class="card-title">Sayings of Youth</h5>
    <p class="card-text">Youth is the most beautiful journey of every person's life. But maybe that's why people place more dreams floating on it. Around here, we might be allowed to do crazy, possibly wrong things</p>
    <a href="#" class="btn btn-primary ms-5">Buy Now</a>
  </div>
</div>
		</div>
		<div class="col-lg-3 mb-3">
			<div class="card" style="width: 14rem;">
  <img src="https://product.hstatic.net/200000696663/product/287944486-573813814110642-6549025351161353719-n_e5d28fe927ad4b778d2c0a978e4e72b2_1024x1024.jpg" class="card-img-top" alt="...">
  <div class="card-body">
    <h5 class="card-title">Sayings of Youth</h5>
    <p class="card-text">Youth is the most beautiful journey of every person's life. But maybe that's why people place more dreams floating on it. Around here, we might be allowed to do crazy, possibly wrong things</p>
    <a href="#" class="btn btn-primary ms-5">Buy Now</a>
  </div>
</div>
		</div>	
		
	
		</div>
		

	
	<!--End Product  -->	
	
	
			</div>
			
		
		</div>
		
		
	</div>
	
	
	<!--End Container  -->
	<!--Footer-->
	
	<jsp:include page="footer.jsp"></jsp:include>
	
	<!--End Footer-->
</body>
</html>