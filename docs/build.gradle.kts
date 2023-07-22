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
    val mainProject = "template"
    antora {
        asciiAttributes.set(
            mapOf(
                "project-group" to project.group,
                "project-name" to mainProject,
                "project-version" to project.version
            )
        )
        javadocTitle.set("Template ${project.version} API")
        javadocProjects.set(
            when (gradle) {
                is ExtensionAware -> ((gradle as ExtensionAware).extensions["PROJECT_POOL"] as Map<*, Array<String>>)[mainProject]!!
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
