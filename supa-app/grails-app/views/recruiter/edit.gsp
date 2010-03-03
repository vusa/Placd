
<%@ page import="com.placd.model.Recruiter" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'recruiter.label', default: 'Recruiter')}" />
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
            <g:hasErrors bean="${recruiterInstance}">
            <div class="errors">
                <g:renderErrors bean="${recruiterInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form method="post" >
                <g:hiddenField name="id" value="${recruiterInstance?.id}" />
                <g:hiddenField name="version" value="${recruiterInstance?.version}" />
                <div class="dialog">
                    <table>
                        <tbody>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="name"><g:message code="recruiter.name.label" default="Name" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: recruiterInstance, field: 'name', 'errors')}">
                                    <g:textField name="name" value="${recruiterInstance?.name}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="company"><g:message code="recruiter.company.label" default="Company" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: recruiterInstance, field: 'company', 'errors')}">
                                    <g:select name="company.id" from="${com.placd.model.Company.list()}" optionKey="id" value="${recruiterInstance?.company?.id}"  />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="surname"><g:message code="recruiter.surname.label" default="Surname" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: recruiterInstance, field: 'surname', 'errors')}">
                                    <g:textField name="surname" value="${recruiterInstance?.surname}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="user"><g:message code="recruiter.user.label" default="User" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: recruiterInstance, field: 'user', 'errors')}">
                                    <g:select name="user.id" from="${com.placd.model.AppUser.list()}" optionKey="id" value="${recruiterInstance?.user?.id}"  />
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
