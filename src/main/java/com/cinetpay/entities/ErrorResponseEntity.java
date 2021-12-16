/**
 * @author Jean-Marc Dje Bi
 * @since 14-12-2021
 * @version 1
 */

package com.cinetpay.entities;

/**
 * Classe representant une reponse generique
 */
public class ErrorResponseEntity {

	/**
	 * Message d'erreur
	 */
	private String error;
	
	/**
	 * Statut de la reponse
	 */
	private Integer status;
	
	/**
	 * Code de la reponse
	 */
	private int code;
	
	public ErrorResponseEntity(){
		
	}
	
	public ErrorResponseEntity(String error, int status, int code){
		this.error = error;
		this.status = status;
		this.code = code;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	
}
