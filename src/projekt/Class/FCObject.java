/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekt.Class;


/**
 * @author Admin
 */
// familly Cancer
public class FCObject {
    private String family;
    private String cancer;
    private String alians;
    private boolean isAdded;

    public FCObject(String family, String cancer, String alians) {
        this.family = family;
        this.cancer = cancer;
        this.alians = alians;
        isAdded = false;
    }

    public FCObject() {
        this("", "", "");
        isAdded = false;
    }

    public String getAlians() {
        return alians;
    }

    public void setAlians(String alians) {
        this.alians = alians;
    }

    public String getCancer() {
        return cancer;
    }

    public void setCancer(String cancer) {
        this.cancer = cancer;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public boolean isAdded() {
        return isAdded;
    }

    public void setAdded(boolean isAdded) {
        this.isAdded = isAdded;
    }

    public String getAddedString() {
        if (isAdded) {
            return "1";
        }
        return "0";
    }
}
