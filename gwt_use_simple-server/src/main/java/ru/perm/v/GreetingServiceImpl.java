package ru.perm.v;

import com.google.gwt.user.server.rpc.jakarta.RemoteServiceServlet;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The server side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class GreetingServiceImpl extends RemoteServiceServlet implements
        GreetingService {
    Logger logger = Logger.getLogger(getClass().getName());

    public GreetingResponse greetServer(String input) throws IllegalArgumentException {
        logger.warning("Server received message: " + input);
        // Verify that the input is valid.
        if (!FieldVerifier.isValidName(input)) {
            logger.log(Level.ALL,"Name must be at least 4 characters long: " + input);
            // If the input is not valid, throw an IllegalArgumentException back to
            // the client.
            throw new IllegalArgumentException(
                    "Name must be at least 4 characters long");
        }

        GreetingResponse response = new GreetingResponse();

        response.setServerInfo(getServletContext().getServerInfo());
        response.setUserAgent(getThreadLocalRequest().getHeader("User-Agent"));

        response.setGreeting("Hello, " + input + "!");

        return response;
    }
}
