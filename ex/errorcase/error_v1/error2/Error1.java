public class Error1{
    public void stopLoading() {
        if(timer != null) {
            timer.stop();
            timer = null;
        }
        loadButton.setEnabled(true);
        stopButton.setEnabled(false);
    }
    public boolean matches(StringBuffer sb, int pos) {
        if (pos + pred.length() > sb.length()) {
            return false;
        }
        char cb[] = new char[pred.length()];
        sb.getChars(pos, pos + pred.length(), cb, 0);
        return pred.equals(new String(cb));
    }
}