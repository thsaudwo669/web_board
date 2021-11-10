package sonmyeongjae.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sonmyeongjae.Dao.MemberDao;
import sonmyeongjae.Dto.MemberDto;

public class MInsertCommand implements MCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		MemberDto dto = new MemberDto();
		
		dto.setId(request.getParameter("id"));
		dto.setPwd(request.getParameter("pwd"));
		dto.setName(request.getParameter("Name"));
		dto.setEmail(request.getParameter("email"));
		
		MemberDao dao = new MemberDao();
		dao.insert(dto);

	}

}
