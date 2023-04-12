package com.lyrieek.i18n

import java.io.File

class TranslateSets {

	private val deque: ArrayDeque<TranslateMap> = ArrayDeque()

	var useLanguage = I18nConfig.getDefaultLanguage()

	fun initDefault() {
		for (item in File(this.javaClass.classLoader.getResource(I18nConfig.DEFAULT_DIR)!!.path).listFiles()!!) {
			add(item)
		}
	}

	fun add(file: File) {
		val map = toTranslateMap(file)
		if (map != null) {
			deque.add(map)
		}
	}

	fun toTranslateMap(file: File): TranslateMap? {
		val fileName = file.name.substringBeforeLast(".")
		if (fileName == "config") {
			return null
		}
		return TranslateMap(file.parent, fileName).load(file)
	}

	fun addPrev(file: File) {
		val map = toTranslateMap(file)
		if (map != null) {
			deque.addFirst(map)
		}
	}

	fun find(key: String): String {
		for (map in deque) {
			if (map.language == useLanguage) {
				return map.find(key)
			}
		}
		return ""
	}

	fun getLanguages(): Set<String> {
		return deque.map { it.language }.toSet()
	}


}