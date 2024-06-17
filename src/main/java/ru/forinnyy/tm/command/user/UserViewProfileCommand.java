package ru.forinnyy.tm.command.user;

import org.jetbrains.annotations.NotNull;
import ru.forinnyy.tm.enumerated.Role;
import ru.forinnyy.tm.exception.entity.AbstractEntityException;
import ru.forinnyy.tm.exception.field.AbstractFieldException;
import ru.forinnyy.tm.exception.user.AbstractUserException;
import ru.forinnyy.tm.model.User;

public final class UserViewProfileCommand extends AbstractUserCommand {

    private final String NAME = "view-user-profile";

    private final String DESCRIPTION = "View profile of current user";

    @Override
    public @NotNull String getDescription() {
        return DESCRIPTION;
    }

    @Override
    public @NotNull String getName() {
        return NAME;
    }

    @Override
    public void execute() throws AbstractFieldException, AbstractUserException {
        final User user = getAuthService().getUser();
        System.out.println("[USER VIEW PROFILE]");
        System.out.println("ID: " + user.getId());
        System.out.println("LOGIN: " + user.getLogin());
        System.out.println("FIRST NAME: " + user.getFirstName());
        System.out.println("MIDDLE NAME: " + user.getMiddleName());
        System.out.println("LAST NAME: " + user.getLastName());
        System.out.println("EMAIL: " + user.getEmail());
        System.out.println("ROLE: " + user.getRole());
    }

    @Override
    public Role[] getRoles() {
        return Role.values();
    }

}
