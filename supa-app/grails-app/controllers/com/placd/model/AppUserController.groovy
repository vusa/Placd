package com.placd.model

class AppUserController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index = {
        redirect(action: "list", params: params)
    }

    def list = {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [appUserInstanceList: AppUser.list(params), appUserInstanceTotal: AppUser.count()]
    }

    def create = {
        def appUserInstance = new AppUser()
        appUserInstance.properties = params
        return [appUserInstance: appUserInstance]
    }

    def save = {
        def appUserInstance = new AppUser(params)
        if (appUserInstance.save(flush: true)) {
            flash.message = "${message(code: 'default.created.message', args: [message(code: 'appUser.label', default: 'AppUser'), appUserInstance.id])}"
            redirect(action: "show", id: appUserInstance.id)
        }
        else {
            render(view: "create", model: [appUserInstance: appUserInstance])
        }
    }

    def show = {
        def appUserInstance = AppUser.get(params.id)
        if (!appUserInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'appUser.label', default: 'AppUser'), params.id])}"
            redirect(action: "list")
        }
        else {
            [appUserInstance: appUserInstance]
        }
    }

    def edit = {
        def appUserInstance = AppUser.get(params.id)
        if (!appUserInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'appUser.label', default: 'AppUser'), params.id])}"
            redirect(action: "list")
        }
        else {
            return [appUserInstance: appUserInstance]
        }
    }

    def update = {
        def appUserInstance = AppUser.get(params.id)
        if (appUserInstance) {
            if (params.version) {
                def version = params.version.toLong()
                if (appUserInstance.version > version) {
                    
                    appUserInstance.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'appUser.label', default: 'AppUser')] as Object[], "Another user has updated this AppUser while you were editing")
                    render(view: "edit", model: [appUserInstance: appUserInstance])
                    return
                }
            }
            appUserInstance.properties = params
            if (!appUserInstance.hasErrors() && appUserInstance.save(flush: true)) {
                flash.message = "${message(code: 'default.updated.message', args: [message(code: 'appUser.label', default: 'AppUser'), appUserInstance.id])}"
                redirect(action: "show", id: appUserInstance.id)
            }
            else {
                render(view: "edit", model: [appUserInstance: appUserInstance])
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'appUser.label', default: 'AppUser'), params.id])}"
            redirect(action: "list")
        }
    }

    def delete = {
        def appUserInstance = AppUser.get(params.id)
        if (appUserInstance) {
            try {
                appUserInstance.delete(flush: true)
                flash.message = "${message(code: 'default.deleted.message', args: [message(code: 'appUser.label', default: 'AppUser'), params.id])}"
                redirect(action: "list")
            }
            catch (org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "${message(code: 'default.not.deleted.message', args: [message(code: 'appUser.label', default: 'AppUser'), params.id])}"
                redirect(action: "show", id: params.id)
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'appUser.label', default: 'AppUser'), params.id])}"
            redirect(action: "list")
        }
    }
}
