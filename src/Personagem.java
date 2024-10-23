import java.util.Random;

public abstract class Personagem {
    String nome;
    int vida;
    int stamina;
    int dano;

    public Personagem(String nome, int vida, int stamina, int dano) {
        this.nome = nome;
        this.vida = vida;
        this.stamina = stamina;
        this.dano = dano;
    }

    public Personagem(String nome, int vida, int stamina) {
        this.nome = nome;
        this.vida = vida;
        this.stamina = stamina;
    }

    protected String getNome() {
        return nome;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getStamina() {
        return stamina;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    public boolean estaVivo() {
        return this.vida > 0;
    }

    public abstract void atacar(Inimigos Inimigos);

    public void receberDano(int dano) {
        this.vida -= dano;
        System.out.println(this.nome + " recebeu [" + this.dano + "] de dano e ficou com [" + this.vida + "] de vida.");
        System.out.println("+ --------------------------------------------------- +");
        if (this.vida <= 0) {
            System.out.println(this.nome + " morreu.");
            System.out.println("+ --------------------------------------------------- +");
        }
    }


    public int calcularDano(Inimigos inimigo) {
        Random random = new Random();
        int danoBase = this.dano;
        int variacao = random.nextInt(6) - 2; // Variação de dano entre -2 e +3.
        return Math.max(0, danoBase + variacao); // Garante que o dano não seja negativo.
    }
}