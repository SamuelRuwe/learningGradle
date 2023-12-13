tasks.register("samsTask") {
    println("Hello from samsTask")
}

class GreetingPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        project.task("helloWor") {
            doLast {
                println("Hello from the GreetingPlugin")
            }
        }
    }
}

// Apply the plugin
apply<GreetingPlugin>()
