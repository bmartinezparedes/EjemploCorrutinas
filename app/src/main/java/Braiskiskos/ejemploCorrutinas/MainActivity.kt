package Braiskiskos.ejemploCorrutinas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
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

        val job= GlobalScope.launch(Dispatchers.Main){

        }
    }
}