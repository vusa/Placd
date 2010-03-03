
<%@ page import="com.placd.model.Applicant" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'applicant.label', default: 'Applicant')}" />
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
                        
                            <g:sortableColumn property="id" title="${message(code: 'applicant.id.label', default: 'Id')}" />
                        
                            <g:sortableColumn property="tags" title="${message(code: 'applicant.tags.label', default: 'Tags')}" />
                        
                            <g:sortableColumn property="summary" title="${message(code: 'applicant.summary.label', default: 'Summary')}" />
                        
                            <g:sortableColumn property="showContactDetails" title="${message(code: 'applicant.showContactDetails.label', default: 'Show Contact Details')}" />
                        
                            <g:sortableColumn property="lastUpdate" title="${message(code: 'applicant.lastUpdate.label', default: 'Last Update')}" />
                        
                            <g:sortableColumn property="name" title="${message(code: 'applicant.name.label', default: 'Name')}" />
                        
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${applicantInstanceList}" status="i" var="applicantInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${applicantInstance.id}">${fieldValue(bean: applicantInstance, field: "id")}</g:link></td>
                        
                            <td>${fieldValue(bean: applicantInstance, field: "tags")}</td>
                        
                            <td>${fieldValue(bean: applicantInstance, field: "summary")}</td>
                        
                            <td><g:formatBoolean boolean="${applicantInstance.showContactDetails}" /></td>
                        
                            <td><g:formatDate date="${applicantInstance.lastUpdate}" /></td>
                        
                            <td>${fieldValue(bean: applicantInstance, field: "name")}</td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${applicantInstanceTotal}" />
            </div>
        </div>
    </body>
</html>
