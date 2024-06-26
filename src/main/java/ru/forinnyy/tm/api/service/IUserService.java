package ru.forinnyy.tm.api.service;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.forinnyy.tm.enumerated.Role;
import ru.forinnyy.tm.exception.entity.AbstractEntityException;
import ru.forinnyy.tm.exception.entity.UserNotFoundException;
import ru.forinnyy.tm.exception.field.AbstractFieldException;
import ru.forinnyy.tm.exception.field.LoginEmptyException;
import ru.forinnyy.tm.exception.user.AbstractUserException;
import ru.forinnyy.tm.model.User;

public interface IUserService extends IService<User> {

    @NotNull
    User create(String login, String password) throws AbstractUserException, AbstractFieldException, AbstractEntityException;

    @NotNull
    User create(String login, String password, String email) throws AbstractUserException, AbstractFieldException, AbstractEntityException;

    @NotNull
    User create(String login, String password, Role role) throws AbstractUserException, AbstractFieldException, AbstractEntityException;

    @Nullable
    User findByLogin(String login) throws AbstractFieldException;

    @Nullable
    User findByEmail(String email) throws AbstractUserException;

    @Nullable
    User removeByLogin(String login) throws AbstractEntityException, AbstractFieldException;

    @Nullable
    User removeByEmail(String email) throws AbstractEntityException, AbstractUserException, AbstractFieldException;

    @NotNull
    User setPassword(String id, String password) throws AbstractFieldException, AbstractEntityException;

    @NotNull
    User updateUser(String id, String firstName, String lastName, String middleName) throws AbstractFieldException, AbstractEntityException;

    @NotNull
    Boolean isLoginExist(String login);

    @NotNull
    Boolean isEmailExist(String email);

    void lockUserByLogin(String login) throws AbstractFieldException, AbstractEntityException;

    void unlockUserByLogin(String login) throws AbstractFieldException, AbstractEntityException;

}
