package com.beans;

import java.util.ArrayList;

public interface EmpDao {
	public void connectDatabase();
    public boolean checkAdmin(Emp e);
	public boolean insert (Emp e);
    public ArrayList<Emp> display();
    public boolean delete (String name);
    public Emp getEmp(String name) ;
	public boolean updateEmp(Emp e);
//	public boolean display (Emp e);
}
