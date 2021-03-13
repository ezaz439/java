import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.*;
import javax.swing.*;
public class Login extends Frame implements ActionListener{
	TextField tf;
	TextField tf2;
	private First first;
	public Login(First f){
		super("Metro Bank Limited");
		first = f;
		add (new Label("Wecome To Our System!"));
		Label l=new Label("Enter card number");
		Label l2=new Label("Pin");
		tf=new TextField(28);
		tf2=new TextField(28);
		//tf2.setEchoChar('*');
		Button b=new Button("Login");
		Button b2=new Button("Cancel");
		
		add(l);add(tf);
		add(l2);add(tf2);
		add(b);add(b2);
		
		b.addActionListener(this);
		b2.addActionListener(this);
		
		setLayout(new FlowLayout());
		setSize(280,400);
		//setVisible(true);
	}
	public void actionPerformed(ActionEvent ae){
		String s=ae.getActionCommand();
            if(s.equals("Login")){	
			DataAccess da=new DataAccess();
			String q="select CardNum,Pin from signup";
			String typedName=tf.getText();
			String typedPass=tf2.getText();
			ResultSet rs=null;
			System.out.println("Button pressed");		
			try{
				rs=da.getData(q);
				System.out.println(q);
				while(rs.next()){
					String n = rs.getString("CardNum");
					String p= rs.getString("Pin");
					if(n.equals(typedName) && p.equals(typedPass)){
						System.out.println("Correct Cred.");
						JOptionPane.showMessageDialog(this,"Correct Cred.");
						Account a=new Account();
						a.setVisible(true);
						this.setVisible(false);
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
			first.setVisible(true);
			this.setVisible(false);
		
	}
}
	public void paint(Graphics g){
		g.setColor(Color.BLUE);
		g.fillRect(0,0,280,400);
}
}
  