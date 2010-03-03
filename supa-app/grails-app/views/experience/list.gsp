
<%@ page import="com.placd.model.Experience" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'experience.label', default: 'Experience')}" />
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
                        
                            <g:sortableColumn property="id" title="${message(code: 'experience.id.label', default: 'Id')}" />
                        
                            <g:sortableColumn property="text" title="${message(code: 'experience.text.label', default: 'Text')}" />
                        
                            <th><g:message code="experience.applicant.label" default="Applicant" /></th>
                   	    
                            <g:sortableColumn property="dateEnd" title="${message(code: 'experience.dateEnd.label', default: 'Date End')}" />
                        
                            <g:sortableColumn property="dateStart" title="${message(code: 'experience.dateStart.label', default: 'Date Start')}" />
                        
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${experienceInstanceList}" status="i" var="experienceInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${experienceInstance.id}">${fieldValue(bean: experienceInstance, field: "id")}</g:link></td>
                        
                            <td>${fieldValue(bean: experienceInstance, field: "text")}</td>
                        
                            <td>${fieldValue(bean: experienceInstance, field: "applicant")}</td>
                        
                            <td><g:formatDate date="${experienceInstance.dateEnd}" /></td>
                        
                            <td><g:formatDate date="${experienceInstance.dateStart}" /></td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${experienceInstanceTotal}" />
            </div>
        </div>
    </body>
</html>
