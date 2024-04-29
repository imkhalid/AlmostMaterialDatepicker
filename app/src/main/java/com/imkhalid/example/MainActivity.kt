package com.imkhalid.example

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.Toast
import com.imkhalid.materialdatepicker.date.DatePickerFragmentDialog
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.button1).setOnClickListener {
            val dialog = DatePickerFragmentDialog.newInstance({ view, year, monthOfYear, dayOfMonth ->
                val calendar = Calendar.getInstance()
                calendar.set(year, monthOfYear, dayOfMonth)

                val simpleDateFormat = SimpleDateFormat("yyyy-MMM-dd", Locale.getDefault())

                Toast.makeText(applicationContext, simpleDateFormat.format(calendar.time), Toast.LENGTH_SHORT).show()
            }, 2017, 11, 4)
            val calendar = Calendar.getInstance()
            calendar.set(2024, 5, 15)
            dialog.setMinDate( Date().time)
            dialog.setMaxDate( calendar.time.time)
            dialog.show(supportFragmentManager, "tag")
        }
    }
}
