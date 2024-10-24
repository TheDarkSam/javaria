import java.util.Random;
import java.util.Scanner;

public abstract class Personagem {
    String nome;
    int vida;
    int stamina;
    int dano;

    Scanner scanf = new Scanner(System.in);

    public static void clear() {
        for (int i = 0; i < 100; i++) {
            System.out.println();
        }
    }

    public Personagem(String nome, int vida, int stamina, int dano) {
        this.nome = nome;
        this.vida = vida;
        this.stamina = stamina;
        this.dano = dano;
    }

    public Personagem(String nome, int vida, int dano) {
        this.nome = nome;
        this.vida = vida;
        this.dano = dano;
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
        if (this.vida < 0) {
            this.vida = 0;
        }
        System.out.println(this.nome + " recebeu [" + dano + "] de dano e ficou com [" + this.vida + "] de vida.");
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

    // RECUPERAÇÃO MANA OU STAMINA.
    public void recuperar() {
        clear();
        System.out.println("+ --------------------------------------------------- +");
        if (this instanceof Mago) {
            Mago mago = (Mago) this;
            System.out.println(mago.nome + " está recuperando mana...");
            mago.mana += 5;
            System.out.println(mago.nome + " agora tem [" + mago.mana + "] de mana.");
        } else if (this instanceof Guerreiro) {
            Guerreiro guerreiro = (Guerreiro) this;
            System.out.println(guerreiro.nome + " está recuperando stamina...");
            guerreiro.stamina += 5;
            System.out.println(guerreiro.nome + " agora tem [" + guerreiro.stamina + "] de stamina.");
        } else if (this instanceof Tanker) {
            Tanker tanker = (Tanker) this;
            System.out.println(tanker.nome + " está recuperando stamina...");
            tanker.stamina += 5;
            System.out.println(tanker.nome + " agora tem [" + tanker.stamina + "] de stamina.");
        }
        System.out.println("+ --------------------------------------------------- +");
    }
}
