<%@ include file="../common/header.jspf"%>
<%@ include file="../common/navigation.jspf"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="container">
	New Actor:
	<form:form id="createActorForm" method="POST" action="/new" modelAttribute="actors">
		<fieldset class="form-group">
			<label>First name</label> <input name="firstName" type="text" class="form-control" /> <BR />
		</fieldset>
		<fieldset class="form-group">
			<label>Last name</label> <input name="lastName" type="text" class="form-control" /> <BR />
		</fieldset>
		<input name="addActor" type="submit" class="btn btn-success" value="Add" />
		<input name="cancelActor" type="submit" class="btn btn-success" value="Cancel"/>
	</form:form>
</div>

<%@ include file="../common/footer.jspf"%>