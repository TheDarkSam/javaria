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
        return " Espada: " + nome +
                "\n Dano: " + dano +
                "\n Custo de Stamina: " + custoStamina;
    }

    public String getNome() {
        return nome;
    }
}