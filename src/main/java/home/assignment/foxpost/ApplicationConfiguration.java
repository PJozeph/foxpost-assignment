package home.assignment.foxpost;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import home.assignment.foxpost.dao.ClientDao;
import home.assignment.foxpost.dao.ParcelDao;

@Configuration
@MapperScan(basePackages = "home.assignment.foxpost.mapper")
public class ApplicationConfiguration {

	@Bean
	public ClientDao createClientDao() {
		return new ClientDao();
	}

	@Bean
	public ParcelDao createParcelDao() {
		return new ParcelDao();
	}

}
