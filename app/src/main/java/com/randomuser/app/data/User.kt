package com.randomuser.app.data

data class User(
    val gender: String,
    val name: Name,
    val location: Location,
    val email: String,
    val login: Login,
    val dob: DOB,
    val phone: String,
    val cell: String,
    val picture: Picture,
)

data class Name(
    val title: String,
    val first: String,
    val last: String,
)

data class Location(
    val street: Street,
    val city: String,
    val state: String,
    val country: String,
    val postcode: String,
)

data class Street(
    val number: Int,
    val name: String,
)

data class Login(
    val username: String,
)

data class DOB(
    val date: String,
    val age: Int,
)

data class Picture(
    val large: String,
    val medium: String,
    val thumbnail: String,
)