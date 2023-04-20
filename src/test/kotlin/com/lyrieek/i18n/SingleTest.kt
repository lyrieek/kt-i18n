package com.lyrieek.i18n

import io.kotest.core.spec.style.FunSpec

class SingleTest : FunSpec({
	val file = "locales/zh_CN.json"
	beforeTest {
		I18n.loadFile(file)
	}

	test("test basic I18n.parse") {
		println(I18n.parse("print"))
	}

})