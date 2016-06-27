import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.Box;
public class denglu extends Frame {
	public static String name;
	Box baseBox,box1,box2;
	denglu(String s) throws Exception{ 
		super(s);
		box1= Box.createVerticalBox();
	box1.add(new Label("µÇÂ¼ÖÐ¡£¡£¡£¡£¡£"));
	UdpSend.sent("n");
	UdpSend.sent("0");
	UdpSend.sent("0");
	name=UdpSend.receive();
	setBounds(320,325,400,375);
	setVisible(true);
	dispose();
}
}
