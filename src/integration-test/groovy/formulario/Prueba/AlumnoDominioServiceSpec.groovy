package formulario.Prueba

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class AlumnoDominioServiceSpec extends Specification {

    AlumnoDominioService alumnoDominioService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new AlumnoDominio(...).save(flush: true, failOnError: true)
        //new AlumnoDominio(...).save(flush: true, failOnError: true)
        //AlumnoDominio alumnoDominio = new AlumnoDominio(...).save(flush: true, failOnError: true)
        //new AlumnoDominio(...).save(flush: true, failOnError: true)
        //new AlumnoDominio(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //alumnoDominio.id
    }

    void "test get"() {
        setupData()

        expect:
        alumnoDominioService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<AlumnoDominio> alumnoDominioList = alumnoDominioService.list(max: 2, offset: 2)

        then:
        alumnoDominioList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        alumnoDominioService.count() == 5
    }

    void "test delete"() {
        Long alumnoDominioId = setupData()

        expect:
        alumnoDominioService.count() == 5

        when:
        alumnoDominioService.delete(alumnoDominioId)
        sessionFactory.currentSession.flush()

        then:
        alumnoDominioService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        AlumnoDominio alumnoDominio = new AlumnoDominio()
        alumnoDominioService.save(alumnoDominio)

        then:
        alumnoDominio.id != null
    }
}
