import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {

    private static Random random;
    public static void main(String[] args) {
        System.out.println("У вас є 5 життів.");
        List words = List.of("адміністрація","факультет","годиннник","яблуко","картина","стілець","університет");
        random = new Random();
        int choice = 1;
        while(choice==1){
            StringBuilder word = new StringBuilder();
            word.append(words.get(random.nextInt(words.size())));
            HangmanGame(word);
            Scanner input = new Scanner(System.in);
            System.out.println("Введіть 1, щоб повторити, введіть 0: ");
            choice=input.nextInt();
            while(choice!=1&&choice!=0){
                choice=input.nextInt();
            }

        }



    }
    private static void HangmanGame(StringBuilder word) {
        boolean victory=false;
        boolean stopGame=true;
        int life=5;
        StringBuilder newWord= new StringBuilder("");
        newWord.append(word.charAt(0));
        for(int i=0; i<word.length()-2;i++){
            newWord.append('_');
        }
        newWord.append(word.charAt(word.length() - 1));
        System.out.println(newWord);
        while (stopGame){
            Scanner input = new Scanner(System.in);
            System.out.println("Введіть букву: ");
            char n =input.nextLine().charAt(0);
            for (int i = 0; i <word.length() ; i++) {
                if(n==word.charAt(i)){
                    newWord.setCharAt(i,n);
                    victory=true;
                }
            }
            if(!victory)life--;
            System.out.println("Кількість життів, що залишилась: "+ life);
            System.out.println(newWord);
            victory=false;

            if(newWord.compareTo(word) == 0){

                System.out.println("Ви виграли!");
                stopGame=false;
            }
            if (life==0){
                System.out.println("Ви програли!");
                System.out.println("Правильне слово: " +word);
                stopGame=false;
            }

        }

    }

}