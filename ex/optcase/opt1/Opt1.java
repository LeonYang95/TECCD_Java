public class Opt1{
    public void stopLoading() {
        if(timer != null) {
            timer.stop();
            timer = null;
        }
        loadButton.setEnabled(true);
        stopButton.setEnabled(false);
    }

    public void startLoading() {
        if(timer == null) {
            loadButton.setEnabled(false);
            stopButton.setEnabled(true);
            timer = new Timer(25, this);
            timer.start();
        }
    }
}