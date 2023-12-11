<%@ include file="../common/header.jspf"%>
<%@ include file="../common/navigation.jspf"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="container">
	New Category:
	<form:form id="createCategoryForm" method="POST" action="/new" modelAttribute="category">
		<fieldset class="form-group">
			<label>Name category</label> <input name="name" type="text" class="form-control" /> <BR />
		</fieldset>
		<input name="addCategory" type="submit" class="btn btn-success" value="Add" />
		<input name="cancelCategory" type="submit" class="btn btn-success" value="Cancel"/>
	</form:form>
</div>

<%@ include file="../common/footer.jspf"%>