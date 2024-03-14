package za.co.bbd.beanquizcli;

import za.co.bbd.beanquizcli.command.Command;

public class Output {
    public static void printWelcomeBanner() {
        System.out.println("""
***********************************************
*                                             *
*            Welcome to Bean Quiz!            *
*                                             *
***********************************************
"""
        );
    }

    public static void printCommands(Command[] commands) {
        for(Command command : commands) {
            if (command.enabled()) {
                System.out.println(command.getIdentifier() + " - " + command.getDescription());
            }
        }
        System.out.println();
    }

    public static void printEnterCommand() {
        System.out.print("Please make a selection: ");
    }

}
