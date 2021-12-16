/**
 * @author Jean-Marc Dje Bi
 * @since 16-12-2021
 * @version 1
 */

package com.cinetpay.scheduler;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.cinetpay.models.Robot;
import com.cinetpay.ping.RobotsPinger;
import com.cinetpay.repositories.RobotRepository;
import com.google.firebase.messaging.FirebaseMessagingException;

/**
 * Classe de la tache periodique de ping des robots. Periode de ping 1 minutes
 */
@Component
public class PingRobotScheduler {
	
	@Autowired
	RobotsPinger robotsPinger;
	
	@Autowired
	RobotRepository robotRepository;
	
	Logger logger = LoggerFactory.getLogger(PingRobotScheduler.class);

	@Scheduled(initialDelay = 10 * 1000, fixedDelay =   60 * 1000)
	public void run() throws FirebaseMessagingException, IOException {
		
		List<Robot> robots = robotRepository.findAll();
		
		logger.info("PING " + robots.size()  + " robots started");
		
		robotsPinger.ping(robots);
				
	}
}
