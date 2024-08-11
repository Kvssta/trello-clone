package org.nikola.trelloclone.service;

import org.nikola.trelloclone.entity.User;
import org.nikola.trelloclone.repository.UserRepository;

public interface UserService {

    User createNewUser(User user);
}
