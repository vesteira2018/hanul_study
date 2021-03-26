import java.io.Serializable;

public class CalcDTO implements Serializable {
	private int num1, num2;
	private String opcode;
	
	public CalcDTO() {}

	public CalcDTO(int num1, int num2, String opcode) {
		super();
		this.num1 = num1;
		this.num2 = num2;
		this.opcode = opcode;
	}

	public int getNum1() {
		return num1;
	}

	public void setNum1(int num1) {
		this.num1 = num1;
	}

	public int getNum2() {
		return num2;
	}

	public void setNum2(int num2) {
		this.num2 = num2;
	}

	public String getOpcode() {
		return opcode;
	}

	public void setOpcode(String opcode) {
		this.opcode = opcode;
	}
	
	
}
