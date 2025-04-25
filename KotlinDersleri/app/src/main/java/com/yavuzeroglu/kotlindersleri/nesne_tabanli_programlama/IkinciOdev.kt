package com.yavuzeroglu.kotlindersleri.nesne_tabanli_programlama

fun main() {

    println(convertCelciusToFahrenheit(32.2))

    rectanglePerimeter(9, 13)

    var factorialResult = factorial(5)
    println("Faktoriyel Sonuc: ${factorialResult}")

    letters("yavuz  ")

    println("3 kenarın iç açılar toplamı: ${calculateInteriorAngles(4)}")

    println("24 günlük çalışma süresinin ücreti: ${calculateSalary(24)}")

    println("54 GB kullanilan internetin tutarı: ${calculateInternetBill(54)}")
}

fun convertCelciusToFahrenheit(celcius: Double): Double {
    return celcius * 1.8 + 32
}

fun rectanglePerimeter(shortSide: Int, longSide: Int) {
    val sonuc = 2 * (shortSide + longSide)
    println(sonuc)
}

fun factorial(num: Int): Int {
    var result = 1

    for (x in num downTo 1) {
        result *= x
    }
    return result
}

fun letters(word: String) {

    println("$word kelimesi ${word.trim().length} harften olusmaktadir.")
}

fun calculateInteriorAngles(sideNumber: Int): Int {
    return (sideNumber - 2) * 180
}

fun calculateSalary(day: Int): Int {
    val hourlyWage = 10
    val overtimeWage = 20
    val workingHour = day * 8
    var monthlyOvertime = 0
    var salary = 0

    if (workingHour <= 160) {
        salary = workingHour * hourlyWage
        return salary
    } else {
        monthlyOvertime = workingHour - 160
        val overtimeSalary = monthlyOvertime * overtimeWage
        salary = overtimeSalary + 160 * hourlyWage
        return salary
    }
}

fun calculateInternetBill(quota: Int): Int {
    var amount = 100
    var exceededQuota = 0
    var exceededQuotaAmount = 0
    var total = 0
    if (quota <= 50) {
        return amount
    } else if (quota > 50) {
        exceededQuota = quota - 50
        for (x in 1..exceededQuota) {
            exceededQuotaAmount += 4
        }
    }
    amount += exceededQuotaAmount
    return amount
}