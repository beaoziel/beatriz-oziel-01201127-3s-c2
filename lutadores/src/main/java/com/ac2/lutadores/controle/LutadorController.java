package com.ac2.lutadores.controle;

import com.ac2.lutadores.dominio.Lutador;
import com.ac2.lutadores.repositorio.LutadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@RestController
@RequestMapping("/lutadores")
public class LutadorController {

    @Autowired
    private LutadorRepository repository;

    @PostMapping
    public ResponseEntity postLutador(@RequestBody @Valid Lutador nvLutador) {
        repository.save(nvLutador);
        return ResponseEntity.status(201).build();
    }

    @GetMapping
    public ResponseEntity getLutador() {
        return ResponseEntity.status(200).body(repository.findAll());
    }

    @GetMapping("/contagem-vivos")
    public ResponseEntity getVivos() {
        return ResponseEntity.status(200).body(repository.findAllVivos().size());
    }

    @GetMapping("/contagem-mortos")
    public ResponseEntity getMortos() {
        return ResponseEntity.status(200).body(repository.findAllMortos().size());
    }

}
