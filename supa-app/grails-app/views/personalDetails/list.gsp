
<%@ page import="com.placd.model.PersonalDetails" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'personalDetails.label', default: 'PersonalDetails')}" />
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
                        
                            <g:sortableColumn property="id" title="${message(code: 'personalDetails.id.label', default: 'Id')}" />
                        
                            <g:sortableColumn property="workphone" title="${message(code: 'personalDetails.workphone.label', default: 'Workphone')}" />
                        
                            <g:sortableColumn property="email" title="${message(code: 'personalDetails.email.label', default: 'Email')}" />
                        
                            <g:sortableColumn property="cellphone" title="${message(code: 'personalDetails.cellphone.label', default: 'Cellphone')}" />
                        
                            <th><g:message code="personalDetails.user.label" default="User" /></th>
                   	    
                            <g:sortableColumn property="homephone" title="${message(code: 'personalDetails.homephone.label', default: 'Homephone')}" />
                        
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${personalDetailsInstanceList}" status="i" var="personalDetailsInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${personalDetailsInstance.id}">${fieldValue(bean: personalDetailsInstance, field: "id")}</g:link></td>
                        
                            <td>${fieldValue(bean: personalDetailsInstance, field: "workphone")}</td>
                        
                            <td>${fieldValue(bean: personalDetailsInstance, field: "email")}</td>
                        
                            <td>${fieldValue(bean: personalDetailsInstance, field: "cellphone")}</td>
                        
                            <td>${fieldValue(bean: personalDetailsInstance, field: "user")}</td>
                        
                            <td>${fieldValue(bean: personalDetailsInstance, field: "homephone")}</td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${personalDetailsInstanceTotal}" />
            </div>
        </div>
    </body>
</html>
