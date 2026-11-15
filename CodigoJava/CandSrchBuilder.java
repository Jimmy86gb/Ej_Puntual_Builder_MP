import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class CandSrchBuilder extends UIBuilder {
    private JTextField txtUserName;
    private JTextField txtSkill;
    private JComboBox<String> cmbExperience;

    public CandSrchBuilder() {
        super();
        txtUserName = new JTextField(15);
        txtSkill = new JTextField(15);
        cmbExperience = new JComboBox<>();
    }

    @Override
    public void addUIControls() {
        searchUI.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel lblUserName = new JLabel("Name: ");
        JLabel lblExperienceRange = new JLabel("Experience(min Yrs.)");
        JLabel lblSkill = new JLabel("Skill: ");

        cmbExperience.addItem("<5");
        cmbExperience.addItem(">5");
        cmbExperience.setSelectedIndex(0);

        gbc.gridx = 0;
        gbc.gridy = 0;
        searchUI.add(lblUserName, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        searchUI.add(txtUserName, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        searchUI.add(lblExperienceRange, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        searchUI.add(cmbExperience, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        searchUI.add(lblSkill, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        searchUI.add(txtSkill, gbc);
    }

    @Override
    public void initialize() {
        txtUserName.setText("");
        txtSkill.setText("Internet Tech");
    }

    @Override
    public String getSQL() {
        String experience = (String) cmbExperience.getSelectedItem();
        return "Select * from Candidate where Username='" + txtUserName.getText()
                + "' and Experience " + experience
                + " and Skill='" + txtSkill.getText() + "'";
    }
}