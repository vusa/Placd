
<%@ page import="com.placd.model.Message" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'message.label', default: 'Message')}" />
        <title><g:message code="default.edit.label" args="[entityName]" /></title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLink(uri: '/')}">Home</a></span>
            <span class="menuButton"><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></span>
            <span class="menuButton"><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></span>
        </div>
        <div class="body">
            <h1><g:message code="default.edit.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${messageInstance}">
            <div class="errors">
                <g:renderErrors bean="${messageInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form method="post" >
                <g:hiddenField name="id" value="${messageInstance?.id}" />
                <g:hiddenField name="version" value="${messageInstance?.version}" />
                <div class="dialog">
                    <table>
                        <tbody>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="message"><g:message code="message.message.label" default="Message" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: messageInstance, field: 'message', 'errors')}">
                                    <g:textField name="message" value="${messageInstance?.message}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="inReplyTo"><g:message code="message.inReplyTo.label" default="In Reply To" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: messageInstance, field: 'inReplyTo', 'errors')}">
                                    <g:select name="inReplyTo.id" from="${com.placd.model.Message.list()}" optionKey="id" value="${messageInstance?.inReplyTo?.id}"  />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="toUser"><g:message code="message.toUser.label" default="To User" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: messageInstance, field: 'toUser', 'errors')}">
                                    <g:select name="toUser.id" from="${com.placd.model.AppUser.list()}" optionKey="id" value="${messageInstance?.toUser?.id}"  />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="fromUser"><g:message code="message.fromUser.label" default="From User" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: messageInstance, field: 'fromUser', 'errors')}">
                                    <g:select name="fromUser.id" from="${com.placd.model.AppUser.list()}" optionKey="id" value="${messageInstance?.fromUser?.id}"  />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="subject"><g:message code="message.subject.label" default="Subject" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: messageInstance, field: 'subject', 'errors')}">
                                    <g:textField name="subject" value="${messageInstance?.subject}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="read"><g:message code="message.read.label" default="Read" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: messageInstance, field: 'read', 'errors')}">
                                    <g:checkBox name="read" value="${messageInstance?.read}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="job"><g:message code="message.job.label" default="Job" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: messageInstance, field: 'job', 'errors')}">
                                    <g:select name="job.id" from="${com.placd.model.Job.list()}" optionKey="id" value="${messageInstance?.job?.id}"  />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="timeSent"><g:message code="message.timeSent.label" default="Time Sent" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: messageInstance, field: 'timeSent', 'errors')}">
                                    <g:datePicker name="timeSent" precision="day" value="${messageInstance?.timeSent}"  />
                                </td>
                            </tr>
                        
                        </tbody>
                    </table>
                </div>
                <div class="buttons">
                    <span class="button"><g:actionSubmit class="save" action="update" value="${message(code: 'default.button.update.label', default: 'Update')}" /></span>
                    <span class="button"><g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" /></span>
                </div>
            </g:form>
        </div>
    </body>
</html>
