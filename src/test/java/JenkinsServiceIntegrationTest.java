import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

import com.github.danielpacak.jenkins.ci.core.Jenkins;
import com.github.danielpacak.jenkins.ci.core.service.JenkinsService;


public class JenkinsServiceIntegrationTest extends AbstractJenkinsIntegrationTest {

    private JenkinsService service;

    @Before
    public void beforeTest() {
        service = new JenkinsService(getJenkinsClient());
    }

    @Test
    public void getJenkins() throws Exception {
        Jenkins jenkins = service.getJenkins();
        assertEquals(Jenkins.MODE.NORMAL, jenkins.getMode());
        assertEquals(new Integer(2), jenkins.getNumExecutors());
        assertEquals("the master Jenkins node", jenkins.getNodeDescription());
        // assertFalse(jenkins.getUseSecurity());
        assertNull(jenkins.getNodeName());
    }

}