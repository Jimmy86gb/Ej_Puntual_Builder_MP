import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class EmpSrchBuilder extends UIBuilder {
    private JTextField txtUserName;
    private JTextField txtCity;
    private JTextField txtRenewal;
    private JLabel lblUserName;
    private JLabel lblCity;
    private JLabel lblRenewal;

    public EmpSrchBuilder() {
        super();
        txtUserName = new JTextField(15);
        txtCity = new JTextField(15);
        txtRenewal = new JTextField(15);
    }

    @Override
    public void addUIControls() {
        searchUI.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        lblUserName = new JLabel("Name: ");
        lblCity = new JLabel("City: ");
        lblRenewal = new JLabel("Membership Renewal: ");

        gbc.gridx = 0;
        gbc.gridy = 0;
        searchUI.add(lblUserName, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        searchUI.add(txtUserName, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        searchUI.add(lblCity, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        searchUI.add(txtCity, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        searchUI.add(lblRenewal, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        searchUI.add(txtRenewal, gbc);
    }

    @Override
    public void initialize() {
        txtUserName.setText("");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM/dd/yyyy", Locale.ENGLISH);
        String currentDate = LocalDate.now().format(formatter);
        txtRenewal.setText(currentDate);
    }

    @Override
    public String getSQL() {
        return "Select * from Employer where Username='" + txtUserName.getText()
                + "' and City='" + txtCity.getText()
                + "' and DateRenewal='" + txtRenewal.getText() + "'";
    }
}