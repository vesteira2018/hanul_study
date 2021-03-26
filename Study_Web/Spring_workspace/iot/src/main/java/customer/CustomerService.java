package customer;

import java.util.List;

public interface CustomerService {
	//CRUD(Create, Read, Update, Delete)
	void customer_insert(CustomerVO vo); //�ű԰�����
	List<CustomerVO> customer_list(); //�������ȸ
	CustomerVO customer_detail(int id); //����������ȸ
	void customer_update(CustomerVO vo); //��������������
	void customer_delete(int id); //����������
}
