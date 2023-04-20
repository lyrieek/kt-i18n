package com.lyrieek.i18n

import io.kotest.core.spec.style.FunSpec

class I18nTest : FunSpec({
	beforeTest {
		I18n.init()
	}

	test("test I18n.getLanguages") {
		println(I18n.getLanguages())
	}

	test("test toggle language") {
		println(I18n.parse("print"))
		I18n.use("en_US")
		println(I18n.parse("print"))
		I18n.use("zh_CN")
		println(I18n.parse("print"))
	}

})