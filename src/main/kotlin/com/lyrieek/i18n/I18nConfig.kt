package com.lyrieek.i18n

import com.alibaba.fastjson2.JSON
import java.nio.charset.Charset
import java.util.*

open class I18nConfig {
	companion object {
		const val DEFAULT_DIR = "locales/"
		const val DEFAULT_CONFIG = DEFAULT_DIR + "config.json"
		var configFile = this::class.java.classLoader.getResource(DEFAULT_CONFIG)
		var configMap = JSON.parseObject(configFile)

		fun reLoad() {
			configFile = this::class.java.classLoader.getResource(DEFAULT_CONFIG)
		}

		fun hasFile(): Boolean {
			return configFile != null
		}

		fun getStringConfig(key: String, callback: () -> String): String {
			if (configMap?.get(key) != null)
				return configMap.get(key).toString()
			return callback.invoke()
		}

		fun getCharset(): String {
			return getStringConfig("charset") { Charset.defaultCharset().toString() }
		}

		fun getDefaultLanguage(): String {
			return getStringConfig("default-language") { Locale.getDefault().toString().replace("#", "") }
		}

	}

}