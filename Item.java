
class Item{
     double HP;
     double Mana;
     double Stamina;

    public Item(double HP, double Mana, double Stamina){
        this.HP = HP;
        this.Mana = Mana;
        this.Stamina = Stamina;
    }

    public Item(){
        this.HP = 0.0;
        this.Mana = 0.0;
        this.Stamina = 0.0;
    }

    public double getHP(){
        return HP;
    }

    public double getMana(){
        return Mana;
    }

    public double getStamina(){
        return Stamina;
    }

    public void setHP(double HP){
        this.HP = HP;
    }

    public void setMana(double Mana){
        this.Mana = Mana;
    }

    public void setStamina(double Stamina){
        this.Stamina = Stamina;
    }

    public void printItem(){
        System.out.println("HR increase: " + HP);
        System.out.println("Mana increase: " + Mana);
        System.out.println("Stamina increase: " + Stamina);
    }
}