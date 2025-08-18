package com.standard

import jdk.internal.net.http.common.Pair.pair

object JsonUtil {
    fun jsonStrToMap(jsonStr: String): Map<String, Any> {

        val replacedJsonStr = jsonStr.replace("{", "")
            .replace("}", "")
            .replace("\n", "")
            .replace(" : ", ": ")

        return replacedJsonStr.split(",").associate { pair ->
            val bits = pair.split(":", limit = 2)

            val key = bits[0].trim().replace("\"", "")
            val value = if (bits[1].trim().startsWith("\"")) {
                bits[1].trim().replace("\"", "")
            } else {
                bits[1].trim().toInt()
            }

            key to value
        }

    }


}