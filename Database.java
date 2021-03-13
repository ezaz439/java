import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.Graphics;
import java.awt.Color;
public class Database extends Frame implements ActionListener{
	private TextArea ta;
	private Frame parent;
	private TextField tf3;
	private TextArea tq;
	private First first;
	public Database(First f){
		super("Metro Bank Lim.");
		first =f;
		Label l=new Label("Data From DB");
		ta=new TextArea(7,30);
		Button b=new Button("Show");
		Button b2=new Button("Exit");
		add(l);add(ta);
		add(b);add(b2);
		b.addActionListener(this);
		b2.addActionListener(this);
		setLayout(new FlowLayout());
		setSize(300,400);
		//setLocation(400,300);
		//setVisible(true);
	}
	public void actionPerformed(ActionEvent ae){
		String s=ae.getActionCommand();
		System.out.println(ta.getText());
		ta.setText("");
		if(s.equals("Show")){
			try{
				DataAccess da=new DataAccess();
				ResultSet rs=null;
				rs=da.getData("select uname,accnum,currbal from deposit");
				while(rs.next()){
					String str=rs.getString("uname")+":"+rs.getString("accnum")+":"+rs.getString("currbal");
					ta.append(str+"\n");
				}
			}catch(Exception ex){ex.printStackTrace();}
			//ta.append("my text\n");
		}
		else if(s.equals("Exit")){
			first.setVisible(true);
			this.setVisible(false);
		}

		}
		public void paint(Graphics g){
		g.setColor(Color.GREEN);
		g.fillRect(0,0,300,400);

	}
}
