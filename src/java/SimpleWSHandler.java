
import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import javax.websocket.CloseReason;
import javax.websocket.OnClose;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/simple")
public class SimpleWSHandler {
 private static final Set<Session> sessions = 
  Collections.synchronizedSet(new HashSet<Session>());

 @OnOpen
 public void open(Session session) {
  sessions.add(session); //Save the session
 }
 @OnClose
 public void close(Session session, CloseReason reason) {
  sessions.remove(session); //Remove the session
 }
public static void broadcastMessage(String message) {
 for (Session s : sessions) {
  if (s.isOpen()) {
   try {
    s.getBasicRemote().sendText(message);
   } catch (IOException e) {
    e.printStackTrace();
   }
  }
 }
}
}
