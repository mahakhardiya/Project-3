<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="m"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<m:AfterLogin title="Profile">
<jsp:attribute name="header">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/styles/Profile.css" />
	<script
			src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script>
	function closePopup() {
		$("#popup").hide();
	}
	
	$("#ShowVisa").click(function(){
		var userId="${userIdSession}";
		 $.ajax({
		        type : "get",
		        url : "http://localhost:9090/getVisa/"+userId,
		        dataType : "json",
		        contentType : "application/json;charset=utf-8",
		        success:function(msg){
		        	if(msg.length!=0)
		        		{
		        		$("#tbl").append("<tr> <th>VisaId</th> <th>Country</th> <th>Occupation</th> <th>Date Of Expiry</th> <th>Date Of Issue</th> <th>Status</th> </tr>");
			        	for(var i=0;i<msg.length;i++)
			        		{
			        	 	var str="<tr> <td>"+msg[i].visaId+"</td>  <td>"+msg[i].country+"</td> <td>"+msg[i].occupation+"</td>  <td>"+msg[i].expiryDate+"</td> <td>"+msg[i].issueDate+"</td>  <td>"+msg[i].status+"</td> </tr>";
				         	$("#tbl").append(str); // replace 'yourTableId' with the id of your table
			        		}
		        		}
		        	else
		        		{
		        		$("#tbl").append("<tr><td>No Visa found</td></tr>");
		        		}
		        	
		        	//$("#tbl").append("<tr> <td><button id='printButton'>Download</button></td> </tr>")
		        
		        }
		  
		    });
		
	});
</script>
</jsp:attribute>

<jsp:attribute name="content">
        <div class="profile-container">
            <form>
            <h2 class="text-center" style="font-family: auto;color: #1d3963;font-weight: 600;">Profile Details</h2>
                <table>
                    <tr>
                        <td class="text-styling">User ID</td>
                        <td><input value="${user.userId}" disabled="disabled"></td>
                    </tr>
                    <tr>
                        <td class="text-styling">First Name</td>
                        <td><input value="${user.firstName}" disabled="disabled"></td>
                    </tr>
                    <tr>
                        <td class="text-styling">Surname</td>
                        <td><input value="${user.surname}" disabled="disabled"></td>
                    </tr>
                    <tr>
                        <td class="text-styling">Date Of Birth</td>
                        <td><input value="${user.dateOfBirth}" disabled="disabled"></td>
                    </tr>
                    <tr>
                        <td class="text-styling">Gender</td>
                        <td><input value="${user.gender}" disabled="disabled"></td>
                    </tr>
                    <tr>
                        <td class="text-styling">Contact Number</td>
                        <td><input value="${user.contactNumber}" disabled="disabled"></td>
                    </tr>
                    <tr>
                        <td class="text-styling">Email Address</td>
                        <td><input value="${user.email}" disabled="disabled"></td>
                    </tr>
                    <tr><td><input type="submit" formaction="ShowPassport" value="Show Passport" style="background-color: #1d3963;color: white;"></td>
                    <td></td>
                    <td><input type="submit" value="Show Visa" class="ShowVisa" id="ShowVisa" formaction="ShowVisa" style="margin-right: 25%;background-color: #1d3963;color: white;"></td>
                    </tr>
                </table>
            </form>
        </div>
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
    </jsp:attribute>
</m:AfterLogin>
