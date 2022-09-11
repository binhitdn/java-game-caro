import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
public class Admin extends javax.swing.JFrame implements Runnable{
    private UserData userData;
    private JButton jButton3;
    private JScrollPane jScrollPane2;
    public static JTextArea jTextArea2;
    private JTextField jTextField1;
    private JTextField jTextField2;
    public Admin() {
        initComponents();
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        jTextArea2.setEditable(false);
        userData = new UserData();
    }

    private void initComponents() {

        jTextField2 = new javax.swing.JTextField();
        jTextField1 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jTextArea2.append("Đã khởi động máy chủ:"+"\n");
        jTextArea2.append("Address:"+"\n");
        jTextArea2.append("IP:"+"\n");
        

        jTextField2.setText("jTextField2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTextField1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1KeyPressed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton3.setText("Phát thông báo");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane2.setViewportView(jTextArea2);

       

        

        

        

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(layout.createSequentialGroup()
        					.addGap(30)
        					.addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, 441, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.UNRELATED)
        					.addComponent(jButton3))
        				.addGroup(Alignment.TRAILING, layout.createSequentialGroup()
        					.addContainerGap()
        					.addComponent(jScrollPane2, GroupLayout.DEFAULT_SIZE, 624, Short.MAX_VALUE)))
        			.addContainerGap())
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 370, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        				.addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jButton3))
        			.addContainerGap(47, Short.MAX_VALUE))
        );
        getContentPane().setLayout(layout);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        sendMessage();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTextField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyPressed
        if(evt.getKeyCode()==10){
            sendMessage();
        }
    }

    

    
    private void sendMessage(){
        String message = jTextField1.getText();
        if(message.length()==0) return;
        String temp = jTextArea2.getText();
        temp+= "Thông báo từ máy chủ : "+message+"\n";
        jTextArea2.setText(temp);
        jTextArea2.setCaretPosition(jTextArea2.getDocument().getLength());
        Server.threadServers.boardCast(-1,"chat-server,Thông báo từ máy chủ : "+ message);
        jTextField1.setText("");
    }
    public void addMessage(String message) {
        String tmp = jTextArea2.getText();
        tmp=tmp+message+"\n";
        jTextArea2.setText(tmp);
        jTextArea2.setCaretPosition(jTextArea2.getDocument().getLength());
    }
    
  

    @Override
    public void run() {
        new Admin().setVisible(true);
    }
}