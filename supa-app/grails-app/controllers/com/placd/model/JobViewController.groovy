package com.placd.model

class JobViewController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index = {
        redirect(action: "list", params: params)
    }

    def list = {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [jobViewInstanceList: JobView.list(params), jobViewInstanceTotal: JobView.count()]
    }

    def create = {
        def jobViewInstance = new JobView()
        jobViewInstance.properties = params
        return [jobViewInstance: jobViewInstance]
    }

    def save = {
        def jobViewInstance = new JobView(params)
        if (jobViewInstance.save(flush: true)) {
            flash.message = "${message(code: 'default.created.message', args: [message(code: 'jobView.label', default: 'JobView'), jobViewInstance.id])}"
            redirect(action: "show", id: jobViewInstance.id)
        }
        else {
            render(view: "create", model: [jobViewInstance: jobViewInstance])
        }
    }

    def show = {
        def jobViewInstance = JobView.get(params.id)
        if (!jobViewInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'jobView.label', default: 'JobView'), params.id])}"
            redirect(action: "list")
        }
        else {
            [jobViewInstance: jobViewInstance]
        }
    }

    def edit = {
        def jobViewInstance = JobView.get(params.id)
        if (!jobViewInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'jobView.label', default: 'JobView'), params.id])}"
            redirect(action: "list")
        }
        else {
            return [jobViewInstance: jobViewInstance]
        }
    }

    def update = {
        def jobViewInstance = JobView.get(params.id)
        if (jobViewInstance) {
            if (params.version) {
                def version = params.version.toLong()
                if (jobViewInstance.version > version) {
                    
                    jobViewInstance.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'jobView.label', default: 'JobView')] as Object[], "Another user has updated this JobView while you were editing")
                    render(view: "edit", model: [jobViewInstance: jobViewInstance])
                    return
                }
            }
            jobViewInstance.properties = params
            if (!jobViewInstance.hasErrors() && jobViewInstance.save(flush: true)) {
                flash.message = "${message(code: 'default.updated.message', args: [message(code: 'jobView.label', default: 'JobView'), jobViewInstance.id])}"
                redirect(action: "show", id: jobViewInstance.id)
            }
            else {
                render(view: "edit", model: [jobViewInstance: jobViewInstance])
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'jobView.label', default: 'JobView'), params.id])}"
            redirect(action: "list")
        }
    }

    def delete = {
        def jobViewInstance = JobView.get(params.id)
        if (jobViewInstance) {
            try {
                jobViewInstance.delete(flush: true)
                flash.message = "${message(code: 'default.deleted.message', args: [message(code: 'jobView.label', default: 'JobView'), params.id])}"
                redirect(action: "list")
            }
            catch (org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "${message(code: 'default.not.deleted.message', args: [message(code: 'jobView.label', default: 'JobView'), params.id])}"
                redirect(action: "show", id: params.id)
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'jobView.label', default: 'JobView'), params.id])}"
            redirect(action: "list")
        }
    }
}
