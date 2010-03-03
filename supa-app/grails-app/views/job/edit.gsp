
<%@ page import="com.placd.model.Job" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'job.label', default: 'Job')}" />
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
            <g:hasErrors bean="${jobInstance}">
            <div class="errors">
                <g:renderErrors bean="${jobInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form method="post" >
                <g:hiddenField name="id" value="${jobInstance?.id}" />
                <g:hiddenField name="version" value="${jobInstance?.version}" />
                <div class="dialog">
                    <table>
                        <tbody>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="jobSpecs"><g:message code="job.jobSpecs.label" default="Job Specs" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: jobInstance, field: 'jobSpecs', 'errors')}">
                                    <g:textField name="jobSpecs" value="${jobInstance?.jobSpecs}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="tags"><g:message code="job.tags.label" default="Tags" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: jobInstance, field: 'tags', 'errors')}">
                                    <g:textField name="tags" value="${jobInstance?.tags}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="datePosted"><g:message code="job.datePosted.label" default="Date Posted" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: jobInstance, field: 'datePosted', 'errors')}">
                                    <g:datePicker name="datePosted" precision="day" value="${jobInstance?.datePosted}"  />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="salary_min"><g:message code="job.salary_min.label" default="Salarymin" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: jobInstance, field: 'salary_min', 'errors')}">
                                    <g:textField name="salary_min" value="${fieldValue(bean: jobInstance, field: 'salary_min')}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="salary_max"><g:message code="job.salary_max.label" default="Salarymax" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: jobInstance, field: 'salary_max', 'errors')}">
                                    <g:textField name="salary_max" value="${fieldValue(bean: jobInstance, field: 'salary_max')}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="city"><g:message code="job.city.label" default="City" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: jobInstance, field: 'city', 'errors')}">
                                    <g:textField name="city" value="${jobInstance?.city}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="country"><g:message code="job.country.label" default="Country" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: jobInstance, field: 'country', 'errors')}">
                                    <g:textField name="country" value="${jobInstance?.country}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="title"><g:message code="job.title.label" default="Title" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: jobInstance, field: 'title', 'errors')}">
                                    <g:textField name="title" value="${jobInstance?.title}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="company"><g:message code="job.company.label" default="Company" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: jobInstance, field: 'company', 'errors')}">
                                    <g:select name="company.id" from="${com.placd.model.Company.list()}" optionKey="id" value="${jobInstance?.company?.id}"  />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="closingDate"><g:message code="job.closingDate.label" default="Closing Date" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: jobInstance, field: 'closingDate', 'errors')}">
                                    <g:datePicker name="closingDate" precision="day" value="${jobInstance?.closingDate}"  />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="recruiter"><g:message code="job.recruiter.label" default="Recruiter" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: jobInstance, field: 'recruiter', 'errors')}">
                                    <g:select name="recruiter.id" from="${com.placd.model.Recruiter.list()}" optionKey="id" value="${jobInstance?.recruiter?.id}"  />
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
