public class UIDirector {
    private UIBuilder builder;

    public UIDirector(UIBuilder bldr) {
        this.builder = bldr;
    }

    public void build() {
        builder.addUIControls();
        builder.initialize();
    }
}