/**
 * @author Jean-Marc Dje Bi
 * @since 16-12-2021
 * @version 1
 */

package com.cinetpay.controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cinetpay.ping.RobotsPinger;
import com.cinetpay.repositories.RobotRepository;
import com.google.firebase.messaging.FirebaseMessagingException;

import com.cinetpay.models.Robot;

/**
 * Classe du controlleur de test du ping des robots
 */
@RestController
public class PingTestController {
	
	@Autowired
	RobotsPinger robotsPinger;
	
	@Autowired
	RobotRepository robotRepository;
    
	@GetMapping("/ping/robots")
	public ResponseEntity<Object> httpPingTest() throws IOException, FirebaseMessagingException {	
		
		
		List<Robot> robots = robotRepository.findAll();
		
		robotsPinger.ping(robots);
		
		return ResponseEntity.noContent().build();
				
	}
	
}