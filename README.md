# java-gradle-template

Gradle template for opensource java projects

Correct some variables:

- [gradle.properties](./gradle.properties): 
  - `githubRepo`
  - `baseName`
  - `description`
  - `systemProp.sonar.projectKey`
  
  For organization repo: `projectGroup` and `systemProp.sonar.organization`

- [settings.gradle.kts](./settings.gradle.kts#16)
  - `rootProject.name`
  - Update subprojects structure

- [build.yml](.github/workflows/build.yml)
  - `REPO`
  - `PROFILE`

- Add GitHub repository secrets for action
  - `CI_GPG_PASSPHARSE`
  - `CI_GPG_PRIVATE_KEY`
  - `OSS_GITHUB_TOKEN`
  - `OSS_SONARQUBE_TOKEN`
  - `OSS_SONATYPE_PASSWORD`
  - `OSS_SONATYPE_USER`
