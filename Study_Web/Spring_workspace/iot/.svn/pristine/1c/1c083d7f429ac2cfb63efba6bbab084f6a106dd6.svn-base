package visual;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import common.LowerKeyMap;

@Service
public class VisualServiceImpl implements VisualService {
	@Autowired private VisualDAO dao;
	
	@Override
	public List<LowerKeyMap> department_analysis() {
		return dao.department_analysis();
	}

	@Override
	public List<LowerKeyMap> hirement_analysis_year() {
		return dao.hirement_analysis_year();
	}
	
	@Override
	public List<LowerKeyMap> hirement_analysis_month() {
		return dao.hirement_analysis_month();
	}

	@Override
	public List<LowerKeyMap> hirement_analysis_top3_year() {
		return dao.hirement_analysis_top3_year();
	}

	@Override
	public List<LowerKeyMap> hirement_analysis_top3_month() {
		return dao.hirement_analysis_top3_month();
	}

}
