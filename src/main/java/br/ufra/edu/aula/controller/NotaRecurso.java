package br.ufra.edu.aula.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.ufra.edu.aula.model.Nota;
import br.ufra.edu.aula.service.NotaService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/notas")
public class NotaRecurso {
	
	@Autowired
    private NotaService notaService;

    @GetMapping
    public List<Nota> listarTodas() {
        return notaService.listarTodas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Nota> buscarPorId(@PathVariable Long id) {
        return notaService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Nota> criar(@RequestBody Nota nota) {
        Nota novaNota = notaService.salvar(nota);
        return ResponseEntity.ok(novaNota);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Nota> atualizar(@PathVariable Long id, @RequestBody Nota notaAtualizada) {
        return notaService.atualizar(id, notaAtualizada)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        boolean removido = notaService.excluir(id);
        return removido ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

}
