import org.gradle.kotlin.dsl.sourceSets

plugins {
  alias(libs.plugins.cucumberCompanion)
  alias(libs.plugins.kotlinJvm)
  `jvm-test-suite`
}

cucumberCompanion {
  enableForStandardTestTask = false
}

testing {
  suites {
    @Suppress("UnstableApiUsage")
    register<JvmTestSuite>("features") {
      generateCucumberSuiteCompanion(project) {
        dependsOn(":features-a:processResources")
        dependsOn(":features-b:processResources")
      }
      sources {
        // only first directory seems to be processed up by Cucumber Companion
        resources.setSrcDirs(
          listOf<File>(
            checkNotNull(project(":features-a").sourceSets["main"].output.resourcesDir),
            checkNotNull(project(":features-b").sourceSets["main"].output.resourcesDir),
          )
        )
      }
      targets {
        all {
          tasks.withType<ProcessResources> {
            dependsOn(":features-a:processResources")
            dependsOn(":features-b:processResources")
          }
        }
      }
    }
  }
}
