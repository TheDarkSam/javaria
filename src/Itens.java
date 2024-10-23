public class Itens {

    int resistencia;
    int custoMana;
    int dano;
    int stamina;
    int mana;

    public void atributos(int resistencia, int custoMana, int dano, int stamina, int mana){
        this.resistencia = resistencia;
        this.custoMana = custoMana;
        this.dano = dano;
        this.stamina = stamina;
        this.mana = mana;
    }

    public int getDano() {
        return dano;
    }

    public int getResistencia() {
        return resistencia;
    }

    public int getStamina() {
        return stamina;
    }

    public int getcustoMana() {
        return custoMana;
    }

    public int getMana() {
        return custoMana;
    }


    @Override
        public String toString() {
            return "Itens {" +
                    ", Dano=" + dano +
                    ", Resistência=" + resistencia +
                    ", Mana Extra=" + custoMana +
                    ", Stamina=" + stamina +
                    ", Mana=" + mana +
                    ", " + super.toString();
        }
    }