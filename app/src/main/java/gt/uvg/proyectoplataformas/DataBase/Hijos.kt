package gt.uvg.proyectoplataformas.DataBase

data class Hijos(
    val id : Int,
    val nombre : String,
    val tareas : List<Tareas>,
    val recompensaTot : Int
)

