import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
class Selection extends Frame implements ActionListener{
	Button button1,button2,button3,button4,button5;
	Panel p1 = new Panel();
	Panel p2 = new Panel();
	Panel p3 = new Panel();
	Panel p4 = new Panel();
	Panel p5 = new Panel();
	Panel p = new Panel();
	Panel x =new Panel();
	
	public Selection(String s) throws HeadlessException, IOException{
		super(s);
		this.setLayout(null);
		this.setLayout(new GridLayout(7,1));
		x.add(new Label(denglu.name));
		this.add(x);
		p.add(new Label("请选择你要的服务"));		
		this.add(p);
		button1 = new Button("存款");
		p1.add(button1);
		this.add(p1);
		button2 = new Button("取款");
		p2.add(button2);
		this.add(p2);
		button3 = new Button("查询余额");
		p3.add(button3);
		this.add(p3);
		button4 = new Button("退出");
		p4.add(button4);
		this.add(p4);
		button5 = new Button("修改密码");
		p5.add(button5);
		this.add(p5);
		this.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);
				}
			});
		button2.addActionListener(this);
		button3.addActionListener(this);
		button4.addActionListener(this);
		button5.addActionListener(this);
		setBounds(200,200,250,250);
		setVisible(true);
		validate();
	}
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==button2){//取款
				dispose();
				
		}
		if(e.getSource()==button3){//查询余额
			
			dispose();
		}
		else if(e.getSource()==button4){//退出
				System.exit(0);
				dispose();
		}
		else if(e.getSource()==button5){//修改密码
				
				dispose();
			}
}
}