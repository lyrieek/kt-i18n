package com.lyrieek.i18n

import java.io.File
import java.lang.RuntimeException

open class I18n {

	companion object {
		val sets: TranslateSets = TranslateSets()
		var ready = false
		fun loadFolder(path: String) {
			if (!ready) {
				init()
			}
			val file = File(path)
			if (!file.isDirectory) {
				throw RuntimeException("directory not find")
			}
			for (item in file.listFiles()!!) {
				loadFile(item)
			}
		}

		fun loadFile(file: File) {
			sets.add(file)
			ready = true
		}

		fun loadFile(file: String) {
			sets.add(File(this::class.java.classLoader.getResource(file)!!.file))
			ready = true
		}

		fun init() {
			sets.initDefault()
			ready = true
		}

		fun parse(key: String): String {
			if (!ready) {
				init()
			}
			return sets.find(key)
		}

		fun use(language: String) {
			sets.useLanguage = language
		}

		fun getLanguages(): Set<String> {
			return sets.getLanguages()
		}
	}
}