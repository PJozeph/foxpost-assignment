package home.assignment.foxpost.test;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import home.assignment.foxpost.dao.ClientDao;
import home.assignment.foxpost.dao.ParcelDao;
import home.assignment.foxpost.model.Client;
import home.assignment.foxpost.service.ClientService;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { AppConfigurationTest.class })
public class ClientServiceTest {

	private static final int TEST_ID = 1;

	private static final String TEST_CITY = "Kecskemét";

	private static final String TEST_EMAIL = "kata@gmail.com";

	@Autowired
	private ClientService clientService;

	@MockBean
	private ClientDao clientDao;
	
	@MockBean
	private ParcelDao parcelDao;
	
	@Test
	public void getAllclientTest() {
		List<Client> result = Arrays.asList(Client.builder().build());
		Mockito.when(clientDao.getAll()).thenReturn(result);
		
		clientService.getAll();
		
		Mockito.verify(clientDao).getAll();
		Assert.assertFalse(clientDao.getAll().isEmpty());
	}
	
	@Test
	public void getClientByEmailTest() throws Exception {
		Client result = Client.builder().email(TEST_EMAIL).city(TEST_CITY).build();
		Mockito.when(clientDao.getClientByEmail(TEST_EMAIL)).thenReturn(result);
		
		clientService.getClientByEmail(TEST_EMAIL);
		
		Mockito.verify(clientDao).getClientByEmail(TEST_EMAIL);
	}
	
	@Test
	public void getClientByIdTest() {
		Client result = Client.builder().email(TEST_EMAIL).city(TEST_CITY).id(TEST_ID).build();
		Mockito.when(clientDao.getClientById(TEST_ID)).thenReturn(result);
		
		clientService.getClientById(TEST_ID);
		
		Mockito.verify(clientDao).getClientById(TEST_ID);
	}

}
