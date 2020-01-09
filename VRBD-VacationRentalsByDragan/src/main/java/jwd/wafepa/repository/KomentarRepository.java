package jwd.wafepa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jwd.wafepa.model.Komentar;

@Repository
public interface KomentarRepository extends JpaRepository<Komentar, Long>{

}
