package com.hanul.poly03;

//Interface의 상속은 implements 키워드 사용
public class Tv implements RemoCon {

	@Override
	public void volUp() {
		System.out.println("TV 소리를 올린다.");
	}

	@Override
	public void volDown() {
		System.out.println("TV 소리를 내린다.");
	}

	@Override
	public void internet() {
		System.out.println("인터넷에 접속한다.");
	}

}
