plugins {
    java
}

group = "astrihale"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(files("./src/main/resources/svetovid-lib.jar"))
    testCompile("junit", "junit", "4.12")
}
