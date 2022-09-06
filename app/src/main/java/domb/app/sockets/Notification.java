package domb.app.sockets;


public class Notification {
    private String type;
  
    public Notification() {
    }
  
    public Notification(String type) {
      this.type = type;
    }
  
    public String getType() {
      return this.type;
    }
  
    public void setType(String type) {
      this.type = type;
    }
  
  }