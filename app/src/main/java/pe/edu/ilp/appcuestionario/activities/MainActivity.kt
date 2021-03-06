package pe.edu.ilp.appcuestionario.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import pe.edu.ilp.appcuestionario.R
import pe.edu.ilp.appcuestionario.model.Pregunta

class MainActivity : AppCompatActivity() {

    var preguntas = ArrayList<Pregunta>()
    var posicionActual = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        pregunta01();
        pregunta2();
        pregunta3();

        //cargarPreguntas()
        //mostrarPreguntas()


        val btnVerdad = findViewById<android.view.View>(R.id.btnVerdadero)
        btnVerdad.setOnClickListener{
            Toast.makeText(this,"La respuesta es incorrecta", Toast.LENGTH_SHORT).show()

        }

        val btnIncorrecto = findViewById<android.view.View>(R.id.btnFalso)
        btnIncorrecto.setOnClickListener{
            Toast.makeText(this,"La respuesta es correcta", Toast.LENGTH_SHORT).show()
        }

        val btnNext = findViewById<Button>(R.id.btnSiguiente)
        try {
            posicionActual++
            mostrarPreguntas()
        } catch (e:Exception){
            Toast.makeText(this, "No hay mas preguntas Xd", Toast.LENGTH_SHORT).show()
        }

        val btnatras = findViewById<Button>(R.id.btnatras)
        btnNext.setOnClickListener{
            posicionActual --
            mostrarPreguntas()
        }
    }

    fun cargarPreguntas() {
        preguntas.add(Pregunta("Caracas es la capital de Venezuela",true))
        preguntas.add(Pregunta("Piura es un departamento que pertenece a Ecuador", false))
        preguntas.add(Pregunta("Uruguay es un país Latinoamericano", true))
        preguntas.add(Pregunta("Lima es la capital de Chile", false))
    }

    private fun mostrarPreguntas() {
        val textoPregunta = findViewById<TextView>(R.id.tvPregunta)
        textoPregunta.text = preguntas[posicionActual].enunciado
    }

    fun pregunta01(){
        for(i in 50 downTo 1 step 2){

            println("El valor de manera inversa :$i")
        }
    }
    fun pregunta2(){
        val num =5
        var factorial: Long = 1
        for(i in 1..num){
            factorial *= i.toLong()
        }
        println("Factorial de : $num = $factorial")
    }
    fun pregunta3(){
        var base = 5
        var altura:Int=6
        var area=(base*altura)/2
        println("El area de un triangulo es igual a: $area")
    }
}

