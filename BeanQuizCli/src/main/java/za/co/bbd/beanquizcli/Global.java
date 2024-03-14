package za.co.bbd.beanquizcli;

import com.fasterxml.jackson.databind.ObjectMapper;
import za.co.bbd.beanquizcli.command.Command;
import za.co.bbd.beanquizcli.command.ListQuizCommand;
import za.co.bbd.beanquizcli.command.LoginCommand;
import za.co.bbd.beanquizcli.command.QuitCommand;

import java.util.Scanner;

public class Global {
    public static final String AUTH0_DOMAIN = "https://dev-lnr103bcr22wbcst.us.auth0.com/";
    public static final String API_DOMAIN = "http://beanstalk-stack-environment.eba-taemd5qk.eu-west-1.elasticbeanstalk.com/";

    public static final Scanner scanner = new Scanner(System.in);

    public static final ObjectMapper objectMapper = new ObjectMapper();

    // List of commands that the CommandHandler loops to
    public static Command[] commands = {
//            new LoginCommand(),
            new ListQuizCommand(),
            new QuitCommand()
    };
}
