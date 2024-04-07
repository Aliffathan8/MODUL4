package com.example.modul4alif

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import java.util.Calendar


class MainActivity : AppCompatActivity() {
    var tanggal: EditText? = null
    var waktu: EditText? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tanggal = findViewById<View>(R.id.tanggal) as EditText
        waktu = findViewById<View>(R.id.waktu) as EditText
    }

    fun setTanggal(v: View?) {
        val c = Calendar.getInstance()
        val thn = c[Calendar.YEAR]
        val bln = c[Calendar.MONTH]
        val tgl = c[Calendar.DAY_OF_MONTH]
        val datePickerDialog = DatePickerDialog(this@MainActivity,
            { view, thn, bln, tgl -> tanggal!!.setText(thn.toString() + "-" + (bln + 1) + "-" + tgl) },
            thn,
            bln,
            tgl
        )
        datePickerDialog.show()
    }

    fun setWaktu(v: View?) {
        val c = Calendar.getInstance()
        val jam = c[Calendar.HOUR_OF_DAY]
        val menit = c[Calendar.MINUTE]
        val timePickerDialog = TimePickerDialog(this@MainActivity,
            { view, jam, menit -> waktu!!.setText("$jam:$menit") }, jam, menit, false
        )
        timePickerDialog.show()
    }
}