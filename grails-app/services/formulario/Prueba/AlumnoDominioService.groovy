package formulario.Prueba

import grails.gorm.services.Service

@Service(AlumnoDominio)
interface AlumnoDominioService {

    AlumnoDominio get(Serializable id)

    List<AlumnoDominio> list(Map args)

    Long count()

    void delete(Serializable id)

    AlumnoDominio save(AlumnoDominio alumnoDominio)

}