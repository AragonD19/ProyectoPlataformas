package gt.uvg.proyectoplataformas

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import gt.uvg.proyectoplataformas.Database.TYPE_HEADER
import gt.uvg.proyectoplataformas.Database.TYPE_ITEM
import gt.uvg.proyectoplataformas.databinding.HeaderDesingBinding
import gt.uvg.proyectoplataformas.databinding.ItemDesingBinding


class Adapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    class ItemViewHolder(val itemBinding: ItemDesingBinding): RecyclerView.ViewHolder(itemBinding.root){
        fun bind(item: DataItem.Item){
            itemBinding.item = item
        }
    }

    class HeaderViewHolder(val headerBinding: HeaderDesingBinding): RecyclerView.ViewHolder(headerBinding.root){
        fun bind(item: DataItem.Header){
            headerBinding.header = item
        }
    }

    private val itemList = arrayListOf<Any>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when(viewType){
            TYPE_ITEM -> ItemViewHolder(ItemDesingBinding.inflate(LayoutInflater.from(parent.context),parent,false))
            TYPE_HEADER -> HeaderViewHolder(HeaderDesingBinding.inflate(LayoutInflater.from(parent.context),parent,false))
            else -> throw java.lang.IllegalArgumentException("Invalid ViewType")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder){
            is ItemViewHolder -> holder.bind(itemList[position] as DataItem.Item)
            is HeaderViewHolder -> holder.bind(itemList[position] as DataItem.Header)
        }
    }

    override fun getItemCount(): Int = itemList.size

    override fun getItemViewType(position: Int): Int {
        return when(itemList[position]){
            is DataItem.Item -> TYPE_ITEM
            is DataItem.Header -> TYPE_HEADER
            else -> throw java.lang.IllegalArgumentException("Invalid ViewType")
        }
    }

    fun updateList(updatedList: List<Any>){
        itemList.clear()
        itemList.addAll(updatedList)
        notifyDataSetChanged()
    }

}