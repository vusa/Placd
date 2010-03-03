package com.placd.model

class UserImageController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index = {
        redirect(action: "list", params: params)
    }

    def list = {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [userImageInstanceList: UserImage.list(params), userImageInstanceTotal: UserImage.count()]
    }

    def create = {
        def userImageInstance = new UserImage()
        userImageInstance.properties = params
        return [userImageInstance: userImageInstance]
    }

    def save = {
        def userImageInstance = new UserImage(params)
        if (userImageInstance.save(flush: true)) {
            flash.message = "${message(code: 'default.created.message', args: [message(code: 'userImage.label', default: 'UserImage'), userImageInstance.id])}"
            redirect(action: "show", id: userImageInstance.id)
        }
        else {
            render(view: "create", model: [userImageInstance: userImageInstance])
        }
    }

    def show = {
        def userImageInstance = UserImage.get(params.id)
        if (!userImageInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'userImage.label', default: 'UserImage'), params.id])}"
            redirect(action: "list")
        }
        else {
            [userImageInstance: userImageInstance]
        }
    }

    def edit = {
        def userImageInstance = UserImage.get(params.id)
        if (!userImageInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'userImage.label', default: 'UserImage'), params.id])}"
            redirect(action: "list")
        }
        else {
            return [userImageInstance: userImageInstance]
        }
    }

    def update = {
        def userImageInstance = UserImage.get(params.id)
        if (userImageInstance) {
            if (params.version) {
                def version = params.version.toLong()
                if (userImageInstance.version > version) {
                    
                    userImageInstance.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'userImage.label', default: 'UserImage')] as Object[], "Another user has updated this UserImage while you were editing")
                    render(view: "edit", model: [userImageInstance: userImageInstance])
                    return
                }
            }
            userImageInstance.properties = params
            if (!userImageInstance.hasErrors() && userImageInstance.save(flush: true)) {
                flash.message = "${message(code: 'default.updated.message', args: [message(code: 'userImage.label', default: 'UserImage'), userImageInstance.id])}"
                redirect(action: "show", id: userImageInstance.id)
            }
            else {
                render(view: "edit", model: [userImageInstance: userImageInstance])
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'userImage.label', default: 'UserImage'), params.id])}"
            redirect(action: "list")
        }
    }

    def delete = {
        def userImageInstance = UserImage.get(params.id)
        if (userImageInstance) {
            try {
                userImageInstance.delete(flush: true)
                flash.message = "${message(code: 'default.deleted.message', args: [message(code: 'userImage.label', default: 'UserImage'), params.id])}"
                redirect(action: "list")
            }
            catch (org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "${message(code: 'default.not.deleted.message', args: [message(code: 'userImage.label', default: 'UserImage'), params.id])}"
                redirect(action: "show", id: params.id)
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'userImage.label', default: 'UserImage'), params.id])}"
            redirect(action: "list")
        }
    }
}
