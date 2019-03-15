package com.github.user;


import com.github.utils.MailSender;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public void save(User user) {

        if(user.getEmail().equals("spedrasss@gmail.com") || user.getEmail().equals("admin@gmail.com")){
            user.setAdmin(true);
        }

        String generatedString = RandomStringUtils.randomAlphanumeric(32);
        user.setRegisterToken(generatedString);
        String subject = "Welcome " + user.getFirstName();

        String content =
                String.format("<a href=\"localhost:8080/register/%s\" >Register link ->  Click</a>",
                    user.getRegisterToken());
        try {
            MailSender.sendEmail(user.getEmail(), subject, content);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        userRepository.save(user);
    }

    @Override
    public void update(User user) {
        userRepository.save(user);
    }

    @Override
    public User find(Long id) {
        return userRepository.findOne(id);
    }

    @Override
    public void delete(Long id) {
        userRepository.delete(id);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public boolean existUserByEmail(String email) {
        if(userRepository.existsUserByEmail(email)){
            return true;
        }
        return false;
    }
    @Override
    public User findUserByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }

    @Override
    public User findByRegisterToken(String token) {
        return userRepository.findByRegisterToken(token);
    }

}
