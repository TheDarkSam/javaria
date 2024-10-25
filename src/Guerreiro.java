public class Guerreiro extends Personagem {

    public static final int staminaMax = 20;

    public Guerreiro(String nome, int vida, int stamina, int dano) {super(nome, vida, stamina, dano);}

    @Override
    public void atacar(Inimigos inimigo) {
        if (stamina >= 5) {  // VALOR DE CONSUMO DE STAMINA.
            int dano = calcularDano(inimigo);
            System.out.println("+ --------------------------------------------------- +");
            System.out.println(this.nome + " ataca o " + inimigo.getNome() + " causando [" + dano + "] de dano!");
            inimigo.inimigoreceberDano(dano);
            stamina -= 5;
            System.out.println(this.nome + " agora tem [" + this.stamina + "] de stamina.");
            System.out.println("+ --------------------------------------------------- +");
        } else {
            System.out.println("+ --------------------------------------------------- +");
            System.out.println(this.nome + " não tem stamina suficiente para atacar!");
            System.out.println("+ --------------------------------------------------- +");
        }
    }
}
