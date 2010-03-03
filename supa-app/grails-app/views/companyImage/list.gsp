
<%@ page import="com.placd.model.CompanyImage" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'companyImage.label', default: 'CompanyImage')}" />
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
                        
                            <g:sortableColumn property="id" title="${message(code: 'companyImage.id.label', default: 'Id')}" />
                        
                            <th><g:message code="companyImage.company.label" default="Company" /></th>
                   	    
                            <g:sortableColumn property="path" title="${message(code: 'companyImage.path.label', default: 'Path')}" />
                        
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${companyImageInstanceList}" status="i" var="companyImageInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${companyImageInstance.id}">${fieldValue(bean: companyImageInstance, field: "id")}</g:link></td>
                        
                            <td>${fieldValue(bean: companyImageInstance, field: "company")}</td>
                        
                            <td>${fieldValue(bean: companyImageInstance, field: "path")}</td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${companyImageInstanceTotal}" />
            </div>
        </div>
    </body>
</html>
