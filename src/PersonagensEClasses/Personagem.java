package PersonagensEClasses;

import java.util.Random;
import java.util.Scanner;

public abstract class Personagem {
    String nome;
    int vida;
    int stamina;
    int dano;
    int mana;
    int staminaMax;
    int vidaMax;
    int manaMax;

    Scanner scanf = new Scanner(System.in);

    public static void clear() {
        System.out.println("\n".repeat(50));
    }

    public Personagem(String nome, int vida, int stamina, int dano, int staminaMax, int vidaMax) {
        this.nome = nome;
        this.vida = vida;
        this.stamina = stamina;
        this.dano = dano;
        this.staminaMax = staminaMax;
        this.vidaMax = vidaMax;
    }

    public Personagem(int vida, String nome, int mana, int dano, int manaMax, int vidaMax) {
        this.vida = vida;
        this.nome = nome;
        this.mana = mana;
        this.dano = dano;
        this.manaMax = manaMax;
        this.vidaMax = vidaMax;
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
            System.out.println(mago.nome + " está tentando recuperar mana...");

            // Verifica se a mana está no máximo
            if (mago.mana >= Mago.manaMax) {
                System.out.println(mago.nome + " já está com a mana no máximo! Não pode ser recuperada.");
            } else {
                // Recupera a mana, garantindo que não ultrapasse o limite
                mago.mana += 5;
                if (mago.mana > Mago.manaMax) { // Garante que a mana não ultrapasse o máximo
                    mago.mana = Mago.manaMax;
                }
                System.out.println(mago.nome + " agora tem [" + mago.mana + "] de mana.");
            }

        } else if (this instanceof Guerreiro) {
            Guerreiro guerreiro = (Guerreiro) this;
            System.out.println(guerreiro.nome + " está tentando recuperar stamina...");

            // Verifica se a stamina está no máximo
            if (guerreiro.stamina >= Guerreiro.staminaMax) {
                System.out.println(guerreiro.nome + " já está com a stamina no máximo! Não pode ser recuperada.");
            } else {
                // Recupera a stamina
                guerreiro.stamina += 5;
                if (guerreiro.stamina > Guerreiro.staminaMax) { // Garante que a stamina não ultrapasse o máximo
                    guerreiro.stamina = Guerreiro.staminaMax;
                }
                System.out.println(guerreiro.nome + " agora tem [" + guerreiro.stamina + "] de stamina.");
            }

        } else if (this instanceof Tanker) {
            Tanker tanker = (Tanker) this;
            System.out.println(tanker.nome + " está tentando recuperar stamina...");

            // Verifica se a stamina está no máximo
            if (tanker.stamina >= Tanker.staminaMax) {
                System.out.println(tanker.nome + " já está com a stamina no máximo! Não pode ser recuperada.");
            } else {
                // Recupera a stamina
                tanker.stamina += 5;
                if (tanker.stamina > Tanker.staminaMax) { // Garante que a stamina não ultrapasse o máximo
                    tanker.stamina = Tanker.staminaMax;
                }
                System.out.println(tanker.nome + " agora tem [" + tanker.stamina + "] de stamina.");
            }
        }

        System.out.println("+ --------------------------------------------------- +");
    }
}