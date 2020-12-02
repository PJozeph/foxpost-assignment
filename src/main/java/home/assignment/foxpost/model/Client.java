package home.assignment.foxpost.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Client {

	private int id;
	private String clientName;
	private String address;
	private String zipCode;
	private String city;
	private String phone;
	private String email;

}
