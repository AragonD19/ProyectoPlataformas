package gt.uvg.proyectoplataformas.Package

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import gt.uvg.proyectoplataformas.R
import gt.uvg.proyectoplataformas.databinding.FragmentCrearTareaBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [CrearTarea.newInstance] factory method to
 * create an instance of this fragment.
 */
class CrearTarea : Fragment() {
    // TODO: Rename and change types of parameters
    private var _binding: FragmentCrearTareaBinding? = null
    private val binding get() = _binding!!



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentCrearTareaBinding.inflate(inflater, container, false)

        val listaNombres = arrayOf("Adrian", "David", "Renatto")
        val arrayAdapter = ArrayAdapter(requireContext(), R.layout.dropdown_item, listaNombres)

        binding.editTextAsignarAHijo.setAdapter(arrayAdapter)
        return binding.root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment CrearTarea.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            CrearTarea().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}