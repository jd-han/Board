package framework;

import java.util.HashMap;
import java.util.Map;

import board.controller.CommentDeleteController;
import board.controller.CommentRegistController;
import board.controller.CommentUpdateController;
import board.controller.DeleteController;
import board.controller.DetailController;
import board.controller.ListController;
import board.controller.UpdateController;
import board.controller.UpdateFormController;
import board.controller.WriteController;
import board.controller.WriteFormController;
import login.LoginController;
import login.LoginFormController;
import login.LogoutController;

public class URLHandleMapping {
	private Map<String, Controller> mappings;
	
	public URLHandleMapping() {
		mappings = new HashMap<>();
		mappings.put("/board/list.do", new ListController());
		mappings.put("/board/detail.do", new DetailController());
		mappings.put("/board/delete.do", new DeleteController());
		mappings.put("/board/writeForm.do", new WriteFormController());
		mappings.put("/board/write.do", new WriteController());
		mappings.put("/board/updateForm.do", new UpdateFormController());
		mappings.put("/board/update.do", new UpdateController());
		mappings.put("/board/commentDelete.do", new CommentDeleteController());
		mappings.put("/board/commentRegist.do", new CommentRegistController());
		mappings.put("/board/commentUpdate.do", new CommentUpdateController());
		mappings.put("/login/login.do", new LoginController());
		mappings.put("/login/loginForm.do", new LoginFormController());
		mappings.put("/login/logout.do", new LogoutController());
	}

	public Controller getController(String requestUri) {
		return mappings.get(requestUri);
	}
}









