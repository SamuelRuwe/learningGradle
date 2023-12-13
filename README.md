### Gradle Definitions

1. Project: A piece of software that can be built such as an application or a library
2. Single Project Build: A build that includes only one project, called the root project
3. Multi-Project Build: A build that includes one root project and any number of subprojects
4. Build Script: Tells gradle what steps to take to build the project
5. Dependency Management: An automated technique for declaring and resolving external dependencies
6. Task: A basic unit of work such as compiling code or executing tests
7. Plugin: Extends gradle's capabilities and optionally adds tasks

### Useful Gradle Commands

1. `gradle tasks --group="build setup"`
2. `gradle -q help --tasks libs`
3. `gradle :basics:basicKotlin:dependencies --configuration="compileClasspath"`
4. `gradle :basics:basicKotlin:properties --property="junitVersion"`
5. `gradle :basics:basicKotlin:test --continuous`

### Settings File

1. The primary goal of the settings file is to add subprojects to the build
2. The settings file is the entry point of every gradle build
3. When gradle assembles a project for a build, it creates a Settings instance and executes the settings file against it
4. There is a one-to-one correspondence between a Settings instance and a settings.gradle(.kts) file

### Commonly Used Settings Properties

1. buildCache
    1. The build configuration
2. plugins
    1. The container of plugins that have been applied to the settings
3. rootDir
    1. The root directory of the build. The root directory is the project directory of the root project
4. rootProject
    1. The root project of the build
5. settings
    1. Returns the Settings object

### Build Lifecycle

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

### Build File

1. A build.gradle(.kts) file is referred to as a build script
2. A build script configures a project and is associated with an object of type Project
3.

### Commonly Used Project Properties

1. name
    1. The name of the project directory
2. path
    1. The fully qualified name of the project
3. description
    1. A description for the project
4. dependencies
    1. Returns the dependency handler of the project
5. repositories
    1. Returns the repository handler of the project
6. layout
    1. Provides access to several important locations for a project
7. group
    1. The group of the project
8. version
    1. The version of the project
9. uri()
    1. Resolves a file path to a URI, relative to the project directory of the project
10. task()
    1. Creates a Task with the given name and adds it to the project

### Declaring Variables in Build Scripts

1. Local Variables
    1. Declare local variables with the val keyword. Local variables are only visible in the scope where they have been
       declared. They are a feature of the underlying Kotlin language
2. Extra Properties
    1. Gradle’s enhanced objects, including projects, tasks, and source sets, can hold user-defined properties.

### Tasks

1. A task represents some independent unit of work that a build performs. This might be compiling some classes, creating
   a JAR, generating Javadoc, or publishing some archives to a repository.
2. Prefer tasks.register() over tasks.create()
    1. This saves time on building when the task is not utilized. If it is needed it can be created, otherwise it is
       just registered and no further actions are taken
3. When a task is run, that task is executed along with any other task it depends on

### Plugins

1. Extend the gradle model
2. Configure the project according to conventions
    1. Add new tasks
    2. Configure sensible defaults
3. Apply specific configuration (eg: Add organizational repositories, enforce standards)
4. A plugin is any class that implements the Plugin interface

### Advantages of Plugins over BuildScript

1. Promotes reuse and reduces the overhead of maintaining similar logic across multiple projects
2. Allows a higher degree of modularization, enhancing comprehensibility and organization
3. Encapsulates imperative logic and allows build scripts to be as declarative as possible

### Plugin Distributions

1. Core Plugins
2. Community Plugins
    1. In a remote repository such as the gradle plugin portal or maven
3. Local Plugins

### Types of Plugins

1. Binary Plugins
    1. Binary plugins are added using either `includeBuild` or by including a dependency in the plugins block
    2. Script plugins that are part of an included build end up as a binary plugin and are published in a jar
2. Script Plugins
    1. Additional build scripts used to configure the build
    2. Script plugins are not reusable outside of the build script
3. Convention Plugins
    1. Convention plugins are similar to binary plugins, but they exist in the buildSrc directory