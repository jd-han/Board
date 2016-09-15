package framework;

import java.util.HashMap;
import java.util.Map;

public class URLHandleMapping {
	private Map<String, Controller> mappings;
	public URLHandleMapping() {}
	public URLHandleMapping(String ctrlNames) throws Exception {
		mappings = new HashMap<>();

		String[] ctrlList = ctrlNames.split(";");
		for (String ctrlInfo : ctrlList) {
			String[] ctrlArr = ctrlInfo.trim().split("=");
			mappings.put(
					ctrlArr[0],
					(Controller)Class.forName(ctrlArr[1]).newInstance()
			);
		}
	}

	public Controller getController(String requestUri) {
		return mappings.get(requestUri);
	}
}









