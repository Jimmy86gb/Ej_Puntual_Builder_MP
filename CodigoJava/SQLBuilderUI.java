import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.border.EtchedBorder;

public class SQLBuilderUI extends JFrame {
    public static final String CANDIDATE = "Candidate SQL Statement";
    public static final String EMPLOYER = "Employer SQL Statement";
    public static final String ENTERPRISE = "Enterprise SQL Statement";
    public static final String EXIT = "Exit";
    public static final String GET_SQL = "Show SQL Statement";
    public static final String BLANK = "";

    private JComboBox<String> cmbSearchType;
    private JTextArea txtSQL;
    private JPanel pSearchCriteria;
    private JLabel lblSearchType;
    private JLabel lblWhereClause;
    private JLabel lblSearchCriteria;
    private JButton btnGetWhereClause;
    private JButton btnExit;

    public SQLBuilderUI() {
        super("Builder example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.WEST;

        cmbSearchType = new JComboBox<>(new String[]{
            SQLBuilderUI.BLANK,
            SQLBuilderUI.CANDIDATE,
            SQLBuilderUI.EMPLOYER,
            SQLBuilderUI.ENTERPRISE
        });
        cmbSearchType.setSelectedIndex(0);

        txtSQL = new JTextArea("The SQL statement will be displayed here.", 5, 45);
        txtSQL.setLineWrap(true);
        txtSQL.setWrapStyleWord(true);
        JScrollPane scrollSQL = new JScrollPane(txtSQL);

        pSearchCriteria = new JPanel(new BorderLayout());
        pSearchCriteria.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));

        lblSearchType = new JLabel("Select SQL Statement:");
        lblWhereClause = new JLabel("SQL Statement:");
        lblSearchCriteria = new JLabel("Statement's Criteria:");

        btnGetWhereClause = new JButton(SQLBuilderUI.GET_SQL);
        btnExit = new JButton(SQLBuilderUI.EXIT);

        gbc.gridx = 0;
        gbc.gridy = 0;
        add(lblSearchType, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        add(cmbSearchType, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        add(lblSearchCriteria, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        add(pSearchCriteria, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        add(lblWhereClause, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        add(scrollSQL, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        add(btnGetWhereClause, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        add(btnExit, gbc);

        pack();
        setLocationRelativeTo(null);
    }

    public void displayNewUI(JPanel panel) {
        pSearchCriteria.removeAll();
        pSearchCriteria.add(panel, BorderLayout.CENTER);
        pSearchCriteria.revalidate();
        pSearchCriteria.repaint();
        pack();
    }

    public void setSQL(String sqlStr) {
        txtSQL.setText(sqlStr);
    }

    public JButton getBtnGetWhereClause() {
        return btnGetWhereClause;
    }

    public JButton getBtnExit() {
        return btnExit;
    }

    public JComboBox<String> getCmbSearchType() {
        return cmbSearchType;
    }

    public String getSearchType() {
        return (String) cmbSearchType.getSelectedItem();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SQLBuilderUI frame = new SQLBuilderUI();
            new ButtonHandler(frame);
            frame.setVisible(true);
        });
    }
}

class ButtonHandler implements ActionListener {
    private SQLBuilderUI frame;
    private UIBuilder builder;

    public ButtonHandler(SQLBuilderUI frame) {
        this.frame = frame;
        this.builder = null;
        this.frame.getBtnGetWhereClause().addActionListener(this);
        this.frame.getBtnExit().addActionListener(this);
        this.frame.getCmbSearchType().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == frame.getBtnExit()) {
            eventBtnExit();
        } else if (e.getSource() == frame.getBtnGetWhereClause()) {
            eventBtnGetWhereClause();
        } else if (e.getSource() == frame.getCmbSearchType()) {
            eventCmbSearchType();
        }
    }

    public void eventBtnGetWhereClause() {
        String selection = frame.getSearchType();
        if (!selection.equals(SQLBuilderUI.BLANK) && builder != null) {
            frame.setSQL(builder.getSQL());
        } else {
            frame.setSQL("Select one option above");
        }
    }

    public void eventCmbSearchType() {
        String selection = frame.getSearchType();
        if (!selection.equals(SQLBuilderUI.BLANK)) {
            BuilderFactory factory = new BuilderFactory();
            builder = factory.getUIBuilder(selection);
            UIDirector director = new UIDirector(builder);
            director.build();
            JPanel uiObj = builder.getSearchUI();
            frame.displayNewUI(uiObj);
        } else {
            pClearCriteria();
            frame.setSQL("You should select one option above");
        }
    }

    private void pClearCriteria() {
        frame.displayNewUI(new JPanel());
    }

    public void eventBtnExit() {
        frame.dispose();
        System.exit(0);
    }
}