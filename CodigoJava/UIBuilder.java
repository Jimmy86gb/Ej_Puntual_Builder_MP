import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

public abstract class UIBuilder {
    protected JPanel searchUI;

    public UIBuilder() {
        searchUI = new JPanel();
        Border etched = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
        searchUI.setBorder(etched);
    }

    public abstract void addUIControls();
    public abstract void initialize();
    public abstract String getSQL();

    public JPanel getSearchUI() {
        return searchUI;
    }
}