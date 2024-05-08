package formulario.Prueba

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

import formulario.Prueba.AlumnoDominio

class AlumnoDominioController {

    AlumnoDominioService alumnoDominioService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond alumnoDominioService.list(params), model:[alumnoDominioCount: alumnoDominioService.count()]
    }

    def show(Long id) {
        respond alumnoDominioService.get(id)
    }

    def create() {
        respond new AlumnoDominio(params)
    }

    def save(AlumnoDominio alumnoDominio) {
        if (alumnoDominio == null) {
            notFound()
            return
        }

        try {
            alumnoDominioService.save(alumnoDominio)
        } catch (ValidationException e) {
            respond alumnoDominio.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'alumnoDominio.label', default: 'AlumnoDominio'), alumnoDominio.id])
                redirect alumnoDominio
            }
            '*' { respond alumnoDominio, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond alumnoDominioService.get(id)
    }

    def update(AlumnoDominio alumnoDominio) {
        if (alumnoDominio == null) {
            notFound()
            return
        }

        try {
            alumnoDominioService.save(alumnoDominio)
        } catch (ValidationException e) {
            respond alumnoDominio.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'alumnoDominio.label', default: 'AlumnoDominio'), alumnoDominio.id])
                redirect alumnoDominio
            }
            '*'{ respond alumnoDominio, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        alumnoDominioService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'alumnoDominio.label', default: 'AlumnoDominio'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'alumnoDominio.label', default: 'AlumnoDominio'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
