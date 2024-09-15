package com.example.roomdb

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.icu.util.Calendar
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.room.Room
import com.example.roomdb.databinding.FragmentAddBinding

class AddFragment : Fragment() {

    lateinit var binding: FragmentAddBinding

    private var showTime: String? = null
    private var selectedDate: String? = null

   lateinit var database: NoteDataBase

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddBinding.inflate(inflater, container, false)


        database =
            Room.databaseBuilder(requireActivity(),
                NoteDataBase::class.java, "Note-DB").allowMainThreadQueries().build()

        binding.datePickerBtn.setOnClickListener {

            pickaDate()

        }
        binding.timePickerBtn.setOnClickListener {

            pickATime()
        }

        binding.submitBTN.setOnClickListener {

            var titleStr = binding.titleET.text.toString()
            var timeStr = showTime ?: "00:00"
            var dateStr = selectedDate ?: "12-12-24"


            val note = Note(title = titleStr, time = timeStr, date = dateStr)

            database.getNoteDao().insertData(note)


            findNavController().navigate(R.id.action_addFragment_to_homeFragment)


        }




        return binding.root
    }

    private fun pickATime() {
        val c = Calendar.getInstance()

        val minute = c.get(Calendar.MINUTE)
        val hour = c.get(Calendar.HOUR_OF_DAY)

        val showTime = TimePickerDialog(

            requireActivity(), TimePickerDialog.OnTimeSetListener { _, hourOfDay, minute ->

                showTime = "$hourOfDay: $minute"
                binding.timePickerBtn.text = showTime

            }, hour, minute, false


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
            { _, year, month, dayOfMonth ->

                selectedDate = "$dayOfMonth/$month/$year"
                binding.datePickerBtn.text = selectedDate
            },
            year, month, date

        )
        showDate.show()


    }


}


