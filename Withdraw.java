import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.Graphics;
import java.awt.Color;
import javax.swing.*;
public class Withdraw extends Frame implements ActionListener{
	private Frame parent;
	private TextField ammountT;
	private TextArea currBal;
	String accountno;
	//private First first;
	public Withdraw(){
		super("Welcome to our System");
		Label s=new Label("Enter Ammount");
		ammountT=new TextField(28);
		Button b3=new Button("Withdraw");
		Label p=new Label("Current Balance");
		currBal=new TextArea(5,30);
		Button b4=new Button("show");
		Button b5=new Button("exit");
		add(s);add(ammountT);
		add(b3);
		add(p);add(currBal);
		add(b4);add(b5);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		setLayout(new FlowLayout());
		setSize(280,400);
		//setLocation(400,300);
			//setVisible(true);*/
	}
	public void setaccno(String ss)
		{
			this.accountno=ss;
		}
	public void actionPerformed(ActionEvent ae){
		String s=ae.getActionCommand();
	  System.out.println(currBal.getText());
		currBal.setText("");
		if(s.equals("Withdraw")){
            DataAccess da=new DataAccess();
            String typeAmmount=ammountT.getText();
            int i=Integer.parseInt(typeAmmount);
            int result=0;
            String q="select currbal from deposit where accnum='"+accountno+"'";
            ResultSet rs=null;
            System.out.println("Button pressed");
            try{
                rs=da.getData(q);
                System.out.println(q);
                while(rs.next()){
                	//String n = rs.getString("accnum");
                    String p=rs.getString("currbal");
                    int j=Integer.parseInt(p);
                      if(i<=j){
                        result=j-i;
                        System.out.println(result);
                        String str1 = Integer.toString(result);
                        String sql="UPDATE deposit SET currbal = '"+result+"' WHERE accnum = '"+accountno+"'";
                        System.out.println(sql);
                        int m=da.updateDB(sql);
                        System.out.println("Transaction Successful");
                        JOptionPane.showMessageDialog(this,"Transaction Successful");
                        break;
                    }
                    else
                    {
                    	JOptionPane.showMessageDialog(this,"Transaction Is not Successful Excceced Ammount");
                    }   
                }
            }
            catch(Exception ex){
                JOptionPane.showMessageDialog(this,"DB Error");
            }
        }
        else if(s.equals("Exit")){
			System.exit(0);
		
	}
}
public void paint(Graphics g){
		g.setColor(Color.BLUE);
		g.fillRect(0,0,280,400);
}
}