package jwd.wafepa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jwd.wafepa.model.SadrzajApartmana;

@Repository
public interface SadrzajApartmanaRepository extends JpaRepository<SadrzajApartmana, Long>{

}
