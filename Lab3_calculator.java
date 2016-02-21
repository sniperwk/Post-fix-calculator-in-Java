import java.util.Scanner;
import java.util.StringTokenizer;

public class Lab3_calculator {

	/**
	 * @param args
	 */
	public static final int LIMIT = 100; // the limit of the number of input items
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Lab3_stack stack = new Lab3_stack();
		
		Scanner keyboard = new Scanner(System.in);
		String inputString;
		String tempString, sumString = "";
		StringTokenizer opToken;
		// String[] operator = new String[LIMIT];		 
		int operand1, operand2, operation, countItem = 0;
		String operandString;
		boolean invalidInput = false, validOutput = false;
		
		// check if the input is valid, the number of operators " + - *"  and " = " should equal the number of operand (intergers)
		// at least 1 operand and exactly 1 " = "; 
		while (true)
		{
			System.out.println("input the items for the calculator:");
			countItem = 0;
			sumString = "";
			// stack.showStack();
			stack.reset();
			// stack.showStack();
			while (((inputString = keyboard.nextLine()).length() > 0))
			{
				opToken = new StringTokenizer(inputString, " ");
				tempString = opToken.nextToken();
				sumString = sumString + tempString + " ";
				if (tempString.matches("(-)*[0-9]+"))
				{
					// operator[countItem++] = tempString;
					stack.push(Integer.parseInt(tempString));
				} else if (tempString.matches("[\\*+-]")) {
					// operator[countItem++] = tempString;
					if ((operandString = stack.pop()) != "") // when the stack is not empty, pop() will return a non-null string
					{
						// System.out.println("debug: operandString: " + operandString);
						
						operand2 = Integer.parseInt(operandString);
						// System.out.println("debug: operand2: " + operand2);
						if ((operandString = stack.pop()) != "")
						{
							operand1 = Integer.parseInt(operandString);
							
							//System.out.println("debug: operand1: " + operand1);
							
							if (tempString.matches("\\*"))
							{
								operation = operand1 * operand2;
							} else if (tempString.matches("\\+"))
							{
								operation = operand1 + operand2;
							} else // operator is -								
							{
								operation = operand1 - operand2;
							}
							stack.push(operation);
						} else {
							// invalidInput = true;
							// System.out.println("invalid input: two few operands" + sumString);
							break;
						} 
					} else {
						// invalidInput = true;
						// System.out.println("invalid input: two few operands" + sumString);
						break;
					}

				} else if (tempString.equals("=")) {
					if ((inputString = keyboard.nextLine()).length() > 0)
					{
						// invalidInput = true;
						// System.out.println("invalid input, no more items after \"=\"" + sumString + inputString);
						sumString = sumString + inputString + " ";
						break;
					} else {
						if (stack.size() == 1)
						{
							validOutput = true;
							System.out.println("the result of " + sumString + " is " + stack.pop());
							break;
						} else {
							// invalidInput = true;
							// System.out.println("invalid input, two many operands: " + sumString);
							break;
						}
					}
				} else { // invalid item, not number, not operator, not "="
					// invalidInput = true;
					System.out.println("invalid input, illegal item: " + sumString);
					break;
				}
			
			}
			
			// consume all the remaining input
			// System.out.println("inputString length: " + inputString.length());
			if (inputString.length() > 0) {
				while (((inputString = keyboard.nextLine()).length() > 0)) { }
			}

			
			if (validOutput) {
				// System.out.println("to break out of outermost while loop");
				break; // break the outermost while loop if the calculation is successful
				} else if (stack.size() > 0)
				{
					System.out.println("invalid input, two MANY operands: " + sumString);
				} else {
					System.out.println("invalid input, two FEW operands: " + sumString);
				}
			
			
			
		} // outermost while (true) loop
		
		// System.out.println("outside of outermost while loop");
	}

}
