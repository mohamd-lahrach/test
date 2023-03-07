package com.lahrachtech.textinputlayout

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Toast
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_teacher.*
import kotlin.math.log

class TeacherActivity : AppCompatActivity() {
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
                val branch =getBranchByName()
                if (branch != null) {
                    Log.d("tag", "onCreate:${branch.brancheName} ")
                }else{
                    Toast.makeText(this@TeacherActivity,"NullPointerException",Toast.LENGTH_SHORT).show()
                }
                val adapter = ArrayAdapter(this@TeacherActivity, android.R.layout.simple_dropdown_item_1line, nameOfTheBranches)
                chooseBrancheForTeacher.setAdapter(adapter)
            }
            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@TeacherActivity, "error", Toast.LENGTH_SHORT).show()
            }
        })

    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_teacher)
        mDatabase = FirebaseDatabase.getInstance().getReference("branches");
        nameOfTheBranches = arrayListOf()

    }
    fun getBranchByName(): Branche? {
        var brnch: Branche? =null
        chooseBrancheForTeacher.setOnItemClickListener { parent, view, position, id ->
            mDatabase.addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    for (item in snapshot.children ){
                        val getBranche = item.getValue(Branche::class.java)
                        if (getBranche!!.brancheName==nameOfTheBranches[position]){
                            brnch =getBranche
                        }
                    }
                }

                override fun onCancelled(error: DatabaseError) {
                    Toast.makeText(this@TeacherActivity,"erooooooooor",Toast.LENGTH_SHORT).show()
                }

            })
        }
        return brnch
    }
}