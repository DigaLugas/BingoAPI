package com.digas.bingo.controller;

import com.digas.bingo.entity.Cartela;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("bingo")
public class GameController {


    @GetMapping("/cartela")
    public List<List<Integer>> getCartela() {
        Cartela cartela = new Cartela();
        return cartela.criaCartela();
    }
}
