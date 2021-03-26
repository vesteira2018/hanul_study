package notice;

import java.util.List;

public interface NoticeService {
	//CRUD
	void notice_insert(NoticeVO vo); //�ű԰���������
	void notice_reply_insert(NoticeVO vo); //�űԴ������
	List<NoticeVO> notice_list(); //�����۸����ȸ
	NoticePage notice_list(NoticePage page); //������������ �����۸����ȸ
	NoticeVO notice_view(int id);//�����ۻ���ȸ(�����ۺ���)
	void notice_read(int id); //��ȸ�� ����ó��
	void notice_update(NoticeVO vo); //�����ۺ�������
	void notice_delete(int id);//�����ۻ���
	
}
