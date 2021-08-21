# Getting Started

### Embedded DB
#H2 Connection settings
spring.h2.console.enabled=true
spring.datasource.url=jdbc:h2:mem:testdb

H2 Web Console : http://localhost:8080/h2-console

###PostgreSQL DB

	SET search_path TO public;
	Set below spring data props(keys) for Spring Boot to connect to DB
		spring.datasource.url
		spring.datasource.username
		spring.datasource.password



## Swagger Definition

        Hit the endpoint : http://localhost:<<PORT_NO>>/swagger-ui/index.html
        Here it would be http://localhost:8095/swagger-ui/index.html


