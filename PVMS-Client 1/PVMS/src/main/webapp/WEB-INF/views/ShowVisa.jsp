<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="m"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<m:AfterLogin title="Visas">

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
table {
  border-collapse: collapse;
  width: 65%;
  left:300px;
}
 
th, td {
  text-align: left;
  padding: 8px;
}
 
#tbl{
	position:absolute;
	top: 190px;
}
/* Style for the button container */
#btnStyle {
    position: absolute;
    display: flex;
    justify-content: center;
    align-items: center;
    left: 500px;
    top: 90px
}
 
/* Style for the button itself */
#printButton {
    font-size: 20px;
    padding: 10px 20px;
    color: white;
    background-color: #007BFF;
    border: none;
    border-radius: 5px;
    cursor: pointer;
    transition: background-color 0.3s ease;
}
 
#printButton:hover {
    background-color: #005656;
}
 
tr:nth-child(even) {background-color: #f2f2f2;}
</style>
 
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jspdf/1.5.3/jspdf.debug.js"></script>
 
 
<script>
$(function(){
	
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
		        		$("#tbl").append("<tr><td><h1 style='font-family:emoji;text-align:center;'>No Visas found</h1></td></tr>");
		        		}
		        	
		        	//$("#tbl").append("<tr> <td><button id='printButton'>Download</button></td> </tr>")
		        
		        }
		  
		    });
		  
});
</script>
</jsp:attribute>

<jsp:attribute name="content">
    <div style="overflow-x: auto;">
	<table id="tbl" class="tbl"></table>	
</div>

</jsp:attribute>

</m:AfterLogin>
    