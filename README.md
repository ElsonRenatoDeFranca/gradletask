# gradletask

This project presents an introductory view about tasks on Gradle and allows the automation of simple procedures using Groovy language. In this example we will interact with MongoDb to add, query and delete some collections from database. It can be used as a clean up tool for database. Basically the project is a gradle task that triggers a Java application that relies on SpringData MongoRepository<Object, Object> to perform NoSql operations.

# Usage:

> bradle build

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
