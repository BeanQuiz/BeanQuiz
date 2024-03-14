package za.co.bbd.cli.beanquiz;

import kong.unirest.json.JSONObject;
import za.co.bbd.cli.beanquiz.command.*;
import za.co.bbd.cli.beanquiz.model.UserQuestionResponse;

import java.util.*;

public class Global {
    public static final String AUTH0_DOMAIN = "https://dev-lnr103bcr22wbcst.us.auth0.com/";
    public static final String AUTH0_CLIENT_ID = "OFccgQPw8u2R2rSzMSXL5T1lncsUADpx";
    public static final String AUTH0_AUDIENCE = "http://localhost:8080/";
    public static final String API_DOMAIN = "http://beanstalk-stack-environment.eba-taemd5qk.eu-west-1.elasticbeanstalk.com/";
    public static String accessToken = "";
    public static String user = "";
    public static Integer quizId = -1;

    public static Date startTimestamp;
    public static Date endTimestamp;

    public static Integer score = 0;
    public static Integer totalQuestions = 0;

    public static List<JSONObject> questions = new ArrayList<>();
    public static List<UserQuestionResponse> userQuestionResponses = new ArrayList<>();

    public static final List<Command> defaultCommands = Arrays.asList(
            new LoginCommand(),
            new LogoutCommand(),
            new PlayCommand(),
            new ProfileCommand(),
            new QuitCommand()
    );

    public static List<Command> commands = defaultCommands;

    public static final Scanner scanner = new Scanner(System.in);
}