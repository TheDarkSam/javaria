package ItensGerais;

import java.util.ArrayList;

public class Inventario {

    private static final int LIMITE = 8; // Limite de itens no inventário.
    private static ArrayList<Itens> inventario = new ArrayList<>();

    public static void adicionarItens(Itens item) {
        inventario.add(item);
    }

    public static boolean inventarioCheio() {
        System.out.println("O inventário está cheio.");
        return inventario.size() >= LIMITE;
    }

    public static void exibirInventario() {
        System.out.println("ItensGerais.Itens no inventário:");
        for (Itens item : inventario) {
            System.out.println("- " + item);
        }
    }

    public static void removerItem() {}
}

