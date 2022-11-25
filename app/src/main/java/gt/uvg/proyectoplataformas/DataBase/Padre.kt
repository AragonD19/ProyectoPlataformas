package gt.uvg.proyectoplataformas.DataBase

data class Padre(
    val id : Int,
    val codId : String,
    val email : String,
    val contrasena : String,
    val listaHijos : List<Hijos>
)
