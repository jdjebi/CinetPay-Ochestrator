/**
 * @author Jean-Marc Dje Bi
 * @since 14-12-2021
 * @version 1
 */

package com.cinetpay.models;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * Classe representant une transaction
 */
@Document(collection="operations")
public class Operation {
	
	public static final String STATUS_SUCCESS = "SUCCESS";
	
	public static final String STATUS_FAILED = "FAILED";

	@Id
	private String id;
	
	@NotNull(message="Identifiant de la operation non renseigné")
	@Field(name="id_transaction")
	private String idTransaction;
	
	/**
	 * Les valeurs du statut: SUCCESS ou FAILED
	 */
	@NotNull(message="Identifiant de la operation non renseigné")
	private String status;
	
	private String message;
	
	@NotNull(message="Solde de l'operation non renseigné")
	private Integer solde;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getIdTransaction() {
		return idTransaction;
	}

	public void setIdTransaction(String idTransaction) {
		this.idTransaction = idTransaction;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Integer getSolde() {
		return solde;
	}

	public void setSolde(Integer solde) {
		this.solde = solde;
	}
}
