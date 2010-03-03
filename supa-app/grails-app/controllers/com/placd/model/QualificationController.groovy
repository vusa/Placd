package com.placd.model

class QualificationController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index = {
        redirect(action: "list", params: params)
    }

    def list = {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [qualificationInstanceList: Qualification.list(params), qualificationInstanceTotal: Qualification.count()]
    }

    def create = {
        def qualificationInstance = new Qualification()
        qualificationInstance.properties = params
        return [qualificationInstance: qualificationInstance]
    }

    def save = {
        def qualificationInstance = new Qualification(params)
        if (qualificationInstance.save(flush: true)) {
            flash.message = "${message(code: 'default.created.message', args: [message(code: 'qualification.label', default: 'Qualification'), qualificationInstance.id])}"
            redirect(action: "show", id: qualificationInstance.id)
        }
        else {
            render(view: "create", model: [qualificationInstance: qualificationInstance])
        }
    }

    def show = {
        def qualificationInstance = Qualification.get(params.id)
        if (!qualificationInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'qualification.label', default: 'Qualification'), params.id])}"
            redirect(action: "list")
        }
        else {
            [qualificationInstance: qualificationInstance]
        }
    }

    def edit = {
        def qualificationInstance = Qualification.get(params.id)
        if (!qualificationInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'qualification.label', default: 'Qualification'), params.id])}"
            redirect(action: "list")
        }
        else {
            return [qualificationInstance: qualificationInstance]
        }
    }

    def update = {
        def qualificationInstance = Qualification.get(params.id)
        if (qualificationInstance) {
            if (params.version) {
                def version = params.version.toLong()
                if (qualificationInstance.version > version) {
                    
                    qualificationInstance.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'qualification.label', default: 'Qualification')] as Object[], "Another user has updated this Qualification while you were editing")
                    render(view: "edit", model: [qualificationInstance: qualificationInstance])
                    return
                }
            }
            qualificationInstance.properties = params
            if (!qualificationInstance.hasErrors() && qualificationInstance.save(flush: true)) {
                flash.message = "${message(code: 'default.updated.message', args: [message(code: 'qualification.label', default: 'Qualification'), qualificationInstance.id])}"
                redirect(action: "show", id: qualificationInstance.id)
            }
            else {
                render(view: "edit", model: [qualificationInstance: qualificationInstance])
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'qualification.label', default: 'Qualification'), params.id])}"
            redirect(action: "list")
        }
    }

    def delete = {
        def qualificationInstance = Qualification.get(params.id)
        if (qualificationInstance) {
            try {
                qualificationInstance.delete(flush: true)
                flash.message = "${message(code: 'default.deleted.message', args: [message(code: 'qualification.label', default: 'Qualification'), params.id])}"
                redirect(action: "list")
            }
            catch (org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "${message(code: 'default.not.deleted.message', args: [message(code: 'qualification.label', default: 'Qualification'), params.id])}"
                redirect(action: "show", id: params.id)
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'qualification.label', default: 'Qualification'), params.id])}"
            redirect(action: "list")
        }
    }
}
