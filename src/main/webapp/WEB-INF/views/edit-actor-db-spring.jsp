<%@ include file="../common/header.jspf"%>
<%@ include file="../common/navigation.jspf"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="container">
	Edit Actor:
	<form:form method="POST" action="/edit" modelAttribute="actor">
		<input type="hidden" name="actorId" value="${actor.actorId}" />
		<fieldset class="form-group">
			<label>First name</label> <input name="firstName" type="text" class="form-control" value="${actor.firstName}" /> <BR />
		</fieldset>
		<fieldset class="form-group">
			<label>Last name</label> <input name="lastName" type="text" class="form-control" value="${actor.lastName}"/> <BR />
		</fieldset>
		<input name="saveActor" type="submit" class="btn btn-success" value="Save" />
		<input name="cancelActor" type="submit" class="btn btn-success" value="Cancel"/>
	</form:form>
</div>

<%@ include file="../common/footer.jspf"%>