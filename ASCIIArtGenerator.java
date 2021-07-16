import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * ASCII Art Generator in Java. 
 * Prints a given text as an ASCII text art on the console. 
 * This code is licensed under - CC Attribution CC BY 4.0.
 * @author www.quickprogrammingtips.com
 *
 */
public class ASCIIArtGenerator {
     
    public static final int ART_SIZE_SMALL = 12;
    public static final int ART_SIZE_MEDIUM = 18;
    public static final int ART_SIZE_LARGE = 24;
    public static final int ART_SIZE_HUGE = 32;
    ArrayList<String> points = new ArrayList<>();
    
    static int lives = 2;
    static int totalpoints = 0;
    static String name;
    public static Scanner in;
    public static Random r = new Random();
    
    public ASCIIArtGenerator() {
        in = new Scanner(System.in);
        
    }
    

 
    private static final String DEFAULT_ART_SYMBOL = "*";
 
    public enum ASCIIArtFont {
        ART_FONT_DIALOG("Dialog"), ART_FONT_DIALOG_INPUT("DialogInput"), 
        ART_FONT_MONO("Monospaced"),ART_FONT_SERIF("Serif"), ART_FONT_SANS_SERIF("SansSerif");
 
        private String value;
 
        public String getValue() {
            return value;
        }
 
        private ASCIIArtFont(String value) {
            this.value = value;
        }
    }

    
    
    public static void main(String[] args) throws Exception {
        ASCIIArtGenerator artGen = new ASCIIArtGenerator();
         
        System.out.println();
        artGen.printTextArt("Space Odyssey", ASCIIArtGenerator.ART_SIZE_MEDIUM);
        System.out.println(); 
         
        System.out.println();
        artGen.printTextArt("By The Frederick YMCA!", ASCIIArtGenerator.ART_SIZE_SMALL, ASCIIArtFont.ART_FONT_MONO,"*");
        System.out.println();
        
        totalpoints = 0;
        
        
        System.out.println("What's your name?");
        name = in.nextLine();
        
         TimeUnit.SECONDS.sleep(1);

        System.out.println();
        artGen.printTextArt("Welcome "+name+"!", ASCIIArtGenerator.ART_SIZE_MEDIUM);
        System.out.println();
         TimeUnit.SECONDS.sleep(3);

        
        
        
        //crash lands and needs to rebuild
        //piece 1: moon phases quiz
        //piece 2: town (earth multiple choice)
        //piece 3: volcano (earth mass quiz)
        //piece 3: gravitation quiz or game-show solar system quiz
        //piece 4: boss battle
        //constellations will be fill in the blank
        System.out.println("\n\n");
        System.out.println("We have an emergency situation. You have crash-landed on the planet Jogon, a distant place with similar characteristics to Earth.");
        System.out.println("You must complete various puzzles to find the pieces to rebuild your shuttle");
        System.out.println("You have 3 lives. If you fail the puzzles 3 times you lose and the game automatically ends");
        System.out.println("Finishing the puzzles as quickly as possible ensures you receive the maximum amount of points!");
        System.out.println("\n\n\n\n\n");
        System.out.println();
        artGen.printTextArt("Good Luck!", ASCIIArtGenerator.ART_SIZE_MEDIUM);
        System.out.println();
        
        
        System.out.println("Piece 1!");
        int result1 = moonPhases();
        
        totalpoints+=result1;
        
        System.out.println("You have earned "+totalpoints+" points");
        if(result1==0){
            lives-=1;
        }
        
        
        System.out.println(pointUpdate());
        
        if(!liveCheck()){
            System.out.println("Thanks for playing, see you soon!");
            System.exit(-1);
        }
        System.out.println("\n\n\n");
        System.out.println("Piece 2!");

        int result2 = mass();
        totalpoints+=result2;
        System.out.println("You have earned "+result2+" points");
        
        if(result2==0){
            lives-=1;
        }
        
        
        System.out.println(pointUpdate());
        
        if(!liveCheck()){
            System.out.println("Thanks for playing, see you soon!");
            System.exit(-1);
        }
        
        System.out.println("\n\n\n");
        System.out.println("Piece 3!");

        int result3 = RPS();
        totalpoints+=result3;
        System.out.println("You have earned "+result3+" points");
        
        if(result3==0){
            lives-=1;
        }
        
        
        System.out.println(pointUpdate());
        
        if(!liveCheck()){
            System.out.println("Thanks for playing, see you soon!");
            System.exit(-1);
        }
        System.out.println("\n\n\n");
        
        
        System.out.println("Piece 4!");

        int result4 = gameShow();
        totalpoints+=result4;
        System.out.println("You have earned "+result4+" points");
        
        if(result4==0){
            lives-=1;
        }
        
        
        System.out.println(pointUpdate());
        
        if(!liveCheck()){
            System.out.println("Thanks for playing, see you soon!");
            System.exit(-1);
        }
        System.out.println("\n\n\n");
        
        
         TimeUnit.SECONDS.sleep(2);
         System.out.println("Piece 5:");
         System.out.println("==================================================");
         System.out.println("The king has your remaining piece and you must fight him for it back!");
         System.out.println("==================================================");
        
         System.out.println("Would you like to upgrade your health before the battle for 100 points?");
        
         int playerHealth = 100;
         int strength = 0;
         String quest = in.nextLine();
         if(quest.equals("y")){
             playerHealth = 110;
             System.out.println("Health has increased by 10%\n");
         }
         
         System.out.println("Would you like to upgrade your attack before the battle for 100 points?");
        
         
         quest = in.nextLine();
         if(quest.equals("y")){
             strength = 1;
             System.out.println("Strength has been increased by 10%\n");
         }
        int computerHealth = 100;
        
        int[] moves = {0,10, 20, 30};
        int playerMove;
        int computerMove;
        int hit = 0;
        while(computerHealth>0&&playerHealth>0){
             TimeUnit.SECONDS.sleep(2);
            

            playerMove = r.nextInt(4);
            if(playerMove==0){
                System.out.println("You miss to the side!");
            }
            if(playerMove==1){
                System.out.println("You smack the king's helmet!");
                hit = 10;
            }
            
            if(playerMove==2){
                System.out.println("You slam his side!");
                hit = 20;
            }
            
            if(playerMove==3){
                System.out.println("You stab the king!");
                hit = 30;
            }
            
            computerHealth-=(hit + hit*strength*1.1);
            
            System.out.println("Player Health: "+playerHealth+" King Health "+ computerHealth+"\n");
            
            if(computerHealth<=0){
                break;
            }
            
             TimeUnit.SECONDS.sleep(2);

            computerMove = r.nextInt(4);
            if(playerMove==0){
                System.out.println("King misses to the side!");
            }
            if(playerMove==1){
                System.out.println("King smacks your helmet!");
                hit = 10;
            }
            
            if(playerMove==2){
                System.out.println("King slams your side!");
                hit = 20;
            }
            
            if(playerMove==3){
                System.out.println("King stabs you!");
                hit = 30;
            }
            
            playerHealth-=(hit + hit*strength*1.5);
            System.out.println("Player Health: "+playerHealth+" King Health "+ computerHealth);
            System.out.println();

            
            
            
            
            
            
            
        }
        
        if(playerHealth>computerHealth){
            System.out.println("Congratulations, you win!");
            
        }
        
        else{
            System.out.println("Sorry, you lose and are to stay in exile on the planet!\n\n\n\n");
        }
        
        System.out.println(pointUpdate());
        System.exit(-1);
        


        
         while(true){
             
         }

        
        

        
        
        
        
        
        
        
        
        


        
        

        
         
    }
 
    /**
     * Prints ASCII art for the specified text. For size, you can use predefined sizes or a custom size.
     * Usage - printTextArt("Hi",30,ASCIIArtFont.ART_FONT_SERIF,"@");
     * @param artText
     * @param textHeight - Use a predefined size or a custom type
     * @param fontType - Use one of the available fonts
     * @param artSymbol - Specify the character for printing the ascii art
     * @throws Exception
     */
    
    public static int moonPhases(){
        int incorrect = 0;
        
        
        System.out.println("====================================================================================");

        System.out.println("You have just arrrived at a base where you know a piece of your ship crashed!");
        System.out.println("But there is a combination on the outside testing your knowledge of the moon phases");
        System.out.println("You cannot get more than 2 of the 5 questions wrong to open the combination!");
        System.out.println("====================================================================================");
        
        System.out.println("====================================================================================");

        System.out.println("First question: when the moon is at the phase 'Waning Gibbous' is it less than or more than halfway through the cycle?");
        System.out.println("Answer with 'more' or 'less'");
        String answer1 = in.nextLine();
        if(answer1.substring(0,1).equals("m")){
            System.out.println("That is correct!");
        }
        else{
            System.out.println("Sorry, that is incorrect!");
            incorrect++;
        }
        
        System.out.println("====================================================================================");
        
        System.out.println("Second question: Is Waxing Crescent or Waxing Gibbous the second phase after New Moon?");
        System.out.println("Answer with '1' or '2'");
        int answer2 = in.nextInt();
        if(answer2==1){
            System.out.println("That is correct!");
        }
        
        else{
            System.out.println("Sorry, that is incorrect!");
            incorrect++;
        }
        
        
        System.out.println("====================================================================================");

        System.out.println("What Phase occurs after full moon?");
        in.nextLine();
        String answer3 = in.nextLine();
 
        String[] answers = answer3.split(" ");
        
        
        if(answers[0].substring(0,1).equals("w")&&answers[1].substring(0,1).equals("g")){
            System.out.println("That is correct!");
        }
        
        else{
            System.out.println("Sorry, that is incorrect!");
            incorrect++;
        }
        
        System.out.println("====================================================================================");
        
        
        System.out.println("====================================================================================");

        System.out.println("Fourth question: when the moon is at the phase 'Waxing Crescent' is it less than or more than halfway through the cycle?");
        System.out.println("Answer with 'more' or 'less'");
        answer1 = in.nextLine();
        if(answer1.substring(0,1).equals("l")){
            System.out.println("That is correct!");
        }
        else{
            System.out.println("Sorry, that is incorrect!");
            incorrect++;
        }
        
        System.out.println("====================================================================================");
        
       System.out.println("====================================================================================");

        System.out.println("Last question: is the right or left side of the moon lit up during The First Quarter Phase?");
        System.out.println("Answer with 'right' or 'left'");
        answer1 = in.nextLine();
        if(answer1.substring(0,1).equals("r")){
            System.out.println("That is correct!");
        }
        else{
            System.out.println("Sorry, that is incorrect!");
            incorrect++;
        }
        
        System.out.println("====================================================================================");
        
       if(incorrect<3){
           return (7-incorrect)*10;
               //max of 70 pts
       }
        
        
       
       return 0;
       
        
      
    }
    
    public static int mass(){
        
        int incorrect = 0;
        
        System.out.println("====================================================================================");

        System.out.println("You have just made it to a citadel where the planet's inhabitants reside");
        System.out.println("They have the second piece of your ship! But will only trade it for information about Earth...");
        System.out.println("You can be off by 25% but no more in your answers and need to get at least 2 right!");
        System.out.println("====================================================================================");
        
        
        System.out.println("====================================================================================");

        System.out.println("First question: Does Earth follow a circular or elliptical (more oval) orbit around the sun?");
        System.out.println("Answer with 'circular' or 'eliptical'");
        String answer1 = in.nextLine();
        if(answer1.substring(0,1).equals("e")){
            System.out.println("That is correct!");
        }
        else{
            System.out.println("Sorry, that is incorrect!");
            incorrect++;
        }
        
        System.out.println("====================================================================================");
        
        System.out.println("====================================================================================");

        System.out.println("Second question: What is the Ozone Hole?");
        System.out.println("A. A hole in the Ozone Layer that makes us more vulnerable to UV Light (dangerous for skin)");
        System.out.println("B. A massive hole dug under an international agreement to search for oil reserves");

        answer1 = in.nextLine();
        if(answer1.substring(0,1).equals("a")){
            System.out.println("That is correct!");
        }
        else{
            System.out.println("Sorry, that is incorrect!");
            incorrect++;
        }
        
        System.out.println("====================================================================================");
        
        
        System.out.println("====================================================================================");

        System.out.println("Third question: Which exerts a stronger gravitational pull on an object: The Earth or The Moon?");
        System.out.println("Answer with 'earth' or 'moon'");
        answer1 = in.nextLine();
        if(answer1.substring(0,1).equals("e")){
            System.out.println("That is correct!");
        }
        else{
            System.out.println("Sorry, that is incorrect!");
            incorrect++;
        }
        
        System.out.println("====================================================================================");
        
        if(incorrect<2){
            return 50+20*(1-incorrect);
        }
        
        return 0;
        
    }
    
    
    public static int RPS() throws Exception{
        System.out.println("Now is your turn to face a grandmaster in a game of Rock Paper Scissor Shoot!");
        System.out.println("Defeat them and you will win your third piece!");
        boolean playing = true;
        String[] moves = {"rock","paper","scissors"};
        int count = 0;
        int player;

        while(playing){
            
            TimeUnit.SECONDS.sleep(1);

            System.out.println("What is your choice?!");
            String answer1 = in.nextLine();
            
            if(answer1.substring(0,1).equals("r")){
                System.out.println("Player chose rock!\n");
                player = 0;
            }
            
            else if(answer1.substring(0,1).equals("p")){
                System.out.println("Player chose paper!\n");
                player = 1;

            }
            
            else{
                System.out.println("Player chose scissors!\n");
                player = 2;
            }
            
            TimeUnit.SECONDS.sleep(1);

            int computer = r.nextInt(3);
            System.out.println("Grandmaster chooses "+moves[computer]);
            
            if(computer==player){
                System.out.println("Tie! Try Again!\n");
                count++;
                continue;
            }
            
            else if(computer==0 && player == 1){
                System.out.println("Player wins!");
                return 70-(10*count);
            }
            
            else if(computer==0 && player == 2){
                System.out.println("Grandmaster wins! Try Again!\n");
                count++;
                continue;
            }
            
            else if(computer==1 && player == 0){
                System.out.println("Grandmaster wins! Try Again!\n");
                count++;
                continue;
            }
            
            else if(computer==1 && player == 2){
                System.out.println("Player wins!\n");
                return 70-(10*count);
            }
            
            else if(computer==2 && player == 0){
                System.out.println("Player wins!\n");
                return 70-(10*count);
            }
            
            else if(computer==2 && player == 1){
                System.out.println("Grandmaster wins! Try Again!\n");
                count++;
                continue;
            }
            
            TimeUnit.SECONDS.sleep(1);


            
            
        
 
            
            
            

            
            
            
            
        }
        
        return 0;
            
            
        
        
        
        
    }
    
    public static int gameShow(){
        System.out.println("====================================================================================");

        System.out.println("The grandmaster was so impressed he transported you to a game show to compete for money");
        System.out.println("You must win at least $2000 to get your 4th piece! Only the winner of the gameshow earns the prize money!");
        System.out.println("====================================================================================");
        int points = 0;
        while(true){
            Integer[] questions = {500, 1000, 1500, 2000, 2500};
            System.out.println("What question would you like?");
            for(int i=1; i<6; i++){
                if(questions[i-1]!=null){
                    
                    System.out.println(i+". $"+questions[i-1]);

                }
            }
            int choice = in.nextInt();
            in.nextLine();


            if(choice==2500){
                questions[4]=null;
                
                System.out.println("Does time run slower in outer space (beyond any objects) or near earth?");
                
                String answer = in.nextLine();
                
                if(answer.substring(0,1).equals("e")){
                    System.out.println("Correct!\n");
                    points+=2500;
                }
                
                else{
                    System.out.println("Sorry, incorrect!");
                }
                
                
            }
            
            if(choice==500){
                questions[0]=null;
                System.out.println("Is earth or mars closer to the sun?");
                
                String answer = in.nextLine();
                
                if(answer.substring(0,1).equals("e")){
                    System.out.println("Correct!\n");
                    points+=500;
                }
                               else{
                    System.out.println("Sorry, incorrect!");
                }
                
                
            }
            
            if(choice==1000){
                questions[1]=null;
                System.out.println("Is mercury hotter than earth?");
                
                String answer = in.nextLine();
                
                if(answer.substring(0,1).equals("y")){
                    System.out.println("Correct!\n");
                    points+=1000;
                }
                
               else{
                    System.out.println("Sorry, incorrect!");
                }
            }
            
            if(choice==1500){
                questions[2]=null;
                System.out.println("How many months does one cycle of the moon take?");
                
                String answer = in.nextLine();
                
                if(answer.substring(0,1).equals("1")){
                    System.out.println("Correct!\n");
                    points+=1500;
                }
                
               else{
                    System.out.println("Sorry, incorrect!");
                }
                
            }
            
            else{
                questions[2]=null;
                System.out.println("How many layers does Earth's atmosphere have?");
                
                String answer = in.nextLine();
                
                if(answer.substring(0,1).equals("5")){
                    System.out.println("Correct!\n");
                    points+=2000;
                }
                
               else{
                    System.out.println("Sorry, incorrect!");
                }
                
            }
            
            System.out.println("Your opponent guesses correctly and wins $1000!");
            System.out.println("Your opponent guesses correctly again and wins $500!");
            
            if(points>=2000){
                System.out.println("You win!");
                return points/10;
                
            }
            
            continue;

            
            
            

            
            
            
            
        }

        
        
        
        
        
        
        
    }
    
    public static String pointUpdate(){

        return name + " has "+totalpoints+ " points total with "+lives+" lives remaining!";
        
    }
    
    public static boolean liveCheck(){
        return lives>0;
    }
    private void printTextArt(String artText, int textHeight, ASCIIArtFont fontType, String artSymbol) throws Exception {
        String fontName = fontType.getValue();
        int imageWidth = findImageWidth(textHeight, artText, fontName);
 
        BufferedImage image = new BufferedImage(imageWidth, textHeight, BufferedImage.TYPE_INT_RGB);
        Graphics g = image.getGraphics();
        Font font = new Font(fontName, Font.BOLD, textHeight);
        g.setFont(font);
 
        Graphics2D graphics = (Graphics2D) g;
        graphics.drawString(artText, 0, getBaselinePosition(g, font));
 
        for (int y = 0; y < textHeight; y++) {
            StringBuilder sb = new StringBuilder();
            for (int x = 0; x < imageWidth; x++)
                sb.append(image.getRGB(x, y) == Color.WHITE.getRGB() ? artSymbol : " ");
            if (sb.toString().trim().isEmpty())
                continue;
            System.out.println(sb);
        }
    }
 
    /**
     * Convenience method for printing ascii text art.
     * Font default - Dialog,  Art symbol default - *
     * @param artText
     * @param textHeight
     * @throws Exception
     */
    private void printTextArt(String artText, int textHeight) throws Exception {
        printTextArt(artText, textHeight, ASCIIArtFont.ART_FONT_DIALOG, DEFAULT_ART_SYMBOL);
    }
 
    /**
     * Using the Current font and current art text find the width of the full image
     * @param textHeight
     * @param artText
     * @param fontName
     * @return
     */
    private int findImageWidth(int textHeight, String artText, String fontName) {
        BufferedImage im = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);
        Graphics g = im.getGraphics();
        g.setFont(new Font(fontName, Font.BOLD, textHeight));
        return g.getFontMetrics().stringWidth(artText);
    }
 
    /**
     * Find where the text baseline should be drawn so that the characters are within image
     * @param g
     * @param font
     * @return
     */
    private int getBaselinePosition(Graphics g, Font font) {
        FontMetrics metrics = g.getFontMetrics(font);
        int y = metrics.getAscent() - metrics.getDescent();
        return y;
    }
}
