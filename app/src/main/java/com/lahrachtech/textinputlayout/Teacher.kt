package com.lahrachtech.textinputlayout

class Teacher {
    lateinit var id: String
    lateinit var firstName: String
    lateinit var lastName: String
    lateinit var age: String
    lateinit var CIN: String
    lateinit var email: String
    lateinit var phoneNumber: String
    lateinit var branche: Branche


    constructor()
    constructor(
        _id: String,
        _firstName: String,
        _lastName: String,
        _age: String,
        _CIN: String,
        _email: String,
        _phoneNumber: String,
        _branche: Branche
    ) {
    this.id=_id
    this.firstName=_firstName
    this.lastName=_lastName
    this.age=_age
    this.CIN=_CIN
    this.email=_email
    this.phoneNumber=_phoneNumber
    this.branche=_branche

    }
}