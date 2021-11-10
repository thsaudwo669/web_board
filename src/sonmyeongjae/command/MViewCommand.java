package sonmyeongjae.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sonmyeongjae.Dao.MemberDao;
import sonmyeongjae.Dto.MemberDto;

public class MViewCommand implements MCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		
		String id = request.getParameter("id");
		
		MemberDao dao = new MemberDao();
		
		MemberDto dto = dao.view(id);
		
		request.setAttribute("dto", dto);

	}

}
