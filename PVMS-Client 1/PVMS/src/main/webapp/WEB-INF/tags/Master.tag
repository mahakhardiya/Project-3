<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@ attribute name="title" required="true" rtexprvalue="true"%>
<%@ attribute name="header" fragment="true"%>
<%@ attribute name="content" fragment="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>${title}</title>
<link rel="Stylesheet"
	href="${pageContext.request.contextPath}/styles/Mystyles.css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
	crossorigin="anonymous"></script>
	<link rel="icon" type="image/x-icon" href="/images/favicon.png">
<jsp:invoke fragment="header"></jsp:invoke>
</head>
<body>
	<div>
    <nav class="navbar navbar-expand-lg navbar-dark" style="background-color: #1d3963">
        <div class="container-fluid">
            <a class="navbar-brand" style="font-size: xx-large; font-family: emoji;" href="./"><img src="${pageContext.request.contextPath}/images/passportWaveLogo2.png" height="55px" width="150px"></a>

            <!-- Add the navbar toggler for small screens -->
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav"
                aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <!-- Add the collapsible content with an ID -->
            <div class="collapse navbar-collapse justify-content-start" id="navbarNav">
                <ul class="navbar-nav ms-auto">
                    <li class="nav-item">
                        <a class="nav-link" aria-current="page" href="./">Home</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="./aboutus">About Us</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="./contactUs">Contact Us</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
</div>



	<jsp:invoke fragment="content"></jsp:invoke>
</body>
</html>
