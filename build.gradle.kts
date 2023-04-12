plugins {
	kotlin("jvm") version "1.8.20"
	`maven-publish`
	signing
	application
}

group = "com.lyrieek.i18n"
version = "0.1.1"

tasks.withType<Test>().configureEach {
	useJUnitPlatform()
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("com.alibaba.fastjson2:fastjson2-kotlin:2.0.27")

	testImplementation("io.kotest:kotest-runner-junit5-jvm:5.5.5")
	testImplementation("io.kotest:kotest-assertions-core:5.5.5")
	testImplementation("io.kotest:kotest-property:5.5.5")
}

publishing {
	repositories {
		maven {
			url = uri("https://oss.sonatype.org/service/local/staging/deploy/maven2")
			credentials {
				username = providers.gradleProperty("ossrhUsername").get()
				password = providers.gradleProperty("ossrhPassword").get()
			}
		}
	}
	publications {
		create<MavenPublication>("maven") {
			pom {
				artifactId = "kt-i18n"
				name.set("Kt-I18n")
				description.set("kotlin i18n solution")
				url.set("http://www.lyrieek.com/library/kt-i18n")
				licenses {
					license {
						name.set("GNU AFFERO GENERAL PUBLIC LICENSE,Version 3")
						url.set("https://www.gnu.org/licenses/agpl-3.0.txt")
					}
				}
				developers {
					developer {
						id.set("lyrieek")
						name.set("lyrieek")
						email.set("lyrieek@hotmail.com")
					}
				}
				scm {
					connection.set("https://github.com/lyrieek/kt-i18n")
					developerConnection.set("scm:git:git://github.com/lyrieek/kt-i18n.git")
					url.set("scm:git:ssh://git@github.com:lyrieek/kt-i18n.git")
				}
			}
		}
	}
}

signing {
	sign(publishing.publications["maven"])
}
