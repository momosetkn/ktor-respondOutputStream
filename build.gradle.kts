
val ktorVersion: String by project
val kotlinVersion: String by project
val logbackVersion: String by project

plugins {
    kotlin("jvm") version "1.9.22"
    id("io.ktor.plugin") version "2.3.8"
}

group = "com.example"
version = "0.0.1"

application {
    mainClass.set("com.example.ApplicationKt")

    val isDevelopment: Boolean = project.ext.has("development")
    applicationDefaultJvmArgs = listOf("-Dio.ktor.development=$isDevelopment")
}

repositories {
    mavenCentral()
}

dependencies {
    // ktor
    implementation("io.ktor:ktor-server-core-jvm:$ktorVersion")
    implementation("io.ktor:ktor-server-netty-jvm:$ktorVersion")
    implementation("io.ktor:ktor-server-resources:${ktorVersion}")

    implementation("ch.qos.logback:logback-classic:$logbackVersion")
    testImplementation("io.ktor:ktor-server-tests-jvm:$ktorVersion")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit:$kotlinVersion")

}

// ./gradlew runWorkaround
task<JavaExec>("runWorkaround") {
    group = "application"
    mainClass = "com.example.WorkaroundApplicationKt"
    classpath = sourceSets["main"].runtimeClasspath
}


// ./gradlew runWorkaround2
task<JavaExec>("runWorkaround2") {
    group = "application"
    mainClass = "com.example.WorkaroundApplication2Kt"
    classpath = sourceSets["main"].runtimeClasspath
}
