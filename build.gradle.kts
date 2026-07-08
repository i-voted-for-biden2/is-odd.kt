@file:OptIn(ExperimentalKotlinGradlePluginApi::class)

import com.vanniktech.maven.publish.JavadocJar
import com.vanniktech.maven.publish.KotlinMultiplatform
import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.dokka)
    alias(libs.plugins.maven.publish)
}

group = "dev.schlaubi"
version = "2.0.0"

repositories {
    mavenCentral()
}

mavenPublishing {
    configure(KotlinMultiplatform(JavadocJar.Dokka("dokkaGenerateHtml")))
    signAllPublications()
    publishToMavenCentral(automaticRelease = true)

    pom {
        name = project.name
        description = "Kotlin port and bindings for very popular JavaScript library is-odd"
        url = "https://github.com/DRSchlaubi/is-odd.kt"

        licenses {
            license {
                name = "MIT License"
                url = "https://github.com/DRSchlaubi/is-odd.kt/blob/main/LICENSE"
            }
        }

        developers {
            developer {
                name = "Michael Rittmeister"
                email = "mail@schlaubi.me"
                organizationUrl = "https://michael.rittmeister.in"
            }
        }

        scm {
            connection = "scm:git:https://github.com/DRSchlaubi/lavakord.git"
            developerConnection = "scm:git:https://github.com/DRSchlaubi/lavakord.git"
            url = "https://github.com/DRSchlaubi/lavakord"
        }
    }
}

kotlin {
    applyDefaultHierarchyTemplate {
        common {
            group("nonJs") {
                withJvm()
                group("native")
            }
        }
    }

    jvm {
        testRuns.configureEach {
            executionTask.configure {
                useJUnitPlatform()
            }
        }
    }
    js {
        browser {
            testTask {
                useKarma {
                    useChromeHeadless()
                }
            }
        }
        nodejs()
    }
    mingwX64()

    linuxX64()
    linuxArm64()

    macosArm64()

    iosArm64()
    iosSimulatorArm64()

    watchosArm32()
    watchosArm64()
    watchosSimulatorArm64()

    tvosArm64()
    tvosSimulatorArm64()

    sourceSets {
        dependencies {
            testImplementation(kotlin("test-common"))
            testImplementation(kotlin("test-annotations-common"))
        }

        jvmTest {
            dependencies {
                implementation(kotlin("test-junit5"))
            }
        }

        jsMain {
            dependencies {
                implementation(npm("is-odd", libs.versions.`is`.odd.get()))
            }
        }

        jsTest {
            dependencies {
                implementation(kotlin("test-js"))
            }
        }
    }

    compilerOptions {
        freeCompilerArgs.add("-Xexpect-actual-classes")
    }
}

dokka {
    dokkaSourceSets {
        configureEach {

            perPackageOption {
                matchingRegex.set(".*\\.internal.*") // will match all .internal packages and sub-packages
                suppress.set(true)
            }
        }
    }
}
