import Client.StoreClientSide;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.AssertJUnit.assertEquals;

public class TestClientServerConnection {
    // to run tests on a server you fisrt need to turn it on
    @Test
    public void givenGreetingClient_whenServerRespondsWhenStarted_thenCorrect() throws IOException {

        StoreClientSide client = new StoreClientSide();
        client.startConnection("localhost", 5000);
        String response = client.sendMessage("start_shopping");
        assertEquals("Online Shopping Active Now", response);

    }
}
