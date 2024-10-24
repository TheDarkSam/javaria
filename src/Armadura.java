import java.util.Random;

class Armadura extends Itens {
    private String nome;
    private int resistencia;
    private int stamina;

    public Armadura(String nome, int resistencia, int stamina) {
        this.nome = nome;
        this.resistencia = resistencia;
        this.stamina = stamina;
    }

    @Override
    public String toString() {
        return " Armadura: " + nome +
                "\n Resistência: " + resistencia +
                "\n Stamina Concedida: " + stamina;
    }

    public String getNome() { return nome; }
}

class GeradorArmadurasComuns {
    private Random random = new Random();

    public Armadura gerarArmadurasComuns() {
        String nome = "Armadura Comum";
        int resistencia = random.nextInt(3) + 1;
        int stamina = random.nextInt(2) + 1;
        return new Armadura(nome, resistencia, stamina);
    }
}