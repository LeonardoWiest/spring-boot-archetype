package com.github.leonardowiest;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.ConfigurableEnvironment;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
//@PropertySource(ignoreResourceNotFound = false, value = "classpath:application.properties")
//@PropertySource(ignoreResourceNotFound = false, value = "classpath:application-${spring.profiles.active}.properties")
public class Application {

	public static void main(String[] args) {

		SpringApplication application = new SpringApplication(Application.class);

		ConfigurableEnvironment environment = application.run(args).getEnvironment();

		logApplicationStartup(environment);
	}

	private static void logApplicationStartup(ConfigurableEnvironment environment) {

		String protocol = "http";

		if (environment.getProperty("server.ssl.key-store") == ""
				|| environment.getProperty("server.ssl.key-store") != null) {
			protocol = "https";
		}

		String serverPort = environment.getProperty("server.port");

		String contextPath = environment.getProperty("server.servlet.context-path");

		if (contextPath == "" || contextPath == null) {
			contextPath = "/";
		}

		String hostAddress = "localhost";

		try {

			hostAddress = InetAddress.getLocalHost().getHostAddress();
		} catch (UnknownHostException e) {

			log.warn("The host name could not be determined, using `localhost` as fallback");
		}

		log.info(
				"\n----------------------------------------------------------\n\t"
						+ "Application '{}' is running! \n\t" + "Local: \t\t{}://localhost:{}{}\n\t"
						+ "External: \t{}://{}:{}{}\n\t"
						+ "Profile(s): \t{}\n----------------------------------------------------------",
				environment.getProperty("spring.application.name"), protocol, serverPort, contextPath, protocol,
				hostAddress, serverPort, contextPath, environment.getActiveProfiles());
	}
}
