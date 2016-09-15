package util;

import java.io.File;
import java.util.UUID;

import com.oreilly.servlet.multipart.FileRenamePolicy;

public class BitFileRenamePolicy implements FileRenamePolicy {

	@Override
	public File rename(File oriFile) {
		// c:/2016/08/11/abc.jpg
		// abc.jpg
		String name = oriFile.getName();
		// c:/2016/08/11
		String parent = oriFile.getParent();
		String ext = "";
		// 3
		int index = name.lastIndexOf(".");
		if (index != -1) {
			// .jpg
			ext = name.substring(index);
		}
		String uName = UUID.randomUUID().toString();
		return new File(parent, uName + ext);
	}
}









