plugins {
    kotlin("multiplatform") version "1.4.21"
    id("org.jetbrains.dokka") version "1.4.20"
    `maven-publish`
}

group = "me.schlaubi"
version = "1.1"

repositories {
    mavenCentral()
}

publishing {
    repositories {
        maven {
            setUrl("https://api.bintray.com/maven/drschlaubi/maven/is-odd.kt;publish=1;override=0")

            credentials {
                username = System.getenv("BINTRAY_USER")
                password = System.getenv("BINTRAY_KEY")
            }
        }
    }

    publications {
        filterIsInstance<MavenPublication>().forEach { publication ->
            publication.pom {
                name.set(project.name)
                description.set("Kotlin port and bindings for very popular JavaScript library is-odd\n" +
                        "\n")
                url.set("https://github.com/DRSchlaubi/is-odd.kt")

                licenses {
                    license {
                        name.set("MIT License")
                        url.set("https://github.com/DRSchlaubi/is-odd.kt/blob/main/LICENSE")
                    }
                }

                developers {
                    developer {
                        name.set("Michael Rittmeister")
                        email.set("mail@schlaubi.me")
                        organizationUrl.set("https://michael.rittmeister.in")
                    }
                }

                scm {
                    connection.set("scm:git:https://github.com/DRSchlaubi/lavakord.git")
                    developerConnection.set("scm:git:https://github.com/DRSchlaubi/lavakord.git")
                    url.set("https://github.com/DRSchlaubi/lavakord")
                }
            }
        }
    }
}


kotlin {
    jvm {
        compilations.all {
            kotlinOptions.jvmTarget = "1.8"
        }
        testRuns["test"].executionTask.configure {
            useJUnit()
        }
    }
    js(BOTH) {
        browser {
            testTask {
                useKarma {
                    useChromeHeadless()
                    webpackConfig.cssSupport.enabled = true
                }
            }
        }
        nodejs()
    }
    val hostOs = System.getProperty("os.name")
    val isMingwX64 = hostOs.startsWith("Windows")
    val nativeTarget = when {
        hostOs == "Mac OS X" -> macosX64("native")
        hostOs == "Linux" -> linuxX64("native")
        isMingwX64 -> mingwX64("native")
        else -> throw GradleException("Host OS is not supported in Kotlin/Native.")
    }


    sourceSets {
        commonMain {
            repositories {
                jcenter()
            }
        }

        commonTest {
            dependencies {
                implementation(kotlin("test-common"))
                implementation(kotlin("test-annotations-common"))
            }
        }

        val nonJs = create("nonJs")

        val jvmMain by getting {
            dependsOn(nonJs)
        }

        val jvmTest by getting {
            dependencies {
                implementation(kotlin("test-junit"))
            }
        }

        val jsMain by getting {
            dependencies {
                implementation(npm("is-odd", "3.0.1"))
            }
        }

        val jsTest by getting {
            dependencies {
                implementation(kotlin("test-js"))
            }
        }

        val nativeMain by getting {
            dependsOn(nonJs)
        }
    }
}

tasks {
    dokkaHtml {
        outputDirectory.set(file("docs"))

        dokkaSourceSets {
            configureEach {
                includeNonPublic.set(false)

                perPackageOption {
                    matchingRegex.set(".*\\.internal.*") // will match all .internal packages and sub-packages
                    suppress.set(true)
                }
            }
        }
    }
}
