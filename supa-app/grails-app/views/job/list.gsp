
<%@ page import="com.placd.model.Job" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'job.label', default: 'Job')}" />
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
                        
                            <g:sortableColumn property="id" title="${message(code: 'job.id.label', default: 'Id')}" />
                        
                            <g:sortableColumn property="jobSpecs" title="${message(code: 'job.jobSpecs.label', default: 'Job Specs')}" />
                        
                            <g:sortableColumn property="tags" title="${message(code: 'job.tags.label', default: 'Tags')}" />
                        
                            <g:sortableColumn property="datePosted" title="${message(code: 'job.datePosted.label', default: 'Date Posted')}" />
                        
                            <g:sortableColumn property="salary_min" title="${message(code: 'job.salary_min.label', default: 'Salarymin')}" />
                        
                            <g:sortableColumn property="salary_max" title="${message(code: 'job.salary_max.label', default: 'Salarymax')}" />
                        
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${jobInstanceList}" status="i" var="jobInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${jobInstance.id}">${fieldValue(bean: jobInstance, field: "id")}</g:link></td>
                        
                            <td>${fieldValue(bean: jobInstance, field: "jobSpecs")}</td>
                        
                            <td>${fieldValue(bean: jobInstance, field: "tags")}</td>
                        
                            <td><g:formatDate date="${jobInstance.datePosted}" /></td>
                        
                            <td>${fieldValue(bean: jobInstance, field: "salary_min")}</td>
                        
                            <td>${fieldValue(bean: jobInstance, field: "salary_max")}</td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${jobInstanceTotal}" />
            </div>
        </div>
    </body>
</html>
