import java.util.Scanner;

public class Batalha {

    public static void clear() {
        for (int i = 0; i < 100; i++) {
            System.out.println();
        }
    }//trocar por clear dps!

    private Personagem personagem;
    private Inimigos inimigo;

    public void definirPersonagem(Personagem personagem) {
        this.personagem = personagem;
    }

    public void definirInimigo(Inimigos inimigo) {
        this.inimigo = inimigo;
    }

    public void iniciar() {
        while (inimigo.inimigoestaVivo() && personagem.estaVivo()) {
            clear();
            System.out.println("+ --------------------------------------------------- +");
            System.out.println("            Seu inimigo é um " + inimigo.getNome());
            System.out.println("+ --------------------------------------------------- +");
            System.out.println(" ");
            System.out.println("-> O que " + personagem.getNome() + " deve fazer?");
            System.out.println(" ");
            System.out.println("1 - Atacar.");
            System.out.println("2 - Recuperar STA/MAN.");
            System.out.println("3 - Abrir Inventário.");
            System.out.println("4 - Fugir.");
            System.out.println(" ");
            System.out.println("+ --------------------------------------------------- +");

            Scanner scanf = new Scanner(System.in);
            int escolhaBatalha = scanf.nextInt();
            scanf.nextLine();

            if (escolhaBatalha == 1) {
                clear();
                personagem.atacar(inimigo);
                if (inimigo.inimigoestaVivo()) {
                    int danoInimigo = inimigo.inimigocalcularDano(personagem);
                    System.out.println(inimigo.getNome() + " ataca " + personagem.getNome() + " causando [" + danoInimigo + "] de dano!");
                    personagem.receberDano(danoInimigo);
                    System.out.println(" ");
                    System.out.println("Pressione Enter para continuar...");
                    scanf.nextLine();
                } else {
                    System.out.println(inimigo.getNome() + " foi derrotado!");
                    System.out.println("+ --------------------------------------------------- +");
                    System.out.println("Pressione Enter para continuar...");
                    scanf.nextLine();
                }} else if (escolhaBatalha == 2) {
                    clear();
                    personagem.recuperar();
                    System.out.println(personagem.getNome() + " enquanto se recupera, " + inimigo.getNome() + " ataca!");
                    System.out.println(" ");
                    if (inimigo.inimigoestaVivo()) {
                        int danoInimigo = inimigo.inimigocalcularDano(personagem);
                        System.out.println(inimigo.getNome() + " ataca " + personagem.getNome() + " causando [" + danoInimigo + "] de dano!");
                        personagem.receberDano(danoInimigo);
                    }
                    System.out.println("Pressione Enter para continuar...");
                    scanf.nextLine();
                }else if (escolhaBatalha == 3) {
                    clear();
                    Inventario inventario = new Inventario();
                    inventario.adicionarItens();
                    inventario.exibirInventario();
                    inventario.removerItem();
                    System.out.println("Pressione Enter para continuar...");
                    scanf.nextLine();
                } else if (escolhaBatalha == 4) {
                    System.out.println(personagem.getNome() + " fugiu do combate.");
                    break;
                } else {System.out.println("Opção inválida. Tente novamente.");}
                    if (!personagem.estaVivo()) {
                    System.out.println(personagem.getNome() + " foi derrotado!");
                    System.out.println("+ --------------------------------------------------- +");
                    System.out.println("Pressione Enter para continuar...");
                    scanf.nextLine();
            }
        }
    }
}
