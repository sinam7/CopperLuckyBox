plugins {
    id("java")
}

group = "com.sinam7.copperluckybox"
version = "0.1-SNAPSHOT"

repositories {
    mavenCentral()
    maven("https://repo.papermc.io/repository/maven-public/")
}


dependencies {
    compileOnly("io.papermc.paper:paper-api:1.19.4-R0.1-SNAPSHOT")
    compileOnly("org.projectlombok:lombok:1.18.26")
    annotationProcessor("org.projectlombok:lombok:1.18.26")

    testCompileOnly("org.projectlombok:lombok:1.18.26")
    testAnnotationProcessor("org.projectlombok:lombok:1.18.26")
}

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(17))
}



tasks {
    jar {
        doLast {
            copy {
                from("build/libs")
                into("run/plugins")
                include("*.jar")
            }
        }
    }

}
