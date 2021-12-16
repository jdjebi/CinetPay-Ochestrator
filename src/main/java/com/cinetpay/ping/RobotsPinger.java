package com.cinetpay.ping;

import java.io.IOException;
import java.net.InetAddress;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cinetpay.models.Robot;
import com.cinetpay.service.ServerPortService;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingException;
import com.google.firebase.messaging.MulticastMessage;

/**
 * Classe de gestion des pings a destination des robots
 */
@Component
public class RobotsPinger {
	
	@Autowired
	ServerPortService serverPortService;
	
	private String responseUrl;
	
	/**
	 * Initialse le gestionnaire en definissant l'url de reponse
	 * @throws IOException
	 */
	@PostConstruct
	public void initializer() throws IOException {
		
		this.responseUrl = "http://" + InetAddress.getLocalHost().getHostAddress() + ":" + serverPortService.getPort() + "/robots/status";
		
	}
	
	/**
	 * Effectue un ping sur un robot
	 * @param robot
	 * @throws IOException 
	 * @throws FirebaseMessagingException 
	 */
	public void ping(List<Robot> robots) throws IOException, FirebaseMessagingException {
		
		List<String> tokens = robots.stream().map(Robot::getTokenFirebase).collect(Collectors.toList());
							
		MulticastMessage message = MulticastMessage.builder()
			    .putData("action", "PING")
			    .putData("responseUrl", this.responseUrl)
			    .addAllTokens(tokens)
			    .build();
		
		FirebaseMessaging.getInstance().sendMulticast(message);
						
	}
	
	
}
