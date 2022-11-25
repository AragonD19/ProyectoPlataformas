package gt.uvg.proyectoplataformas

object Database {
    const val TYPE_HEADER = 0
    const val TYPE_ITEM = 1

    fun getItems(): ArrayList<Any>{

        val itemList = arrayListOf<Any>()

        itemList.add(DataItem.Header("Pablo"))
        itemList.add(DataItem.Item(1,"barrer"))

        itemList.add(DataItem.Header("Juan"))
        itemList.add(DataItem.Item(1,"lavar los platos"))


        return itemList

    }

}