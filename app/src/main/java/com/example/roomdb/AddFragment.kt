package com.example.roomdb

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.icu.util.Calendar
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.roomdb.databinding.FragmentAddBinding

class AddFragment : Fragment() {

    lateinit var binding: FragmentAddBinding
//    private var selectedDate: String? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddBinding.inflate(inflater, container, false)

        binding.datePickerBtn.setOnClickListener {

            pickaDate()

        }
        binding.timePickerBtn.setOnClickListener {

            pickATime()
        }


        return binding.root
    }

    private fun pickATime() {
        val c = Calendar.getInstance()

        val minute = c.get(Calendar.MINUTE)
        val hour = c.get(Calendar.HOUR_OF_DAY)

        val showTime = TimePickerDialog(

            requireActivity(),TimePickerDialog.OnTimeSetListener{
                _,hour,minute ->

                val showTime = "$hour: $minute"

            },hour,minute,false


        )
        showTime.show()
    }



    private fun pickaDate() {
        val calender = Calendar.getInstance()

        val date = calender.get(Calendar.DAY_OF_MONTH)
        val month = calender.get(Calendar.MONTH)
        val year = calender.get(Calendar.YEAR)

        val showDate = DatePickerDialog(
            requireActivity(),
            {  _, year, month, dayOfMonth ->

             val   selectedDate = "$dayOfMonth/$month/$year"
                binding.datePickerBtn.text = selectedDate
            },
            year,month,date

        )
        showDate.show()


    }


}


