/**
 * @author Jean-Marc Dje Bi
 * @since 14-12-2021
 * @version 1
 */

package com.cinetpay.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cinetpay.models.Operation;

public interface OperationRepository extends MongoRepository<Operation, String>{
	
}
