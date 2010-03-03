package com.placd.model

class JobController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index = {
        redirect(action: "list", params: params)
    }

    def list = {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [jobInstanceList: Job.list(params), jobInstanceTotal: Job.count()]
    }

    def create = {
        def jobInstance = new Job()
        jobInstance.properties = params
        return [jobInstance: jobInstance]
    }

    def save = {
        def jobInstance = new Job(params)
        if (jobInstance.save(flush: true)) {
            flash.message = "${message(code: 'default.created.message', args: [message(code: 'job.label', default: 'Job'), jobInstance.id])}"
            redirect(action: "show", id: jobInstance.id)
        }
        else {
            render(view: "create", model: [jobInstance: jobInstance])
        }
    }

    def show = {
        def jobInstance = Job.get(params.id)
        if (!jobInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'job.label', default: 'Job'), params.id])}"
            redirect(action: "list")
        }
        else {
            [jobInstance: jobInstance]
        }
    }

    def edit = {
        def jobInstance = Job.get(params.id)
        if (!jobInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'job.label', default: 'Job'), params.id])}"
            redirect(action: "list")
        }
        else {
            return [jobInstance: jobInstance]
        }
    }

    def update = {
        def jobInstance = Job.get(params.id)
        if (jobInstance) {
            if (params.version) {
                def version = params.version.toLong()
                if (jobInstance.version > version) {
                    
                    jobInstance.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'job.label', default: 'Job')] as Object[], "Another user has updated this Job while you were editing")
                    render(view: "edit", model: [jobInstance: jobInstance])
                    return
                }
            }
            jobInstance.properties = params
            if (!jobInstance.hasErrors() && jobInstance.save(flush: true)) {
                flash.message = "${message(code: 'default.updated.message', args: [message(code: 'job.label', default: 'Job'), jobInstance.id])}"
                redirect(action: "show", id: jobInstance.id)
            }
            else {
                render(view: "edit", model: [jobInstance: jobInstance])
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'job.label', default: 'Job'), params.id])}"
            redirect(action: "list")
        }
    }

    def delete = {
        def jobInstance = Job.get(params.id)
        if (jobInstance) {
            try {
                jobInstance.delete(flush: true)
                flash.message = "${message(code: 'default.deleted.message', args: [message(code: 'job.label', default: 'Job'), params.id])}"
                redirect(action: "list")
            }
            catch (org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "${message(code: 'default.not.deleted.message', args: [message(code: 'job.label', default: 'Job'), params.id])}"
                redirect(action: "show", id: params.id)
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'job.label', default: 'Job'), params.id])}"
            redirect(action: "list")
        }
    }
}
