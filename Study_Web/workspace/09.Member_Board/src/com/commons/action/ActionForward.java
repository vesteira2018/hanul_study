package com.commons.action;

public class ActionForward {
	private String path = null;	//jsp 파일의 위치(경로)와 파일명
	//true : sendRedirect(), false : forward()
	private boolean isRedirect = false;	//페이지 전환 방식
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public boolean isRedirect() {
		return isRedirect;
	}
	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}
	
}
