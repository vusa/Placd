package com.placd.model

class CompanyImageController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index = {
        redirect(action: "list", params: params)
    }

    def list = {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [companyImageInstanceList: CompanyImage.list(params), companyImageInstanceTotal: CompanyImage.count()]
    }

    def create = {
        def companyImageInstance = new CompanyImage()
        companyImageInstance.properties = params
        return [companyImageInstance: companyImageInstance]
    }

    def save = {
        def companyImageInstance = new CompanyImage(params)
        if (companyImageInstance.save(flush: true)) {
            flash.message = "${message(code: 'default.created.message', args: [message(code: 'companyImage.label', default: 'CompanyImage'), companyImageInstance.id])}"
            redirect(action: "show", id: companyImageInstance.id)
        }
        else {
            render(view: "create", model: [companyImageInstance: companyImageInstance])
        }
    }

    def show = {
        def companyImageInstance = CompanyImage.get(params.id)
        if (!companyImageInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'companyImage.label', default: 'CompanyImage'), params.id])}"
            redirect(action: "list")
        }
        else {
            [companyImageInstance: companyImageInstance]
        }
    }

    def edit = {
        def companyImageInstance = CompanyImage.get(params.id)
        if (!companyImageInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'companyImage.label', default: 'CompanyImage'), params.id])}"
            redirect(action: "list")
        }
        else {
            return [companyImageInstance: companyImageInstance]
        }
    }

    def update = {
        def companyImageInstance = CompanyImage.get(params.id)
        if (companyImageInstance) {
            if (params.version) {
                def version = params.version.toLong()
                if (companyImageInstance.version > version) {
                    
                    companyImageInstance.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'companyImage.label', default: 'CompanyImage')] as Object[], "Another user has updated this CompanyImage while you were editing")
                    render(view: "edit", model: [companyImageInstance: companyImageInstance])
                    return
                }
            }
            companyImageInstance.properties = params
            if (!companyImageInstance.hasErrors() && companyImageInstance.save(flush: true)) {
                flash.message = "${message(code: 'default.updated.message', args: [message(code: 'companyImage.label', default: 'CompanyImage'), companyImageInstance.id])}"
                redirect(action: "show", id: companyImageInstance.id)
            }
            else {
                render(view: "edit", model: [companyImageInstance: companyImageInstance])
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'companyImage.label', default: 'CompanyImage'), params.id])}"
            redirect(action: "list")
        }
    }

    def delete = {
        def companyImageInstance = CompanyImage.get(params.id)
        if (companyImageInstance) {
            try {
                companyImageInstance.delete(flush: true)
                flash.message = "${message(code: 'default.deleted.message', args: [message(code: 'companyImage.label', default: 'CompanyImage'), params.id])}"
                redirect(action: "list")
            }
            catch (org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "${message(code: 'default.not.deleted.message', args: [message(code: 'companyImage.label', default: 'CompanyImage'), params.id])}"
                redirect(action: "show", id: params.id)
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'companyImage.label', default: 'CompanyImage'), params.id])}"
            redirect(action: "list")
        }
    }
}
