import org.junit.AfterClass;
import org.junit.BeforeClass;

import com.github.danielpacak.jenkins.ci.core.Job;
import com.github.danielpacak.jenkins.ci.core.client.JenkinsClient;

public abstract class AbstractJenkinsIntegrationTest {

    private static String host = "localhost";

    private static Integer port = 8081;

    private static String user = "dopaboi";

    private static String password = "dopaboi";

    @BeforeClass
    public static void beforeClass() {
        System.out.printf("Starting Jenkins on %s:%s...%n", host, port);
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("Stopping Jenkins ...");
    }

    protected JenkinsClient getJenkinsClient() {
        return new JenkinsClient(host, port).setCredentials(user, password);
    }


    protected Job newJobWithRandomName() {
        return new Job().setName(newRandomName());
    }


    protected String newRandomName() {
        return "junit-" + System.currentTimeMillis();
    }

}