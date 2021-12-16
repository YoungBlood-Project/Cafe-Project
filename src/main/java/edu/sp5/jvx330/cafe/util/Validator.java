package edu.sp5.jvx330.cafe.util;

import java.util.Collection;

//��ȿ�� �˻��� �޼ҵ�
public class Validator {
	
	//��ȿ�� �˻�(String)
	public static boolean isEmpty(String s_obj) {
		if(s_obj==null||s_obj.length()==0) {
			return true;
		}
		return false;
	}
	//��ȿ�� �˻�(Collection)
	public static boolean isEmpty(Collection<?> c_obj) {
		if(c_obj==null||c_obj.size()==0) {
			return true;
		}
		return false;
	}
	
	//��ȿ�� �˻�(Integer)
	public static boolean isEmpty(Integer i_obj) {
		if(i_obj==null||i_obj==0) {
			return true;
		}
		return false;
	}
}