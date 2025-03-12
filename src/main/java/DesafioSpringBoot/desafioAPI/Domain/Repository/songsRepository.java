package DesafioSpringBoot.desafioAPI.Domain.Repository;

import DesafioSpringBoot.desafioAPI.Domain.Model.Songs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface songsRepository extends JpaRepository<Songs, Long> {

}
