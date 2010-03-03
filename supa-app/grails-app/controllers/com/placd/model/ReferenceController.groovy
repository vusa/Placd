package com.placd.model

class ReferenceController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index = {
        redirect(action: "list", params: params)
    }

    def list = {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [referenceInstanceList: Reference.list(params), referenceInstanceTotal: Reference.count()]
    }

    def create = {
        def referenceInstance = new Reference()
        referenceInstance.properties = params
        return [referenceInstance: referenceInstance]
    }

    def save = {
        def referenceInstance = new Reference(params)
        if (referenceInstance.save(flush: true)) {
            flash.message = "${message(code: 'default.created.message', args: [message(code: 'reference.label', default: 'Reference'), referenceInstance.id])}"
            redirect(action: "show", id: referenceInstance.id)
        }
        else {
            render(view: "create", model: [referenceInstance: referenceInstance])
        }
    }

    def show = {
        def referenceInstance = Reference.get(params.id)
        if (!referenceInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'reference.label', default: 'Reference'), params.id])}"
            redirect(action: "list")
        }
        else {
            [referenceInstance: referenceInstance]
        }
    }

    def edit = {
        def referenceInstance = Reference.get(params.id)
        if (!referenceInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'reference.label', default: 'Reference'), params.id])}"
            redirect(action: "list")
        }
        else {
            return [referenceInstance: referenceInstance]
        }
    }

    def update = {
        def referenceInstance = Reference.get(params.id)
        if (referenceInstance) {
            if (params.version) {
                def version = params.version.toLong()
                if (referenceInstance.version > version) {
                    
                    referenceInstance.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'reference.label', default: 'Reference')] as Object[], "Another user has updated this Reference while you were editing")
                    render(view: "edit", model: [referenceInstance: referenceInstance])
                    return
                }
            }
            referenceInstance.properties = params
            if (!referenceInstance.hasErrors() && referenceInstance.save(flush: true)) {
                flash.message = "${message(code: 'default.updated.message', args: [message(code: 'reference.label', default: 'Reference'), referenceInstance.id])}"
                redirect(action: "show", id: referenceInstance.id)
            }
            else {
                render(view: "edit", model: [referenceInstance: referenceInstance])
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'reference.label', default: 'Reference'), params.id])}"
            redirect(action: "list")
        }
    }

    def delete = {
        def referenceInstance = Reference.get(params.id)
        if (referenceInstance) {
            try {
                referenceInstance.delete(flush: true)
                flash.message = "${message(code: 'default.deleted.message', args: [message(code: 'reference.label', default: 'Reference'), params.id])}"
                redirect(action: "list")
            }
            catch (org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "${message(code: 'default.not.deleted.message', args: [message(code: 'reference.label', default: 'Reference'), params.id])}"
                redirect(action: "show", id: params.id)
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'reference.label', default: 'Reference'), params.id])}"
            redirect(action: "list")
        }
    }
}
