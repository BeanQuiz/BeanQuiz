package za.co.bbd.cli.beanquiz.command;

public abstract class Command {
    private final String identifier;
    private final String description;

    public Command(String identifier, String description) {
        this.identifier = identifier;
        this.description = description;
    }

    public String getIdentifier() {
        return identifier;
    }

    public String getDescription() {
        return description;
    }

    public Boolean enabled() {
        return true;
    }

    public Boolean hidden() {
        return false;
    }

    public Boolean execute() {
        return true;
    }

    public String getPrefix() {return "";}
}
