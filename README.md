created for: https://github.com/gradle/cucumber-companion/issues/133

# To Reproduce

run:

```
./gradlew :suite:featuresGenerateCucumberSuiteCompanion
```

inspect `suite/build/generated-sources/cucumberCompanion-features`

change order of sources in `suite/build.gradle.kts`

```
        resources.setSrcDirs(
          listOf<File>(
            checkNotNull(project(":features-a").sourceSets["main"].output.resourcesDir),
            checkNotNull(project(":features-b").sourceSets["main"].output.resourcesDir),
          )
        )
```

rerun/reinspect
