import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.Box;

public class WindowBox extends Frame implements ActionListener{
		Box baseBox,box1,box2;
		TextField tf1,tf2;
		Button button1;
		Button button2;
		static String number1;
		String number2;
		WindowBox(String s){    //���췽��
			super(s);
		    tf1 = new TextField(6);
		    tf2 = new TextField(6);
			box1= Box.createVerticalBox();
			box1.add(new Label("��������Ŀ���")); //���뿨��
			box1.add(Box.createVerticalStrut(8));
			box1.add(new Label("�������������"));//��������
			box2=Box.createVerticalBox();
			box2.add(tf1);
			
			box2.add(Box.createVerticalStrut(8));
			box2.add(tf2);
			
			baseBox=Box.createHorizontalBox();
			baseBox.add(box1);
			baseBox.add(Box.createHorizontalStrut(10));
			baseBox.add(box2);
			add(baseBox);
			button1= new Button("ȷ��");//���밴ť
			button1.addActionListener(this);
			add(button1);
			button2 = new Button("�˿�");//�˿���ť
			button2.addActionListener(this);
			add(button2);
			setLayout(new FlowLayout());
			this.addWindowListener(new WindowAdapter(){
				public void windowClosing(WindowEvent e){
					System.exit(0);
					}
				});
			setBounds(320,325,400,375);
			setVisible(true);
		}
		public void actionPerformed(ActionEvent e){
			if(e.getSource() == button1){
				//������������ź�����ı���
						 number1=tf1.getText();
						 try {
							UdpSend.sent("0");
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
							number2=tf2.getText();
							try {
								UdpSend.sent(number1);
							} catch (Exception e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							try {
								UdpSend.sent(number2);
							} catch (Exception e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
				/*�ж���������Ŀ��ź������Ƿ���ȷ*/	
							dispose();			
		}	if(e.getSource()==button2){
				System.exit(0);
				dispose();//�˳�
			}
	}
	
		
	}	

