import java.util.Random;

class Manto extends Itens {
    private String nome;
    private int resistencia;
    private int addMana;

    public Manto(String nome, int resistencia, int addMana) {
        this.nome = nome;
        this.resistencia = resistencia;
        this.addMana = addMana;
    }

    @Override
    public String toString() {
        return " Manto: " + nome +
                "\n Resistência: " + resistencia +
                "\n Mana Concedida: " + addMana;
    }

    public String getNome() { return nome; }
}

class GeradorMantosComuns {
    private Random random = new Random();

    public Manto gerarMantosComuns() {
        String nome = "Manto Comum";
        int resistencia = random.nextInt(2) + 1;
        int addMana = random.nextInt(2) + 1;
        return new Manto(nome, resistencia, addMana);
    }
}