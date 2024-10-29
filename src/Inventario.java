import java.util.ArrayList;

public class Inventario {

    private static final int LIMITE = 8; // Limite de itens no inventário.
    private static ArrayList<Itens> inventario = new ArrayList<>();

    public static void adicionarItens(Itens bovoite) {
        inventario.add(bovoite);
    }

    public static boolean inventarioCheio() {
        return inventario.size() >= LIMITE;
    }

    public static void exibirInventario() {
        System.out.println("Itens no inventário:");
        for (Itens item : inventario) {
            System.out.println("- " + item);
        }
    }

    public static void removerItem() {
    }

}

