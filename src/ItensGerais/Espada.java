package ItensGerais;

import java.util.Random;

class Espada extends Itens {
    private String nome;
    private int dano;
    private int custoStamina;

    public Espada(String nome, int dano, int custoStamina) {
        this.nome = nome;
        this.dano = dano;
        this.custoStamina = custoStamina;
    }

    @Override
    public String toString() {
        return " ItensGerais.Espada: " + nome +
                "\n Dano: " + dano +
                "\n Custo de Stamina: " + custoStamina;
    }

    public String getNome() {
        return nome;
    }
}

    class GeradorEspadasComuns {
        private Random random = new Random();

        public Espada gerarEspadasComuns() {
            String nome = "ItensGerais.Espada Comum";
            int dano = random.nextInt(3) + 1;
            int custoStamina = random.nextInt(2) + 1;
            return new Espada(nome, dano, custoStamina);
        }
    }