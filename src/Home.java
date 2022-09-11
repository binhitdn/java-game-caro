import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.BoxLayout;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.TitledBorder;

public class Home extends JFrame {
	JLabel lblNewLabel,lblNewLabel_1,lblNewLabel_2,lblNewLabel_3,lblNewLabel_4,lblNewLabel_5,lblNewLabel_6,lblNewLabel_7,lblNewLabel_8;
	JTextArea textArea;
	JTextArea textArea_1;
	private JPanel contentPane;
	public Home() {
		 this.setTitle("Trang Chủ - Cờ Caro");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 637, 365);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		setResizable(false);
		
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.YELLOW);
		panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 255), 4), "Th\u00F4ng tin c\u00E1 nh\u00E2n", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLUE));
		contentPane.add(panel, BorderLayout.WEST);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(Color.MAGENTA, 3));
		panel_1.setBackground(Color.CYAN);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 271, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(14, Short.MAX_VALUE))
		);
		
		lblNewLabel = new JLabel("");
		
		lblNewLabel_1 = new JLabel("{TenDangNhap}");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		
		lblNewLabel_2 = new JLabel("{\u0110\u00E3 ch\u01A1i}");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		
		lblNewLabel_3 = new JLabel("{Th\u1EAFng}");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		
		lblNewLabel_4 = new JLabel("{H\u00F2a}");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		
		lblNewLabel_5 = new JLabel("{Thua}");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		
		lblNewLabel_7 = new JLabel("{\u0110i\u1EC3m}");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblNewLabel_8 = new JLabel("{Th\u1EE9 h\u1EA1ng}");
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setText(Client.user.getNickname());
		lblNewLabel_3.setText("Số trận thắng: "+Integer.toString(Client.user.getNumberOfwin()));
		lblNewLabel_2.setText("Tổng Số Trận: "+Integer.toString(Client.user.getNumberOfGame()) );
		lblNewLabel.setIcon(new ImageIcon("src/"+Client.user.getAvatar()+".jpg"));
//        jButton10.setIcon(new ImageIcon("assets/image/send2.png"));
//        jTextArea1.setEditable(false);
//        if(Client.user.getNumberOfGame()==0){
//            jLabel14.setText("-");
//        }
//        else{
//            jLabel14.setText(String.format("%.2f", (float)Client.user.getNumberOfwin()/Client.user.getNumberOfGame()*100)+"%");
//        }
//        jLabel16.setText(""+Client.user.getNumberOfDraw());
//        jLabel10.setText(""+(Client.user.getNumberOfGame()+Client.user.getNumberOfwin()*10));
//        jLabel12.setText(""+Client.user.getRank());
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(Alignment.LEADING, gl_panel_1.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNewLabel_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGroup(Alignment.LEADING, gl_panel_1.createSequentialGroup()
							.addGap(36)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
								.addComponent(lblNewLabel_4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblNewLabel_3, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
								.addComponent(lblNewLabel_5, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblNewLabel_7, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblNewLabel_8, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
						.addGroup(Alignment.LEADING, gl_panel_1.createSequentialGroup()
							.addGap(45)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(53, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(13)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblNewLabel_1)
					.addGap(10)
					.addComponent(lblNewLabel_2)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblNewLabel_3)
					.addGap(10)
					.addComponent(lblNewLabel_4)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_5)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_7)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_8)
					.addContainerGap(11, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		panel.setLayout(gl_panel);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.CYAN);
		panel_2.add(panel_4, BorderLayout.CENTER);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(Color.CYAN);
		
		JLabel lblNewLabel_9 = new JLabel("Chat Toàn Server");
		lblNewLabel_9.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
		GroupLayout gl_panel_4 = new GroupLayout(panel_4);
		gl_panel_4.setHorizontalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_4.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNewLabel_9))
						.addGroup(gl_panel_4.createParallelGroup(Alignment.TRAILING, false)
							.addGroup(Alignment.LEADING, gl_panel_4.createSequentialGroup()
								.addContainerGap()
								.addComponent(panel_5, 0, 0, Short.MAX_VALUE))
							.addGroup(Alignment.LEADING, gl_panel_4.createSequentialGroup()
								.addGap(10)
								.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE))))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panel_4.setVerticalGroup(
			gl_panel_4.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addGap(4)
					.addComponent(lblNewLabel_9, GroupLayout.DEFAULT_SIZE, 16, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_5, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
					.addGap(15))
		);
		
		textArea = new JTextArea();
		textArea.setEnabled(false);
		scrollPane.setViewportView(textArea);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		
		JButton btnNewButton_6 = new JButton("Gửi");
		btnNewButton_6.setBackground(Color.BLACK);
		btnNewButton_6.setForeground(Color.WHITE);
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sendMessage();
			}
		});
		GroupLayout gl_panel_5 = new GroupLayout(panel_5);
		gl_panel_5.setHorizontalGroup(
			gl_panel_5.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_5.createSequentialGroup()
					.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 274, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnNewButton_6, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panel_5.setVerticalGroup(
			gl_panel_5.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_5.createParallelGroup(Alignment.BASELINE)
					.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
					.addComponent(btnNewButton_6, GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE))
		);
		
		textArea_1 = new JTextArea();
		scrollPane_1.setViewportView(textArea_1);
		panel_5.setLayout(gl_panel_5);
		panel_4.setLayout(gl_panel_4);
		 textArea_1.addKeyListener(new java.awt.event.KeyAdapter() {
		        public void keyPressed(java.awt.event.KeyEvent evt) {
		        	if(evt.getKeyCode() == 10){
		                sendMessage();
		            }
		        }
		    });
		 textArea_1.setDisabledTextColor(Color.BLACK);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(Color.WHITE);
		panel_2.add(panel_6, BorderLayout.NORTH);
		panel_6.setLayout(new BoxLayout(panel_6, BoxLayout.X_AXIS));
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.CYAN);
		panel_3.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 5), "Ch\u1EE9c n\u0103ng", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_6.add(panel_3);
		panel_3.setLayout(new GridLayout(0, 3, 0, 5));
		
		JButton btnNewButton_1 = new JButton("T\u00ECm tr\u1EADn");
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBackground(Color.BLACK);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Client.closeView(Client.View.HOMEPAGE);
		        Client.openView(Client.View.FINDROOM);
			}
		});
		panel_3.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("T\u1EA1o Ph\u00F2ng");
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.setBackground(Color.BLACK);
		btnNewButton_2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

		        int res = JOptionPane.showConfirmDialog(rootPane, "Bạn có muốn đặt mật khẩu cho phòng không?", "Tạo phòng", JOptionPane.YES_NO_OPTION);
		        if(res==JOptionPane.YES_OPTION){
		            Client.closeView(Client.View.HOMEPAGE);
		            Client.openView(Client.View.CREATEROOMPASSWORD);
		        }
		        else if(res==JOptionPane.NO_OPTION){
		            try {
		            Client.threadClient.write("create-room,");
		            Client.closeView(Client.View.HOMEPAGE);
		        } catch (IOException ex) {
		            JOptionPane.showMessageDialog(rootPane, ex.getMessage());
		        }
		        } 
				
			}
			
		   
		});
		panel_3.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("T\u00ECm Ph\u00F2ng");
		btnNewButton_3.setBackground(Color.BLACK);
		btnNewButton_3.setForeground(Color.WHITE);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_3.add(btnNewButton_3);
		
		JButton btnNewButton = new JButton("B\u1EA3ng x\u1EBFp h\u1EA1ng");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.BLACK);
		panel_3.add(btnNewButton);
		
		JButton btnNewButton_4 = new JButton("\u0110\u0103ng xu\u1EA5t");
		btnNewButton_4.setBackground(Color.BLACK);
		btnNewButton_4.setForeground(Color.WHITE);
		panel_3.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Tho\u00E1t");
		btnNewButton_5.setForeground(Color.WHITE);
		btnNewButton_5.setBackground(Color.BLACK);
		panel_3.add(btnNewButton_5);
	}
	private void sendMessage(){
        try {
            if (textArea_1.getText().isEmpty()) {
                throw new Exception("Vui lòng nhập nội dung tin nhắn");
            }
            String temp = textArea.getText();
            temp += "Tôi: " + textArea.getText() + "\n";
            textArea.setText(temp);
            Client.threadClient.write("chat-server," + textArea_1.getText());
            textArea_1.setText("");
            textArea.setCaretPosition(textArea.getDocument().getLength());
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage());
        }
    }
    /**
     * @param args the command line arguments
     */
    public void addMessage(String message){
        String temp = textArea.getText();
        temp+=message+"\n";
        textArea.setText(temp);
        textArea.setCaretPosition(textArea.getDocument().getLength());
    }
   
}
