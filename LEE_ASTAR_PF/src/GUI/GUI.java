package GUI;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import Astar.Main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class GUI extends JFrame {

	static int rowdata;
	static int columndata;

	static File textfile;

	public GUI(int row, int column, File text) { // GUI ���� Ŭ����

		Font main = new Font("���� ���", 0, 30);
		Font sub = new Font("���� ���", 0, 15);

		Image img = null;
		try {
			File sourceimage = new File("src/overwatch.png");
			img = ImageIO.read(sourceimage);
		} catch (IOException e) {
			System.out.println("�̹��������� �����ϴ�.");
		} // ������ġ �ΰ� �ҷ����� �κ�
		setIconImage(img);

		JLabel logo = new JLabel(new ImageIcon(img));
		textfile = text;
		rowdata = row;
		columndata = column; // ��Ʈ�ο��� �޾ƿ� ���ϰ� ����� GUI��ü�� ����

		setTitle("A * Algorithm implemented by Java");
		setSize(500, 500);
		setVisible(true);
		Container c = getContentPane();

		c.setBackground(Color.DARK_GRAY);
		setLayout(null);
		add(new showmap());
		add(new BGR());
		add(new RUI());

		logo.setSize(100, 100);
		logo.setLocation(385, 280);
		add(logo);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static class status extends Panel { // ��� �г��� ����ϴ� Ŭ����, �����ؾ� �� �����͸�
												// ����

		static Button buttons[][] = new Button[rowdata][columndata];
		static char[][] Map = new char[rowdata][columndata];

		static JButton buttons_BUI[] = new JButton[4];
		static JButton buttons_BUI2[] = new JButton[4];
		static NumberField speed = new NumberField();
		static int Mode;

		static File text;
		Main main = new Main(buttons);

		public status() {
		}

		public void convertMap() { // ��ư���� �� ���� char�� ��ȯ�Ͽ� Map�� ����
			char[][] temp = new char[rowdata][columndata];
			for (int x = 0; x < buttons.length; x++) {
				for (int y = 0; y < buttons[0].length; y++) {
					switch (buttons[x][y].status) {
					case '.': {
						temp[x][y] = '.';
						break;
					}
					case 'W': {
						temp[x][y] = 'W';
						break;
					}
					case 'S': {
						temp[x][y] = 'S';
						break;
					}
					case 'E': {
						temp[x][y] = 'E';
						break;
					}
					default: {

					}
					}
				}
			}
			Map = temp;
		}

		public void removeRoad() {
			for (int x = 0; x < buttons.length; x++) {
				for (int y = 0; y < buttons[0].length; y++) {
					switch (Map[x][y]) {
					case '-': {
						System.out.println("1");
						Map[x][y] = '.';
						showmap.buttons[x][y].setBackground(Color.darkGray);
						break;
					}
					case '@': {
						System.out.println("2");
						Map[x][y] = '.';
						showmap.buttons[x][y].setBackground(Color.darkGray);
						break;
					}
					}
				}
			}
		}

		public void MapDisable() { // ��ư���� �� ���� ������� ���ϵ��� ����
			for (int r = 0; r < buttons.length; r++) {
				for (int j = 0; j < buttons[0].length; j++) {
					buttons[r][j].setEnabled(false);
				}
			}
		}

		public void MapEnable() { // ��ư���� �� ���� ����� �� �ֵ��� ����
			for (int r = 0; r < buttons.length; r++) {
				for (int j = 0; j < buttons[0].length; j++) {
					buttons[r][j].setEnabled(true);
				}
			}
		}
	}

	public class BGR extends status { // �����, ������, ��ֹ� ���� ������ ������ ����� ����
		public BGR() {
			Font sub = new Font("���� ���", Font.BOLD, 12);
			setBackground(null);
			Container M = getContentPane();
			setSize((int) ((M.getSize().height) * (1.0)), (int) ((M.getSize().width) * (0.08)) + 15);
			setLocation(15, (int) ((M.getSize().height) * (0.8)) + 35);
			setLayout(new GridLayout(2, 2, 15, 5));
			for (int i = 0; i < buttons_BUI.length; i++) {
				buttons_BUI[i] = new JButton("�Ŵ�" + (i + 1));
				buttons_BUI[i].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent a) {
						for (int i = 0; i < buttons_BUI.length; i++) {
							if (a.getSource() == buttons_BUI[i]) { // Mode������ �̿��Ͽ� �������� ��带 �����ϰų� �������� �� ����
								switch (buttons_BUI[i].getText()) {
								case "����� ����": {
									MapEnable();
									buttons_BUI[0].setText("����� ���� ����");
									buttons_BUI[1].setEnabled(false);
									buttons_BUI[2].setEnabled(false);
									buttons_BUI[3].setEnabled(false);
									Mode = 1;
									break;
								}
								case "����� ���� ����": {
									MapDisable();
									buttons_BUI[0].setText("����� ����");
									buttons_BUI[1].setEnabled(true);
									buttons_BUI[2].setEnabled(true);
									buttons_BUI[3].setEnabled(true);
									Mode = 0;
									break;
								}
								case "������ ����": {
									MapEnable();
									buttons_BUI[1].setText("������ ���� ����");
									buttons_BUI[0].setEnabled(false);
									buttons_BUI[2].setEnabled(false);
									buttons_BUI[3].setEnabled(false);
									Mode = 2;
									break;
								}
								case "������ ���� ����": {
									MapDisable();
									buttons_BUI[1].setText("������ ����");
									buttons_BUI[0].setEnabled(true);
									buttons_BUI[2].setEnabled(true);
									buttons_BUI[3].setEnabled(true);
									Mode = 0;
									break;
								}
								case "��ֹ� ����": {
									MapEnable();
									buttons_BUI[2].setText("��ֹ� ���� ����");
									buttons_BUI[0].setEnabled(false);
									buttons_BUI[1].setEnabled(false);
									buttons_BUI[3].setEnabled(false);
									Mode = 3;
									break;
								}
								case "��ֹ� ���� ����": {
									MapDisable();
									buttons_BUI[2].setText("��ֹ� ����");
									buttons_BUI[0].setEnabled(true);
									buttons_BUI[1].setEnabled(true);
									buttons_BUI[3].setEnabled(true);
									Mode = 0;
									break;
								}
								case "������ ����": {
									buttons_BUI2[1].setEnabled(false);
									for (int x = 0; x < 3; x++) {
										buttons_BUI[x].setEnabled(true);
									}
									buttons_BUI[3].setText("������ ����");
									Mode = 0;
									break;
								}
								case "������ ����": {
									convertMap();
									buttons_BUI2[1].setEnabled(true);
									for (int x = 0; x < 3; x++) {
										buttons_BUI[x].setEnabled(false);
									}
									buttons_BUI[3].setText("������ ����");
									buttons_BUI[0].setText("����� ����");
									buttons_BUI[1].setText("������ ����");
									buttons_BUI[2].setText("��ֹ� ����");
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
			for (int x = 0; x <= 3; x++) {
				buttons_BUI[x].setEnabled(false);
			}
			for (int i = 0; i <= 3; i++) {
				buttons_BUI[i].setBorderPainted(false);
				buttons_BUI[i].setFocusPainted(false);
				buttons_BUI[i].setContentAreaFilled(false);
				buttons_BUI[i].setFont(sub);
				buttons_BUI[i].setForeground(Color.ORANGE);
			}
		}
	}

	public class RUI extends status { // �� �м�, Ž�� ����, ����, ���ᰡ �ִ� ��Ʈ�ѷ�

		public void MapClean() {
			text = null;
			for (int r = 0; r < buttons.length; r++) {
				for (int j = 0; j < buttons[0].length; j++) {
					buttons[r][j].status = 'b';
					buttons[r][j].block = false;
					buttons[r][j].setBackground(Color.DARK_GRAY);
				}
			}
		}

		public RUI() {
			setBackground(Color.DARK_GRAY);
			Font sub = new Font("���� ���", Font.BOLD, 12);
			Container M = getContentPane();
			setResizable(false);
			JLabel speedtitle = new JLabel("�ӵ�");
			JButton speedok = new JButton("�ӵ� ����");
			speedtitle.setFont(sub);
			speedok.setFont(sub);
			
			M.add(speed);
			M.add(speedtitle);
			M.add(speedok);
			speed.setSize(60, 20);
			speedtitle.setSize(60, 20);
			speedok.setSize(100, 20);
			speedtitle.setForeground(Color.orange);
			speedok.setForeground(Color.ORANGE);
			speedok.setBackground(Color.DARK_GRAY);
			speedok.setBorderPainted(false);
			speedok.setFocusPainted(false);
			speedok.setContentAreaFilled(false);
			speed.setLocation((int) ((M.getSize().height) * (0.84)) + 35, 210);
			speedtitle.setLocation((int) ((M.getSize().height) * (0.84)), 210);
			speedok.setLocation((int) ((M.getSize().height) * (0.84)) - 5, 235);
			speed.setText("80");
			speed.setForeground(Color.WHITE);
			main.speed = 80;
			speed.setBackground(Color.GRAY);
			speed.setDocument((new JTextFieldLimit(4)));
			speedok.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					try {
						main.speed = Integer.parseInt(speed.getText());
					} catch (NumberFormatException e) {

					}
				}
			});

			setSize((int) ((M.getSize().height) * (0.2)) + 6, (int) ((M.getSize().width) * (0.6) - 30));
			setLocation((int) ((M.getSize().height) * (0.84)), 10);
			setLayout(new GridLayout(6, 1, 0, 15));
			for (int i = 0; i < buttons_BUI2.length; i++) {
				buttons_BUI2[i] = new JButton("�Ŵ�" + (i + 1));
				buttons_BUI2[i].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent a) {
						for (int i = 0; i < buttons_BUI2.length; i++) {
							if (a.getSource() == buttons_BUI2[i]) {
								Mode = 0;
								switch (i) {
								case 0: {
									FileReader fr = null;
									BufferedReader br = null;
									boolean start = false;
									boolean end = false;
									String line = "";
									int pointerx = 0;
									int pointery = 0;
									char pointer;
									try {
										fr = new FileReader(textfile);
										br = new BufferedReader(fr);
										while ((line = br.readLine()) != null) {
											for (int y = 0; y < line.length(); y++) {
												pointer = line.charAt(y);
												if (pointer == '.' || pointer == 'E' || pointer == 'S'
														|| pointer == 'W') {
													if (pointer == '.') {
														buttons[pointery][pointerx].setBackground(Color.DARK_GRAY);
														buttons[pointery][pointerx].block = false;
														buttons[pointery][pointerx].status = '.';
														Map[pointery][pointerx] = '.';
													} else if (pointer == 'S') {
														if (start) {
															JOptionPane.showMessageDialog(M, "������� �� �� �̻� ������", "����",
																	JOptionPane.ERROR_MESSAGE);
															br.close();
															MapClean();
															buttons_BUI2[0].setEnabled(false);
															buttons_BUI2[1].setEnabled(true);
															break;
														} else {
															buttons[pointery][pointerx].setBackground(Color.GREEN);
															buttons[pointery][pointerx].block = true;
															buttons[pointery][pointerx].status = 'S';
															Map[pointery][pointerx] = 'S';
															start = true;
														}
													} else if (pointer == 'E') {
														if (end) {
															JOptionPane.showMessageDialog(M, "�������� �� �� �̻� ������", "����",
																	JOptionPane.ERROR_MESSAGE);
															br.close();
															MapClean();
															buttons_BUI2[0].setEnabled(false);
															buttons_BUI2[1].setEnabled(true);
															break;
														} else {
															buttons[pointery][pointerx].setBackground(Color.RED);
															buttons[pointery][pointerx].block = true;
															buttons[pointery][pointerx].status = 'E';
															Map[pointery][pointerx] = 'E';
															end = true;
														}
													} else if (pointer == 'W') {
														buttons[pointery][pointerx].setBackground(Color.WHITE);
														buttons[pointery][pointerx].block = true;
														buttons[pointery][pointerx].status = 'W';
														Map[pointery][pointerx] = 'W';
													}
													pointerx++;
												} else {
													continue;
												}
											}
											pointery++;
											pointerx = 0;
										}
									} catch (IOException e) {
										e.printStackTrace();
									}
									buttons_BUI[3].setEnabled(true);
									buttons_BUI2[0].setEnabled(false);
									buttons_BUI2[1].setEnabled(true);
									break;
								}
								case 1: {
									boolean start = false;
									boolean end = false;
									for (int r = 0; r < buttons.length; r++) {
										for (int j = 0; j < buttons[0].length; j++) {
											if (buttons[r][j].status == 'S') {
												start = true;
											}
											if (buttons[r][j].status == 'E') {
												end = true;
											}
										}
									}
									if (start && end) {
										main.genMap(Map);
		                                 try {                                 
		                                    main.start();         // �ϴ� �����带 ������ ����
		                                     } catch (Exception e) {                                                                                
		                                       main = null;                                                   
		                                       main = new Main(buttons);
		                                       main.genMap(Map);                              
		                                       System.out.println(speed.getText());	                                    
		                                       if(!speed.getText().equals(null))
		                                    	 try{
		                   						main.speed = Integer.parseInt(speed.getText());}
		                                       catch(NumberFormatException e2){
		                                    	   main.speed = 80; // �ӵ�ĭ�� ����������� �⺻�� ����
		                                       }
		                                       main.start();
		                                     }		                        
		                           } else {
										JOptionPane.showMessageDialog(M, "������̳� �������� �����Ǿ� ���� �ʽ��ϴ�,", "����",
												JOptionPane.ERROR_MESSAGE);
										break;
										// ������̳� ������ ���� �ϳ��� ������ �۵� �Ұ���
									}
									break;
								}
								case 2: {
									JOptionPane.showMessageDialog(M,
											"�����б� �ڷᱸ�� �� �˰��� TA \n\n �˰��� ���� : �̿��� \n GUI ���� : ���� \n ���������� �ٵ� ���� ����ߴ�... ", "������ ����",
											JOptionPane.INFORMATION_MESSAGE);
									break;
								}
								case 3: {
									int result = 0;
									result = JOptionPane.showConfirmDialog(M, "���α׷��� �����Ͻðڽ��ϱ�?", "����",
											JOptionPane.INFORMATION_MESSAGE);
									if (result == JOptionPane.CANCEL_OPTION || result == JOptionPane.CLOSED_OPTION) {
										break;
									}
									if (result == JOptionPane.OK_OPTION) {
										System.exit(1);
									}
								}
								}
							}
						}
					}
				});
				buttons_BUI2[i].setBackground(Color.GRAY);
				add(buttons_BUI2[i]);
			}
			buttons_BUI2[0].setText("�� �м�");
			buttons_BUI2[1].setText("Ž�� ����");
			buttons_BUI2[2].setText("����");
			buttons_BUI2[3].setText("����");
			buttons_BUI2[1].setEnabled(false);
			for (int i = 0; i <= 3; i++) {
				buttons_BUI2[i].setBorderPainted(false);
				buttons_BUI2[i].setFocusPainted(false);
				buttons_BUI2[i].setContentAreaFilled(false);
				buttons_BUI2[i].setFont(sub);
				buttons_BUI2[i].setForeground(Color.ORANGE);
			}
		}
	}

	public class showmap extends status { // ��ư �� ��ü, ������ ����� ����
		public showmap() {

			Container M = getContentPane();
			setLayout(null);
			final int sizeX = (int) ((M.getSize().height) * (0.8));
			final int sizeY = (int) ((M.getSize().width) * (0.8));
			int buttons_sizeX = (sizeX / buttons.length);
			int buttons_sizeY = (sizeY / buttons[0].length);
			setSize(sizeX + 5, sizeY + 5);
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
					buttons[i][j].setEnabled(false);
					buttons[i][j].setBorder(new LineBorder(Color.ORANGE, 1));
					buttons[i][j].addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							for (int i = 0; i < buttons.length; i++) {
								for (int j = 0; j < buttons[0].length; j++) {
									if (e.getSource() == buttons[i][j]) {
										int blocked = 0; // ���� �����Ͽ��� �� ���� ������
															// �߻��� ��� 1�� ����Ǹ�
															// if���� ���� �� ������ ���ѵ�
										switch (Mode) {
										case 1: {
											for (int a = 0; a < buttons.length; a++) {
												for (int b = 0; b < buttons[0].length; b++) {
													if (buttons[a][b].status == 'S') {

														/*
														 * ������̳� �������� 2���� �ɶ� ����
														 * ��ǥ�� ������ ���������� ����� ������
														 * �ν�
														 */
														if (a != i || b != j) {
															System.out.println("����� 2���̻� �Ұ���");
															blocked = 1;
														} else if (a == i && b == j) {
															System.out.println("����� ������");
															blocked = 1;
															buttons[i][j].status = '.';
															buttons[i][j].block = false;
															buttons[i][j].setBackground(Color.DARK_GRAY);
														} else if (buttons[i][j].block) {
															System.out.println("�ߺ� ���� �Ұ���. ������ ��õ�");
															break;
														}
														break;
													}
												}
											}
											if (blocked == 0) {
												buttons[i][j].status = 'S';
												buttons[i][j].setBackground(Color.green);
												buttons[i][j].block = true;
											}
											break;
										}
										case 2: {
											for (int a = 0; a < buttons.length; a++) {
												for (int b = 0; b < buttons[0].length; b++) {
													if (buttons[a][b].status == 'E') {
														if (a != i || b != j) {
															System.out.println("������ 2���̻� �Ұ���");
															blocked = 1;
														} else if (a == i && b == j) {
															System.out.println("������ ������");
															blocked = 1;
															buttons[i][j].status = '.';
															buttons[i][j].setBackground(Color.DARK_GRAY);
															buttons[i][j].block = false;
														} else if (buttons[i][j].block) {
															System.out.println("�ߺ� ���� �Ұ���. ������ ��õ�");
															break;
														}
														break;
													}
												}
											}
											if (blocked == 0) {
												buttons[i][j].status = 'E';
												buttons[i][j].setBackground(Color.red);
												buttons[i][j].block = true;
											}
											break;
										}
										case 3: {
											for (int a = 0; a < buttons.length; a++) {
												for (int b = 0; b < buttons[0].length; b++) {
													if (buttons[a][b].status == 'W') {
														if (a == i && b == j) {
															blocked = 1;
															buttons[i][j].status = '.';
															buttons[i][j].setBackground(Color.DARK_GRAY);
															break;
														}
													}
												}
											}
											if (blocked == 0) {
												buttons[i][j].status = 'W';
												buttons[i][j].setBackground(Color.white);
												buttons[i][j].block = true;
											}
											break;
										}
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