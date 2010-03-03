package com.placd.model

class KeySkillsController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index = {
        redirect(action: "list", params: params)
    }

    def list = {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [keySkillsInstanceList: KeySkills.list(params), keySkillsInstanceTotal: KeySkills.count()]
    }

    def create = {
        def keySkillsInstance = new KeySkills()
        keySkillsInstance.properties = params
        return [keySkillsInstance: keySkillsInstance]
    }

    def save = {
        def keySkillsInstance = new KeySkills(params)
        if (keySkillsInstance.save(flush: true)) {
            flash.message = "${message(code: 'default.created.message', args: [message(code: 'keySkills.label', default: 'KeySkills'), keySkillsInstance.id])}"
            redirect(action: "show", id: keySkillsInstance.id)
        }
        else {
            render(view: "create", model: [keySkillsInstance: keySkillsInstance])
        }
    }

    def show = {
        def keySkillsInstance = KeySkills.get(params.id)
        if (!keySkillsInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'keySkills.label', default: 'KeySkills'), params.id])}"
            redirect(action: "list")
        }
        else {
            [keySkillsInstance: keySkillsInstance]
        }
    }

    def edit = {
        def keySkillsInstance = KeySkills.get(params.id)
        if (!keySkillsInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'keySkills.label', default: 'KeySkills'), params.id])}"
            redirect(action: "list")
        }
        else {
            return [keySkillsInstance: keySkillsInstance]
        }
    }

    def update = {
        def keySkillsInstance = KeySkills.get(params.id)
        if (keySkillsInstance) {
            if (params.version) {
                def version = params.version.toLong()
                if (keySkillsInstance.version > version) {
                    
                    keySkillsInstance.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'keySkills.label', default: 'KeySkills')] as Object[], "Another user has updated this KeySkills while you were editing")
                    render(view: "edit", model: [keySkillsInstance: keySkillsInstance])
                    return
                }
            }
            keySkillsInstance.properties = params
            if (!keySkillsInstance.hasErrors() && keySkillsInstance.save(flush: true)) {
                flash.message = "${message(code: 'default.updated.message', args: [message(code: 'keySkills.label', default: 'KeySkills'), keySkillsInstance.id])}"
                redirect(action: "show", id: keySkillsInstance.id)
            }
            else {
                render(view: "edit", model: [keySkillsInstance: keySkillsInstance])
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'keySkills.label', default: 'KeySkills'), params.id])}"
            redirect(action: "list")
        }
    }

    def delete = {
        def keySkillsInstance = KeySkills.get(params.id)
        if (keySkillsInstance) {
            try {
                keySkillsInstance.delete(flush: true)
                flash.message = "${message(code: 'default.deleted.message', args: [message(code: 'keySkills.label', default: 'KeySkills'), params.id])}"
                redirect(action: "list")
            }
            catch (org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "${message(code: 'default.not.deleted.message', args: [message(code: 'keySkills.label', default: 'KeySkills'), params.id])}"
                redirect(action: "show", id: params.id)
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'keySkills.label', default: 'KeySkills'), params.id])}"
            redirect(action: "list")
        }
    }
}
