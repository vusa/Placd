
<%@ page import="com.placd.model.Company" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'company.label', default: 'Company')}" />
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
                        
                            <g:sortableColumn property="id" title="${message(code: 'company.id.label', default: 'Id')}" />
                        
                            <g:sortableColumn property="logo" title="${message(code: 'company.logo.label', default: 'Logo')}" />
                        
                            <g:sortableColumn property="contactPhone" title="${message(code: 'company.contactPhone.label', default: 'Contact Phone')}" />
                        
                            <g:sortableColumn property="contactEmail" title="${message(code: 'company.contactEmail.label', default: 'Contact Email')}" />
                        
                            <g:sortableColumn property="name" title="${message(code: 'company.name.label', default: 'Name')}" />
                        
                            <th><g:message code="company.owner.label" default="Owner" /></th>
                   	    
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${companyInstanceList}" status="i" var="companyInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${companyInstance.id}">${fieldValue(bean: companyInstance, field: "id")}</g:link></td>
                        
                            <td>${fieldValue(bean: companyInstance, field: "logo")}</td>
                        
                            <td>${fieldValue(bean: companyInstance, field: "contactPhone")}</td>
                        
                            <td>${fieldValue(bean: companyInstance, field: "contactEmail")}</td>
                        
                            <td>${fieldValue(bean: companyInstance, field: "name")}</td>
                        
                            <td>${fieldValue(bean: companyInstance, field: "owner")}</td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${companyInstanceTotal}" />
            </div>
        </div>
    </body>
</html>
