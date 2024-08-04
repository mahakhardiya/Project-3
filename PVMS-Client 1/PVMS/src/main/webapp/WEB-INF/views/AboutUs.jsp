<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="m"%>

<m:Master title="About us">
	<jsp:attribute name="header">
        <link
			href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
			rel="stylesheet"
			integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
			crossorigin="anonymous">
        <script
			src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
			integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
			crossorigin="anonymous"></script>
        <style>
body {
	font-family: Arial, sans-serif;
	margin: 0;
	padding: 0;
	background-color: #f5f5f5;
}

.container {
	width: 80%;
	margin: 0 auto;
	padding: 20px;
}

h1, h2, h3 {
	color: #333;
}

p {
	line-height: 1.6;
}

header {
	background-color: #333;
	padding: 10px 0;
}

nav ul {
	list-style-type: none;
	margin: 0;
	padding: 0;
	text-align: center;
}

nav ul li {
	display: inline;
	margin-right: 20px;
}

nav ul li a {
	color: #fff;
	text-decoration: none;
}

footer {
	color: black;
	text-align: center;
	padding: 10px 0;
	margin-top: 20px;
}
</style>
    </jsp:attribute>

	<jsp:attribute name="content">
        <section id="about">
            <div class="container">
                <h1
					style="text-align: center; text-align: center; font-family: auto; color: #1d3963; border-bottom: 2px solid;">About Us</h1>
              
                <br>
                <p>Welcome to our passport and visa services website. We are dedicated to providing efficient and reliable assistance for all your passport and visa needs. Our team of professionals strives to make the application, renewal, and cancellation processes as smooth as possible for our clients.</p>
                <p>With years of experience in the industry, we understand the complexities involved in obtaining travel documents. Whether you're applying for a new passport, renewing an existing one, or seeking a visa for your international travel, we are here to help.</p>
                <p>At Passport and Visa Services, customer satisfaction is our top priority. We aim to deliver exceptional service and ensure that your journey starts with hassle-free document processing.</p>
            </div>
        </section>
 
        <!-- Footer -->
        <footer>
            <div class="container"
				style="position: absolute; top: 90%; left: 13%;">
                <p>&copy; 2024 Passport and Visa Services</p>
            </div>
        </footer>
    </jsp:attribute>
</m:Master>