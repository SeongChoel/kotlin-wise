package com

import com.domain.system.controller.SystemController
import com.domain.wiseSaying.controller.WiseSayingController
import com.global.Request
import com.global.SingletonScope

class App {

    fun run() {
        val wiseSayingController = SingletonScope.wiseSayingController
        val systemController = SingletonScope.systemController

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
                "목록" -> wiseSayingController.list(rq)
                "삭제" -> wiseSayingController.delete(rq)
                "수정" -> wiseSayingController.modify(rq)
                "빌드" -> wiseSayingController.build()
                else -> {
                    println("알수없는 명령입니다. 다시 입력해주세요.")
                }
            }
        }
    }
}