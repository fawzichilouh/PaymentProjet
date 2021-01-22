/*
  * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetjava;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.SwingConstants;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTabbedPane;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.Font;
import java.awt.Dimension;

/**
 *
 * @author amine
 */
public class VerificationPayment extends javax.swing.JFrame {
	
    PaymentController controller=new PaymentController(this);

    /**
     * Creates new form VerificationPayment
     */
    public VerificationPayment() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel1.setBounds(0, 11, 607, 35);
        jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel2 = new javax.swing.JLabel();
        jLabel2.setBounds(42, 108, 312, 62);
        jLabel3 = new javax.swing.JLabel();
        jLabel3.setBounds(372, 109, 130, 62);
        verification = new javax.swing.JTextField();
        verification.setBounds(134, 196, 153, 36);
        btn_verify = new javax.swing.JButton();
        btn_verify.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		
        	}
        });
        // set event handler
        btn_verify.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		final String  regex = "[0-9]{4}"; 
     		     Pattern pattern = Pattern.compile(regex);
     		     Matcher matcher = pattern.matcher(verification.getText());
     		     
        		if(verification.getText().equals("")|| verification.getText().equals("Code verification"))
        	     	JOptionPane.showMessageDialog(jPanel1,"Code empty" ,"Error",JOptionPane.ERROR_MESSAGE);
        		else if(!matcher.matches())
        	     	JOptionPane.showMessageDialog(jPanel1,"Invalide code !" ,"Error",JOptionPane.ERROR_MESSAGE);

        			
        		else {
        			try {
						controller.verifyToken(Integer.parseInt(verification.getText()));
					} catch (NumberFormatException | ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
        			
        		}
        	}
        });
        btn_verify.setAction(action);
        btn_verify.setBounds(325, 196, 128, 33);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 102, 255));
        jLabel1.setText("Verification du paiement");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("A  Code has been sent to  your number phone : ");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        
        /******************
         * set Phone field 
         ******************/
        if(controller.retrievePhone()!=null) {
            jLabel3.setText("" + controller.retrievePhone());
        }else{
            jLabel3.setText("" + my_Session.phoneStatic);



        }

        verification.setFont(new java.awt.Font("Open Sans", 0, 12)); // NOI18N
        verification.setForeground(new java.awt.Color(149, 165, 166));
        verification.setText("Code verification");
        verification.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        verification.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                verificationMouseClicked(evt);
            }
        });

        btn_verify.setBackground(new java.awt.Color(41, 128, 185));
        btn_verify.setFont(new java.awt.Font("Open Sans", 0, 18)); // NOI18N
        btn_verify.setForeground(new java.awt.Color(255, 255, 255));
        btn_verify.setText("Verify code");
        btn_verify.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        
        JLabel lblNewLabel = new JLabel("BoukiPay \u00A9 Copyright 2021");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Open Sans", Font.PLAIN, 10));
        lblNewLabel.setBounds(0, 279, 597, 33);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, 609, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, 322, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        getContentPane().setLayout(layout);
        jPanel1.setLayout(null);
        jPanel1.add(jLabel2);
        jPanel1.add(jLabel3);
        jPanel1.add(verification);
        jPanel1.add(btn_verify);
        jPanel1.add(jLabel1);
        jPanel1.add(lblNewLabel);

        setSize(new Dimension(623, 351));
        setLocationRelativeTo(null);
    }// </editor-fold>                        

    private void verificationMouseClicked(java.awt.event.MouseEvent evt) {                                          
        // TODO add your handling code here:
         if(verification.getText().equals("Code verification")){
            verification.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(9,132, 227), 1, true));

            verification.setText("");
            verification.setForeground(new java.awt.Color(0, 0, 0));
        }
    }                                         

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VerificationPayment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VerificationPayment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VerificationPayment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VerificationPayment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VerificationPayment().setVisible(true);
            }
        });
    }
    
    public void setErrorMessage(String errorMessage) {
        // lblErrorMessage.setText(errorMessage);
     	JOptionPane.showMessageDialog(jPanel1, errorMessage,"Error",JOptionPane.WARNING_MESSAGE);
     }
    
    public void setSuccesMessage(String succesMessage) {
        // lblErrorMessage.setText(errorMessage);
     	JOptionPane.showMessageDialog(jPanel1,succesMessage ,"Succes",JOptionPane.INFORMATION_MESSAGE);
     }

    // Variables declaration - do not modify                     
    private javax.swing.JButton btn_verify;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField verification;
    private final Action action = new SwingAction();
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
