# FileInfoSystem

Overview:

The Service/Utility return the information about files in the specific directory. The service provides two methods:

1) api/pathInfo: Given the full path as parameter and api return the json response contains description of all the directories and files. The description includes the full path, size and flag if the entry is the directory or file.

2) api/fileInfo: Given the full path to a file as parameter and return the json response contains description of that file. The description includes the full path and all of the attributes available in the JDK.

# Deployment:

Build war files:

compile and run unit tests:  mvn clean install

./FileInfoSystem/target/file-info-system-0.0.1-SNAPSHOT.war

Run coverage :
mvn test

Then run mvn jacoco:report, the generated report is under target/site/jacoco/index.html

# Generate javadoc
we run the command to generate our Javadocs to a directory in target/site:

mvn javadoc:javadoc


# Run the Application
execute fileinfosystem.sh or fileinfosystem.bat

Apis can be hit by specifying http://localhost:8080/{apiName} in the browser after the server is up and running e.g.

windows:

http://localhost:8080/api/pathInfo?path=c:/{path}

http://localhost:8080/fileInfo?file=c:/{path}

linux/mac :

http://localhost:8080/api/pathInfo?path=/{path}

http://localhost:8080/fileInfo?file=/{path}

# Swagger URL 

http://localhost:8080/api-swagger