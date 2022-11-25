data class Padre(
    val id : Int,
    val codId : String,
    val email : String,
    val contrasena : String,
    var listaHijos : ArrayList<Hijos>
)