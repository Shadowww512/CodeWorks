package labs.lab4;

import java.awt.Point;
import java.util.List;

/**
 * A class for an adventure game with a player, traps, and jet packs. The game
 * world measures 10 x 10, and the center of the world is at coordinates 0, 0.
 */
public class AdventureGame {

	private Point player_location;
    private String player_direction;
    private int num_of_moves;
    private int num_of_jetPacks;

    private List<Point> traps;
    private List<Point> jetPacks;

    
	/**
	 * Constructs a new game with player location 0, 0 (in the center of the world)
	 * facing north, with the traps and jet packs given
	 * 
	 * @param traps    list of locations of traps (assume all within world bounds,
	 *                 and not at 0, 0)
	 * @param jetPacks list of locations of jet packs (assume all within world
	 *                 bounds, and not at 0, 0)
	 */
	public AdventureGame(List<Point> traps, List<Point> jetPacks) {
		this.traps = traps;
        this.jetPacks = jetPacks;

        this.player_direction = "NORTH";
        this.player_location = new Point(0,0);
        this.num_of_moves = 0;
        this.num_of_jetPacks = 0;
	}

	/**
	 * Turns the player to the left
	 */
	public void playerTurnLeft() {
		switch (player_direction){
            case "NORTH":
                player_direction = "WEST";
                break;
            case "WEST":
                player_direction = "SOUTH";
                break;
            case "SOUTH":
                player_direction = "EAST";
                break;
            case "EAST":
                player_direction = "NORTH";
                break;
        }
	}

	/**
	 * Turns the player to the right
	 */
	public void playerTurnRight() {
		switch(player_direction){
            case "NORTH":
                player_direction = "EAST";
                break;
            case "EAST":
                player_direction = "SOUTH";
                break;
            case "SOUTH":
                player_direction = "WEST";
                break;
            case "WEST":
                player_direction = "NORTH";
                break;
        }
	}


	/**
	 * Moves the player one step in the direction they're facing, as long as the
	 * move is a valid one (within the bounds of the world)
	 */
	public void movePlayer() {
        //translate location by  direction case
        switch (player_direction){
            case "NORTH":
                if (player_location.getY() < 5){
                    player_location.translate(0, 1);
                } else {return;}
                break;
            case "SOUTH":
                if (player_location.getY() >  -5){
                    player_location.translate(0, -1);
                } else {return;}
                break;
            case "WEST":
                if(player_location.getX() > -5){
                    player_location.translate(-1, 0);
                } else {return;}
                break;
            case "EAST":
                if(player_location.getX() < 5){
                    player_location.translate(1, 0);
                } else {return;}
                break;
        }
        
        //check collide of current location with traps and jetPacks list
        boolean hasTrap = traps.contains(player_location);
        boolean hasjetPack = jetPacks.contains(player_location);
        
        if (hasTrap && hasjetPack){
            //pick up and use right-a-way
            pick_up_jetPack(player_location);
            fell_into_trap(player_location);
            //this is to see if there is a jetpack previously unpicked due to full package, but now with one empty spot
            pick_up_jetPack(player_location);
        }
        else if (hasTrap){
            fell_into_trap(player_location);
        }
        else if (hasjetPack){
            pick_up_jetPack(player_location);
        }
        
        num_of_moves++;
        //check winning condition after each move, if survived
        if (num_of_moves == 30){
            System.out.print("You win!");
        }
	}
    
    //player try to pick up as much jetpack from the location as possible
    private void pick_up_jetPack(Point player_location){
        final String pick_up_jetPackMessage = "Picked up jet pack! ";
        while(true){
            //if no more jetpack at the spot
            if (!jetPacks.contains(player_location)){
                return;
            }
            if (num_of_jetPacks < 3){
                num_of_jetPacks++;
                jetPacks.remove(player_location);
                System.out.print(pick_up_jetPackMessage);
            } else {return;}
        }
    }

    private void fell_into_trap(Point player_location){
        final String fell_trap_loseMessage = "Fell into a trap! You lose!";
        final String used_jetpackMessage = "Fell into a trap! Used jet pack! ";
        num_of_jetPacks --;
        if (num_of_jetPacks < 0){
            System.out.print(fell_trap_loseMessage);
            return;
        } else {
            System.out.print(used_jetpackMessage);
        }
    }
	/**
	 * Returns the player's current location
	 * 
	 * @return the player's current location
	 */
	public Point getPlayerLocation() {
		return player_location;
	}


	/**
	 * Returns the direction in which the player is currently facing
	 * ("NORTH", "SOUTH", "EAST", OR "WEST")
	 * 
	 * @return	the direction in which the player is currently facing
	 */
	public String getPlayerDirection() {
		return player_direction;
	}
	
	
	/**
	 * Returns the number of moves the player has taken
	 * 
	 * @return	the number of moves the player has taken
	 */
	public int getNumMovesMade() {
		return num_of_moves;
	}
}
