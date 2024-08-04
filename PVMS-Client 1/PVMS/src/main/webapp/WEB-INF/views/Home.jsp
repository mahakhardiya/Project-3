<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="m"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<m:Master title="Home">

	<jsp:attribute name="header">
        <!-- Your header content here -->
        <link rel="stylesheet"
			href="${pageContext.request.contextPath}/styles/Mystyles.css">
			<script
			src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
	<script>
		
			function closePopup() {
				$("#popup").hide();
			}
	</script>



</jsp:attribute>

	<jsp:attribute name="content">
        <div
			style="display: flex; justify-content: space-between; align-items: center; padding: 0 5%; height: 90vh;">
            <div style="width: 50%;">
                <img
					src="${pageContext.request.contextPath}/images/img1.jpg"
					style="object-fit: cover; width: 100%;">
            </div>

            <h1
				style="position: absolute; left: 26%; top: 10%; font-family: emoji; color: #1d3963; font-weight: bold;">
                <span>Welcome to Passport</span>
                <span>and Visa Management System</span>
            </h1>

            <div style="width: 30%;">
                <h1 style="font-family: fantasy; font-size: 3.5rem;">
                    <span>Seamless ,</span> <br>
                    <span>Swift &</span> <br>
                    <span>Effortless.....</span>
                </h1>

                <p
					style="font-size: 15px; color: #707070; margin-bottom: 30px;">
                    Embark on Your Global Journey with Ease! Unlock Seamless Passport Applications, Swift Visa Services. Your Adventure Begins Here. Apply for Your Passport and Visa Hassle-Free Today!
                </p>

               <input type="button" class="btn btn-secondary"
					value="Login" onclick="window.location.href='/login'">
			   <input type="button" class="btn btn-secondary" value="Register"
					onclick="window.location.href='/register'">

            </div>
        </div>
        
        
        
         <c:if test="${msg!= null}">
    <div
				style="display: flex; justify-content: center; background-color: #f0f0f0;; align-items: center;"
				id="popup">
		<img src="${pageContext.request.contextPath}/images/profile.jpg"
					style="width: 100px; height: 100px; border-radius: 50%;">
        <div style="text-align: center;">
            <h5 style="margin-top: 14%;">${msg}</h5>
            <input type="button" id="popupbutton" value="Close"
						class="btn btn-danger" onclick="closePopup();"
						style="margin: 5px;">
        </div>
        </div>
        </c:if>
        
    </jsp:attribute>
</m:Master>
