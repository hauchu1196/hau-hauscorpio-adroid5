package com.example.hau.hwsession5;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hau on 22/09/2016.
 */
public class Company {
    private String name;
    private String phone;
    private String website;

    private static List<Company> companyList;
    public static List<Company> getCompanyList() {
        if (companyList == null) {
            companyList = new ArrayList<>();
            companyList.add(new Company("FPT Software", "0473007575", "https://www.fpt-software.com"));
            companyList.add(new Company("EWay", "+84432595450", "https://eway.vn"));
            companyList.add(new Company("KMS", "+84838486888", "http://www.kms-technology.com"));
            companyList.add(new Company("BraveBits", " +84463260066", "http://www.bravebits.vn"));
            companyList.add(new Company("TechKids", "+841653005670", "http://techkids.vn"));
        }
        return companyList;
    }
    public Company(String name, String phone, String website) {
        this.name = name;
        this.phone = phone;
        this.website = website;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
