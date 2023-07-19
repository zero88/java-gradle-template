# java-gradle-template

Gradle template for opensource java projects

Correct some variables:

- [gradle.properties](./gradle.properties):
  - `title=<title>`
  - `description=<description>` 
  - `projectGroup`
  - `projectLicense`
  - `github.repo`
  - `systemProp.sonar.organization=<sonar-org-key>`
  - `systemProp.sonar.projectKey=<sonar-project-key>`
  
  For organization repo: `projectGroup` and `systemProp.sonar.organization`

- [settings.gradle.kts](./settings.gradle.kts#16)
  - `rootProject.name`
  - `projectName`
  - Update subprojects structure

- [ci.yml](.github/workflows/ci.yml)
  - Update `${{ env.PROFILE }}` to `projectName`

- Add GitHub repository secrets for action
  - `CI_GPG_PASSPHARSE`
  - `CI_GPG_PRIVATE_KEY`
  - `OSS_GITHUB_TOKEN`
  - `OSS_SONARQUBE_TOKEN`
  - `OSS_SONATYPE_PASSWORD`
  - `OSS_SONATYPE_USER`

- Git branches:
  - `docs/main`: To keep Antora component documentation
  - `gh-pages`: To keep Antora webdocs and host GitHub page
