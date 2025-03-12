package DesafioSpringBoot.desafioAPI.Service;

import DesafioSpringBoot.desafioAPI.Domain.Model.Songs;

import java.util.List;

public interface songsService extends CRUDService<Long, Songs>{

    Songs findById(Long id);

    Songs create(Songs songtoCreate);



}
