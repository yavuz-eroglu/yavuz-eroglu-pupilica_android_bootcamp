package com.yavuzeroglu.kotlindersleri.standart_programlama

fun main() {
    // 1,2,3
    for(i in 1..3){ // Swift: 1...3 -
//        print("$i, ")
    }
    // i : Dizilerdeki indexs'i temsilen i'dir

    // 10 - 20 => 5'er artacak
    for(x in 10..20 step 5) {
        println("Döngü 2: $x")
    }


    // 10 - 20 => 5'er azalacak
    for(x in 20 downTo 10 step 5) {
        println("Döngü 3: $x")
    }
}