
<%@ page import="com.placd.model.Recruiter" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'recruiter.label', default: 'Recruiter')}" />
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
                        
                            <g:sortableColumn property="id" title="${message(code: 'recruiter.id.label', default: 'Id')}" />
                        
                            <g:sortableColumn property="name" title="${message(code: 'recruiter.name.label', default: 'Name')}" />
                        
                            <th><g:message code="recruiter.company.label" default="Company" /></th>
                   	    
                            <g:sortableColumn property="surname" title="${message(code: 'recruiter.surname.label', default: 'Surname')}" />
                        
                            <th><g:message code="recruiter.user.label" default="User" /></th>
                   	    
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${recruiterInstanceList}" status="i" var="recruiterInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${recruiterInstance.id}">${fieldValue(bean: recruiterInstance, field: "id")}</g:link></td>
                        
                            <td>${fieldValue(bean: recruiterInstance, field: "name")}</td>
                        
                            <td>${fieldValue(bean: recruiterInstance, field: "company")}</td>
                        
                            <td>${fieldValue(bean: recruiterInstance, field: "surname")}</td>
                        
                            <td>${fieldValue(bean: recruiterInstance, field: "user")}</td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${recruiterInstanceTotal}" />
            </div>
        </div>
    </body>
</html>
