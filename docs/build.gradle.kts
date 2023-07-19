import cloud.playio.gradle.antora.tasks.AntoraCopyTask
import cloud.playio.gradle.generator.docgen.AsciidocGenTask

plugins {
    id(PlayioPlugin.antora)
    id(PlayioPlugin.docgen)
}

dependencies {
    compileOnly(project(":core"))
}

documentation {
    antora {
        asciiAttributes.set(mapOf("rsql-version" to project.version))
        javadocTitle.set("jOOQ RSQL ${project.version} API")
        javadocProjects.set(
            when (gradle) {
                is ExtensionAware -> ((gradle as ExtensionAware).extensions["PROJECT_POOL"] as Map<*, Array<String>>)["template"]!!
                else              -> emptyArray()
            }.map(project::project)
        )
    }
}

tasks {
    named<AntoraCopyTask>("antoraPartials") {
        from(withType<AsciidocGenTask>())
        include("*.adoc")
    }
}
