import java.applet.Applet;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Index extends Applet implements ActionListener{
    // Label Created
    Label lb1 = new Label("Enter Name ");
    Label lb2 = new Label("Enter Email ");
    Label lb3 = new Label("Select Gender ");
    Label lb4 = new Label("Enter Address");
    Label lb5 = new Label("Enter Mobile Number");
    Label lb6 = new Label("Select Country ");

    // Controls Created
    TextField name = new TextField(50);
    TextField email = new TextField(50);
    CheckboxGroup chg = new CheckboxGroup();
    Checkbox chb1 = new Checkbox("male", chg, true);
    Checkbox chb2 = new Checkbox("female", chg, false);
    Checkbox chb3 = new Checkbox("transgender", chg, false);
    TextArea address = new TextArea("", 5, 50);
    TextField mobile = new TextField(50);
    Choice country = new Choice();

    Button btn = new Button("Submit");
String Message="";
    // init state in applet
    public void init() {

        // set font size
        setFont(new Font("ARIAL", Font.BOLD, 20));
        // name
        add(lb1);
        add(name);
        // email
        add(lb2);
        add(email);
        // gender
        add(lb3);
        add(chb1);
        add(chb2);
        add(chb3);
        setFont(new Font("ARIAL", Font.BOLD, 24));
        // address
        add(lb4);
        add(address);

        // mobile
        add(lb5);
        add(mobile);

        // country
        add(lb6);
        country.addItem("India");
        country.addItem("USA");
        country.addItem("UK");
        country.addItem("Australia");
        add(country);
        // button
        
        add(btn);
        btn.addActionListener(this);
        btn.setBackground(Color.red);
    }


public void actionPerformed(ActionEvent e){


// create Database Connection
try {
    

Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/appletWeb","root","Suraj@3224");
String query="insert into data(name,email,gender,address,mobile,country) values(?,?,?,?,?,?)";

PreparedStatement pstm=con.prepareStatement(query);
pstm.setString(1,name.getText());
pstm.setString(2,email.getText());
pstm.setString(4,address.getText());
int mobileNum=Integer.parseInt(mobile.getText());
pstm.setLong(5,mobileNum);
pstm.setString(6,country.getSelectedItem());

pstm.execute();

con.close();

} catch (Exception err) {
System.out.println(err);
}
Message="Successfully Send Data";
repaint();
}

    public void paint(Graphics g) {
g.drawString(Message, 100, 300);
    }

}

/* <applet code="Index.class" width="700" height="700"></applet> */