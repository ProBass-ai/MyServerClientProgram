import Client.GreetClient;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.AssertJUnit.assertEquals;

public class TestClientServerConnection {
    // to run tests on a server you fisrt need to turn it on
    @Test
    public void givenGreetingClient_whenServerRespondsWhenStarted_thenCorrect() throws IOException {

        GreetClient client = new GreetClient();
        client.startConnection("localhost", 5000);
        String response = client.sendMessage("activate_calculator");
        assertEquals("Calculator activated", response);

    }
}
