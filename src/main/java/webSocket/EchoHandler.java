package webSocket;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.RequestContextListener;
import org.springframework.web.context.request.ServletRequestAttributes;

@RequestMapping("/echo")
public class EchoHandler extends TextWebSocketHandler {
	// ���� ����Ʈ
	private List<WebSocketSession> sessionList = new ArrayList<WebSocketSession>();

	private static Logger logger = LoggerFactory.getLogger(EchoHandler.class);

	// Ŭ���̾�Ʈ�� ���� �Ǿ��� �� ����
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		sessionList.add(session);
		logger.info("{} �����", session.getId());
		System.out.printf("{} �����", session.getId().toString());
		
		// 1��
//		HttpServletRequest servletRequest = (HttpServletRequest) ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes());
		// 2��
//		ServletRequestAttributes servletRequestAttribute = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
//		HttpSession httpSession = servletRequestAttribute.getRequest().getSession(true);
//		String userName = (String) httpSession.getAttribute("userName");

//        for(WebSocketSession sess : sessionList){
//          sess.sendMessage(new TextMessage(name + " : " + contents));
//        }
	}

	// Ŭ���̾�Ʈ�� ������ ������ �޽����� �������� �� ����
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		logger.info("{}�� ���� {} ����", session.getId(), message.getPayload());
		System.out.printf("{}�� ���� {} ����", session.getId(), message.getPayload());

		String[] allMessage = message.getPayload().split(",");
		String contents = allMessage[0];
		String name = allMessage[1];

		// ��� �������� �޼��� ���
		for (WebSocketSession sess : sessionList) {
//            sess.sendMessage(new TextMessage(message.getPayload()));
			sess.sendMessage(new TextMessage(name + " : " + contents));
		}
	}

	// Ŭ���̾�Ʈ ������ ������ �� ����
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		sessionList.remove(session);
		logger.info("{} ���� ����.", session.getId());
	}
}
