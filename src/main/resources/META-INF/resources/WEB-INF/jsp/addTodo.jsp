<%@ include file="common/header.jspf" %>
<%@ include file="common/navigator.jspf" %>

<div class="container">

    <h1>Enter Todo Details</h1>

    <form:form method="post" modelAttribute="todo">
        <fieldset class="mb-3">
            <form:label path="descr">Description</form:label>
            <form:input type="text" path="descr" required="required"/>
            <form:errors path="descr" cssClass="text-warning"/>
        </fieldset>


        <fieldset class="mb-3">
            <form:label path="targetDate">Target Date</form:label>
            <form:input type="text" path="targetDate" required="required"/>
            <form:errors path="targetDate" cssClass="text-warning"/>
        </fieldset>


        <form:input type="hidden" path="id"/>

        <form:input type="hidden" path="done"/>

        <input type="submit" class="btn btn-success"/>

    </form:form>

</div>

<%@ include file="common/footer.jspf" %>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/css/bootstrap-datepicker.min.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/locales/bootstrap-datepicker.es.min.js"></script>

<script type="text/javascript">
    $(document).ready(function() {
        $('#targetDate').datepicker({
            format: 'yyyy-mm-dd'
        });
    });
</script>