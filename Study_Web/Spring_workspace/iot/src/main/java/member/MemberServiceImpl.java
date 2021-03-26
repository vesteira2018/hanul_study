package member;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {
	@Autowired private MemberDAO dao;
	
	@Override
	public boolean member_join(MemberVO vo) {
		return dao.member_join(vo);
	}

	@Override
	public MemberVO member_select(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MemberVO member_login(HashMap<String, Object> map) {
		return dao.member_login(map);
	}

	@Override
	public boolean member_update(MemberVO vo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean member_delete(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean member_id_check(String id) {
		return dao.member_id_check(id);
	}

	@Override
	public boolean member_social_id(MemberVO vo) {
		return dao.member_social_id(vo);
	}

	@Override
	public boolean member_social_insert(MemberVO vo) {
		return dao.member_social_insert(vo);
	}

	@Override
	public boolean member_social_update(MemberVO vo) {
		// TODO Auto-generated method stub
		return false;
	}

}
