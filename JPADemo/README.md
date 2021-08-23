# Getting Started

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
    using @ControllerAdvice, @ExceptionHandler and @ResponseStatus annotations

## Swagger Definition

        Hit the endpoint : http://localhost:<<PORT_NO>>/swagger-ui/index.html
        Here it would be http://localhost:8095/swagger-ui/index.html

## Building and Running Spring Boot app

        mvn clean install
        mvn clean spring-boot:run
        mvn clean install -DskipTests ( to skip running test cases )
