package com.labs.lab1

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.boot.web.servlet.ServletRegistrationBean
import org.springframework.context.annotation.Bean

@SpringBootApplication
class Lab1Application {
	@Bean
	fun servletRegistrationBean(): ServletRegistrationBean<Servlet> {
		val servlet = Servlet()
		val bean = ServletRegistrationBean(servlet, "/my-servlet")
		return bean
	}
}

fun main(args: Array<String>) {
	runApplication<Lab1Application>(*args)
}
