package domb.app.controllers;

import domb.app.model.User;
import domb.app.repositories.UserRepository;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TestController {
  
  private final KieContainer kieContainer;
  private UserRepository userRepository;

  @Autowired
  public TestController(KieContainer kieContainer, UserRepository userRepository) {
    super();
    this.kieContainer = kieContainer;
    this.userRepository = userRepository;
  }

  @RequestMapping(value = "/test-rule", method = RequestMethod.GET, produces = "application/json")
	public User testRule() {
		User newUser = new User();
    newUser.setEmail("email@email.com");
    newUser.setPassword("password");
    newUser.setFirstName("Mile");
    newUser.setLastName("<O><O><O><O><O>");
    userRepository.save(newUser);

    KieSession kieSession = kieContainer.newKieSession();
    kieSession.insert(newUser);
    kieSession.fireAllRules();
    kieSession.dispose();

    return newUser;
	}
}
