import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EmployeeServicesPage extends JFrame implements ActionListener {
    private JPanel EmployeeSerPage;
    private JPanel TitlePanel;
    private JLabel EmployeePageLabel;
    private JButton AddEmployeeBtn;
    private JButton ManageEmployeeBtn;
    private JButton AdminPageBtn;
    private JPanel BtnPanel;

    public EmployeeServicesPage(){
        setContentPane(EmployeeSerPage);
        setTitle("Employee Services page");
        setSize(500,500);
        setVisible(true);
        // Close operation
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        AddEmployeeBtn.addActionListener(this);
        ManageEmployeeBtn.addActionListener(this);
        AdminPageBtn.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == AddEmployeeBtn) {
            new AddEmployeePage();
            dispose();
        }
        else if(e.getSource() == ManageEmployeeBtn){
            new ManageEmployeePage();
            dispose();
        }
        else
        {
            new AdminPage();
            dispose();
        }
    }
}
