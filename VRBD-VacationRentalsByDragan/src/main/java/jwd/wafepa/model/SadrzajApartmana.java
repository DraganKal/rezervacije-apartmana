package jwd.wafepa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
// Model klase SadrzajApartmana
@Entity
public class SadrzajApartmana {
	
	@Id
	@GeneratedValue
	@Column
	private Long id;
	@Column(nullable = false)
	private String naziv;
	@ManyToOne(fetch=FetchType.EAGER)
	private Apartman apartman;
	
	public SadrzajApartmana() {
		super();
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public Apartman getApartman() {
		return apartman;
	}

	public void setApartman(Apartman apartman) {
		this.apartman = apartman;
		if(!apartman.getSadrzajApartmana().contains(this)){
			apartman.getSadrzajApartmana().add(this);
		}
	}
	
	

}
