package home.assignment.foxpost.model;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class Tracking {

	private int id;
	private int parcelId;
	private Timestamp eventDate;
	private int eventId;
	
}
