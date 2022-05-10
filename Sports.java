import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 Name: Matthew
 <p>
 Date: April 28, 2022
 Description: The Sports super class. Sports are like minigames that we make to simulate real games, featuring random possibilities,
 resulting in goals, commentary and what not. Has overall result win or loss because the user is betting on the sport after all.
 */

public class Sports {
    //Attributes
    private int homeScore;
    private int opposingScore;
    private Player[] homeTeam;
    private Player[] opposingTeam;

    //Constructor to make a sports team
    public Sports(Player player1, Player player2, Player player3, Player player4, Player player5, Player player6,
                  Player player7,Player player8,Player player9,Player player10){
        Player[] totalPlayers={player1,player2,player3,player4,player5,player6,player7,player8,player9,player10};

        //Shuffling the 10 players
        List<Player> list = Arrays.asList(totalPlayers);
        Collections.shuffle(list);
        list.toArray(totalPlayers);

        //Splits into two random teams because the total players have been shuffled
        this.homeTeam= new Player[]{totalPlayers[0], totalPlayers[1], totalPlayers[2], totalPlayers[3], totalPlayers[4]};
        this.opposingTeam= new Player[]{totalPlayers[5], totalPlayers[6], totalPlayers[7], totalPlayers[8], totalPlayers[9]};
    }

    //Getters
    public int getHomeScore(){
        return homeScore;
    }
    public int getOpposingScore(){
        return opposingScore;
    }
    public Player[] getHomeTeam(){
        return homeTeam;
    }
    public Player[] getOpposingTeam(){
        return opposingTeam;
    }

    //Setters
    public void setHomeScore(int newHomeScore){
        this.homeScore = newHomeScore;
    }
    public void setOpposingScore(int newOpposingScore){
        this.opposingScore = newOpposingScore;
    }
    public void setHomeTeam(Player[] newHomeTeam){
        this.homeTeam = newHomeTeam;
    }
    public void setOpposingTeam(Player[] newOpposingTeam){
        this.opposingTeam = newOpposingTeam;
    }

    //toString
    public String toString(){
        //Prints out the players and info on both teams
        String everything="";
        everything+="Home Team: \n";
        for(int i = 0; i < 5; i++){
            everything+= "Name: "+this.homeTeam[i].getName()+"\n";
            everything+= "Wins: "+this.homeTeam[i].getWins()+"\n";
            everything+= "Losses: "+this.homeTeam[i].getLosses()+"\n";
            everything+= "\n";
        }
        everything+="Opposing Team: \n";
        for(int i = 0; i < 5; i++){
            everything+= "Name: "+this.opposingTeam[i].getName()+"\n";
            everything+= "Wins: "+this.opposingTeam[i].getWins()+"\n";
            everything+= "Losses: "+this.opposingTeam[i].getLosses()+"\n";
            everything+= "\n";
        }
        return(everything);
    }

    //cheering for a team (if we implement a chat feature)(dependant on user class)(other class)
    public void cheerForTeam(User user, String team){
        System.out.println(user.getUsername()+" is cheering for "+team);
    }

    //change player on the team (dependant on player class)(my class)
    public void replacePlayer(Player player, Player newPlayer){
        for (int i=0;i<5;i++){
            if(homeTeam[i]==player){
                homeTeam[i]=newPlayer ;
            }
            else if(opposingTeam[i]==player){
                opposingTeam[i]=newPlayer ;
            }
        }
    }

    //Demonstrating everything
    public static void main(String[] args) {
        //Making Players
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

        //Making a sports game
        Sports sport = new Sports(freddyJackson,michealJackson,georgeWashingless,sierraJones,biancaBruh,evan,gary,imRunning,outOf,namesToput);

        //Using and printing the getter methods(Scores are empty because they only get changed when a game runs)
        System.out.println(sport.getHomeScore());
        System.out.println(sport.getOpposingScore());
        Player[] tempHomeTeam =sport.getHomeTeam();
        Player[] tempOpposingTeam =sport.getHomeTeam();
        System.out.println("Home:");
        for(int i=0;i<sport.homeTeam.length;i++){
            System.out.println(tempHomeTeam[i]);
        }
        System.out.println("Opposing:");
        for(int i=0;i<sport.homeTeam.length;i++){
            System.out.println(tempOpposingTeam[i]);
        }

        //Using and printing the setter methods
        sport.setHomeScore(2);
        sport.setOpposingScore(25);
        //Printing the new scores
        System.out.println(sport.homeScore);
        System.out.println(sport.opposingScore);

        //Making new teams to replace the old ones
        Player[] newHomeTeam = new Player[]{freddyJackson,michealJackson,georgeWashingless,sierraJones,biancaBruh};
        Player[] newOpposingTeam = new Player[]{evan,gary,imRunning,outOf,namesToput};
        sport.setHomeTeam(newHomeTeam);
        sport.setOpposingTeam(newOpposingTeam);
        //Printing the new teams
        System.out.println(sport.toString());

        //the toString method
        System.out.println(sport.toString());

        //cheering method
        //Making a user
        User jary = new User("garyisbad", "garyisbad1", "696969");
        sport.cheerForTeam(jary,"home");

        //replace method
        //Making new player to replace
        Player jack = new Player("jack",68,21);
        sport.replacePlayer(namesToput, jack);
        System.out.println(sport.toString());
    }
}
