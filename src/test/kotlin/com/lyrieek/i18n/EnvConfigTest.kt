package com.lyrieek.i18n

import com.alibaba.fastjson2.JSON
import io.kotest.core.spec.style.StringSpec
import java.net.URL
import java.nio.charset.Charset
import java.util.*

class EnvConfigTest : StringSpec({

	"find system default charset" {
		println(Charset.defaultCharset())
	}

	"system default lang" {
		println(Locale.getDefault().toString().replace("#", ""))
	}

	"read config file" {
		println(
			JSON.parseObject(
				this.javaClass.classLoader.getResource(I18nConfig.DEFAULT_CONFIG)
			)
		)
	}

	"check config file" {
		I18nConfig.reLoad()
		println(I18nConfig.hasFile())
	}

	"test getStringConfig" {
		println(I18nConfig.getStringConfig("unknown key test") { "test value" })
	}

})