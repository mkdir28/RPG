import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to a RGP game!");
        Character yourAttributes = Character.createAtribute();
        System.out.println("Your stats: ");
        yourAttributes.printCharacter();
        Status Status  = new Status();

        for (int i=0; i<Status.getStatus().length; i++) {
            System.out.println(" ");
            if(!Status.getStatus()[i].isAlly()) {
                System.out.println("Monster stats:");
                Status.getStatus()[i].printCharacter();
                System.out.println(" ");
                if(Status.getisAlly()!=null) {
                    System.out.println("Do you want to call your allied for a fight? If yes: type 1, if no: type 0");
                    int choose;
                    Scanner src = new Scanner(System.in);
                    choose=src.nextInt();
                    if (choose ==1) {
                        Status.getisAlly().attakDefeated((Monster) Status.getStatus()[i]);
                        Status.setisAlly(null);
                        System.out.println("Your stats:");
                        yourAttributes.printCharacter();
                        continue;
                    }
                }
                if(!yourAttributes.attakDefeated((Monster) Status.getStatus()[i])) {
                    System.out.println("You died!");
                    return;
                }
            } else {
                System.out.println("Congrats! You have an ally!");
                Status.setisAlly(Status.getStatus()[i]);
                System.out.println("His stats:");
                Status.getisAlly().printCharacter();
                System.out.println("Press to continue");
                Scanner src = new Scanner(System.in);
                src.nextLine();
            }

        System.out.println();
            System.out.println("Your status:");
            System.out.println();
            if (yourAttributes.getXP()>=5) {
                yourAttributes.increaseXP();
                yourAttributes.printCharacter();
            }
    }
}
}