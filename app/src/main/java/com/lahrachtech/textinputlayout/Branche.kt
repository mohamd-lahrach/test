package com.lahrachtech.textinputlayout

class Branche {
    lateinit var id: String
    lateinit var brancheName: String
    lateinit var acronym: String
    lateinit var years:ArrayList<String>
    lateinit var teachers:ArrayList<Teacher>

    constructor()
    constructor(_id: String, _branchName: String, _acronym: String) {
        this.id = _id
        this.brancheName = _branchName
        this.acronym = _acronym
        this.years= arrayListOf("first year","second year")
    }

    override fun toString(): String {
        return "Branche(id='$id', brancheName='$brancheName', acronym='$acronym', years=$years)"
    }

}


