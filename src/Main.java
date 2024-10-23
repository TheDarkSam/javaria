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
        GeradorEspadasComuns geradorEspadasComuns = new GeradorEspadasComuns();
        Espada espadaComum = geradorEspadasComuns.gerarEspadasComuns();

        // Gerações de CAJADO.
        GeradorCajadosComuns geradorCajadosComuns = new GeradorCajadosComuns();
        Cajado cajadoComum = geradorCajadosComuns.gerarCajadosComuns();

        // Gerações de ARMADURA.
        GeradorArmadurasComuns geradorArmadurasComuns = new GeradorArmadurasComuns();
        Armadura armaduraComum = geradorArmadurasComuns.gerarArmadurasComuns();

        // Gerações de MANTOS.
        GeradorMantosComuns geradorMantosComuns = new GeradorMantosComuns();
        Manto mantoComum = geradorMantosComuns.gerarMantosComuns();

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
            System.out.println("1 - Tanker | 20 HP | 15 Sta | 5 Dano");
            System.out.println("2 - Guerreiro | 15 HP | 20 Sta | 10 Dano");
            System.out.println("3 - Mago | 10HP | 10 Sta | 20 Man");
            System.out.println(" ");
            System.out.println("+ ---------------------------------------- +");
            System.out.println(" ");
            System.out.print("Digite sua escolha: ");
            int escolha = scanf.nextInt();
            scanf.nextLine();

            switch (escolha) {
                case 1:
                    clear();
                    personagem = new Tanker(nome, 20, 15, 5);
                    System.out.println("+ ---------------------------------------- +");
                    System.out.println("      " + nome + " escolheu a classe Tanker!");
                    System.out.println("+ ---------------------------------------- +");
                    System.out.println("Você ganhou a espada: " + espadaComum.getNome());
                    System.out.println("Dano: " + espadaComum.getDano());
                    System.out.println("Custo de Stamina: " + espadaComum.getStamina());
                    System.out.println("+ ---------------------------------------- +");
                    System.out.println("Você ganhou a armadura: " + armaduraComum.getNome());
                    System.out.println("Resistência: " + armaduraComum.getResistencia());
                    System.out.println("Ganho de Stamina: " + armaduraComum.getStamina());
                    System.out.println("+ ---------------------------------------- +");
                    imprimirDevagar("............................................", 75);
                    classeEscolhida = true;
                    break;
                case 2:
                    clear();
                    personagem = new Guerreiro(nome, 15, 20, 10);
                    System.out.println("+ ---------------------------------------- +");
                    System.out.println("    " + nome + " escolheu a classe Guerreiro!");
                    System.out.println("+ ---------------------------------------- +");
                    System.out.println("Você ganhou a espada: " + espadaComum.getNome());
                    System.out.println("Dano: " + espadaComum.getDano());
                    System.out.println("Custo de Stamina: " + espadaComum.getStamina());
                    System.out.println("+ ---------------------------------------- +");
                    System.out.println("Você ganhou a armadura: " + armaduraComum.getNome());
                    System.out.println("Resistência: " + armaduraComum.getResistencia());
                    System.out.println("Ganho de Stamina: " + armaduraComum.getStamina());
                    System.out.println("+ ---------------------------------------- +");
                    imprimirDevagar("............................................", 75);
                    classeEscolhida = true;
                    break;
                case 3:
                    clear();
                    personagem = new Mago(nome, 10, 10, 20);
                    System.out.println("+ ---------------------------------------- +");
                    System.out.println("       " + nome + " escolheu a classe Mago!");
                    System.out.println("+ ---------------------------------------- +");
                    System.out.println("Você ganhou o cajado: " + cajadoComum.getNome());
                    System.out.println("Dano: " + cajadoComum.getDano());
                    System.out.println("Custo de Mana: " + cajadoComum.getcustoMana());
                    System.out.println("+ ---------------------------------------- +");
                    System.out.println("Você ganhou o manto: " + mantoComum.getNome());
                    System.out.println("Resistência: " + mantoComum.getResistencia());
                    System.out.println("Ganho de Mana: " + mantoComum.getMana());
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
        // PRONTO PARA INICIAR A BATALHA.
        System.out.println("Pronto para iniciar? (1 - Sim)");
        System.out.println("-> ");
        int escolha2 = scanf.nextInt();

        switch (escolha2) {
            case 1:
                // BATALHA TESTE
                clear();
                System.out.println("+ --------------------------------------------------- +");
                System.out.println("       Seu primeiro inimigo é um " + goblinComum.getNome());
                while (goblinComum.inimigoestaVivo() && personagem.estaVivo()) {
                    System.out.println("+ --------------------------------------------------- +");
                    System.out.println(" ");
                    System.out.println("-> O que " + personagem.getNome() + " deve fazer?");
                    System.out.println(" ");
                    System.out.println("1 - Atacar.");
                    System.out.println("2 - Fugir.");
                    System.out.println("3 - Abrir Inventário.");
                    System.out.println(" ");
                    System.out.println("+ --------------------------------------------------- +");
                    int escolhaBatalha = scanf.nextInt();
                    scanf.nextLine();

                    if (escolhaBatalha == 1) {
                        // PERSONAGEM ATACA O GOBLIN.
                        clear();
                        personagem.atacar(goblinComum);
                        // VERIFICA SE O GOBLIN ESTÁ VIVO APÓS ATAQUE DO PERSONAGEM.
                        if (goblinComum.inimigoestaVivo()) {
                            // GOBLIN CONTRA-ATACA.
                            int danoGoblin = goblinComum.inimigocalcularDano(personagem); // CALCULA O DANO DO GOBLIN.
                            System.out.println(goblinComum.getNome() + " ataca " + personagem.getNome() + " causando [" + danoGoblin + "] de dano!");
                            personagem.receberDano(danoGoblin); // PERSONAGEM RECEBENDO DANO.
                            System.out.println(" ");
                            System.out.println("Pressione Enter para continuar...");
                            scanf.nextLine();
                            clear();
                        } else {
                            System.out.println(goblinComum.getNome() + " foi derrotado!");
                        }

                    } else if (escolhaBatalha == 2) {
                        System.out.println(personagem.getNome() + " fugiu do combate.");
                        break;
                    } else if (escolhaBatalha == 3){
                        inventario.exibirInventario();
                    } else {
                        System.out.println("Opção inválida. Tente novamente.");
                    }

                    // VERIFICA SE O PERSONAGEM ESTÁ VIVO APÓS ATAQUE DO GOBLIN.
                    if (!personagem.estaVivo()) {
                        System.out.println(personagem.getNome() + " foi derrotado!");
                    }
                }
        }
        scanf.close();
    }
}
