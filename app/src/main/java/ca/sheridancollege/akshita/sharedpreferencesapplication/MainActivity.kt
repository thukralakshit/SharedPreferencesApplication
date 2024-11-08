package ca.sheridancollege.akshita.sharedpreferencesapplication

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.saveButton).setOnClickListener {
            save()
        }
        findViewById<Button>(R.id.clearButton).setOnClickListener {
            clear()
        }
        findViewById<Button>(R.id.retreiveButton).setOnClickListener {
            retrieve()
        }
    }

    fun save() {

        val pref = getPreferences(Context.MODE_PRIVATE)
        val editor = pref.edit()

        var id = findViewById<TextView>(R.id.idText).text.toString().toInt()
        var name = findViewById<TextView>(R.id.nameText).text.toString()

        editor.putInt("id", id)
        editor.putString("name", name)
        editor.commit()
    }

    fun clear() {
        val pref = getPreferences(Context.MODE_PRIVATE)
        val editor = pref.edit()

        editor.clear()
        editor.commit()

        findViewById<TextView>(R.id.idText).text = "0"
        findViewById<TextView>(R.id.nameText).text = ""

    }


    fun retrieve() {
        val pref = getPreferences(Context.MODE_PRIVATE)
        val editor = pref.edit()

        var id = pref.getInt("id", 0)
        var name = pref.getString("name", null)

        Toast.makeText(this, "Student Id: $id \n" + "Student Name: $name \n", Toast.LENGTH_LONG)
            .show()
    }
}