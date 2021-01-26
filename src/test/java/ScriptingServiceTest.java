import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.github.danielpacak.jenkins.ci.core.GroovyResponse;
import com.github.danielpacak.jenkins.ci.core.GroovyScript;
import com.github.danielpacak.jenkins.ci.core.StringGroovyScript;
import com.github.danielpacak.jenkins.ci.core.service.ScriptingService;
import com.github.danielpacak.jenkins.ci.core.util.Streams;


public class ScriptingServiceTest extends AbstractJenkinsIntegrationTest {

    private ScriptingService service;

    @Before
    public void beforeTest() throws Exception {
        this.service = new ScriptingService(getJenkinsClient());
    }

    @Test
    public void runScript() throws Exception {
        GroovyScript script = new StringGroovyScript("print 'Hello, Jenkins!'");

        GroovyResponse response = service.runScript(script);
        assertEquals("Hello, Jenkins!", Streams.toString(response.getInputStream()));
    }

}