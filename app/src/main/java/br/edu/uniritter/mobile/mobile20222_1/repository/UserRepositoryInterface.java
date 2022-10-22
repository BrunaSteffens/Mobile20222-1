package br.edu.uniritter.mobile.mobile20222_1.repository;

import java.util.List;

import br.edu.uniritter.mobile.mobile20222_1.model.User;

public interface UserRepositoryInterface {
    public List<User> getUsers();
    public User getUserById(int id);
    public User getUserByUserLogin(String login);
    public List<User> getUsersByName(String name);
    public User addUser(User user);
    public User updateUser(User user) ;
    public User removeUser(User user);

}
