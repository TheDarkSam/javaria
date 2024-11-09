import PersonagensEClasses.Personagem;

import java.util.Random;

public class Inimigos {
    private String nome;
    private int dano;
    private int vida;


    public void inimigoreceberDano(int dano) {
        this.vida -= dano;
        if (this.vida < 0) {
            this.vida = 0;
        }
        System.out.println(this.nome + " recebeu [" + dano + "] de dano e ficou com [" + this.vida + "] de vida.");
        System.out.println(" ");

        if (this.vida <= 0) {
            this.vida = 0;
            System.out.println(this.nome + " morreu.");
            System.out.println("+ --------------------------------------------------- +");
        }
    }

    public int inimigocalcularDano(Personagem personagem){
        Random random = new Random();
        int danoBase = this.dano;
        int variacao = random.nextInt(6) - 2; // Variação de dano entre -2 e +3
        return Math.max(0, danoBase + variacao); // Garante que o dano não seja negativo
    }


    public boolean inimigoestaVivo() {
        return this.vida > 0;
    }

    // BUILDER PARA INIMIGOS.
    private Inimigos(InimigoBuilder builder) {
        this.nome = builder.nome;
        this.dano = builder.dano;
        this.vida = builder.vida;
    }

    public String getNome() {return nome;}

    public int getDano() {return dano;}

    public int getVida() {return vida;}

    @Override
    public String toString() {
        return "Inimigo: " +
                "| Nome: " + nome +
                " | Vida: " + vida +
                " | Dano: " + dano +
                ' ';
    }

    public static class InimigoBuilder {
        private String nome;
        private int dano;
        private int vida;

        public InimigoBuilder setNome(String nome) {this.nome = nome;
            return this;
        }

        public InimigoBuilder setDano(int dano) {this.dano = dano;
            return this;
        }

        public InimigoBuilder setVida(int vida) {this.vida = vida;
            return this;
        }

        public Inimigos build() {
            return new Inimigos(this);
        }
    }
}
