/**
 * @author Jean-Marc Dje Bi
 * @since 14-12-2021
 * @version 1
 */

package com.cinetpay.repositories;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cinetpay.models.Robot;

public interface RobotRepository extends MongoRepository<Robot, String>{
	
	Optional<Robot> findByNumeroSim(String numeroSim);
	
}
