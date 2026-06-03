# Dependabot Vulnerable Java Gradle Test Repo

This repository is a minimal Java application that uses the Gradle build system and intentionally pins several dependencies to versions with publicly known CVEs.

It exists only as a test fixture for Dependabot and other software composition analysis tools. Do not use these dependency versions in production code.

## Included vulnerable dependency examples

- Log4j Core `2.14.1` — Log4Shell / CVE-2021-44228
- Spring Framework Core `5.2.0.RELEASE` — Spring Framework CVE coverage demonstration
- Jackson Databind `2.9.8` — CVE-2019-14379
- Commons Collections `3.2.1` — CVE-2015-6420
- Hibernate Core `5.4.0.Final` — known CVE coverage demonstration
- H2 Database `1.4.197` — CVE-2022-23221
- Tomcat Embed Core `9.0.30` — CVE-2020-1938 coverage demonstration

## Build with Gradle
## Build

```bash
gradle build
```

## Build with Maven

A matching `pom.xml` is included alongside `build.gradle` so Dependabot can scan the same intentionally vulnerable dependency set through the Maven ecosystem as well.

```bash
mvn test
```

## Run with Gradle
## Run

```bash
gradle run
```

## Gradle Wrapper Note

This repository keeps `gradle/wrapper/gradle-wrapper.properties` pinned to Gradle 7.6 for scanner compatibility, but intentionally does not commit `gradle-wrapper.jar` because some review and scanning systems reject binary files. If you need executable wrapper scripts locally, regenerate them with:

```bash
gradle wrapper --gradle-version 7.6
```
