plugins {
    eclipse
    idea
    id(ZeroLibs.Plugins.oss) version ZeroLibs.Version.gradlePlugin
    id(ZeroLibs.Plugins.root) version ZeroLibs.Version.gradlePlugin

    id(PluginLibs.nexusPublish) version PluginLibs.Version.nexusPublish
}

val pRepo = project.ext.get("githubRepo") as String
val pGroup = project.ext.get("projectGroup") as String

allprojects {
    group = pGroup

    repositories {
        mavenLocal()
        maven { url = uri("https://maven-central-asia.storage-download.googleapis.com/maven2/") }
        maven { url = uri("https://oss.sonatype.org/content/groups/public/") }
        mavenCentral()
    }
    val skipPublish = (gradle as ExtensionAware).extensions["SKIP_PUBLISH"] as Array<*>
    sonarqube {
        isSkipProject = project.path in skipPublish
    }

    tasks {
        withType<AbstractPublishToMaven> {
            enabled = project != rootProject && project.path !in skipPublish
        }
    }
}

subprojects {
    apply(plugin = ZeroLibs.Plugins.oss)

    dependencies {

        testImplementation(TestLibs.junit5Api)
        testImplementation(TestLibs.junit5Engine)
        testImplementation(TestLibs.junit5Vintage)
    }

    oss {
        zero88.set(true)
        publishingInfo {
            enabled.set(true)
            homepage.set("https://github.com/${pRepo}")
            license {
                name.set("The Apache License, Version 2.0")
                url.set("https://github.com/${pRepo}/blob/master/LICENSE")
            }
            scm {
                connection.set("scm:git:git://git@github.com:${pRepo}.git")
                developerConnection.set("scm:git:ssh://git@github.com:${pRepo}.git")
                url.set("https://github.com/${pRepo}")
            }
        }
        testLogger {
            slowThreshold = 5000
        }
    }
}


nexusPublishing {
    packageGroup.set(pGroup)
    repositories {
        sonatype {
            username.set(project.property("nexus.username") as String?)
            password.set(project.property("nexus.password") as String?)
        }
    }
}
