package home.assignment.foxpost.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import home.assignment.foxpost.exception.RecordNotFoundException;
import home.assignment.foxpost.mapper.ParcelMapper;
import home.assignment.foxpost.model.Event;
import home.assignment.foxpost.model.Parcel;

public class ParcelDao {

	private static final String MESSAGE = " not present in db";
	@Autowired
	private ParcelMapper parcelMapper;

	public List<Parcel> getParcelsBySender(int clientId) {
		return parcelMapper.getParcelsBySender(clientId);
	}

	public List<Parcel> getParcelsByReciver(int id) {
		return parcelMapper.getParcelsByReciver(id);
	}

	public Parcel getParcelByNumber(String parcelNumber) {
		Parcel parcelByNumber = parcelMapper.getParcelByNumber(parcelNumber);
		if (parcelByNumber == null) {
			throw new RecordNotFoundException(parcelByNumber + MESSAGE);
		}
		return parcelByNumber;
	}

	public List<Event> getParcelEvents(int parcelId) {
		return parcelMapper.getPraceEvents(parcelId);
	}

	public Event getCurrentEvent(int parcelId) {
		return parcelMapper.getPraceEvents(parcelId).get(0);
	}

}
