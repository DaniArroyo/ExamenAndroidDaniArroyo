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

lateinit var editTextRespuestaPrimerJugador: EditText
lateinit var respuestaCorrectaPrimerJugador : String
 var contadorPrimerJugador : Int = 0


class RespuestaPrimerJugadorFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var v = inflater.inflate(R.layout.fragment_respuesta_primer_jugador, container, false)

        var TextViewNombrePrimerJugador = v.findViewById<TextView>(R.id.TextViewNombrePrimerJugador)
        var textViewPreguntaRealizadaPrimerJugador =
            v.findViewById<TextView>(R.id.textViewPreguntaRealizadaPrimerJugador)
        editTextRespuestaPrimerJugador = v.findViewById(R.id.editTextRespuestaPrimerJugador)
        var buttonRespuestaPrimerJugador = v.findViewById<Button>(R.id.buttonRespuestaPrimerJugador)

        TextViewNombrePrimerJugador.text = nombreJugador1
        textViewPreguntaRealizadaPrimerJugador.text = arguments?.getString("pregunta")
        respuestaCorrectaPrimerJugador = arguments?.getString("respuestaCorrecta").toString()
        contadorPrimerJugador = arguments?.getInt("contadorPrimerJugador")!!

        buttonRespuestaPrimerJugador.setOnClickListener {
            jugador1Responde()
        }

        return v
    }


    fun jugador1Responde() {
        if (editTextRespuestaPrimerJugador.text.toString() != "") {
            if (editTextRespuestaPrimerJugador.text.toString() == respuestaCorrectaPrimerJugador) {
                Toast.makeText(requireContext(), "Respuesta Correcta", Toast.LENGTH_LONG).show()
                contadorPrimerJugador++
                    if (contadorPrimerJugador == 3){
                        var ganador = bundleOf("nombreGanador" to nombreJugador1)
                        findNavController().navigate(
                            R.id.action_respuestaPrimerJugadorFragment_to_ganadorFragment, ganador
                        )
                    }else{
                        var bundle = bundleOf("nombreJugador1" to nombreJugador1, "nombreJugador2" to nombreJugador2, "contadorPrimerJugador" to contadorPrimerJugador)
                        findNavController().navigate(
                            R.id.action_respuestaPrimerJugadorFragment_to_primerJugadorPreguntaFragment, bundle
                        )
                    }
            } else {
                Toast.makeText(requireContext(), "Respuesta Incorrecta", Toast.LENGTH_LONG).show()
                var bundle = bundleOf("nombreJugador1" to nombreJugador1, "nombreJugador2" to nombreJugador2, "contadorPrimerJugador" to contadorPrimerJugador)
                findNavController().navigate(
                    R.id.action_respuestaPrimerJugadorFragment_to_primerJugadorPreguntaFragment, bundle
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
