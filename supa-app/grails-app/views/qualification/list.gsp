
<%@ page import="com.placd.model.Qualification" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'qualification.label', default: 'Qualification')}" />
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
                        
                            <g:sortableColumn property="id" title="${message(code: 'qualification.id.label', default: 'Id')}" />
                        
                            <g:sortableColumn property="text" title="${message(code: 'qualification.text.label', default: 'Text')}" />
                        
                            <g:sortableColumn property="rank" title="${message(code: 'qualification.rank.label', default: 'Rank')}" />
                        
                            <th><g:message code="qualification.applicant.label" default="Applicant" /></th>
                   	    
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${qualificationInstanceList}" status="i" var="qualificationInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${qualificationInstance.id}">${fieldValue(bean: qualificationInstance, field: "id")}</g:link></td>
                        
                            <td>${fieldValue(bean: qualificationInstance, field: "text")}</td>
                        
                            <td>${fieldValue(bean: qualificationInstance, field: "rank")}</td>
                        
                            <td>${fieldValue(bean: qualificationInstance, field: "applicant")}</td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${qualificationInstanceTotal}" />
            </div>
        </div>
    </body>
</html>
