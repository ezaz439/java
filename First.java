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
//java api documentation
class First extends Frame implements ActionListener, WindowListener {
	public Login log;
    public Signup sign;
    public Deposit depo;
    public Database db;
	public First(){
		super("Welcome to our system!");
		Label p = new Label("Metro Bank Lim.");
		log=new Login(this);
        sign=new Signup(this);
        depo=new Deposit(this);
        db= new Database(this);
		Button l=new Button("Login");
		 Button s=new Button("Signup");
		 Button n=new Button("Deposit");
		Button q=new Button("Database");
		add(l);
		add(s);
		add(n);
		add(q);
		l.setBounds(140,50,110,50);
		s.setBounds(140,150,110,50);
		n.setBounds(140,250,110,50);
		q.setBounds(140,350,110,50);
		l.addActionListener(this);
		s.addActionListener(this);
		n.addActionListener(this);
		q.addActionListener(this);
		addWindowListener(this);
		setLayout(null);
		setSize(400,500);
		setLocation(400,500);
	}
	public void actionPerformed(ActionEvent e){
		String s=e.getActionCommand();
		if(s.equals("Login")){
			this.setVisible(false);
			log.setVisible(true);
		}
	    else if(s.equals("Signup")){
			sign.setVisible(true);
			this.setVisible(false);
		}
		else if(s.equals ("Deposit")){
			depo.setVisible(true);
			this.setVisible(false);
        }
    else if(s.equals ("Database")){
			db.setVisible(true);
			this.setVisible(false);

		}
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