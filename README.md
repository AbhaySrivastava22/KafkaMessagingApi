# KafkaMessagingApi
This project is a Spring Boot with Apache Kafka Project.
This project demonstrates the kafka producer and comsumer messaging service in which one user sends message to another and in response another user can send message to the same user.

#Steps to Start The Project :
1.Clone and open project in any java IDE like Intellij
2.Download and extract the latest version of Kafka from the official site : https://kafka.apache.org/
3.In kafka folder -->config-->zookeeper.properties change the dataDir=your kafka folder path/zookeeper-data
4.In kafka folder -->config-->server.properties change the log.dirs=your kafka folder path/kafka-logs
5.open cmd and cd into kafka folder and type : .\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties
6.open another cmd and cd into kafka folder and type : .\bin\windows\kafka-server-start.bat .\config\server.properties
7. now run the spring code using spring main class.
8. use the postman collection to excute the code.




