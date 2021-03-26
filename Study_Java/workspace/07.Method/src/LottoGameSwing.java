import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

//AWT, SWING : Java에서 제공하는 GUI (Graphic User Interface)
public class LottoGameSwing {
	//컴포넌트 선언 
	JFrame frame;
	JPanel panel;
	JTextArea output;
	JButton startBtn;
	JButton clearBtn;
	
	//생성자 메소드 ㅣ 코드 구현
	public LottoGameSwing() {
		//컴포넌트 객체 생성
		 frame = new JFrame();
		 panel = new JPanel();
		 output = new JTextArea();
		 startBtn = new JButton("번호생성");
		 clearBtn = new JButton("번호지우기");
		 
		 //startBtn과 clearBtn을 panel에 묶어준다(등록).
		 panel.add(startBtn);
		 panel.add(clearBtn);
		 
		 //출력창(output)의 글꼴스타일 변경
		 output.setFont(new Font("Century Gothic", Font.BOLD, 20));
		 
		 //frame에 output과 panel을 배치
		 frame.getContentPane().add(new JScrollPane(output), BorderLayout.CENTER);
		 frame.getContentPane().add(panel, BorderLayout.CENTER);
		 
		 //frame 속성 설정
		 frame.setTitle("Lotto Game");
		 frame.setSize(250, 300);
		 frame.setVisible(true);
		 frame.setLocationRelativeTo(null);	//화면중앙에 배치
		 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//닫기
		 
		 //이벤트 처리를 위한 Listener 클래스와 연계
		 startBtn.addActionListener(new StartBtnListener());
		 clearBtn.addActionListener(new ClearBtnListener());
	}//LottoGameSwing()
	
	//번호생성 이벤트 클래스
	class StartBtnListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			LottoGame game = new LottoGame();
			int[] lotto = game.getNumber();
			for (int i = 0; i < lotto.length; i++) {
				if (lotto[i] < 10) {
					output.append("0" + lotto[i] + " ");
				} else {
					output.append(lotto[i] + " ");
				}//if
			}//for
			output.append("\n");
		}
	}//class
	
	//번호지우기 이벤트 클래스
	class ClearBtnListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			output.setText("");
		}
	}//class
	
	public static void main(String[] args) {
		new LottoGameSwing();
		
	}//main()
}//class
