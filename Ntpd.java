import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Ntpd implements ActionListener {

  public static void main(String[] args) {
    new Ntpd();
  }
  Font f = new Font("serif",Font.PLAIN,35);
  
  JTextArea txtarea = new JTextArea();
  JScrollPane scroll = new JScrollPane(txtarea,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
  
  
  JFrame jf = new JFrame();
  JMenuBar menub = new JMenuBar();
  JMenu File = new JMenu("Files");
  JMenu Edit = new JMenu("Edit");
  JMenu format = new JMenu("formattext");
  JMenu helper = new JMenu("Help");
  JMenuItem newfl =new JMenuItem("New File");
  JMenuItem fOpen =new JMenuItem("Open a File");
  JMenuItem save =new JMenuItem("Save File");
  JMenuItem saveas =new JMenuItem("Save File s");
  JMenuItem close =new JMenuItem("CLose");
  JMenuItem cut =new JMenuItem("cut");
  JMenuItem cpy =new JMenuItem("cpy");
  JMenuItem paste =new JMenuItem("paste");
  JMenuItem slxtall =new JMenuItem("Selectall");
  JMenuItem cfont =new JMenuItem("Edit-font");
  JMenuItem about = new JMenuItem("About Notepad");
  
  public Ntpd() {
    newfl.addActionListener(this);
    File.add(newfl);
    fOpen.addActionListener(this);
    File.add(fOpen);
    
    save.addActionListener(this);
    File.add(save);
    saveas.addActionListener(this);
    File.add(saveas);
    close.addActionListener(this);
    File.add(close);
    
    cut.addActionListener(this);
    Edit.add(cut);
    cpy.addActionListener(this);
    Edit.add(cpy);
    paste.addActionListener(this);
    Edit.add(paste);
    slxtall.addActionListener(this);
    Edit.add(slxtall);
    
    cfont.addActionListener(this);
    format.add(cfont);
  
    about.addActionListener(this);
    helper.add(about);
    
    txtarea.setFont(f);
    txtarea.setLineWrap(true);
    txtarea.setWrapStyleWord(true);
    scroll.setSize(700, 400);
    menub.add(File);
    menub.add(Edit);
    menub.add(format);
    menub.add(helper);
    
    jf.add(scroll);
    jf.setJMenuBar(menub);
    jf.setTitle("Untitled Document");
    jf.setSize(700,400);
    jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    jf.setLocationRelativeTo(null);
    jf.setVisible(true);
  }
  public void actionPerformed(ActionEvent e) {
    if(e.getSource().equals(newfl)) {
      jf.setTitle("Untitled Document");
      txtarea.setText("");
    }
    if(e.getSource().equals(save)) {
      if(txtarea == null){
        JOptionPane.showMessageDialog(null,"File is empty");
      }else {
        FileWriter f;
        try{
          f=new FileWriter("Untitled.txt");
          String sr = txtarea.getText();
          for(int i=0;i<sr.length();i++) {
            f.write(sr.charAt(i));
          }
          f.close();
          JOptionPane.showMessageDialog(null,"Saved sucessfully");
        }catch(Exception except) {
          JOptionPane.showMessageDialog(null, "Error in file");
        }
      }
    }
    
    if(e.getSource().equals(saveas)) {
      if(txtarea == null){
        JOptionPane.showMessageDialog(null,"File is empty");
      }else {
        
        String s=JOptionPane.showInputDialog("Enter thefilename");
        FileWriter f;
        jf.setTitle(s);
        try{
          f=new FileWriter(s);
          String sr = txtarea.getText();
          for(int i=0;i<sr.length();i++) {
            f.write(sr.charAt(i));
          }
          f.close();
          JOptionPane.showMessageDialog(null,"Saved file successfully");
        }catch(Exception except) {
          JOptionPane.showMessageDialog(null, "error in thefile");
        }
      }
    }
    if(e.getSource().equals(fOpen)) {
      FileReader fr;

String s=JOptionPane.showInputDialog("Enter filename");
      String tr="";//or null
      try {
        fr=new FileReader(s);
        int a;
        while((a=fr.read())!=-1) {
          tr+=(char)a;
        }
        fr.close();
        txtarea.setText(tr);
      }catch(Exception ex) {
        JOptionPane.showInputDialog(null,"error in file");
      }
    }
    if(e.getSource().equals(close)) {
      System.exit(0);
    }
    if(e.getSource().equals(cut)) {
      txtarea.cut();
    }
    if(e.getSource().equals(cpy)) {
      txtarea.copy();
    }
    if(e.getSource().equals(paste)) {
      txtarea.paste();
    }
    if(e.getSource().equals(slxtall)) {
      txtarea.selectAll();
    }
  
    if(e.getSource().equals(about)) {
      JOptionPane.showMessageDialog(null, "Notepad myswing app");
    }
  }
}