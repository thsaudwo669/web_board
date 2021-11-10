package sonmyeongjae;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sonmyeongjae.command.MCommand;
import sonmyeongjae.command.MDeleteCommand;
import sonmyeongjae.command.MInsertCommand;
import sonmyeongjae.command.MListCommand;
import sonmyeongjae.command.MUpdateCommand;
import sonmyeongjae.command.MViewCommand;

@WebServlet("*.do")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;

   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String viewPage =null;
		String uri = request.getRequestURI();
		String com =uri.substring(uri.lastIndexOf("/")+1, uri.lastIndexOf(".do"));
		
		if(com != null && com.trim().equals("list")) {
			MCommand command = new MListCommand();
			command.execute(request, response);
			viewPage = "/WEB-INF/view/mList.jsp";
		}else if(com != null && com.trim().equals("insertForm")) {
			viewPage = "/WEB-INF/view/mInsertForm.jsp";
		}else if(com != null && com.trim().equals("insert")) {
			MCommand command = new MInsertCommand();
			command.execute(request, response);
			viewPage = "list.do";
		}else if(com !=null && com.trim().equals("view")) {
			//1.Model 부분의 서비스를 실행 
			MCommand command = new MViewCommand();
			//2.해당되는 View로 이동
			command.execute(request, response);
			//3.리스트 재사용
			viewPage = "/WEB-INF/view/mView.jsp";
			
		}else if(com !=null && com.trim().equals("update")) {
			MCommand command = new MUpdateCommand();
			command.execute(request, response);
			viewPage = "list.do";
		}else if(com !=null && com.trim().equals("delete")) {
			MCommand command = new MDeleteCommand();
			command.execute(request, response);
			viewPage = "list.do";
		}
		
		RequestDispatcher rd = request.getRequestDispatcher(viewPage);
		rd.forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
