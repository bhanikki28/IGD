# Getting Started

## Spring Initializr

    To bootstrap/initializer your SpringBoot project, use https://start.spring.io/
    Provide the below inputs and click on generate
        1. Choose Maven or Gradle Project
        2. Choose Language ( Java / Kotlin / Groovy )
        3. Spring Boot Version to use
        4. Group ID ( eg : com.igd.demo)
        5. Artifact ( Project name eg : SpringBootSample )
        6. Name 
        7. Description for your project
        8. Package Name
        9. Packaging Type ( Jar/War )
        10. Java Version ( 8/11/16 )

    Once the project got generated , we can import it in IDE as maven/gradle project

## DB changes

	SET search_path TO public; // This has to be done in SQL client
	Set below spring data props(keys) for Spring Boot to connect to DB in application.properties
		spring.datasource.url
		spring.datasource.username
		spring.datasource.password

## Controller Annotations

    @RestController -   to tag the class as Spring Rest Controller
    @RequestMapping -   to set the URI for the endpoint
    @GetMapping     -   for 'GET' operation endpoints
    @PostMapping    -   for 'POST' operation endpoints
    @PutMapping     -   for 'PUT' operations 
    @DeleteMapping  -   for 'Delete' operations
    @PathVariable   -   for url params

## Spring Boot Logging
    
    Spring Boot provides support for Logging. It comes with support for SLF4J logging
    Logging Levels can be at 
        1. INFO
        2. DEBUG
        3. TRACE
        4. ERROR
        5. WARN

    Spring Boot by default logs to console and one can configure the logs to
    be writtent to File ( Customization )

    Log Appenders can be of two types

        1. Console Appender
        2. File Appender

## Exception Handling
    
    Spring Boot provides support for centralized Exception handling
    using 
        1. @ControllerAdvice
        2. @ExceptionHandler and 
        3. @ResponseStatus annotations

## Swagger Definition and Annotations

        Hit the endpoint : http://localhost:<<PORT_NO>>/swagger-ui/index.html
        Here it would be http://localhost:8095/swagger-ui/index.html
        @Api            -   Annotation to specify the API title
        @ApiOperation   -   to specify api operation value that should come in Swagger UI
        
## Building and Running Spring Boot app

        mvn clean install
        mvn clean spring-boot:run
        mvn clean install -DskipTests ( to skip running test cases )
