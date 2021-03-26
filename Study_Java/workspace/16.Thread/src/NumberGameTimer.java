import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class NumberGameTimer extends JFrame implements ActionListener {
	JButton gameStart;
	
	//생성자 메소드
	public NumberGameTimer() {
		//창 설정
		setTitle("Number Game with Timer");	//제목표시줄
		setSize(500, 550);	//화면 크기 설정
		setLocationRelativeTo(null);	//화면 중앙에 위치
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//닫기 버튼을 누르면 완전종료
		setLayout(null);	//레이아웃 매니저 미생성
		this.getContentPane().setBackground(Color.WHITE);	//패널색상 흰색
		
		//버튼 설정
		gameStart = new JButton("Game Start");
		gameStart.setBounds(150, 180, 160, 60);	//버튼 위치 및 사이즈 할당
		add(gameStart);
		gameStart.setBorder(null);
		gameStart.addActionListener(this);
	}//NumberGameTimer()
	
	//이벤트 발생 시 행동 생성
	@Override
	public void actionPerformed(ActionEvent e) {
		Object object = e.getSource();
		
		//버튼 클릭 시 게임 시작 이벤트
		if (object == gameStart) {
			GameGui game = new GameGui();
			Thread thGame = new Thread(game);
			thGame.start();
			
			dispose();
		}//if
		
	}//actionPerformed() override

	
	public static void main(String[] args) {
		new NumberGameTimer();	//생성자 메소드 호출
	}//main()
	
}//class

class GameGui extends JFrame implements Runnable, ActionListener {
	JButton[] number = new JButton[50];
	String[] numberStr = new String[50];
	
	int i;
	Random rnd = new Random();
	int rndValue;
	int[] rndValueCheck = new int[25];
	int[] numberCheck = new int[50];
	JLabel resultLable = new JLabel("결과");
	JLabel resultTimerLable = new JLabel();
	JLabel realTimerLable = new JLabel();
	
	@Override
	public void run() {
		setTitle("Number Game with Timer");	//제목표시줄
		setSize(500, 550);	//화면 크기 설정
		setLocationRelativeTo(null);	//화면 중앙에 위치
		setLayout(null);	//레이아웃 매니저 미생성
		
		realTimerLable.setBounds(200, 5, 200, 50);
		realTimerLable.setFont(new Font("Gothic", Font.BOLD, 30));
		
		RealTime realTime = new RealTime(realTimerLable);
		Thread thread = new Thread(realTime);
		
		add(realTimerLable);
		repaint();
		
		//숫자판
		for (int i = 0; i <= 49; i++) {
			numberStr[i] = Integer.toString(i + 1);
			number[i] = new JButton(numberStr[i]);
			number[i].setSize(95, 90);
			number[i].setFont(new Font("Gothic", Font.BOLD, 30));
			if (i <= 48) {
				number[i].addActionListener(this);
			}//if
			this.numberCheck[i] = 0;
		}//for
		
		for (int i = 0; i <= 24; i++) {
			rndValueCheck[i] = 0;
		}//for
		
		for (int i = 0; i <= 24; i++) {
			for (;;) {
				rndValue = (int)(Math.random() * 25);
				if (rndValueCheck[rndValue] != 1) {
					break;
				}//if
			}//for
			number[rndValue].setLocation((i % 5) * 95, (i / 5) * 90 + 50);
			add(number[rndValue]);
			rndValueCheck[rndValue] = 1;
		}//for
		
		this.getContentPane().setBackground(Color.WHITE);	//패널색상 흰색
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//닫기 버튼을 누르면 완전종료
		
		thread.start();
		
	}//run() override
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object object = e.getSource();
		numberCheck[0] = 1;
		for (int i = 0; i <= 49; i++) {
			if (i <= 24) {
				if (object == number[i]) {
					for (;;) {
						if (numberCheck[i] == 1) {
							number[i + 25].setLocation(number[i].getLocation());
							number[i].setEnabled(false);
							number[i].setVisible(false);
							add(number[i + 25]);
							numberCheck[i + 1] = 1;
						}//inner-2 if
						break;
					}//inner for
				}//inner-1 if
			} else if (i <= 48) {
				if (object == number[i]) {
					for (;;) {
						if (numberCheck[i] == 1) {
							number[i].setEnabled(false);
							number[i].setVisible(false);
							numberCheck[i + 1] = 1;
						}//inner-2 if
						break;
					}//inner for
				}//inner-1 if
			} else if (i == 49) {
				if (numberCheck[49] == 1) {
					number[49].addActionListener(this);
				}//inner if
			}//outer if
		}//outer for
		
		if (object == number[49]) {
			resultLable.setBounds(200, 150, 100, 40);
			resultLable.setFont(new Font("Gothic", Font.BOLD, 30));
			resultLable.setForeground(Color.black);
			add(resultLable);
			
			resultTimerLable.setText(realTimerLable.getText() + "초");
			resultTimerLable.setBounds(170, 220, 150, 40);
			resultTimerLable.setFont(new Font("Gothic", Font.BOLD, 30));
			resultTimerLable.setForeground(Color.black);
			add(resultTimerLable);
			
			repaint();
			
			number[49].setEnabled(false);
			number[49].setVisible(false);
			realTimerLable.setEnabled(false);
			realTimerLable.setVisible(false);
		}//if
	}//actionPerformed() override
	
}//class

class RealTime implements Runnable {
	JLabel realTimerLabel;
	
	public RealTime(JLabel realTimerLabel) {
		this.realTimerLabel = realTimerLabel;
	}//RealTime()
	
	//타이머 설정
	@Override
	public void run() {
		double number = 0;
		for (;;) {
			number += 0.01;	//100분의 1초까지 나오게끔
			realTimerLabel.setText(String.format("%.2f", number));
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				return;
			}//try-catch
		}//for
	}//run() override

}//class
