package domain.wiseSaying.repository

import com.domain.wiseSaying.entity.WiseSaying
import com.domain.wiseSaying.repository.WiseSayingFileRepository
import com.global.SingletonScope
import com.global.SingletonScope.wiseSayingRepository
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import kotlin.test.Test

class WiseSayingFileRepositoryTest {

    private val wiseSayingFileRepository = SingletonScope.wiseSayingFileRepository

    @BeforeEach
    fun setUp() {
        wiseSayingFileRepository.clear()
        wiseSayingFileRepository.initTable()

    }

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

    @Test
    fun `명언 2개 저장`() {
        val wiseSaying1 = wiseSayingFileRepository
            .save(WiseSaying(saying = "인생은 짧고, 예술은 길다.", author = "헨리 장"))
        val wiseSaying2 = wiseSayingFileRepository
            .save(WiseSaying(saying = "내 죽음을 적에게 알리지 말라.", author = "이순신"))

        val lastId = wiseSayingFileRepository.loadLastId()

        assertThat(lastId).isEqualTo(2)
    }

    @Test
    fun `findAll`() {
        val wiseSaying1 = wiseSayingFileRepository
            .save(WiseSaying(saying = "인생은 짧고 예술은 길다.", author = "헨리 장"))
        val wiseSaying2 = wiseSayingFileRepository
            .save(WiseSaying(saying = "내 죽음을 적에게 알리지 말라.", author = "이순신"))

        val result = wiseSayingFileRepository.findAll()
        val count = result.size

        assertThat(count).isEqualTo(2)
        assertThat(result).containsExactly(wiseSaying1, wiseSaying2)
    }

    @Test
    fun `findById`() {
        val wiseSaying = wiseSayingFileRepository
            .save(WiseSaying(saying = "나의 죽음을 적들에게 알리지 말라.", author = "충무공 이순신"))

        val foundWiseSaying = wiseSayingFileRepository.findById(wiseSaying.id)

        assertThat(foundWiseSaying).isEqualTo(wiseSaying)
    }

    @Test
    fun `delete`() {
        val wiseSaying = wiseSayingFileRepository
            .save(WiseSaying(saying = "나의 죽음을 적에게 알리지 말라.", author ="충무공 이순신"))

        wiseSayingFileRepository.delete(wiseSaying)
        assertThat(wiseSayingFileRepository.findById(wiseSaying.id)).isNull()
    }





}

