
<%@ page import="com.placd.model.Message" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'message.label', default: 'Message')}" />
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
                            <td valign="top" class="name"><g:message code="message.id.label" default="Id" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: messageInstance, field: "id")}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="message.message.label" default="Message" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: messageInstance, field: "message")}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="message.inReplyTo.label" default="In Reply To" /></td>
                            
                            <td valign="top" class="value"><g:link controller="message" action="show" id="${messageInstance?.inReplyTo?.id}">${messageInstance?.inReplyTo?.encodeAsHTML()}</g:link></td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="message.toUser.label" default="To User" /></td>
                            
                            <td valign="top" class="value"><g:link controller="appUser" action="show" id="${messageInstance?.toUser?.id}">${messageInstance?.toUser?.encodeAsHTML()}</g:link></td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="message.fromUser.label" default="From User" /></td>
                            
                            <td valign="top" class="value"><g:link controller="appUser" action="show" id="${messageInstance?.fromUser?.id}">${messageInstance?.fromUser?.encodeAsHTML()}</g:link></td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="message.subject.label" default="Subject" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: messageInstance, field: "subject")}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="message.read.label" default="Read" /></td>
                            
                            <td valign="top" class="value"><g:formatBoolean boolean="${messageInstance?.read}" /></td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="message.job.label" default="Job" /></td>
                            
                            <td valign="top" class="value"><g:link controller="job" action="show" id="${messageInstance?.job?.id}">${messageInstance?.job?.encodeAsHTML()}</g:link></td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="message.timeSent.label" default="Time Sent" /></td>
                            
                            <td valign="top" class="value"><g:formatDate date="${messageInstance?.timeSent}" /></td>
                            
                        </tr>
                    
                    </tbody>
                </table>
            </div>
            <div class="buttons">
                <g:form>
                    <g:hiddenField name="id" value="${messageInstance?.id}" />
                    <span class="button"><g:actionSubmit class="edit" action="edit" value="${message(code: 'default.button.edit.label', default: 'Edit')}" /></span>
                    <span class="button"><g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" /></span>
                </g:form>
            </div>
        </div>
    </body>
</html>
