//plugins {
//  id("org.gradle.toolchains.foojay-resolver-convention") version "0.8.0"
//}
rootProject.name = "cucumber-companion-multiple-sources-issue"

include(":features-a")
include(":features-b")
include(":suite")

dependencyResolutionManagement {
  repositories {
    mavenCentral()
  }
}
