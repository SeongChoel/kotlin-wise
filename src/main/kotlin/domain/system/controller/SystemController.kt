package com.domain.system.controller

class SystemController {

    fun exit() {
        println("프로그램을 종료합니다.")
        kotlin.system.exitProcess(0)
    }
}