if [ ! -d "~/logs" ]; then
  mkdir ~/logs
fi

export AppenderLogFilePath=~/logs/
export LoggingLevel=DEBUG

mvn clean install
mvn spring-boot:run