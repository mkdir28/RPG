public class Monster extends Character{
    int EXPToGive;

    //the monster is not an ally
    public boolean isAlly(){
        return false;
    }

    public Monster(int EXPToGive) {
        this.EXPToGive = EXPToGive;
    }

    public int getEXPToGive() {
        return EXPToGive;
    }

    public void setEXPToGive(int EXPToGive) {
        this.EXPToGive = EXPToGive;
    }

    public Monster() {
        super();
        this.EXPToGive = 5;
    }
    public Monster(int hp, int stamina, int mana, int xp, Item item, int EXPToGive) {
        super();
        this.EXPToGive = EXPToGive;
    }
    public void printCharacter() {
        System.out.println("HP (with Item): " + item.getHP() + (int)getItem().getHP());
        System.out.println("Mana (with Item): " + mana + (int)getItem().getMana());
        System.out.println("Stamina (with Item): " + stamina + (int)getItem().getStamina());
        System.out.println("XP to give: " + EXPToGive);
        item.printItem();
    }
}
