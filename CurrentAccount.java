
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.*;
import javax.swing.*;
public class CurrentAccount extends Frame implements ActionListener{
	TextField tf;
	TextField tf2;
	TextField tf5;
	private Account account;
	public CurrentAccount(Account a){
		super("Metro Bank Limited");
		account= a;
		add (new Label("Wecome To Our System!"));
		Label l=new Label("Enter Account name");
		Label s=new Label("Account Number");
		Label p=new Label("Pin Number");
		tf=new TextField(28);
		tf2=new TextField(28);
		tf5=new TextField(28);
		//tf2.setEchoChar('*');
		Button b=new Button("Withdraw");
		Button b2=new Button("Cancel");
		add(l);add(tf);
		add(s);add(tf2);
		add(p);add(tf5);
		add(b);add(b2);
		b.addActionListener(this);
		b2.addActionListener(this);
		setLayout(new FlowLayout());
		setSize(280,400);
		//setVisible(true);
	}
	public void actionPerformed(ActionEvent ae){
		String s=ae.getActionCommand();
            if(s.equals("Withdraw")){	
			DataAccess da=new DataAccess();
			String q="select uname,accnum,pin from deposit";
			String typedName=tf.getText();
			String typedAccNUm=tf2.getText();

			String typedPin=tf5.getText();
			ResultSet rs=null;
			System.out.println("Button pressed");		
			try{
				rs=da.getData(q);
				System.out.println(q);
				while(rs.next()){
					String n = rs.getString("accnum");
					String p= rs.getString("pin");
					if(n.equals(typedAccNUm) && p.equals(typedPin)){
						System.out.println("Correct Cred.");
						JOptionPane.showMessageDialog(this,"Correct Cred.");
						Withdraw w=new Withdraw();
						w.setVisible(true);
						this.setVisible(false);
						w.setaccno(typedAccNUm);
						break;
					}
				}
			}

			catch(Exception ex){
				JOptionPane.showMessageDialog(this,"DB Error");
				//ex.printStackTrace();
			
		}
	}
		else if(s.equals("Cancel")){
			account.setVisible(true);
			this.setVisible(false);
		}
	}
	public void paint(Graphics g){
		g.setColor(Color.BLUE);
		g.fillRect(0,0,280,400);
}
}