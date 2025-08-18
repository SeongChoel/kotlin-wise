package domain.wiseSaying.repository

import com.domain.wiseSaying.entity.WiseSaying
import com.domain.wiseSaying.repository.WiseSayingFileRepository
import com.global.SingletonScope
import com.global.SingletonScope.wiseSayingRepository
import org.assertj.core.api.Assertions.assertThat
import kotlin.test.Test

class WiseSayingFileRepositoryTest {

    private val wiseSayingFileRepository = SingletonScope.wiseSayingFileRepository

    @Test
    fun `save`() {
        val wiseSaying = wiseSayingFileRepository
            .save(WiseSaying(saying = "인생은 짧고, 예술은 길다.", author = "헨리 장"))

        val filePath = wiseSayingFileRepository
            .tableDirPath
            .toFile()
            .listFiles()
            ?.find { it.name == "${wiseSaying.id}.json" }

        assertThat(filePath).isNotNull

    }

    @Test
    fun `saveLastId, loadLastId`() {
        wiseSayingFileRepository.saveLastId(10)
        assertThat(wiseSayingFileRepository.loadLastId()).isEqualTo(10)
    }
}

