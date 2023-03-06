package com.lahrachtech.textinputlayout

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.dialog_branche.view.*

class MainActivity : AppCompatActivity() {
    lateinit var mDatabase: DatabaseReference;
    lateinit var nameOfTheBranches: ArrayList<String>
    override fun onStart() {
        super.onStart()
        mDatabase.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                nameOfTheBranches.clear()
                for (item in snapshot.children) {
                    val getBranche = item.getValue(Branche::class.java)
                    nameOfTheBranches.add ( 0,getBranche!!.brancheName)
                }
                val adapter = ArrayAdapter(this@MainActivity, android.R.layout.simple_dropdown_item_1line, nameOfTheBranches)
                chooseBranch.setAdapter(adapter)
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@MainActivity, "error", Toast.LENGTH_SHORT).show()
            }
        })
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mDatabase = FirebaseDatabase.getInstance().getReference("branches");
        nameOfTheBranches = arrayListOf()
        faBtnAddBranch.setOnClickListener {
            val (view, alertDialog) = alertBuilder(R.layout.dialog_branche)
            alertDialog.show()
            view.btnAddNote.setOnClickListener {
                val content = view.etBrancheName.text.toString()
                if (content.isNotEmpty()) {
                    val id = mDatabase.push().key
                    val branche = Branche(id!!, content, content.acronym())
                    mDatabase.child(id).setValue(branche)
                    nameOfTheBranches.add(branche.brancheName)

                    alertDialog.dismiss()
                } else {
                    Toast.makeText(this, "errrooooorrrr", Toast.LENGTH_SHORT).show()
                }

            }
        }
    }

    private fun alertBuilder(srcLayout: Int): Pair<android.view.View, AlertDialog> {
        val alertBuilder = AlertDialog.Builder(this)
        val view = layoutInflater.inflate(srcLayout, null)
        alertBuilder.setView(view)
        val alertDialog = alertBuilder.create()
        return Pair(view, alertDialog)
    }

    fun String.acronym(): String {
        var acronym = ""
        val words = this.trim().split("\\s+".toRegex())
        for (word in words) {
            val firstCapitalLetter = word.trim().first().uppercaseChar()
            acronym += firstCapitalLetter
        }
        return acronym
    }

}