package com.yavuzeroglu.kotlindersleri.degiskenler

import kotlinx.datetime.Clock
import kotlinx.datetime.DateTimeUnit
import kotlinx.datetime.LocalDate
import kotlinx.datetime.TimeZone
import kotlinx.datetime.plus
import kotlinx.datetime.todayIn


fun main() {
    val city = "Bursa"
    val country = "Turkey"
    val phoneNumber = "05319999999"
    val zipCode = "16200"
    val email = "yavuzeroglu15@gmail.com"
    val profession = "Software Developer"
    val amountOfStock = 200
    val customerName = "Sirius Black"
    val balance = 15000
    val birthDate = LocalDate(1996, 2, 19)
    val salary = 22500
    val maritalStatus = "Single"
    val productComment = "Useful lamp"
    val paymentDate = Clock.System.todayIn(TimeZone.currentSystemDefault())
        .plus(1, DateTimeUnit.WEEK)
    val payment = "Invoice"
    val orderQuantity = 4
    val carModel = "Mazda"
    val bookName = "Clean Code"
    val releaseDate = LocalDate(2008, 8, 1)
    val discountAmount = 20
    val roomNumber = 16
    val latitude = 40
    val longitude = 29
    val productName = "Floor Lamp"
    val foodPrice = 230
    val brand = "Mazda"
    val musicName = "Sana Güvenmiyorum"
    val videoDuration = 2900L
    val productScore = 4.2
    val pictureName = "floor_lamp_1.png"
    val fileFormat = "jpeg"
    val color = "Auburn"
    val colorCode = "#9B2226"
    val phoneModel = "Iphone 13"
    val screenSize = "6.77"
    val weight = "220"
    val nationalDay = "23 Nisan"
    val holiday = "Sunday"
    val reservationDate = LocalDate(2025, 7, 20)
    val streetName = "Manhattan"
    val busLine = arrayListOf<String>("Osmangazi", "Nilüfer")
    val remainingMinute = 600000L
    val trackCode = "1AB16161616"
    val couponDuration = 10
    val couponCode = "ST8MT220425G4"
    val invoiceAdress = "Barış Manço Moda 81300 İstanbul"
}