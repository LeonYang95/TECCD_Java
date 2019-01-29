public class Error1{
    public void stopLoading() {
        if(timer != null) {
            timer.stop();
            timer = null;
        }
        loadButton.setEnabled(true);
        stopButton.setEnabled(false);
    }
    public static JPanel createHorizontalPanel(boolean threeD) {
        JPanel p = new JPanel();
        p.setLayout(new BoxLayout(p, BoxLayout.X_AXIS));
        if(threeD) {
            p.setBorder(loweredBorder);
        }
        return p;
    }
}