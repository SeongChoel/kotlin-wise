package com

import com.domain.system.controller.SystemController
import com.domain.wiseSaying.controller.WiseSayingController
import com.global.Request

class App {

    fun run() {
        val wiseSayingController = WiseSayingController()
        val systemController = SystemController()

        println("====명언 앱=====")

        while (true) {
            print("명령) ")

            val input = readlnOrNull() ?: ""

            val rq = Request(input)

            when(rq.actionName) {
                "종료" -> {
                    systemController.exit()
                    break
                }
                "등록" -> wiseSayingController.write()
                "목록" -> wiseSayingController.list()
                "삭제" -> wiseSayingController.delete(rq)
                "수정" -> wiseSayingController.modify(rq)
                else -> {
                    println("알수없는 명령입니다. 다시 입력해주세요.")
                }
            }
        }
    }
}