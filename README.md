# gradletask

This project presents an introductory view about tasks on Gradle and allows the automation of simple procedures.

# Usage:

    > gradle build

    > gradle mongoDbCleaner --args="mongodb://<database_host>:<port>/<database_name>"

     database_host = localhost
     port = 27017
     database_name = umbler

     task mongoDbCleaner(type: JavaExec, dependsOn:[classes]) {
	 group = "Execution"
	 description = "Run the main class with JavaExecTask"
	 classpath = sourceSets.main.runtimeClasspath
	 main = 'com.example.gradletask.GradletaskApplication'
     }
