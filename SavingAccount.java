import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.*;
import javax.swing.*;
import java.awt.event.WindowListener;
import java.awt.event.WindowEvent;
public class SavingAccount extends Frame implements ActionListener,WindowListener{
	TextField tf1;
	private Account account;
	public SavingAccount(Account a){
		super("Welcome To our System");
		add ( new Label ("Enter Pin"));
        TextField tf1 = new TextField(20);	
		add(tf1);
		tf1.addActionListener(this);
		Button e=new Button("Withdraw");
        add(e);
        e.addActionListener(this);
		Button p= new Button ("Cancel");
		p.addActionListener(this);
		add(p);
		setLayout(new FlowLayout());
		setSize(280,400);
		//setVisible(true);
	}
	public void actionPerformed(ActionEvent ae){
		System.out.println("Button Pressed");
		String s=ae.getActionCommand();

         if(s.equals("Withdraw")){
			DataAccess da=new DataAccess();
			String w="select pin from deposit";
			String typedPin=tf1.getText();
			ResultSet rs=null;
			System.out.println("Button pressed");
		}
	}
public void paint(Graphics g){
		g.setColor(Color.BLUE);
		g.fillRect(0,0,280,400);
}
	public void windowActivated(WindowEvent ae){}
	public void windowClosed(WindowEvent ae){}
	public void windowClosing(WindowEvent ae){
		//this.setVisible(false);
		System.exit(0);
	}
	public void windowDeactivated(WindowEvent ae){}
	public void windowDeiconified(WindowEvent ae){}
	public void windowIconified(WindowEvent ae){}
	public void windowOpened(WindowEvent ae){}
}
