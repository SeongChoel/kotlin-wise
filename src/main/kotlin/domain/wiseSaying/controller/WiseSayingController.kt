package com.domain.wiseSaying.controller

import com.domain.wiseSaying.entity.WiseSaying
import com.global.Request

class WiseSayingController(
    var lastId : Int = 0,
) {

    val wiseSayings = mutableListOf<WiseSaying>()

    fun write() {
        print("명언: ")
        val saying = readlnOrNull() ?: ""
        print ("작가: ")
        val author = readlnOrNull() ?: ""
        var id = ++lastId
        wiseSayings.add(WiseSaying(id, author, saying))

        println("${lastId}번 명언이 등록되었습니다.")
    }

    fun list() {
        if (wiseSayings.count() == 0) {
            println("등록된 명언이 없습니다.")
        }
        else {
            println("번호 / 작가 / 명언")
            for (wiseSaying in wiseSayings.reversed()) {
                println("${wiseSaying.id} / ${wiseSaying.author} / ${wiseSaying.saying}")
            }
        }
    }
    fun delete(rq : Request) {
        val id = rq.getParam("id")?.toIntOrNull()

        if (id == null) {
            println("삭제할 명언의 번호를 입력해주세요.")
            return
        }

        val rst = wiseSayings.removeIf { saying -> saying.id == id }

        if(rst) {
            println("${id}번 명언을 삭제했습니다.")
        } else {
            println("${id}번 명언은 존재하지 않습니다.")
        }
    }
}