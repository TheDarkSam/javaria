import java.util.Random;

class Cajado extends Itens {
    private String nome;

    public Cajado(String nome, int dano, int custoMana) {
        this.nome = nome;
        this.dano = dano;
        this.custoMana = custoMana;
    }

    public Cajado() {}

    @Override
    public String toString() {
        return " Cajado: " + nome +
                "\n Dano: " + dano +
                "\n Custo Mana: " + custoMana;
    }

    public String getNome() { return nome; }
}

class GeradorCajadosComuns {
    private Random random = new Random();

    public Cajado gerarCajadosComuns() {
        String nome = "Cajado Comum";
        int dano = random.nextInt(3) + 1;
        int custoMana = random.nextInt(2) + 1;
        return new Cajado(nome, dano, custoMana);
    }
}