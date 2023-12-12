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


Settings File
1. The primary goal of the settings file is to add subprojects to the build
2. The settings file is the entry point of every gradle build
3. When gradle assembles a project for a build, it creates a Settings instance and executes the settings file against it
4. There is a one-to-one correspondence between a Settings instance and a settings.gradle(.kts) file


Build Lifecycle
1. Initialization
   1. Detects settings.gradle(.kts) file
   2. Creates Settings instance
   3. Evaluates settings file to determine which projects (and included builds) make up the build
   4. Creates a Project instance for every project
2. Configuration
   1. Evaluates the build scripts, build.gradle(.kts), of every project participating in the build
   2. Creates a task graph for the requested tasks
3. Execution
   1. Schedules and executes the selected tasks
   2. Dependencies between tasks determine the execution order
   3. Execution of tasks can occur in parallel
