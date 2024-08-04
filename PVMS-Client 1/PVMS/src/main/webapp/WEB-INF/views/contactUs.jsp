<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="m"%>

<m:Master title="Contact us">

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
/* General Styles */
body {
	font-family: Arial, sans-serif;
	margin: 0;
	padding: 0;
	background-color: #fff;
}

.container {
	max-width: 800px;
	margin: 0 auto;
	padding: 0px;
}

header {
	background-color: #333;
	color: #fff;
	padding: 0px 0;
}

header nav ul {
	margin: 0;
	padding: 0;
	list-style-type: none;
}

header nav ul li {
	display: inline;
	margin-right: 20px;
}

header nav ul li a {
	color: #fff;
	text-decoration: none;
}

footer {
	color: #000; /* Black text color */
	text-align: center;
	padding-top: 10px;
	position: fixed;
	bottom: 0;
	width: 100%;
}

/* Contact Form Styles */
#contact {
	background-color: #fff;
	padding: 20px;
	margin-top: 0px; /* Adjusted margin-top value */
	border-radius: 10px;
}

#contact h1 {
	text-align: center;
	margin-bottom: 20px;
}

#contact p {
	text-align: center;
	margin-bottom: 30px;
}

#contact form label {
	display: block;
	margin-bottom: 5px;
	font-weight: bold;
}

#contact form input[type="text"], #contact form input[type="email"],
	#contact form textarea {
	width: 100%;
	padding: 10px;
	margin-bottom: 20px;
	border: 1px solid #ccc;
	border-radius: 5px;
	box-sizing: border-box;
}

#contact form textarea {
	resize: vertical;
}

#contact form input[type="submit"] {
	width: 100%;
	background-color: #333;
	color: #fff;
	border: none;
	padding: 15px;
	border-radius: 5px;
	cursor: pointer;
}

#contact form input[type="submit"]:hover {
	background-color: #555;
	padding-bottom: 10px;
}
</style>
</jsp:attribute>

	<jsp:attribute name="content">
<div id="contact">
        <div class="container">
            <h1 style="font-family: auto; color: #1d3963; border-bottom: 2px solid;">Contact Us</h1>
            <br>
            <p>If you have any questions or inquiries, please feel free to contact us using the form below:</p>
            
            <form action="#" method="POST">
                <label for="name">Name:</label>
                <input type="text" id="name" name="name" required>
 
                <label for="email">Email:</label>
                <input type="email" id="email" name="email" required>
 
                <label for="message">Message:</label>
                <textarea id="message" name="message" rows="6" required></textarea>
 
                <input type="submit" value="Send Message">
            </form>
        </div>
    </div>
 
    <footer>
        <p>&copy; 2024 Passport & Visa Services. All rights reserved.</p>
    </footer>
</jsp:attribute>
</m:Master>
