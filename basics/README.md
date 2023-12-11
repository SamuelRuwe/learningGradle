Gradle Definitions
1. Project: A piece of software that can be built such as an application or a library
2. Single Project Build: A build that includes only one project, called the root project
3. Multi-Project Build: A build that includes one root project and any number of subprojects
4. Build Script: Tells gradle what steps to take to build the project
5. Dependency Management: An automated technique for declaring and resolving external dependencies
6. Task: A basic unit of work such as compiling code or executing tests
7. Plugin: Extends gradle's capabilities and optionally adds tasks


Useful Gradle Commands
1. `gradle tasks --group="build setup"`
2. `gradle -q help --tasks libs`
3. `gradle :basics:basicKotlin:dependencies --configuration="compileClasspath"`
4. `gradle :basics:basicKotlin:properties --property="junitVersion"`
5. `gradle :basics:basicKotlin:test --continuous`
