package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import Astar.*;

public class GUI extends JFrame {

	static Main ASTAR;

	GUI(Main ASTAR) {
		
		Font main = new Font("���� ���",0,30);
		Font sub = new Font("���� ���",0,15);
		
		setTitle("A-STAR Algorithm");
		setSize(500, 500);
		setVisible(true);
		Container c = getContentPane();

		c.setBackground(Color.DARK_GRAY);
		setLayout(null);
		add(new BGR());
		add(new showmap());

		add(new RUI());
		
		JLabel Title = new JLabel("A Star Algorithm");
		Title.setLocation(10,430);
		Title.setSize(300,40);
		Title.setFont(main);
		Title.setForeground(Color.WHITE);
		c.add(Title);
		

		// setResizable(false);
	}

	public class BGR extends Panel {
		Main ASTAR;
		public BGR() {
			Font sub = new Font("���� ���",Font.BOLD,12);
			setBackground(null);		
			Container M = getContentPane();			
			setSize((int) ((M.getSize().height) * (1.0)), (int) ((M.getSize().width) * (0.08))-15);
			setLocation(10,(int) ((M.getSize().height) * (0.8))+30);
			setLayout(new GridLayout(1, 3, 30, 0));
			JButton buttons_BUI[] = new JButton[3];
			for (int i = 0; i < buttons_BUI.length; i++) {
				buttons_BUI[i] = new JButton("�Ŵ�" + (i + 1));
				buttons_BUI[i].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent a) {
						for (int i = 0; i < buttons_BUI.length; i++) {
							if (a.getSource() == buttons_BUI[i]) {
								System.out.println(buttons_BUI[i].getText());
								/*
								 * �׼����� �޾Ƶ��� ��� �ּ� �Է�
								 * 
								 */

							}
						}
					}
				});

				buttons_BUI[i].setBackground(Color.GRAY);
				add(buttons_BUI[i]);
			}
			buttons_BUI[0].setText("����� ����");
			buttons_BUI[1].setText("������ ����");
			buttons_BUI[2].setText("���! �帲��");
			for(int i=0; i<=2; i++){
				buttons_BUI[i].setFont(sub);
				buttons_BUI[i].setForeground(Color.WHITE);
			}
		}
	}

	public class RUI extends Panel {
		Main ASTAR;
		public RUI() {
			setBackground(Color.DARK_GRAY);
			Font sub = new Font("���� ���",Font.BOLD,12);
			Container M = getContentPane();
			setResizable(false);
			setSize((int) ((M.getSize().height) * (0.2))+15, (int) ((M.getSize().width) * (0.9)));
			setLocation((int) ((M.getSize().height) * (0.8)), 10);
			setLayout(new GridLayout(6, 1, 0, 20));
			JButton buttons_BUI[] = new JButton[5];
			for (int i = 0; i < buttons_BUI.length; i++) {
				buttons_BUI[i] = new JButton("�Ŵ�" + (i + 1));
				buttons_BUI[i].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent a) {
						for (int i = 0; i < buttons_BUI.length; i++) {
							if (a.getSource() == buttons_BUI[i]) {
								System.out.println(buttons_BUI[i].getText());
								/*
								 * �׼����� �޾Ƶ��� ��� �ּ� �Է�
								 * 
								 */
							}
						}
					}
				});
				buttons_BUI[i].setBackground(Color.GRAY);
				add(buttons_BUI[i]);
			}
			buttons_BUI[0].setText("�� ��������");
			buttons_BUI[1].setText("�� ������");
			buttons_BUI[2].setText("�� ����");
			buttons_BUI[3].setText("��� �ʱ�ȭ");
			buttons_BUI[4].setText("�������");
			for(int i=0; i<=4; i++){
				buttons_BUI[i].setFont(sub);
				buttons_BUI[i].setForeground(Color.WHITE);
			}
		}
	}

	public class showmap extends Panel {
		Main ASTAR;
		public void name() {
		}
		/**
		 * Create the panel.
		 */
		public showmap() {
			Container M = getContentPane();
			// �� ũ�� �޾Ƽ� �׸��� ���� �ƿ����� �߰� �ؾ���
			JButton buttons[][] = new JButton[20][20];
			setLayout(null);
			final int sizeX = (int) ((M.getSize().height) * (0.8));
			final int sizeY = (int) ((M.getSize().width) * (0.8));
			int buttons_sizeX = (sizeX / buttons.length);
			int buttons_sizeY = (sizeY / buttons[0].length);
			setSize(sizeX, sizeY);
			setBackground(Color.DARK_GRAY);
			Color c = Color.DARK_GRAY;
			int l = 0;
			int a = 10;
			int b = 10;
			for (int i = 0; i < buttons.length; i++) {
				for (int j = 0; j < buttons[0].length; j++) {
					buttons[i][j] = new JButton("");
					buttons[i][j].setSize(buttons_sizeX, buttons_sizeY);
					buttons[i][j].setLocation(a, b);
					buttons[i][j].addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							for (int i = 0; i < buttons.length; i++) {
								for (int j = 0; j < buttons[0].length; j++) {
									if (e.getSource() == buttons[i][j]) {
										System.out.println("(" + i + "," + j + ")");
										Color temp = buttons[i][j].getBackground();
										if (temp.equals(c)) {
											buttons[i][j].setBackground(Color.GREEN);
										} else {
											buttons[i][j].setBackground(null);
										}
										/*
										 * �׼����� �޾Ƶ��� ��� �ּ� �Է�
										 * 
										 */
									}
								}
							}
						}
					});
					add(buttons[i][j]);
					buttons[i][j].setBackground(null);
					l++;
					a += buttons_sizeX;
					if (j == buttons[0].length - 1) {
						a = 10;
					}
				}
				b += buttons_sizeY;
			}
			// setResizable(false);
		}
		//////////////////////
	}
}