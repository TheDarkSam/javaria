import java.util.Random;

class Espada extends Itens {
    private String nome;

    public Espada(String nome, int dano, int stamina) {
        this.nome = nome;
        this.dano = dano;
        this.stamina = stamina;
    }

    public Espada() {
    }

    @Override
    public String toString() {
        return "Espada: " + nome +
                ", Dano: " + dano +
                ", Custo Stamina: " + stamina;
    }

    public String getNome() {
        return nome;
    }
}


class GeradorEspadasComuns {
    private Random random = new Random();
    Espada espadas = new Espada();

    public Espada gerarEspadasComuns() {

        for (int i = 0; i < 1; i++) {
            String nome = "Espada Comum";
            int dano = random.nextInt(10) + 1;
            int stamina = random.nextInt(5) + 5;

            espadas = new Espada(nome, dano, stamina);
        }
        return espadas;
    }
}