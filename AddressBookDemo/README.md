# Getting Started

### Swagger Dependency

Getting the Swagger 2 Spring Dependency

	Add the Swagger dependency in maven pom.xml
		<!-- https://mvnrepository.com/artifact/io.springfox/springfox-boot-starter -->
		<dependency>
			<groupId>io.springfox</groupId>
			<artifactId>springfox-boot-starter</artifactId>
			<version>3.0.0</version>
		</dependency>


### Enabling the Swagger

	No additional step required from springfox-boot-starter version 3.0.0


### Configuring the Swagger

Configuring Swagger

		To customize Swagger with the controllers to be scanned and add more details, need to define below configurations
		
			1. Docket Bean
			2. API Info 
			3. API Operation - to be defined at the controller
			4. API Param - param definition for the controller
			5. API Model - more info on models been used

### Accessing the Swagger docs

			Hit the endpoint : http://localhost:<<PORT_NO>>/swagger-ui/index.html


### Building and Running the application in local

    mvn clean install
    mvn clean spring-boot:run

### Running the Test    

    mvn test
    jacaco reports can be found at : target/site/jacoco/index.html

### Dockerization

    mvn clean install - to generate jar file
    docker build -t address-book:1 .
    docker run -p 8080:8080 address-book:1

### Deployment into Kubernetes

    Sample yml file placed under resources/k8s folder to deploy into k8s

    Namespace:
        Syntax : kubectl create ns <<namespace_name>>
        kubectl create ns igd
    
    To create deployment , pls run below commands
    
    kubectl create -f deployment.yml -n igd
    kubectl get deploy -n igd
    
    Expose it as a service
    kubectl expose deployment address-app -n igd --type=LoadBalancer --port=8080 

