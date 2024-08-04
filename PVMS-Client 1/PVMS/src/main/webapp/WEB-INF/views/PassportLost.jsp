<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="m"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<m:AfterLogin title="Passport Lost">
    <jsp:attribute name="header">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/Places.js" type="module"></script>     
<link rel="stylesheet" href="${pageContext.request.contextPath}/styles/RenewalForm.css" />
    </jsp:attribute>
    <jsp:attribute name="content" >
     <div class="form-container" >
        <div class="form-wrapper" >
        <form:form  modelAttribute="passportLost" >
    	<h2 align="center" style="font-family:'Merriweather Sans',sans-serif;">Passport Lost Form</h2>
            <table >
          		<tr>
          			<td>User ID</td>
          			<td><input value="${userId}" disabled="disabled"/></td>
          		</tr>
                <tr>
                    <td>State:</td>
                    <td>
                        <form:select path="state" id="state"></form:select>  </td>
                     <td>    <form:errors path="state" cssClass="error"></form:errors>
                    </td>
                </tr>
                <tr>
                    <td>City:</td>
                    <td>
                        <form:select path="city" id="city" ></form:select>  </td>
                      <td>  <form:errors path="city" cssClass="error"></form:errors>
                    </td>
                </tr>
                <tr>
                    <td>Pincode:</td>
                    <td>
                        <form:select path="pincode" id="pincode"></form:select></td>
                      <td><form:errors path="pincode" cssClass="error"></form:errors>
                    </td>
                </tr>
                <tr>
          			<td>Type Of Service</td>
          			<td>
          			<form:radiobutton path="typeOfService" value="Normal" cssClass="form-check-input" cssStyle="margin-right:5px;"/>Normal 
          			<form:radiobutton path="typeOfService" value="Tatkal" cssClass="form-check-input" cssStyle="margin-right:5px;"/>Tatkal</td>
          			<td><form:errors path="typeOfService" cssClass="error"></form:errors>
          			</td>
          		</tr>
          		<tr>
          			<td>BookletType</td>
          			<td>
          			<form:radiobutton path="bookletType" value="30" cssClass="form-check-input" cssStyle="margin-right:5px;" label="30 Pages "/>
          			<form:radiobutton path="bookletType" value="60" cssClass="form-check-input" cssStyle="margin-right:5px;padding-left:10px;" label=" 60 Pages" /></td>
          			<td><form:errors path="bookletType" cssClass="error" cssStyle="red"></form:errors>
          			</td>
          		</tr>
                <tr>
                <td></td>
                    <td ><button class="btn btn-large" type="submit"  id="submit-button" style="background-color: rgb(0, 64, 128);color: white;" formaction="ValidatePassportLost">Submit</button></td>
                </tr>
            </table>
        </form:form>
         </div>
    </div>

    </jsp:attribute>
</m:AfterLogin>
