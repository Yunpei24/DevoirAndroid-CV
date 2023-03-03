package sn.esmt.emploie.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sn.esmt.emploie.entities.AppUserCVEntity;

@Repository
public interface AppUserCVRepository extends JpaRepository<AppUserCVEntity,Integer> {
    AppUserCVEntity findByEmailAndNomAndPrenom(String email, String nom, String prenom);
}
