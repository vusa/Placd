
<%@ page import="com.placd.model.Applicant" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'applicant.label', default: 'Applicant')}" />
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
                            <td valign="top" class="name"><g:message code="applicant.id.label" default="Id" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: applicantInstance, field: "id")}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="applicant.tags.label" default="Tags" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: applicantInstance, field: "tags")}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="applicant.summary.label" default="Summary" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: applicantInstance, field: "summary")}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="applicant.showContactDetails.label" default="Show Contact Details" /></td>
                            
                            <td valign="top" class="value"><g:formatBoolean boolean="${applicantInstance?.showContactDetails}" /></td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="applicant.lastUpdate.label" default="Last Update" /></td>
                            
                            <td valign="top" class="value"><g:formatDate date="${applicantInstance?.lastUpdate}" /></td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="applicant.name.label" default="Name" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: applicantInstance, field: "name")}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="applicant.expectedMinimunSalary.label" default="Expected Minimun Salary" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: applicantInstance, field: "expectedMinimunSalary")}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="applicant.surname.label" default="Surname" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: applicantInstance, field: "surname")}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="applicant.user.label" default="User" /></td>
                            
                            <td valign="top" class="value"><g:link controller="appUser" action="show" id="${applicantInstance?.user?.id}">${applicantInstance?.user?.encodeAsHTML()}</g:link></td>
                            
                        </tr>
                    
                    </tbody>
                </table>
            </div>
            <div class="buttons">
                <g:form>
                    <g:hiddenField name="id" value="${applicantInstance?.id}" />
                    <span class="button"><g:actionSubmit class="edit" action="edit" value="${message(code: 'default.button.edit.label', default: 'Edit')}" /></span>
                    <span class="button"><g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" /></span>
                </g:form>
            </div>
        </div>
    </body>
</html>
