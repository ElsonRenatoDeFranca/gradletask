# gradletask

This project presents an introductory view about tasks on Gradle and allows the automation of simple procedures using Groovy language.

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

