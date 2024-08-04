<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="m"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="v"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>

<m:AfterLogin title="Cancel Visa">
	<jsp:attribute name="header">
<link rel="stylesheet"
			href="${pageContext.request.contextPath}/styles/CancelVisa.css">
<script
			src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script>
	$(function() {
		$("#popupbutton").click(function() {
			$("#popup").hide();
		});
	});
	$(function() {
		var passportid = ($("#passportId").val());

		$
				.ajax({
					type : "get",
					url : "http://localhost:9090/getvisapassport/" + passportid,
					dataType : "json",
					contentType : "application/json;charset=utf-8",
					success : function(msg) {
						if (msg.length != 0) {

							$("#select").append(

							"<option value='' label='Select'></option>");

							for (var i = 0; i < msg.length; i++) {
								var option = "<option value =" + msg[i].visaId +" id= "+msg[i].visaId +">"
										+ msg[i].visaId + "</option>";
								$("#select").append(option);
							}

							$('#select').click(
									function() {

										var id = $("#select").val();
										for (var i = 0; i < msg.length; i++) {
											if (id == msg[i].visaId) {
												$("#issueDate").val(
														msg[i].issueDate)
														.append();
												$("#country").val(
														msg[i].country)
														.append();
											}
										}

									});
						}

					},

				});

	});
</script>

</jsp:attribute>

	<jsp:attribute name="content">
	<v:if test="${price != null }">
		<div
				style="display: flex; justify-content: center; background-color: #f0f0f0; align-items: center;"
				id="popup">
			<img src="${pageContext.request.contextPath}/images/profile.jpg"
					style="width: 100px; height: 100px; border-radius: 50%;">
			<div style="text-align: center;">
				<h5>Your Request has been submitted successfully. Please pay
					${price} to complete the visa cancellation process.</h5>
				<input type="button" id="popupbutton" value="Close"
						class="btn btn-danger" style="margin: 5px;">
			</div>
		</div>
	</v:if>
 
 
	<div class="form-container">
		<div class="form-wrapper">
			<f:form action="CancelVisaForm" id="Form" modelAttribute="visa">
				<h2 align="center" style="font-family: auto;font-weight: 600;color: #1d3963;margin-bottom: 6%; margin-right: 4%;">Visa
					Cancellation</h2>
				<v:if test="${msg!=null}">
					<v:out value="${msg }"></v:out>
				</v:if>
 
				<table id="tdata">
					<tr>
						<td class="text-styling">User Id</td>
						<td><f:input path="userId" type="text" id="userId"
									value="${userId}" disabled="true" />  </td>
					
 
					</tr>
					<tr>
						<td class="text-styling">Passport Id</td>
						<td><f:input path="passportId" type="text" id="passportId"
									name="passportId" value="${passportId}" disabled="true" /></td>
					</tr>
 
					<tr>
						<td class="text-styling">Visa Id</td>
						<td><f:select path="visaId" id="select" name="visaId"></f:select>
						</td>
 
						<td><f:errors path="visaId"
									cssStyle="color:red;  font-size: 12px; font-family: serif;  "></f:errors>
						</td>
 
					</tr>
					<tr>
						<td class="text-styling">Visa Issue Date</td>
						<td><f:input path="issueDate" type="date" id="issueDate"
									disabled="true" /></td>
					</tr>
					<tr>
						<td class="text-styling">Visa Applied Country</td>
						<td><f:input path="country" type="text" id="country"
									disabled="true" /></td>
					</tr>
					<tr>
					
						<tr>
						<td></td>
						<td><input id="submit_btn" class="btn btn-large"
								type="submit"
								style="background-color: rgb(0, 64, 128); color: white;"
								value="Cancel Visa"></td>
					</tr>
 
				</table>
			</f:form>
		</div>
	</div>
	</jsp:attribute>
</m:AfterLogin>