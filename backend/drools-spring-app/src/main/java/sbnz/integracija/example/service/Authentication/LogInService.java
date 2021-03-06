package sbnz.integracija.example.service.Authentication;


import lombok.RequiredArgsConstructor;
import sbnz.integracija.example.facts.LoginEvent;
import sbnz.integracija.example.facts.Notification;
import sbnz.integracija.example.facts.User;
import sbnz.integracija.example.repository.NotificationRepository;
import sbnz.integracija.example.repository.UserRepository;
import sbnz.integracija.example.security.api.AuthenticationService;
import sbnz.integracija.example.security.api.TokenService;
import sbnz.integracija.example.service.Authentication.command.LogInUseCase;
import sbnz.integracija.example.service.knowledge.KnowledgeService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LogInService implements LogInUseCase {

    Logger logger = LoggerFactory.getLogger(LogInService.class);

    private final AuthenticationService authenticationService;
    private final TokenService tokenService;
    private final PasswordEncoder encoder;
    private final UserRepository userRepository;
    private final KnowledgeService knowledgeService;
    private final NotificationRepository notificationRepository;

    @Override
    public LoginDTO logIn(LoginCommand command) {

        User user = authenticationService.authenticate(command.getEmail(), command.getPassword());
        checkForSuspiciousActivity(command.getEmail());
        String token = tokenService.getToken(user);
        long expiresIn = tokenService.getExpiresIn();

        return LoginDTO.of(token, user.getAuthorities(), expiresIn);
    }
    
    private void checkForSuspiciousActivity(String email) {
    	LoginEvent le = new LoginEvent(email);
    	Notification n = new Notification();
    	knowledgeService.getEventsSession().insert(le);
    	knowledgeService.getEventsSession().insert(n);
    	knowledgeService.getEventsSession().fireAllRules();
    	
    	if(n.getCode() == 1) {
    		notificationRepository.save(n);
    	}
    	
    }

}
