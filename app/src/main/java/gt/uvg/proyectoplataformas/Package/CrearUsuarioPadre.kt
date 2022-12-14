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
 * Use the [CrearUsuarioPadre.newInstance] factory method to
 * create an instance of this fragment.
 */
class CrearUsuarioPadre : Fragment() {
    // TODO: Rename and change types of parameters
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

        return inflater.inflate(R.layout.fragment_crear_usuario_padre, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val button3 = view.findViewById<Button>(R.id.button3)


        button3.setOnClickListener{
            if (!view.findViewById<TextView>(R.id.editTextTextPassword3).text.isNullOrEmpty() &&
                !view.findViewById<TextView>(R.id.editTextTextEmailAddress).text.isNullOrEmpty() &&
                !view.findViewById<TextView>(R.id.editTextTextPersonName2).text.isNullOrEmpty()){
                var flag = false
                for (i in Database.listaPadre){
                    if ( view.findViewById<TextView>(R.id.editTextTextEmailAddress).text.toString() == i.email) {
                        Toast.makeText(activity, "Correo ya utilizado", Toast.LENGTH_SHORT).show()
                        flag = true
                        break
                    }
                }
                if(!flag){
                    val listaTemp = ArrayList<Hijos>()
                    Database.listaPadre.add(Padre(
                        0,getRandomString(6),
                        view.findViewById<TextView>(R.id.editTextTextEmailAddress).text.toString(),view.findViewById<TextView>(R.id.editTextTextPassword3).text.toString(),listaTemp))
                    findNavController().navigate(R.id.action_crearUsuarioPadre_to_mainLogin)
                }
            }else {
                Toast.makeText(activity, "Faltan campos por llenar", Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun getRandomString(length: Int) : String {
        val charset = "ABCDEFGHIJKLMNOPQRSTUVWXTZabcdefghiklmnopqrstuvwxyz0123456789"
        return (1..length)
            .map { charset.random() }
            .joinToString("")
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment CrearUsuarioPadre.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            CrearUsuarioPadre().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}