private fun Map<Int, List<Int>>.ver(minor: Int, patch: Int):String = "${minor}.${this[minor]?.get(patch)}"

object PluginLibs {

    object Version {

        const val nexusPublish = "1.1.0"
    }

    const val nexusPublish = "io.github.gradle-nexus.publish-plugin"
}

object JacksonLibs {

    object Version {

        const val jackson = "2.12.0"
    }

    const val annotations = "com.fasterxml.jackson.core:jackson-annotations:${Version.jackson}"
    const val databind = "com.fasterxml.jackson.core:jackson-databind:${Version.jackson}"
    const val datetime = "com.fasterxml.jackson.datatype:jackson-datatype-jsr310:${Version.jackson}"
}

object TestLibs {

    object Version {

        const val junit5 = "5.9.1"
    }

    const val junit5Api = "org.junit.jupiter:junit-jupiter-api:${Version.junit5}"
    const val junit5Engine = "org.junit.jupiter:junit-jupiter-engine:${Version.junit5}"
    const val junit5Vintage = "org.junit.vintage:junit-vintage-engine:${Version.junit5}"
    const val junit5Params = "org.junit.jupiter:junit-jupiter-params:${Version.junit5}"

}

object VertxLibs {

    object Version {

        private val pool = mapOf(2 to (0..7).toList(), 3 to (0..6).toList(), 4 to (0..0).toList())
        @JvmField val vertxCore = "4.${pool.ver(3, 5)}"
        @JvmField val vertxSQL = "4.${pool.ver(3, 5)}"
        const val vertxJunit = "4.2.5"
        const val docgen = "0.9.4"
    }

    @JvmField val core = "io.vertx:vertx-core:${Version.vertxCore}"
    @JvmField val codegen = "io.vertx:vertx-codegen:${Version.vertxCore}"
    @JvmField val junit5 = "io.vertx:vertx-junit5:${Version.vertxJunit}"
    const val docgen = "io.vertx:vertx-docgen:${Version.docgen}"
}

object ZeroLibs {
    object Version {

        const val gradlePlugin = "2.1.0"
        const val utils = "2.0.0"
        const val rsql = "2.2.1"
    }

    const val rsql = "io.github.zero88:rsql-parser:${Version.rsql}"
    const val utils = "io.github.zero88:java-utils:${Version.utils}"

    object Plugins {

        const val oss = "io.github.zero88.gradle.oss"
        const val root = "io.github.zero88.gradle.root"
    }
}
