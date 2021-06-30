/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Yasser
 */
public class ValueCount {

    private String label;
    private long count;
    
    public ValueCount(String label, long count) {
        this.label = label;
        this.count = count;
    }

    /**
     * @return the label
     */
    public String getLabel() {
        return label;
    }

    /**
     * @param label the label to set
     */
    public void setLabel(String label) {
        this.label = label;
    }

    /**
     * @return the count
     */
    public long getCount() {
        return count;
    }

    /**
     * @param count the count to set
     */
    public void setCount(long count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return label +" | "+ count; //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
