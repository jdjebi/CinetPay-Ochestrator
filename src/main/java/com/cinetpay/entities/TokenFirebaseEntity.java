/**
 * @author Jean-Marc Dje Bi
 * @since 14-12-2021
 * @version 1
 */

package com.cinetpay.entities;

import javax.validation.constraints.NotNull;

/**
 * Classe representant un token firebase
 */
public class TokenFirebaseEntity {

	@NotNull(message="Aucun token renseigné")
	private String token;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
}
