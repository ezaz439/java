import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.*;
import javax.swing.*;
public class Deposit extends Frame implements ActionListener{
	TextField tf;
	TextField tf2;
	TextField tf3;
	TextField tf4;
	TextField tf5;
	private First first;
	public Deposit(First f){
		super("Metro Bank Limited");
		first=f;
		add (new Label("Wecome To Our System!"));
		Label l=new Label("User Name");
		Label s =new Label("Account Number");
		Label p = new Label("card number");
	    Label q =new Label ("Current Balance");
		Label r=new Label("Pin");
		tf=new TextField(28);
		tf2=new TextField(28);
		tf3=new TextField(28);
		tf4=new TextField(28);
	    tf5=new TextField(28);


		//tf2.setEchoChar('*');
		Button b=new Button("Ok");
		Button b2=new Button("Cancel");
		add(l);add(tf);
		add(s);add(tf2);
		add(p);add(tf3);
		add(q);add(tf4);
		add(r);add(tf5);
		add(b);add(b2);
		b.addActionListener(this);
		b2.addActionListener(this);
		setLayout(new FlowLayout());
		setSize(280,400);
		//setLocation(400,200);
		//setVisible(true);
	}
	public void actionPerformed(ActionEvent ae){
		System.out.println("Button Pressed");
		String s=ae.getActionCommand();
		System.out.println(s);
		if(s.equals("Ok")){
			if(tf.getText().length()==0 || tf2.getText().length()==0){
				JOptionPane.showMessageDialog(this,"You Must Type");
			}
			else
			{
			//String q="insert into `deposit` values(null,'"+tf.getText()+"','"+tf2.getText()+"','"+tf3.getText()+"','"+tf4.getText()+"','"+tf5.getText()+"')";
			String e="UPDATE deposit SET currbal ='"+tf4.getText()+"' WHERE accnum = '"+tf2.getText()+"'";
			System.out.println(e);
			DataAccess da=new DataAccess();
			int c=da.updateDB(e);
			JOptionPane.showMessageDialog(this,c+" row(s) updated");
		}
	}
	else if(s.equals("Cancel")){
			first.setVisible(true);
			this.setVisible(false);
	}
}
public void paint(Graphics g){
		g.setColor(Color.BLUE);
		g.fillRect(0,0,280,400);
}
}