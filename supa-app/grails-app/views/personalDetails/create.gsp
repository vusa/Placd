
<%@ page import="com.placd.model.PersonalDetails" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'personalDetails.label', default: 'PersonalDetails')}" />
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
            <g:hasErrors bean="${personalDetailsInstance}">
            <div class="errors">
                <g:renderErrors bean="${personalDetailsInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form action="save" method="post" >
                <div class="dialog">
                    <table>
                        <tbody>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="workphone"><g:message code="personalDetails.workphone.label" default="Workphone" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: personalDetailsInstance, field: 'workphone', 'errors')}">
                                    <g:textField name="workphone" value="${personalDetailsInstance?.workphone}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="email"><g:message code="personalDetails.email.label" default="Email" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: personalDetailsInstance, field: 'email', 'errors')}">
                                    <g:textField name="email" value="${personalDetailsInstance?.email}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="cellphone"><g:message code="personalDetails.cellphone.label" default="Cellphone" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: personalDetailsInstance, field: 'cellphone', 'errors')}">
                                    <g:textField name="cellphone" value="${personalDetailsInstance?.cellphone}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="user"><g:message code="personalDetails.user.label" default="User" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: personalDetailsInstance, field: 'user', 'errors')}">
                                    <g:select name="user.id" from="${com.placd.model.AppUser.list()}" optionKey="id" value="${personalDetailsInstance?.user?.id}"  />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="homephone"><g:message code="personalDetails.homephone.label" default="Homephone" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: personalDetailsInstance, field: 'homephone', 'errors')}">
                                    <g:textField name="homephone" value="${personalDetailsInstance?.homephone}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="cvPath"><g:message code="personalDetails.cvPath.label" default="Cv Path" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: personalDetailsInstance, field: 'cvPath', 'errors')}">
                                    <g:textField name="cvPath" value="${personalDetailsInstance?.cvPath}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="country"><g:message code="personalDetails.country.label" default="Country" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: personalDetailsInstance, field: 'country', 'errors')}">
                                    <g:textField name="country" value="${personalDetailsInstance?.country}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="city"><g:message code="personalDetails.city.label" default="City" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: personalDetailsInstance, field: 'city', 'errors')}">
                                    <g:textField name="city" value="${personalDetailsInstance?.city}" />
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
