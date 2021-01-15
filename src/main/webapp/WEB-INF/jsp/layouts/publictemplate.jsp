<%@ include file="../commontags.jsp"%>

<!DOCTYPE html>
<html lang="en">

	<!--begin::Head-->
	<head><base href="/resources/../../../">
		<meta charset="utf-8" />
		<title>DAFTAR BIL</title>
		<meta name="description" content="Login page example" />
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />


		<!--begin::Page Custom Styles(used by this page)-->
		<link rel="stylesheet" type="text/css" href="<spring:url value="/resources/assets/css/pages/users/login-3.css"/>" />
		
		<!--end::Page Custom Styles-->
		<!--begin::Global Theme Styles(used by all pages)-->
		<link rel="stylesheet" type="text/css" href="<spring:url value="/resources/assets/plugins/global/plugins.bundle.css"/>" />
		<link rel="stylesheet" type="text/css" href="<spring:url value="/resources/assets/plugins/custom/prismjs/prismjs.bundle.css"/>" />
		<link rel="stylesheet" type="text/css" href="<spring:url value="/resources/assets/css/style.bundle.css"/>" />
		<!--end::Global Theme Styles-->
		
		<!--begin::Layout Themes(used by all pages)-->
		<link rel="stylesheet" type="text/css" href="<spring:url value="/resources/assets/css/themes/layout/header/base/light.css"/>" />
		<link rel="stylesheet" type="text/css" href="<spring:url value="/resources/assets/css/themes/layout/header/menu/light.css"/>" />
		<link rel="stylesheet" type="text/css" href="<spring:url value="/resources/assets/css/themes/layout/brand/dark.css"/>" />
		<link rel="stylesheet" type="text/css" href="<spring:url value="/resources/assets/css/themes/layout/aside/dark.css"/>" />
		<!--end::Layout Themes-->
		
		<link rel="image" type="text/css" href="<spring:url value="/resources/assets/images/favicon.png"/>" />
	</head>
	<!--end::Head-->
	
	<!--begin::Body-->
	<body id="kt_body" class="header-fixed header-mobile-fixed subheader-enabled subheader-fixed aside-enabled aside-fixed aside-minimize-hoverable page-loading">
		<!--begin::Main-->
		<div class="d-flex flex-column flex-root">
			
			<!-- Begin page content -->
			<main class="content d-flex flex-column flex-column-fluid">
				<div class="d-flex flex-column-fluid">
					<tiles:insertAttribute name="body" />
				</div>
			</main>
			<!--end::page content-->
			
		</div>
		<!--end::Main-->
		
		
		<!--begin::Global Config(global config for global JS scripts)-->
		<script>var KTAppSettings = { "breakpoints": { "sm": 576, "md": 768, "lg": 992, "xl": 1200, "xxl": 1200 }, "colors": { "theme": { "base": { "white": "#ffffff", "primary": "#6993FF", "secondary": "#E5EAEE", "success": "#1BC5BD", "info": "#8950FC", "warning": "#FFA800", "danger": "#F64E60", "light": "#F3F6F9", "dark": "#212121" }, "light": { "white": "#ffffff", "primary": "#E1E9FF", "secondary": "#ECF0F3", "success": "#C9F7F5", "info": "#EEE5FF", "warning": "#FFF4DE", "danger": "#FFE2E5", "light": "#F3F6F9", "dark": "#D6D6E0" }, "inverse": { "white": "#ffffff", "primary": "#ffffff", "secondary": "#212121", "success": "#ffffff", "info": "#ffffff", "warning": "#ffffff", "danger": "#ffffff", "light": "#464E5F", "dark": "#ffffff" } }, "gray": { "gray-100": "#F3F6F9", "gray-200": "#ECF0F3", "gray-300": "#E5EAEE", "gray-400": "#D6D6E0", "gray-500": "#B5B5C3", "gray-600": "#80808F", "gray-700": "#464E5F", "gray-800": "#1B283F", "gray-900": "#212121" } }, "font-family": "Poppins" };</script>
		<!--end::Global Config-->
		<!--begin::Global Theme Bundle(used by all pages)-->
		<script src="<spring:url value="/resources/assets/plugins/global/plugins.bundle.js"/>"></script>
		<script src="<spring:url value="/resources/assets/plugins/custom/prismjs/prismjs.bundle.js"/>"></script>
		<script src="<spring:url value="/resources/assets/js/scripts.bundle.js"/>"></script>

		<!--end::Global Theme Bundle-->
		<!--begin::Page Scripts(used by this page)-->
		<script src="<spring:url value="/resources/assets/js/pages/custom/login/login.js"/>"></script>
		<script src="https://ajax.aspnetcdn.com/ajax/jquery.validate/1.16.0/jquery.validate.min.js"></script>
		<!--end::Page Scripts-->
		
	</body>
	<!--end::Body-->

</html>

