<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="m"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<m:Master title="Registration">

	<jsp:attribute name="header">
        <style>
body {
	font-family: Arial, sans-serif;
	margin: 0;
	padding: 0;
	background-color: #fff;
	/* background-image: url('${pageContext.request.contextPath}/images/bg-img.jpg'); */
}

.error {
	color: red;
}

.styling {
	font-weight: 600;
}

#container {
	display: flex;
	justify-content: center;
	align-items: flex-start;
	box-shadow: rgb(131 180 243/ 20%) 0px 7px 20px 10px;
	margin: 5% 17.5%;
	padding-bottom: 4%;
	border-radius: 4.5%;
}

.form-group {
	margin: 10px;
	margin-top: 165px;
}

table {
	width: 100%;
}

.btn-primary:hover {
	background-color: #292b2c;
}
</style>

<script>
	function closePopup() {
		document.getElementById('popup').style.display = 'none';
	}
</script>

<script src="https://www.google.com/recaptcha/api.js" async defer></script>

    </jsp:attribute>

	<jsp:attribute name="content">
        <f:form action="UserValidate" modelAttribute="url"
			style="width:90%;">
            <div id="container">
        <h1 class="title"
					style="position: absolute; left: 37.5%; top: 19.5%; font-family: emoji; color: #1d3963; font-weight: bold; border-bottom: 2px solid currentColor;">Register Now</h1>    
                <div class="form-group" style="margin-left: 9%;">
                    <table cellpadding="5px">
                        <tr>
                            <td class="styling">First Name</td>
                            <td><f:input path="firstName" /></td>
                        </tr>
                        <tr>
                            <td></td>
                            <td><f:errors path="firstName"
									cssClass="error"></f:errors></td>
                        </tr>
                        <tr>
                            <td class="styling">Surname</td>
                            <td><f:input path="surname" /></td>
                        </tr>
                        <tr>
                            <td></td>
                            <td><f:errors path="surname"
									cssClass="error"></f:errors></td>
                        </tr>
                        <tr>
                            <td class="styling">Date Of Birth</td>
                            <td><f:input path="dateOfBirth"
									type="date" /></td>
                        </tr>
                        <tr>
                            <td></td>
                            <td> <f:errors path="" cssClass="error"></f:errors> <f:errors
									path="dateOfBirth" cssClass="error"></f:errors> </td>
                        </tr>
                        <tr>
                            <td class="styling">Contact Number</td>
                            <td><f:input path="contactNumber" /></td>
                        </tr>
                        <tr>
                            <td></td>
                            <td><f:errors path="contactNumber"
									cssClass="error"></f:errors></td>
                        </tr>
                        <tr>
                            <td class="styling">Email</td>
                            <td><f:input path="email" /></td>
                        </tr>
                        <tr>
                            <td></td>
                            <td><f:errors path="email"
									cssClass="error"></f:errors></td>
                        </tr>
                        <tr>
                            <td class="styling">Gender</td>
                            <td>
                                <f:radiobutton path="gender"
									value="Male" /> Male
                                <f:radiobutton path="gender"
									value="Female" /> Female
                                <f:radiobutton path="gender"
									value="Others" /> Others
                            </td>
                        </tr>
                        <tr>
                            <td></td>
                            <td><f:errors path="gender"
									cssClass="error"></f:errors></td>
                        </tr>
                        
                        <tr>
                        <td style="color: red;">${Error}</td>
                        <td>  <div class="g-recaptcha"
									data-sitekey="6Le-ImopAAAAAOZVRgX0QuuQd-2ySFN40uCuGHbD"></div>
									</td>
                        </tr>
                        <tr>
                            <td></td>
                            <td></td>
                            <td>
                                <input class="btn btn-large"
								type="submit"
								style="background-color: rgb(0, 64, 128); color: white;">
                            </td>
                        </tr>
                    </table>
                </div>
                <div class="form-group" style="padding-right: 10%;">
                    <table cellpadding="5px">
                        <tr>
                            <td class="styling">Qualification</td>
                            <td>
                                <f:select path="qualification">
                                    <f:option value="">Select</f:option>
                                    <f:option value="High School">High School</f:option>
                                    <f:option value="Intermediate">Intermediate</f:option>
                                    <f:option value="Graduate">Graduate</f:option>
                                    <f:option value="Post Graduate">Post Graduate</f:option>
                                </f:select>
                            </td>
                        </tr>
                        <tr>
                            <td></td>
                            <td><f:errors path="qualification"
									cssClass="error"></f:errors></td>
                        </tr>
                        <tr>
                            <td class="styling">Address</td>
                            <td> <f:textarea path="address"
									rows="4" cols="30" /> </td>
                        </tr>
                        <tr>
                            <td></td>
                            <td><f:errors path="address"
									cssClass="error"></f:errors></td>
                        </tr>
                        <tr>
                            <td class="styling">Hint Question</td>
                            <td>
                                <f:select path="hintQuestion">
                                    <f:option value="">Select</f:option>
                                    <f:option
										value="In which city you were born">In which city you were born?</f:option>
                                    <f:option
										value="What is your first pet name">What is your first pet name?</f:option>
                                    <f:option
										value="What is your favorite book name">What is your favorite book name?</f:option>
                                    <f:option
										value="What is your first school name">What is your first school name?</f:option>
                                </f:select>
                            </td>
                        </tr>
                        <tr>
                            <td></td>
                            <td><f:errors path="hintQuestion"
									cssClass="error"></f:errors></td>
                        </tr>
                        <tr>
                            <td class="styling">Hint Answer</td>
                            <td> <f:input path="hintAnswer" /></td>
                        </tr>
                        <tr>
                            <td></td>
                            <td><f:errors path="hintAnswer"
									cssClass="error"></f:errors></td>
                        </tr>
                    </table>
                </div>
            </div>
        </f:form>
        
        <c:if test="${msg!= null}">
    <div
				style="display: flex; justify-content: center; background-color: #f0f0f0; align-items: center;"
				id="popup">
        <div style="text-align: center;">
            <h5>${msg}</h5>
            <input type="button" id="popupbutton" value="Close"
						class="btn btn-danger" onclick="closePopup();"
						style="margin: 5px;">
        </div>
    </div>
</c:if>
    </jsp:attribute>

</m:Master>