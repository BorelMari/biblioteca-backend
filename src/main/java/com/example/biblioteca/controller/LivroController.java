
package com.example.biblioteca.controller;

import com.example.biblioteca.model.Livro;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class LivroController {

    // Lista para armazenar os livros
    List<Livro> livros = new ArrayList<>();

    // 1 - Cadastrar um novo livro
    @PostMapping("/livros")
    public void cadastrarLivro(@RequestBody Livro livro) {
        livros.add(livro);
    }

    // 2 - Listar todos os livros
    @GetMapping("/livros")
    public List<Livro> listarLivros() {
        return livros;
    }

    // 3 - Listar somente os livros disponíveis
    @GetMapping("/livros/disponiveis")
    public List<Livro> listarLivrosDisponiveis() {

        List<Livro> disponiveis = new ArrayList<>();

        for (Livro livroAtual : livros) {

            if (livroAtual.getQuantidadeDisponivel() > 0) {
                disponiveis.add(livroAtual);
            }

        }

        return disponiveis;
    }

    // 4 - Obter a quantidade total de livros cadastrados
    @GetMapping("/livros/total")
    public int quantidadeTotalLivros() {
        return livros.size();
    }

}
