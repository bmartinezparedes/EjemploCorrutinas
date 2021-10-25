package Braiskiskos.ejemploCorrutinas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val miBoton: Button = findViewById(R.id.miBoton)

        miBoton.setOnClickListener {
        lanzarCorrutina()
        }
    }
    private fun lanzarCorrutina(){
        val miTexto:TextView=findViewById(R.id.miText)
        val job= GlobalScope.launch(Dispatchers.Main){
            suspendingTask(miTexto)
        }
        val job2= GlobalScope.launch(Dispatchers.Main){
            job.join()
            suspendingTask2(miTexto)
        }
    }
    suspend fun suspendingTask(miTexto: TextView){
        miTexto.text="Hola"
        delay(3000L)
        miTexto.text="Corrutine"
    }
    suspend private fun suspendingTask2(miTexto: TextView){
        delay(1500L)
        miTexto.text="Task 2"
    }
}