package edu.ramapo.akarki;

import edu.ramapo.akarki.canasta.model.CanastaGame;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args)
    {
        CanastaGame game = new CanastaGame();
        try
        {
            game.runGame();
        }
        catch (Exception e)
        {
            // prints exception if any  
            e.printStackTrace();
        }
    }
}
