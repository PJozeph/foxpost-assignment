package home.assignment.foxpost.test;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import home.assignment.foxpost.api.service.ParcelService;
import home.assignment.foxpost.dao.ClientDao;
import home.assignment.foxpost.dao.ParcelDao;
import home.assignment.foxpost.model.Client;
import home.assignment.foxpost.model.Event;
import home.assignment.foxpost.model.Parcel;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { AppConfigurationTest.class })
public class ParcelServiceTest {

	private static final String PARCEL_NUMBER = "fp01";

	private static final int TEST_ID = 1;

	private static final String TEST_EMAIL = "kata@gmail.com";

	private static final String EVENT_NAME = "IN_BOX";

	@Autowired
	private ParcelService parcelService;

	@MockBean
	private ClientDao clientDao;

	@MockBean
	private ParcelDao parcelDao;

	@Test
	public void getParcelBySenderTest() throws Exception {
		Client client = Client.builder().email(TEST_EMAIL).id(TEST_ID).build();
		List<Parcel> parcels = Arrays.asList(Parcel.builder().senderId(TEST_ID).build(), Parcel.builder().senderId(TEST_ID).build());

		Mockito.when(clientDao.getClientByEmail(TEST_EMAIL)).thenReturn(client);
		Mockito.when(parcelDao.getParcelsBySender(client.getId())).thenReturn(parcels);

		parcelService.getBySender(TEST_EMAIL);

		Mockito.verify(clientDao).getClientByEmail(TEST_EMAIL);
		Mockito.verify(parcelDao).getParcelsBySender(TEST_ID);
	}

	@Test
	public void getParcelByReciverTest() throws Exception {
		Client client = Client.builder().email(TEST_EMAIL).id(TEST_ID).build();
		List<Parcel> parcels = Arrays.asList(Parcel.builder().senderId(TEST_ID).build(), Parcel.builder().senderId(TEST_ID).build());

		Mockito.when(clientDao.getClientByEmail(TEST_EMAIL)).thenReturn(client);
		Mockito.when(parcelDao.getParcelsBySender(client.getId())).thenReturn(parcels);

		parcelService.getByReciver(TEST_EMAIL);

		Mockito.verify(clientDao).getClientByEmail(TEST_EMAIL);
		Mockito.verify(parcelDao).getParcelsByReciver(TEST_ID);
	}

	@Test
	public void getParcelEventsByParcelNumberTest() {
		Parcel parcel = Parcel.builder().id(TEST_ID).build();
		List<Event> events = Arrays.asList(Event.builder().build());

		Mockito.when(parcelDao.getParcelByNumber(PARCEL_NUMBER)).thenReturn(parcel);
		Mockito.when(parcelDao.getParcelEvents(parcel.getId())).thenReturn(events);

		parcelService.getParceEvents(PARCEL_NUMBER);

		Mockito.verify(parcelDao).getParcelByNumber(PARCEL_NUMBER);
		Mockito.verify(parcelDao).getParcelEvents(TEST_ID);
	}

	@Test
	public void getLatestEventOfParcelTest() {
		Parcel parcel = Parcel.builder().id(TEST_ID).build();
		Event event = Event.builder().eventName(EVENT_NAME).build();
		
		Mockito.when(parcelDao.getParcelByNumber(PARCEL_NUMBER)).thenReturn(parcel);
		Mockito.when(parcelDao.getCurrentEvent(event.getId())).thenReturn(event);
		
		parcelService.getCurrentEvents(PARCEL_NUMBER);
		
		Mockito.verify(parcelDao).getParcelByNumber(PARCEL_NUMBER);
		Mockito.verify(parcelDao).getCurrentEvent(TEST_ID);
	}

}
