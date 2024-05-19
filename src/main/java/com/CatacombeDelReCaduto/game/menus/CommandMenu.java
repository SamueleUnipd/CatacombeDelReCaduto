package com.CatacombeDelReCaduto.game.menus;

import com.CatacombeDelReCaduto.game.prompts.Command;
import com.CatacombeDelReCaduto.game.prompts.InputReader;

import java.util.List;
import java.util.TreeMap;

/**
 * Estendere questa classe per creare un menu di gioco che e` gestito da comandi
 */
public abstract class CommandMenu extends Menu {
    protected List<Command> commands;
    private TreeMap<String, Command> commandMap;

    public CommandMenu(List<Command> commands) {
        // chiamo costruttore Menu dando gli item da mostrare
        super(commands.stream().map(Command::getDescription).toList());

        // init comandi
        this.commands = commands;
        initCommandMap();
    }

    public void display() {
        Command command = null;

        String userCommand = "";
        do {
            // stampo menu
            print();

            // prendo input
            userCommand = InputReader.getInput();

            // verifico se l'utente ha inputato il numero del menu
            int choice = userChoice(userCommand);

            // se comando non trovato parso il linguaggio
            if (choice < 1)
                command = Command.parse(userCommand, commandMap);
            // se comando trovato get command
            else
                command = commands.get(choice - 1);

        } while (command == null);

        commandsHandler(command);
    }

    /**
     * implementare switch che chiama il metodo corretto in base al comando
     * @param command comando dato dall'utente
     */
    protected abstract void commandsHandler(Command command);

    private void initCommandMap() {
        commandMap = new TreeMap<>();

        // inserisco nella mappa tutti gli alias del comando come chiave
        for (var command : commands)
            for (var alias : command.getAliases())
                commandMap.put(alias, command);
    }
}
