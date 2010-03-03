
<%@ page import="com.placd.model.Reference" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'reference.label', default: 'Reference')}" />
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
                        
                            <g:sortableColumn property="id" title="${message(code: 'reference.id.label', default: 'Id')}" />
                        
                            <g:sortableColumn property="position" title="${message(code: 'reference.position.label', default: 'Position')}" />
                        
                            <g:sortableColumn property="text" title="${message(code: 'reference.text.label', default: 'Text')}" />
                        
                            <g:sortableColumn property="phone" title="${message(code: 'reference.phone.label', default: 'Phone')}" />
                        
                            <g:sortableColumn property="email" title="${message(code: 'reference.email.label', default: 'Email')}" />
                        
                            <g:sortableColumn property="name" title="${message(code: 'reference.name.label', default: 'Name')}" />
                        
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${referenceInstanceList}" status="i" var="referenceInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${referenceInstance.id}">${fieldValue(bean: referenceInstance, field: "id")}</g:link></td>
                        
                            <td>${fieldValue(bean: referenceInstance, field: "position")}</td>
                        
                            <td>${fieldValue(bean: referenceInstance, field: "text")}</td>
                        
                            <td>${fieldValue(bean: referenceInstance, field: "phone")}</td>
                        
                            <td>${fieldValue(bean: referenceInstance, field: "email")}</td>
                        
                            <td>${fieldValue(bean: referenceInstance, field: "name")}</td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${referenceInstanceTotal}" />
            </div>
        </div>
    </body>
</html>
