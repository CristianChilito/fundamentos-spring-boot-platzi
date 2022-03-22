package com.fundamentosplatzi.springboot.fundamentos.service;

import com.fundamentosplatzi.springboot.fundamentos.entity.User;
import com.fundamentosplatzi.springboot.fundamentos.repository.UserRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class UserService {
    private final static Log LOG = LogFactory.getLog(UserService.class);
    private static final String MESSAGE_USER_NOT_FOUND = "Ha ocurrido un error buscando el usuario por email";
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
//    public UserServiceImpl(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }

//    @Override
//    public User getUserByEmail(String email) {
////        Optional<User> optionalUser = userRepository.findMyUserByEmail(email);
////        if (optionalUser.isPresent()) {
////            return optionalUser.get();
////        }
//        return userRepository.findMyUserByEmail(email).orElseThrow(() -> new RuntimeException(MESSAGE_USER_NOT_FOUND));
////        throw new RuntimeException("Ha ocurrido un error buscando el usuario por email");
//    }





    @Transactional
    public void saveTransactional(List<User> users) {
        users.stream()
                .peek(user -> LOG.info("Insert usuario: " + user))
                .forEach(userRepository::save);
    }
    public List<User> getAllUsers() {
        return userRepository.findAll ();
    }

    public User save(User newUser) {
        return  userRepository.save(newUser);
    }

    public void delete(Long id) {
        userRepository.delete(new User(id));
    }

    public User update(User newUser, Long id) {
      return userRepository.findById(id).map(
                user -> {
                    user.setEmail(newUser.getEmail());
                    user.setBirthDate(newUser.getBirthDate());
                    user.setName(newUser.getName());
                    return  userRepository.save(user);
                }
        ).get();
    }
}
