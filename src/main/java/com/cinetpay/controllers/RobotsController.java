/**
 * @author Jean-Marc Dje Bi
 * @since 14-12-2021
 * @version 1
 */

package com.cinetpay.controllers;

import java.util.HashMap;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cinetpay.entities.ErrorResponseEntity;
import com.cinetpay.entities.RobotStatusEntity;
import com.cinetpay.entities.SoldeEntity;
import com.cinetpay.entities.TokenFirebaseEntity;
import com.cinetpay.models.Operation;
import com.cinetpay.models.Robot;
import com.cinetpay.repositories.OperationRepository;
import com.cinetpay.repositories.RobotRepository;

/**
 * Classe representant l'API pour manipuler les robots du point de vue de l'orchestrateurs
 */
@RestController
public class RobotsController {

	@Autowired
	RobotRepository robotRepository;
	
	@Autowired
	OperationRepository operationRepository;
	
	/**
	 * Enregistre un robot
	 * @param robot
	 * @return
	 */
	@PostMapping("/robots")
	public ResponseEntity<Object> createRobot(@Valid @RequestBody(required = true) Robot robot) {
				
		Robot newRobot = null;
		
		Optional<Robot> optionalRobot = null;
		
		ErrorResponseEntity errorResponse = null;
				
		HashMap<String,String> response = null;
		
		optionalRobot = robotRepository.findByNumeroSim(robot.getNumeroSim());
		
		if(optionalRobot.isPresent()) {
				
			errorResponse = new ErrorResponseEntity();
			
			errorResponse.setCode(901);
			
			errorResponse.setError("Numéro de sim déjà enregisté");
			
			errorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
			
			return ResponseEntity.badRequest().body(errorResponse);

		}
		
		newRobot = robotRepository.save(robot);
		
		response = new HashMap<String,String>();
		
		response.put("id", newRobot.getId());
				
		return ResponseEntity.created(null).body(response);
	}
	
	/**
	 * Met a jour le token d'un robot
	 * @param id
	 * @return
	 */
	@PutMapping("/robots/{id}/token")
	public ResponseEntity<Object> updateRobotToken(@PathVariable String id, @Valid @RequestBody TokenFirebaseEntity tokenFirebase) {
				
		Robot robot = null;
		
		Optional<Robot> optionalRobot = null;
		
		ErrorResponseEntity errorResponse = null;
		
		optionalRobot = robotRepository.findById(id);
		
		if(optionalRobot.isEmpty()) {
			
			errorResponse = new ErrorResponseEntity();
			
			errorResponse.setCode(902);
			
			errorResponse.setError("Robot introuvable");
			
			errorResponse.setStatus(HttpStatus.NOT_FOUND.value());
			
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
	
		}
		
		robot = optionalRobot.get();
			
		robot.setTokenFirebase(tokenFirebase.getToken());
		
		robotRepository.save(robot);
		
		return ResponseEntity.noContent().build();
	}
	
	/**
	 * Met a jour le solde d'un robot
	 * @param id
	 * @return
	 */
	@PutMapping("/robots/{id}/solde")
	public ResponseEntity<Object> updateRobotSolde(@PathVariable String id, @Valid @RequestBody SoldeEntity soldeEntity) {
				
		Robot robot = null;
		
		Optional<Robot> optionalRobot = null;
		
		ErrorResponseEntity errorResponse = null;
		
		optionalRobot = robotRepository.findById(id);
		
		if(optionalRobot.isEmpty()) {
			
			errorResponse = new ErrorResponseEntity();
			
			errorResponse.setCode(902);
			
			errorResponse.setError("Robot introuvable");
			
			errorResponse.setStatus(HttpStatus.NOT_FOUND.value());
			
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
	
		}
		
		robot = optionalRobot.get();
			
		robot.setSolde(soldeEntity.getSolde());
		
		robotRepository.save(robot);
		
		return ResponseEntity.noContent().build();
	}
	
	/**
	 * Met a jour l'etat d'un robot
	 * @param id
	 * @return
	 */
	@PostMapping("/robots/status")
	public ResponseEntity<Object> updateRobotStatus(@Valid @RequestBody RobotStatusEntity robotStatusEntity) {
				
		Robot robot = null;
		
		ErrorResponseEntity errorResponse = null;
		
		Optional<Robot> optionalRobot = null;
				
		if(!robotStatusEntity.getStatus().equals(Robot.STATUS_BUSY) && !robotStatusEntity.getStatus().equals(Robot.STATUS_FREE)){
			
			errorResponse = new ErrorResponseEntity();
			
			errorResponse.setCode(903);
			
			errorResponse.setError("Statut du robot non pris en charge");
			
			errorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
			
			return ResponseEntity.badRequest().body(errorResponse);
			
		}
		
		optionalRobot = robotRepository.findById(robotStatusEntity.getId());
		
		if(optionalRobot.isEmpty()) {
			
			errorResponse = new ErrorResponseEntity();
			
			errorResponse.setCode(902);
			
			errorResponse.setError("Robot introuvable");
			
			errorResponse.setStatus(HttpStatus.NOT_FOUND.value());
			
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
		}
		
		robot = optionalRobot.get();
		
		robot.setSolde(robotStatusEntity.getSolde());
		
		robot.setStatus(robotStatusEntity.getStatus());
		
		robotRepository.save(robot);
		
		return ResponseEntity.noContent().build();
	}
	
	
	/**
	 * Enregistre une operation effectuee par un robot
	 * @param id
	 * @return
	 */
	@PostMapping("/operations")
	public ResponseEntity<Object> registerRobotSolde(@Valid @RequestBody Operation operation) {
				
		Operation newOperation = null;
		
		ErrorResponseEntity errorResponse = null;
				
		if(!operation.getStatus().equals(Operation.STATUS_SUCCESS) && !operation.getStatus().equals(Operation.STATUS_FAILED)){
			
			errorResponse = new ErrorResponseEntity();
			
			errorResponse.setCode(904);
			
			errorResponse.setError("Statut d'operation non pris en charge");
			
			errorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
			
			return ResponseEntity.badRequest().body(errorResponse);
			
		}
		
		newOperation = operationRepository.save(operation);
		
		return ResponseEntity.created(null).body(newOperation);
	}
	
}
