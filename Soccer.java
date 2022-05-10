/**
 Name: Matthew
 <p>
 Date: April 28, 2022
 Description: The Sports super class. Sports are like minigames that we make to simulate real games, featuring random possibilities,
 resulting in goals, commentary and what not. Has overall result win or loss because the user is betting on the sport after all.
 */
import java.util.*;
import java.util.Random;

public class Soccer extends Sports{

    //Attributes
    private int homeScore=0;
    private int opposingScore=0;

    //Constructor to make a soccer game
    public Soccer(Player player1, Player player2, Player player3, Player player4, Player player5, Player player6,
                  Player player7,Player player8,Player player9,Player player10){
        super(player1, player2, player3, player4, player5, player6, player7,player8,player9,player10);
    }

    //Runs the game (dependant on user class)(other class)
    public void runSoccer(double wager, String chosenTeam, User gambler){
         Player[] homeTeam=getHomeTeam();
         Player[] opposingTeam=getOpposingTeam();

        int result = 0; // 2 is win, 1 is tie, 0 is lose lol loser
        Wallet wallet = gambler.getWallet();
        wallet.changeMoney(-wager);
        //players fight 10 times
        //Match 2 random players against each other 10 times
        for(int i=0; i<10; i++){
            Random rand = new Random();
            int randomNum = rand.nextInt(5);
            int secondRandomNum = rand.nextInt(5);
            if (homeTeam[randomNum].successRate(homeTeam[randomNum])>opposingTeam[secondRandomNum].successRate(opposingTeam[secondRandomNum])){
                homeScore +=1;
                System.out.println("home team scored a gooall!");
            }
            else if (homeTeam[randomNum].successRate(homeTeam[randomNum])<opposingTeam[secondRandomNum].successRate(opposingTeam[secondRandomNum])){
                opposingScore +=1;
                System.out.println("opposing team scored a gooall!");
            }
            else if(i==9){
                System.out.println("The players are head to head, but the game is coming to an end....");
            }
            else{
                System.out.println("*Soccer ball bouncing noises*");
            }
        }

        System.out.println("The final score of home vs opposing is "+homeScore+" : "+opposingScore);

        //winning
        if (chosenTeam.equals("home") && homeScore>opposingScore){
            result = 2;
            System.out.println("You won the bet and gained $"+ wager );
        }
        else if (chosenTeam.equals("opposition") && opposingScore>homeScore){
            result = 2;
            System.out.println("You won the bet and gained $"+ wager );
        }
        //losing
        else if (chosenTeam.equals("home") && opposingScore>homeScore){
            result = 0;
            System.out.println("You lost the bet and lost $"+ wager );
        }
        else if (chosenTeam.equals("opposition") && homeScore>opposingScore){
            result = 0;
            System.out.println("You lost the bet and lost $"+ wager );
        }
        else{
            result = 1;
            System.out.println("The game was tied, your wager is returned.");
        }

        wallet.changeMoney(wager * result);

    }

    //Testing
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in) ;

        //Demonstrating runSoccer method
        //Creates players
        Player freddyJackson = new Player("Freddy Jackson",17,38);
        Player michealJackson = new Player("Micheal Jackson",21,38);
        Player georgeWashingless = new Player("George Washingless ",52,21);
        Player sierraJones = new Player("Sierra Jones",31,24);
        Player biancaBruh = new Player("Bianca Bruh",51,26);
        Player evan = new Player("Evan",69,21);
        Player gary = new Player("Gary",21,69);
        Player imRunning = new Player("Im Running",43,25);
        Player outOf = new Player("Out Of",2,32);
        Player namesToput = new Player("Names Toput",58,21);

        //Creating soccer game with 10 "players"
        Soccer soccer = new Soccer(freddyJackson,michealJackson,georgeWashingless,sierraJones,biancaBruh,evan,gary,imRunning,outOf,namesToput);

        //Gets their wager
        System.out.println("How much do you want to wager?");
        double bet = sc.nextDouble();
        sc.nextLine();

        //Prints out the players on both teams
        System.out.println(soccer.toString());

        //Gets them to pick side and runs the game
        System.out.println("home or opposition?");
        String selectedTeam = sc.nextLine();
        User bary = new User("garyisbad", "garyisbad1", "696969");
        bary.getWallet().changeMoney(1000000);
        soccer.runSoccer(bet, selectedTeam, bary);
        System.out.println("New balance: "+ bary.getWallet().getQtyUSD());
    }
}
