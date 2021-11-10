package sonmyeongjae.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sonmyeongjae.Dao.MemberDao;

public class MDeleteCommand implements MCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String id =request.getParameter("id");
		
		MemberDao dao = new MemberDao();
		dao.delete(id);

	}

}
