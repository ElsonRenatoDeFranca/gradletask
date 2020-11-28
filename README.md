# gradletask

This project presents an introductory view about tasks on Gradle and allows the automation of simple procedures using Groovy language. In this example we will interact with MongoDb to add, query and delete some collections from database. It can be used as a clean up tool for database. Basically the project is a gradle task that triggers a Java application that relies on SpringData MongoRepository<Object, Object> to perform NoSql operations.

# Usage:

> bradle build

> gradle mongoDbCleaner --args="mongodb://<database_host>:<port>/<database_name>"

database_host = localhost
port = 27017
database_name = umbler

#
MongoDb commands to be handled by script;

     1- Connect to MongoDB
     
     task init_dev {
     doLast {
        exec {
           workingDir '.'
           commandLine 'mongo', '--port', '27018', '<', 'init/mongodb-init-dev'

           ext.output = {
               return standardOutput.toString()
           }
        }
     }
     2- show dbs
     3- use <specific_database>
     4- show collections;
         4.1- db.customers.insert([{nome: "Maria", idade: 19},{nome:"Fernando", idade: 25}, {nome:"Antonio", idade: 31}]);
         4.2- db.developers.insert([{nome: "Maria", idade: 19},{nome:"Fernando", idade: 25}, {nome:"Antonio", idade: 31}]);
     5- db.collection.drop()

