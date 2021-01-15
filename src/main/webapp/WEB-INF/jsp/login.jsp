<%@ include file="commontags.jsp"%>

<spring:url var="postUrl" value="/auth/signin" />
<spring:url var="registrationUrl" value="/auth/signup" />

<!--begin::Login-->
<div class="login login-signin-on login-3 d-flex flex-row-fluid" id="kt_login">
	<div class="d-flex flex-center flex-row-fluid bgi-size-cover bgi-position-top bgi-no-repeat" style="background-image: url(<spring:url value="/resources/assets/media/bg/bg-3.jpg"/>);">
		<div class="login-form text-center p-7 position-relative overflow-hidden">
			<!--begin::Login Header-->
			<div class="d-flex flex-center mb-15">
				<a href="#">
					<img src="<spring:url value="/resources/assets/media/logos/tea.png"/>" class="max-h-75px" alt="" />
				</a>
			</div>
			<!--end::Login Header-->
			
			<!--begin::Login Sign in form-->
			<div class="login-signin">
				<div class="mb-20">
					<h3>Sign In</h3>
					<div class="text-muted font-weight-bold">Enter your details to login to your account:</div>
				</div>
				<form:form id="loginForm" modelAttribute="loginForm" action="${postUrl}" class="form">
					<div class="form-group mb-5">
						<input class="form-control h-auto form-control-solid py-4 px-8" type="text" placeholder="Username" name="username" autocomplete="off" />
					</div>
					<div class="form-group mb-5">
						<input class="form-control h-auto form-control-solid py-4 px-8" type="password" placeholder="Password" name="password" />
					</div>
					<div class="form-group d-flex flex-wrap justify-content-between align-items-center">
						<label class="checkbox m-0 text-muted">
						<input type="checkbox" name="remember" />Remember me
						<span></span></label>
						<a href="javascript:;" id="kt_login_forgot" class="text-muted text-hover-primary">Forget Password ?</a>
					</div>
					<form:button id="kt_login_signin_submit" name="action" value="signin" class="btn btn-primary font-weight-bold px-9 py-4 my-3 mx-4"><spring:message code="button.signin" /></form:button>
				</form:form>
				<div class="mt-10">
					<span class="opacity-70 mr-4">Don't have an account yet?</span>
					<a href="javascript:;" id="kt_login_signup" class="text-muted text-hover-primary font-weight-bold">Sign Up!</a>
				</div>
			</div>
			<!--end::Login Sign in form-->
			
			<!--begin::Login Sign up form-->
			<div class="login-signup">
				<div class="mb-20">
					<h3>Sign Up</h3>
					<div class="text-muted font-weight-bold">Enter your details to create your account</div>
				</div>
				<form:form id="registrationForm" modelAttribute="registrationForm" action="${registrationUrl}" class="form">
					<div class="form-group mb-5">
						<input class="form-control h-auto form-control-solid py-4 px-8" type="text" placeholder="Fullname" name="fullname" />
					</div>
					<div class="form-group mb-5">
						<input class="form-control h-auto form-control-solid py-4 px-8" type="text" placeholder="Email" name="email" autocomplete="off" />
					</div>
					<div class="form-group mb-5">
						<input class="form-control h-auto form-control-solid py-4 px-8" type="password" placeholder="Password" name="password" />
					</div>
					<div class="form-group mb-5">
						<input class="form-control h-auto form-control-solid py-4 px-8" type="password" placeholder="Confirm Password" name="rpassword" />
					</div>
					<div class="form-group mb-5 text-left">
						<label class="checkbox m-0">
						<input type="checkbox" name="agree" />I Agree the
						<a href="#" class="font-weight-bold">terms and conditions</a>.
						<span></span></label>
						<div class="form-text text-muted text-center"></div>
					</div>
					<div class="form-group d-flex flex-wrap flex-center mt-10">
						<button id="kt_login_signup_submit" class="btn btn-primary font-weight-bold px-9 py-4 my-3 mx-2">Sign Up</button>
						<button id="kt_login_signup_cancel" class="btn btn-light-primary font-weight-bold px-9 py-4 my-3 mx-2">Cancel</button>
					</div>
				</form:form>
			</div>
			<!--end::Login Sign up form-->
			
			<!--begin::Login forgot password form-->
			<div class="login-forgot">
				<div class="mb-20">
					<h3>Forgotten Password ?</h3>
					<div class="text-muted font-weight-bold">Enter your email to reset your password</div>
				</div>
				<form class="form">
					<div class="input-group mb-10">
						<input class="form-control h-auto form-control-solid py-4 px-8" type="text" placeholder="Email" name="email" id="kt_email" autocomplete="off" />
					</div>
					<div class="form-group d-flex flex-wrap flex-center mt-10">
						<button id="kt_login_forgot_submit" class="btn btn-primary font-weight-bold px-9 py-4 my-3 mx-2">Request</button>
						<button id="kt_login_forgot_cancel" class="btn btn-light-primary font-weight-bold px-9 py-4 my-3 mx-2">Cancel</button>
					</div>
				</form>
			</div>
			<!--end::Login forgot password form-->
		</div>
	</div>
</div>
<!--end::Login-->