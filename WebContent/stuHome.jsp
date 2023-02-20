<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<!-- IRFAN AFIFI -->
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>stuHome</title>
<!-- FONT -->
<link href="https://fonts.googleapis.com/css2?family=Ubuntu:wght@300&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=ZCOOL+XiaoWei&display=swap" rel="stylesheet">
<!-- CSS -->
<style>
     <%@ include file="../Css/stuHome.css"%>
</style>

</head>
<body>

<div class="main-body" align="center"> <!-- BACKGROUND -->
<div class="Home" align="center">
	<div class="header" align="center">
	  <br><h1>Course Online Portal</h1> <!-- TITLE -->
	</div>	 
		
		   <div class="position" align="center">	
			    <div class="position" align="right">
			   	  <!-- 1 --><br>
				  <div class="card2" align="center">
				  			<br>
		             <!-- Slideshow container -->
							<div class="slideshow-container">  <!-- PICTURE SLIDESHOW -->
							
							  <!-- Full-width images with number and caption text -->
							  <div class="mySlides fade">
							    <div class="numbertext">1 / 3</div>
							    <img src="https://mlw7hbissvcr.i.optimole.com/qcdHgbo-y1hVjAW0/w:1000/h:1000/q:auto/https://www.unirecommend.com/wp-content/uploads/2021/03/MMU.jpg" style="width:100%">

							  </div>
							
							  <div class="mySlides fade">
							    <div class="numbertext">2 / 3</div>
							    <img src="https://en.your-uni.com/wp-content/uploads/2020/10/Multimedia-university-mmu-photos.jpg" style="width:100%">

							  </div>
							
							  <div class="mySlides fade">
							    <div class="numbertext">3 / 3</div>
							    <img src="https://www.secondcrm.com/wp-content/uploads/2019/04/mmu-banner.jpg" style="width:100%">

							  </div>
							
							  <!-- Next and previous buttons -->
							  <a class="prev" onclick="plusSlides(-1)">&#10094;</a>
							  <a class="next" onclick="plusSlides(1)">&#10095;</a>
							</div>
							<br>
							
							<!-- The dots/circles -->
							<div style="text-align:center">
							  <span class="dot" onclick="currentSlide(1)"></span>
							  <span class="dot" onclick="currentSlide(2)"></span>
							  <span class="dot" onclick="currentSlide(3)"></span>
							</div>
							
							<!-- JS FUNCTION TO SWIPE PICTURE SLIDESHOW ONCLICK -->
							<script>  
								let slideIndex = 1;
								showSlides(slideIndex);
								
								function plusSlides(n) {
								  showSlides(slideIndex += n);
								}
								
								function currentSlide(n) {
								  showSlides(slideIndex = n);
								}
								
								function showSlides(n) {
								  let i;
								  let slides = document.getElementsByClassName("mySlides");
								  let dots = document.getElementsByClassName("dot");
								  if (n > slides.length) {slideIndex = 1}    
								  if (n < 1) {slideIndex = slides.length}
								  for (i = 0; i < slides.length; i++) {
								    slides[i].style.display = "none";  
								  }
								  for (i = 0; i < dots.length; i++) {
								    dots[i].className = dots[i].className.replace(" active", "");
								  }
								  slides[slideIndex-1].style.display = "block";  
								  dots[slideIndex-1].className += " active";
								}
								</script>
															
				  </div>
				</div>	
				
			<div class="position" align="left">	
		      <!-- 2 -->
			  <div class="card" align="center">
				<img src="https://cdn-icons-png.flaticon.com/512/146/146007.png" alt="Admin" class="rounded-circle" width="120"> <!-- IMAGE -->
				<h4><%=(request.getAttribute("username") == null) ? "": request.getAttribute("username")%></h4>
				
					<div class="allbtn" align="center"> <!-- ALL BUTTON -->
					<form action="${pageContext.request.contextPath}/StuProfileServlet" method="post">
						<input type="hidden" name="username" value=<%=(request.getAttribute("username") == null) ? "": request.getAttribute("username")%>>
						<input type="hidden" name="password" value=<%=(request.getAttribute("password") == null) ? "": request.getAttribute("password")%>>
						<input class="btn" type="submit" value="Profile">
					</form>
					<form action="${pageContext.request.contextPath}/StuViewServlet" method="post">
						<input type="hidden" name="username" value=<%=(request.getAttribute("username") == null) ? "": request.getAttribute("username")%>>
						<input type="hidden" name="password" value=<%=(request.getAttribute("password") == null) ? "": request.getAttribute("password")%>>
						<input class="btn" type="submit" value="Courses">
					</form>
					<form action="${pageContext.request.contextPath}/UserLogOutServlet" method="get">
						<input type="hidden" name="username" value=<%=(request.getAttribute("username") == null) ? "": request.getAttribute("username")%>>
						<input type="hidden" name="password" value=<%=(request.getAttribute("password") == null) ? "": request.getAttribute("password")%>>
						<input class="btn" type="submit" value="Log Out">
					</form>

					</div>
			  </div>	  
			</div>	
		</div>

			

			
		
		

</div>
</div>


</body>
</html>