
<%@ page import="com.placd.model.AppUser" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'appUser.label', default: 'AppUser')}" />
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
            <g:hasErrors bean="${appUserInstance}">
            <div class="errors">
                <g:renderErrors bean="${appUserInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form method="post" >
                <g:hiddenField name="id" value="${appUserInstance?.id}" />
                <g:hiddenField name="version" value="${appUserInstance?.version}" />
                <div class="dialog">
                    <table>
                        <tbody>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="login"><g:message code="appUser.login.label" default="Login" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: appUserInstance, field: 'login', 'errors')}">
                                    <g:textField name="login" maxlength="15" value="${appUserInstance?.login}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="password"><g:message code="appUser.password.label" default="Password" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: appUserInstance, field: 'password', 'errors')}">
                                    <g:textField name="password" maxlength="15" value="${appUserInstance?.password}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="email"><g:message code="appUser.email.label" default="Email" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: appUserInstance, field: 'email', 'errors')}">
                                    <g:textField name="email" value="${appUserInstance?.email}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="auth_type"><g:message code="appUser.auth_type.label" default="Authtype" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: appUserInstance, field: 'auth_type', 'errors')}">
                                    <g:textField name="auth_type" value="${appUserInstance?.auth_type}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="dob"><g:message code="appUser.dob.label" default="Dob" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: appUserInstance, field: 'dob', 'errors')}">
                                    <g:datePicker name="dob" precision="day" value="${appUserInstance?.dob}"  />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="active"><g:message code="appUser.active.label" default="Active" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: appUserInstance, field: 'active', 'errors')}">
                                    <g:checkBox name="active" value="${appUserInstance?.active}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="group"><g:message code="appUser.group.label" default="Group" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: appUserInstance, field: 'group', 'errors')}">
                                    <g:select name="group.id" from="${com.placd.model.UserGroup.list()}" optionKey="id" value="${appUserInstance?.group?.id}"  />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="last_login"><g:message code="appUser.last_login.label" default="Lastlogin" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: appUserInstance, field: 'last_login', 'errors')}">
                                    <g:datePicker name="last_login" precision="day" value="${appUserInstance?.last_login}"  />
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
