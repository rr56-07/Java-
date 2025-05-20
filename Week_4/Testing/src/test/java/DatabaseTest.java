import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseTest {
    Database db ;

    @BeforeEach
    void connect(){
        db = new Database();
        db.connected();
    }
    @AfterEach
    void disconnect() {
        db.disconnected();
    }

    @Test
    void testConnected() {
        assertTrue(db.isConnected());
    }
}