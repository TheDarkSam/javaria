import java.util.Random;

class Cajado extends Itens {
    private String nome;

    public Cajado(String nome, int dano, int custoMana) {
        this.nome = nome;
        this.dano = dano;
        this.custoMana = custoMana;
    }

    public Cajado() {
    }

    @Override
    public String toString() {
        return "Cajado: " + nome +
                ", Dano: " + dano +
                ", Custo Mana: " + custoMana;
    }

    public String getNome() { return nome; }
}

class GeradorCajadosComuns {
    private Random random = new Random();
    Cajado cajados = new Cajado();

    public Cajado gerarCajadosComuns() {

        for (int i = 0; i < 1; i++) {
            String nome = "Cajado Comum";
            int dano = random.nextInt(10) + 1;
            int custoMana = random.nextInt(5) + 5;

            cajados = new Cajado(nome, dano, custoMana);
        }
        return cajados;
    }
}