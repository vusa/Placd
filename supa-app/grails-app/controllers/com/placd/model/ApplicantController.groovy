package com.placd.model

class ApplicantController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index = {
        redirect(action: "list", params: params)
    }

    def list = {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [applicantInstanceList: Applicant.list(params), applicantInstanceTotal: Applicant.count()]
    }

    def create = {
        def applicantInstance = new Applicant()
        applicantInstance.properties = params
        return [applicantInstance: applicantInstance]
    }

    def save = {
        def applicantInstance = new Applicant(params)
        if (applicantInstance.save(flush: true)) {
            flash.message = "${message(code: 'default.created.message', args: [message(code: 'applicant.label', default: 'Applicant'), applicantInstance.id])}"
            redirect(action: "show", id: applicantInstance.id)
        }
        else {
            render(view: "create", model: [applicantInstance: applicantInstance])
        }
    }

    def show = {
        def applicantInstance = Applicant.get(params.id)
        if (!applicantInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'applicant.label', default: 'Applicant'), params.id])}"
            redirect(action: "list")
        }
        else {
            [applicantInstance: applicantInstance]
        }
    }

    def edit = {
        def applicantInstance = Applicant.get(params.id)
        if (!applicantInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'applicant.label', default: 'Applicant'), params.id])}"
            redirect(action: "list")
        }
        else {
            return [applicantInstance: applicantInstance]
        }
    }

    def update = {
        def applicantInstance = Applicant.get(params.id)
        if (applicantInstance) {
            if (params.version) {
                def version = params.version.toLong()
                if (applicantInstance.version > version) {
                    
                    applicantInstance.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'applicant.label', default: 'Applicant')] as Object[], "Another user has updated this Applicant while you were editing")
                    render(view: "edit", model: [applicantInstance: applicantInstance])
                    return
                }
            }
            applicantInstance.properties = params
            if (!applicantInstance.hasErrors() && applicantInstance.save(flush: true)) {
                flash.message = "${message(code: 'default.updated.message', args: [message(code: 'applicant.label', default: 'Applicant'), applicantInstance.id])}"
                redirect(action: "show", id: applicantInstance.id)
            }
            else {
                render(view: "edit", model: [applicantInstance: applicantInstance])
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'applicant.label', default: 'Applicant'), params.id])}"
            redirect(action: "list")
        }
    }

    def delete = {
        def applicantInstance = Applicant.get(params.id)
        if (applicantInstance) {
            try {
                applicantInstance.delete(flush: true)
                flash.message = "${message(code: 'default.deleted.message', args: [message(code: 'applicant.label', default: 'Applicant'), params.id])}"
                redirect(action: "list")
            }
            catch (org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "${message(code: 'default.not.deleted.message', args: [message(code: 'applicant.label', default: 'Applicant'), params.id])}"
                redirect(action: "show", id: params.id)
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'applicant.label', default: 'Applicant'), params.id])}"
            redirect(action: "list")
        }
    }
}
