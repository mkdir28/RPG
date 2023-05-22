
import java.util.Scanner;

public class Character {
    int magic;
    Item item;
    int mana;
    int stamina;
    int hp;
    int XP;

    public Character(int hp, int mana, int stamina, int magic, Item item, int XP){
        this.hp = hp;
        this.mana = mana;
        this.magic = magic;
        this.stamina = stamina;
        this.XP = XP;
    }

    public Character(){
        magic = 5;
        mana = 5;
        stamina = 5;
        hp = 5;
        item = new Item(hp, mana, stamina);
        XP=0;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item){
        this.item = item;
    }

    public int getmagic(){
        return magic;
    }

    public void setmagic(int magic){
        this.magic = magic;
    }

    public int getmana(){
        return mana;
    }

    public void setmana(int mana){
        this.mana = mana;
    }

    public int getstamina(){
        return stamina;
    }

    public void setstamina(int stamina){
        this.stamina = stamina;
    }

    public int gethp(){
        return hp;
    }

    public void sethp(int hp){
        this.hp = hp;
    }

    public boolean isAlly(){
        return true;
    }

    public int getXP() {
        return XP;
    }

    public void setXP(int XP){
        this.XP = XP;
    }

    public boolean attakDefeated(Monster attack){
        System.out.println("Choose type of attack: ");
        Scanner src = new Scanner(System.in);
        System.out.println("Do you want 1. Physical attack or 2. Magic?");

        int choose = src.nextInt();

        if(choose == 1){
            System.out.println("You choose physical attack!");
            double physAttack = (attack.getstamina() + attack.getItem().getStamina() * 
            (double)attack.getstamina()/this.getstamina());
            double youAttack = (attack.getstamina() + attack.getItem().getStamina() * 
            (double)attack.getstamina() + this.getstamina());

            attack.sethp((int)(attack.gethp()-youAttack));
            this.sethp((int)(this.gethp()-physAttack));

            if (this.gethp()+this.getItem().getHP()<=0) {
                return false;
            } else if(this.gethp()+attack.getItem().getHP()<=0){
                System.out.println("You kill the monster!");
                System.out.println("Congratulation!!!!");
                this.setXP(this.getXP()+attack.getEXPToGive());
                this.setstamina(this.getstamina()-1);
                System.out.println("Will you take a monster Item?");
                System.out.println("1. - Yes" + "\n" + "0. - No");
                choose = src.nextInt();

                if(choose == 1) this.setItem(attack.getItem());
                return true;
            } else 
                return this.attakDefeated(attack);
            
        } else if(choose == 2){
            System.out.println("You choose magic attack!");
            double magicAttack = (attack.getmana() + attack.getItem().getMana() * (double)attack.getmana()/this.getmana());
            double youAttack = (attack.getmana() + attack.getItem().getMana() * (double)attack.getmana() + this.getmana());

            attack.sethp((int)(attack.gethp() - youAttack));
            this.sethp((int)(this.gethp() - magicAttack));

            if (this.gethp()+this.getItem().getHP()<=0) {
                return false;
            }else if(this.gethp()+attack.getItem().getHP()<=0){
                System.out.println("You kill the monster!");
                System.out.println("Congratulation!!!!");
                this.setXP(this.getXP()+attack.getEXPToGive());
                this.setmana(this.getmana()-1);
                System.out.println("Will you take a monster Item?");
                System.out.println("1. - Yes" + "\n" + "0. - No");
                choose = src.nextInt();

                if(choose == 1) this.setItem(attack.getItem());
                return true;

        }  else 
            System.out.println("Monster didn't die, try again");
            return this.attakDefeated(attack);
        
    }else {
        System.out.println("Error!" + "\n" + "Try again: ");
        return false;
    }
}

public void increaseXP(){
    System.out.println("WOW! You have enough exp to go further");
    System.out.println("If you want to ugrade your items." + "\n" + " 1. - Stamina" + "\n" + "2. - Mana"
    + "\n" + "3. - Hp");
    Scanner src = new Scanner(System.in);
    int choose = src.nextInt();

    switch(choose) {
        case 1:
            this.sethp(this.gethp()+5);
            break;
        case 2:
            this.setstamina(this.getstamina()+5);
            break;
        case 3:
            this.setmana(this.getmana()+5);
            break;
        default:
            this.sethp(this.gethp()+5);
    }
    this.setXP(this.getXP()-5);

}
    public void printCharacter(){
        System.out.println("HP (with Item): " + item.getHP() + (int)getItem().getHP());
        System.out.println("Mana (with Item): " + mana + (int)getItem().getMana());
        System.out.println("Stamina (with Item): " + stamina + (int)getItem().getStamina());
        System.out.println("Your XP: " + XP);
        item.printItem();
    }

    static Character createAtribute() {
        Character attribute = new Character();
        Scanner src = new Scanner(System.in);
        System.out.println("You have charcters: Hp; Mana; Stamina" + "\n" +
        "Lets choose your character!" );
        System.out.println("You have 15 points to give:");
        int hp=5,mana=5,stamina=5;
        System.out.println("How many points you want to give to HP?");
        hp = src.nextInt();
        if (hp<15 && hp>0) {
            attribute.sethp(hp);
            System.out.println("You have " + (15 - hp) + " points to give for another atribute:");
            System.out.println("How many points you want to give to Stamina?");
            stamina = src.nextInt();
            if (stamina>0 && hp+stamina<15) {
                attribute.setstamina(stamina);
                attribute.setmana(15-hp-stamina);
            }
            if (mana>0 && hp+stamina+mana<15) {
                attribute.setstamina(stamina);
                attribute.setmana(15-hp-stamina);
            System.out.println("You have " + (15 - hp - stamina) + " points you want to give to Mana");
            }
        }
        return attribute;
    }

    static Item chooseItem(){
        Item chosenItem = new Item();
        System.out.println("Choose your first item!");
        System.out.println("This is a list of available items:");
        System.out.println(chosenItem);
        System.out.println("Type the number of an item you want to choose:");
        System.out.println();
        Scanner src = new Scanner(System.in);
        int choose=1;
        choose=src.nextInt();
        if (choose>0 && choose<4) System.out.println(" ");;
        return chosenItem;
    }
}
