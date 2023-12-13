package org.puregeniusness

import org.gradle.api.DefaultTask
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.provider.Property
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.OutputFile
import org.gradle.api.tasks.TaskAction
import java.io.File

abstract class CreateFileTask : DefaultTask() {
    @get:Input
    abstract val fileText: Property<String>

    @Input
    val fileName = project.rootDir.toString() + "/myfile.txt"

    @OutputFile
    val myFile: File = File(fileName)

    @TaskAction
    fun action() {
        myFile.createNewFile()
        myFile.writeText(fileText.get())
    }
}

class MyBinaryPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        project.tasks.register("createFileTask", CreateFileTask::class.java) {
            group = "from my plugin"
            description = "Create myfile.txt in the current directory"
            fileText.set("HELLO FROM MY PLUGIN")
        }
    }
}
