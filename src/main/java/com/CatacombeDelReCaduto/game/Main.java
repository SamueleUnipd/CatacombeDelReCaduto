package com.CatacombeDelReCaduto.game;

import com.CatacombeDelReCaduto.game.jsonHandlers.FilesManager;
import com.CatacombeDelReCaduto.game.menus.MainMenu;
import java.util.logging.Logger;
import java.util.logging.Level;

/**
 * Classe d'avvio del gioco
 */
public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args){
        try {
            // crea se necessario cartella salvataggio dei dati
            FilesManager.makeSavesDir();

            // avvio menu iniziale
            MainMenu mainMenu = new MainMenu();
            mainMenu.display();
        }catch (Exception ex){
            System.out.println("Errore nell'esecuzione del programma\n" + ex.getMessage());
            logger.log(Level.SEVERE, "", ex);
        }
    }

    /**
     * disabilita tutti i log del programma (chiamare all'inizio per creare un jar senza log)
     */
    public static void disableLogging(){
        // disable logging
        java.util.logging.LogManager.getLogManager().reset();

        Logger rootLogger = Logger.getLogger("");
        rootLogger.setLevel(Level.OFF);
    }
}
