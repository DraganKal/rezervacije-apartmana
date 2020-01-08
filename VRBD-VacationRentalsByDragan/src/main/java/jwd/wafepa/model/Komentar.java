package jwd.wafepa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
// Model klase Komentar
@Entity
public class Komentar {
	
	@Id
	@GeneratedValue
	@Column
	private Long id;
	@ManyToOne(fetch=FetchType.EAGER)
	private Korisnik gost;
	@ManyToOne(fetch=FetchType.EAGER)
	private Apartman apartman;
	@Column
	private String tekst;
//	1-5
	@Column
	private int ocena;
	
	public Komentar() {
		super();
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Korisnik getGost() {
		return gost;
	}
	public void setGost(Korisnik gost) {
		this.gost = gost;
		if(!gost.getKomentari().contains(this)){
			gost.getKomentari().add(this);
		}
	}
	public Apartman getApartman() {
		return apartman;
	}
	public void setApartman(Apartman apartman) {
		this.apartman = apartman;
		if(!apartman.getKomentari().contains(this)){
			apartman.getKomentari().add(this);
		}
	}
	public String getTekst() {
		return tekst;
	}
	public void setTekst(String tekst) {
		this.tekst = tekst;
	}
	public int getOcena() {
		return ocena;
	}
	public void setOcena(int ocena) {
		this.ocena = ocena;
	}
	
	
	
	

}
