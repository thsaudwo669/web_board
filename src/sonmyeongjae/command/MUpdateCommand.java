package sonmyeongjae.command;

import java.io.UnsupportedEncodingException;
import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sonmyeongjae.Dao.MemberDao;
import sonmyeongjae.Dto.MemberDto;

public class MUpdateCommand implements MCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("MUpdateCommand");
		//1.폼에서 입력된 데이터를 받아서 MemberDto로 만들기
		MemberDto dto = new MemberDto();
		//2.MemberDao 객체 생성
		dto.setId(request.getParameter("id"));
		dto.setPwd(request.getParameter("pwd"));
		dto.setName(request.getParameter("name"));
		dto.setEmail(request.getParameter("email"));
		dto.setJoinDate(Date.valueOf(request.getParameter("joinDate")));
		
		//3.MemberDao 객체의 해당되는 메소드 실행(update)
		MemberDao dao = new MemberDao();
		dao.update(dto);

	}

}
