package domb.app.controllers;

import domb.sbnz.model.User;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TestController {
  
  private final KieContainer kieContainer;

  @Autowired
  public TestController(KieContainer kieContainer) {
    super();
    this.kieContainer = kieContainer;
  }

  @RequestMapping(value = "/test-rule", method = RequestMethod.GET, produces = "application/json")
	public User testRule() {
		User newUser = new User();

        newUser.setFirstName("Mile");
        newUser.setLastName("<O>");
        KieSession kieSession = kieContainer.newKieSession();
        kieSession.insert(newUser);
        kieSession.fireAllRules();
        kieSession.dispose();

        return newUser;
	}
}
