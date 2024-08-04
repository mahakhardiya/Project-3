<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>    
<%@ taglib tagdir="/WEB-INF/tags" prefix="m" %>
 

<m:AfterLogin title="Apply Visa">
<jsp:attribute name="header">
<link rel="stylesheet" href="${pageContext.request.contextPath}/styles/Visa.css">

<style>
  			body {
                margin: 0;
                padding: 0;
                background-color: #f6f6f6; /* Light background color */
                font-weight: 600;
             
            }
 
            .form-container {
            
                background-image: url(" ${pageContext.request.contextPath}/images/AfterLoginBg.jpg"); /* Add your background image path */
                background-size: cover; /* Cover the entire container */
                display: flex;
                justify-content: center;
                align-items: center;
                min-height: 100vh; /* Set minimum height to viewport height */
                padding: 0px; /* Add padding to the container */
                overflow: hidden; /* Prevent overflow */
            }
 
            .form-wrapper {
                margin-top: 2%;
                background-color: rgba(255, 255, 255, 0.8); /* Semi-transparent white background */
                border-radius: 20px;
                padding: 30px;
                width: calc(100% - 40px); /* Adjusted width */
                max-width: 680px;
                box-shadow: 0 0 15px rgba(0, 0, 0, 0.1); /* Soft shadow */
                overflow: hidden; /* Prevent overflow */
            }
 
            /* Styling the form */
            .form-wrapper table {
                width: 100%;
                margin-top: 10px; /* Adjust top margin */
            }
 
            .form-wrapper td {
                padding: 10px;
            }
 
			.display-content{
			position:absolute;
			top:5%;
			}
 
            /* Responsive styles */
            @media (max-width: 768px) {
                .form-wrapper {
                    padding: 10px; /* Adjust padding for smaller screens */
                }
            }
 
            @media (max-width: 600px) {
                .form-wrapper {
                    max-width: 600px;
                }
                
            }
                .error {
                    color: red;
                }
 
            /* Style the textboxes */
            .form-wrapper input[type="text"],
            .form-wrapper select {
                width: 70%;
                padding: 10px;
                border: 1px solid #ccc;
                border-radius: 5px;
                box-sizing: border-box;
                margin-top: 5px;
                margin-bottom: 10px;
            }
 
            /* Style the submit button */
            .form-wrapper input[type="submit"] {
                width: 100%;
                padding: 10px;
                border: none;
                border-radius: 5px;
                background-color: rgb(0, 64, 128);
                color: white;
                cursor: pointer;
            }
 
            .form-wrapper input[type="submit"]:hover {
                background-color: #003366; /* Darker shade of blue on hover */
            }
            
            .error
			{
			color:red;
			}
			
			#popup
			{
			display: flex;
			justify-content: center;
			align-items: center;
			border-radius: 10px;
			width: 110%;
			background: powderblue;	
			color: red		
			}
			
			#popupVisa
			{
			display: flex;
			justify-content: center;
			align-items: center;
			border-radius: 10px;
			width: 110%;
			background: powderblue;	
			color: red		
			}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script>
$(function(){
	
    $.ajax({
        type : "get",
        url : "http://localhost:9090/getAllPlaces",
        dataType : "json",
        contentType : "application/json;charset=utf-8",
        success:function(msg){
           
            var uniquePlaces = []; // Separate list to store unique places
            var uniqueOccupation = [];
            for(var i = 0; i < msg.length; i++) {
                var place = msg[i].occupationId.place;
                var occupation = msg[i].occupationId.occupation;
 
                // Add the place to the uniquePlaces list if it's not already there
                if(!uniquePlaces.includes(place)) {
                    uniquePlaces.push(place);
                    $("#selectCountry").append("<option value='" + place + "'>" + place + "</option>");
                }
                if(!uniqueOccupation.includes(occupation)) {
                    uniqueOccupation.push(occupation);
                    $("#selectOccupation").append("<option value='" + occupation + "'>" + occupation + "</option>");
                }
            }
        }
  
    });
		
    $("#selectCountry").change(function() {
        var selectedCountry = $(this).val();
        //alert("You have selected: " + selectedCountry);
         var userId = $("#userId").val()
         //alert(userId);
        
        $.ajax({
            type : "get",
            url : "http://localhost:9090/getVisaCountrys/"+userId,
            dataType : "json",
            contentType : "application/json;charset=utf-8",
            success:function(msg){
             for(var i=0;i<msg.length;i++)
            	 {
            	 if(msg[i]==selectedCountry)
            		 {
            		 alert("You had already applied for "+msg[i]);
            		 $("#selectCountry").val("");
            		 }
            	 }
            }
      
        });
        
    });
 
});
 
 
</script>
</jsp:attribute>

<jsp:attribute name="content">
<div class="form-container" >
 
<div class="display-content">
 
<c:if test="${passportExpiryBeforeVisa != null}">
    <div class="popup" id="popup">
        <div style="text-align: center;">
            <h5>${passportExpiryBeforeVisa}</h5>
            <input type="button" id="popupbutton" value="Apply Passport" class="popupbutton" style="margin: 5px;">
        </div>
    </div>
</c:if>
 
<c:if test="${passportMsg != null}">
    <div class="popup" id="popup">
        <div style="text-align: center;">
            <h5>${passportMsg}</h5>
            <input type="button" id="popupbutton" value="Apply Passport" class="popupbutton" style="margin: 5px;">
        </div>
    </div>
</c:if>
 
<c:if test="${visaDetails != null}">
    <div class="popupVisa" id="popupVisa">
        <div style="text-align: center;">
        	<c:forEach var="i" items="${visaDetails}">
        		<c:out value="${i}"></c:out>
        		<br>
        	</c:forEach>
            <h5>${alertMessage}</h5>
            <input type="button" id="popupbutton" value="Close" class="popupbutton" style="margin: 5px;">
        </div>
    </div>
</c:if>
</div>
 
<div class="form-wrapper" >
<f:form action="VisaForm" modelAttribute="visa" class="myform" id="myform">
    <table>
    	<tr><td></td><td><h2 style="font-family: auto;color: #1d3963;font-weight: bold;">Apply Visa</h2></td></tr>
    	<tr>
            <td>User Id</td>
            <td><input type="text" name="userId" class="userId" id="userId"  value="${userIdSession}" disabled="disabled"></td>
            <%-- <td><f:errors path="userId"" cssClass="error"/></td> --%>
        </tr>
        <tr>
            <td>Passport Id</td>
            <td><input  type="text" name="passportId" id="passportId"  value="${passportId}" disabled="disabled"/></td>
			<%-- <td><f:errors path="passportId" cssClass="error"/></td> --%>
        </tr>
        <tr>
    <td>Country</td>
    <td>
        <select name="country" id="selectCountry">
            <option value="">Select</option> <!-- Modify default option -->
        </select>
    </td>
    <td><f:errors path="country" cssClass="error"/></td>
</tr>
<tr>
    <td>Occupation</td>
    <td>
        <select name="occupation" id="selectOccupation">
            <option value="">Select</option> <!-- Modify default option -->
        </select>
    </td>
    <td><f:errors path="occupation" cssClass="error"/></td>
</tr>
        
        <tr>
            <td>Date Of Application</td>
            <td><input type="date" value="${dateOfApplication}" disabled ></td>
            <td></td>
        </tr>
        <tr>
        <td></td>
            <td ><input type="submit" id="showMessage" class="showMessage btn-large"></td>
        </tr>
    </table>
</f:form>
 
</div>
</div>
 </jsp:attribute>
</m:AfterLogin>