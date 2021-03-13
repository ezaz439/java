import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.*;
import javax.swing.*;
import java.awt.Graphics;
import java.awt.Color;
public class ChangePin extends Frame implements ActionListener{
	TextField tf2;
	TextField tf5;
	private Account account;
	//private Account account;
	public ChangePin(Account a){
		super("Metro Bank Limited");
		account =a;
		add (new Label("Wecome To Our System!"));
		Label l=new Label("Account Number");
		Label s =new Label("New Pin");
		tf2=new TextField(28);
		tf5=new TextField(28);
	
      	//tf2.setEchoChar('*');
		Button b=new Button("Change");
		Button b2=new Button("Cancel");
		add(l);add(tf2);
		add(s);add(tf5);
		add(b);add(b2);
		
		b.addActionListener(this);
		b2.addActionListener(this);
		setLayout(new FlowLayout());
		setSize(280,400);
		//setLocation(280,400);
		//setVisible(true);
	}
	public void actionPerformed(ActionEvent ae){
		System.out.println("Button Pressed");
		String s=ae.getActionCommand();
		System.out.println(s);
		if(s.equals("Change")){
			if(tf2.getText().length()==0 || tf5.getText().length()==0){
				JOptionPane.showMessageDialog(this,"You Must Type");
			}
			else
			{
			//String q="insert into `deposit` values(null,'"+tf.getText()+"','"+tf2.getText()+"','"+tf3.getText()+"','"+tf4.getText()+"','"+tf5.getText()+"','"+tf6.getText()+"')";
			String e="UPDATE deposit SET Pin = '"+tf5.getText()+"' WHERE accnum = '"+tf2.getText()+"'";
			System.out.println(e);
			DataAccess da=new DataAccess();
			int c=da.updateDB(e);
			JOptionPane.showMessageDialog(this,c+" row(s) updated");
		}
	}
	else if(s.equals("Cancel")){
			account.setVisible(true);
			this.setVisible(false);
	}
}
	public void paint(Graphics g){
		g.setColor(Color.GREEN);
		g.fillRect(0,0,280,400);
}
}

	