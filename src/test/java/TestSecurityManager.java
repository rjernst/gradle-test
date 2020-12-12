
import java.net.URI;
import java.security.Policy;
import java.security.URIParameter;

import org.junit.jupiter.api.Test;

public class TestSecurityManager {

  @Test
  public void testSecurityManager() throws Exception {
    URI policyFile = TestSecurityManager.class.getResource("test.policy").toURI();
    Policy.setPolicy(Policy.getInstance("JavaPolicy",  new URIParameter(policyFile)));

    SecurityManager securityManager = new SecurityManager();
    System.setSecurityManager(securityManager);

    securityManager.checkPermission(new RuntimePermission("queuePrintJob"));
    System.setSecurityManager(null);
  }
}
