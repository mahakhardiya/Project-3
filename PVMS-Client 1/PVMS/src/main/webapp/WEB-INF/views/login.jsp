<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="m"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<m:Master title="Login">

	<jsp:attribute name="header">
	<script src="https://kit.fontawesome.com/0806e80215.js"
			crossorigin="anonymous"></script>
			<script> window.forward();</script>
<style>
.error {
	color: red;
}

.btn-lg:hover {
	background-color: #292b2c;
}

.divider:after, .divider:before {
	content: "";
	flex: 1;
	height: 1px;
	background: #eee;
}

.h-custom {
	height: calc(100% - 73px);
}

@media ( max-width : 450px) {
	.h-custom {
		height: 100%;
	}
}
</style>

<script>


	function closePopup() {
		document.getElementById('popup').style.display = 'none';
	}
</script>
</jsp:attribute>
	<jsp:attribute name="content">
	
<h1
			style="position: absolute; left: 45%; top: 11%; font-family: emoji; color: #1d3963; font-weight: bold; border-bottom: 2px solid currentColor;">Login</h1>
	
<f:form action="loginValidate" modelAttribute="loginU" method="POST">
<section class="vh-100">
  <div class="container-fluid h-custom">
    <div
						class="row d-flex justify-content-center align-items-center h-100">
      <div class="col-md-9 col-lg-6 col-xl-5">
        <img
								src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-login-form/draw2.webp"
								class="img-fluid" alt="Sample image">
      </div>
      <div class="col-md-8 col-lg-6 col-xl-4 offset-xl-1">
        <form>
          <div
									class="d-flex flex-row align-items-center justify-content-center justify-content-lg-start">
            <p class="lead fw-normal mb-0 me-3">Sign in with</p>
            <button type="button"
										class="btn btn-primary btn-floating mx-1">
              <i class="fab fa-facebook-f"></i>
            </button>

            <button type="button"
										class="btn btn-primary btn-floating mx-1">
              <i class="fab fa-twitter"></i>
            </button>

            <button type="button"
										class="btn btn-primary btn-floating mx-1">
              <i class="fab fa-linkedin-in"></i>
            </button>
          </div>

          <div class="divider d-flex align-items-center my-4">
            <p class="text-center fw-bold mx-3 mb-0">Or</p>
          </div>
			<h5 style="color: red;font-family: auto;">${error}</h5>
          <!-- Email input -->
          <div class="form-outline mb-4">
            <f:input path="userId" id="form3Example3"
										class="form-control form-control-lg"
										placeholder="Enter a valid userId address" />
            <label class="form-label" for="form3Example3">User Id</label>
            <f:errors path="userId" cssClass="error"></f:errors>
          </div>

          <!-- Password input -->
          <div class="form-outline mb-3">
            <f:input type="password" path="password" id="form3Example4"
										class="form-control form-control-lg"
										placeholder="Enter password" />
            <label class="form-label" for="form3Example4">Password</label>
            <f:errors path="password" cssClass="error"></f:errors>
          </div>

          <div class="d-flex justify-content-between align-items-center">
            <!-- Checkbox -->
            <div class="form-check mb-0">
              <input class="form-check-input me-2" type="checkbox"
											value="" id="form2Example3" />
              <label class="form-check-label" for="form2Example3">
                Remember me
              </label>
            </div>
            
          </div>

          <div class="text-center text-lg-start mt-4 pt-2">
            <input type="submit" class="btn btn-primary btn-lg"
										style="padding-left: 2.5rem; padding-right: 2.5rem;"
										value="Login">
									
            <p class="small fw-bold mt-2 pt-1 mb-0">Don't have an account? <a
											href="./register" class="link-danger">Register</a>
								</p>
          </div>

        </form>
      </div>
    </div>
  </div>
  <div>
    

    <!-- Right -->
    <div>
      <a href="#!" class="text-white me-4">
        <i class="fa-brands fa-facebook"></i>
      </a>
      <a href="#!" class="text-white me-4">
        <i class="fab fa-twitter"></i>
      </a>
      <a href="#!" class="text-white">
        <i class="fab fa-linkedin-in"></i>
      </a>
    </div>
    <!-- Right -->
  </div>
</section>
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

<meta http-equiv="Cache-Control" content="no-cache, no-store, must-revalidate">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Expires" content="0">
