package home.assignment.foxpost.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import home.assignment.foxpost.model.Client;

@Mapper
public interface ClientMapper {

	@Select("SELECT id as id, client_name as clientName, address as address, zip_code as zipCode, city as city, phone as phone, email as email FROM CLIENTS")
	public List<Client> getAll();

	@Select("SELECT id as id, client_name as clientName, address as address, zip_code as zipCode, city as city, phone as phone, email as email FROM CLIENTS where email = #{email}")
	public Client getClientByEmail(String email);
	
	@Select("SELECT id as id, client_name as clientName, address as address, zip_code as zipCode, city as city, phone as phone, email as email FROM CLIENTS where id = #{id}")
	public Client getClientById(int id);
	
}
