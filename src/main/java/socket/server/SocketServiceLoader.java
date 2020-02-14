package socket.server;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class SocketServiceLoader implements ServletContextListener {
    private Server server;
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        new Server();

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
