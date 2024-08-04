<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="m"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<m:AfterLogin title="Services">
	<jsp:attribute name="header">
	<link rel="stylesheet"
			href="${pageContext.request.contextPath}/styles/Services.css" />
 	<link
			href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
			rel="stylesheet"
			integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
			crossorigin="anonymous">
	<script
			src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
			integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
			crossorigin="anonymous"></script>
	<script
			src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script>
	function closePopup() {
		$("#popup").hide();
	}
</script>
</jsp:attribute>
	<jsp:attribute name="content">
	<p style="margin: 5px; font-family:auto;"><b>Welcome ${userId},</b></p>
<h2 style="font-family: auto;font-size: 2.9rem; position: absolute; top: 12%;left: 46%; color: #1d3963; border-bottom: 2px solid currentColor;">Services</h2>

  <div class="container">
     <div class="card">
       <div class="face face1">
         <div class="content">
             <img src="${pageContext.request.contextPath}/images/ApplyPassport2.jpg" width="280px" height="200px">           
           
         </div>
       </div>
       <div class="face face2">
         <div class="content" style="text-align: center;">
         <h3 style="font-weight: 600;font-family:auto;">Apply Passport</h3>
           <p>Embark on your travel adventures sooner by applying for your passport quickly and efficiently.</p>
           <a href="./ApplyPassport" type="button">Apply Passport</a>
         </div>
       </div>
    </div>
    
    <div class="card">
       <div class="face face1">
         <div class="content">
            <img src="${pageContext.request.contextPath}/images/ApplyVisa.jpg" width="280px" height="200px">      
          
         </div>
       </div>
       <div class="face face2">
         <div class="content" style="text-align: center;">
         <h3 style="font-weight: 600;font-family:auto;">Apply Visa</h3>
           <p> Experience a stress-free visa application journey tailored to your needs and timeline.</p>
           <a href="./ApplyVisa" type="button">Apply Visa</a>
         </div>
       </div>
    </div>
    
    <div class="card">
       <div class="face face1">
         <div class="content">
         <img src="${pageContext.request.contextPath}/images/PassportRenewal.jpg" width="280px" height="200px">
         </div>
       </div>
       <div class="face face2">
         <div class="content" style="text-align: center;">
			<h3 style="font-weight: 600;font-family:auto;">Passport Renewal</h3>
           <p>Experience a stress-free passport renewal process with our dedicated support.</p>
           <a href="./PassportRenewal" type="button">Renew Passport</a>
         </div>
       </div>
    </div>
    
 <div class="card">
  <div class="face face1">
    <div class="content">
      <img src="${pageContext.request.contextPath}/images/CancelVisa.jpg" width="280px" height="200px">
    </div>
  </div>
  <div class="face face2">
    <div class="content" style="text-align: center;">
  		<h3 style="font-weight: 600;font-family:auto;">Cancel Visa</h3>
      <p>Cancel your visa stress-free with our dedicated support, making your travel plans as smooth as can be.</p>
      <a href="./CancelVisa" type="button" >Cancel Visa</a>
    </div>
  </div>
</div>
  
   <div class="card" id="card5">
  <div class="face face1">
    <div class="content">
      <img src="${pageContext.request.contextPath}/images/PassportLost.jpg" width="280px" height="200px">
    </div>
  </div>
  <div class="face face2">
    <div class="content" style="text-align: center;">
  		<h3 style="font-weight: 600;font-family:auto;">Lost Passport</h3>
      <p>Replace your lost passport stress-free with our dedicated support, making your travel plans as smooth as can be.</p>
      <a href="./PassportLost" type="button" >Passport Lost</a>
    </div>
  </div>
</div>
  </div>

  
<c:if test="${PassportError != null}">
    <div
				style="display: flex; justify-content: center; background-color: #f0f0f0; align-items: center;"
				id="popup">
        <img src="${pageContext.request.contextPath}/images/profile.jpg"
					style="width: 100px; height: 100px; border-radius: 50%;">
        <div style="text-align: center;">
            <h5>${PassportError}</h5>
             <div
						style="display: flex; justify-content: center; align-items: center;">
                <input type="button" id="popupbutton" value="Close"
							class="btn btn-danger" onclick="closePopup();"
							style="margin-right: 5px;">
                <form method="post" action="/ApplyPassport">
                    <button type="submit" class="btn btn-primary">Apply Passport</button>
                </form>
            </div>
        </div>
    </div> 
</c:if>
 <c:if test="${newPassportDetails!= null}">
    <div
				style="display: flex; justify-content: center; background-color: #f0f0f0; align-items: center;"
				id="popup">
        <img src="${pageContext.request.contextPath}/images/profile.jpg"
					style="width: 100px; height: 100px; border-radius: 50%;">
        <div style="text-align: center;">
        <h5>${newPassportDetails}</h5>
            <input type="button" id="popupbutton" value="Close"
						class="btn btn-danger" onclick="closePopup();"
						style="margin: 5px;">
        </div>
    </div> 
</c:if>
<c:if test="${message != null}">   
<div
				style="display: flex; justify-content: center; background-color: #f0f0f0; align-items: center;"
				id="popup">
        <img src="${pageContext.request.contextPath}/images/profile.jpg"
					style="width: 100px; height: 100px; border-radius: 50%;">
        <div style="text-align: center;">
            <h5>${message}</h5>
            <input type="button" id="popupbutton" value="Close"
						class="btn btn-danger" onclick="closePopup();"
						style="margin: 5px;">
        </div>
  </div>  

</c:if>
<c:if test="${visaDetails != null}">
   <div
				style="display: flex; justify-content: center; background-color: #f0f0f0; align-items: center;"
				id="popup">
        <img src="${pageContext.request.contextPath}/images/profile.jpg"
					style="width: 100px; height: 100px; border-radius: 50%;">
        <div style="text-align: center; margin-top: 15%">
        	<c:forEach var="i" items="${visaDetails}">
        		<h5>${i}</h5>
        	</c:forEach>
            <h5>${alertMessage}</h5>
            <input type="button" id="popupbutton" value="Close"
						class="btn btn-danger" onclick="closePopup();"
						style="margin: 5px;">
        </div>
    </div>
</c:if>
</jsp:attribute>

</m:AfterLogin>