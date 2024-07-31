package com.digas.bingo.entity;

import java.util.Collections;
import java.util.ArrayList;
import java.util.List;

public class Sorteador {
    private List<Integer> bolas = new ArrayList<>();

    public Sorteador() {
        for (int i = 1; i <= 75; i++) {
            bolas.add(i);
        }
    }

    public void shuffle() {
        Collections.shuffle(bolas);
    }

    public int mostrar() {
        if (!bolas.isEmpty()) {
            return bolas.remove(0);
        } else {
            throw new IllegalStateException("No more balls to draw");
        }
    }
}
