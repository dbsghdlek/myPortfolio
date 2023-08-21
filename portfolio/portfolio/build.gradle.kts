import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	val kotlinVersion = "1.6.21"
	java
	id("org.springframework.boot") version "2.7.7"
	id("io.spring.dependency-management") version "1.0.15.RELEASE"
	kotlin("jvm") version kotlinVersion
	kotlin("plugin.spring") version kotlinVersion
	kotlin("kapt") version kotlinVersion
	idea
}

val qeurydslVersion = "5.0.0"

group = "com.personal"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

configurations {
	compileOnly {
		extendsFrom(configurations.annotationProcessor.get())
	}
}

repositories {
	mavenCentral()
}

dependencies {
	compileOnly("org.projectlombok:lombok")
	annotationProcessor("org.projectlombok:lombok")
	implementation("org.springframework.boot:spring-boot-starter-thymeleaf")
	implementation("org.springframework.boot:spring-boot-starter-web")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	runtimeOnly("mysql:mysql-connector-java")
	implementation("org.springframework.boot:spring-boot-starter-validation")
	implementation ("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation ("io.springfox:springfox-swagger2:2.9.2")
	implementation ("io.springfox:springfox-swagger-ui:2.9.2")
	implementation ("org.mybatis.spring.boot:mybatis-spring-boot-starter:2.2.0")
	implementation("org.jetbrains.kotlin:kotlin-reflect")


	//QueryDSL
	implementation("com.querydsl:querydsl-jpa:$qeurydslVersion")
	kapt("com.querydsl:querydsl-apt:$qeurydslVersion:jpa")
	kapt("org.springframework.boot:spring-boot-configuration-processor")

	annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")

}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "11"
	}
}

idea {
	module {
		val kaptMain = file("build/generated/source/kapt/main")
		sourceDirs.add(kaptMain)
		generatedSourceDirs.add(kaptMain)
	}
}


tasks.withType<Test> {
	useJUnitPlatform()
}


