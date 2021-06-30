/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Yasser
 */
public class Jobs {
    
private String title,company,location,type,level,yearsExp,country,skills;

    public Jobs(String[] args) {
        this.title = args[0];
        this.company = args[1];
        this.location = args[2];
        this.type = args[3];
        this.level = args[4];
        this.yearsExp = args[5];
        this.country = args[6];
        this.skills = args[7];
        
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the company
     */
    public String getCompany() {
        return company;
    }

    /**
     * @param company the company to set
     */
    public void setCompany(String company) {
        this.company = company;
    }

    /**
     * @return the location
     */
    public String getLocation() {
        return location;
    }

    /**
     * @param location the location to set
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return the level
     */
    public String getLevel() {
        return level;
    }

    /**
     * @param level the level to set
     */
    public void setLevel(String level) {
        this.level = level;
    }

    /**
     * @return the yearsExp
     */
    public String getYearsExp() {
        return yearsExp;
    }

    /**
     * @param yearsExp the yearsExp to set
     */
    public void setYearsExp(String yearsExp) {
        this.yearsExp = yearsExp;
    }

    /**
     * @return the country
     */
    public String getCountry() {
        return country;
    }

    /**
     * @param country the country to set
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * @return the skills
     */
    public String getSkills() {
        return skills;
    }

    /**
     * @param skills the skills to set
     */
    public void setSkills(String skills) {
        this.skills = skills;
    }

    @Override
    public String toString() {
        return title+" | "+company+" | "+location+" | "+type+" | "+level+" | "+yearsExp+" | "+country+" | "+skills; //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
