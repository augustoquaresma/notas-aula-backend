package br.ufra.edu.aula.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufra.edu.aula.model.Nota;
import br.ufra.edu.aula.repository.INotas;

@Service
public class NotaService {
	
	@Autowired
    private INotas notaRepository;

    public List<Nota> listarTodas() {
        return notaRepository.findAll();
    }

    public Optional<Nota> buscarPorId(Long id) {
        return notaRepository.findById(id);
    }

    public Nota salvar(Nota nota) {
        return notaRepository.save(nota);
    }

    public Optional<Nota> atualizar(Long id, Nota notaAtualizada) {
        return notaRepository.findById(id).map(nota -> {
            nota.setTitulo(notaAtualizada.getTitulo());
            nota.setDescricao(notaAtualizada.getDescricao());
            nota.setResponsavel(notaAtualizada.getResponsavel());
            // dataAtualizacao será atualizada automaticamente via @PreUpdate
            return notaRepository.save(nota);
        });
    }

    public boolean excluir(Long id) {
        return notaRepository.findById(id).map(nota -> {
            notaRepository.delete(nota);
            return true;
        }).orElse(false);
    }

}
