import java.awt.Frame;
import java.awt.TextField;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowListener;
import java.awt.event.WindowEvent;
import java.awt.event.*;
import java.awt.Graphics;
import java.awt.Color;
class Account extends Frame implements ActionListener,WindowListener{
	public CurrentAccount cur;
    public ChangePin chp;
    //public Back bck;
    public Account(){
		super("Welcome To our System");
		cur=new CurrentAccount(this);
		chp=new ChangePin(this);
		//bck=new Back(this);
		add ( new Label ("Please Select Account Type"));
		Button x= new Button("CurrentAccount");
        Button z= new Button("ChangePin");
        //Button y= new Button("Back");
        add(x);
		add(z);
		//add(y);
		x.setBounds(140,50,100,50);
		z.setBounds(140,250,100,50);
		//y.setBounds(140,150,100,50);
		x.addActionListener(this);
		z.addActionListener(this);
		//y.addActionListener(this);
		addWindowListener(this);
		setLayout(null);
		setSize(400,500);
		setLocation(400,500);
		//setVisible(true);
	}
	public void actionPerformed(ActionEvent e){
		String s=e.getActionCommand();
		if(s.equals("CurrentAccount")){
			this.setVisible(false);
			cur.setVisible(true);
		}
		else if(s.equals("ChangePin")){
			chp.setVisible(true);
			this.setVisible(false);
		}
		/*else if(s.equals("Back")){
			account.setVisible(true);
			this.setVisible(false);
		}*/
	}
	public void paint(Graphics g){
		g.setColor(Color.BLUE);
		g.fillRect(0,0,400,500);
}
	public void windowActivated(WindowEvent e){}
	public void windowClosed(WindowEvent e){}
	public void windowClosing(WindowEvent e){
		//this.setVisible(false);
		System.exit(0);
	}
	public void windowDeactivated(WindowEvent e){}
	public void windowDeiconified(WindowEvent e){}
	public void windowIconified(WindowEvent e){}
	public void windowOpened(WindowEvent e){}	


}