package sonmyeongjae.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sonmyeongjae.Dao.MemberDao;
import sonmyeongjae.Dto.MemberDto;

public class MListCommand implements MCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// 1.DB에 목록을 반환하는 메소드를 실행
		MemberDao dao = new MemberDao();
		//2. 반환하는 목록을 requestScope 저장
		ArrayList<MemberDto> dtos = dao.list();
		//3. request scope에 저장
		request.setAttribute("dtos", dtos);

	}

}
