package org.example.GLAB_303_11_7;
import java.util.TreeMap;
import java.util.Map;

public class PhoneDirectoryWithTreeMap {
    /**
     * The TreeMap that will store the data. Both key and value are
     * of type String. The key represents a name and the value represents
     * the associated phone
     */
    private TreeMap<String,String> data;
    public PhoneDirectoryWithTreeMap() {
        this.data = new TreeMap<String,String>();
    }
    /**
     * Finds the phone number, if any, for a given name.
     * @returns The phone number associated with the name; if the name does
     * not occur in the phone directory, then the return value is null.
     */
    public String getNumber( String name) {
        return this.data.get(name);
    }
    /**
     * Associates a given name with a given phone number. if the name already exists in the phone directory
     * then the new number replaces the old one. Otherwise a new name/number pair is added.
     * The name and number should both be non-null. An IllegalArgumentException is thrown if this is not the case.
     */
    public void putNumber( String name, String number) {
        if (name ==null || number == null)
            throw new IllegalArgumentException("name and number cannot be null");
        this.data.put(name,number);
    }
    /** write the contents of the phone directory to System.out.
     */
    public void print() {
        for ( Map.Entry<String,String> entry : this.data.entrySet() )
            System.out.println(entry.getKey() + ": " + entry.getValue());
    }
} //end class PhoneDirectoryWithTreeMap
