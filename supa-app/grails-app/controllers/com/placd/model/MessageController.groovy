package com.placd.model

class MessageController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index = {
        redirect(action: "list", params: params)
    }

    def list = {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [messageInstanceList: Message.list(params), messageInstanceTotal: Message.count()]
    }

    def create = {
        def messageInstance = new Message()
        messageInstance.properties = params
        return [messageInstance: messageInstance]
    }

    def save = {
        def messageInstance = new Message(params)
        if (messageInstance.save(flush: true)) {
            flash.message = "${message(code: 'default.created.message', args: [message(code: 'message.label', default: 'Message'), messageInstance.id])}"
            redirect(action: "show", id: messageInstance.id)
        }
        else {
            render(view: "create", model: [messageInstance: messageInstance])
        }
    }

    def show = {
        def messageInstance = Message.get(params.id)
        if (!messageInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'message.label', default: 'Message'), params.id])}"
            redirect(action: "list")
        }
        else {
            [messageInstance: messageInstance]
        }
    }

    def edit = {
        def messageInstance = Message.get(params.id)
        if (!messageInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'message.label', default: 'Message'), params.id])}"
            redirect(action: "list")
        }
        else {
            return [messageInstance: messageInstance]
        }
    }

    def update = {
        def messageInstance = Message.get(params.id)
        if (messageInstance) {
            if (params.version) {
                def version = params.version.toLong()
                if (messageInstance.version > version) {
                    
                    messageInstance.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'message.label', default: 'Message')] as Object[], "Another user has updated this Message while you were editing")
                    render(view: "edit", model: [messageInstance: messageInstance])
                    return
                }
            }
            messageInstance.properties = params
            if (!messageInstance.hasErrors() && messageInstance.save(flush: true)) {
                flash.message = "${message(code: 'default.updated.message', args: [message(code: 'message.label', default: 'Message'), messageInstance.id])}"
                redirect(action: "show", id: messageInstance.id)
            }
            else {
                render(view: "edit", model: [messageInstance: messageInstance])
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'message.label', default: 'Message'), params.id])}"
            redirect(action: "list")
        }
    }

    def delete = {
        def messageInstance = Message.get(params.id)
        if (messageInstance) {
            try {
                messageInstance.delete(flush: true)
                flash.message = "${message(code: 'default.deleted.message', args: [message(code: 'message.label', default: 'Message'), params.id])}"
                redirect(action: "list")
            }
            catch (org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "${message(code: 'default.not.deleted.message', args: [message(code: 'message.label', default: 'Message'), params.id])}"
                redirect(action: "show", id: params.id)
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'message.label', default: 'Message'), params.id])}"
            redirect(action: "list")
        }
    }
}
