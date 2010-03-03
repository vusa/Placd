
<%@ page import="com.placd.model.Job" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'job.label', default: 'Job')}" />
        <title><g:message code="default.show.label" args="[entityName]" /></title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLink(uri: '/')}">Home</a></span>
            <span class="menuButton"><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></span>
            <span class="menuButton"><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></span>
        </div>
        <div class="body">
            <h1><g:message code="default.show.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="dialog">
                <table>
                    <tbody>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="job.id.label" default="Id" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: jobInstance, field: "id")}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="job.jobSpecs.label" default="Job Specs" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: jobInstance, field: "jobSpecs")}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="job.tags.label" default="Tags" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: jobInstance, field: "tags")}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="job.datePosted.label" default="Date Posted" /></td>
                            
                            <td valign="top" class="value"><g:formatDate date="${jobInstance?.datePosted}" /></td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="job.salary_min.label" default="Salarymin" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: jobInstance, field: "salary_min")}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="job.salary_max.label" default="Salarymax" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: jobInstance, field: "salary_max")}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="job.city.label" default="City" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: jobInstance, field: "city")}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="job.country.label" default="Country" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: jobInstance, field: "country")}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="job.title.label" default="Title" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: jobInstance, field: "title")}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="job.company.label" default="Company" /></td>
                            
                            <td valign="top" class="value"><g:link controller="company" action="show" id="${jobInstance?.company?.id}">${jobInstance?.company?.encodeAsHTML()}</g:link></td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="job.closingDate.label" default="Closing Date" /></td>
                            
                            <td valign="top" class="value"><g:formatDate date="${jobInstance?.closingDate}" /></td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="job.recruiter.label" default="Recruiter" /></td>
                            
                            <td valign="top" class="value"><g:link controller="recruiter" action="show" id="${jobInstance?.recruiter?.id}">${jobInstance?.recruiter?.encodeAsHTML()}</g:link></td>
                            
                        </tr>
                    
                    </tbody>
                </table>
            </div>
            <div class="buttons">
                <g:form>
                    <g:hiddenField name="id" value="${jobInstance?.id}" />
                    <span class="button"><g:actionSubmit class="edit" action="edit" value="${message(code: 'default.button.edit.label', default: 'Edit')}" /></span>
                    <span class="button"><g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" /></span>
                </g:form>
            </div>
        </div>
    </body>
</html>
