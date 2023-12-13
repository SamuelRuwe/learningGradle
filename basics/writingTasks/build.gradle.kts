abstract class CreateFileTask : DefaultTask() {
    @TaskAction
    fun action() {
        val file = File("myfile.txt")
        file.createNewFile()
        file.writeText("HELLO FROM MY TASK")
    }
}

tasks.register<CreateFileTask>("createFileTask") {
    group = "custom"
    description = "Create myfile.txt in the current directory"
}

abstract class CreateFileTaskV2 : DefaultTask() {
    @Input
    val fileText = "HELLO FROM MY TASK"

    @Input
    val fileName = "myfile.txt"

    @OutputFile
    val myFile: File = File(fileName)

    @TaskAction
    fun action() {
        myFile.createNewFile()
        myFile.writeText(fileText)
    }
}

tasks.register<CreateFileTaskV2>("createFileTaskV2") {
    group = "custom"
    description = "Create myfile.txt in the current directory"
}




abstract class CreateFileTaskV3 : DefaultTask() {
    @get:Input
    abstract val fileText: Property<String>

    @Input
    val fileName = "myfile.txt"

    @OutputFile
    val myFile: File = File(fileName)

    @TaskAction
    fun action() {
        myFile.createNewFile()
        myFile.writeText(fileText.get())
    }
}

tasks.register<CreateFileTaskV3>("createFileTaskV3") {
    group = "custom"
    description = "Create myfile.txt in the current directory"
    // Set convention. Convention provides a default value
    fileText.convention("HELLO FROM THE CREATE FILE TASK METHOD")
}

tasks.named<CreateFileTaskV3>("createFileTaskV3") {
    fileText.set("HELLO FROM THE NAMED METHOD") // Override with custom message
}
