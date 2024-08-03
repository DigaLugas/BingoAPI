package com.digas.bingo.entity;

import java.util.Collections;

import java.util.Stack;

public class Sorteador {
    private final Stack<Integer> bolas = new Stack<>();

    public Sorteador() {
        for (int i = 1; i <= 75; i++) {
            bolas.add(i);
        }
    }

    private void shuffle() {
        Collections.shuffle(bolas);
    }

    public int mostrar() {
        if (!bolas.isEmpty()) {
            return bolas.pop();
        } else {
            throw new IllegalStateException("Sem bolas para sortear");
        }
    }
}
