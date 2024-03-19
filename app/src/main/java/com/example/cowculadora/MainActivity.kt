package com.example.cowculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

enum class Operacao {
    mais, menos, multiplicar, dividir
}

class MainActivity : AppCompatActivity() {
    lateinit var textView: TextView
    var valor: Int = 0;
    var valorAux: Int = 0;
    var estaUsandoAux: Boolean = false;
    var operacao: Operacao? = null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.textView)
        textView.text = valor.toString()
    }

    public fun setValue(paramValue: Int) {
        if (estaUsandoAux) {
            valorAux = paramValue;
        }
        valor = paramValue;
    }

    public fun getValue(): Int {
        if(estaUsandoAux) return valorAux;
        return valor;
    }

    public fun onClickClear(view: View) {
        valor = 0;
        valorAux = 0;
        textView.text = valor.toString();
        estaUsandoAux = false;
        operacao = null;
    }

    public fun onClickDel() {
        valor = 777;
        val valorString = valor.toString();
        val valorNovo = valorString.dropLast(1).toInt();
        setValue(valorNovo);
    }
}