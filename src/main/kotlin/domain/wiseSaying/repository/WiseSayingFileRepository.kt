package com.domain.wiseSaying.repository

import com.domain.wiseSaying.entity.WiseSaying
import com.global.AppConfig
import java.nio.file.Path

class WiseSayingFileRepository : WiseSayingRepository {

    private var lastId : Int = 0

    init {
        initTable()
    }

    val tableDirPath: Path
        get() = AppConfig.tableDirPath.resolve("wiseSaying")

    override fun save(wiseSaying: WiseSaying): WiseSaying {

        if (wiseSaying.isNew()) { //추가
            val new = wiseSaying.copy(id = ++lastId)
            saveOnDisk(new)
            return new
        }

        saveOnDisk(wiseSaying)

        return wiseSaying //수정
    }

    private fun saveOnDisk(wiseSaying: WiseSaying) {
        tableDirPath.resolve("${wiseSaying.id}.json").toFile().writeText(wiseSaying.jsonStr)
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

    fun saveLastId(id : Int) {
        tableDirPath.resolve("lastId.txt").toFile().writeText(id.toString())
    }

    fun loadLastId(): Int {
        return tableDirPath.resolve("lastId.txt").toFile().readText().toIntOrNull() ?:0
    }

    fun initTable() {
        tableDirPath.toFile().run {
            if(!exists()) {
                mkdirs()
            }
        }
    }
}