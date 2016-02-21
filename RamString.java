public class RamString implements WackyStringInterface{
    private String currentString;
    public RamString()
    {
    }

    /**
     * @param ram String 
     * @throws NullPointerException
     */
    public RamString(String ram) throws NullPointerException
    {
        if(ram ==null)
            throw new NullPointerException("Null is unacceptable.");
        else
            currentString = ram;
    }
    @Override
    public void setWackyString(String string)throws NullPointerException {
        if(string ==null)
            throw new NullPointerException("Null is unacceptable.");
        else
            currentString = string;
    }
    @Override
    public String getWackyString() {
        return currentString;
    }
    /**
     * @return length of string
     */
    public int getLength(){
        int length = currentString.length();
        return length;
    }
    @Override
    public String getEvenCharacters() {
        String newString = "";
        for(int i=0; i<currentString.length(); i++)
        {
            if(i%2 == 0)
            {
                newString = newString + currentString.charAt(i);
            }

        }
        return newString;
    }

    @Override
    public String getOddCharacters() {
        String newString = "";
        for(int i=0; i<currentString.length()-1; i++)
        {
            if(i%2 == 0)
            {
                newString = newString + currentString.charAt(i+1);
            }

        }
        return newString;
    }

    @Override
    public int countDigits() {
        int counter = 0;
        String isDigit = "0123456789";
        for(int i = 0; i<currentString.length(); i++)
        {
            for(int j = 0; j<isDigit.length(); j++) //tests the whole isDigit string against each char of currentString 
            {
                if((currentString.charAt(i) == isDigit.charAt(j)))
                {
                    counter++;
                }
            }
        }
        return counter;
    }

    @Override
    public void ramifyString(){
        String begin;
        String end;
        String vcu = "VCU";
        String rams = "Rams";
        outerloop: //use this to break from inside any inner loop.
            for(int i = 0;i<currentString.length();i++)
            {
                //Test 000+ case
                if(currentString.charAt(i) == '0' && ((i+1 < currentString.length()) && (currentString.charAt(i+1) =='0')) && 
                        (i+2 < currentString.length() && currentString.charAt(i+2) == '0')) //checking for 2 past i while not going over
                {
                    if(i+3 > currentString.length())
                    {
                        i=currentString.length();
                        break;
                    }
                    i+=3;
                    while(i<currentString.length() && currentString.charAt(i) == '0') //once we know that there are 3 zeros, continue to look for more, break at change.
                    {
                        i++;
                        if(i == currentString.length())
                        {
                            break outerloop;
                        }
                    }
                }
                //Test VCU 0 case
                if(currentString.charAt(i) =='0' && (((i+1 < currentString.length()) && (currentString.charAt(i+1) !='0')) || i+1 >= currentString.length()))
                {
                    begin = currentString.substring(0,i);
                    end = currentString.substring(i+1, currentString.length());
                    currentString = begin+vcu+end;
                }
                //Test Rams 00 case
                if(currentString.charAt(i) == '0' && ((i+1 < currentString.length()) && (currentString.charAt(i+1) =='0')))
                {
                    begin = currentString.substring(0,i);
                    end = currentString.substring(i+2, currentString.length());
                    currentString = begin+rams+end;  
                }
            }
    }
    @Override
    public void convertDigitsToRomanNumeralsInSubstring(int startPosition, int endPosition)
            throws MyIndexOutOfBoundsException, IllegalArgumentException {

        String begin;
        String end;

        if(startPosition < 1 || endPosition < 1 || startPosition > currentString.length() || endPosition > currentString.length())
        {
            throw new MyIndexOutOfBoundsException("Incorrect position");
        }
        if(startPosition > endPosition)
        {
            throw new IllegalArgumentException("Start position cannot be before End");
        }
        currentString = currentString.substring(startPosition-1, endPosition);
        for(int i = 0; i<currentString.length(); i++)
        {
            switch(currentString.charAt(i))
            {
                case '1': 
                    begin = currentString.substring(0, i);
                    end = currentString.substring(i+1, currentString.length());
                    currentString = begin+"I"+end;
                    break;
                case '2': 
                    begin = currentString.substring(0, i);
                    end = currentString.substring(i+1, currentString.length());
                    currentString = begin+"II"+end;
                    break;
                case '3': 
                    begin = currentString.substring(0, i);
                    end = currentString.substring(i+1, currentString.length());
                    currentString = begin+"III"+end;
                    break;
                case '4': 
                    begin = currentString.substring(0, i);
                    end = currentString.substring(i+1, currentString.length());
                    currentString = begin+"IV"+end;
                    break;
                case '5': 
                    begin = currentString.substring(0, i);
                    end = currentString.substring(i+1, currentString.length());
                    currentString = begin+"V"+end;
                    break;
                case '6': 
                    begin = currentString.substring(0, i);
                    end = currentString.substring(i+1, currentString.length());
                    currentString = begin+"VI"+end;
                    break;
                case '7': 
                    begin = currentString.substring(0, i);
                    end = currentString.substring(i+1, currentString.length());
                    currentString = begin+"VII"+end;
                    break;
                case '8': 
                    begin = currentString.substring(0, i);
                    end = currentString.substring(i+1, currentString.length());
                    currentString = begin+"VIII"+end;
                    break;
                case '9': 
                    begin = currentString.substring(0, i);
                    end = currentString.substring(i+1, currentString.length());
                    currentString = begin+"IX"+end;
                    break;

                default:
                    break;
            }
        }
    }
}
