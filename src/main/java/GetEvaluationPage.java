import org.example.PerformanceEvaluation;
import org.example.Sys;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GetEvaluationPage extends JFrame{
    private JPanel TitlePanel;
    private JLabel GetEvaluationTitle;
    private JPanel EvaluationInputPanel;
    private JLabel QualityLabel;
    private JLabel ProductivityLabel;
    private JLabel PunctualityLabel;
    private JLabel CollaborationLabel;
    private JLabel InitiativeLabel;
    private JPanel BtnPanel;
    private JButton BackBtn;
    private JLabel PunctualityText;
    private JLabel QualityText;
    private JLabel ProductivityText;
    private JLabel CollaborationText;
    private JLabel InitiativeText;
    private JPanel GetEvaluation;
    private JLabel EvaluationText;
    private JLabel EvaluationLabel;

    GetEvaluationPage(){
        setContentPane(GetEvaluation);
        setTitle("Performance Evaluation");
        setSize(500,500);
        setVisible(true);
        // Close operation
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        PerformanceEvaluation pe = Sys.employee.getPerformanceEvaluation();
        QualityText.setText(pe.getQuality().toString());
        ProductivityText.setText(pe.getProductivity().toString());
        PunctualityText.setText(pe.getPunctuality().toString());
        CollaborationText.setText(pe.getCollaboration().toString());
        InitiativeText.setText(pe.getInitiative().toString());
        EvaluationText.setText(pe.getEvaluation().toString());

        BackBtn.addActionListener(e -> {
            new ManageEmployeePage();
            dispose();
        });
    }
}
