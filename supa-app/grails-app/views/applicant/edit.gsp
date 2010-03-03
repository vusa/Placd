
<%@ page import="com.placd.model.Applicant" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'applicant.label', default: 'Applicant')}" />
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
            <g:hasErrors bean="${applicantInstance}">
            <div class="errors">
                <g:renderErrors bean="${applicantInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form method="post" >
                <g:hiddenField name="id" value="${applicantInstance?.id}" />
                <g:hiddenField name="version" value="${applicantInstance?.version}" />
                <div class="dialog">
                    <table>
                        <tbody>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="tags"><g:message code="applicant.tags.label" default="Tags" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: applicantInstance, field: 'tags', 'errors')}">
                                    <g:textField name="tags" value="${applicantInstance?.tags}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="summary"><g:message code="applicant.summary.label" default="Summary" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: applicantInstance, field: 'summary', 'errors')}">
                                    <g:textField name="summary" value="${applicantInstance?.summary}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="showContactDetails"><g:message code="applicant.showContactDetails.label" default="Show Contact Details" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: applicantInstance, field: 'showContactDetails', 'errors')}">
                                    <g:checkBox name="showContactDetails" value="${applicantInstance?.showContactDetails}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="lastUpdate"><g:message code="applicant.lastUpdate.label" default="Last Update" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: applicantInstance, field: 'lastUpdate', 'errors')}">
                                    <g:datePicker name="lastUpdate" precision="day" value="${applicantInstance?.lastUpdate}"  />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="name"><g:message code="applicant.name.label" default="Name" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: applicantInstance, field: 'name', 'errors')}">
                                    <g:textField name="name" value="${applicantInstance?.name}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="expectedMinimunSalary"><g:message code="applicant.expectedMinimunSalary.label" default="Expected Minimun Salary" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: applicantInstance, field: 'expectedMinimunSalary', 'errors')}">
                                    <g:textField name="expectedMinimunSalary" value="${fieldValue(bean: applicantInstance, field: 'expectedMinimunSalary')}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="surname"><g:message code="applicant.surname.label" default="Surname" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: applicantInstance, field: 'surname', 'errors')}">
                                    <g:textField name="surname" value="${applicantInstance?.surname}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="user"><g:message code="applicant.user.label" default="User" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: applicantInstance, field: 'user', 'errors')}">
                                    <g:select name="user.id" from="${com.placd.model.AppUser.list()}" optionKey="id" value="${applicantInstance?.user?.id}"  />
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
