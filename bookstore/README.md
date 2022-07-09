### Pre-requisites

	Need to have Maven,Docker and Java8 installed in your machine to run this application in local


### Building/Running the Application

	mvn clean install
	mvn clean spring-boot:run
	
	
### Dockerizing the Application

	Run Command : mvn clean install - to generate jar file
	docker build -t com.anz.app/bookstore:1 .
		- Above command will dockerize the application and tag it as com.anz.app/bookstore:1
		- To see the list of images, run command : docker images
		- To run the docker image in local, run below command
			docker run -p 8080:8080 com.anz.app/bookstore:1 

###	 Assumption

		This App is using inmemory h2 database for storing the books in table : TBL_BOOKS
		When application starts up, it will look at data.sql/schema.sql file to create and load initial data to the table
		Later data(book) can be inserted/queried using API as mentioned above


###  Testing the App

	 ## Unit testing with JUnit 
	 
	 Unit testing is done through JUnit/Mockito
	 Test coverage is done through JaCaCo Plugin
	 
	 Please run : mvn clean install
	 
	 Test Coverage reports can be seen under /target/site/jacaco/index.html
	 
	 Check is added on JaCaCo Plugin to fail the build
	 		-	If the line coverage is less than 80%
	 		-	If the branch coverage is less than 70%
	 		
	 
	## Integration Testing with RestAssured
	BDD is defined in src/test/resources/Features/bookstore.feature
	
	Please run : mvn clean install
	
	Cucumber reports will be generated ( check the command console )
	
	https://reports.cucumber.io/reports/e06be096-9e07-4ff8-bd24-0ff25e12e862
	

###  Testing the Api 

		Use Postman/Insomnia to test the endpoints
		
		1.	Save a Book:
			- Post Call : http://localhost:8080/bookstore/v1/books
			- Payload
				{
				    "bookName" : "Associate Cloud Engineer GCP",
				    "authorName":"Dan Sullivan",
				    "publishedDate" : "2022-01-28",
				    "price" : "50.00",
				    "inStock" : "yes"
				}
		
		2. 	Get All Books
				- Get Call : http://localhost:8080/bookstore/v1/books
				
		3.	Find Book By Id
				-	Get Call : http://localhost:8080/bookstore/v1/books/2
		4. Search Book by Name
				- Get Call : http://localhost:8080/bookstore/v1/books?name=GCP*
	

### To push image into GCR ( Google Cloud Container Registry )

	1. 	To authenticate google cloud : gcloud auth login
	2.	To tag docker image for gcr : docker build -t gcr.io/<<PROJ_ID>>/com.anz.app/bookstore:1 
	3. 	To authorize docker to push image to gcr : gcloud auth configure-docker
	4.	To push image to gcr : docker push gcr.io/<<PROJ_ID>>/com.anz.app/bookstore:1
	5.	Login to gcloud console and navigate to Container Registry section, to view the image been pushed there.
	6.	Then the image can be deployed to GKE/Google App Engine(Flexible Env)/Cloud Run
	



### Deploy On Kubernetes ( GKE - Google Kubernetes Engine )

	kubectl apply -f app_deploy.yml -n anz-dev
		- This will create the deployment "bookstore-app" in anz-dev namespace
	
	Verify the deployment is created and its running fine

		-	kubectl get deploy -n anz-dev
	
	Verify the pods are running
	
		-	kubectl get pods -n anz-dev
	Services:
		Need to create service as type “LoadBalancer”, so that it can be accessed outside the cluster

		kubectl expose deployment bookstore-app -n anz-dev --type=LoadBalancer --port=8080 
		kubectl get services -n anz-dev
		
		Please give some time for the external ip to popup, then you can able to access the services
		http://<<EXTERNAL_IP>>/bookstore/v1/books
		

		
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
			
			
### My Technical Blogs

		https://medium.com/@bharathy.poovalingam/deploying-microservice-on-kubernetes-92b6adc5ec59
		https://medium.com/@bharathy.poovalingam/gcp-learning-series-app-engine-part-2-3f7d5b494ff1
		https://medium.com/@bharathy.poovalingam/spring-boot-with-docker-d4129a353f87
		https://medium.com/@bharathy.poovalingam/gcp-learning-series-cloud-functions-f14ef6ca5d1a
		https://medium.com/@bharathy.poovalingam/terraform-a27fc6dc1cdf
		https://medium.com/@bharathy.poovalingam/gcp-data-engineer-cloud-storage-32d66b35e148
		
		