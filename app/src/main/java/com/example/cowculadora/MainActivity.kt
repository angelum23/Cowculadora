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

    fun getStringValue(): String {
        val value = getValue()
        return value.toString();
    }

    fun setStringValue(paramValue: String) {
        setValue(paramValue.toInt());
    }

    fun usarValorAux() {
        estaUsandoAux = true;
        textView.text = valorAux.toString();
    }

    fun usarValorPrincipal() {
        val resultado = retornaResultado()
        estaUsandoAux = false;
        operacao = null;
        valor = resultado;
        valorAux = 0;
        textView.text = resultado.toString();
    }

    fun retornaResultado(): Int {
        if (operacao === Operacao.mais) {
            return valor + valorAux;
        }
        if (operacao === Operacao.menos) {
            return valor - valorAux;
        }
        if (operacao === Operacao.multiplicar) {
            return valor * valorAux;
        }
        if (operacao === Operacao.dividir) {
            if (valorAux == 0) {
                onClear();
                return 0;
            }
            return valor / valorAux;
        }

        return valor;
    }

    fun definirOperacao(paramOperacao: Operacao) {
        if (operacao != null) {
            if(valorAux == 0) {
                operacao = paramOperacao;
                return;
            }

            usarValorPrincipal();
            return;
        }

        operacao = paramOperacao;
        usarValorAux();
    }

    fun onClear() {
        valor = 0;
        valorAux = 0;
        textView.text = valor.toString();
        estaUsandoAux = false;
        operacao = null;
    }

    public fun onClickClear(view: View) {
        onClear();
    }

    public fun onClickDel(view: View) {
        val valorString = getStringValue();
        if(valorString.length <= 1) {
            setValue(0);
            return;
        }
        setStringValue(valorString.dropLast(1));
    }

    public fun onClickMais(view: View) {
        definirOperacao(Operacao.mais);
    }
    public fun onClickMenos(view: View) {
        definirOperacao(Operacao.menos);
    }
    public fun onClickMultiplicar(view: View) {
        definirOperacao(Operacao.multiplicar);
    }
    public fun onClickDividir(view: View) {
        definirOperacao(Operacao.dividir);
    }

    public fun onClickIgual(view: View) {
        usarValorPrincipal();
    }

    public fun onClickNumber(view: View) {
        val valorString = getStringValue();
        val label = (view as Button).text.toString()
        setStringValue(valorString + label)
    }
}