<%@ include file="../../../commontags.jsp"%>
<spring:url var="postUrl" value="/secured/bill" />

<div class="container">

	<form:form id="billForm" modelAttribute="billForm" action="${postUrl}">

		<form:errors element="div" cssClass="errorblock" path="*" />

		<div class="row">
			<div class="card card-custom gutter-b col-md-12" data-card="true" data-card-tool="toggle">
				<div class="card-header">
					<div class="card-title">
						<span class="card-icon">
							<i class="flaticon2-chat-1 text-primary"></i>
						</span>
						<h3 class="card-label"><spring:message code="title.bill" /></h3>
					</div>
					<div class="card-toolbar">
						<a href="#" class="btn btn-icon btn-sm btn-light-primary mr-1" data-card-tool="toggle">
							<i class="ki ki-arrow-down icon-xs"></i>
						</a>
					</div>
				</div>

				<div class="card-body">
					<div class="form-group row">
						<label class="col-md-2 col-form-label mandatory" for="categoryCode"> 
							<spring:message code="bill.category" />
						</label>
						<div class="col-md-2">
							<form:select path="bill.billCategory" id="categoryCode" class="form-control">
								<form:option value=""><spring:message code="label.select"/></form:option>
	      						<form:options items="${billForm.categories}" itemValue="code" itemLabel="name"/>
							</form:select>
						</div>
					</div>
													
					
					<div class="form-group row">
						<label class="col-md-2 col-form-label mandatory" for="receiver"> 
							<spring:message code="bill.receiver" />
						</label>
						<div class="col-md-8">
							<form:input path="bill.receiver" id="receiver" class="form-control" />
						</div>
					</div>
					
					<div class="form-group row">
						<label class="col-md-2 col-form-label mandatory" for="amount"> 
							<spring:message code="bill.amount" />
						</label>
						<div class="col-md-2">
							<form:input path="bill.amount" id="amount" class="form-control" />
						</div>
					</div>
					
					<div class="form-group row">
						<label class="col-md-2 col-form-label mandatory" for="receiveDate"> 
							<spring:message code="bill.receivedDate" />
						</label>
						<div class="col-md-2">
							<form:input path="bill.billReceivedDate" id="receiveDate" class="form-control" />
						</div>
					</div>
					
					<div class="form-group row">
						<label class="col-md-2 col-form-label mandatory" for="reference"> 
							<spring:message code="bill.reference" />
						</label>
						<div class="col-md-8">
							<form:input path="bill.reference" id="reference" class="form-control" />
						</div>
					</div>
					
					<div class="form-group row">
						<label class="col-md-2 col-form-label mandatory" for="billDate"> 
							<spring:message code="bill.billDate" />
						</label>
						<div class="col-md-2">
							<form:input path="bill.billDate" id="billDate" class="form-control" />
						</div>
					</div>
					
					<div class="form-group row">
						<label class="col-md-2 col-form-label mandatory" for="votCode"> 
							<spring:message code="bill.votCode" />
						</label>
						<div class="col-lg-4 col-md-9 col-sm-12">
							<select class="form-control select2" id="votCode" name="bill.votCode">
								<option label="Label"></option>
							</select>
						</div>
					</div>
					
					<div class="form-group row">
						<label class="col-md-2 col-form-label mandatory" for="contractNo"> 
							<spring:message code="bill.contractNo" />
						</label>
						<div class="col-md-4">
							<form:input path="bill.contractNo" id="contractNo" class="form-control" />
						</div>
					</div>
					
					<div class="form-group row">
						<label class="col-md-2 col-form-label mandatory" for="remarks"> 
							<spring:message code="bill.remarks" />
						</label>
						<div class="col-md-8">
							<form:textarea path="bill.remarks" id="remarks" class="form-control"  />
						</div>
					</div>
				</div>

				<div class="card-footer">
					<form:button id="searchBtn" name="action" value="search" class="btn btn-primary ripple-surface mb-0"><spring:message code="button.search" /></form:button>
					<form:button id="newBtn" name="action" value="new" class="btn btn-primary ripple-surface mb-0"><spring:message code="button.new" /></form:button>
					<form:button id="backBtn" name="action" value="back" class="btn btn-primary ripple-surface mb-0"><spring:message code="button.back" /></form:button>
				</div>
			</div>
		</div>
		
	</form:form>
	
	<!--begin::Card-->
	<div class="row">
	<div class="card card-custom col-md-12" data-card="true" data-card-tool="toggle">
		<div class="card-header">
			<div class="card-title">
				<span class="card-icon">
					<i class="flaticon2-delivery-package text-primary"></i>
				</span>
				<h3 class="card-label"><spring:message code="label.list"/> <spring:message code="title.bill"/></h3>
			</div>
			<div class="card-toolbar">
				<!--begin::Dropdown-->
				<div class="dropdown dropdown-inline mr-2">
					<button type="button" class="btn btn-light-primary font-weight-bolder dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
						<i class="flaticon2-download text-dark"></i>
						<spring:message code="label.export"/>
					</button>
					<!--begin::Dropdown Menu-->
					<div class="dropdown-menu dropdown-menu-sm dropdown-menu-right">
						<!--begin::Navigation-->
						<ul class="navi flex-column navi-hover py-2">
							<li class="navi-item">
								<a href="#" class="navi-link">
									<span class="navi-icon">
										<i class="la la-print"></i>
									</span>
									<span class="navi-text">Print</span>
								</a>
							</li>
							<li class="navi-item">
								<a href="#" class="navi-link">
									<span class="navi-icon">
										<i class="la la-file-pdf-o"></i>
									</span>
									<span class="navi-text">PDF</span>
								</a>
							</li>
						</ul>
						<!--end::Navigation-->
					</div>
					<!--end::Dropdown Menu-->
				</div>
				<!--end::Dropdown-->
				<a href="#" class="btn btn-icon btn-sm btn-light-primary mr-1" data-card-tool="toggle">
					<i class="ki ki-bold-double-arrow-down icon-xs"></i>
				</a>
			</div>
		</div>
		
		<div class="card-body">			
			<!--begin: Datatable-->
			<table class="table table-bordered table-hover table-checkable" id="categories_datatable">
				<thead>
					<tr>
						<th><spring:message code="label.no"/></th>
						<th><spring:message code="bill.receiver"/></th>
						<th><spring:message code="bill.amount"/></th>
						<th><spring:message code="bill.reference"/></th>
						<th><spring:message code="bill.billDate"/></th>
						<th><spring:message code="bill.votCode"/></th>
						<th><spring:message code="bill.category"/></th>
						<th><spring:message code="bill.status"/></th> <!-- change to icon: tooltip category -->
					</tr>
				</thead>
				<tfoot>
					<tr>
					</tr>
				</tfoot>	
			</table>
			<!--end: Datatable-->
		</div>
		
	</div>
	<!--end::Card-->
	</div>
</div>
<!--end::Container-->

<script type="text/javascript">

$(document).ready(function() {
	$('#billForm').on('keyup keypress', function(e) {
		var keyCode = e.keyCode || e.which;
		if (keyCode === 13) {
			e.preventDefault();
			return false;
		}
	});
	

	$('#bill_datatable').dataTable({
        'sAjaxSource': '/secured/bills',
		"sAjaxDataProp": "",
		"order": [[ 0, "asc" ]],
        'bJQueryUI': true,
        'searching': false,
        'aoColumns': [
            { 'mData': 'receiver' },
            { 'mData': 'amount' },
            { 'mData': 'reference' },
            { 'mData': 'billDate' },
            { 'mData': 'votCode' },
            { 'mData': 'category' },
            { 'mData': 'status' }
        ]
    }); 

	var $select = $('#votCode');
	
	var $option = $('<option selected>Loading...</option>').val("C021090000000102000000000047000");

	$select.append($option).trigger('change'); // append the option and update Select2

	$.ajax({ // make the request for the selected data object
	  type: 'GET',
	  url: '/secured/dropdown/votCode',
	  dataType: 'json',
	  data: {
		 return $option.text(data.BUD_DESC).val(data.BUD_CODE)
	  }
	}).then(function (data) {
	  console.log(data);
	  $option.text(data.BUD_DESC).val(data.BUD_CODE); // update the text that is displayed (and maybe even the value)
	  $option.removeData(); // remove any caching data that might be associated
	  $select.trigger('change'); // notify JavaScript components of possible changes
	});
});

    
	
</script>