
<%@ page import="com.placd.model.UserImage" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'userImage.label', default: 'UserImage')}" />
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
            <g:hasErrors bean="${userImageInstance}">
            <div class="errors">
                <g:renderErrors bean="${userImageInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form action="save" method="post" >
                <div class="dialog">
                    <table>
                        <tbody>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="path"><g:message code="userImage.path.label" default="Path" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: userImageInstance, field: 'path', 'errors')}">
                                    <g:textField name="path" value="${userImageInstance?.path}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="user"><g:message code="userImage.user.label" default="User" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: userImageInstance, field: 'user', 'errors')}">
                                    <g:select name="user.id" from="${com.placd.model.AppUser.list()}" optionKey="id" value="${userImageInstance?.user?.id}"  />
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
