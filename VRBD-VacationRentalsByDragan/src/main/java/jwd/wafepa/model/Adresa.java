package jwd.wafepa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
// Model klase Adresa
@Entity
public class Adresa {
	
	@Id
	@GeneratedValue
	@Column
	private Long id;
	@Column
	private String ulica;
	@Column
	private int broj;
	@Column
	private String mesto;
	@Column
	private int postanskiBroj;
	@OneToOne(mappedBy = "adresa" , fetch = FetchType.EAGER)
	private Lokacija lokacija;
	
	public Adresa() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUlica() {
		return ulica;
	}

	public void setUlica(String ulica) {
		this.ulica = ulica;
	}

	public int getBroj() {
		return broj;
	}

	public void setBroj(int broj) {
		this.broj = broj;
	}

	public String getMesto() {
		return mesto;
	}

	public void setMesto(String mesto) {
		this.mesto = mesto;
	}

	public int getPostanskiBroj() {
		return postanskiBroj;
	}

	public void setPostanskiBroj(int postanskiBroj) {
		this.postanskiBroj = postanskiBroj;
	}

	public Lokacija getLokacija() {
		return lokacija;
	}

	public void setLokacija(Lokacija lokacija) {
		this.lokacija = lokacija;
		if(!lokacija.getAdresa().equals(this)) {
			lokacija.setAdresa(this);
		}
	}
	
	

}
