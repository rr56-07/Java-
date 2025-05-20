public class Database {
    private boolean connected = false;

    public void connected(){
        connected = true;
    }

    public void  disconnected(){
        connected = false;
    }

    public boolean isConnected(){
        return connected;
    }
}
