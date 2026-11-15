public class BuilderFactory {
    public UIBuilder getUIBuilder(String str) {
        UIBuilder builder = null;
        if (str.equals(SQLBuilderUI.CANDIDATE)) {
            builder = new CandSrchBuilder();
        } else if (str.equals(SQLBuilderUI.EMPLOYER)) {
            builder = new EmpSrchBuilder();
        } else if (str.equals(SQLBuilderUI.ENTERPRISE)) {
            builder = new EnterpriseSrchBuilder();
        }
        return builder;
    }
}