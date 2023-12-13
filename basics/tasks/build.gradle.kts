// Registering "hello" task
tasks.register("hello") {
    group = "Custom"
    description = "A lovely greeting task."
    doLast {
        println("Hello world!")
    }
}

// Registering intro task. Because it depends on hello, hello task will be executed
tasks.register("intro") {
    dependsOn("hello")
    doLast {
        println("Hello from intro")
    }
}

// Tasks can be accessed once registered through the TaskProvider API
repeat(4) { counter ->
    tasks.register("task$counter") {
        doLast {
            println("I'm task number $counter")
        }
    }
}

tasks.named("task0") { dependsOn("task2", "task3") }

// Creating a task using a class extending DefaultTask
abstract class HelloTask : DefaultTask() {
    @TaskAction
    fun hello() {
        println("hello from HelloTask")
    }
}

// Register helloTask with type HelloTask
// This also changes the type of the task from Task to HelloTask
tasks.register<HelloTask>("helloTask") {
    group = "Custom tasks"
    description = "A lovely greeting task."
}
