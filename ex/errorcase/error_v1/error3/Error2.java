public class Error1{
    public void stopLoading() {
        if(timer != null) {
            timer.stop();
            timer = null;
        }
        loadButton.setEnabled(true);
        stopButton.setEnabled(false);
    }
    public void mouseClicked(MouseEvent e) {
        TableColumnModel columnModel = tableView.getColumnModel();
        int viewColumn = columnModel.getColumnIndexAtX(e.getX());
        int column = tableView.convertColumnIndexToModel(viewColumn);
        if(e.getClickCount() == 1 && column != -1) {
            System.out.println("Sorting ...");
            int shiftPressed = e.getModifiers()&InputEvent.SHIFT_MASK;
            boolean ascending = (shiftPressed == 0);
            sorter.sortByColumn(column, ascending);
        }
    }
}