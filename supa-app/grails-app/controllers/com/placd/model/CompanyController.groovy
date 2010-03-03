package com.placd.model

class CompanyController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index = {
        redirect(action: "list", params: params)
    }

    def list = {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [companyInstanceList: Company.list(params), companyInstanceTotal: Company.count()]
    }

    def create = {
        def companyInstance = new Company()
        companyInstance.properties = params
        return [companyInstance: companyInstance]
    }

    def save = {
        def companyInstance = new Company(params)
        if (companyInstance.save(flush: true)) {
            flash.message = "${message(code: 'default.created.message', args: [message(code: 'company.label', default: 'Company'), companyInstance.id])}"
            redirect(action: "show", id: companyInstance.id)
        }
        else {
            render(view: "create", model: [companyInstance: companyInstance])
        }
    }

    def show = {
        def companyInstance = Company.get(params.id)
        if (!companyInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'company.label', default: 'Company'), params.id])}"
            redirect(action: "list")
        }
        else {
            [companyInstance: companyInstance]
        }
    }

    def edit = {
        def companyInstance = Company.get(params.id)
        if (!companyInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'company.label', default: 'Company'), params.id])}"
            redirect(action: "list")
        }
        else {
            return [companyInstance: companyInstance]
        }
    }

    def update = {
        def companyInstance = Company.get(params.id)
        if (companyInstance) {
            if (params.version) {
                def version = params.version.toLong()
                if (companyInstance.version > version) {
                    
                    companyInstance.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'company.label', default: 'Company')] as Object[], "Another user has updated this Company while you were editing")
                    render(view: "edit", model: [companyInstance: companyInstance])
                    return
                }
            }
            companyInstance.properties = params
            if (!companyInstance.hasErrors() && companyInstance.save(flush: true)) {
                flash.message = "${message(code: 'default.updated.message', args: [message(code: 'company.label', default: 'Company'), companyInstance.id])}"
                redirect(action: "show", id: companyInstance.id)
            }
            else {
                render(view: "edit", model: [companyInstance: companyInstance])
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'company.label', default: 'Company'), params.id])}"
            redirect(action: "list")
        }
    }

    def delete = {
        def companyInstance = Company.get(params.id)
        if (companyInstance) {
            try {
                companyInstance.delete(flush: true)
                flash.message = "${message(code: 'default.deleted.message', args: [message(code: 'company.label', default: 'Company'), params.id])}"
                redirect(action: "list")
            }
            catch (org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "${message(code: 'default.not.deleted.message', args: [message(code: 'company.label', default: 'Company'), params.id])}"
                redirect(action: "show", id: params.id)
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'company.label', default: 'Company'), params.id])}"
            redirect(action: "list")
        }
    }
}
