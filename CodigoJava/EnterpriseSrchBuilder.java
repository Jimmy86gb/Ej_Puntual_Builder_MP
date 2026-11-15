import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class EnterpriseSrchBuilder extends UIBuilder {
    private JTextField txtEntName;
    private JTextField txtNIT;
    private JTextField txtCountry;
    private JTextField txtAddress;
    private JLabel lblEntName;
    private JLabel lblNIT;
    private JLabel lblCountry;
    private JLabel lblAddress;

    public EnterpriseSrchBuilder() {
        super();
        txtEntName = new JTextField(15);
        txtNIT = new JTextField(15);
        txtCountry = new JTextField(15);
        txtAddress = new JTextField(15);
    }

    @Override
    public void addUIControls() {
        searchUI.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        lblEntName = new JLabel("Enterprise name: ");
        lblNIT = new JLabel("Tax Identification Number: ");
        lblCountry = new JLabel("Country: ");
        lblAddress = new JLabel("Address: ");

        gbc.gridx = 0;
        gbc.gridy = 0;
        searchUI.add(lblEntName, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        searchUI.add(txtEntName, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        searchUI.add(lblNIT, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        searchUI.add(txtNIT, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        searchUI.add(lblCountry, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        searchUI.add(txtCountry, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        searchUI.add(lblAddress, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        searchUI.add(txtAddress, gbc);
    }

    @Override
    public void initialize() {
        txtEntName.setText("");
        txtNIT.setText("");
        txtCountry.setText("");
        txtAddress.setText("");
    }

    @Override
    public String getSQL() {
        return "Select * from Enterprise where Name='" + txtEntName.getText()
                + "' and NIT='" + txtNIT.getText()
                + "' and Country='" + txtCountry.getText()
                + "' and Address='" + txtAddress.getText() + "'";
    }
}