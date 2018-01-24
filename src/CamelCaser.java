public class CamelCaser {
    public static void main(String[] args) {
        System.out.print(camelCase("testiNg"));
    }

    public static String camelCase(String inputString) {
        //Your Code Here
        StringBuilder outputString = new StringBuilder("");
        boolean invalidChar = false, invalidFormat = false, nullInput=false; //to check for exceptions
        inputString=inputString.toLowerCase();
        char previousChar = inputString.charAt(0);
        //checking if any exceptions in first letter of inputString
        if(previousChar!=' ')
            outputString.append(previousChar);
        if(Character.isDigit(previousChar))
            invalidFormat=true;
        if(!(Character.isDigit(previousChar)) && previousChar!=' ' && !(Character.isLetter(previousChar)))
            invalidChar=true;
        if (inputString.equals("\0"))
            nullInput=true;
        if(!nullInput && !invalidFormat && !invalidChar) //converting to camelCase only if there are no exceptions
            {
            for (int i = 1; i < inputString.length(); i++) {
                char curr=inputString.charAt(i);
                if(!(Character.isDigit(curr)) && curr!=' ' && !(Character.isLetter(curr))) //checking for invalid character
                {
                    invalidChar=true;
                    break;
                }
                    if (curr != ' ') { //append character only if not whitespace
                        if (previousChar == ' ') { //to check for new word
                            if (Character.isDigit(curr)) { //checking for invalid format
                                invalidFormat = true;
                                break;
                            }
                            outputString.append(Character.toUpperCase(curr));
                        } else
                            outputString.append(curr);
                    }
                previousChar = inputString.charAt(i); //updating previous character for next iteration
            }
        }
        // throwing exceptions
        if(nullInput)
            throw new IllegalArgumentException(ErrorConstants.NULL_INPUT);
        if(invalidChar)
            throw new IllegalArgumentException(ErrorConstants.INVALID_CHARACTER);
        if(invalidFormat)
            throw new IllegalArgumentException(ErrorConstants.INVALID_FORMAT);
        return outputString.toString();
    }
}

