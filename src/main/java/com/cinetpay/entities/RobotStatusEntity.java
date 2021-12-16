/**
 * @author Jean-Marc Dje Bi
 * @since 14-12-2021
 * @version 1
 */
package com.cinetpay.entities;

import javax.validation.constraints.NotNull;

/**
 * Classe representant l'etat d'un robot
 *
 */
public class RobotStatusEntity {

	@NotNull(message="id non renseigné")
	private String id;
	
	@NotNull(message="statut non renseigné")
	private String status;
	
	@NotNull(message=" non renseigné")
	private Integer solde;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getSolde() {
		return solde;
	}

	public void setSolde(Integer solde) {
		this.solde = solde;
	}
}
