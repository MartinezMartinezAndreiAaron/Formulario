package formulario.Prueba

class NivelAcademico {// bachillerato, uni
    String nombre

    static hasMany = [especialidades: Especialidad]

    static constraints = {
        nombre blank: false, unique: true
    }

    String toString() {
        return nombre
    }
}
