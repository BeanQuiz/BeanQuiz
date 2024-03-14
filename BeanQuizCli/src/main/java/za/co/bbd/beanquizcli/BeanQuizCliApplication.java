package za.co.bbd.beanquizcli;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import za.co.bbd.beanquizcli.command.CommandHandler;


import java.util.Scanner;

@SpringBootApplication
public class BeanQuizCliApplication implements CommandLineRunner {

	private final CommandHandler commandHandler = new CommandHandler();

	public static void main(String[] args) {
		SpringApplication.run(BeanQuizCliApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.setProperty("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.NoOpLog");

		Output.printWelcomeBanner();

		Boolean shouldContinue = true;

		while (shouldContinue) {
			Output.printCommands(Global.commands);

			commandHandler.setCommands(Global.commands);

			Output.printEnterCommand();

			String userInput = Global.scanner.nextLine();

			shouldContinue = commandHandler.getCommand(userInput).execute();
		}

		Global.scanner.close();
	}
}
