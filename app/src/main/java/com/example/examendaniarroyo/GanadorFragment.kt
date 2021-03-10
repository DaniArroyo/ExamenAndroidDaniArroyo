package com.example.examendaniarroyo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

lateinit var nombreGanador : String

class GanadorFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var v = inflater.inflate(R.layout.fragment_ganador, container, false)

        var TextViewGanador = v.findViewById<TextView>(R.id.TextViewGanador)
        nombreGanador = arguments?.getString("nombreGanador").toString()
        TextViewGanador.text = nombreGanador

        return v
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            GanadorFragment().apply {
            }
    }
}