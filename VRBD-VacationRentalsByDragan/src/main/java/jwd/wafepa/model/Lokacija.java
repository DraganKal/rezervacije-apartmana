package jwd.wafepa.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

// Model klase Lokacija
@Entity
public class Lokacija {
	@Id
	@GeneratedValue
	@Column
	private Long id;
	@Column
	private double geografskaSirina;
	@Column
	private double geografskaDuzina;
	@OneToOne(fetch = FetchType.LAZY)
	private Adresa adresa;
	@OneToMany(mappedBy="lokacija", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private List<Apartman> apartmani = new ArrayList<>();
	
	
	public Lokacija() {
		super();
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public double getGeografskaSirina() {
		return geografskaSirina;
	}
	public void setGeografskaSirina(double geografskaSirina) {
		this.geografskaSirina = geografskaSirina;
	}
	public double getGeografskaDuzina() {
		return geografskaDuzina;
	}
	public void setGeografskaDuzina(double geografskaDuzina) {
		this.geografskaDuzina = geografskaDuzina;
	}
	public Adresa getAdresa() {
		return adresa;
	}
	public void setAdresa(Adresa adresa) {
		this.adresa = adresa;
		if(!adresa.getLokacija().equals(this)) {
			adresa.setLokacija(this);
		}
	}
	public List<Apartman> getApartmani() {
		return apartmani;
	}
	public void setApartmani(List<Apartman> apartmani) {
		this.apartmani = apartmani;
	}
	public void addApartman(Apartman apartman) {
		if(apartman.getLokacija() != this) {
			apartman.setLokacija(this);
		}
		apartmani.add(apartman);
	}
	
	
	

}
