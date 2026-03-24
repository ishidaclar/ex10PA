package com.clara.ex10.controllers;

import com.clara.ex10.models.TarefaModel;
import com.clara.ex10.services.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path="/tarefas")
public class TarefaController {

    @Autowired
    private TarefaService tarefaService;

    @GetMapping
    public ResponseEntity<List<TarefaModel>> findAll() {
        List<TarefaModel> requeste = tarefaService.findAll();
        return ResponseEntity.ok().body(requeste);
    }

    @PostMapping
    ResponseEntity<TarefaModel> criarTarefa(@RequestBody TarefaModel tarefaModel) {
        TarefaModel requeste = tarefaService.criarTarefa(tarefaModel);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(tarefaModel.getId()).toUri();

        return ResponseEntity.created(uri).body(requeste);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        tarefaService.remover(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public Optional<TarefaModel> buscarId(@PathVariable Long id) {
        return tarefaService.findById(id);

    }
}