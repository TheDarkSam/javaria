import java.util.Random;

class Manto extends Itens {
    private String nome;

    public Manto(String nome, int resistencia, int mana) {
        this.nome = nome;
        this.resistencia = resistencia;
        this.mana = mana;
    }

    public Manto() {
    }

    @Override
    public String toString() {
        return "Manto: " + nome +
                ", Resistência: " + resistencia +
                ", Mana Concedida: " + mana;
    }

    public String getNome() { return nome; }
}

class GeradorMantosComuns {
    private Random random = new Random();
    Manto mantos = new Manto();

    public Manto gerarMantosComuns() {

        for (int i = 0; i < 1; i++) {
            String nome = "Manto Comum";
            int resistencia = random.nextInt(2) + 1;
            int mana = random.nextInt(1) + 1;

            mantos = new Manto(nome, resistencia, mana);
        }
        return mantos;
    }
}