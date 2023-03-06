package com.lahrachtech.textinputlayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val branches = arrayOf(
            "Computer Science",
            "Mechanical Engineering",
            "Electrical Engineering",
            "Civil Engineering",
            "Chemical Engineering",
            "Aerospace Engineering",
            "Industrial Engineering",
            "Materials Science and Engineering",
            "Biomedical Engineering",
            "Environmental Science",
            "Physics",
            "Mathematics",
            "Chemistry",
            "Biology",
            "Biochemistry",
            "Neuroscience",
            "Psychology",
            "Sociology",
            "Anthropology",
            "History",
            "Political Science",
            "Economics",
            "Business Administration",
            "Accounting",
            "Marketing",
            "Management",
            "Human Resources Management",
            "Finance",
            "Law",
            "Medicine",
            "Nursing",
            "Pharmacy",
            "Dentistry",
            "Physical Therapy",
            "Occupational Therapy",
            "Veterinary Medicine",
            "Agriculture",
            "Forestry",
            "Geology",
            "Geophysics",
            "Meteorology",
            "Oceanography",
            "Architecture",
            "Urban Planning",
            "Landscape Architecture",
            "Art",
            "Music",
            "Theater",
            "Film Studies",
            "Linguistics"
        )

        val adapter = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, branches)
        chooseBranch.setAdapter(adapter)
    }
}