package com.test.jwt.model;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name= "rendezvous")
public class RendezVous {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idRdv;
	
	


	public RendezVous() {}
	
	@Column(name ="nom_client")
	private String nom_client;
	
	@Column(name ="prenom_client")
	private String prenom_client;
	
	@Column(name= "commentaire")
	private String commentaire;
	
	@Column(name ="numtel")
	private int numtel;
	
	@Column(name ="date_rdv")
	private Date date_rdv;
	
	@Column(name ="etat")
	private Boolean etat;

	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "user_id", nullable = false)
	@JsonIdentityReference

	private User user;



	public User getUser() {
		return user;
	}




	public void setUser(User user) {
		this.user = user;
	}




	public RendezVous(long idRdv, String nom_client, String prenom_client, String commentaire, int numtel,
			Date date_rdv, Boolean etat) {
		super();
		this.idRdv = idRdv;
		this.nom_client = nom_client;
		this.prenom_client = prenom_client;
		this.commentaire = commentaire;
		this.numtel = numtel;
		this.date_rdv = date_rdv;
		this.etat = etat;
	}




	public long getIdRdv() {
		return idRdv;
	}




	public String getNom_client() {
		return nom_client;
	}




	public String getPrenom_client() {
		return prenom_client;
	}




	public String getCommentaire() {
		return commentaire;
	}




	public int getNumtel() {
		return numtel;
	}




	public Date getDate_rdv() {
		return date_rdv;
	}




	public Boolean getEtat() {
		return etat;
	}




	public void setIdRdv(long idRdv) {
		this.idRdv = idRdv;
	}




	public void setNom_client(String nom_client) {
		this.nom_client = nom_client;
	}




	public void setPrenom_client(String prenom_client) {
		this.prenom_client = prenom_client;
	}




	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}




	public void setNumtel(int numtel) {
		this.numtel = numtel;
	}




	public void setDate_rdv(Date date_rdv) {
		this.date_rdv = date_rdv;
	}




	public void setEtat(Boolean etat) {
		this.etat = etat;
	}
	
	




	
	
}
