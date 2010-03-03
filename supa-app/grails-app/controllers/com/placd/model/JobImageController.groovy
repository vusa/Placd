package com.placd.model

class JobImageController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index = {
        redirect(action: "list", params: params)
    }

    def list = {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [jobImageInstanceList: JobImage.list(params), jobImageInstanceTotal: JobImage.count()]
    }

    def create = {
        def jobImageInstance = new JobImage()
        jobImageInstance.properties = params
        return [jobImageInstance: jobImageInstance]
    }

    def save = {
        def jobImageInstance = new JobImage(params)
        if (jobImageInstance.save(flush: true)) {
            flash.message = "${message(code: 'default.created.message', args: [message(code: 'jobImage.label', default: 'JobImage'), jobImageInstance.id])}"
            redirect(action: "show", id: jobImageInstance.id)
        }
        else {
            render(view: "create", model: [jobImageInstance: jobImageInstance])
        }
    }

    def show = {
        def jobImageInstance = JobImage.get(params.id)
        if (!jobImageInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'jobImage.label', default: 'JobImage'), params.id])}"
            redirect(action: "list")
        }
        else {
            [jobImageInstance: jobImageInstance]
        }
    }

    def edit = {
        def jobImageInstance = JobImage.get(params.id)
        if (!jobImageInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'jobImage.label', default: 'JobImage'), params.id])}"
            redirect(action: "list")
        }
        else {
            return [jobImageInstance: jobImageInstance]
        }
    }

    def update = {
        def jobImageInstance = JobImage.get(params.id)
        if (jobImageInstance) {
            if (params.version) {
                def version = params.version.toLong()
                if (jobImageInstance.version > version) {
                    
                    jobImageInstance.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'jobImage.label', default: 'JobImage')] as Object[], "Another user has updated this JobImage while you were editing")
                    render(view: "edit", model: [jobImageInstance: jobImageInstance])
                    return
                }
            }
            jobImageInstance.properties = params
            if (!jobImageInstance.hasErrors() && jobImageInstance.save(flush: true)) {
                flash.message = "${message(code: 'default.updated.message', args: [message(code: 'jobImage.label', default: 'JobImage'), jobImageInstance.id])}"
                redirect(action: "show", id: jobImageInstance.id)
            }
            else {
                render(view: "edit", model: [jobImageInstance: jobImageInstance])
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'jobImage.label', default: 'JobImage'), params.id])}"
            redirect(action: "list")
        }
    }

    def delete = {
        def jobImageInstance = JobImage.get(params.id)
        if (jobImageInstance) {
            try {
                jobImageInstance.delete(flush: true)
                flash.message = "${message(code: 'default.deleted.message', args: [message(code: 'jobImage.label', default: 'JobImage'), params.id])}"
                redirect(action: "list")
            }
            catch (org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "${message(code: 'default.not.deleted.message', args: [message(code: 'jobImage.label', default: 'JobImage'), params.id])}"
                redirect(action: "show", id: params.id)
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'jobImage.label', default: 'JobImage'), params.id])}"
            redirect(action: "list")
        }
    }
}
