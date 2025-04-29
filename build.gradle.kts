
plugins {
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.ktor)
    alias(libs.plugins.kotlin.plugin.serialization)
}

group = "com.syntex_error"
version = "0.0.1"

application {
    mainClass = "io.ktor.server.netty.EngineMain"

    val isDevelopment: Boolean = project.ext.has("development")
    applicationDefaultJvmArgs = listOf("-Dio.ktor.development=$isDevelopment")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(libs.ktor.server.core)
    implementation(libs.ktor.server.swagger)
    implementation("io.ktor:ktor-server-openapi:3.1.2")
    implementation(libs.ktor.serialization.kotlinx.json)
    implementation(libs.ktor.server.content.negotiation)
    implementation(libs.postgresql)
    implementation(libs.h2)
    implementation(libs.ktor.server.auth)
    implementation(libs.ktor.server.auth.jwt)
    implementation(libs.ktor.server.compression)
    implementation(libs.ktor.server.default.headers)
    implementation(libs.ktor.server.cors)
    implementation(libs.ktor.server.netty)
    implementation(libs.logback.classic)
    implementation(libs.ktor.server.config.yaml)
    testImplementation(libs.ktor.server.test.host)
    testImplementation(libs.kotlin.test.junit)

    implementation(libs.exposed.core)
    implementation(libs.exposed.jdbc)
    implementation(libs.exposed.dao)
    implementation(libs.exposed.java.time)
    implementation(libs.exposed.kotlin.datetime)

    implementation(libs.hikari)
    implementation(libs.bcrypt)
    implementation(libs.kotlinx.datetime)
    implementation("io.github.cdimascio:dotenv-kotlin:6.5.1")

    implementation(libs.koin.ktor)
    implementation(libs.koin.core)
    implementation(libs.koin.logger)
    implementation(libs.ktor.server.call.logging)
    implementation(libs.ktor.serialization.gson)

    implementation(libs.valiktor.core)
    implementation(libs.commons.io)
    implementation(libs.commons.email)
    implementation(libs.ktor.server.status.pages)
    implementation(libs.ktor.swagger.ui)
    implementation(libs.ktor.server.request.validation)
    implementation(libs.ktor.open.api)


}
