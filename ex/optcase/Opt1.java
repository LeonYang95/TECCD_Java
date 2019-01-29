public class Opt1{
    public void stopLoading() {
        if(timer != null) {
            timer.stop();
            timer = null;
        }
        if(timer != null) {
            timer.stop();
            timer = null;
        }
        loadButton.setEnabled(true);
        stopButton.setEnabled(false);
    }
    public void createHorizontalPanel(boolean threeD) {
        if(timer != null) {
            timer.stop();
            timer = null;
        }
        if(timer != null) {
            timer.stop();
            timer = null;
        }
        new JPanel().setLayout(new BoxLayout(p, BoxLayout.X_AXIS));
        loadButton.setEnabled(true);
        stopButton.setEnabled(false);
    }
}