package home.assignment.foxpost.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import home.assignment.foxpost.api.response.ErrorResponse;
import home.assignment.foxpost.dao.ClientDao;
import home.assignment.foxpost.exception.RecordNotFoundException;
import home.assignment.foxpost.model.Client;

@RestController
@RequestMapping("client")
public class ClientService {

	@Autowired
	private ClientDao clientDao;

	@RequestMapping("/getAll")
	public List<Client> getAll() {
		return clientDao.getAll();
	}

	@RequestMapping("/getByEmail")
	public ResponseEntity<Client> getClientByEmail(@RequestParam("email") String email) {
		Client clientByEmail = clientDao.getClientByEmail(email);
		return ResponseEntity.status(HttpStatus.OK).body(clientByEmail);
	}

	@RequestMapping("/getById")
	public ResponseEntity<Client> getClientById(@RequestParam("id") int id) {
		Client clientById = clientDao.getClientById(id);
		return ResponseEntity.status(HttpStatus.OK).body(clientById);
	}

	@ExceptionHandler({ RecordNotFoundException.class })
	public ResponseEntity<ErrorResponse> handleException(RecordNotFoundException e) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND)
				.body(ErrorResponse.builder().message(e.getMessage()).build());
	}

}
