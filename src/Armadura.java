import java.util.Random;

class Armadura extends Itens {
    private String nome;

    public Armadura(String nome, int resistencia, int stamina) {
        this.nome = nome;
        this.resistencia = resistencia;
        this.stamina = stamina;
    }

    public Armadura() {
    }

    @Override
    public String toString() {
        return "Armadura: " + nome +
                ", Resistência: " + resistencia +
                ", Stamina Concedida: " + stamina;
    }

    public String getNome() { return nome; }
}

class GeradorArmadurasComuns {
    private Random random = new Random();
    Armadura armaduras = new Armadura();

    public Armadura gerarArmadurasComuns() {

        for (int i = 0; i < 1; i++) {
            String nome = "Armadura Comum";
            int resistencia = random.nextInt(3) + 1;
            int stamina = random.nextInt(1) + 1;

            armaduras = new Armadura(nome, resistencia, stamina);
        }
        return armaduras;
    }
}