package jwd.wafepa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
// Model klase Rezervacija
@Entity
public class Rezervacija {
	
	@Id
	@GeneratedValue
	@Column
	private Long id;
	@ManyToOne(fetch=FetchType.EAGER)
	private Apartman apartman;
	
//	POCETNI DATUM REZERVACIJE ATRIBUT!!!! URADI
	
	@Column
	int brojNocenja;
	@Column
	double ukupnaCena;
	@ManyToOne(fetch=FetchType.EAGER)
	private Korisnik gost;
//	Kreirana, Odbijena, Odustanak, Prihvacena, Zavrsena
	@Column
	private String status;
	
	public Rezervacija() {
		super();
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Apartman getApartman() {
		return apartman;
	}
	public void setApartman(Apartman apartman) {
		this.apartman = apartman;
		if(!apartman.getRezervacije().contains(this)){
			apartman.getRezervacije().add(this);
		}
	}
	public int getBrojNocenja() {
		return brojNocenja;
	}
	public void setBrojNocenja(int brojNocenja) {
		this.brojNocenja = brojNocenja;
	}
	public double getUkupnaCena() {
		return ukupnaCena;
	}
	public void setUkupnaCena(double ukupnaCena) {
		this.ukupnaCena = ukupnaCena;
	}
	public Korisnik getGost() {
		return gost;
	}
	public void setGost(Korisnik gost) {
		this.gost = gost;
		if(!gost.getRezervacije().contains(this)){
			gost.getRezervacije().add(this);
		}
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	

}
