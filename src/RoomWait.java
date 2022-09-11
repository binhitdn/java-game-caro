import java.awt.Color;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;

/**
 *
 * @author Admin
 */
public class RoomWait extends JFrame {
	 private JButton jButton2;
	    private JLabel jLabel1;
	    private JLabel jLabel2;
	    private JLabel jLabel4;
	    private JPanel jPanel1;
    private boolean isOpenning;
    public RoomWait() {
        initComponents();
        this.setTitle("Caro");
        isOpenning = false;
//        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);   
        jLabel4.setVisible(false);
    }
    public void setRoomName(String roomName){
        jLabel1.setText("Phòng "+roomName);
    }
    
    public void setRoomPassword(String password){
        jLabel4.setText(password);
        jLabel4.setVisible(true);
    }
    
    public void showFindedCompetitor(){
        isOpenning = true;
        jLabel2.setText("Đã tìm thấy đối thủ, đang vào phòng");
        jLabel2.setForeground(Color.BLUE);
        jButton2.setVisible(false);
    }
 
    private void initComponents() {
        jPanel1 = new JPanel();
        jLabel1 = new JLabel();
        jLabel4 = new JLabel();
        jLabel2 = new JLabel();
        jButton2 = new JButton();
        jButton2.setText("Thoát");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(Color.CYAN);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Phòng {}");

        jLabel4.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Mật khẩu:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1Layout.setHorizontalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(jPanel1Layout.createSequentialGroup()
        					.addContainerGap()
        					.addComponent(jLabel4, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE))
        				.addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 228, GroupLayout.PREFERRED_SIZE))
        			.addContainerGap(102, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addGap(29)
        			.addComponent(jLabel1)
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addComponent(jLabel4)
        			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1.setLayout(jPanel1Layout);

        jLabel2.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Đang chờ người chơi khác vào phòng");

        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	if(isOpenning) return;
                try {
                    Client.closeView(Client.View.WAITINGROOM);
                    Client.openView(Client.View.HOMEPAGE);
                    Client.threadClient.write("cancel-room,");
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(rootPane, ex.getMessage());
                }
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.TRAILING)
        		.addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, 341, Short.MAX_VALUE)
        		.addGroup(layout.createSequentialGroup()
        			.addComponent(jLabel2, GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(jButton2, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap())
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(layout.createSequentialGroup()
        					.addGap(110)
        					.addComponent(jLabel2)
        					.addContainerGap(33, Short.MAX_VALUE))
        				.addGroup(Alignment.TRAILING, layout.createSequentialGroup()
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(jButton2, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
        					.addGap(25))))
        );
        getContentPane().setLayout(layout);
        pack();
        
    }

 
}