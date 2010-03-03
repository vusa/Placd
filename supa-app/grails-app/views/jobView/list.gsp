
<%@ page import="com.placd.model.JobView" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'jobView.label', default: 'JobView')}" />
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
                        
                            <g:sortableColumn property="id" title="${message(code: 'jobView.id.label', default: 'Id')}" />
                        
                            <g:sortableColumn property="timeViewed" title="${message(code: 'jobView.timeViewed.label', default: 'Time Viewed')}" />
                        
                            <th><g:message code="jobView.applicant.label" default="Applicant" /></th>
                   	    
                            <th><g:message code="jobView.job.label" default="Job" /></th>
                   	    
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${jobViewInstanceList}" status="i" var="jobViewInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${jobViewInstance.id}">${fieldValue(bean: jobViewInstance, field: "id")}</g:link></td>
                        
                            <td><g:formatDate date="${jobViewInstance.timeViewed}" /></td>
                        
                            <td>${fieldValue(bean: jobViewInstance, field: "applicant")}</td>
                        
                            <td>${fieldValue(bean: jobViewInstance, field: "job")}</td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${jobViewInstanceTotal}" />
            </div>
        </div>
    </body>
</html>
