import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "2.7.5"
	id("io.spring.dependency-management") version "1.0.15.RELEASE"

	val kotlinVersion = "1.7.21"
	kotlin("jvm") version kotlinVersion
	kotlin("plugin.spring") version kotlinVersion
	kotlin("kapt") version kotlinVersion
}

group = "com.example"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17
java.targetCompatibility = JavaVersion.VERSION_17

configurations {
	compileOnly {
		extendsFrom(configurations.annotationProcessor.get())
	}
}

repositories {
	mavenCentral()
}

springBoot {
	buildInfo()
}

buildscript {
	dependencies {
		classpath("org.jetbrains.kotlin:kotlin-noarg:1.4.21")
	}
}

apply(plugin = "kotlin-jpa")

dependencyManagement {
	dependencies {
		dependencySet("org.springdoc:1.5.6") {
			entry("springdoc-openapi-ui")
			entry("springdoc-openapi-data-rest")
			entry("springdoc-openapi-kotlin")
		}
	}
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.jetbrains:annotations:20.1.0")

	val querydslVersion = "5.0.0"
//	implementation("org.springframework.boot:spring-boot-starter-data-mongodb")
//	api("com.querydsl:querydsl-apt:$querydslVersion")
//	kapt("com.querydsl:querydsl-jpa:$querydslVersion")

	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation(kotlin("reflect"))
	implementation(kotlin("stdlib-jdk8"))
	implementation(kotlin("noarg"))
	implementation(kotlin("allopen"))

	val mapstructVersion = "1.5.3.Final"

	implementation("org.mapstruct:mapstruct:$mapstructVersion")
	kapt("org.mapstruct:mapstruct-processor:$mapstructVersion")

	developmentOnly("org.springframework.boot:spring-boot-devtools")

	testImplementation("com.ninja-squad:springmockk:3.1.0")
	testImplementation("org.springframework.boot:spring-boot-starter-test")

	annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
}

kapt {
	annotationProcessor("org.springframework.data.mongodb.repository.support.MongoAnnotationProcessor")
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "17"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
