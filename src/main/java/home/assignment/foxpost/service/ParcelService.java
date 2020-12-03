package home.assignment.foxpost.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import home.assignment.foxpost.dao.ClientDao;
import home.assignment.foxpost.dao.ParcelDao;
import home.assignment.foxpost.exception.RecordNotFoundException;
import home.assignment.foxpost.model.Client;
import home.assignment.foxpost.model.Event;
import home.assignment.foxpost.model.Parcel;
import home.assignment.foxpost.response.ErrorResponse;
import home.assignment.foxpost.response.Response;

@RestController
@RequestMapping("parcel")
public class ParcelService {

	@Autowired
	private ParcelDao parcelDao;

	@Autowired
	private ClientDao clientDao;

	@RequestMapping("/getBySender")
	public ResponseEntity<Response> getBySender(@RequestParam("email") String email) {
		Client client = clientDao.getClientByEmail(email);
		List<Parcel> parcelsBySender = parcelDao.getParcelsBySender(client.getId());

		Response.builder().client(client).parcels(parcelsBySender).build();
		return ResponseEntity.status(HttpStatus.OK).body(Response.builder().client(client).parcels(parcelsBySender).build());
	}

	@RequestMapping("/getByReciver")
	public ResponseEntity<Response> getByReciver(@RequestParam("email") String email) {
		Client client = clientDao.getClientByEmail(email);
		List<Parcel> parcelsByReciver = parcelDao.getParcelsByReciver(client.getId());
		
		return ResponseEntity.status(HttpStatus.OK).body(Response.builder().client(client).parcels(parcelsByReciver).build());
	}

	@RequestMapping("/getEvents")
	public ResponseEntity<Response> getParceEvents(@RequestParam("parcelNumber") String parcelNumber) {
		Parcel parcel = parcelDao.getParcelByNumber(parcelNumber);
		List<Event> parcelEvents = parcelDao.getParcelEvents(parcel.getId());
		
		return ResponseEntity.status(HttpStatus.OK).body(Response.builder().events(parcelEvents).build());
	}

	@RequestMapping("/getCurrentEvent")
	public ResponseEntity<Response> getCurrentEvents(@RequestParam("parcelNumber") String parcelNumber) {
		Parcel parcel = parcelDao.getParcelByNumber(parcelNumber);
		Event currentEvent = parcelDao.getCurrentEvent(parcel.getId());
		
		return ResponseEntity.status(HttpStatus.OK).body(Response.builder().event(currentEvent).build());
	}

	@ExceptionHandler({ RecordNotFoundException.class })
	public ResponseEntity<ErrorResponse> handleException(RecordNotFoundException e) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ErrorResponse.builder().message(e.getMessage()).build());
	}

}
