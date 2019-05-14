package in.anil.questbook.service;

import in.anil.questbook.model.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}