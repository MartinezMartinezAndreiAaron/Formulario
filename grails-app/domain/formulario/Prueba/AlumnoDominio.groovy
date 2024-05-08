package formulario.Prueba

import formulario.Prueba.Especialidad
import formulario.Prueba.NivelAcademico

class AlumnoDominio {
    String nombre
    String apellido_paterno
    String apellido_materno
    String email
    Integer semestre
    String matricula
    NivelAcademico nivelAcademico
    Especialidad especialidad

    static constraints = {
        nombre blank: false
        apellido_paterno blank: false
        apellido_materno blank: false
        email email: true, blank: false, unique: true
        semestre min: 1, max: 1, blank: false
        matricula size: 9..9, blank: false, unique: true
        nivelAcademico nullable: false
        especialidad nullable: false
    }
}
