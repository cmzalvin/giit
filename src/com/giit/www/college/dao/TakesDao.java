package com.giit.www.college.dao;

/**
 * Created by c0de8ug on 16-2-16.
 */

public interface TakesDao {
    public int getStdCountInSection(int secId);

    public void add(int secId, int stdId);
}
