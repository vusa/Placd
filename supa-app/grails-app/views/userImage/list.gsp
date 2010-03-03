
<%@ page import="com.placd.model.UserImage" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'userImage.label', default: 'UserImage')}" />
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
                        
                            <g:sortableColumn property="id" title="${message(code: 'userImage.id.label', default: 'Id')}" />
                        
                            <g:sortableColumn property="path" title="${message(code: 'userImage.path.label', default: 'Path')}" />
                        
                            <th><g:message code="userImage.user.label" default="User" /></th>
                   	    
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${userImageInstanceList}" status="i" var="userImageInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${userImageInstance.id}">${fieldValue(bean: userImageInstance, field: "id")}</g:link></td>
                        
                            <td>${fieldValue(bean: userImageInstance, field: "path")}</td>
                        
                            <td>${fieldValue(bean: userImageInstance, field: "user")}</td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${userImageInstanceTotal}" />
            </div>
        </div>
    </body>
</html>
