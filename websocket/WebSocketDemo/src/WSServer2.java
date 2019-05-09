import java.io.IOException;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ServerEndpoint(value="/ws2/{userId}")
public class WSServer2 {
    private Logger logger = LoggerFactory.getLogger(WSServer2.class);
    
    private static String userId;
    
    //����ʱִ��
    @OnOpen
    public void onOpen(@PathParam("userId") String userId,Session session) throws IOException{
        this.userId = userId;
        logger.debug("�����ӣ�{}",userId);
    }
    
    //�ر�ʱִ��
    @OnClose
    public void onClose(){
        logger.debug("���ӣ�{} �ر�",this.userId);
    }
    
    //�յ���Ϣʱִ��
    @OnMessage
    public void onMessage(String message, Session session) throws IOException {
        logger.debug("�յ��û�{}����Ϣ{}",this.userId,message);
        session.getBasicRemote().sendText("�յ� "+this.userId+" ����Ϣ "); //�ظ��û�
    }
    
    //���Ӵ���ʱִ��
    @OnError
    public void onError(Session session, Throwable error){
        logger.debug("�û�idΪ��{}�����ӷ��ʹ���",this.userId);
        error.printStackTrace();
    }

}