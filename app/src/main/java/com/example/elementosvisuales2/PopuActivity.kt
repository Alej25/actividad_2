package com.example.elementosvisuales2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.*
import android.widget.Button
import android.widget.PopupMenu
import android.widget.Toast

class PopuActivity : AppCompatActivity() {

    private lateinit var popupmenu: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_popu)
        popupmenu = findViewById(R.id.activity_main_popu)

        popupmenu.setOnClickListener (object: View.OnClickListener {
            override fun onClick(view: View?) {

                val menu = PopupMenu(this@PopuActivity, view)
                val inflater: MenuInflater = menu.menuInflater
                inflater.inflate(R.menu.activity_main_menu, menu.menu)

                menu.setOnMenuItemClickListener(object : MenuItem.OnMenuItemClickListener,
                PopupMenu.OnMenuItemClickListener{
                    override fun onMenuItemClick(menuItem: MenuItem ): Boolean {
                         return when (menuItem.itemId){
                             R.id.new_game->{
                                 mostrar_mensaje("Nuevo juego desde Menu de opciones contextuales")
                             }
                             R.id.help->{
                                 mostrar_mensaje("ayuda desde Menu de opciones contextuales")

                             }
                             else -> false

                         }
                    }

                } )
               menu.show()
            }
        })


    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return  when (item.itemId){ // es un metodo para el cual reotrna un valor dependiendo del valor seleccionado  itemld

            R.id.new_game ->  mostrar_mensaje("Nuevo juego desde menu de opciones ")
            R.id.help -> mostrar_mensaje("ayuda desde menu de opciones ")
            else ->  super.onOptionsItemSelected(item)
        }

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
    fun mostrar_mensaje(msj : String) : Boolean{
        val toast= Toast.makeText(this,msj, Toast.LENGTH_LONG)
        toast.setGravity(Gravity.BOTTOM or Gravity.CENTER,0,0)
        toast.show()
        return true
    }



}