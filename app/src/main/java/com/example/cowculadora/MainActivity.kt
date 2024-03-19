package com.example.cowculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
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
            textView.text = paramValue.toString();
            return;
        }
        textView.text = paramValue.toString();
        valor = paramValue;
    }

    public fun getValue(): Int {
        if(estaUsandoAux) return valorAux;
        return valor;
    }

    public fun getStringValue(): String {
        val value = getValue()
        return value.toString();
    }

    public fun setStringValue(paramValue: String) {
        setValue(paramValue.toInt());
    }

    public fun onClickClear(view: View) {
        valor = 0;
        valorAux = 0;
        textView.text = valor.toString();
        estaUsandoAux = false;
        operacao = null;
    }

    public fun onClickDel(view: View) {
        val valorString = getStringValue();
        if(valorString.length <= 1) {
            setValue(0);
            return;
        }
        setStringValue(valorString.dropLast(1));
    }

    public fun onClickNumber(view: View) {
        val valorString = getStringValue();
        val label = (view as Button).text.toString()
        setStringValue(valorString + label)
    }
}