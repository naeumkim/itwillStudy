package exam;

import java.awt.Button;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JFrame;

public class exam0525 extends JFrame{

	
		final int SIZE = 5;
		Button[] btnArr = null;
		String[] birds = { "참새", "두루미", "황새", "비둘기", "까오기", "오리", "타조", "부엉이", "올빼미", "뱁새", "꿩", "닭", "구관조", "잉꼬", "매",
				"거위", "독수리", "콘돌", "봉황", "공작", "까치", "까마귀", "앵무새", "꾀꼬리", "고니" };

		public exam0525() {
			this("Bingo Game");
		}
		
		exam0525(String title) {
			super(title);
			setLayout(new GridLayout(SIZE, SIZE));
			MyEventHandler handler = new MyEventHandler();
			addWindowListener(handler);
			btnArr = new Button[SIZE * SIZE];

			for (int i = 0; i < SIZE * SIZE; i++) {
				btnArr[i] = new Button(birds[i]);
				btnArr[i].addActionListener(handler);
				add(btnArr[i]);
			}
			setBounds(500, 200, 300, 300);
			setVisible(true);
		}

		public static void main(String args[]) {
			exam0525 win = new exam0525("Bingo Game");
			win.show();
		}

		class MyEventHandler extends WindowAdapter implements ActionListener {
			public void actionPerformed(ActionEvent ae) {
				Button btn = (Button) ae.getSource();
				System.out.println(btn.getLabel());
				btn.setBackground(Color.LIGHT_GRAY);
			}

			public void windowClosing(WindowEvent e) {
				e.getWindow().setVisible(false);
				e.getWindow().dispose();
				System.exit(0);
			}
		}
		
	
}
