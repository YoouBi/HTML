package listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;

@WebListener
public class MyRequestListener implements ServletContextAttributeListener, ServletRequestListener {

	@Override
	public void attributeAdded(ServletContextAttributeEvent scae) {
		System.out.println("요청 객체에 attribute가 설정되었음.");
		System.out.println(scae.getName() + scae.getValue());
		// 보안상의 이유로 테스트만 하장 ...
	}
	
	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		System.out.println("사용자 요청이 발생했을 때 이벤트~~~~");
		HttpServletRequest req = (HttpServletRequest) sre.getServletRequest();
		System.out.println(req.getRequestURI() + "를 요청하였음!");
	}
}
