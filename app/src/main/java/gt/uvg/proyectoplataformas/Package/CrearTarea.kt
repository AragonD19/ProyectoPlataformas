package gt.uvg.proyectoplataformas.Package

import Tareas
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import gt.uvg.proyectoplataformas.Database
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
    var handler: Handler = Handler()
    var runnable: Runnable? = null
    var delay = 500

    override fun onResume() {
        super.onResume()
        val listaNombres = arrayOf("Adrian", "David", "Renatto")
        val arrayAdapter = ArrayAdapter(requireContext(), R.layout.dropdown_item, listaNombres)
        
        val view = R.layout.fragment_crear_tarea
        var num = binding.numIncentivo
        num.maxValue = 20
        num.minValue = 1

       /* handler.postDelayed(Runnable {
            handler.postDelayed(runnable!!, delay.toLong())
            Toast.makeText(activity, num.value.toString(), Toast.LENGTH_SHORT).show()
        }.also { runnable = it }, delay.toLong())
        */


        binding.editTextAsignarAHijo.setAdapter(arrayAdapter)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val button5 = view.findViewById<Button>(R.id.button5)


        button5.setOnClickListener{
            var contador = 0
            if (!view.findViewById<TextView>(R.id.editTextNombreTarea).text.isNullOrEmpty() && !view.findViewById<TextView>(R.id.editTextDescripcionTarea).text.isNullOrEmpty() && !view.findViewById<AutoCompleteTextView>(R.id.editTextAsignarAHijo).text.isNullOrEmpty()){
                for (i in Database.listaPadre[0].listaHijos){
                    if(i.nombre.equals(view.findViewById<AutoCompleteTextView>(R.id.editTextAsignarAHijo).text)){
                        Database.listaPadre[0].listaHijos[contador].tareas.add(Tareas())
                        break
                    }
                    contador++
                }


            }
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentCrearTareaBinding.inflate(inflater, container, false)

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