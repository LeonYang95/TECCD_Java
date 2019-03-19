public class Method{
    private void initialize() {
        Parameter[] params = getParameters();
        if (params != null) {
            for (int i = 0; i < params.length; i++) {
                if (params[i] != null) {
                    if (TAB_LENGTH_KEY.equals(params[i].getName())) {
                        tabLength = Integer.parseInt(params[i].getValue());
                        break;
                    }
                }
            }
        }
    }

    private void initialize() {
        Parameter[] params = getParameters();
        if (params != null) {
            for (int i = 0; i < params.length; i++) {
                if (LINES_KEY.equals(params[i].getName())) {
                    lines = Long.parseLong(params[i].getValue());
                    continue;
                }
                if (SKIP_KEY.equals(params[i].getName())) {
                    skip = Long.parseLong(params[i].getValue());
                    continue;
                }
            }
        }
    }



}