import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

plugins {
    kotlin("jvm") version "1.9.21"
    id("java")
    id("com.github.johnrengelman.shadow") version "8.1.1"
}


group = "com.pepej"
version = "1.0"

repositories {
    mavenCentral()
    maven {
        url = uri("https://repo.spongepowered.org/repository/maven-public/")
    }

}

dependencies {

    annotationProcessor("org.spongepowered:mixin:0.8.2:processor")
    implementation("org.spongepowered:mixin:0.8")        {
        exclude("org.slf4j:slf4j-api")
    }

    compileOnly(fileTree("libs"))
    implementation(fileTree("compLibs"))
    compileOnly("io.netty:netty-all:4.1.86.Final")
//    implementation("org.apache.logging.log4j:log4j-api:2.2")
// https://mvnrepository.com/artifact/net.minecraft/launchwrapper
    implementation("net.minecraft:launchwrapper:1.12")
    implementation("commons-codec:commons-codec:1.15")
    implementation("com.google.code.gson:gson:2.8.9")
    implementation("com.google.guava:guava:33.0.0-jre")
//    implementation("jakarta.activation:jakarta.activation-api:2.0.1")
//    implementation("javax.sq:jdbc-stdext:2.0")
    compileOnly("org.lwjgl:lwjgl:3.1.0")
    compileOnly("org.lwjgl:lwjgl-opengl:3.1.0")
    implementation(kotlin("stdlib"))
    testImplementation("org.jetbrains.kotlin:kotlin-test")
}



tasks.withType<JavaCompile> {
    modularity.inferModulePath = false
    sourceCompatibility = "8"
    targetCompatibility = "8"
//    options.compilerArgs.add("--add-opens=java.sql")
}



tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(8)
}

tasks.withType<ShadowJar> {
    archiveFileName.set("${project.name}-${project.version}.jar")
//    File(project.buildDir, "mixins/mixins.omegapvp.refmap.json")
    manifest {
        attributes(
            mutableMapOf(
                "Implementation-Title" to project.name,
                "Implementation-Version" to project.version,
                "TweakOrder" to -1,
                "TweakClass" to "org.spongepowered.asm.launch.MixinTweaker",
                "MixinConfigs" to "mixins.omegapvp.json", // Конфигурации миксинов, через зяпятую если их несколько
//                "FMLCorePlugin" to "com.pepej.omegapvp.MixinLoader",  // Не забываем указать эти два флага,
                "ForceLoadAsMod" to "true",               // чтобы Forge нормально загрузил и мод, и миксины
            )
        )
    }
}
