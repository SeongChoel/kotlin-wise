package com.global

import com.domain.system.controller.SystemController
import com.domain.wiseSaying.controller.WiseSayingController
import com.domain.wiseSaying.repository.WiseSayingRepository
import com.domain.wiseSaying.service.WiseSayingService

object SingletonScope {
    val wiseSayingRepository by lazy { WiseSayingRepository() }
    val wiseSayingService by lazy { WiseSayingService() }
    val wiseSayingController by lazy { WiseSayingController() }
    val systemController by lazy { SystemController() }

}