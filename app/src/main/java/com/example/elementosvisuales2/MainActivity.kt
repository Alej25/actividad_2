package com.example.elementosvisuales2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.*
import android.widget.AdapterView.OnItemClickListener
import android.widget.AdapterView.OnItemLongClickListener
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
     private  lateinit var lista: ListView
     private val dias = arrayOf("Lunes",  " Martes ", "Miercoles " ,"Jueves" , "Viernes" ,"sabado " , "Domingo ")
     private val  list: ArrayList<String> = ArrayList(dias.toList())


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lista= findViewById(R.id.main_activity_lista)
        val adapter = ArrayAdapter(this,
            R.layout.activity_main,
            R.id.main_activity_text,
            list
            )
        lista.adapter=adapter

        lista.onItemClickListener = OnItemClickListener{adapterView, view, i, l ->
        Toast.makeText(this,list[i],Toast.LENGTH_LONG).show()

    }
        registerForContextMenu(lista)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater//  menuinflater permite convertir un archivo xml a un tipo menu en  un objeto porgramable
        inflater.inflate(R.menu.activity_main_menu,menu)// mandar a llamarel metodo innflater  
        return true
    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    )
    {
        super.onCreateContextMenu(menu, v, menuInfo)
        val inflater = menuInflater
        inflater.inflate(R.menu.activity_main_menu,menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return  when (item.itemId){ // es un metodo para el cual reotrna un valor dependiendo del valor seleccionado  itemld

            R.id.new_game ->  mostrar_mensaje("Nuevo juego desde menu de opciones ")
            R.id.help -> mostrar_mensaje("ayuda desde menu de opciones ")
            else ->  super.onOptionsItemSelected(item)
        }

    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        return  when (item.itemId)
        {
            R.id.new_game->{
                mostrar_mensaje("Nuevo juego desde Menu de opciones contextuales")
            }
            R.id.help->{
                mostrar_mensaje("ayuda desde Menu de opciones contextuales")

            }
            else->super.onContextItemSelected(item)
        }
    }

    fun mostrar_mensaje(msj : String) : Boolean{
        val toast=Toast.makeText(this,msj,Toast.LENGTH_LONG)
        toast.setGravity(Gravity.BOTTOM or Gravity.CENTER,0,0)
        toast.show()
        return true
    }
}