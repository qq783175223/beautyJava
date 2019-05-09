
import javax.websocket.CloseReason;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

//ws://127.0.0.1:8080/Demo1/ws/����
@ServerEndpoint("/ws/{user}")
public class WSServer {
	private String currentUser;
	
	//���Ӵ�ʱִ��
	@OnOpen
	public void onOpen(@PathParam("user") String user, Session session) {
		currentUser = user;
		System.out.println("Connected ... " + session.getId());
	}

	//�յ���Ϣʱִ��
	@OnMessage
	public String onMessage(String message, Session session) {
		System.out.println(currentUser + "��" + message);
		return currentUser + "��" + message;
	}

	//���ӹر�ʱִ��
	@OnClose
	public void onClose(Session session, CloseReason closeReason) {
		System.out.println(String.format("Session %s closed because of %s", session.getId(), closeReason));
	}

	//���Ӵ���ʱִ��
	@OnError
	public void onError(Throwable t) {
		t.printStackTrace();
	}
}
