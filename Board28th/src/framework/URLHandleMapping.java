package framework;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class URLHandleMapping {
	// /board/list.do     ->  BoardController, list
	// /login/logout.do   ->  LoginController, logout
	// /login/login.do    ->  LoginController, login
	
	private Map<String, CtrlAndMethod> mappings;
	public URLHandleMapping() {}
	public URLHandleMapping(String ctrlNames) throws Exception {
		mappings = new HashMap<>();

		/*
			kr.co.mlec.board.controller.BoardController;
            kr.co.mlec.login.controller.LoginController
		 */
		String[] ctrlList = ctrlNames.split(";");
		for (String ctrlName : ctrlList) {
			// ctrlName : kr.co.mlec.board.controller.BoardController
			// ctrlName : kr.co.mlec.login.controller.LoginController
			Class<?> clz = Class.forName(ctrlName.trim());
			Object target = clz.newInstance();
			
			// clz 안에 존재하는 모든 메서드를 추출한다.
			Method[] mArr = clz.getDeclaredMethods();
			// 반복을 진행하면서 메서드의 URI 정보를 추출하고
			// URI 에 해당하는 객체와 실행 메서드 정보를 맵에 저장한다.
			for (Method method : mArr) {
				RequestMapping rm = method.getAnnotation(RequestMapping.class);
				if (rm == null) continue;
				
				mappings.put(
					rm.value(), new CtrlAndMethod(target, method)
				);
			}
		}
	}

	public CtrlAndMethod getCtrlAndMethod(String requestUri) {
		return mappings.get(requestUri);
	}
}









