package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
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
		int Mode;
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
	
	public static class status extends Panel{
		static int Mode;
		static Button buttons[][] = new Button[20][20];
	}

	public class BGR extends status {
		Main ASTAR;
		public BGR() {
			Font sub = new Font("���� ���",Font.BOLD,12);
			setBackground(null);		
			Container M = getContentPane();			
			setSize((int) ((M.getSize().height) * (1.0)), (int) ((M.getSize().width) * (0.08))-15);
			setLocation(10,(int) ((M.getSize().height) * (0.8))+30);
			setLayout(new GridLayout(1, 1, 3, 0));
			JButton buttons_BUI[] = new JButton[4];
			for (int i = 0; i < buttons_BUI.length; i++) {
				buttons_BUI[i] = new JButton("�Ŵ�" + (i + 1));
				buttons_BUI[i].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent a) {
						for (int i = 0; i < buttons_BUI.length; i++) {
							if (a.getSource() == buttons_BUI[i]) {
								switch(buttons_BUI[i].getText()){
								case "����� ����" :{
									System.out.println("����� ����");
									Mode = 1;
									break;
								}
								case "������ ����" :{
									System.out.println("������ ����");
									Mode = 2;
									break;
								}
								case "��ֹ� ����" :{
									Mode = 3;
									break;
								}
								case "������ ����" :{
									for(int x=0; x<3; x++){
									buttons_BUI[x].setEnabled(true);}
									buttons_BUI[3].setText("������ ����");
									Mode = 0;
									break;
								}
								case "������ ����" :{
									for(int x=0; x<3; x++){
									buttons_BUI[x].setEnabled(false);}
									buttons_BUI[3].setText("������ ����");
									Mode = 0;
									break;
								}
								}
							}
						}
					}
				});

				buttons_BUI[i].setBackground(Color.GRAY);
				add(buttons_BUI[i]);
			}
			buttons_BUI[0].setText("����� ����");
			buttons_BUI[1].setText("������ ����");
			buttons_BUI[2].setText("��ֹ� ����");
			buttons_BUI[3].setText("������ ����");
			for(int x=0; x<3; x++){
				buttons_BUI[x].setEnabled(false);}
			for(int i=0; i<=3; i++){
				buttons_BUI[i].setFont(sub);
				buttons_BUI[i].setForeground(Color.WHITE);
			}
		}
	}

	public class RUI extends status {
		Main ASTAR;
		public RUI() {
			setBackground(Color.DARK_GRAY);
			Font sub = new Font("���� ���",Font.BOLD,12);
			Container M = getContentPane();
			setResizable(false);
			setSize((int) ((M.getSize().height) * (0.2))+6, (int) ((M.getSize().width) * (0.9)));
			setLocation((int) ((M.getSize().height) * (0.84)), 10);
			setLayout(new GridLayout(6, 1, 0, 20));
			JButton buttons_BUI[] = new JButton[5];
			for (int i = 0; i < buttons_BUI.length; i++) {
				buttons_BUI[i] = new JButton("�Ŵ�" + (i + 1));
				buttons_BUI[i].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent a) {
						for (int i = 0; i < buttons_BUI.length; i++) {
							if (a.getSource() == buttons_BUI[i]) {
								Mode = 0;
								switch(i){
								case 0:{
									
								}
								case 1:{
									
								}
								case 2:{
									
								}
								case 3:{
									
								}
								case 4:{
									System.exit(1);
								}
								}
							}
						}
					}
				});
				buttons_BUI[i].setBackground(Color.GRAY);
				add(buttons_BUI[i]);
			}
			buttons_BUI[0].setText("�� ��������");
			buttons_BUI[1].setText("�� ����");
			buttons_BUI[2].setText("��� �ʱ�ȭ");
			buttons_BUI[3].setText("��� ����");
			buttons_BUI[4].setText("Ž�� ����");
			for(int i=0; i<=4; i++){
				buttons_BUI[i].setFont(sub);
				buttons_BUI[i].setForeground(Color.WHITE);
			}
		}
	}

	public class showmap extends status {
		Main ASTAR;
		public showmap() {
			Container M = getContentPane();
			// �� ũ�� �޾Ƽ� �׸��� ���� �ƿ����� �߰� �ؾ���
			
			setLayout(null);
			final int sizeX = (int) ((M.getSize().height) * (0.8));
			final int sizeY = (int) ((M.getSize().width) * (0.8));
			int buttons_sizeX = (sizeX / buttons.length);
			int buttons_sizeY = (sizeY / buttons[0].length);
			setSize(sizeX+5, sizeY+5);
			setBackground(Color.DARK_GRAY);
			Color c = Color.DARK_GRAY;
			int l = 0;
			int a = 10;
			int b = 10;
			for (int i = 0; i < buttons.length; i++) {
				for (int j = 0; j < buttons[0].length; j++) {
					buttons[i][j] = new Button('b');
					buttons[i][j].setSize(buttons_sizeX, buttons_sizeY);
					buttons[i][j].setLocation(a, b);
					buttons[i][j].addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							for (int i = 0; i < buttons.length; i++) {
								for (int j = 0; j < buttons[0].length; j++) {
									if (e.getSource() == buttons[i][j]) {
										int blocked = 0;
										switch(Mode){
										case 1:{
											for (int a = 0; a < buttons.length; a++) {
												for (int b = 0; b < buttons[0].length; b++) {
													if(buttons[a][b].status == 's'){
														if(a!=i||b!=j){
														System.out.println("����� 2���̻� �Ұ���");
														blocked = 1;}
														else if(a==i&&b==j){
															System.out.println("����� ������");
															blocked = 1;
															buttons[i][j].status = 'b';
															buttons[i][j].setBackground(Color.DARK_GRAY);
														}else if(buttons[i][j].block){
															System.out.println("�ߺ� ���� �Ұ���. ������ ��õ�");
															break;
														}
														break;
													}
												}
											}if(blocked == 0){
											buttons[i][j].status = 's';
											buttons[i][j].setBackground(Color.green);
											buttons[i][j].block = true;}
											break;
										}
										case 2:{
											for (int a = 0; a < buttons.length; a++) {
												for (int b = 0; b < buttons[0].length; b++) {
													if(buttons[a][b].status == 'e'){
														if(a!=i||b!=j){
															System.out.println("������ 2���̻� �Ұ���");
															blocked = 1;}
															else if(a==i&&b==j){
																System.out.println("������ ������");
																blocked = 1;
																buttons[i][j].status = 'b';
																buttons[i][j].setBackground(Color.DARK_GRAY);
															}else if(buttons[i][j].block){
																System.out.println("�ߺ� ���� �Ұ���. ������ ��õ�");
																break;
															}
															break;
													}
												}
											}
											if(blocked == 0){
												buttons[i][j].status = 'e';
												buttons[i][j].setBackground(Color.red);
												buttons[i][j].block = true;}
											break;
										}
										case 3:{
											for (int a = 0; a < buttons.length; a++) {
												for (int b = 0; b < buttons[0].length; b++) {
													if(!buttons[i][j].block){
													buttons[i][j].setBackground(Color.LIGHT_GRAY);
													buttons[i][j].block = true;}else break;}
													}
											break;
										}
										case 0:{}
										}
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
		}
	}
}