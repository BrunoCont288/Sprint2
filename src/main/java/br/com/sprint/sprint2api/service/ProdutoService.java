package br.com.sprint.sprint2api.service;

import br.com.sprint.sprint2api.exception.RecursoNaoEncontradoException;
import br.com.sprint.sprint2api.model.Produto;
import br.com.sprint.sprint2api.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Produto> listarTodos() {
        return produtoRepository.findAll();
    }

    public Produto buscarPorId(Long id) {
        return produtoRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Produto não encontrado com o ID: " + id));
    }

    public Produto salvar(Produto produto) {
        return produtoRepository.save(produto);
    }

    public void deletar(Long id) {
        Produto produto = buscarPorId(id); // Reutiliza a busca para garantir que o produto existe antes de deletar
        produtoRepository.delete(produto);
    }
}