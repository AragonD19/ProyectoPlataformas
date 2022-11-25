package gt.uvg.proyectoplataformas

object Database {
    const val TYPE_HEADER = 0
    const val TYPE_ITEM = 1

    fun getItems(): ArrayList<Any>{

        val itemList = arrayListOf<Any>()

        itemList.add(DataItem.Header("Santi"))
        itemList.add(DataItem.Item(1,"Lavar el carro"))
        itemList.add(DataItem.Item(2,"Sacar la basura"))
        itemList.add(DataItem.Item(3,"barrer la casa"))
        itemList.add(DataItem.Item(4,"lavar la ropa"))

        itemList.add(DataItem.Header("Ivania"))
        itemList.add(DataItem.Item(5,"Lavar el carro"))
        itemList.add(DataItem.Item(6,"Hacer la tarea"))
        itemList.add(DataItem.Item(7,"Lavar la ropa"))


        return itemList

    }

}