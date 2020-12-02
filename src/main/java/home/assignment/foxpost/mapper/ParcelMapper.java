package home.assignment.foxpost.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import home.assignment.foxpost.model.Event;
import home.assignment.foxpost.model.Parcel;

@Mapper
public interface ParcelMapper {

	@Select(" SELECT id as id, sender_id as senderId, reciver_id as reciverId, parcel_no as parcelNumber FROM PARCELS WHERE sender_id = #{id}")
	public List<Parcel> getParcelsBySender (int id);

	@Select(" SELECT id as id, sender_id as senderId, reciver_id as reciverId, parcel_no as parcelNumber FROM PARCELS WHERE reciver_id = #{id}")
	public List<Parcel> getParcelsByReciver(int id);

	@Select(" SELECT id as id, sender_id as senderId, reciver_id as reciverId, parcel_no as parcelNumber FROM PARCELS WHERE parcel_no = #{parcelNumber}")
	public Parcel getParcelByNumber(String parcelNumber);
	
	@Select("SELECT e.id, e.event_name as eventName FROM parcels as p INNER JOIN trackings as t ON p.id=t.parcel_id INNER JOIN events AS e ON t.event_id = e.id WHERE t.parcel_id = #{parcelId} ORDER BY t.event_date DESC")
	public List<Event> getPraceEvents(int parcelId);

}
