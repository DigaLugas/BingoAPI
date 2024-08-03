package com.digas.bingo.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class Cartela {
    private Random random = new Random();
    private List<List<Integer>> cartela;

    public List<List<Integer>> criaCartela() {
        cartela = new ArrayList<>();
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

    public List<List<Integer>> atualizarCartela() {
        return criaCartela();
    }

    public boolean marcarNumero(int numero) {
        for (List<Integer> coluna : cartela) {
            if (coluna.contains(numero)) {
                int index = coluna.indexOf(numero);
                coluna.set(index, -1); //marca o número como -1
                return true;
            }
        }
        return false;
    }

    public boolean verificarBingo() {
        for (int i = 0; i < 5; i++) { //Verifica linhas
            boolean linhaCompleta = true;
            for (int j = 0; j < 5; j++) {
                if (i == 2 && j == 2) continue;
                if (cartela.get(j).get(i) != -1 && cartela.get(j).get(i) != 0) {
                    linhaCompleta = false;
                    break;
                }
            }
            if (linhaCompleta) return true;
        }


        for (int j = 0; j < 5; j++) {
            boolean colunaCompleta = true; //verificar colunas
            for (int i = 0; i < 5; i++) {
                if (i == 2 && j == 2) continue;
                if (cartela.get(j).get(i) != -1 && cartela.get(j).get(i) != 0) {
                    colunaCompleta = false;
                    break;
                }
            }
            if (colunaCompleta) return true;
        }


        boolean diagonalPrincipal = true; //verificar diagonais
        boolean diagonalSecundaria = true;
        for (int i = 0; i < 5; i++) {
            if (i == 2) continue;
            if (cartela.get(i).get(i) != -1 && cartela.get(i).get(i) != 0) {
                diagonalPrincipal = false;
            }
            if (cartela.get(i).get(4 - i) != -1 && cartela.get(i).get(4 - i) != 0) {
                diagonalSecundaria = false;
            }
        }
        return diagonalPrincipal || diagonalSecundaria;
    }
}
