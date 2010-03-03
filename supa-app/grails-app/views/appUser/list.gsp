
<%@ page import="com.placd.model.AppUser" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'appUser.label', default: 'AppUser')}" />
        <title><g:message code="default.list.label" args="[entityName]" /></title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLink(uri: '/')}">Home</a></span>
            <span class="menuButton"><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></span>
        </div>
        <div class="body">
            <h1><g:message code="default.list.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="list">
                <table>
                    <thead>
                        <tr>
                        
                            <g:sortableColumn property="id" title="${message(code: 'appUser.id.label', default: 'Id')}" />
                        
                            <g:sortableColumn property="login" title="${message(code: 'appUser.login.label', default: 'Login')}" />
                        
                            <g:sortableColumn property="password" title="${message(code: 'appUser.password.label', default: 'Password')}" />
                        
                            <g:sortableColumn property="email" title="${message(code: 'appUser.email.label', default: 'Email')}" />
                        
                            <g:sortableColumn property="auth_type" title="${message(code: 'appUser.auth_type.label', default: 'Authtype')}" />
                        
                            <g:sortableColumn property="dob" title="${message(code: 'appUser.dob.label', default: 'Dob')}" />
                        
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${appUserInstanceList}" status="i" var="appUserInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${appUserInstance.id}">${fieldValue(bean: appUserInstance, field: "id")}</g:link></td>
                        
                            <td>${fieldValue(bean: appUserInstance, field: "login")}</td>
                        
                            <td>${fieldValue(bean: appUserInstance, field: "password")}</td>
                        
                            <td>${fieldValue(bean: appUserInstance, field: "email")}</td>
                        
                            <td>${fieldValue(bean: appUserInstance, field: "auth_type")}</td>
                        
                            <td><g:formatDate date="${appUserInstance.dob}" /></td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${appUserInstanceTotal}" />
            </div>
        </div>
    </body>
</html>
