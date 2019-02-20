# SoapServerAndClient

springBootWSProducer

- run dbscripts on mysql engine
- mvn clean package (to generate the classes from schema)
- mvn spring-boot:run to start server on port 8080
- you can find the wsdl file on (http://localhost:8080/soapws/myProjectWSDL.wsdl)


spring-boot-web-consumer

- mvn clean package (to generate the classes from the WSDL file)
- mvn spring-boot:run to start client server on port 4040
- (http://localhost:4040)


notes 
- project as Endpoints need to be invoked in soap server is completed AS request 
- all soap EndPoint is tested using soapUI
- project as spring MVC Client not completed as expected
- project will be completed next week .
 
 
