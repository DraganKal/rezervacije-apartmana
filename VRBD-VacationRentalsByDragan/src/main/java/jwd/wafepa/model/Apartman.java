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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
// Model klase apartman
@Entity
public class Apartman {
	
	@Id
	@GeneratedValue
	@Column
	private Long id;
//	Ceo apartman ili soba
	@Column
	private String tip;
	@Column
	private int brojSoba;
	@Column
	private int brojGostiju;
	@ManyToOne(fetch=FetchType.EAGER)
	private Lokacija lokacija;
	
//	1 DATUMI ZA IZDAVANJE  ATRIBUT!!! URADI
	
//	2 DOSTUPNOST PO DATUMIMA ATRIBUT!! URADI
	
	@ManyToOne(fetch=FetchType.EAGER)
	private Korisnik domacin;
//	Veza sa klasom komentar
	@OneToMany(mappedBy="apartman", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private List<Komentar> komentari = new ArrayList<>();
	
//	3 SLIKE ATRIBUT!!! URADI
	
	@Column
	private double cenaNocenja;
	@Column
	private String vremeZaPrijavu;
	@Column
	private String vremeZaOdjavu;
//	Status(aktivno ili neaktivno)
	@Column
	private boolean aktivno;
	@OneToMany(mappedBy="apartman", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private List<SadrzajApartmana> sadrzajApartmana = new ArrayList<>();
	@OneToMany(mappedBy="apartman", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private List<Rezervacija> rezervacije = new ArrayList<>();
	@ManyToMany(fetch = FetchType.EAGER)   
	private List<Korisnik> gosti = new ArrayList<>();

	public Apartman() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}

	public int getBrojSoba() {
		return brojSoba;
	}

	public void setBrojSoba(int brojSoba) {
		this.brojSoba = brojSoba;
	}

	public int getBrojGostiju() {
		return brojGostiju;
	}

	public void setBrojGostiju(int brojGostiju) {
		this.brojGostiju = brojGostiju;
	}

	public Lokacija getLokacija() {
		return lokacija;
	}

	public void setLokacija(Lokacija lokacija) {
		this.lokacija = lokacija;
		if(!lokacija.getApartmani().contains(this)){
			lokacija.getApartmani().add(this);
		}
	}

	public Korisnik getDomacin() {
		return domacin;
	}

	public void setDomacin(Korisnik domacin) {
		this.domacin = domacin;
		if(!domacin.getApartmaniZaIzdavanje().contains(this)){
			domacin.getApartmaniZaIzdavanje().add(this);
		}
	}

	public double getCenaNocenja() {
		return cenaNocenja;
	}

	public void setCenaNocenja(double cenaNocenja) {
		this.cenaNocenja = cenaNocenja;
	}

	public String getVremeZaPrijavu() {
		return vremeZaPrijavu;
	}

	public void setVremeZaPrijavu(String vremeZaPrijavu) {
		this.vremeZaPrijavu = vremeZaPrijavu;
	}

	public String getVremeZaOdjavu() {
		return vremeZaOdjavu;
	}

	public void setVremeZaOdjavu(String vremeZaOdjavu) {
		this.vremeZaOdjavu = vremeZaOdjavu;
	}

	public boolean isAktivno() {
		return aktivno;
	}

	public void setAktivno(boolean aktivno) {
		this.aktivno = aktivno;
	}

	public List<SadrzajApartmana> getSadrzajApartmana() {
		return sadrzajApartmana;
	}

	public void setSadrzajApartmana(List<SadrzajApartmana> sadrzajApartmana) {
		this.sadrzajApartmana = sadrzajApartmana;
	}
	public void addSadrzajApartmana(SadrzajApartmana sadrzajZaDodavanje) {
		if(sadrzajZaDodavanje.getApartman() != this) {
			sadrzajZaDodavanje.setApartman(this);
		}
		sadrzajApartmana.add(sadrzajZaDodavanje);
	}

	public List<Rezervacija> getRezervacije() {
		return rezervacije;
	}

	public void setRezervacije(List<Rezervacija> rezervacije) {
		this.rezervacije = rezervacije;
	}
	public void addRezervacija(Rezervacija rezervacija) {
		if(rezervacija.getApartman() != this) {
			rezervacija.setApartman(this);
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
		if(komentar.getApartman() != this) {
			komentar.setApartman(this);
		}
		komentari.add(komentar);
	}

	public List<Korisnik> getGosti() {
		return gosti;
	}

	public void setGosti(List<Korisnik> gosti) {
		this.gosti = gosti;
	}
	public void addGost(Korisnik korisnik) {
		if(!korisnik.getIznajmljeniApartmani().contains(this)) {
			korisnik.getIznajmljeniApartmani().add(this);
		}
		gosti.add(korisnik);
	}
	
	

}
