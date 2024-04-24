import org.example.Employee;
import org.example.HRMS;
import org.example.Sys;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class AddEmployeePage extends JFrame implements ActionListener{
    private JPanel TitlePanel;
    private JLabel AddEmployeePageLabel;
    private JPanel InputPanel;
    private JLabel NameLabel;
    private JTextField NameText;
    private JButton AddBtn;
    private JLabel IDLabel;
    private JLabel DepartmentLabel;
    private JLabel UsernameLabel;
    private JLabel PasswordLabel;
    private JTextField IDText;
    private JTextField DepartmentText;
    private JTextField UsernameText;
    private JTextField PasswordText;
    private JPanel BtnPanel;
    private JButton ReturnBtn;
    private JPanel AddEmployeePage;

    public AddEmployeePage(){
        setContentPane(AddEmployeePage);
        setTitle("Add Employee page");
        setSize(500,500);
        setVisible(true);
        // Close operation
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        AddBtn.addActionListener(this);
        ReturnBtn.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == AddBtn){
            String name = NameText.getText();
            try{
                int id = Integer.parseInt(IDText.getText());
                String username = UsernameText.getText();
                String password = PasswordText.getText();
                String department = DepartmentText.getText();

                Employee employee = new Employee(name,id,username,password,department);
                boolean added = Sys.hrms.addEmployee(employee);
                if(!added){
                    JOptionPane.showMessageDialog(null,"ID already exists!", "Error",JOptionPane.ERROR_MESSAGE);
                }
                else{
                    JOptionPane.showMessageDialog(null,"Employee added successfully!", "Info",JOptionPane.INFORMATION_MESSAGE);
                }
            }
            catch(Exception ex){
                JOptionPane.showMessageDialog(null,"Only numbers are allowed in ID!!", "Error",JOptionPane.ERROR_MESSAGE);
            }
        }
        else {
            new EmployeeServicesPage();
            dispose();
        }
    }
}
