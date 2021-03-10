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

lateinit var editTextRespuestaSegundoJugador: EditText
lateinit var respuestaCorrecta : String
var contadorSegundoJugador : Int = 0



class RespuestaSegundoJugadorFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var v = inflater.inflate(R.layout.fragment_respuesta_segundo_jugador, container, false)

        var TextViewNombreSegundoJugador = v.findViewById<TextView>(R.id.TextViewNombreSegundoJugador)
        var textViewPreguntaRealizada = v.findViewById<TextView>(R.id.textViewPreguntaRealizada)
        editTextRespuestaSegundoJugador = v.findViewById(R.id.editTextRespuestaSegundoJugador)
        var buttonRespuestaSegundoJugador = v.findViewById<Button>(R.id.buttonRespuestaSegundoJugador)

        TextViewNombreSegundoJugador.text = nombreJugador2
        textViewPreguntaRealizada.text = arguments?.getString("pregunta")
        respuestaCorrecta = arguments?.getString("respuestaCorrecta").toString()
        contadorPrimerJugador = arguments?.getInt("contadorPrimerJugador")!!

        buttonRespuestaSegundoJugador.setOnClickListener {
            jugador2Responde()
        }

        return v
    }


    fun jugador2Responde(){
        if (editTextRespuestaSegundoJugador.text.toString() != "") {
        if (editTextRespuestaSegundoJugador.text.toString() == respuestaCorrecta) {
            Toast.makeText(requireContext(), "Respuesta Correcta", Toast.LENGTH_LONG).show()
            contadorSegundoJugador++
            if (contadorSegundoJugador == 3){
                var ganador = bundleOf("nombreGanador" to nombreJugador2)
                findNavController().navigate(
                    R.id.action_respuestaSegundoJugadorFragment_to_ganadorFragment, ganador
                )
            }else{
                var bundle = bundleOf("contadorSegundoJugador" to contadorSegundoJugador)
                findNavController().navigate(
                    R.id.action_respuestaSegundoJugadorFragment_to_segundoJugadorPreguntaFragment, bundle
                )
            }
        } else{
            Toast.makeText(requireContext(), "Respuesta Incorrecta", Toast.LENGTH_LONG).show()
            var bundle = bundleOf("contadorSegundoJugador" to contadorSegundoJugador)
            findNavController().navigate(
                R.id.action_respuestaSegundoJugadorFragment_to_segundoJugadorPreguntaFragment, bundle
            )
        }

        } else {
            Toast.makeText(requireContext(), "Rellene todos los campos", Toast.LENGTH_LONG).show()
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            RespuestaSegundoJugadorFragment().apply {

            }
    }
}