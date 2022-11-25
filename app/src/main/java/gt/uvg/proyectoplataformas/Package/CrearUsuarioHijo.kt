package gt.uvg.proyectoplataformas.Package

import Hijos
import Padre
import Tareas
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import gt.uvg.proyectoplataformas.R
import gt.uvg.proyectoplataformas.Database

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [CrearUsuarioHijo.newInstance] factory method to
 * create an instance of this fragment.
 */
class CrearUsuarioHijo : Fragment() {
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_crear_usuario_hijo, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val inicioHijo = view.findViewById<Button>(R.id.button2)

        inicioHijo.setOnClickListener{
            if (!view.findViewById<TextView>(R.id.editTextTextPersonName).text.isNullOrEmpty()){
                Database.listaPadre[0].listaHijos.add(Hijos(Database.listaPadre[0].listaHijos.size,view.findViewById<TextView>(R.id.editTextTextPersonName).text.toString(),
                    ArrayList<Tareas>(),0))
                Toast.makeText(activity, "Hijo creada exitosamente", Toast.LENGTH_SHORT).show()

            }else {
                Toast.makeText(activity, "Faltan campos por llenar", Toast.LENGTH_SHORT).show()
            }
        }





    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment CrearUsuarioHijo.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            CrearUsuarioHijo().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}