package com.domain.wiseSaying.repository

import com.domain.wiseSaying.entity.WiseSaying

class WiseSayingMemRepository : WiseSayingRepository {
    private var lastId: Int = 0
    private val wiseSayings = mutableListOf<WiseSaying>()

    override fun save(wiseSaying: WiseSaying): WiseSaying { //수정, 추가 통합

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

    override fun findAll(): List<WiseSaying> {
        return wiseSayings.toList()
    }

    override fun delete(wiseSaying: WiseSaying) {
        wiseSayings.remove(wiseSaying)
    }

    override fun findById(id: Int): WiseSaying? {
        return wiseSayings.find { it.id == id }
    }

    override fun clear() {
        wiseSayings.clear()
        lastId = 0
    }

    override fun findByAuthorLike(keyword: String): List<WiseSaying> {
        TODO("Not yet implemented")
    }

    override fun findBySayingLike(keyword: String): List<WiseSaying> {
        TODO("Not yet implemented")
    }

}