package com.placd.model

class ExperienceController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index = {
        redirect(action: "list", params: params)
    }

    def list = {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [experienceInstanceList: Experience.list(params), experienceInstanceTotal: Experience.count()]
    }

    def create = {
        def experienceInstance = new Experience()
        experienceInstance.properties = params
        return [experienceInstance: experienceInstance]
    }

    def save = {
        def experienceInstance = new Experience(params)
        if (experienceInstance.save(flush: true)) {
            flash.message = "${message(code: 'default.created.message', args: [message(code: 'experience.label', default: 'Experience'), experienceInstance.id])}"
            redirect(action: "show", id: experienceInstance.id)
        }
        else {
            render(view: "create", model: [experienceInstance: experienceInstance])
        }
    }

    def show = {
        def experienceInstance = Experience.get(params.id)
        if (!experienceInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'experience.label', default: 'Experience'), params.id])}"
            redirect(action: "list")
        }
        else {
            [experienceInstance: experienceInstance]
        }
    }

    def edit = {
        def experienceInstance = Experience.get(params.id)
        if (!experienceInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'experience.label', default: 'Experience'), params.id])}"
            redirect(action: "list")
        }
        else {
            return [experienceInstance: experienceInstance]
        }
    }

    def update = {
        def experienceInstance = Experience.get(params.id)
        if (experienceInstance) {
            if (params.version) {
                def version = params.version.toLong()
                if (experienceInstance.version > version) {
                    
                    experienceInstance.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'experience.label', default: 'Experience')] as Object[], "Another user has updated this Experience while you were editing")
                    render(view: "edit", model: [experienceInstance: experienceInstance])
                    return
                }
            }
            experienceInstance.properties = params
            if (!experienceInstance.hasErrors() && experienceInstance.save(flush: true)) {
                flash.message = "${message(code: 'default.updated.message', args: [message(code: 'experience.label', default: 'Experience'), experienceInstance.id])}"
                redirect(action: "show", id: experienceInstance.id)
            }
            else {
                render(view: "edit", model: [experienceInstance: experienceInstance])
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'experience.label', default: 'Experience'), params.id])}"
            redirect(action: "list")
        }
    }

    def delete = {
        def experienceInstance = Experience.get(params.id)
        if (experienceInstance) {
            try {
                experienceInstance.delete(flush: true)
                flash.message = "${message(code: 'default.deleted.message', args: [message(code: 'experience.label', default: 'Experience'), params.id])}"
                redirect(action: "list")
            }
            catch (org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "${message(code: 'default.not.deleted.message', args: [message(code: 'experience.label', default: 'Experience'), params.id])}"
                redirect(action: "show", id: params.id)
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'experience.label', default: 'Experience'), params.id])}"
            redirect(action: "list")
        }
    }
}
