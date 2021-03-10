package com.example.examendaniarroyo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController

lateinit var editTextJugador1: EditText
lateinit var editTextJugador2: EditText

class HomeFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var v =  inflater.inflate(R.layout.fragment_home, container, false)
        var buttonComenzar = v.findViewById<Button>(R.id.buttonComenzar)
        editTextJugador1 = v.findViewById<EditText>(R.id.editTextJugador1)
        editTextJugador2 = v.findViewById<EditText>(R.id.editTextJugador2)


        buttonComenzar.setOnClickListener{
            comenzarJuego()
        }

        return v
    }

    fun comenzarJuego(){
        if (editTextJugador1.text.toString() != "" && editTextJugador2.text.toString() != ""){
            var nombreJugador1 = editTextJugador1.text.toString()
            var nombreJugador2 = editTextJugador2.text.toString()
            var bundle = bundleOf("nombreJugador1" to nombreJugador1, "nombreJugador2" to nombreJugador2)
            findNavController().navigate(R.id.action_homeFragment_to_primerJugadorPreguntaFragment, bundle)
        } else {
            Toast.makeText(requireContext(), "Rellene todos los campos", Toast.LENGTH_LONG).show()
        }
    }

}