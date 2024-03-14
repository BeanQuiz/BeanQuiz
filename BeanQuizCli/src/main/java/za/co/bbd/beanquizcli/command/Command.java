package za.co.bbd.beanquizcli.command;

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

    public Boolean execute() {
        return true;
    }
}
