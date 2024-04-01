package tec.escola.api.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import tec.escola.api.domain.professor.*;

@RestController
@RequestMapping("professor")
@SecurityRequirement(name = "bearer-key")
public class ProfessorController {
    @Autowired
    ProfessorRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastro(@RequestBody @Valid DadosCadastroProfessor dados, UriComponentsBuilder uriBuilder){
        var professor = new Professor(dados);
        repository.save(professor);
        var uri = uriBuilder.path("/professor/{id}").build().toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoProfessor(professor));
    }
    @GetMapping
    public ResponseEntity<Page<DadosListagemProfessor>> listar(
           @PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao){
        var page = repository.findAllByAtivoTrue(paginacao).map(DadosListagemProfessor::new);
        return ResponseEntity.ok(page);
    }
    @PutMapping
    @Transactional
    public ResponseEntity atuaizar(@RequestBody @Valid DadosAtualizacaoProfessor dados){
        var professor = repository.getReferenceById(dados.id());
        professor.atualizar(dados);

        return ResponseEntity.ok(new DadosDetalhamentoProfessor(professor));
    }
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id){
        var professor = repository.getReferenceById(id);
        professor.excluir();
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhamento(@PathVariable Long id){
        var professor = repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoProfessor(professor));
    }

}