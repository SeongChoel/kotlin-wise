package com

fun main() {

    println("====명언 앱=====")
    var lastId = 0

    while (true) {
        print("명령) ")

        val input = readlnOrNull() ?: ""

        when(input) {
            "종료" -> break;
            "등록" -> {
                print("명언: ")
                val saying = readlnOrNull() ?: ""
                print ("작가: ")
                val author = readlnOrNull() ?: ""
                lastId ++

                println("${lastId}번 명언이 등록되었습니다.")
            }
        }
    }

}