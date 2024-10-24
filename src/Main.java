import java.util.Scanner;

public class Main {

    // IMPRESSÃO LENTA DE PRINTS.
    public static void imprimirDevagar(String mensagem, int intervalo) {
        for (char c : mensagem.toCharArray()) {
            System.out.print(c);
            try {
                Thread.sleep(intervalo);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println();
    }

    // CLEAR NO TERMINAL.
    public static void clear() {
        for (int i = 0; i < 100; i++) {
            System.out.println();
        }
    }

    // CÓDIGO PROPRIAMENTE DITO.
    public static void main(String[] args) {
        Scanner scanf = new Scanner(System.in);
        Inventario inventario = new Inventario();

        // Gerações de ESPADA.
        GeradorEspadasComuns gerarEspadaComum = new GeradorEspadasComuns();

        // Gerações de CAJADO.
        GeradorCajadosComuns gerarCajadoComum = new GeradorCajadosComuns();

        // Gerações de ARMADURA.
        GeradorArmadurasComuns gerarArmaduraComum = new GeradorArmadurasComuns();

        // Gerações de MANTOS.
        GeradorMantosComuns gerarMantoComum = new GeradorMantosComuns();

        // INIMIGOS.
        Inimigos goblinComum = new Inimigos.InimigoBuilder()
                .setNome("Goblin Comum")
                .setDano(2)
                .setVida(15)
                .build();

        Inimigos goblinChefe = new Inimigos.InimigoBuilder()
                .setNome("Goblin Rei")
                .setDano(3)
                .setVida(20)
                .build();

        // TELA INICIAL.
        System.out.println("+ ---------------------------------------- +");
        System.out.println("         Olá, qual será seu nome?");
        System.out.println("+ ---------------------------------------- +");
        String nome = scanf.nextLine();

        Personagem personagem = null;
        boolean classeEscolhida = false;

        while (!classeEscolhida) {
            clear();
            System.out.println("+ ---------------------------------------- +");
            System.out.println("            Escolha sua classe:");
            System.out.println("+ ---------------------------------------- +");
            System.out.println(" ");
            System.out.println("1 - Tanker | 30 HP | 15 Sta | 5 Dano");
            System.out.println("2 - Guerreiro | 20 HP | 20 Sta | 15 Dano");
            System.out.println("3 - Mago | 10HP | 25 Mana | 25 Dano");
            System.out.println(" ");
            System.out.println("+ ---------------------------------------- +");
            System.out.println(" ");
            System.out.print("Digite sua escolha: ");
            int escolha = scanf.nextInt();
            scanf.nextLine();

            switch (escolha) {
                case 1:
                    clear();
                    personagem = new Tanker(nome, 30, 15, 5);
                    System.out.println("+ ---------------------------------------- +");
                    System.out.println("      " + nome + " escolheu a classe Tanker!");
                    System.out.println("+ ---------------------------------------- +");
                    System.out.println(gerarEspadaComum.gerarEspadasComuns());
                    System.out.println("+ ---------------------------------------- +");
                    System.out.println(gerarArmaduraComum.gerarArmadurasComuns());
                    System.out.println("+ ---------------------------------------- +");
                    imprimirDevagar("............................................", 75);
                    classeEscolhida = true;
                    break;
                case 2:
                    clear();
                    personagem = new Guerreiro(nome, 20, 20, 15);
                    System.out.println("+ ---------------------------------------- +");
                    System.out.println("    " + nome + " escolheu a classe Guerreiro!");
                    System.out.println("+ ---------------------------------------- +");
                    System.out.println(gerarEspadaComum.gerarEspadasComuns());
                    System.out.println("+ ---------------------------------------- +");
                    System.out.println(gerarArmaduraComum.gerarArmadurasComuns());
                    System.out.println("+ ---------------------------------------- +");
                    imprimirDevagar("............................................", 75);
                    classeEscolhida = true;
                    break;
                case 3:
                    clear();
                    personagem = new Mago(nome, 10, 25, 25);
                    System.out.println("+ ---------------------------------------- +");
                    System.out.println("       " + nome + " escolheu a classe Mago!");
                    System.out.println("+ ---------------------------------------- +");
                    System.out.println(gerarCajadoComum.gerarCajadosComuns());
                    System.out.println("+ ---------------------------------------- +");
                    System.out.println(gerarMantoComum.gerarMantosComuns());
                    System.out.println("+ ---------------------------------------- +");
                    imprimirDevagar("............................................", 75);
                    classeEscolhida = true;
                    break;
                default:
                    System.out.println("Escolha inválida. Por favor, escolha 1, 2 ou 3.");
            }
        }

        // ESCOLHAS DE CLASSE CONCLUÍDAS. RECEBIMENTO DE ITENS INICIAIS.

        clear();
        // COMEÇO DA HISTÓRIA.

/*
        System.out.println("+ ---------------------------------------------------" +
                "-----------------------------------------------------------" +
                "--------------------------------------------------- +");
        System.out.println(" ");
        imprimirDevagar("-> Bem... Essa é uma velha história de um humano," +
                " humano este que trouxe o caos para o mundo.", 1);
        imprimirDevagar(" ", 3000);
        imprimirDevagar("-> Quando era apenas uma criança, tinha uma única paixão," +
                " se tornar um bravo lutador, independentemente de sua força, mas claro," +
                " não se contentaria com pouco.", 1);
        imprimirDevagar(" ", 3000);
        imprimirDevagar("-> Sua história começa devagar, em um pequeno vilarejo, " +
                "este que estava sendo atacado e infestado por perigosos Slimes!", 1);
        System.out.println(" ");
        imprimirDevagar("...", 1500);
        System.out.println(" ");
        imprimirDevagar("-> Tá, talvez não tão perigosos assim, mas independente disto," +
                " vamos ver como a história de um pequeno humano se tornou o" +
                " pesadelo de todos.", 1);
        System.out.println(" ");
        System.out.println("+ ---------------------------------------------------" +
                "-----------------------------------------------------------" +
                "--------------------------------------------------- +");
 */
        System.out.println("Pronto para iniciar? (1 - Sim)");
        System.out.println("-> ");
        int escolha2 = scanf.nextInt();

        switch (escolha2) {
            case 1:
                clear();
                if (escolha2 == 1) {
                    Batalha batalha = new Batalha();
                    batalha.definirPersonagem(personagem);
                    batalha.definirInimigo(goblinComum);
                    batalha.iniciar();
                    batalha.definirPersonagem(personagem);
                    batalha.definirInimigo(goblinChefe);
                    batalha.iniciar();
                } else {
                    System.out.println("Saindo do jogo...");
                }
        }
        scanf.close();
       }
    }
