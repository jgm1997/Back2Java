plugins {
    id("java")
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(21))
    }
}

group = "es.jgm1997"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

// Enable preview features for compilation (compileJava, compileTestJava, etc.)
tasks.withType<JavaCompile> {
    // Pass --enable-preview to the compiler (needed for StructuredTaskScope preview API)
    options.compilerArgs?.add("--enable-preview")
    // Optional: ensure UTF-8 encoding
    options.encoding = "UTF-8"
}

// Ensure tests run with preview enabled on the JVM
tasks.test {
    useJUnitPlatform()
    // Pass the preview flag to the JVM executing tests
    jvmArgs("--enable-preview")
}