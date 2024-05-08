package formulario.Prueba

class Especialidad { //enfermeria, software
    String nombre
    NivelAcademico nivelAcademico

    static constraints = {
        nombre blank: false, unique: ['nivelAcademico']
        nivelAcademico nullable: false
    }

    String toString() {
        return nombre
    }
}
