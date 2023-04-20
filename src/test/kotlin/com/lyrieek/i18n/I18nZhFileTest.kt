package com.lyrieek.i18n

import com.alibaba.fastjson2.JSON
import io.kotest.core.spec.style.FunSpec
import java.nio.charset.Charset

class I18nZhFileTest : FunSpec({

	val file = "locales/zh_CN.json"
	var content = ""

	beforeTest {
		content = this::class.java.classLoader.getResource(file)?.readText(Charset.forName("utf-8"))!!
	}

	test("print content") {
		println(content)
		assert(content.isNotEmpty())
	}

	test("print json") {
		val json = JSON.parseObject(content)
		println(json)
		assert(json.isNotEmpty())
	}

	test("assert json 'start' value") {
		assert(JSON.parseObject(content).get("start").equals("开始"))
	}

})