import java.util.ArrayList;
import java.util.Scanner;

public class Inventario {

    private static final int LIMITE = 8; // Limite de itens no inventário.
    private static ArrayList<String> inventario = new ArrayList<String>();

    public static void adicionarItens() {
        String item;
        Scanner scanf = new Scanner(System.in);
        while (inventario.size() < LIMITE) {
            System.out.println("Digite o nome do item para adicionar ao inventário (ou 'sair' para finalizar):");
            item = scanf.nextLine();

            if (item.equalsIgnoreCase("sair")) {
                break;
            }

            if (!inventarioCheio()) {
                inventario.add(item);
                System.out.println("Item '" + item + "' adicionado ao inventário.");
            } else {
                System.out.println("O inventário está cheio! Não é possível adicionar mais itens.");
                break;
            }
        }
    }

    public static boolean inventarioCheio() {
        return inventario.size() >= LIMITE;
    }

    public static void exibirInventario() {
        System.out.println("Itens no inventário:");
        for (String item : inventario) {
            System.out.println("- " + item);
        }
    }

    public static void removerItem() {
        Scanner scanf = new Scanner(System.in);
        System.out.println("Digite o nome do item que deseja remover:");
        String item = scanf.nextLine();

        if (inventario.contains(item)) {
            inventario.remove(item);
            System.out.println("Item '" + item + "' removido do inventário.");
        } else {
            System.out.println("Item não encontrado no inventário.");
        }
    }

}

