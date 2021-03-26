package board;

import java.util.List;

public interface BoardService {
	//CRUD
	int board_insert(BoardVO vo); //���� �ű�����
	BoardPage board_list(BoardPage page);  //���������� �����ȸ
	BoardVO board_view(int id); //������ ���Ϻ�����ȸ
	void board_read(int id); //������ ���� ��ȸ�� ����ó��
	int board_update(BoardVO vo); //������ ���� ��������
	int board_delete(int id); //������ ������ ����
	
	int board_comment_insert(BoardCommentVO vo); //�������ó��
	List<BoardCommentVO> board_comment_list(int pid); //��۸����ȸ
	int board_comment_update(BoardCommentVO vo); //��ۺ�������ó��
	int board_comment_delete(int id); //��ۻ���ó��
}










