package com.lyrieek.i18n

import com.alibaba.fastjson2.JSON
import com.alibaba.fastjson2.JSONObject
import java.io.File

class TranslateMap(val name: String, val language: String) {
	val map: LinkedHashMap<String, String> = linkedMapOf()

	fun load(jsonFile: File): TranslateMap {
		return load(JSON.parseObject(jsonFile.toURI().toURL()))
	}

	fun load(json: JSONObject): TranslateMap {
		json.mapKeys {
			val key = it.key ?: return@mapKeys
			map[key] = it.value.toString()
		}
		return this
	}

	fun find(key: String): String {
		return map[key] ?: ""
	}

}