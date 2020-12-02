package home.assignment.foxpost.test;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import home.assignment.foxpost.api.service.ClientService;
import home.assignment.foxpost.api.service.ParcelService;

@Configuration
public class AppConfigurationTest {

	@Bean
	public ClientService createClientService() {
		return new ClientService();
	}
	
	@Bean
	public ParcelService createParcelService() {
		return new ParcelService();
	}
	
}
