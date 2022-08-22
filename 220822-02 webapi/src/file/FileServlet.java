package file;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/fileupload")
@MultipartConfig(location = "d:\\temp", fileSizeThreshold = 10 * 1024 * 1024
, maxFileSize =  50 * 1024 * 1024)
// location은 임시 폴더
// fileSizeThreshold에 적어놓은것보다 작은 파일은 인메모리로 들어가고 넘어가면 파일형태로 임시 폴더에 들어간다(하드디스크를 씀)
// maxFileSize는 사용자가 보낼 수 있는 최대 용량
public class FileServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// System.out.println(req.getContentType());
		Part p = req.getPart("fileupload");
		System.out.println(p.getName()); // 파라미터 이름 ex)fileupload
		System.out.println(p.getSubmittedFileName()); // 실제 사용자가 올린 파일의 이름 ex)춘식1.png
		for (String header : p.getHeaderNames()) { // 헤더를 꺼내보고있음
			System.out.println(header + " : " + p.getHeader(header));
		}
		// ex)
		// content-disposition : form-data; name="fileupload"; filename="춘식1.png"
		// content-type : image/png
		
		// 파일을 저장해보자
		// 특별한 경로 지정을 해줘도 되지만 톰캣 카탈리나 베이스에 집어넣어보자
		String contextPath = getServletContext().getRealPath("");
		System.out.println(contextPath); // 경로를 찾아가보자
		
		// 자바 nio 패키지에 집어넣기
		Path directory = Paths.get(contextPath); // 해당 경로를 가르킬 수 있는 path 객체
		Files.copy(p.getInputStream(), directory.resolve(p.getSubmittedFileName()), StandardCopyOption.REPLACE_EXISTING);
		// .resolve는 붙일 이름 .getSubmittedFileName()로 그대로 붙여넣었음
		// StandardCopyOption은 그 파일이 이미 존재할 때 어떻게 할 것인지 REPLACE_EXISTING 덮어써라
		
		resp.sendRedirect("/" + URLEncoder.encode(p.getSubmittedFileName(), "UTF-8"));
	}
}
