package jwd.wafepa.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
// Model klase Korisnik
@Entity
public class Korisnik {
	
	@Id
	@GeneratedValue
	@Column
	private Long id;
	@Column(nullable = false, unique = true)
	private String korisnickoIme;
	@Column(nullable = false)
	private String lozinka;
	@Column
	private String ime;
	@Column
	private String prezime;
	@Column
	private String pol;
//	Administrator, Domacin, Gost
	@Column(nullable = false)
	private String uloga;
//	Ako je korisnik domacin
	@OneToMany(mappedBy="domacin", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private List<Apartman> apartmaniZaIzdavanje = new ArrayList<>();
//	Ako je korisnik gost 
	@ManyToMany(mappedBy = "gosti" ,cascade = { CascadeType.PERSIST,CascadeType.MERGE })   
	private List<Apartman> iznajmljeniApartmani = new ArrayList<>();
//	Ako je korisnik gost
	@OneToMany(mappedBy="gost", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private List<Rezervacija> rezervacije = new ArrayList<>();
//	Ako je korisnik gost
	@OneToMany(mappedBy="gost", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private List<Komentar> komentari = new ArrayList<>();
	
	public Korisnik() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getKorisnickoIme() {
		return korisnickoIme;
	}

	public void setKorisnickoIme(String korisnickoIme) {
		this.korisnickoIme = korisnickoIme;
	}

	public String getLozinka() {
		return lozinka;
	}

	public void setLozinka(String lozinka) {
		this.lozinka = lozinka;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public String getPol() {
		return pol;
	}

	public void setPol(String pol) {
		this.pol = pol;
	}

	public String getUloga() {
		return uloga;
	}

	public void setUloga(String uloga) {
		this.uloga = uloga;
	}

	public List<Apartman> getApartmaniZaIzdavanje() {
		return apartmaniZaIzdavanje;
	}

	public void setApartmaniZaIzdavanje(List<Apartman> apartmaniZaIzdavanje) {
		this.apartmaniZaIzdavanje = apartmaniZaIzdavanje;
	}
	public void AddApartmanZaIzdavanje(Apartman apartman) {
		if(apartman.getDomacin() != this) {
			apartman.setDomacin(this);
		}
		apartmaniZaIzdavanje.add(apartman);
	}

	public List<Rezervacija> getRezervacije() {
		return rezervacije;
	}

	public void setRezervacije(List<Rezervacija> rezervacije) {
		this.rezervacije = rezervacije;
	}
	public void addRezervacija(Rezervacija rezervacija) {
		if(rezervacija.getGost() != this) {
			rezervacija.setGost(this);
		}
		rezervacije.add(rezervacija);
	}

	public List<Komentar> getKomentari() {
		return komentari;
	}

	public void setKomentari(List<Komentar> komentari) {
		this.komentari = komentari;
	}
	public void addKomentar(Komentar komentar) {
		if(komentar.getGost() != this) {
			komentar.setGost(this);
		}
		komentari.add(komentar);
	}

	public List<Apartman> getIznajmljeniApartmani() {
		return iznajmljeniApartmani;
	}

	public void setIznajmljeniApartmani(List<Apartman> iznajmljeniApartmani) {
		this.iznajmljeniApartmani = iznajmljeniApartmani;
	}
	public void addIznajmljenApartman(Apartman apartman) {
		if(!apartman.getGosti().contains(this)) {
			apartman.getGosti().add(this);
		}
		iznajmljeniApartmani.add(apartman);
	}
}
