
<%@ page import="com.placd.model.JobView" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'jobView.label', default: 'JobView')}" />
        <title><g:message code="default.edit.label" args="[entityName]" /></title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLink(uri: '/')}">Home</a></span>
            <span class="menuButton"><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></span>
            <span class="menuButton"><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></span>
        </div>
        <div class="body">
            <h1><g:message code="default.edit.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${jobViewInstance}">
            <div class="errors">
                <g:renderErrors bean="${jobViewInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form method="post" >
                <g:hiddenField name="id" value="${jobViewInstance?.id}" />
                <g:hiddenField name="version" value="${jobViewInstance?.version}" />
                <div class="dialog">
                    <table>
                        <tbody>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="timeViewed"><g:message code="jobView.timeViewed.label" default="Time Viewed" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: jobViewInstance, field: 'timeViewed', 'errors')}">
                                    <g:datePicker name="timeViewed" precision="day" value="${jobViewInstance?.timeViewed}"  />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="applicant"><g:message code="jobView.applicant.label" default="Applicant" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: jobViewInstance, field: 'applicant', 'errors')}">
                                    <g:select name="applicant.id" from="${com.placd.model.Applicant.list()}" optionKey="id" value="${jobViewInstance?.applicant?.id}"  />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="job"><g:message code="jobView.job.label" default="Job" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: jobViewInstance, field: 'job', 'errors')}">
                                    <g:select name="job.id" from="${com.placd.model.Job.list()}" optionKey="id" value="${jobViewInstance?.job?.id}"  />
                                </td>
                            </tr>
                        
                        </tbody>
                    </table>
                </div>
                <div class="buttons">
                    <span class="button"><g:actionSubmit class="save" action="update" value="${message(code: 'default.button.update.label', default: 'Update')}" /></span>
                    <span class="button"><g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" /></span>
                </div>
            </g:form>
        </div>
    </body>
</html>
