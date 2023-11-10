plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation ("com.amazonaws:aws-java-sdk-bom:1.11.837")
    implementation ("com.amazonaws:aws-java-sdk-s3:1.11.837")
    implementation ("com.amazonaws:aws-java-sdk-sts:1.11.837")
    implementation ("com.amazonaws:aws-java-sdk-iam:1.11.837")
    implementation("javax.xml.bind:jaxb-api:2.2.4")
}

tasks.test {
    useJUnitPlatform()
}