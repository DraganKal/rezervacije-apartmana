package jwd.wafepa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jwd.wafepa.model.Apartman;

@Repository
public interface ApartmanRepository extends JpaRepository<Apartman, Long>{

}
