/**
 * @author Jean-Marc Dje Bi
 * @since 14-12-2021
 * @version 1
 */

package com.cinetpay.entities;

import javax.validation.constraints.NotNull;

/**
 * Classe representant un solde
 */
public class SoldeEntity {

	@NotNull(message="Aucun solde renseigné")
	private Integer solde;

	public Integer getSolde() {
		return solde;
	}

	public void setSolde(Integer solde) {
		this.solde = solde;
	}

	
}
