package com.giit.www.entity.custom;

/**
 * Created by c0de8ug on 16-1-6.
 */
public class DepartmentJSON {
    String department;
    SpecialityJSON[] specialities;

    public DepartmentJSON(String key) {
        this.department = key;
    }
}
