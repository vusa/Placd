package com.placd.model

class PersonalDetailsController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index = {
        redirect(action: "list", params: params)
    }

    def list = {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [personalDetailsInstanceList: PersonalDetails.list(params), personalDetailsInstanceTotal: PersonalDetails.count()]
    }

    def create = {
        def personalDetailsInstance = new PersonalDetails()
        personalDetailsInstance.properties = params
        return [personalDetailsInstance: personalDetailsInstance]
    }

    def save = {
        def personalDetailsInstance = new PersonalDetails(params)
        if (personalDetailsInstance.save(flush: true)) {
            flash.message = "${message(code: 'default.created.message', args: [message(code: 'personalDetails.label', default: 'PersonalDetails'), personalDetailsInstance.id])}"
            redirect(action: "show", id: personalDetailsInstance.id)
        }
        else {
            render(view: "create", model: [personalDetailsInstance: personalDetailsInstance])
        }
    }

    def show = {
        def personalDetailsInstance = PersonalDetails.get(params.id)
        if (!personalDetailsInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'personalDetails.label', default: 'PersonalDetails'), params.id])}"
            redirect(action: "list")
        }
        else {
            [personalDetailsInstance: personalDetailsInstance]
        }
    }

    def edit = {
        def personalDetailsInstance = PersonalDetails.get(params.id)
        if (!personalDetailsInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'personalDetails.label', default: 'PersonalDetails'), params.id])}"
            redirect(action: "list")
        }
        else {
            return [personalDetailsInstance: personalDetailsInstance]
        }
    }

    def update = {
        def personalDetailsInstance = PersonalDetails.get(params.id)
        if (personalDetailsInstance) {
            if (params.version) {
                def version = params.version.toLong()
                if (personalDetailsInstance.version > version) {
                    
                    personalDetailsInstance.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'personalDetails.label', default: 'PersonalDetails')] as Object[], "Another user has updated this PersonalDetails while you were editing")
                    render(view: "edit", model: [personalDetailsInstance: personalDetailsInstance])
                    return
                }
            }
            personalDetailsInstance.properties = params
            if (!personalDetailsInstance.hasErrors() && personalDetailsInstance.save(flush: true)) {
                flash.message = "${message(code: 'default.updated.message', args: [message(code: 'personalDetails.label', default: 'PersonalDetails'), personalDetailsInstance.id])}"
                redirect(action: "show", id: personalDetailsInstance.id)
            }
            else {
                render(view: "edit", model: [personalDetailsInstance: personalDetailsInstance])
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'personalDetails.label', default: 'PersonalDetails'), params.id])}"
            redirect(action: "list")
        }
    }

    def delete = {
        def personalDetailsInstance = PersonalDetails.get(params.id)
        if (personalDetailsInstance) {
            try {
                personalDetailsInstance.delete(flush: true)
                flash.message = "${message(code: 'default.deleted.message', args: [message(code: 'personalDetails.label', default: 'PersonalDetails'), params.id])}"
                redirect(action: "list")
            }
            catch (org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "${message(code: 'default.not.deleted.message', args: [message(code: 'personalDetails.label', default: 'PersonalDetails'), params.id])}"
                redirect(action: "show", id: params.id)
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'personalDetails.label', default: 'PersonalDetails'), params.id])}"
            redirect(action: "list")
        }
    }
}
