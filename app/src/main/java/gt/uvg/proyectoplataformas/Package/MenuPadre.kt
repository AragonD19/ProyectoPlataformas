package gt.uvg.proyectoplataformas.Package

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import gt.uvg.proyectoplataformas.Adapter
import gt.uvg.proyectoplataformas.Database
import gt.uvg.proyectoplataformas.R
import gt.uvg.proyectoplataformas.databinding.FragmentMenuPadreBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [MenuPadre.newInstance] factory method to
 * create an instance of this fragment.
 */
class MenuPadre : Fragment() {
    // TODO: Rename and change types of parameters
    private var _binding: FragmentMenuPadreBinding? = null
    private val binding get() = _binding!!
    private val adapterList by lazy { Adapter() }

    private lateinit var adapter: Adapter
    private lateinit var recyclerView: RecyclerView



    override fun onResume() {
        super.onResume()

        val view = R.layout.fragment_menu_padre
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentMenuPadreBinding.inflate(inflater, container, false)
        return binding.root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment MenuPadre.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MenuPadre().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val itemList = Database.getItems()

        adapterList.updateList(itemList)
        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.recyclerView2)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        adapter = Adapter()
        recyclerView.adapter = adapterList
    }

}