import java.applet.Applet;
import java.awt.*;

public class Index extends Applet {
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

    }

    public void paint(Graphics g) {

    }

}

/* <applet code="Index.class" width="700" height="700"></applet> */