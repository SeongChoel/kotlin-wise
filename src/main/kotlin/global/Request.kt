package com.global

//삭제?id=1
class Request(
    val input: String
) {
    var actionName: String
    var paramMap: Map<String, String>

    init {
        val inputBits = input.split("?", limit = 2)
        actionName = inputBits[0].trim()

        paramMap = if (inputBits.size == 2) {
            inputBits[1].split("&").associate {
                val bits = it.split("=", limit = 2)
                val key = bits[0]
                val value = if (bits.size > 1) bits[1] else ""
                key to value
            }
                .toMap()
        } else {
            emptyMap()
        }

    }

    fun getParam(key: String): String? {
        return paramMap[key]
    }

    fun getParamDefault(key: String, default: String): String {
        return paramMap[key]?.ifBlank { default } ?: default
    }

}