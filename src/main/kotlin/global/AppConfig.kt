package com.global

import java.nio.file.Path

object AppConfig {

    private var mode : String = "dev"

    fun setTestMode() {
        mode = "test"
    }

    fun setDevMod() {
        mode = "dev"
    }

    val tableDirPath : Path
        get() =Path.of("data/${mode}")
}