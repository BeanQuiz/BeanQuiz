package za.co.bbd.cli.beanquiz;

import za.co.bbd.cli.beanquiz.command.CommandHandler;

import java.util.Scanner;

public class App {
    private final Scanner scanner = new Scanner(System.in);
    private final CommandHandler commandHandler = new CommandHandler();

    private void run() {
        Output.printWelcomeBanner();

        Boolean shouldContinue = true;

        while (shouldContinue) {
            Output.printLoggedInUser();

            Output.printCommands();

            commandHandler.setCommands(Global.commands);

            Output.printEnterCommand();

            String userInput = scanner.nextLine();
            try {
                shouldContinue = commandHandler.getCommand(userInput).execute();
            } catch (Exception e) {
                System.out.println("An error occurred...");
                Global.commands = Global.defaultCommands;
            }
        }

        scanner.close();
    }

    public static void main(String[] args) {
        System.setProperty("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.NoOpLog");
        new App().run();
    }
}
