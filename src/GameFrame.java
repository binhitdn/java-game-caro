import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.GroupLayout.Alignment;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import javax.swing.border.TitledBorder;
import javax.swing.text.AttributeSet.ColorAttribute;
import javax.swing.border.LineBorder;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class GameFrame extends JFrame {
	private User competitor;
	private Timer timer;
    private Integer second, minute;
    
    private int numberOfMatch;
    private String normalItem[];
    private String winItem[];
    private String iconItem[];
    private String preItem[];
    
    private JButton preButton;
    private int userWin;
    private int competitorWin;
    private Thread sendThread;
    private boolean isSending;
    private Thread listenThread;
    private boolean isListening;
    private String competitorIP;
    private JLabel lblNewLabel_7;
    private JLabel lblNewLabel_8;
    private JLabel lblNewLabel_9;
    private JTextArea textArea_1,textArea;
    private boolean denluot;
    JLabel lblNewLabel_3_1_1,lblNewLabel_3_1;
    private JLabel lblNewLabel_4;
    JLabel lblNewLabel_2_1_1_2;
    JLabel lblNewLabel_2_1_1;
    JLabel lblNewLabel_2_1_2;
    JLabel lblNewLabel,lblNewLabel_2_1;
    JPanel panel_7_1;
    JLabel lblNewLabel_5,lblNewLabel_5_1;
    
    

	private JPanel contentPane;
	private Caro caro = caro = new Caro();

	public GameFrame(User competitor, int room_ID, int isStart, String competitorIP) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setSize(900,600);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		
	
		
		
		
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout(0, 0));
		contentPane.add(panel);
		
		
		panel.add(caro);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.WEST);
		
		JPanel panel_2 = new JPanel();
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 284, Short.MAX_VALUE)
					.addGap(5))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE))
		);
		
		lblNewLabel = new JLabel("{Ph\u00F2ng}");
		lblNewLabel.setFont(new Font("Adobe Garamond Pro Bold", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel panel_3_1 = new JPanel();
		panel_3_1.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 255), 3), "\u0110\u1ED1i th\u1EE7", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLUE));
		
		JPanel panel_5 = new JPanel();
		
		JPanel panel_7 = new JPanel();
		GroupLayout gl_panel_3_1 = new GroupLayout(panel_3_1);
		gl_panel_3_1.setHorizontalGroup(
			gl_panel_3_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_7, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
					.addComponent(panel_5, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_panel_3_1.setVerticalGroup(
			gl_panel_3_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3_1.createSequentialGroup()
					.addComponent(panel_7, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(22))
				.addGroup(gl_panel_3_1.createSequentialGroup()
					.addComponent(panel_5, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		
		JLabel lblNewLabel_1_1 = new JLabel("New label");
		lblNewLabel_1_1.setIcon(new ImageIcon("src/"+competitor.getAvatar()+".jpg"));
		GroupLayout gl_panel_7 = new GroupLayout(panel_7);
		gl_panel_7.setHorizontalGroup(
			gl_panel_7.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_7.createSequentialGroup()
					.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(31, Short.MAX_VALUE))
		);
		gl_panel_7.setVerticalGroup(
			gl_panel_7.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_7.createSequentialGroup()
					.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(11, Short.MAX_VALUE))
		);
		panel_7.setLayout(gl_panel_7);
		panel_5.setLayout(new GridLayout(0, 1, 0, 0));
		
		lblNewLabel_2_1 = new JLabel("T\u00EAn T\u00E0i Kho\u1EA3n");
		panel_5.add(lblNewLabel_2_1);
		
		lblNewLabel_3_1 = new JLabel("Tổng Số Trận");
		panel_5.add(lblNewLabel_3_1);
		
		lblNewLabel_2_1_1 = new JLabel("Số Trận Thắng");
		panel_5.add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("Số Trận Hòa");
		panel_5.add(lblNewLabel_2_1_1_1);
		
		JLabel lblNewLabel_2_1_1_1_1 = new JLabel("Rank:");
		panel_5.add(lblNewLabel_2_1_1_1_1);
		
		JLabel lblNewLabel_2_1_1_1_1_1 = new JLabel("Top Server");
		panel_5.add(lblNewLabel_2_1_1_1_1_1);
		panel_3_1.setLayout(gl_panel_3_1);
		
		JPanel panel_4 = new JPanel();
		
		JPanel panel_3_1_1 = new JPanel();
		panel_3_1_1.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 255), 3), " B\u1EA1n", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 255)));
		
		panel_7_1 = new JPanel();
		
		JLabel lblNewLabel_1_1_1 = new JLabel("New label");
		lblNewLabel_1_1_1.setIcon(new ImageIcon("src/"+Client.user.getAvatar()+".jpg"));
		GroupLayout gl_panel_7_1 = new GroupLayout(panel_7_1);
		gl_panel_7_1.setHorizontalGroup(
			gl_panel_7_1.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_7_1.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(lblNewLabel_1_1_1, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_panel_7_1.setVerticalGroup(
			gl_panel_7_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_7_1.createSequentialGroup()
					.addComponent(lblNewLabel_1_1_1, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(11, Short.MAX_VALUE))
		);
		panel_7_1.setLayout(gl_panel_7_1);
		
		JPanel panel_5_1 = new JPanel();
		panel_5_1.setLayout(new GridLayout(0, 1, 0, 0));
		
		lblNewLabel_2_1_2 = new JLabel("Tên Tài Khoản");
		panel_5_1.add(lblNewLabel_2_1_2);
		
		lblNewLabel_3_1_1 = new JLabel("Tổng Số Trận");
		panel_5_1.add(lblNewLabel_3_1_1);
		
		lblNewLabel_2_1_1_2 = new JLabel("Số Trận Thắng");
		panel_5_1.add(lblNewLabel_2_1_1_2);
		
		JLabel lblNewLabel_2_1_1_1_2 = new JLabel("Số Trận Hòa");
		panel_5_1.add(lblNewLabel_2_1_1_1_2);
		
		JLabel lblNewLabel_2_1_1_1_1_2 = new JLabel("Rank:");
		panel_5_1.add(lblNewLabel_2_1_1_1_1_2);
		
		JLabel lblNewLabel_2_1_1_1_1_1_1 = new JLabel("Top Server");
		panel_5_1.add(lblNewLabel_2_1_1_1_1_1_1);
		GroupLayout gl_panel_3_1_1 = new GroupLayout(panel_3_1_1);
		gl_panel_3_1_1.setHorizontalGroup(
			gl_panel_3_1_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3_1_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_7_1, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(panel_5_1, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(14, Short.MAX_VALUE))
		);
		gl_panel_3_1_1.setVerticalGroup(
			gl_panel_3_1_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3_1_1.createSequentialGroup()
					.addComponent(panel_7_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(22))
				.addGroup(gl_panel_3_1_1.createSequentialGroup()
					.addComponent(panel_5_1, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		panel_3_1_1.setLayout(gl_panel_3_1_1);
		
		JPanel panel_3 = new JPanel();
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, 264, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(19, Short.MAX_VALUE))
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_3, GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(Alignment.TRAILING, gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel_3_1_1, GroupLayout.PREFERRED_SIZE, 264, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_3_1, 0, 0, Short.MAX_VALUE))
					.addGap(19))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_3_1_1, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_3_1, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_3, GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		JScrollPane scrollPane = new JScrollPane();
		
		textArea = new JTextArea();
		
		JButton btnNewButton = new JButton("Gửi");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
		            try {
		                if (textArea.getText().isEmpty()) {
		                    return;
		                }
		                String temp = textArea_1.getText();
		                temp += "Tôi: " + textArea.getText() + "\n";
		                textArea_1.setText(temp);
		                Client.threadClient.write("chat," + textArea.getText());
		                textArea.setText("");
		                textArea_1.setCaretPosition(textArea_1.getDocument().getLength());
		            } catch (IOException ex) {
		                JOptionPane.showMessageDialog(rootPane, ex.getMessage());
		            }
		        }
			
		});
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addContainerGap()
					.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 186, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
				.addComponent(scrollPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)
		);
		gl_panel_3.setVerticalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_3.createSequentialGroup()
					.addGap(5)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_3.createParallelGroup(Alignment.BASELINE)
						.addComponent(textArea, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton)))
		);
		
		textArea_1 = new JTextArea();
		textArea_1.setEditable(false);
		textArea_1.setDisabledTextColor(Color.BLACK);
		scrollPane.setViewportView(textArea_1);
		panel_3.setLayout(gl_panel_3);
		
		lblNewLabel_4 = new JLabel("T\u1EC9 s\u1ED1");
		
		lblNewLabel_5 = new JLabel("anhcaro");
		
		lblNewLabel_7 = new JLabel("Th\u1EDDi gian");
		
		lblNewLabel_8 = new JLabel("Đến lượt bạn");
		
		lblNewLabel_9 = new JLabel("Đến lượt đối thủ");
		
		lblNewLabel_5_1 = new JLabel("anhcaro");
		
		JButton btnNewButton_1 = new JButton("Cầu hòa");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
		            int res = JOptionPane.showConfirmDialog(rootPane, "Bạn có thực sự muốn cầu hòa ván chơi này", "Yêu cầu cầu hòa", JOptionPane.YES_NO_OPTION);
		            if (res == JOptionPane.YES_OPTION) {
		                Client.threadClient.write("draw-request,");
		                timer.stop();
		                setEnableButton(false);
		                Client.openView(Client.View.GAMENOTICE, "Yêu cầu hòa", "Đang chờ phản hồi từ đối thủ");
		            }
		        } catch (IOException ex) {
		            JOptionPane.showMessageDialog(rootPane, ex.getMessage());
		        }
			}
		});
		btnNewButton_1.setBackground(Color.BLACK);
		GroupLayout gl_panel_4 = new GroupLayout(panel_4);
		gl_panel_4.setHorizontalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_panel_4.createSequentialGroup()
							.addGap(10)
							.addComponent(lblNewLabel_5)
							.addPreferredGap(ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
							.addComponent(btnNewButton_1)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblNewLabel_5_1)
							.addGap(53))
						.addGroup(gl_panel_4.createSequentialGroup()
							.addGroup(gl_panel_4.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblNewLabel_8, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_panel_4.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_panel_4.createSequentialGroup()
									.addGap(72)
									.addComponent(lblNewLabel_7, GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE))
								.addGroup(gl_panel_4.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblNewLabel_9, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)))
							.addContainerGap())))
		);
		gl_panel_4.setVerticalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_4.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_4)
						.addComponent(lblNewLabel_7))
					.addGap(18)
					.addGroup(gl_panel_4.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_8)
						.addComponent(lblNewLabel_9))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_4.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel_4.createSequentialGroup()
							.addGroup(gl_panel_4.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_5, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_5_1, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
							.addContainerGap(22, Short.MAX_VALUE))
						.addGroup(gl_panel_4.createSequentialGroup()
							.addComponent(btnNewButton_1)
							.addContainerGap())))
		);
		panel_4.setLayout(gl_panel_4);
		panel_2.setLayout(gl_panel_2);
		panel_1.setLayout(gl_panel_1);
		
		
		
		lblNewLabel_2_1_2.setText(Client.user.getNickname());
		lblNewLabel_3_1_1.setText("Số ván: "+Integer.toString(Client.user.getNumberOfGame()));
		lblNewLabel_2_1_1_2.setText("Thắng: "+Integer.toString(Client.user.getNumberOfwin()));
		
        lblNewLabel.setText("Phòng: " + room_ID);
        
        lblNewLabel_2_1.setText(competitor.getNickname());
        lblNewLabel_3_1.setText("Số ván: "+Integer.toString(competitor.getNumberOfGame()));
        lblNewLabel_2_1_1.setText("Thắng: "+ Integer.toString(competitor.getNumberOfwin()));
//        jButton3.setToolTipText("Xem thông tin đối thủ");
		
		 pack();
	        numberOfMatch = isStart;
	        this.competitor = competitor;
	        this.competitorIP = competitorIP;
	        //
	        isSending = false;
	        isListening = false;
	        
	        //init score
	        userWin = 0;
	        competitorWin = 0;
	        
	        
	     
	        setupButton();
		
		
		
		
		timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String temp = minute.toString();
                String temp1 = second.toString();
                if (temp.length() == 1) {
                    temp = "0" + temp;
                }
                if (temp1.length() == 1) {
                    temp1 = "0" + temp1;
                }
                if (second == 0) {
                	lblNewLabel_7.setText("Thời Gian:" + temp + ":" + temp1);
                    second = 60;
                    minute = 0;
                    try {
                        Client.openView(Client.View.GAMECLIENT, "Bạn đã thua do quá thời gian", "Đang thiết lập ván chơi mới");
//                        increaseWinMatchToCompetitor();
                        Client.threadClient.write("lose,");
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(rootPane, ex.getMessage());
                    }
                    
                } else {
                	lblNewLabel_7.setText("Thời Gian:" + temp + ":" + temp1);
                    second--;
                }

            }

        });
		this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
//                exitGame();
            }
        });
		
	}
	
public void newgame() {
	caro.reset();
	ImageIcon iconX = new ImageIcon("X caro.jpg");
	ImageIcon iconY = new ImageIcon("Y caro.jpg");
	
	
        
        if (numberOfMatch % 2 == 0) {
            JOptionPane.showMessageDialog(rootPane, "Đến lượt bạn đi trước");
            startTimer();
            displayUserTurn();
            lblNewLabel_7.setVisible(true);
            denluot = true;
            lblNewLabel_5.setIcon(iconX);
            lblNewLabel_5_1.setIcon(iconY);
        } else {
            JOptionPane.showMessageDialog(rootPane, "Đối thủ đi trước");
            displayCompetitorTurn();
            denluot = false;
            lblNewLabel_5.setIcon(iconX);
            lblNewLabel_5_1.setIcon(iconY);
        }
        
//        setEnableButton(true);
        if(numberOfMatch % 2 != 0){
//            blockgame();
        }
        
       
        numberOfMatch++;
    }
public void startTimer(){
	lblNewLabel_7.setVisible(true);
    second = 60;
    minute = 0;
    timer.start();
}
public void displayCompetitorTurn() {
	lblNewLabel_7.setVisible(false);
	lblNewLabel_9.setVisible(true);
    
	lblNewLabel_8.setVisible(false);
   
}
public void displayUserTurn(){
	lblNewLabel_7.setVisible(false);
    lblNewLabel_9.setVisible(false);
    
    lblNewLabel_8.setVisible(true);
   
}
int not(int i) {
    if (i == 1) {
        return 0;
    }
    if (i == 0) {
        return 1;
    }
    return 0;
}

void setupButton() {
    for (int i = 0; i < 18; i++) {
        for (int j = 0; j < 18; j++) {
            final int a = i, b = j;

            caro.buttons[a][b].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(denluot==true &&caro.tick[a][b]==false) {
                    	try {
                        	ImageIcon icon;
                        	if(numberOfMatch % 2 == 0) {
                        		icon = new ImageIcon("O caro.jpg");
                            } else {
                            	icon = new ImageIcon("X caro.jpg");
                            }
                        	 
                           Image img = icon.getImage();
                           Image newimg = img.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
                           icon = new ImageIcon(newimg);
                           caro.buttons[a][b].setIcon(icon);
                           caro.tick[a][b] = true;
                           Client.threadClient.write("caro," + a + "," + b);
                           if(numberOfMatch % 2 == 0) {
                        	   caro.buttons[a][b].setName("O");
                           } else {
                        	   caro.buttons[a][b].setName("X");
                           }
                       
                            second = 60;
                            minute = 0;
                   
//                            caro.buttons[a][b].setEnabled(false);
                            denluot=false;
                            try {
                                if (checkWin(a, b)) {
                                    //Xử lý khi người chơi này thắng
//                                    setEnableButton(false);
                                    increaseWinMatchToUser();
                                    Client.openView(Client.View.GAMENOTICE,"Bạn đã thắng","Đang thiết lập ván chơi mới");
                                    Client.threadClient.write("win,"+a+","+b);
                                   
                                }
                                else{ 
                                    Client.threadClient.write("caro," + a + "," + b);
                                    displayCompetitorTurn();
                                    
                                }
//                                setEnableButton(false);
                                timer.stop();
                            } catch (Exception ie) {
                                ie.printStackTrace();
                            }
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(rootPane, ex.getMessage());
                        }
                    }
                }
            });
//            caro.buttons[a][b].addMouseListener(new java.awt.event.MouseAdapter() {
//                public void mouseEntered(java.awt.event.MouseEvent evt) {
//                    if(caro.buttons[a][b].isEnabled()) {
//                    	caro.buttons[a][b].setBackground(Color.GREEN);
//                    	caro.buttons[a][b].setIcon(new ImageIcon(normalItem[not(numberOfMatch % 2)]));
//                    }
//                }
//                public void mouseExited(java.awt.event.MouseEvent evt) {
//                    if(caro.buttons[a][b].isEnabled()){
//                    	caro.buttons[a][b].setBackground(null);
//                    	caro.buttons[a][b].setIcon(new ImageIcon("assets/image/blank.jpg"));
//                    }
//                }
//            });
        }
    }
}
public boolean checkWin(int i, int j) {
    int d = 0, k = i, h;
    
    while (k < 18 && (caro.buttons[k][j].getName() == caro.buttons[i][j].getName())) {
      d++;
      k++;

    }
    k = i - 1;
    while (k > 0 && caro.buttons[k][j].getName() == caro.buttons[i][j].getName()) {
      d++;
      k--;
    }
    if (d > 4) return true;
    d = 0;
    h = j;
   
    while (h < 18 && (caro.buttons[i][h].getName() == caro.buttons[i][j].getName())) {
      d++;
      h++;
    }
    h = j - 1;
    while (h > 0 && (caro.buttons[i][h].getName() == caro.buttons[i][j].getName())) {
      d++;
      h--;
    }
    if (d > 4) return true;
    
    h = i;
    k = j;
    d = 0;
    while (h < 18 && k < 18 && (caro.buttons[i][j].getName() == caro.buttons[h][k].getName())) {
      d++;
      h++;
      k++;
    }
    h = i - 1;
    k = j - 1;
    while (h > 0 && k > 0 && (caro.buttons[i][j].getName() == caro.buttons[h][k].getName())) {
      d++;
      h--;
      k--;
    }
    if (d > 4) return true;
    h = i;
    k = j;
    d = 0;
    while (h < 18 && k > 0 && (caro.buttons[i][j].getName() == caro.buttons[h][k].getName())) {
      d++;
      h++;
      k--;
    }
    h = i - 1;
    k = j + 1;
    while (h > 0 && k < 18 && (caro.buttons[i][j].getName() == caro.buttons[h][k].getName())) {
      d++;
      h--;
      k++;
    }
    if (d > 4) return true;
    
    return false;
  }
public void addCompetitorMove(String x, String y){
    displayUserTurn();
    startTimer();
    setEnableButton(true);
    caro(x, y);
    denluot=true;
}
public void caro(String x, String y) {
    int xx, yy;
    xx = Integer.parseInt(x);
    yy = Integer.parseInt(y);
    ImageIcon icon;
	if(!(numberOfMatch % 2 == 0)) {
		icon = new ImageIcon("O caro.jpg");
    } else {
    	icon = new ImageIcon("X caro.jpg");
    }
	 
    

    	Image img = icon.getImage();
    	   Image newimg = img.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
    	   icon = new ImageIcon(newimg);
    	   caro.buttons[xx][yy].setIcon(icon);
    	   caro.tick[xx][yy] = true;
    	   
    	   if(!(numberOfMatch % 2 == 0)) {
    		   caro.buttons[xx][yy].setName("O");
    	   } else {
    		   caro.buttons[xx][yy].setName("X");
    	   }

    
    
    	   if(checkWin(xx,yy)){
               timer.stop();
               increaseWinMatchToCompetitor();
               Client.openView(Client.View.GAMENOTICE,"Bạn đã thua","Đang thiết lập ván chơi mới");
              
           }
}
public void setEnableButton(boolean b) {
    for (int i = 0; i < 18; i++) {
        for (int j = 0; j < 18; j++) {
           
                caro.buttons[i][j].setEnabled(b);
            
        }
    }
}
public void stopTimer(){
    timer.stop();
}
public void updateNumberOfGame(){
    competitor.setNumberOfGame(competitor.getNumberOfGame() + 1);
    lblNewLabel_3_1.setText(Integer.toString(competitor.getNumberOfGame()));
    Client.user.setNumberOfGame(Client.user.getNumberOfGame() + 1);
    lblNewLabel_3_1_1.setText(Integer.toString(Client.user.getNumberOfGame()));
}
public void increaseWinMatchToUser(){
    Client.user.setNumberOfwin(Client.user.getNumberOfwin()+1);
    lblNewLabel_2_1_1_2.setText(""+Client.user.getNumberOfwin());
    userWin++;
    lblNewLabel_4.setText("Tỉ số: "+userWin+"-"+competitorWin);
    String tmp = textArea_1.getText();
    tmp += "--Bạn đã thắng, tỉ số hiện tại là "+userWin+"-"+competitorWin+"--\n";
    textArea_1.setText(tmp);
    textArea_1.setCaretPosition(textArea_1.getDocument().getLength());
}
public void increaseWinMatchToCompetitor(){
    competitor.setNumberOfwin(competitor.getNumberOfwin()+1);
    lblNewLabel_2_1_1.setText(""+competitor.getNumberOfwin());
    competitorWin++;
    lblNewLabel_4.setText("Tỉ số: "+userWin+"-"+competitorWin);
    String tmp = textArea_1.getText();
    tmp += "--Bạn đã thua, tỉ số hiện tại là "+userWin+"-"+competitorWin+"--\n";
    textArea_1.setText(tmp);
    textArea_1.setCaretPosition(textArea_1.getDocument().getLength());
}
public void stopAllThread(){
    timer.stop();
 

}

}
