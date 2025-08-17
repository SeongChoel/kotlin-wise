package com.domain.wiseSaying.repository

import com.domain.wiseSaying.entity.WiseSaying
import java.nio.file.Path

class WiseSayingFileRepository : WiseSayingRepository {

    private var lastId : Int = 0

    override fun save(wiseSaying: WiseSaying): WiseSaying {

        if (wiseSaying.isNew()) { //추가
            val new = wiseSaying.copy(id = ++lastId)
            saveOnDisk(new)
            return new
        }

        saveOnDisk(wiseSaying)

        return wiseSaying //수정
    }

    fun saveOnDisk(wiseSaying: WiseSaying) {

        Path.of("data/dev/wiseSaying").toFile().writeText(wiseSaying.jsonStr)
    }

    override fun findAll(): List<WiseSaying> {
        TODO("Not yet implemented")
    }

    override fun findById(id: Int): WiseSaying {
        TODO("Not yet implemented")
    }

    override fun delete(wiseSaying: WiseSaying) {
        TODO("Not yet implemented")
    }

    override fun clear() {
        TODO("Not yet implemented")
    }
}