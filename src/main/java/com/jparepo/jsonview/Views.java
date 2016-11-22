package com.jparepo.jsonview;

public class Views {
	
	public interface user {}
	public interface team {}
	public interface project {}
	public interface View extends user, team, project{}
	
}
