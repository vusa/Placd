
<%@ page import="com.placd.model.Reference" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'reference.label', default: 'Reference')}" />
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
                            <td valign="top" class="name"><g:message code="reference.id.label" default="Id" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: referenceInstance, field: "id")}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="reference.position.label" default="Position" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: referenceInstance, field: "position")}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="reference.text.label" default="Text" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: referenceInstance, field: "text")}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="reference.phone.label" default="Phone" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: referenceInstance, field: "phone")}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="reference.email.label" default="Email" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: referenceInstance, field: "email")}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="reference.name.label" default="Name" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: referenceInstance, field: "name")}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="reference.company.label" default="Company" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: referenceInstance, field: "company")}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="reference.cell.label" default="Cell" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: referenceInstance, field: "cell")}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="reference.applicant.label" default="Applicant" /></td>
                            
                            <td valign="top" class="value"><g:link controller="applicant" action="show" id="${referenceInstance?.applicant?.id}">${referenceInstance?.applicant?.encodeAsHTML()}</g:link></td>
                            
                        </tr>
                    
                    </tbody>
                </table>
            </div>
            <div class="buttons">
                <g:form>
                    <g:hiddenField name="id" value="${referenceInstance?.id}" />
                    <span class="button"><g:actionSubmit class="edit" action="edit" value="${message(code: 'default.button.edit.label', default: 'Edit')}" /></span>
                    <span class="button"><g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" /></span>
                </g:form>
            </div>
        </div>
    </body>
</html>
