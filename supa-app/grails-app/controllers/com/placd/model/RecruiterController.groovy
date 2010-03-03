package com.placd.model

class RecruiterController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index = {
        redirect(action: "list", params: params)
    }

    def list = {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [recruiterInstanceList: Recruiter.list(params), recruiterInstanceTotal: Recruiter.count()]
    }

    def create = {
        def recruiterInstance = new Recruiter()
        recruiterInstance.properties = params
        return [recruiterInstance: recruiterInstance]
    }

    def save = {
        def recruiterInstance = new Recruiter(params)
        if (recruiterInstance.save(flush: true)) {
            flash.message = "${message(code: 'default.created.message', args: [message(code: 'recruiter.label', default: 'Recruiter'), recruiterInstance.id])}"
            redirect(action: "show", id: recruiterInstance.id)
        }
        else {
            render(view: "create", model: [recruiterInstance: recruiterInstance])
        }
    }

    def show = {
        def recruiterInstance = Recruiter.get(params.id)
        if (!recruiterInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'recruiter.label', default: 'Recruiter'), params.id])}"
            redirect(action: "list")
        }
        else {
            [recruiterInstance: recruiterInstance]
        }
    }

    def edit = {
        def recruiterInstance = Recruiter.get(params.id)
        if (!recruiterInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'recruiter.label', default: 'Recruiter'), params.id])}"
            redirect(action: "list")
        }
        else {
            return [recruiterInstance: recruiterInstance]
        }
    }

    def update = {
        def recruiterInstance = Recruiter.get(params.id)
        if (recruiterInstance) {
            if (params.version) {
                def version = params.version.toLong()
                if (recruiterInstance.version > version) {
                    
                    recruiterInstance.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'recruiter.label', default: 'Recruiter')] as Object[], "Another user has updated this Recruiter while you were editing")
                    render(view: "edit", model: [recruiterInstance: recruiterInstance])
                    return
                }
            }
            recruiterInstance.properties = params
            if (!recruiterInstance.hasErrors() && recruiterInstance.save(flush: true)) {
                flash.message = "${message(code: 'default.updated.message', args: [message(code: 'recruiter.label', default: 'Recruiter'), recruiterInstance.id])}"
                redirect(action: "show", id: recruiterInstance.id)
            }
            else {
                render(view: "edit", model: [recruiterInstance: recruiterInstance])
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'recruiter.label', default: 'Recruiter'), params.id])}"
            redirect(action: "list")
        }
    }

    def delete = {
        def recruiterInstance = Recruiter.get(params.id)
        if (recruiterInstance) {
            try {
                recruiterInstance.delete(flush: true)
                flash.message = "${message(code: 'default.deleted.message', args: [message(code: 'recruiter.label', default: 'Recruiter'), params.id])}"
                redirect(action: "list")
            }
            catch (org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "${message(code: 'default.not.deleted.message', args: [message(code: 'recruiter.label', default: 'Recruiter'), params.id])}"
                redirect(action: "show", id: params.id)
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'recruiter.label', default: 'Recruiter'), params.id])}"
            redirect(action: "list")
        }
    }
}
