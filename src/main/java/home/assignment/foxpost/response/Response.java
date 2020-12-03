package home.assignment.foxpost.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import home.assignment.foxpost.model.Client;
import home.assignment.foxpost.model.Event;
import home.assignment.foxpost.model.Parcel;
import lombok.Builder;
import lombok.Data;

@Data 
@Builder 
@JsonInclude(Include.NON_NULL)
public class Response {

	private Client client;
	private Parcel parcel;
	private Event event;
	private List<Event> events;
	private List<Parcel> parcels;

}
