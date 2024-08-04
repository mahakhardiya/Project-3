<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="m"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<m:Master title="updatePassword">

	<jsp:attribute name="header">
<style>
.divider:after, .divider:before {
	content: "";
	flex: 1;
	height: 1px;
	background: #eee;
}

.error {
	color: red;
}

h2 {
	font-family: auto;
	position: absolute;
	top: 36.5%;
	left: 56.5%;
	border-bottom: 2Px solid;
	color: #1d3963;
}
</style>
	
</jsp:attribute>
	<jsp:attribute name="content">
	<h2>Update Password</h2>
<section class="vh-100">
  <div class="container py-5 h-100">
    <div
					class="row d-flex align-items-center justify-content-center h-100">
      <div class="col-md-8 col-lg-7 col-xl-6">
        <img
							src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-login-form/draw2.svg"
							class="img-fluid" alt="Phone image">
      </div>
      <div class="col-md-7 col-lg-5 col-xl-5 offset-xl-1">
        <f:form action="updateValidate" modelAttribute="upu">
          <!-- Email input -->
          <div class="form-outline mb-4">
           <h4 style="padding-top: 20px;">User ID :${userId}</h4>
          
          </div>
          <div class="form-outline mb-4">
          <f:errors path="newPassword" cssClass="error"></f:errors>
            <f:input type="password" path="newPassword"
									id="form1Example13" class="form-control form-control-lg" />
            <label class="form-label" for="form1Example13"
									style="font-weight: 500;">New Password</label>
          </div>

          <!-- Password input -->
          <div class="form-outline mb-4">
          	<f:errors path="confirmPassword" cssClass="error"></f:errors>
          	<br>
          	<f:errors path="" cssClass="error"></f:errors>
            <f:input type="password" id="form1Example23"
									class="form-control form-control-lg" path="confirmPassword" />
            <label class="form-label" for="form1Example23"
									style="font-weight: 500;">Confirm Password</label>
          </div>

         

          <!-- Submit button -->
          <input type="submit" class="btn btn-primary btn-lg btn-block"
								value="Submit">
        </f:form>
      </div>
    </div>
  </div>
</section>

</jsp:attribute>

</m:Master>
