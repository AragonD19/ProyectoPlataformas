package gt.uvg.proyectoplataformas

import Padre

object Database {
    const val TYPE_HEADER = 0
    const val TYPE_ITEM = 1

    val listaPadre = ArrayList<Padre>()

    fun getItems(int: Int): ArrayList<Any>{

        val itemList = arrayListOf<Any>()
        var cont = 0

        for (i in listaPadre[int].listaHijos){
            itemList.add(DataItem.Header(i.nombre))
            for(j in i.tareas){
                itemList.add(DataItem.Item(j.id+cont,j.nombre))
                cont++
            }
        }

        return itemList

    }

}