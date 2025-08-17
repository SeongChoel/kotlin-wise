package com.global

import com.domain.system.controller.SystemController
import com.domain.wiseSaying.controller.WiseSayingController
import com.domain.wiseSaying.repository.WiseSayingRepository
import com.domain.wiseSaying.service.WiseSayingService

object SingletonScope {
    val wiseSayingRepository = WiseSayingRepository()
    val wiseSayingService = WiseSayingService()
    val wiseSayingController = WiseSayingController()
    val systemController = SystemController()


}