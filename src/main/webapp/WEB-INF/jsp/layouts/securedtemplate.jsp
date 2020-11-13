<%@ include file="../commontags.jsp"%>

<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="description" content="Sistem Daftar Bil-NEXT">
	<meta name="keywords" content="Sistem Daftar Bil">
	<meta name="_csrf" content="${_csrf.token}" />
    <meta name="_csrf_header" content="${_csrf.headerName}" />
	<title><tiles:getAsString name="title" /></title>
	
	<!--begin::Fonts-->
	<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Poppins:300,400,500,600,700" />
	<!--end::Fonts-->
	
	<!--begin::Page Vendors Styles::Datatables-->
	<link href="/resources/assets/plugins/custom/datatables/datatables.bundle.css" rel="stylesheet" type="text/css" />
	<!--end::Page Vendors Styles::Datatables-->
	
	<!--begin::Global Theme Styles(used by all pages)-->
	<link href="/resources/assets/plugins/global/plugins.bundle.css" rel="stylesheet" type="text/css" />
	<link href="/resources/assets/plugins/custom/prismjs/prismjs.bundle.css" rel="stylesheet" type="text/css" />
	<link href="/resources/assets/css/style.bundle.css" rel="stylesheet" type="text/css" />
	<link href="/resources/assets/css/custom-style.css" rel="stylesheet" type="text/css" />
	<!--end::Global Theme Styles-->
	
	<!--begin::Layout Themes(used by all pages)-->
	<link href="/resources/assets/css/themes/layout/header/base/light.css" rel="stylesheet" type="text/css" />
	<link href="/resources/assets/css/themes/layout/header/menu/light.css" rel="stylesheet" type="text/css" />
	<link href="/resources/assets/css/themes/layout/brand/dark.css" rel="stylesheet" type="text/css" />
	<link href="/resources/assets/css/themes/layout/aside/dark.css" rel="stylesheet" type="text/css" />
	<!--end::Layout Themes-->
	
	<link rel="icon" href="/resources/assets/images/favicon.png" type="image/png" sizes="16x16">
	
	<!--begin::Global Theme Bundle(used by all pages)-->
	<script src="/resources/assets/plugins/global/plugins.bundle.js"></script>
	<script src="/resources/assets/plugins/custom/prismjs/prismjs.bundle.js"></script>
	<script src="/resources/assets/js/scripts.bundle.js"></script>
	<!--end::Global Theme Bundle-->
</head>
<!--end::Head-->

<!--begin::Body-->
<body id="kt_body"
	class="header-fixed header-mobile-fixed aside-enabled aside-fixed aside-minimize-hoverable page-loading">

		<!--begin::Wrapper-->
		<div class="d-flex flex-column flex-row-fluid wrapper" id="kt_wrapper">
			<!--begin::Header-->
			<div id="kt_header" class="header header-fixed">
				<!--begin::Container-->
				<div class="container-fluid d-flex align-items-stretch justify-content-between">
				
					<!--begin::Header Menu Wrapper-->
					<div class="header-menu-wrapper header-menu-wrapper-left" id="kt_header_menu_wrapper">
						<!--begin::Header Menu-->
						<div id="kt_header_menu"
							class="header-menu header-menu-mobile header-menu-layout-default">
							<!--begin::Header Nav-->
							<ul class="menu-nav">
								<li class="menu-item menu-item-submenu menu-item-rel" data-menu-toggle="click" aria-haspopup="true">
									<a href="javascript:;" class="menu-link menu-toggle"> 
										<span class="menu-text">Apps</span> <i class="menu-arrow"></i>
									</a>
								</li>
							</ul>
							<!--end::Header Nav-->
						</div>
						<!--end::Header Menu-->
					</div>
					<!--end::Header Menu Wrapper-->
					
					<!--begin::Topbar-->
					<div class="topbar">
						
						<!--begin::User-->
						<div class="topbar-item">
							<div
								class="btn btn-icon w-auto btn-clean d-flex align-items-center btn-lg px-2"
								id="kt_quick_user_toggle">
								<span
									class="text-muted font-weight-bold font-size-base d-none d-md-inline mr-1">Hi,</span>
								<span
									class="text-dark-50 font-weight-bolder font-size-base d-none d-md-inline mr-3">{user}</span>
								<span class="symbol symbol-35 symbol-light-success"> 
									<span class="symbol-label font-size-h5 font-weight-bold">U</span>
								</span>
							</div>
						</div>
						<!--end::User-->
					</div>
					<!--end::Topbar-->
				</div>
				<!--end::Container-->
			</div>
			<!--end::Header-->
			
			<!--begin::Side Menu-->
			<div class="aside aside-left aside-fixed d-flex flex-column flex-row-auto" id="kt_aside">
				<jsp:include page="../views/secured/menu.jsp" />
			</div>
			<!--end::Side Menu-->
			
			<!-- Begin page content -->
			<main class="content d-flex flex-column flex-column-fluid">
				<div class="d-flex flex-column-fluid">
					<tiles:insertAttribute name="body" />
				</div>
			</main>
		</div>
		<!--end::Wrapper-->

	<!--begin::Global Config(global config for global JS scripts)-->
	<script>
		var KTAppSettings = {
			"breakpoints" : {
				"sm" : 576,
				"md" : 768,
				"lg" : 992,
				"xl" : 1200,
				"xxl" : 1200
			},
			"colors" : {
				"theme" : {
					"base" : {
						"white" : "#ffffff",
						"primary" : "#6993FF",
						"secondary" : "#E5EAEE",
						"success" : "#1BC5BD",
						"info" : "#8950FC",
						"warning" : "#FFA800",
						"danger" : "#F64E60",
						"light" : "#F3F6F9",
						"dark" : "#212121"
					},
					"light" : {
						"white" : "#ffffff",
						"primary" : "#E1E9FF",
						"secondary" : "#ECF0F3",
						"success" : "#C9F7F5",
						"info" : "#EEE5FF",
						"warning" : "#FFF4DE",
						"danger" : "#FFE2E5",
						"light" : "#F3F6F9",
						"dark" : "#D6D6E0"
					},
					"inverse" : {
						"white" : "#ffffff",
						"primary" : "#ffffff",
						"secondary" : "#212121",
						"success" : "#ffffff",
						"info" : "#ffffff",
						"warning" : "#ffffff",
						"danger" : "#ffffff",
						"light" : "#464E5F",
						"dark" : "#ffffff"
					}
				},
				"gray" : {
					"gray-100" : "#F3F6F9",
					"gray-200" : "#ECF0F3",
					"gray-300" : "#E5EAEE",
					"gray-400" : "#D6D6E0",
					"gray-500" : "#B5B5C3",
					"gray-600" : "#80808F",
					"gray-700" : "#464E5F",
					"gray-800" : "#1B283F",
					"gray-900" : "#212121"
				}
			},
			"font-family" : "Poppins"
		};
	</script>
	<!--end::Global Config-->
	<script src="/resources/assets/js/pages/crud/forms/widgets/select2.js"></script>
	<script src="/resources/assets/plugins/custom/datatables/datatables.bundle.js"></script>
	<script src="/resources/assets/js/pages/crud/datatables/basic/basic.js"></script>
</body>
<!--end::Body-->

</html>

