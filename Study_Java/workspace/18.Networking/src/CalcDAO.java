public class CalcDAO {
	
	public int getResult(CalcDTO dto) {
		int num1 = dto.getNum1();
		int num2 = dto.getNum2();
		String opcode = dto.getOpcode();
		
		int result = 0;
		if (opcode.equals("+")) {
			result = num1 + num2;
		} else if (opcode.equals("-")) {
			result = num1 - num2;
		} else if (opcode.equals("*")) {
			result = num1 * num2;
		} else if (opcode.equals("/")){
			result = num1 / num2;
		}//if
		
		return result;
	}//getResult()
	
}//class
