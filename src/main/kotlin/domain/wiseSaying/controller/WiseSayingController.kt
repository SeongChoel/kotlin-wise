package com.domain.wiseSaying.controller

import com.domain.wiseSaying.entity.WiseSaying
import com.domain.wiseSaying.service.WiseSayingService
import com.global.Request
import jdk.javadoc.internal.doclets.formats.html.markup.HtmlStyle

class WiseSayingController {
    private val wiseSayingService = WiseSayingService()

    fun write() {
        print("명언: ")
        val saying = readlnOrNull() ?: ""
        print("작가: ")
        val author = readlnOrNull() ?: ""

        val wiseSaying = wiseSayingService.write(saying, author)
        println("${wiseSaying.id}번 명언이 등록되었습니다.")
    }

    fun list() {
        val wiseSayings = wiseSayingService.getItems()

        if (wiseSayings.count() == 0) {
            println("등록된 명언이 없습니다.")
        } else {
            println("번호 / 작가 / 명언")
            for (wiseSaying in wiseSayings.reversed()) {
                println("${wiseSaying.id} / ${wiseSaying.author} / ${wiseSaying.saying}")
            }
        }
    }

    fun delete(rq: Request) {
        val id = rq.getParam("id")?.toIntOrNull()

        if (id == null) {
            println("삭제할 명언의 번호를 입력해주세요.")
            return
        }

        val wiseSaying = wiseSayingService.getItem(id)

        wiseSaying?.let {
            wiseSayingService.delete(it)
            println("${id}번 명언을 삭제했습니다.")
        } ?: run {
            println("${id}번 명언은 존재하지 않습니다.")
        }

    }

    fun modify(rq: Request) {
        var id = rq.getParam("id")?.toIntOrNull()

        if (id == null) {
            println("수정할 명언의 번호를 입력해주세요.")
            return
        }

        val wiseSaying = wiseSayingService.getItem(id)

        wiseSaying?.let {
            println("명언(기존) : ${wiseSaying.saying}")
            print("명언 : ")
            val saying = readlnOrNull() ?: ""
            println("작가(기존) : ${wiseSaying.author}")
            print("작가 : ")
            val author = readlnOrNull() ?: ""

            wiseSayingService.modify(wiseSaying, saying, author)
            println("${id}번 명언을 수정했습니다.")
        } ?: run {
            println("${id}번 명언은 존재하지 않습니다.")
        }
    }

}