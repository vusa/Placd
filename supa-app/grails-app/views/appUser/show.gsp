
<%@ page import="com.placd.model.AppUser" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'appUser.label', default: 'AppUser')}" />
        <title><g:message code="default.show.label" args="[entityName]" /></title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLink(uri: '/')}">Home</a></span>
            <span class="menuButton"><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></span>
            <span class="menuButton"><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></span>
        </div>
        <div class="body">
            <h1><g:message code="default.show.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="dialog">
                <table>
                    <tbody>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="appUser.id.label" default="Id" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: appUserInstance, field: "id")}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="appUser.login.label" default="Login" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: appUserInstance, field: "login")}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="appUser.password.label" default="Password" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: appUserInstance, field: "password")}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="appUser.email.label" default="Email" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: appUserInstance, field: "email")}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="appUser.auth_type.label" default="Authtype" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: appUserInstance, field: "auth_type")}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="appUser.dob.label" default="Dob" /></td>
                            
                            <td valign="top" class="value"><g:formatDate date="${appUserInstance?.dob}" /></td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="appUser.active.label" default="Active" /></td>
                            
                            <td valign="top" class="value"><g:formatBoolean boolean="${appUserInstance?.active}" /></td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="appUser.group.label" default="Group" /></td>
                            
                            <td valign="top" class="value"><g:link controller="userGroup" action="show" id="${appUserInstance?.group?.id}">${appUserInstance?.group?.encodeAsHTML()}</g:link></td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="appUser.last_login.label" default="Lastlogin" /></td>
                            
                            <td valign="top" class="value"><g:formatDate date="${appUserInstance?.last_login}" /></td>
                            
                        </tr>
                    
                    </tbody>
                </table>
            </div>
            <div class="buttons">
                <g:form>
                    <g:hiddenField name="id" value="${appUserInstance?.id}" />
                    <span class="button"><g:actionSubmit class="edit" action="edit" value="${message(code: 'default.button.edit.label', default: 'Edit')}" /></span>
                    <span class="button"><g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" /></span>
                </g:form>
            </div>
        </div>
    </body>
</html>
