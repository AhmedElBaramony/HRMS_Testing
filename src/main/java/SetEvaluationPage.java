import org.example.Evaluation;
import org.example.PerformanceEvaluation;
import org.example.Sys;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class SetEvaluationPage extends JFrame implements ActionListener {
    private JPanel TitlePanel;
    private JLabel SetEvaluationTitle;
    private JPanel EvaluationInputPanel;
    private JLabel QualityLabel;
    private JLabel ProductivityLabel;
    private JLabel PunctualityLabel;
    private JLabel CollaborationLabel;
    private JPanel BtnPanel;
    private JButton SubmitBtn;
    private JButton BackBtn;
    private JComboBox QualityDrop;
    private JLabel InitiativeLabel;
    private JComboBox ProductivityDrop;
    private JComboBox PunctualityDrop;
    private JComboBox CollaborationDrop;
    private JComboBox InitiativeDrop;
    private JPanel SetEvaluationPage;

    public SetEvaluationPage(){
        String[] array = {Evaluation.POOR.toString(), Evaluation.FAIR.toString(), Evaluation.GOOD.toString(), Evaluation.EXCELLENT.toString()};
        for(String i:array){
            QualityDrop.addItem(i);
            ProductivityDrop.addItem(i);
            PunctualityDrop.addItem(i);
            CollaborationDrop.addItem(i);
            InitiativeDrop.addItem(i);
        }

        SubmitBtn.addActionListener(this);
        BackBtn.addActionListener(this);

        setContentPane(SetEvaluationPage);
        setTitle("Manage Employees page");
        setSize(500,500);
        setVisible(true);
        // Close operation
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == SubmitBtn){
            Evaluation qu = Evaluation.valueOf(Objects.requireNonNull(QualityDrop.getSelectedItem()).toString());
            Evaluation pro = Evaluation.valueOf(Objects.requireNonNull(ProductivityDrop.getSelectedItem()).toString());
            Evaluation pun = Evaluation.valueOf(Objects.requireNonNull(PunctualityDrop.getSelectedItem()).toString());
            Evaluation col = Evaluation.valueOf(Objects.requireNonNull(CollaborationDrop.getSelectedItem()).toString());
            Evaluation in = Evaluation.valueOf(Objects.requireNonNull(InitiativeDrop.getSelectedItem()).toString());

            PerformanceEvaluation pe = new PerformanceEvaluation(qu,pro,pun,col,in);
            Sys.employee.setPerformanceEvaluation(pe);
            JOptionPane.showMessageDialog(null,"Performance Evaluation added successfully");
        }
        else{
            new ManageEmployeePage();
            dispose();
        }
    }
}
