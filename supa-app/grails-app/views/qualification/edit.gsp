
<%@ page import="com.placd.model.Qualification" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'qualification.label', default: 'Qualification')}" />
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
            <g:hasErrors bean="${qualificationInstance}">
            <div class="errors">
                <g:renderErrors bean="${qualificationInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form method="post" >
                <g:hiddenField name="id" value="${qualificationInstance?.id}" />
                <g:hiddenField name="version" value="${qualificationInstance?.version}" />
                <div class="dialog">
                    <table>
                        <tbody>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="text"><g:message code="qualification.text.label" default="Text" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: qualificationInstance, field: 'text', 'errors')}">
                                    <g:textField name="text" value="${qualificationInstance?.text}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="rank"><g:message code="qualification.rank.label" default="Rank" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: qualificationInstance, field: 'rank', 'errors')}">
                                    <g:textField name="rank" value="${fieldValue(bean: qualificationInstance, field: 'rank')}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="applicant"><g:message code="qualification.applicant.label" default="Applicant" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: qualificationInstance, field: 'applicant', 'errors')}">
                                    <g:select name="applicant.id" from="${com.placd.model.Applicant.list()}" optionKey="id" value="${qualificationInstance?.applicant?.id}"  />
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
