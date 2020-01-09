package jwd.wafepa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jwd.wafepa.model.Adresa;

@Repository
public interface AdresaRepository extends JpaRepository<Adresa, Long>{

}
