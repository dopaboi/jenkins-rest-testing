import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.github.danielpacak.jenkins.ci.core.Plugin;
import com.github.danielpacak.jenkins.ci.core.service.PluginService;


public class PluginServiceIntegrationTest extends AbstractJenkinsIntegrationTest {

    private PluginService service;

    @Before
    public void beforeTest() {
        service = new PluginService(getJenkinsClient());
    }

    @Test
    public void getPlugins() throws Exception {
        List<Plugin> plugins = service.getPlugins();
        for (Plugin plugin : plugins) {
            print(plugin);
        }
    }

    private void print(Plugin plugin) {
        System.out.println("Plugin.shortName: " + plugin.getShortName());
        System.out.println("Plugin.longName: " + plugin.getLongName());
        System.out.println("Plugin.url: " + plugin.getUrl());
        System.out.println("Plugin.version: " + plugin.getVersion());
        System.out.println("Plugin.enabled: " + plugin.getEnabled());

    }

}