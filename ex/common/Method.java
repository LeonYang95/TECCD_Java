public class Method{
    public void test(){
        if(1<2){
            JCheckBox cb = (JCheckBox) e.getSource();
            String label = cb.getText();
            if(!cb.isSelected()) {
                if(label.equals("Fast Food")) {
                    fastfoodShown = false;
                    for(int i = fastfoodIndex; i < fastfoodIndex+5; i++) {
                        model.removeElementAt(fastfoodIndex);
                    }
                    fastfoodRadioButton.setEnabled(false);
                    dessertIndex -= 5;
                    fruitIndex -= 5;
                    veggieIndex -= 5;
                    scrollPane.validate();
                } else if(label.equals("Desserts")) {
                    for(int i = dessertIndex; i < dessertIndex+5; i++) {
                        model.removeElementAt(dessertIndex);
                    }
                    dessertRadioButton.setEnabled(false);
                    fruitIndex -= 5;
                    veggieIndex -= 5;
                    scrollPane.validate();
                } else if(label.equals("Fruits")) {
                    for(int i = fruitIndex; i < fruitIndex+5; i++) {
                        model.removeElementAt(fruitIndex);
                    }
                    fruitRadioButton.setEnabled(false);
                    veggieIndex -= 5;
                    scrollPane.validate();
                } else if(label.equals("Vegetables")) {
                    for(int i = veggieIndex; i < veggieIndex+5; i++) {
                        model.removeElementAt(veggieIndex);
                    }
                    veggieRadioButton.setEnabled(false);
                    scrollPane.validate();
                }
            }
            else {
                if(label.equals("Fast Food")) {
                    model.insertElementAt(new Integer(4), 0);
                    model.insertElementAt(new Integer(3), 0);
                    model.insertElementAt(new Integer(2), 0);
                    model.insertElementAt(new Integer(1), 0);
                    model.insertElementAt(new Integer(0), 0);
                    dessertIndex += 5;
                    fruitIndex += 5;
                    veggieIndex += 5;
                    fastfoodRadioButton.setEnabled(true);
                    scrollPane.validate();
                } else if(label.equals("Desserts")) {
                    model.insertElementAt(new Integer(9), dessertIndex);
                    model.insertElementAt(new Integer(8), dessertIndex);
                    model.insertElementAt(new Integer(7), dessertIndex);
                    model.insertElementAt(new Integer(6), dessertIndex);
                    model.insertElementAt(new Integer(5), dessertIndex);
                    fruitIndex += 5;
                    veggieIndex += 5;
                    dessertRadioButton.setEnabled(true);
                    scrollPane.validate();
                } else if(label.equals("Fruits")) {
                    model.insertElementAt(new Integer(14), fruitIndex);
                    model.insertElementAt(new Integer(13), fruitIndex);
                    model.insertElementAt(new Integer(12), fruitIndex);
                    model.insertElementAt(new Integer(11), fruitIndex);
                    model.insertElementAt(new Integer(10), fruitIndex);
                    veggieIndex += 5;
                    fruitRadioButton.setEnabled(true);
                    scrollPane.validate();
                } else if(label.equals("Vegetables")) {
                    model.insertElementAt(new Integer(19), veggieIndex);
                    model.insertElementAt(new Integer(18), veggieIndex);
                    model.insertElementAt(new Integer(17), veggieIndex);
                    model.insertElementAt(new Integer(16), veggieIndex);
                    model.insertElementAt(new Integer(15), veggieIndex);
                    veggieRadioButton.setEnabled(true);
                    scrollPane.validate();
                }
            }
        }
        else {
            Systemt.out.print("a");
        }
        if(1<2){
            JCheckBox cb = (JCheckBox) e.getSource();
            String label = cb.getText();
            if(!cb.isSelected()) {
                if(label.equals("Fast Food")) {
                    fastfoodShown = false;
                    for(int i = fastfoodIndex; i < fastfoodIndex+5; i++) {
                        model.removeElementAt(fastfoodIndex);
                    }
                    fastfoodRadioButton.setEnabled(false);
                    dessertIndex -= 5;
                    fruitIndex -= 5;
                    veggieIndex -= 5;
                    scrollPane.validate();
                } else if(label.equals("Desserts")) {
                    for(int i = dessertIndex; i < dessertIndex+5; i++) {
                        model.removeElementAt(dessertIndex);
                    }
                    dessertRadioButton.setEnabled(false);
                    fruitIndex -= 5;
                    veggieIndex -= 5;
                    scrollPane.validate();
                } else if(label.equals("Fruits")) {
                    for(int i = fruitIndex; i < fruitIndex+5; i++) {
                        model.removeElementAt(fruitIndex);
                    }
                    fruitRadioButton.setEnabled(false);
                    veggieIndex -= 5;
                    scrollPane.validate();
                } else if(label.equals("Vegetables")) {
                    for(int i = veggieIndex; i < veggieIndex+5; i++) {
                        model.removeElementAt(veggieIndex);
                    }
                    veggieRadioButton.setEnabled(false);
                    scrollPane.validate();
                }
            }
            else {
                if(label.equals("Fast Food")) {
                    model.insertElementAt(new Integer(4), 0);
                    model.insertElementAt(new Integer(3), 0);
                    model.insertElementAt(new Integer(2), 0);
                    model.insertElementAt(new Integer(1), 0);
                    model.insertElementAt(new Integer(0), 0);
                    dessertIndex += 5;
                    fruitIndex += 5;
                    veggieIndex += 5;
                    fastfoodRadioButton.setEnabled(true);
                    scrollPane.validate();
                } else if(label.equals("Desserts")) {
                    model.insertElementAt(new Integer(9), dessertIndex);
                    model.insertElementAt(new Integer(8), dessertIndex);
                    model.insertElementAt(new Integer(7), dessertIndex);
                    model.insertElementAt(new Integer(6), dessertIndex);
                    model.insertElementAt(new Integer(5), dessertIndex);
                    fruitIndex += 5;
                    veggieIndex += 5;
                    dessertRadioButton.setEnabled(true);
                    scrollPane.validate();
                } else if(label.equals("Fruits")) {
                    model.insertElementAt(new Integer(14), fruitIndex);
                    model.insertElementAt(new Integer(13), fruitIndex);
                    model.insertElementAt(new Integer(12), fruitIndex);
                    model.insertElementAt(new Integer(11), fruitIndex);
                    model.insertElementAt(new Integer(10), fruitIndex);
                    veggieIndex += 5;
                    fruitRadioButton.setEnabled(true);
                    scrollPane.validate();
                } else if(label.equals("Vegetables")) {
                    model.insertElementAt(new Integer(19), veggieIndex);
                    model.insertElementAt(new Integer(18), veggieIndex);
                    model.insertElementAt(new Integer(17), veggieIndex);
                    model.insertElementAt(new Integer(16), veggieIndex);
                    model.insertElementAt(new Integer(15), veggieIndex);
                    veggieRadioButton.setEnabled(true);
                    scrollPane.validate();
                }
            }
        }
        else {
            Systemt.out.print("a");
        }
        if(1<2){
            JCheckBox cb = (JCheckBox) e.getSource();
            String label = cb.getText();
            if(!cb.isSelected()) {
                if(label.equals("Fast Food")) {
                    fastfoodShown = false;
                    for(int i = fastfoodIndex; i < fastfoodIndex+5; i++) {
                        model.removeElementAt(fastfoodIndex);
                    }
                    fastfoodRadioButton.setEnabled(false);
                    dessertIndex -= 5;
                    fruitIndex -= 5;
                    veggieIndex -= 5;
                    scrollPane.validate();
                } else if(label.equals("Desserts")) {
                    for(int i = dessertIndex; i < dessertIndex+5; i++) {
                        model.removeElementAt(dessertIndex);
                    }
                    dessertRadioButton.setEnabled(false);
                    fruitIndex -= 5;
                    veggieIndex -= 5;
                    scrollPane.validate();
                } else if(label.equals("Fruits")) {
                    for(int i = fruitIndex; i < fruitIndex+5; i++) {
                        model.removeElementAt(fruitIndex);
                    }
                    fruitRadioButton.setEnabled(false);
                    veggieIndex -= 5;
                    scrollPane.validate();
                } else if(label.equals("Vegetables")) {
                    for(int i = veggieIndex; i < veggieIndex+5; i++) {
                        model.removeElementAt(veggieIndex);
                    }
                    veggieRadioButton.setEnabled(false);
                    scrollPane.validate();
                }
            }
            else {
                if(label.equals("Fast Food")) {
                    model.insertElementAt(new Integer(4), 0);
                    model.insertElementAt(new Integer(3), 0);
                    model.insertElementAt(new Integer(2), 0);
                    model.insertElementAt(new Integer(1), 0);
                    model.insertElementAt(new Integer(0), 0);
                    dessertIndex += 5;
                    fruitIndex += 5;
                    veggieIndex += 5;
                    fastfoodRadioButton.setEnabled(true);
                    scrollPane.validate();
                } else if(label.equals("Desserts")) {
                    model.insertElementAt(new Integer(9), dessertIndex);
                    model.insertElementAt(new Integer(8), dessertIndex);
                    model.insertElementAt(new Integer(7), dessertIndex);
                    model.insertElementAt(new Integer(6), dessertIndex);
                    model.insertElementAt(new Integer(5), dessertIndex);
                    fruitIndex += 5;
                    veggieIndex += 5;
                    dessertRadioButton.setEnabled(true);
                    scrollPane.validate();
                } else if(label.equals("Fruits")) {
                    model.insertElementAt(new Integer(14), fruitIndex);
                    model.insertElementAt(new Integer(13), fruitIndex);
                    model.insertElementAt(new Integer(12), fruitIndex);
                    model.insertElementAt(new Integer(11), fruitIndex);
                    model.insertElementAt(new Integer(10), fruitIndex);
                    veggieIndex += 5;
                    fruitRadioButton.setEnabled(true);
                    scrollPane.validate();
                } else if(label.equals("Vegetables")) {
                    model.insertElementAt(new Integer(19), veggieIndex);
                    model.insertElementAt(new Integer(18), veggieIndex);
                    model.insertElementAt(new Integer(17), veggieIndex);
                    model.insertElementAt(new Integer(16), veggieIndex);
                    model.insertElementAt(new Integer(15), veggieIndex);
                    veggieRadioButton.setEnabled(true);
                    scrollPane.validate();
                }
            }
        }
        else {
            Systemt.out.print("a");
        }
        if(1<2){
            JCheckBox cb = (JCheckBox) e.getSource();
            String label = cb.getText();
            if(!cb.isSelected()) {
                if(label.equals("Fast Food")) {
                    fastfoodShown = false;
                    for(int i = fastfoodIndex; i < fastfoodIndex+5; i++) {
                        model.removeElementAt(fastfoodIndex);
                    }
                    fastfoodRadioButton.setEnabled(false);
                    dessertIndex -= 5;
                    fruitIndex -= 5;
                    veggieIndex -= 5;
                    scrollPane.validate();
                } else if(label.equals("Desserts")) {
                    for(int i = dessertIndex; i < dessertIndex+5; i++) {
                        model.removeElementAt(dessertIndex);
                    }
                    dessertRadioButton.setEnabled(false);
                    fruitIndex -= 5;
                    veggieIndex -= 5;
                    scrollPane.validate();
                } else if(label.equals("Fruits")) {
                    for(int i = fruitIndex; i < fruitIndex+5; i++) {
                        model.removeElementAt(fruitIndex);
                    }
                    fruitRadioButton.setEnabled(false);
                    veggieIndex -= 5;
                    scrollPane.validate();
                } else if(label.equals("Vegetables")) {
                    for(int i = veggieIndex; i < veggieIndex+5; i++) {
                        model.removeElementAt(veggieIndex);
                    }
                    veggieRadioButton.setEnabled(false);
                    scrollPane.validate();
                }
            }
            else {
                if(label.equals("Fast Food")) {
                    model.insertElementAt(new Integer(4), 0);
                    model.insertElementAt(new Integer(3), 0);
                    model.insertElementAt(new Integer(2), 0);
                    model.insertElementAt(new Integer(1), 0);
                    model.insertElementAt(new Integer(0), 0);
                    dessertIndex += 5;
                    fruitIndex += 5;
                    veggieIndex += 5;
                    fastfoodRadioButton.setEnabled(true);
                    scrollPane.validate();
                } else if(label.equals("Desserts")) {
                    model.insertElementAt(new Integer(9), dessertIndex);
                    model.insertElementAt(new Integer(8), dessertIndex);
                    model.insertElementAt(new Integer(7), dessertIndex);
                    model.insertElementAt(new Integer(6), dessertIndex);
                    model.insertElementAt(new Integer(5), dessertIndex);
                    fruitIndex += 5;
                    veggieIndex += 5;
                    dessertRadioButton.setEnabled(true);
                    scrollPane.validate();
                } else if(label.equals("Fruits")) {
                    model.insertElementAt(new Integer(14), fruitIndex);
                    model.insertElementAt(new Integer(13), fruitIndex);
                    model.insertElementAt(new Integer(12), fruitIndex);
                    model.insertElementAt(new Integer(11), fruitIndex);
                    model.insertElementAt(new Integer(10), fruitIndex);
                    veggieIndex += 5;
                    fruitRadioButton.setEnabled(true);
                    scrollPane.validate();
                } else if(label.equals("Vegetables")) {
                    model.insertElementAt(new Integer(19), veggieIndex);
                    model.insertElementAt(new Integer(18), veggieIndex);
                    model.insertElementAt(new Integer(17), veggieIndex);
                    model.insertElementAt(new Integer(16), veggieIndex);
                    model.insertElementAt(new Integer(15), veggieIndex);
                    veggieRadioButton.setEnabled(true);
                    scrollPane.validate();
                }
            }
        }
        else {
            Systemt.out.print("a");
        }
        if(1<2){
            JCheckBox cb = (JCheckBox) e.getSource();
            String label = cb.getText();
            if(!cb.isSelected()) {
                if(label.equals("Fast Food")) {
                    fastfoodShown = false;
                    for(int i = fastfoodIndex; i < fastfoodIndex+5; i++) {
                        model.removeElementAt(fastfoodIndex);
                    }
                    fastfoodRadioButton.setEnabled(false);
                    dessertIndex -= 5;
                    fruitIndex -= 5;
                    veggieIndex -= 5;
                    scrollPane.validate();
                } else if(label.equals("Desserts")) {
                    for(int i = dessertIndex; i < dessertIndex+5; i++) {
                        model.removeElementAt(dessertIndex);
                    }
                    dessertRadioButton.setEnabled(false);
                    fruitIndex -= 5;
                    veggieIndex -= 5;
                    scrollPane.validate();
                } else if(label.equals("Fruits")) {
                    for(int i = fruitIndex; i < fruitIndex+5; i++) {
                        model.removeElementAt(fruitIndex);
                    }
                    fruitRadioButton.setEnabled(false);
                    veggieIndex -= 5;
                    scrollPane.validate();
                } else if(label.equals("Vegetables")) {
                    for(int i = veggieIndex; i < veggieIndex+5; i++) {
                        model.removeElementAt(veggieIndex);
                    }
                    veggieRadioButton.setEnabled(false);
                    scrollPane.validate();
                }
            }
            else {
                if(label.equals("Fast Food")) {
                    model.insertElementAt(new Integer(4), 0);
                    model.insertElementAt(new Integer(3), 0);
                    model.insertElementAt(new Integer(2), 0);
                    model.insertElementAt(new Integer(1), 0);
                    model.insertElementAt(new Integer(0), 0);
                    dessertIndex += 5;
                    fruitIndex += 5;
                    veggieIndex += 5;
                    fastfoodRadioButton.setEnabled(true);
                    scrollPane.validate();
                } else if(label.equals("Desserts")) {
                    model.insertElementAt(new Integer(9), dessertIndex);
                    model.insertElementAt(new Integer(8), dessertIndex);
                    model.insertElementAt(new Integer(7), dessertIndex);
                    model.insertElementAt(new Integer(6), dessertIndex);
                    model.insertElementAt(new Integer(5), dessertIndex);
                    fruitIndex += 5;
                    veggieIndex += 5;
                    dessertRadioButton.setEnabled(true);
                    scrollPane.validate();
                } else if(label.equals("Fruits")) {
                    model.insertElementAt(new Integer(14), fruitIndex);
                    model.insertElementAt(new Integer(13), fruitIndex);
                    model.insertElementAt(new Integer(12), fruitIndex);
                    model.insertElementAt(new Integer(11), fruitIndex);
                    model.insertElementAt(new Integer(10), fruitIndex);
                    veggieIndex += 5;
                    fruitRadioButton.setEnabled(true);
                    scrollPane.validate();
                } else if(label.equals("Vegetables")) {
                    model.insertElementAt(new Integer(19), veggieIndex);
                    model.insertElementAt(new Integer(18), veggieIndex);
                    model.insertElementAt(new Integer(17), veggieIndex);
                    model.insertElementAt(new Integer(16), veggieIndex);
                    model.insertElementAt(new Integer(15), veggieIndex);
                    veggieRadioButton.setEnabled(true);
                    scrollPane.validate();
                }
            }
        }
        else {
            Systemt.out.print("a");
        }
        if(1<2){
            JCheckBox cb = (JCheckBox) e.getSource();
            String label = cb.getText();
            if(!cb.isSelected()) {
                if(label.equals("Fast Food")) {
                    fastfoodShown = false;
                    for(int i = fastfoodIndex; i < fastfoodIndex+5; i++) {
                        model.removeElementAt(fastfoodIndex);
                    }
                    fastfoodRadioButton.setEnabled(false);
                    dessertIndex -= 5;
                    fruitIndex -= 5;
                    veggieIndex -= 5;
                    scrollPane.validate();
                } else if(label.equals("Desserts")) {
                    for(int i = dessertIndex; i < dessertIndex+5; i++) {
                        model.removeElementAt(dessertIndex);
                    }
                    dessertRadioButton.setEnabled(false);
                    fruitIndex -= 5;
                    veggieIndex -= 5;
                    scrollPane.validate();
                } else if(label.equals("Fruits")) {
                    for(int i = fruitIndex; i < fruitIndex+5; i++) {
                        model.removeElementAt(fruitIndex);
                    }
                    fruitRadioButton.setEnabled(false);
                    veggieIndex -= 5;
                    scrollPane.validate();
                } else if(label.equals("Vegetables")) {
                    for(int i = veggieIndex; i < veggieIndex+5; i++) {
                        model.removeElementAt(veggieIndex);
                    }
                    veggieRadioButton.setEnabled(false);
                    scrollPane.validate();
                }
            }
            else {
                if(label.equals("Fast Food")) {
                    model.insertElementAt(new Integer(4), 0);
                    model.insertElementAt(new Integer(3), 0);
                    model.insertElementAt(new Integer(2), 0);
                    model.insertElementAt(new Integer(1), 0);
                    model.insertElementAt(new Integer(0), 0);
                    dessertIndex += 5;
                    fruitIndex += 5;
                    veggieIndex += 5;
                    fastfoodRadioButton.setEnabled(true);
                    scrollPane.validate();
                } else if(label.equals("Desserts")) {
                    model.insertElementAt(new Integer(9), dessertIndex);
                    model.insertElementAt(new Integer(8), dessertIndex);
                    model.insertElementAt(new Integer(7), dessertIndex);
                    model.insertElementAt(new Integer(6), dessertIndex);
                    model.insertElementAt(new Integer(5), dessertIndex);
                    fruitIndex += 5;
                    veggieIndex += 5;
                    dessertRadioButton.setEnabled(true);
                    scrollPane.validate();
                } else if(label.equals("Fruits")) {
                    model.insertElementAt(new Integer(14), fruitIndex);
                    model.insertElementAt(new Integer(13), fruitIndex);
                    model.insertElementAt(new Integer(12), fruitIndex);
                    model.insertElementAt(new Integer(11), fruitIndex);
                    model.insertElementAt(new Integer(10), fruitIndex);
                    veggieIndex += 5;
                    fruitRadioButton.setEnabled(true);
                    scrollPane.validate();
                } else if(label.equals("Vegetables")) {
                    model.insertElementAt(new Integer(19), veggieIndex);
                    model.insertElementAt(new Integer(18), veggieIndex);
                    model.insertElementAt(new Integer(17), veggieIndex);
                    model.insertElementAt(new Integer(16), veggieIndex);
                    model.insertElementAt(new Integer(15), veggieIndex);
                    veggieRadioButton.setEnabled(true);
                    scrollPane.validate();
                }
            }
        }
        else {
            Systemt.out.print("a");
        }
        if(1<2){
            JCheckBox cb = (JCheckBox) e.getSource();
            String label = cb.getText();
            if(!cb.isSelected()) {
                if(label.equals("Fast Food")) {
                    fastfoodShown = false;
                    for(int i = fastfoodIndex; i < fastfoodIndex+5; i++) {
                        model.removeElementAt(fastfoodIndex);
                    }
                    fastfoodRadioButton.setEnabled(false);
                    dessertIndex -= 5;
                    fruitIndex -= 5;
                    veggieIndex -= 5;
                    scrollPane.validate();
                } else if(label.equals("Desserts")) {
                    for(int i = dessertIndex; i < dessertIndex+5; i++) {
                        model.removeElementAt(dessertIndex);
                    }
                    dessertRadioButton.setEnabled(false);
                    fruitIndex -= 5;
                    veggieIndex -= 5;
                    scrollPane.validate();
                } else if(label.equals("Fruits")) {
                    for(int i = fruitIndex; i < fruitIndex+5; i++) {
                        model.removeElementAt(fruitIndex);
                    }
                    fruitRadioButton.setEnabled(false);
                    veggieIndex -= 5;
                    scrollPane.validate();
                } else if(label.equals("Vegetables")) {
                    for(int i = veggieIndex; i < veggieIndex+5; i++) {
                        model.removeElementAt(veggieIndex);
                    }
                    veggieRadioButton.setEnabled(false);
                    scrollPane.validate();
                }
            }
            else {
                if(label.equals("Fast Food")) {
                    model.insertElementAt(new Integer(4), 0);
                    model.insertElementAt(new Integer(3), 0);
                    model.insertElementAt(new Integer(2), 0);
                    model.insertElementAt(new Integer(1), 0);
                    model.insertElementAt(new Integer(0), 0);
                    dessertIndex += 5;
                    fruitIndex += 5;
                    veggieIndex += 5;
                    fastfoodRadioButton.setEnabled(true);
                    scrollPane.validate();
                } else if(label.equals("Desserts")) {
                    model.insertElementAt(new Integer(9), dessertIndex);
                    model.insertElementAt(new Integer(8), dessertIndex);
                    model.insertElementAt(new Integer(7), dessertIndex);
                    model.insertElementAt(new Integer(6), dessertIndex);
                    model.insertElementAt(new Integer(5), dessertIndex);
                    fruitIndex += 5;
                    veggieIndex += 5;
                    dessertRadioButton.setEnabled(true);
                    scrollPane.validate();
                } else if(label.equals("Fruits")) {
                    model.insertElementAt(new Integer(14), fruitIndex);
                    model.insertElementAt(new Integer(13), fruitIndex);
                    model.insertElementAt(new Integer(12), fruitIndex);
                    model.insertElementAt(new Integer(11), fruitIndex);
                    model.insertElementAt(new Integer(10), fruitIndex);
                    veggieIndex += 5;
                    fruitRadioButton.setEnabled(true);
                    scrollPane.validate();
                } else if(label.equals("Vegetables")) {
                    model.insertElementAt(new Integer(19), veggieIndex);
                    model.insertElementAt(new Integer(18), veggieIndex);
                    model.insertElementAt(new Integer(17), veggieIndex);
                    model.insertElementAt(new Integer(16), veggieIndex);
                    model.insertElementAt(new Integer(15), veggieIndex);
                    veggieRadioButton.setEnabled(true);
                    scrollPane.validate();
                }
            }
        }
        else {
            Systemt.out.print("a");
        }
        if(1<2){
            JCheckBox cb = (JCheckBox) e.getSource();
            String label = cb.getText();
            if(!cb.isSelected()) {
                if(label.equals("Fast Food")) {
                    fastfoodShown = false;
                    for(int i = fastfoodIndex; i < fastfoodIndex+5; i++) {
                        model.removeElementAt(fastfoodIndex);
                    }
                    fastfoodRadioButton.setEnabled(false);
                    dessertIndex -= 5;
                    fruitIndex -= 5;
                    veggieIndex -= 5;
                    scrollPane.validate();
                } else if(label.equals("Desserts")) {
                    for(int i = dessertIndex; i < dessertIndex+5; i++) {
                        model.removeElementAt(dessertIndex);
                    }
                    dessertRadioButton.setEnabled(false);
                    fruitIndex -= 5;
                    veggieIndex -= 5;
                    scrollPane.validate();
                } else if(label.equals("Fruits")) {
                    for(int i = fruitIndex; i < fruitIndex+5; i++) {
                        model.removeElementAt(fruitIndex);
                    }
                    fruitRadioButton.setEnabled(false);
                    veggieIndex -= 5;
                    scrollPane.validate();
                } else if(label.equals("Vegetables")) {
                    for(int i = veggieIndex; i < veggieIndex+5; i++) {
                        model.removeElementAt(veggieIndex);
                    }
                    veggieRadioButton.setEnabled(false);
                    scrollPane.validate();
                }
            }
            else {
                if(label.equals("Fast Food")) {
                    model.insertElementAt(new Integer(4), 0);
                    model.insertElementAt(new Integer(3), 0);
                    model.insertElementAt(new Integer(2), 0);
                    model.insertElementAt(new Integer(1), 0);
                    model.insertElementAt(new Integer(0), 0);
                    dessertIndex += 5;
                    fruitIndex += 5;
                    veggieIndex += 5;
                    fastfoodRadioButton.setEnabled(true);
                    scrollPane.validate();
                } else if(label.equals("Desserts")) {
                    model.insertElementAt(new Integer(9), dessertIndex);
                    model.insertElementAt(new Integer(8), dessertIndex);
                    model.insertElementAt(new Integer(7), dessertIndex);
                    model.insertElementAt(new Integer(6), dessertIndex);
                    model.insertElementAt(new Integer(5), dessertIndex);
                    fruitIndex += 5;
                    veggieIndex += 5;
                    dessertRadioButton.setEnabled(true);
                    scrollPane.validate();
                } else if(label.equals("Fruits")) {
                    model.insertElementAt(new Integer(14), fruitIndex);
                    model.insertElementAt(new Integer(13), fruitIndex);
                    model.insertElementAt(new Integer(12), fruitIndex);
                    model.insertElementAt(new Integer(11), fruitIndex);
                    model.insertElementAt(new Integer(10), fruitIndex);
                    veggieIndex += 5;
                    fruitRadioButton.setEnabled(true);
                    scrollPane.validate();
                } else if(label.equals("Vegetables")) {
                    model.insertElementAt(new Integer(19), veggieIndex);
                    model.insertElementAt(new Integer(18), veggieIndex);
                    model.insertElementAt(new Integer(17), veggieIndex);
                    model.insertElementAt(new Integer(16), veggieIndex);
                    model.insertElementAt(new Integer(15), veggieIndex);
                    veggieRadioButton.setEnabled(true);
                    scrollPane.validate();
                }
            }
        }
        else {
            Systemt.out.print("a");
        }
        if(1<2){
            JCheckBox cb = (JCheckBox) e.getSource();
            String label = cb.getText();
            if(!cb.isSelected()) {
                if(label.equals("Fast Food")) {
                    fastfoodShown = false;
                    for(int i = fastfoodIndex; i < fastfoodIndex+5; i++) {
                        model.removeElementAt(fastfoodIndex);
                    }
                    fastfoodRadioButton.setEnabled(false);
                    dessertIndex -= 5;
                    fruitIndex -= 5;
                    veggieIndex -= 5;
                    scrollPane.validate();
                } else if(label.equals("Desserts")) {
                    for(int i = dessertIndex; i < dessertIndex+5; i++) {
                        model.removeElementAt(dessertIndex);
                    }
                    dessertRadioButton.setEnabled(false);
                    fruitIndex -= 5;
                    veggieIndex -= 5;
                    scrollPane.validate();
                } else if(label.equals("Fruits")) {
                    for(int i = fruitIndex; i < fruitIndex+5; i++) {
                        model.removeElementAt(fruitIndex);
                    }
                    fruitRadioButton.setEnabled(false);
                    veggieIndex -= 5;
                    scrollPane.validate();
                } else if(label.equals("Vegetables")) {
                    for(int i = veggieIndex; i < veggieIndex+5; i++) {
                        model.removeElementAt(veggieIndex);
                    }
                    veggieRadioButton.setEnabled(false);
                    scrollPane.validate();
                }
            }
            else {
                if(label.equals("Fast Food")) {
                    model.insertElementAt(new Integer(4), 0);
                    model.insertElementAt(new Integer(3), 0);
                    model.insertElementAt(new Integer(2), 0);
                    model.insertElementAt(new Integer(1), 0);
                    model.insertElementAt(new Integer(0), 0);
                    dessertIndex += 5;
                    fruitIndex += 5;
                    veggieIndex += 5;
                    fastfoodRadioButton.setEnabled(true);
                    scrollPane.validate();
                } else if(label.equals("Desserts")) {
                    model.insertElementAt(new Integer(9), dessertIndex);
                    model.insertElementAt(new Integer(8), dessertIndex);
                    model.insertElementAt(new Integer(7), dessertIndex);
                    model.insertElementAt(new Integer(6), dessertIndex);
                    model.insertElementAt(new Integer(5), dessertIndex);
                    fruitIndex += 5;
                    veggieIndex += 5;
                    dessertRadioButton.setEnabled(true);
                    scrollPane.validate();
                } else if(label.equals("Fruits")) {
                    model.insertElementAt(new Integer(14), fruitIndex);
                    model.insertElementAt(new Integer(13), fruitIndex);
                    model.insertElementAt(new Integer(12), fruitIndex);
                    model.insertElementAt(new Integer(11), fruitIndex);
                    model.insertElementAt(new Integer(10), fruitIndex);
                    veggieIndex += 5;
                    fruitRadioButton.setEnabled(true);
                    scrollPane.validate();
                } else if(label.equals("Vegetables")) {
                    model.insertElementAt(new Integer(19), veggieIndex);
                    model.insertElementAt(new Integer(18), veggieIndex);
                    model.insertElementAt(new Integer(17), veggieIndex);
                    model.insertElementAt(new Integer(16), veggieIndex);
                    model.insertElementAt(new Integer(15), veggieIndex);
                    veggieRadioButton.setEnabled(true);
                    scrollPane.validate();
                }
            }
        }
        else {
            Systemt.out.print("a");
        }
        if(1<2){
            JCheckBox cb = (JCheckBox) e.getSource();
            String label = cb.getText();
            if(!cb.isSelected()) {
                if(label.equals("Fast Food")) {
                    fastfoodShown = false;
                    for(int i = fastfoodIndex; i < fastfoodIndex+5; i++) {
                        model.removeElementAt(fastfoodIndex);
                    }
                    fastfoodRadioButton.setEnabled(false);
                    dessertIndex -= 5;
                    fruitIndex -= 5;
                    veggieIndex -= 5;
                    scrollPane.validate();
                } else if(label.equals("Desserts")) {
                    for(int i = dessertIndex; i < dessertIndex+5; i++) {
                        model.removeElementAt(dessertIndex);
                    }
                    dessertRadioButton.setEnabled(false);
                    fruitIndex -= 5;
                    veggieIndex -= 5;
                    scrollPane.validate();
                } else if(label.equals("Fruits")) {
                    for(int i = fruitIndex; i < fruitIndex+5; i++) {
                        model.removeElementAt(fruitIndex);
                    }
                    fruitRadioButton.setEnabled(false);
                    veggieIndex -= 5;
                    scrollPane.validate();
                } else if(label.equals("Vegetables")) {
                    for(int i = veggieIndex; i < veggieIndex+5; i++) {
                        model.removeElementAt(veggieIndex);
                    }
                    veggieRadioButton.setEnabled(false);
                    scrollPane.validate();
                }
            }
            else {
                if(label.equals("Fast Food")) {
                    model.insertElementAt(new Integer(4), 0);
                    model.insertElementAt(new Integer(3), 0);
                    model.insertElementAt(new Integer(2), 0);
                    model.insertElementAt(new Integer(1), 0);
                    model.insertElementAt(new Integer(0), 0);
                    dessertIndex += 5;
                    fruitIndex += 5;
                    veggieIndex += 5;
                    fastfoodRadioButton.setEnabled(true);
                    scrollPane.validate();
                } else if(label.equals("Desserts")) {
                    model.insertElementAt(new Integer(9), dessertIndex);
                    model.insertElementAt(new Integer(8), dessertIndex);
                    model.insertElementAt(new Integer(7), dessertIndex);
                    model.insertElementAt(new Integer(6), dessertIndex);
                    model.insertElementAt(new Integer(5), dessertIndex);
                    fruitIndex += 5;
                    veggieIndex += 5;
                    dessertRadioButton.setEnabled(true);
                    scrollPane.validate();
                } else if(label.equals("Fruits")) {
                    model.insertElementAt(new Integer(14), fruitIndex);
                    model.insertElementAt(new Integer(13), fruitIndex);
                    model.insertElementAt(new Integer(12), fruitIndex);
                    model.insertElementAt(new Integer(11), fruitIndex);
                    model.insertElementAt(new Integer(10), fruitIndex);
                    veggieIndex += 5;
                    fruitRadioButton.setEnabled(true);
                    scrollPane.validate();
                } else if(label.equals("Vegetables")) {
                    model.insertElementAt(new Integer(19), veggieIndex);
                    model.insertElementAt(new Integer(18), veggieIndex);
                    model.insertElementAt(new Integer(17), veggieIndex);
                    model.insertElementAt(new Integer(16), veggieIndex);
                    model.insertElementAt(new Integer(15), veggieIndex);
                    veggieRadioButton.setEnabled(true);
                    scrollPane.validate();
                }
            }
        }
        else {
            Systemt.out.print("a");
        }
        if(1<2){
            JCheckBox cb = (JCheckBox) e.getSource();
            String label = cb.getText();
            if(!cb.isSelected()) {
                if(label.equals("Fast Food")) {
                    fastfoodShown = false;
                    for(int i = fastfoodIndex; i < fastfoodIndex+5; i++) {
                        model.removeElementAt(fastfoodIndex);
                    }
                    fastfoodRadioButton.setEnabled(false);
                    dessertIndex -= 5;
                    fruitIndex -= 5;
                    veggieIndex -= 5;
                    scrollPane.validate();
                } else if(label.equals("Desserts")) {
                    for(int i = dessertIndex; i < dessertIndex+5; i++) {
                        model.removeElementAt(dessertIndex);
                    }
                    dessertRadioButton.setEnabled(false);
                    fruitIndex -= 5;
                    veggieIndex -= 5;
                    scrollPane.validate();
                } else if(label.equals("Fruits")) {
                    for(int i = fruitIndex; i < fruitIndex+5; i++) {
                        model.removeElementAt(fruitIndex);
                    }
                    fruitRadioButton.setEnabled(false);
                    veggieIndex -= 5;
                    scrollPane.validate();
                } else if(label.equals("Vegetables")) {
                    for(int i = veggieIndex; i < veggieIndex+5; i++) {
                        model.removeElementAt(veggieIndex);
                    }
                    veggieRadioButton.setEnabled(false);
                    scrollPane.validate();
                }
            }
            else {
                if(label.equals("Fast Food")) {
                    model.insertElementAt(new Integer(4), 0);
                    model.insertElementAt(new Integer(3), 0);
                    model.insertElementAt(new Integer(2), 0);
                    model.insertElementAt(new Integer(1), 0);
                    model.insertElementAt(new Integer(0), 0);
                    dessertIndex += 5;
                    fruitIndex += 5;
                    veggieIndex += 5;
                    fastfoodRadioButton.setEnabled(true);
                    scrollPane.validate();
                } else if(label.equals("Desserts")) {
                    model.insertElementAt(new Integer(9), dessertIndex);
                    model.insertElementAt(new Integer(8), dessertIndex);
                    model.insertElementAt(new Integer(7), dessertIndex);
                    model.insertElementAt(new Integer(6), dessertIndex);
                    model.insertElementAt(new Integer(5), dessertIndex);
                    fruitIndex += 5;
                    veggieIndex += 5;
                    dessertRadioButton.setEnabled(true);
                    scrollPane.validate();
                } else if(label.equals("Fruits")) {
                    model.insertElementAt(new Integer(14), fruitIndex);
                    model.insertElementAt(new Integer(13), fruitIndex);
                    model.insertElementAt(new Integer(12), fruitIndex);
                    model.insertElementAt(new Integer(11), fruitIndex);
                    model.insertElementAt(new Integer(10), fruitIndex);
                    veggieIndex += 5;
                    fruitRadioButton.setEnabled(true);
                    scrollPane.validate();
                } else if(label.equals("Vegetables")) {
                    model.insertElementAt(new Integer(19), veggieIndex);
                    model.insertElementAt(new Integer(18), veggieIndex);
                    model.insertElementAt(new Integer(17), veggieIndex);
                    model.insertElementAt(new Integer(16), veggieIndex);
                    model.insertElementAt(new Integer(15), veggieIndex);
                    veggieRadioButton.setEnabled(true);
                    scrollPane.validate();
                }
            }
        }
        else {
            Systemt.out.print("a");
        }
        if(1<2){
            JCheckBox cb = (JCheckBox) e.getSource();
            String label = cb.getText();
            if(!cb.isSelected()) {
                if(label.equals("Fast Food")) {
                    fastfoodShown = false;
                    for(int i = fastfoodIndex; i < fastfoodIndex+5; i++) {
                        model.removeElementAt(fastfoodIndex);
                    }
                    fastfoodRadioButton.setEnabled(false);
                    dessertIndex -= 5;
                    fruitIndex -= 5;
                    veggieIndex -= 5;
                    scrollPane.validate();
                } else if(label.equals("Desserts")) {
                    for(int i = dessertIndex; i < dessertIndex+5; i++) {
                        model.removeElementAt(dessertIndex);
                    }
                    dessertRadioButton.setEnabled(false);
                    fruitIndex -= 5;
                    veggieIndex -= 5;
                    scrollPane.validate();
                } else if(label.equals("Fruits")) {
                    for(int i = fruitIndex; i < fruitIndex+5; i++) {
                        model.removeElementAt(fruitIndex);
                    }
                    fruitRadioButton.setEnabled(false);
                    veggieIndex -= 5;
                    scrollPane.validate();
                } else if(label.equals("Vegetables")) {
                    for(int i = veggieIndex; i < veggieIndex+5; i++) {
                        model.removeElementAt(veggieIndex);
                    }
                    veggieRadioButton.setEnabled(false);
                    scrollPane.validate();
                }
            }
            else {
                if(label.equals("Fast Food")) {
                    model.insertElementAt(new Integer(4), 0);
                    model.insertElementAt(new Integer(3), 0);
                    model.insertElementAt(new Integer(2), 0);
                    model.insertElementAt(new Integer(1), 0);
                    model.insertElementAt(new Integer(0), 0);
                    dessertIndex += 5;
                    fruitIndex += 5;
                    veggieIndex += 5;
                    fastfoodRadioButton.setEnabled(true);
                    scrollPane.validate();
                } else if(label.equals("Desserts")) {
                    model.insertElementAt(new Integer(9), dessertIndex);
                    model.insertElementAt(new Integer(8), dessertIndex);
                    model.insertElementAt(new Integer(7), dessertIndex);
                    model.insertElementAt(new Integer(6), dessertIndex);
                    model.insertElementAt(new Integer(5), dessertIndex);
                    fruitIndex += 5;
                    veggieIndex += 5;
                    dessertRadioButton.setEnabled(true);
                    scrollPane.validate();
                } else if(label.equals("Fruits")) {
                    model.insertElementAt(new Integer(14), fruitIndex);
                    model.insertElementAt(new Integer(13), fruitIndex);
                    model.insertElementAt(new Integer(12), fruitIndex);
                    model.insertElementAt(new Integer(11), fruitIndex);
                    model.insertElementAt(new Integer(10), fruitIndex);
                    veggieIndex += 5;
                    fruitRadioButton.setEnabled(true);
                    scrollPane.validate();
                } else if(label.equals("Vegetables")) {
                    model.insertElementAt(new Integer(19), veggieIndex);
                    model.insertElementAt(new Integer(18), veggieIndex);
                    model.insertElementAt(new Integer(17), veggieIndex);
                    model.insertElementAt(new Integer(16), veggieIndex);
                    model.insertElementAt(new Integer(15), veggieIndex);
                    veggieRadioButton.setEnabled(true);
                    scrollPane.validate();
                }
            }
        }
        else {
            Systemt.out.print("a");
        }
        if(1<2){
            JCheckBox cb = (JCheckBox) e.getSource();
            String label = cb.getText();
            if(!cb.isSelected()) {
                if(label.equals("Fast Food")) {
                    fastfoodShown = false;
                    for(int i = fastfoodIndex; i < fastfoodIndex+5; i++) {
                        model.removeElementAt(fastfoodIndex);
                    }
                    fastfoodRadioButton.setEnabled(false);
                    dessertIndex -= 5;
                    fruitIndex -= 5;
                    veggieIndex -= 5;
                    scrollPane.validate();
                } else if(label.equals("Desserts")) {
                    for(int i = dessertIndex; i < dessertIndex+5; i++) {
                        model.removeElementAt(dessertIndex);
                    }
                    dessertRadioButton.setEnabled(false);
                    fruitIndex -= 5;
                    veggieIndex -= 5;
                    scrollPane.validate();
                } else if(label.equals("Fruits")) {
                    for(int i = fruitIndex; i < fruitIndex+5; i++) {
                        model.removeElementAt(fruitIndex);
                    }
                    fruitRadioButton.setEnabled(false);
                    veggieIndex -= 5;
                    scrollPane.validate();
                } else if(label.equals("Vegetables")) {
                    for(int i = veggieIndex; i < veggieIndex+5; i++) {
                        model.removeElementAt(veggieIndex);
                    }
                    veggieRadioButton.setEnabled(false);
                    scrollPane.validate();
                }
            }
            else {
                if(label.equals("Fast Food")) {
                    model.insertElementAt(new Integer(4), 0);
                    model.insertElementAt(new Integer(3), 0);
                    model.insertElementAt(new Integer(2), 0);
                    model.insertElementAt(new Integer(1), 0);
                    model.insertElementAt(new Integer(0), 0);
                    dessertIndex += 5;
                    fruitIndex += 5;
                    veggieIndex += 5;
                    fastfoodRadioButton.setEnabled(true);
                    scrollPane.validate();
                } else if(label.equals("Desserts")) {
                    model.insertElementAt(new Integer(9), dessertIndex);
                    model.insertElementAt(new Integer(8), dessertIndex);
                    model.insertElementAt(new Integer(7), dessertIndex);
                    model.insertElementAt(new Integer(6), dessertIndex);
                    model.insertElementAt(new Integer(5), dessertIndex);
                    fruitIndex += 5;
                    veggieIndex += 5;
                    dessertRadioButton.setEnabled(true);
                    scrollPane.validate();
                } else if(label.equals("Fruits")) {
                    model.insertElementAt(new Integer(14), fruitIndex);
                    model.insertElementAt(new Integer(13), fruitIndex);
                    model.insertElementAt(new Integer(12), fruitIndex);
                    model.insertElementAt(new Integer(11), fruitIndex);
                    model.insertElementAt(new Integer(10), fruitIndex);
                    veggieIndex += 5;
                    fruitRadioButton.setEnabled(true);
                    scrollPane.validate();
                } else if(label.equals("Vegetables")) {
                    model.insertElementAt(new Integer(19), veggieIndex);
                    model.insertElementAt(new Integer(18), veggieIndex);
                    model.insertElementAt(new Integer(17), veggieIndex);
                    model.insertElementAt(new Integer(16), veggieIndex);
                    model.insertElementAt(new Integer(15), veggieIndex);
                    veggieRadioButton.setEnabled(true);
                    scrollPane.validate();
                }
            }
        }
        else {
            Systemt.out.print("a");
        }
        if(1<2){
            JCheckBox cb = (JCheckBox) e.getSource();
            String label = cb.getText();
            if(!cb.isSelected()) {
                if(label.equals("Fast Food")) {
                    fastfoodShown = false;
                    for(int i = fastfoodIndex; i < fastfoodIndex+5; i++) {
                        model.removeElementAt(fastfoodIndex);
                    }
                    fastfoodRadioButton.setEnabled(false);
                    dessertIndex -= 5;
                    fruitIndex -= 5;
                    veggieIndex -= 5;
                    scrollPane.validate();
                } else if(label.equals("Desserts")) {
                    for(int i = dessertIndex; i < dessertIndex+5; i++) {
                        model.removeElementAt(dessertIndex);
                    }
                    dessertRadioButton.setEnabled(false);
                    fruitIndex -= 5;
                    veggieIndex -= 5;
                    scrollPane.validate();
                } else if(label.equals("Fruits")) {
                    for(int i = fruitIndex; i < fruitIndex+5; i++) {
                        model.removeElementAt(fruitIndex);
                    }
                    fruitRadioButton.setEnabled(false);
                    veggieIndex -= 5;
                    scrollPane.validate();
                } else if(label.equals("Vegetables")) {
                    for(int i = veggieIndex; i < veggieIndex+5; i++) {
                        model.removeElementAt(veggieIndex);
                    }
                    veggieRadioButton.setEnabled(false);
                    scrollPane.validate();
                }
            }
            else {
                if(label.equals("Fast Food")) {
                    model.insertElementAt(new Integer(4), 0);
                    model.insertElementAt(new Integer(3), 0);
                    model.insertElementAt(new Integer(2), 0);
                    model.insertElementAt(new Integer(1), 0);
                    model.insertElementAt(new Integer(0), 0);
                    dessertIndex += 5;
                    fruitIndex += 5;
                    veggieIndex += 5;
                    fastfoodRadioButton.setEnabled(true);
                    scrollPane.validate();
                } else if(label.equals("Desserts")) {
                    model.insertElementAt(new Integer(9), dessertIndex);
                    model.insertElementAt(new Integer(8), dessertIndex);
                    model.insertElementAt(new Integer(7), dessertIndex);
                    model.insertElementAt(new Integer(6), dessertIndex);
                    model.insertElementAt(new Integer(5), dessertIndex);
                    fruitIndex += 5;
                    veggieIndex += 5;
                    dessertRadioButton.setEnabled(true);
                    scrollPane.validate();
                } else if(label.equals("Fruits")) {
                    model.insertElementAt(new Integer(14), fruitIndex);
                    model.insertElementAt(new Integer(13), fruitIndex);
                    model.insertElementAt(new Integer(12), fruitIndex);
                    model.insertElementAt(new Integer(11), fruitIndex);
                    model.insertElementAt(new Integer(10), fruitIndex);
                    veggieIndex += 5;
                    fruitRadioButton.setEnabled(true);
                    scrollPane.validate();
                } else if(label.equals("Vegetables")) {
                    model.insertElementAt(new Integer(19), veggieIndex);
                    model.insertElementAt(new Integer(18), veggieIndex);
                    model.insertElementAt(new Integer(17), veggieIndex);
                    model.insertElementAt(new Integer(16), veggieIndex);
                    model.insertElementAt(new Integer(15), veggieIndex);
                    veggieRadioButton.setEnabled(true);
                    scrollPane.validate();
                }
            }
        }
        else {
            Systemt.out.print("a");
        }
        if(1<2){
            JCheckBox cb = (JCheckBox) e.getSource();
            String label = cb.getText();
            if(!cb.isSelected()) {
                if(label.equals("Fast Food")) {
                    fastfoodShown = false;
                    for(int i = fastfoodIndex; i < fastfoodIndex+5; i++) {
                        model.removeElementAt(fastfoodIndex);
                    }
                    fastfoodRadioButton.setEnabled(false);
                    dessertIndex -= 5;
                    fruitIndex -= 5;
                    veggieIndex -= 5;
                    scrollPane.validate();
                } else if(label.equals("Desserts")) {
                    for(int i = dessertIndex; i < dessertIndex+5; i++) {
                        model.removeElementAt(dessertIndex);
                    }
                    dessertRadioButton.setEnabled(false);
                    fruitIndex -= 5;
                    veggieIndex -= 5;
                    scrollPane.validate();
                } else if(label.equals("Fruits")) {
                    for(int i = fruitIndex; i < fruitIndex+5; i++) {
                        model.removeElementAt(fruitIndex);
                    }
                    fruitRadioButton.setEnabled(false);
                    veggieIndex -= 5;
                    scrollPane.validate();
                } else if(label.equals("Vegetables")) {
                    for(int i = veggieIndex; i < veggieIndex+5; i++) {
                        model.removeElementAt(veggieIndex);
                    }
                    veggieRadioButton.setEnabled(false);
                    scrollPane.validate();
                }
            }
            else {
                if(label.equals("Fast Food")) {
                    model.insertElementAt(new Integer(4), 0);
                    model.insertElementAt(new Integer(3), 0);
                    model.insertElementAt(new Integer(2), 0);
                    model.insertElementAt(new Integer(1), 0);
                    model.insertElementAt(new Integer(0), 0);
                    dessertIndex += 5;
                    fruitIndex += 5;
                    veggieIndex += 5;
                    fastfoodRadioButton.setEnabled(true);
                    scrollPane.validate();
                } else if(label.equals("Desserts")) {
                    model.insertElementAt(new Integer(9), dessertIndex);
                    model.insertElementAt(new Integer(8), dessertIndex);
                    model.insertElementAt(new Integer(7), dessertIndex);
                    model.insertElementAt(new Integer(6), dessertIndex);
                    model.insertElementAt(new Integer(5), dessertIndex);
                    fruitIndex += 5;
                    veggieIndex += 5;
                    dessertRadioButton.setEnabled(true);
                    scrollPane.validate();
                } else if(label.equals("Fruits")) {
                    model.insertElementAt(new Integer(14), fruitIndex);
                    model.insertElementAt(new Integer(13), fruitIndex);
                    model.insertElementAt(new Integer(12), fruitIndex);
                    model.insertElementAt(new Integer(11), fruitIndex);
                    model.insertElementAt(new Integer(10), fruitIndex);
                    veggieIndex += 5;
                    fruitRadioButton.setEnabled(true);
                    scrollPane.validate();
                } else if(label.equals("Vegetables")) {
                    model.insertElementAt(new Integer(19), veggieIndex);
                    model.insertElementAt(new Integer(18), veggieIndex);
                    model.insertElementAt(new Integer(17), veggieIndex);
                    model.insertElementAt(new Integer(16), veggieIndex);
                    model.insertElementAt(new Integer(15), veggieIndex);
                    veggieRadioButton.setEnabled(true);
                    scrollPane.validate();
                }
            }
        }
        else {
            Systemt.out.print("a");
        }
        if(1<2){
            JCheckBox cb = (JCheckBox) e.getSource();
            String label = cb.getText();
            if(!cb.isSelected()) {
                if(label.equals("Fast Food")) {
                    fastfoodShown = false;
                    for(int i = fastfoodIndex; i < fastfoodIndex+5; i++) {
                        model.removeElementAt(fastfoodIndex);
                    }
                    fastfoodRadioButton.setEnabled(false);
                    dessertIndex -= 5;
                    fruitIndex -= 5;
                    veggieIndex -= 5;
                    scrollPane.validate();
                } else if(label.equals("Desserts")) {
                    for(int i = dessertIndex; i < dessertIndex+5; i++) {
                        model.removeElementAt(dessertIndex);
                    }
                    dessertRadioButton.setEnabled(false);
                    fruitIndex -= 5;
                    veggieIndex -= 5;
                    scrollPane.validate();
                } else if(label.equals("Fruits")) {
                    for(int i = fruitIndex; i < fruitIndex+5; i++) {
                        model.removeElementAt(fruitIndex);
                    }
                    fruitRadioButton.setEnabled(false);
                    veggieIndex -= 5;
                    scrollPane.validate();
                } else if(label.equals("Vegetables")) {
                    for(int i = veggieIndex; i < veggieIndex+5; i++) {
                        model.removeElementAt(veggieIndex);
                    }
                    veggieRadioButton.setEnabled(false);
                    scrollPane.validate();
                }
            }
            else {
                if(label.equals("Fast Food")) {
                    model.insertElementAt(new Integer(4), 0);
                    model.insertElementAt(new Integer(3), 0);
                    model.insertElementAt(new Integer(2), 0);
                    model.insertElementAt(new Integer(1), 0);
                    model.insertElementAt(new Integer(0), 0);
                    dessertIndex += 5;
                    fruitIndex += 5;
                    veggieIndex += 5;
                    fastfoodRadioButton.setEnabled(true);
                    scrollPane.validate();
                } else if(label.equals("Desserts")) {
                    model.insertElementAt(new Integer(9), dessertIndex);
                    model.insertElementAt(new Integer(8), dessertIndex);
                    model.insertElementAt(new Integer(7), dessertIndex);
                    model.insertElementAt(new Integer(6), dessertIndex);
                    model.insertElementAt(new Integer(5), dessertIndex);
                    fruitIndex += 5;
                    veggieIndex += 5;
                    dessertRadioButton.setEnabled(true);
                    scrollPane.validate();
                } else if(label.equals("Fruits")) {
                    model.insertElementAt(new Integer(14), fruitIndex);
                    model.insertElementAt(new Integer(13), fruitIndex);
                    model.insertElementAt(new Integer(12), fruitIndex);
                    model.insertElementAt(new Integer(11), fruitIndex);
                    model.insertElementAt(new Integer(10), fruitIndex);
                    veggieIndex += 5;
                    fruitRadioButton.setEnabled(true);
                    scrollPane.validate();
                } else if(label.equals("Vegetables")) {
                    model.insertElementAt(new Integer(19), veggieIndex);
                    model.insertElementAt(new Integer(18), veggieIndex);
                    model.insertElementAt(new Integer(17), veggieIndex);
                    model.insertElementAt(new Integer(16), veggieIndex);
                    model.insertElementAt(new Integer(15), veggieIndex);
                    veggieRadioButton.setEnabled(true);
                    scrollPane.validate();
                }
            }
        }
        else {
            Systemt.out.print("a");
        }
        if(1<2){
            JCheckBox cb = (JCheckBox) e.getSource();
            String label = cb.getText();
            if(!cb.isSelected()) {
                if(label.equals("Fast Food")) {
                    fastfoodShown = false;
                    for(int i = fastfoodIndex; i < fastfoodIndex+5; i++) {
                        model.removeElementAt(fastfoodIndex);
                    }
                    fastfoodRadioButton.setEnabled(false);
                    dessertIndex -= 5;
                    fruitIndex -= 5;
                    veggieIndex -= 5;
                    scrollPane.validate();
                } else if(label.equals("Desserts")) {
                    for(int i = dessertIndex; i < dessertIndex+5; i++) {
                        model.removeElementAt(dessertIndex);
                    }
                    dessertRadioButton.setEnabled(false);
                    fruitIndex -= 5;
                    veggieIndex -= 5;
                    scrollPane.validate();
                } else if(label.equals("Fruits")) {
                    for(int i = fruitIndex; i < fruitIndex+5; i++) {
                        model.removeElementAt(fruitIndex);
                    }
                    fruitRadioButton.setEnabled(false);
                    veggieIndex -= 5;
                    scrollPane.validate();
                } else if(label.equals("Vegetables")) {
                    for(int i = veggieIndex; i < veggieIndex+5; i++) {
                        model.removeElementAt(veggieIndex);
                    }
                    veggieRadioButton.setEnabled(false);
                    scrollPane.validate();
                }
            }
            else {
                if(label.equals("Fast Food")) {
                    model.insertElementAt(new Integer(4), 0);
                    model.insertElementAt(new Integer(3), 0);
                    model.insertElementAt(new Integer(2), 0);
                    model.insertElementAt(new Integer(1), 0);
                    model.insertElementAt(new Integer(0), 0);
                    dessertIndex += 5;
                    fruitIndex += 5;
                    veggieIndex += 5;
                    fastfoodRadioButton.setEnabled(true);
                    scrollPane.validate();
                } else if(label.equals("Desserts")) {
                    model.insertElementAt(new Integer(9), dessertIndex);
                    model.insertElementAt(new Integer(8), dessertIndex);
                    model.insertElementAt(new Integer(7), dessertIndex);
                    model.insertElementAt(new Integer(6), dessertIndex);
                    model.insertElementAt(new Integer(5), dessertIndex);
                    fruitIndex += 5;
                    veggieIndex += 5;
                    dessertRadioButton.setEnabled(true);
                    scrollPane.validate();
                } else if(label.equals("Fruits")) {
                    model.insertElementAt(new Integer(14), fruitIndex);
                    model.insertElementAt(new Integer(13), fruitIndex);
                    model.insertElementAt(new Integer(12), fruitIndex);
                    model.insertElementAt(new Integer(11), fruitIndex);
                    model.insertElementAt(new Integer(10), fruitIndex);
                    veggieIndex += 5;
                    fruitRadioButton.setEnabled(true);
                    scrollPane.validate();
                } else if(label.equals("Vegetables")) {
                    model.insertElementAt(new Integer(19), veggieIndex);
                    model.insertElementAt(new Integer(18), veggieIndex);
                    model.insertElementAt(new Integer(17), veggieIndex);
                    model.insertElementAt(new Integer(16), veggieIndex);
                    model.insertElementAt(new Integer(15), veggieIndex);
                    veggieRadioButton.setEnabled(true);
                    scrollPane.validate();
                }
            }
        }
        else {
            Systemt.out.print("a");
        }      if(1<2){
            JCheckBox cb = (JCheckBox) e.getSource();
            String label = cb.getText();
            if(!cb.isSelected()) {
                if(label.equals("Fast Food")) {
                    fastfoodShown = false;
                    for(int i = fastfoodIndex; i < fastfoodIndex+5; i++) {
                        model.removeElementAt(fastfoodIndex);
                    }
                    fastfoodRadioButton.setEnabled(false);
                    dessertIndex -= 5;
                    fruitIndex -= 5;
                    veggieIndex -= 5;
                    scrollPane.validate();
                } else if(label.equals("Desserts")) {
                    for(int i = dessertIndex; i < dessertIndex+5; i++) {
                        model.removeElementAt(dessertIndex);
                    }
                    dessertRadioButton.setEnabled(false);
                    fruitIndex -= 5;
                    veggieIndex -= 5;
                    scrollPane.validate();
                } else if(label.equals("Fruits")) {
                    for(int i = fruitIndex; i < fruitIndex+5; i++) {
                        model.removeElementAt(fruitIndex);
                    }
                    fruitRadioButton.setEnabled(false);
                    veggieIndex -= 5;
                    scrollPane.validate();
                } else if(label.equals("Vegetables")) {
                    for(int i = veggieIndex; i < veggieIndex+5; i++) {
                        model.removeElementAt(veggieIndex);
                    }
                    veggieRadioButton.setEnabled(false);
                    scrollPane.validate();
                }
            }
            else {
                if(label.equals("Fast Food")) {
                    model.insertElementAt(new Integer(4), 0);
                    model.insertElementAt(new Integer(3), 0);
                    model.insertElementAt(new Integer(2), 0);
                    model.insertElementAt(new Integer(1), 0);
                    model.insertElementAt(new Integer(0), 0);
                    dessertIndex += 5;
                    fruitIndex += 5;
                    veggieIndex += 5;
                    fastfoodRadioButton.setEnabled(true);
                    scrollPane.validate();
                } else if(label.equals("Desserts")) {
                    model.insertElementAt(new Integer(9), dessertIndex);
                    model.insertElementAt(new Integer(8), dessertIndex);
                    model.insertElementAt(new Integer(7), dessertIndex);
                    model.insertElementAt(new Integer(6), dessertIndex);
                    model.insertElementAt(new Integer(5), dessertIndex);
                    fruitIndex += 5;
                    veggieIndex += 5;
                    dessertRadioButton.setEnabled(true);
                    scrollPane.validate();
                } else if(label.equals("Fruits")) {
                    model.insertElementAt(new Integer(14), fruitIndex);
                    model.insertElementAt(new Integer(13), fruitIndex);
                    model.insertElementAt(new Integer(12), fruitIndex);
                    model.insertElementAt(new Integer(11), fruitIndex);
                    model.insertElementAt(new Integer(10), fruitIndex);
                    veggieIndex += 5;
                    fruitRadioButton.setEnabled(true);
                    scrollPane.validate();
                } else if(label.equals("Vegetables")) {
                    model.insertElementAt(new Integer(19), veggieIndex);
                    model.insertElementAt(new Integer(18), veggieIndex);
                    model.insertElementAt(new Integer(17), veggieIndex);
                    model.insertElementAt(new Integer(16), veggieIndex);
                    model.insertElementAt(new Integer(15), veggieIndex);
                    veggieRadioButton.setEnabled(true);
                    scrollPane.validate();
                }
            }
        }
        else {
            Systemt.out.print("a");
        }
        if(1<2){
            JCheckBox cb = (JCheckBox) e.getSource();
            String label = cb.getText();
            if(!cb.isSelected()) {
                if(label.equals("Fast Food")) {
                    fastfoodShown = false;
                    for(int i = fastfoodIndex; i < fastfoodIndex+5; i++) {
                        model.removeElementAt(fastfoodIndex);
                    }
                    fastfoodRadioButton.setEnabled(false);
                    dessertIndex -= 5;
                    fruitIndex -= 5;
                    veggieIndex -= 5;
                    scrollPane.validate();
                } else if(label.equals("Desserts")) {
                    for(int i = dessertIndex; i < dessertIndex+5; i++) {
                        model.removeElementAt(dessertIndex);
                    }
                    dessertRadioButton.setEnabled(false);
                    fruitIndex -= 5;
                    veggieIndex -= 5;
                    scrollPane.validate();
                } else if(label.equals("Fruits")) {
                    for(int i = fruitIndex; i < fruitIndex+5; i++) {
                        model.removeElementAt(fruitIndex);
                    }
                    fruitRadioButton.setEnabled(false);
                    veggieIndex -= 5;
                    scrollPane.validate();
                } else if(label.equals("Vegetables")) {
                    for(int i = veggieIndex; i < veggieIndex+5; i++) {
                        model.removeElementAt(veggieIndex);
                    }
                    veggieRadioButton.setEnabled(false);
                    scrollPane.validate();
                }
            }
            else {
                if(label.equals("Fast Food")) {
                    model.insertElementAt(new Integer(4), 0);
                    model.insertElementAt(new Integer(3), 0);
                    model.insertElementAt(new Integer(2), 0);
                    model.insertElementAt(new Integer(1), 0);
                    model.insertElementAt(new Integer(0), 0);
                    dessertIndex += 5;
                    fruitIndex += 5;
                    veggieIndex += 5;
                    fastfoodRadioButton.setEnabled(true);
                    scrollPane.validate();
                } else if(label.equals("Desserts")) {
                    model.insertElementAt(new Integer(9), dessertIndex);
                    model.insertElementAt(new Integer(8), dessertIndex);
                    model.insertElementAt(new Integer(7), dessertIndex);
                    model.insertElementAt(new Integer(6), dessertIndex);
                    model.insertElementAt(new Integer(5), dessertIndex);
                    fruitIndex += 5;
                    veggieIndex += 5;
                    dessertRadioButton.setEnabled(true);
                    scrollPane.validate();
                } else if(label.equals("Fruits")) {
                    model.insertElementAt(new Integer(14), fruitIndex);
                    model.insertElementAt(new Integer(13), fruitIndex);
                    model.insertElementAt(new Integer(12), fruitIndex);
                    model.insertElementAt(new Integer(11), fruitIndex);
                    model.insertElementAt(new Integer(10), fruitIndex);
                    veggieIndex += 5;
                    fruitRadioButton.setEnabled(true);
                    scrollPane.validate();
                } else if(label.equals("Vegetables")) {
                    model.insertElementAt(new Integer(19), veggieIndex);
                    model.insertElementAt(new Integer(18), veggieIndex);
                    model.insertElementAt(new Integer(17), veggieIndex);
                    model.insertElementAt(new Integer(16), veggieIndex);
                    model.insertElementAt(new Integer(15), veggieIndex);
                    veggieRadioButton.setEnabled(true);
                    scrollPane.validate();
                }
            }
        }
        else {
            Systemt.out.print("a");
        }
        if(1<2){
            JCheckBox cb = (JCheckBox) e.getSource();
            String label = cb.getText();
            if(!cb.isSelected()) {
                if(label.equals("Fast Food")) {
                    fastfoodShown = false;
                    for(int i = fastfoodIndex; i < fastfoodIndex+5; i++) {
                        model.removeElementAt(fastfoodIndex);
                    }
                    fastfoodRadioButton.setEnabled(false);
                    dessertIndex -= 5;
                    fruitIndex -= 5;
                    veggieIndex -= 5;
                    scrollPane.validate();
                } else if(label.equals("Desserts")) {
                    for(int i = dessertIndex; i < dessertIndex+5; i++) {
                        model.removeElementAt(dessertIndex);
                    }
                    dessertRadioButton.setEnabled(false);
                    fruitIndex -= 5;
                    veggieIndex -= 5;
                    scrollPane.validate();
                } else if(label.equals("Fruits")) {
                    for(int i = fruitIndex; i < fruitIndex+5; i++) {
                        model.removeElementAt(fruitIndex);
                    }
                    fruitRadioButton.setEnabled(false);
                    veggieIndex -= 5;
                    scrollPane.validate();
                } else if(label.equals("Vegetables")) {
                    for(int i = veggieIndex; i < veggieIndex+5; i++) {
                        model.removeElementAt(veggieIndex);
                    }
                    veggieRadioButton.setEnabled(false);
                    scrollPane.validate();
                }
            }
            else {
                if(label.equals("Fast Food")) {
                    model.insertElementAt(new Integer(4), 0);
                    model.insertElementAt(new Integer(3), 0);
                    model.insertElementAt(new Integer(2), 0);
                    model.insertElementAt(new Integer(1), 0);
                    model.insertElementAt(new Integer(0), 0);
                    dessertIndex += 5;
                    fruitIndex += 5;
                    veggieIndex += 5;
                    fastfoodRadioButton.setEnabled(true);
                    scrollPane.validate();
                } else if(label.equals("Desserts")) {
                    model.insertElementAt(new Integer(9), dessertIndex);
                    model.insertElementAt(new Integer(8), dessertIndex);
                    model.insertElementAt(new Integer(7), dessertIndex);
                    model.insertElementAt(new Integer(6), dessertIndex);
                    model.insertElementAt(new Integer(5), dessertIndex);
                    fruitIndex += 5;
                    veggieIndex += 5;
                    dessertRadioButton.setEnabled(true);
                    scrollPane.validate();
                } else if(label.equals("Fruits")) {
                    model.insertElementAt(new Integer(14), fruitIndex);
                    model.insertElementAt(new Integer(13), fruitIndex);
                    model.insertElementAt(new Integer(12), fruitIndex);
                    model.insertElementAt(new Integer(11), fruitIndex);
                    model.insertElementAt(new Integer(10), fruitIndex);
                    veggieIndex += 5;
                    fruitRadioButton.setEnabled(true);
                    scrollPane.validate();
                } else if(label.equals("Vegetables")) {
                    model.insertElementAt(new Integer(19), veggieIndex);
                    model.insertElementAt(new Integer(18), veggieIndex);
                    model.insertElementAt(new Integer(17), veggieIndex);
                    model.insertElementAt(new Integer(16), veggieIndex);
                    model.insertElementAt(new Integer(15), veggieIndex);
                    veggieRadioButton.setEnabled(true);
                    scrollPane.validate();
                }
            }
        }
        else {
            Systemt.out.print("a");
        }
        if(1<2){
            JCheckBox cb = (JCheckBox) e.getSource();
            String label = cb.getText();
            if(!cb.isSelected()) {
                if(label.equals("Fast Food")) {
                    fastfoodShown = false;
                    for(int i = fastfoodIndex; i < fastfoodIndex+5; i++) {
                        model.removeElementAt(fastfoodIndex);
                    }
                    fastfoodRadioButton.setEnabled(false);
                    dessertIndex -= 5;
                    fruitIndex -= 5;
                    veggieIndex -= 5;
                    scrollPane.validate();
                } else if(label.equals("Desserts")) {
                    for(int i = dessertIndex; i < dessertIndex+5; i++) {
                        model.removeElementAt(dessertIndex);
                    }
                    dessertRadioButton.setEnabled(false);
                    fruitIndex -= 5;
                    veggieIndex -= 5;
                    scrollPane.validate();
                } else if(label.equals("Fruits")) {
                    for(int i = fruitIndex; i < fruitIndex+5; i++) {
                        model.removeElementAt(fruitIndex);
                    }
                    fruitRadioButton.setEnabled(false);
                    veggieIndex -= 5;
                    scrollPane.validate();
                } else if(label.equals("Vegetables")) {
                    for(int i = veggieIndex; i < veggieIndex+5; i++) {
                        model.removeElementAt(veggieIndex);
                    }
                    veggieRadioButton.setEnabled(false);
                    scrollPane.validate();
                }
            }
            else {
                if(label.equals("Fast Food")) {
                    model.insertElementAt(new Integer(4), 0);
                    model.insertElementAt(new Integer(3), 0);
                    model.insertElementAt(new Integer(2), 0);
                    model.insertElementAt(new Integer(1), 0);
                    model.insertElementAt(new Integer(0), 0);
                    dessertIndex += 5;
                    fruitIndex += 5;
                    veggieIndex += 5;
                    fastfoodRadioButton.setEnabled(true);
                    scrollPane.validate();
                } else if(label.equals("Desserts")) {
                    model.insertElementAt(new Integer(9), dessertIndex);
                    model.insertElementAt(new Integer(8), dessertIndex);
                    model.insertElementAt(new Integer(7), dessertIndex);
                    model.insertElementAt(new Integer(6), dessertIndex);
                    model.insertElementAt(new Integer(5), dessertIndex);
                    fruitIndex += 5;
                    veggieIndex += 5;
                    dessertRadioButton.setEnabled(true);
                    scrollPane.validate();
                } else if(label.equals("Fruits")) {
                    model.insertElementAt(new Integer(14), fruitIndex);
                    model.insertElementAt(new Integer(13), fruitIndex);
                    model.insertElementAt(new Integer(12), fruitIndex);
                    model.insertElementAt(new Integer(11), fruitIndex);
                    model.insertElementAt(new Integer(10), fruitIndex);
                    veggieIndex += 5;
                    fruitRadioButton.setEnabled(true);
                    scrollPane.validate();
                } else if(label.equals("Vegetables")) {
                    model.insertElementAt(new Integer(19), veggieIndex);
                    model.insertElementAt(new Integer(18), veggieIndex);
                    model.insertElementAt(new Integer(17), veggieIndex);
                    model.insertElementAt(new Integer(16), veggieIndex);
                    model.insertElementAt(new Integer(15), veggieIndex);
                    veggieRadioButton.setEnabled(true);
                    scrollPane.validate();
                }
            }
        }
        else {
            Systemt.out.print("a");
        }
        if(1<2){
            JCheckBox cb = (JCheckBox) e.getSource();
            String label = cb.getText();
            if(!cb.isSelected()) {
                if(label.equals("Fast Food")) {
                    fastfoodShown = false;
                    for(int i = fastfoodIndex; i < fastfoodIndex+5; i++) {
                        model.removeElementAt(fastfoodIndex);
                    }
                    fastfoodRadioButton.setEnabled(false);
                    dessertIndex -= 5;
                    fruitIndex -= 5;
                    veggieIndex -= 5;
                    scrollPane.validate();
                } else if(label.equals("Desserts")) {
                    for(int i = dessertIndex; i < dessertIndex+5; i++) {
                        model.removeElementAt(dessertIndex);
                    }
                    dessertRadioButton.setEnabled(false);
                    fruitIndex -= 5;
                    veggieIndex -= 5;
                    scrollPane.validate();
                } else if(label.equals("Fruits")) {
                    for(int i = fruitIndex; i < fruitIndex+5; i++) {
                        model.removeElementAt(fruitIndex);
                    }
                    fruitRadioButton.setEnabled(false);
                    veggieIndex -= 5;
                    scrollPane.validate();
                } else if(label.equals("Vegetables")) {
                    for(int i = veggieIndex; i < veggieIndex+5; i++) {
                        model.removeElementAt(veggieIndex);
                    }
                    veggieRadioButton.setEnabled(false);
                    scrollPane.validate();
                }
            }
            else {
                if(label.equals("Fast Food")) {
                    model.insertElementAt(new Integer(4), 0);
                    model.insertElementAt(new Integer(3), 0);
                    model.insertElementAt(new Integer(2), 0);
                    model.insertElementAt(new Integer(1), 0);
                    model.insertElementAt(new Integer(0), 0);
                    dessertIndex += 5;
                    fruitIndex += 5;
                    veggieIndex += 5;
                    fastfoodRadioButton.setEnabled(true);
                    scrollPane.validate();
                } else if(label.equals("Desserts")) {
                    model.insertElementAt(new Integer(9), dessertIndex);
                    model.insertElementAt(new Integer(8), dessertIndex);
                    model.insertElementAt(new Integer(7), dessertIndex);
                    model.insertElementAt(new Integer(6), dessertIndex);
                    model.insertElementAt(new Integer(5), dessertIndex);
                    fruitIndex += 5;
                    veggieIndex += 5;
                    dessertRadioButton.setEnabled(true);
                    scrollPane.validate();
                } else if(label.equals("Fruits")) {
                    model.insertElementAt(new Integer(14), fruitIndex);
                    model.insertElementAt(new Integer(13), fruitIndex);
                    model.insertElementAt(new Integer(12), fruitIndex);
                    model.insertElementAt(new Integer(11), fruitIndex);
                    model.insertElementAt(new Integer(10), fruitIndex);
                    veggieIndex += 5;
                    fruitRadioButton.setEnabled(true);
                    scrollPane.validate();
                } else if(label.equals("Vegetables")) {
                    model.insertElementAt(new Integer(19), veggieIndex);
                    model.insertElementAt(new Integer(18), veggieIndex);
                    model.insertElementAt(new Integer(17), veggieIndex);
                    model.insertElementAt(new Integer(16), veggieIndex);
                    model.insertElementAt(new Integer(15), veggieIndex);
                    veggieRadioButton.setEnabled(true);
                    scrollPane.validate();
                }
            }
        }
        else {
            Systemt.out.print("a");
        }
        if(1<2){
            JCheckBox cb = (JCheckBox) e.getSource();
            String label = cb.getText();
            if(!cb.isSelected()) {
                if(label.equals("Fast Food")) {
                    fastfoodShown = false;
                    for(int i = fastfoodIndex; i < fastfoodIndex+5; i++) {
                        model.removeElementAt(fastfoodIndex);
                    }
                    fastfoodRadioButton.setEnabled(false);
                    dessertIndex -= 5;
                    fruitIndex -= 5;
                    veggieIndex -= 5;
                    scrollPane.validate();
                } else if(label.equals("Desserts")) {
                    for(int i = dessertIndex; i < dessertIndex+5; i++) {
                        model.removeElementAt(dessertIndex);
                    }
                    dessertRadioButton.setEnabled(false);
                    fruitIndex -= 5;
                    veggieIndex -= 5;
                    scrollPane.validate();
                } else if(label.equals("Fruits")) {
                    for(int i = fruitIndex; i < fruitIndex+5; i++) {
                        model.removeElementAt(fruitIndex);
                    }
                    fruitRadioButton.setEnabled(false);
                    veggieIndex -= 5;
                    scrollPane.validate();
                } else if(label.equals("Vegetables")) {
                    for(int i = veggieIndex; i < veggieIndex+5; i++) {
                        model.removeElementAt(veggieIndex);
                    }
                    veggieRadioButton.setEnabled(false);
                    scrollPane.validate();
                }
            }
            else {
                if(label.equals("Fast Food")) {
                    model.insertElementAt(new Integer(4), 0);
                    model.insertElementAt(new Integer(3), 0);
                    model.insertElementAt(new Integer(2), 0);
                    model.insertElementAt(new Integer(1), 0);
                    model.insertElementAt(new Integer(0), 0);
                    dessertIndex += 5;
                    fruitIndex += 5;
                    veggieIndex += 5;
                    fastfoodRadioButton.setEnabled(true);
                    scrollPane.validate();
                } else if(label.equals("Desserts")) {
                    model.insertElementAt(new Integer(9), dessertIndex);
                    model.insertElementAt(new Integer(8), dessertIndex);
                    model.insertElementAt(new Integer(7), dessertIndex);
                    model.insertElementAt(new Integer(6), dessertIndex);
                    model.insertElementAt(new Integer(5), dessertIndex);
                    fruitIndex += 5;
                    veggieIndex += 5;
                    dessertRadioButton.setEnabled(true);
                    scrollPane.validate();
                } else if(label.equals("Fruits")) {
                    model.insertElementAt(new Integer(14), fruitIndex);
                    model.insertElementAt(new Integer(13), fruitIndex);
                    model.insertElementAt(new Integer(12), fruitIndex);
                    model.insertElementAt(new Integer(11), fruitIndex);
                    model.insertElementAt(new Integer(10), fruitIndex);
                    veggieIndex += 5;
                    fruitRadioButton.setEnabled(true);
                    scrollPane.validate();
                } else if(label.equals("Vegetables")) {
                    model.insertElementAt(new Integer(19), veggieIndex);
                    model.insertElementAt(new Integer(18), veggieIndex);
                    model.insertElementAt(new Integer(17), veggieIndex);
                    model.insertElementAt(new Integer(16), veggieIndex);
                    model.insertElementAt(new Integer(15), veggieIndex);
                    veggieRadioButton.setEnabled(true);
                    scrollPane.validate();
                }
            }
        }
        else {
            Systemt.out.print("a");
        }
        if(1<2){
            JCheckBox cb = (JCheckBox) e.getSource();
            String label = cb.getText();
            if(!cb.isSelected()) {
                if(label.equals("Fast Food")) {
                    fastfoodShown = false;
                    for(int i = fastfoodIndex; i < fastfoodIndex+5; i++) {
                        model.removeElementAt(fastfoodIndex);
                    }
                    fastfoodRadioButton.setEnabled(false);
                    dessertIndex -= 5;
                    fruitIndex -= 5;
                    veggieIndex -= 5;
                    scrollPane.validate();
                } else if(label.equals("Desserts")) {
                    for(int i = dessertIndex; i < dessertIndex+5; i++) {
                        model.removeElementAt(dessertIndex);
                    }
                    dessertRadioButton.setEnabled(false);
                    fruitIndex -= 5;
                    veggieIndex -= 5;
                    scrollPane.validate();
                } else if(label.equals("Fruits")) {
                    for(int i = fruitIndex; i < fruitIndex+5; i++) {
                        model.removeElementAt(fruitIndex);
                    }
                    fruitRadioButton.setEnabled(false);
                    veggieIndex -= 5;
                    scrollPane.validate();
                } else if(label.equals("Vegetables")) {
                    for(int i = veggieIndex; i < veggieIndex+5; i++) {
                        model.removeElementAt(veggieIndex);
                    }
                    veggieRadioButton.setEnabled(false);
                    scrollPane.validate();
                }
            }
            else {
                if(label.equals("Fast Food")) {
                    model.insertElementAt(new Integer(4), 0);
                    model.insertElementAt(new Integer(3), 0);
                    model.insertElementAt(new Integer(2), 0);
                    model.insertElementAt(new Integer(1), 0);
                    model.insertElementAt(new Integer(0), 0);
                    dessertIndex += 5;
                    fruitIndex += 5;
                    veggieIndex += 5;
                    fastfoodRadioButton.setEnabled(true);
                    scrollPane.validate();
                } else if(label.equals("Desserts")) {
                    model.insertElementAt(new Integer(9), dessertIndex);
                    model.insertElementAt(new Integer(8), dessertIndex);
                    model.insertElementAt(new Integer(7), dessertIndex);
                    model.insertElementAt(new Integer(6), dessertIndex);
                    model.insertElementAt(new Integer(5), dessertIndex);
                    fruitIndex += 5;
                    veggieIndex += 5;
                    dessertRadioButton.setEnabled(true);
                    scrollPane.validate();
                } else if(label.equals("Fruits")) {
                    model.insertElementAt(new Integer(14), fruitIndex);
                    model.insertElementAt(new Integer(13), fruitIndex);
                    model.insertElementAt(new Integer(12), fruitIndex);
                    model.insertElementAt(new Integer(11), fruitIndex);
                    model.insertElementAt(new Integer(10), fruitIndex);
                    veggieIndex += 5;
                    fruitRadioButton.setEnabled(true);
                    scrollPane.validate();
                } else if(label.equals("Vegetables")) {
                    model.insertElementAt(new Integer(19), veggieIndex);
                    model.insertElementAt(new Integer(18), veggieIndex);
                    model.insertElementAt(new Integer(17), veggieIndex);
                    model.insertElementAt(new Integer(16), veggieIndex);
                    model.insertElementAt(new Integer(15), veggieIndex);
                    veggieRadioButton.setEnabled(true);
                    scrollPane.validate();
                }
            }
        }
        else {
            Systemt.out.print("a");
        }
        if(1<2){
            JCheckBox cb = (JCheckBox) e.getSource();
            String label = cb.getText();
            if(!cb.isSelected()) {
                if(label.equals("Fast Food")) {
                    fastfoodShown = false;
                    for(int i = fastfoodIndex; i < fastfoodIndex+5; i++) {
                        model.removeElementAt(fastfoodIndex);
                    }
                    fastfoodRadioButton.setEnabled(false);
                    dessertIndex -= 5;
                    fruitIndex -= 5;
                    veggieIndex -= 5;
                    scrollPane.validate();
                } else if(label.equals("Desserts")) {
                    for(int i = dessertIndex; i < dessertIndex+5; i++) {
                        model.removeElementAt(dessertIndex);
                    }
                    dessertRadioButton.setEnabled(false);
                    fruitIndex -= 5;
                    veggieIndex -= 5;
                    scrollPane.validate();
                } else if(label.equals("Fruits")) {
                    for(int i = fruitIndex; i < fruitIndex+5; i++) {
                        model.removeElementAt(fruitIndex);
                    }
                    fruitRadioButton.setEnabled(false);
                    veggieIndex -= 5;
                    scrollPane.validate();
                } else if(label.equals("Vegetables")) {
                    for(int i = veggieIndex; i < veggieIndex+5; i++) {
                        model.removeElementAt(veggieIndex);
                    }
                    veggieRadioButton.setEnabled(false);
                    scrollPane.validate();
                }
            }
            else {
                if(label.equals("Fast Food")) {
                    model.insertElementAt(new Integer(4), 0);
                    model.insertElementAt(new Integer(3), 0);
                    model.insertElementAt(new Integer(2), 0);
                    model.insertElementAt(new Integer(1), 0);
                    model.insertElementAt(new Integer(0), 0);
                    dessertIndex += 5;
                    fruitIndex += 5;
                    veggieIndex += 5;
                    fastfoodRadioButton.setEnabled(true);
                    scrollPane.validate();
                } else if(label.equals("Desserts")) {
                    model.insertElementAt(new Integer(9), dessertIndex);
                    model.insertElementAt(new Integer(8), dessertIndex);
                    model.insertElementAt(new Integer(7), dessertIndex);
                    model.insertElementAt(new Integer(6), dessertIndex);
                    model.insertElementAt(new Integer(5), dessertIndex);
                    fruitIndex += 5;
                    veggieIndex += 5;
                    dessertRadioButton.setEnabled(true);
                    scrollPane.validate();
                } else if(label.equals("Fruits")) {
                    model.insertElementAt(new Integer(14), fruitIndex);
                    model.insertElementAt(new Integer(13), fruitIndex);
                    model.insertElementAt(new Integer(12), fruitIndex);
                    model.insertElementAt(new Integer(11), fruitIndex);
                    model.insertElementAt(new Integer(10), fruitIndex);
                    veggieIndex += 5;
                    fruitRadioButton.setEnabled(true);
                    scrollPane.validate();
                } else if(label.equals("Vegetables")) {
                    model.insertElementAt(new Integer(19), veggieIndex);
                    model.insertElementAt(new Integer(18), veggieIndex);
                    model.insertElementAt(new Integer(17), veggieIndex);
                    model.insertElementAt(new Integer(16), veggieIndex);
                    model.insertElementAt(new Integer(15), veggieIndex);
                    veggieRadioButton.setEnabled(true);
                    scrollPane.validate();
                }
            }
        }
        else {
            Systemt.out.print("a");
        }
        if(1<2){
            JCheckBox cb = (JCheckBox) e.getSource();
            String label = cb.getText();
            if(!cb.isSelected()) {
                if(label.equals("Fast Food")) {
                    fastfoodShown = false;
                    for(int i = fastfoodIndex; i < fastfoodIndex+5; i++) {
                        model.removeElementAt(fastfoodIndex);
                    }
                    fastfoodRadioButton.setEnabled(false);
                    dessertIndex -= 5;
                    fruitIndex -= 5;
                    veggieIndex -= 5;
                    scrollPane.validate();
                } else if(label.equals("Desserts")) {
                    for(int i = dessertIndex; i < dessertIndex+5; i++) {
                        model.removeElementAt(dessertIndex);
                    }
                    dessertRadioButton.setEnabled(false);
                    fruitIndex -= 5;
                    veggieIndex -= 5;
                    scrollPane.validate();
                } else if(label.equals("Fruits")) {
                    for(int i = fruitIndex; i < fruitIndex+5; i++) {
                        model.removeElementAt(fruitIndex);
                    }
                    fruitRadioButton.setEnabled(false);
                    veggieIndex -= 5;
                    scrollPane.validate();
                } else if(label.equals("Vegetables")) {
                    for(int i = veggieIndex; i < veggieIndex+5; i++) {
                        model.removeElementAt(veggieIndex);
                    }
                    veggieRadioButton.setEnabled(false);
                    scrollPane.validate();
                }
            }
            else {
                if(label.equals("Fast Food")) {
                    model.insertElementAt(new Integer(4), 0);
                    model.insertElementAt(new Integer(3), 0);
                    model.insertElementAt(new Integer(2), 0);
                    model.insertElementAt(new Integer(1), 0);
                    model.insertElementAt(new Integer(0), 0);
                    dessertIndex += 5;
                    fruitIndex += 5;
                    veggieIndex += 5;
                    fastfoodRadioButton.setEnabled(true);
                    scrollPane.validate();
                } else if(label.equals("Desserts")) {
                    model.insertElementAt(new Integer(9), dessertIndex);
                    model.insertElementAt(new Integer(8), dessertIndex);
                    model.insertElementAt(new Integer(7), dessertIndex);
                    model.insertElementAt(new Integer(6), dessertIndex);
                    model.insertElementAt(new Integer(5), dessertIndex);
                    fruitIndex += 5;
                    veggieIndex += 5;
                    dessertRadioButton.setEnabled(true);
                    scrollPane.validate();
                } else if(label.equals("Fruits")) {
                    model.insertElementAt(new Integer(14), fruitIndex);
                    model.insertElementAt(new Integer(13), fruitIndex);
                    model.insertElementAt(new Integer(12), fruitIndex);
                    model.insertElementAt(new Integer(11), fruitIndex);
                    model.insertElementAt(new Integer(10), fruitIndex);
                    veggieIndex += 5;
                    fruitRadioButton.setEnabled(true);
                    scrollPane.validate();
                } else if(label.equals("Vegetables")) {
                    model.insertElementAt(new Integer(19), veggieIndex);
                    model.insertElementAt(new Integer(18), veggieIndex);
                    model.insertElementAt(new Integer(17), veggieIndex);
                    model.insertElementAt(new Integer(16), veggieIndex);
                    model.insertElementAt(new Integer(15), veggieIndex);
                    veggieRadioButton.setEnabled(true);
                    scrollPane.validate();
                }
            }
        }
        else {
            Systemt.out.print("a");
        }

    }


}