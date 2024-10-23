public class Mago extends Personagem {
    int mana;

    public Mago(String nome, int vida, int stamina, int mana) {super(nome, vida, stamina);
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
            System.out.println(this.nome + " não tem mana suficiente para lançar um feitiço!");
            System.out.println("+ --------------------------------------------------- +");
        }
    }
}

