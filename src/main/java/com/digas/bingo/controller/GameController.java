package com.digas.bingo.controller;

import com.digas.bingo.entity.Cartela;
import com.digas.bingo.entity.Sorteador;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("bingo")
public class GameController {
    Sorteador sorteador = new Sorteador();
    Cartela cartela = new Cartela();
    List<List<Integer>> cartelaDoJogador = cartela.criaCartela();

    @PutMapping("/cartela/nova-cartela")
    public List<List<Integer>> gerarCartelaNova(){
        cartelaDoJogador = cartela.criaCartela();
        return cartelaDoJogador;
    }

    @GetMapping("/cartela")
    public List<List<Integer>> getCartela() {
        return cartelaDoJogador;
    }

    @GetMapping("/sorteador")
    public int getNumeroSorteado(){
        int numeroSorteado = sorteador.mostrar();
        cartela.marcarNumero(numeroSorteado);
        return numeroSorteado;
    }

    @PutMapping("/cartela/atualizar")
    public List<List<Integer>> atualizarCartela() {
        cartelaDoJogador = cartela.atualizarCartela();
        return cartelaDoJogador;
    }

    @GetMapping("/verificar")
    public boolean verificarBingo() {
        return cartela.verificarBingo();
    }
}
