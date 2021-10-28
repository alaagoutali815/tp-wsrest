package com.example.entities;

import java.util.Date;


import javax.persistence.GeneratedValue;
import javax.persistence.Id;





public class Compte {
	@Id
	@GeneratedValue
		private long code;
		
		private double solde;

		private Date dateCreation;

		public Compte(long code, double solde, Date dateCreation) {
			super();
			this.code = code;
			this.solde = solde;
			this.dateCreation = dateCreation;
		}

		public Compte() {
			super();
		}

		public long getCode() {
			return code;
		}

		public void setCode(long code) {
			this.code = code;
		}

		public double getSolde() {
			return solde;
		}

		public void setSolde(double solde) {
			this.solde = solde;
		}

		public Date getDateCreation() {
			return dateCreation;
		}

		public void setDateCreation(Date dateCreation) {
			this.dateCreation = dateCreation;
		}
		

		
	
}
