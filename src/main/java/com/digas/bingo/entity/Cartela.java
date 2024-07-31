package com.digas.bingo.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class Cartela {
    private Random random = new Random();

    public List<List<Integer>> criaCartela() {
        List<List<Integer>> cartela = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            cartela.add(new ArrayList<>());
        }

        for (int j = 0; j < 5; j++) {
            Set<Integer> columnSet = new HashSet<>();
            for (int i = 0; i < 5; i++) {
                if (j == 2 && i == 2) {
                    cartela.get(j).add(0);
                    continue;
                }

                int num;
                switch (j) {
                    case 0:
                        do {
                            num = random.nextInt(15) + 1;
                        } while (columnSet.contains(num));
                        columnSet.add(num);
                        break;
                    case 1:
                        do {
                            num = random.nextInt(15) + 16;
                        } while (columnSet.contains(num));
                        columnSet.add(num);
                        break;
                    case 2:
                        do {
                            num = random.nextInt(15) + 31;
                        } while (columnSet.contains(num));
                        columnSet.add(num);
                        break;
                    case 3:
                        do {
                            num = random.nextInt(15) + 46;
                        } while (columnSet.contains(num));
                        columnSet.add(num);
                        break;
                    case 4:
                        do {
                            num = random.nextInt(15) + 61;
                        } while (columnSet.contains(num));
                        columnSet.add(num);
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + j);
                }
                cartela.get(j).add(num);
            }
        }

        return cartela;
    }
}
