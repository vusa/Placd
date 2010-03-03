
<%@ page import="com.placd.model.KeySkills" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'keySkills.label', default: 'KeySkills')}" />
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
                        
                            <g:sortableColumn property="id" title="${message(code: 'keySkills.id.label', default: 'Id')}" />
                        
                            <g:sortableColumn property="text" title="${message(code: 'keySkills.text.label', default: 'Text')}" />
                        
                            <g:sortableColumn property="level" title="${message(code: 'keySkills.level.label', default: 'Level')}" />
                        
                            <th><g:message code="keySkills.applicant.label" default="Applicant" /></th>
                   	    
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${keySkillsInstanceList}" status="i" var="keySkillsInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${keySkillsInstance.id}">${fieldValue(bean: keySkillsInstance, field: "id")}</g:link></td>
                        
                            <td>${fieldValue(bean: keySkillsInstance, field: "text")}</td>
                        
                            <td>${fieldValue(bean: keySkillsInstance, field: "level")}</td>
                        
                            <td>${fieldValue(bean: keySkillsInstance, field: "applicant")}</td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${keySkillsInstanceTotal}" />
            </div>
        </div>
    </body>
</html>
