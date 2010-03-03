
<%@ page import="com.placd.model.Experience" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'experience.label', default: 'Experience')}" />
        <title><g:message code="default.create.label" args="[entityName]" /></title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLink(uri: '/')}">Home</a></span>
            <span class="menuButton"><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></span>
        </div>
        <div class="body">
            <h1><g:message code="default.create.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${experienceInstance}">
            <div class="errors">
                <g:renderErrors bean="${experienceInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form action="save" method="post" >
                <div class="dialog">
                    <table>
                        <tbody>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="text"><g:message code="experience.text.label" default="Text" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: experienceInstance, field: 'text', 'errors')}">
                                    <g:textField name="text" value="${experienceInstance?.text}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="applicant"><g:message code="experience.applicant.label" default="Applicant" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: experienceInstance, field: 'applicant', 'errors')}">
                                    <g:select name="applicant.id" from="${com.placd.model.Applicant.list()}" optionKey="id" value="${experienceInstance?.applicant?.id}"  />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="dateEnd"><g:message code="experience.dateEnd.label" default="Date End" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: experienceInstance, field: 'dateEnd', 'errors')}">
                                    <g:datePicker name="dateEnd" precision="day" value="${experienceInstance?.dateEnd}"  />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="dateStart"><g:message code="experience.dateStart.label" default="Date Start" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: experienceInstance, field: 'dateStart', 'errors')}">
                                    <g:datePicker name="dateStart" precision="day" value="${experienceInstance?.dateStart}"  />
                                </td>
                            </tr>
                        
                        </tbody>
                    </table>
                </div>
                <div class="buttons">
                    <span class="button"><g:submitButton name="create" class="save" value="${message(code: 'default.button.create.label', default: 'Create')}" /></span>
                </div>
            </g:form>
        </div>
    </body>
</html>
