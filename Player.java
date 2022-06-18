/**
 Name: Matthew
 <p>
 Date: April 28, 2022
 Description: Player class, registers new players that will be competing
 */

public class Player {
    // attributes

    /**
     * player's name
     */
    private String name ;

    /**
     * amount of wins the player has
     */
    private int wins ;

    /**
     * amount of losses the player has
     */
    private int losses ;


    //constructors

    /**
     * Default constructor
     */
    public Player(){
        this.name="";
        this.wins=0;
        this.losses=0;
    }

    /**
     * Registers a player
     * @param name name
     * @param wins player's wins
     * @param losses player's losses
     */
    public Player(String name, int wins, int losses){
        this.name= name;
        this.wins= wins;
        this.losses= losses;
    }

    //getter methods
    /**
     * gets name
     * @return name of player
     */
    public String getName(){
        return this.name;
    }

    /**
     * gets player's wins
     * @return player's wins
     */
    public int getWins(){
        return this.wins;
    }

    /**
     * gets player's losses
     * @return player's losses
     */
    public int getLosses(){
        return this.losses;
    }

    //setter methods

    /**
     * changes player's wins
     * @param newWins new wins
     */
    public void setWins(int newWins){
        this.wins = newWins;
    }


    /**
     * changes player's losses
     * @param newLosses new losses
     */
    public void setLosses(int newLosses){
        this.losses = newLosses;
    }

    //toString

    /**
     * Returns all of a player's stats
     * @return all of a player's stats
     */
    public String toString() {
        return ("Name: " + this.name + " \nWins: " + this.wins + "\nLosses: " + this.losses + "\n");
    }

    //calculate success rate

    /**
     * Calculates a player's success rate of scoring
     * @param player the player
     * @return the player's success rate
     */
    public double successRate(Player player){
        return player.wins / player.losses ;
    }

    //cheer for a player(if we implement a chat feature)(dependant on user class)(other class)

    /**
     * Cheer for a player (In chat)
     * @param user the user that is cheering
     */
    public void cheerForPlayer(User user){
        System.out.println(user.getUsername()+" is cheering for "+this.name);
    }

    public static void main(String[] args) {
        Player freddyJackson = new Player("Freddy Jackson",17,38);
        User jary = new User("garyisbad", "garyisbad1", "696969");
        freddyJackson.cheerForPlayer(jary);
    }
}
