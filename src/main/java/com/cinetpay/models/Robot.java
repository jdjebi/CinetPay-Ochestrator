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
 * Classe representant un robot
 */
@Document(collection="robots")
public class Robot {
	
	public static final String STATUS_BUSY = "BUSY";
	
	public static final String STATUS_FREE = "FREE";

	@Id
	private String id;
	
	@NotNull(message="Version du robot non renseigné")
	private String version;
	
	@NotNull(message="Operateur non renseigné")
	private String operateur;
	
	@NotNull(message="Numero de la sim non renseigné")
	@Field(name="numero_sim")
	private String numeroSim;
	
	@NotNull(message="Modele du robot non renseigné")
	private String modele;
	
	@NotNull(message="OS du modele non renseigné")
	private String os;
	
	@NotNull(message="Token firebase")
	private String tokenFirebase;
	
	private Integer solde;
	
	/*
	 * Valeurs: FREE ou BUSY
	 */
	private String status;

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getModele() {
		return modele;
	}

	public void setModele(String modele) {
		this.modele = modele;
	}

	public String getOs() {
		return os;
	}

	public void setOs(String os) {
		this.os = os;
	}

	public String getTokenFirebase() {
		return tokenFirebase;
	}

	public void setTokenFirebase(String tokenFirebase) {
		this.tokenFirebase = tokenFirebase;
	}

	public String getOperateur() {
		return operateur;
	}

	public void setOperateur(String operateur) {
		this.operateur = operateur;
	}

	public String getNumeroSim() {
		return numeroSim;
	}

	public void setNumeroSim(String numeroSim) {
		this.numeroSim = numeroSim;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getSolde() {
		return solde;
	}

	public void setSolde(Integer solde) {
		this.solde = solde;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}
