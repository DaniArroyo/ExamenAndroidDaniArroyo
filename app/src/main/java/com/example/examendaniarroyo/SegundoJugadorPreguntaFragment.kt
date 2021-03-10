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

lateinit var editTextPreguntaSegundoJugador: EditText
lateinit var editTextRespuestaCorrectaSegundoJugador: EditText

class SegundoJugadorPreguntaFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var v = inflater.inflate(R.layout.fragment_segundo_jugador_pregunta, container, false)


        var textViewSegundoJugador = v.findViewById<TextView>(R.id.textViewSegundoJugador)
        editTextPreguntaSegundoJugador = v.findViewById(R.id.editTextPreguntaSegundoJugador)
        editTextRespuestaCorrectaSegundoJugador = v.findViewById(R.id.editTextRespuestaCorrectaSegundoJugador)
        var buttonSegundoJugadorPregunta = v.findViewById<Button>(R.id.buttonSegundoJugadorPregunta)

        textViewSegundoJugador.text = nombreJugador2


        buttonSegundoJugadorPregunta.setOnClickListener {
            jugador2Pregunta()
        }

        return v
    }

    fun jugador2Pregunta() {
        if (editTextPreguntaSegundoJugador.text.toString() != "" && editTextRespuestaCorrectaSegundoJugador.text.toString() != "") {
            var pregunta = editTextPreguntaSegundoJugador.text.toString()
            var respuestaCorrecta = editTextRespuestaCorrectaSegundoJugador.text.toString()
            var bundle = bundleOf(
                "pregunta" to pregunta,
                "respuestaCorrecta" to respuestaCorrecta
            )
            findNavController().navigate(
                R.id.action_segundoJugadorPreguntaFragment_to_respuestaPrimerJugadorFragment,
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
