public class Error1{
    public void stopLoading() {
        if(timer != null) {
            timer.stop();
            timer = null;
        }
        loadButton.setEnabled(true);
        stopButton.setEnabled(false);
    }

    public boolean lift(int x, int y) {
        pressed = false;
        repaint();
        if (inside(x, y) && anchor != null) {
            showDocument(anchor);
        }
        return true;
    }
}