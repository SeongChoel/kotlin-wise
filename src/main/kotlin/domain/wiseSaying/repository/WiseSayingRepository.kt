package com.domain.wiseSaying.repository

import com.domain.wiseSaying.entity.WiseSaying
import kotlin.text.get
import kotlin.text.set

class WiseSayingRepository {
    private var lastId: Int = 0
    private val wiseSayings = mutableListOf<WiseSaying>()

    fun save(wiseSaying: WiseSaying): WiseSaying { //수정, 추가 통합

        if (wiseSaying.isNew()) { //추가
            val new = wiseSaying.copy(id = ++lastId)
            wiseSayings.add(new)
            return new
        }

        wiseSayings.indexOfFirst { it.id == wiseSaying.id }.let {
            wiseSayings[it] = wiseSaying
        }
        return wiseSaying //수정
    }

    fun findAll(): List<WiseSaying> {
        return wiseSayings.toList()
    }

    fun delete(wiseSaying: WiseSaying) {
        wiseSayings.remove(wiseSaying)
    }

    fun findById(id: Int): WiseSaying? {
        return wiseSayings.find { it.id == id}
    }

}