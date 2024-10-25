import java.util.Random;

public class Mago extends Personagem {
    int mana;
    private int manaMax = 20;

    public Mago(String nome, int vida, int mana, int dano) {super(nome, vida, dano);
        this.mana = mana;
    }

    @Override
    public void atacar(Inimigos inimigo) {
        if (mana >= 5) {  // VALOR DE CONSUMO DE MANA.
            int dano = calcularDano(inimigo);
            System.out.println("+ --------------------------------------------------- +");
            System.out.println(this.nome + " ataca o " + inimigo.getNome() + " causando [" + dano + "] de dano!");
            inimigo.inimigoreceberDano(dano);
            mana -= 5;
            System.out.println(this.nome + " agora tem [" + this.mana + "] de mana.");
            System.out.println("+ --------------------------------------------------- +");
        } else {
            System.out.println("+ --------------------------------------------------- +");
            System.out.println(this.nome + " não tem mana suficiente para lançar um feitiço!");
            System.out.println("+ --------------------------------------------------- +");
        }
    }

    @Override
    public int calcularDano(Inimigos inimigo) {
        Random random = new Random();
        int variacao = random.nextInt(6) - 2;
        return Math.max(0, (this.mana / 5) + this.dano + variacao); // Mais Dano quanto mais Mana.
    }
}

