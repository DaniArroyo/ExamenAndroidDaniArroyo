package com.example.examendaniarroyo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController

lateinit var editTextPreguntaPrimerJugador: EditText
lateinit var editTextRespuestaCorrecta: EditText
lateinit var nombreJugador1: String
lateinit var nombreJugador2: String


class PrimerJugadorPreguntaFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var v = inflater.inflate(R.layout.fragment_primer_jugador_pregunta, container, false)


        var textViewPrimerJugador = v.findViewById<TextView>(R.id.textViewPrimerJugador)
        editTextPreguntaPrimerJugador = v.findViewById<EditText>(R.id.editTextPreguntaPrimerJugador)
        editTextRespuestaCorrecta = v.findViewById<EditText>(R.id.editTextRespuestaCorrecta)
        var buttonPrimerJugadorPregunta = v.findViewById<Button>(R.id.buttonSegundoJugadorPregunta)

        nombreJugador1 = arguments?.getString("nombreJugador1").toString()
        nombreJugador2 = arguments?.getString("nombreJugador2").toString()
        textViewPrimerJugador.text = nombreJugador1


        buttonPrimerJugadorPregunta.setOnClickListener {
            jugador1Pregunta()
        }

        return v
    }

    fun jugador1Pregunta() {
        if (editTextPreguntaPrimerJugador.text.toString() != "" && editTextRespuestaCorrecta.text.toString() != "") {
            var pregunta = editTextPreguntaPrimerJugador.text.toString()
            var respuestaCorrecta = editTextRespuestaCorrecta.text.toString()
            var bundle = bundleOf(
                "pregunta" to pregunta,
                "respuestaCorrecta" to respuestaCorrecta
            )
            findNavController().navigate(
                R.id.action_primerJugadorPreguntaFragment_to_respuestaSegundoJugadorFragment,
                bundle
            )
        } else {
            Toast.makeText(requireContext(), "Rellene todos los campos", Toast.LENGTH_LONG).show()
        }
    }


    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            PrimerJugadorPreguntaFragment().apply {
            }
    }
}