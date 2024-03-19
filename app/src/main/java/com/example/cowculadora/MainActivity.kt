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

    public fun onClickUm(view: View) {
        val valorString = getStringValue();
        setStringValue(valorString + '1')
    }
    public fun onClickDois(view: View) {
        val valorString = getStringValue();
        setStringValue(valorString + '2')
    }
    public fun onClickTres(view: View) {
        val valorString = getStringValue();
        setStringValue(valorString + '3')
    }
    public fun onClickQuatro(view: View) {
        val valorString = getStringValue();
        setStringValue(valorString + '4')
    }
    public fun onClickCinco(view: View) {
        val valorString = getStringValue();
        setStringValue(valorString + '5')
    }
    public fun onClickSeis(view: View) {
        val valorString = getStringValue();
        setStringValue(valorString + '6')
    }
    public fun onClickSete(view: View) {
        val valorString = getStringValue();
        setStringValue(valorString + '7')
    }
    public fun onClickOito(view: View) {
        val valorString = getStringValue();
        setStringValue(valorString + '8')
    }
    public fun onClickNove(view: View) {
        val valorString = getStringValue();
        setStringValue(valorString + '9')
    }
    public fun onClickZero(view: View) {
        val valorString = getStringValue();
        setStringValue(valorString + '0')
    }
}