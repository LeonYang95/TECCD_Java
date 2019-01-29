public class Error1{
    public void stopLoading() {
        if(timer != null) {
            timer.stop();
            timer = null;
        }
        loadButton.setEnabled(true);
        stopButton.setEnabled(false);
    }
    public static void main(String args[]) {
        Frame f = new Frame("CardTest");
        CardTest cardTest = new CardTest();
        cardTest.init();
        cardTest.start();

        f.add("Center", cardTest);
        f.setSize(300, 300);
        f.show();
    }

}