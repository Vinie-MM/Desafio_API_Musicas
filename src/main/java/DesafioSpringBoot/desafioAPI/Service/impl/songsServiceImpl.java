package DesafioSpringBoot.desafioAPI.Service.impl;


import DesafioSpringBoot.desafioAPI.Domain.Model.Songs;
import DesafioSpringBoot.desafioAPI.Domain.Repository.songsRepository;
import DesafioSpringBoot.desafioAPI.Service.songsService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class songsServiceImpl implements songsService {
    private final songsRepository songRepository;


    public songsServiceImpl(songsRepository songRepository) {
        this.songRepository = songRepository;
    }

    @Override
    public List<Songs> findAll() {
        return List.of();
    }

    @Override
    public Songs findById(Long id){
        return songRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Songs create(Songs songtoCreate){
        return songRepository.save(songtoCreate);
    }

    @Override
    public Songs update(Long aLong, Songs entity) {
        return null;
    }

    @Override
    public void delete(Long aLong) {

    }


}
