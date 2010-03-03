
<%@ page import="com.placd.model.Reference" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'reference.label', default: 'Reference')}" />
        <title><g:message code="default.create.label" args="[entityName]" /></title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLink(uri: '/')}">Home</a></span>
            <span class="menuButton"><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></span>
        </div>
        <div class="body">
            <h1><g:message code="default.create.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${referenceInstance}">
            <div class="errors">
                <g:renderErrors bean="${referenceInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form action="save" method="post" >
                <div class="dialog">
                    <table>
                        <tbody>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="position"><g:message code="reference.position.label" default="Position" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: referenceInstance, field: 'position', 'errors')}">
                                    <g:textField name="position" value="${referenceInstance?.position}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="text"><g:message code="reference.text.label" default="Text" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: referenceInstance, field: 'text', 'errors')}">
                                    <g:textField name="text" value="${referenceInstance?.text}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="phone"><g:message code="reference.phone.label" default="Phone" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: referenceInstance, field: 'phone', 'errors')}">
                                    <g:textField name="phone" value="${referenceInstance?.phone}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="email"><g:message code="reference.email.label" default="Email" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: referenceInstance, field: 'email', 'errors')}">
                                    <g:textField name="email" value="${referenceInstance?.email}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="name"><g:message code="reference.name.label" default="Name" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: referenceInstance, field: 'name', 'errors')}">
                                    <g:textField name="name" value="${referenceInstance?.name}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="company"><g:message code="reference.company.label" default="Company" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: referenceInstance, field: 'company', 'errors')}">
                                    <g:textField name="company" value="${referenceInstance?.company}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="cell"><g:message code="reference.cell.label" default="Cell" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: referenceInstance, field: 'cell', 'errors')}">
                                    <g:textField name="cell" value="${referenceInstance?.cell}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="applicant"><g:message code="reference.applicant.label" default="Applicant" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: referenceInstance, field: 'applicant', 'errors')}">
                                    <g:select name="applicant.id" from="${com.placd.model.Applicant.list()}" optionKey="id" value="${referenceInstance?.applicant?.id}"  />
                                </td>
                            </tr>
                        
                        </tbody>
                    </table>
                </div>
                <div class="buttons">
                    <span class="button"><g:submitButton name="create" class="save" value="${message(code: 'default.button.create.label', default: 'Create')}" /></span>
                </div>
            </g:form>
        </div>
    </body>
</html>
