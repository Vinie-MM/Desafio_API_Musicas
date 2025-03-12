package DesafioSpringBoot.desafioAPI.Controller;


import DesafioSpringBoot.desafioAPI.Domain.Model.Songs;
import DesafioSpringBoot.desafioAPI.Service.songsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/songs")
public class songController {

    private final songsService songservice;

    public songController (songsService songservice){
        this.songservice = songservice;
    }

    @GetMapping
    public ResponseEntity<List<Songs>> findAll(){
        var musicas = songservice.findAll();

        return ResponseEntity.ok(musicas);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Songs> findById(@PathVariable Long id) {
        var user = songservice.findById(id);
        return ResponseEntity.ok(user);
    }

    @PostMapping
    public ResponseEntity<Songs> create(@RequestBody Songs songtoCreate) {
        var userCreated = songservice.create(songtoCreate);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(userCreated.getId())
                .toUri();
        return ResponseEntity.created(location).body(userCreated);
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        songservice.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Songs> update(@PathVariable Long id, @RequestBody Songs novaMusica) {
        var user = songservice.update(id, novaMusica);
        return ResponseEntity.ok(user);

}
}