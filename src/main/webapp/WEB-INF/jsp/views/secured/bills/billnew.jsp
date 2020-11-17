<%@ include file="../../../commontags.jsp"%>
<spring:url var="postUrl" value="/secured/bill/new" />

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
					<form:button id="saveBtn" name="action" value="save" class="btn btn-primary ripple-surface mb-0"><spring:message code="button.save" /></form:button>
					<form:button id="backBtn" name="action" value="back" class="btn btn-primary ripple-surface mb-0"><spring:message code="button.back" /></form:button>
				</div>
			</div>
		</div>

	</form:form>
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
	});
	
</script>