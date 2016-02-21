/**
 * 
 * Benjamin Leach
 * 2/20/2016
 * CMSC 256-001 
 *
 * This program is intended to test the functionality of the RamString class. 
 *
 */
public class RamStringTester {

    public static void main(String[] args) {
        printHeading();
        RamString test = new RamString("");
        try{

            try{
                test.setWackyString(""); //Test ALL on an empty string
                System.out.println("Even: " + test.getEvenCharacters());
                System.out.println("Odd: " + test.getOddCharacters());
                System.out.println("Digit Count: " + test.countDigits());
                test.ramifyString();
                System.out.println(test.getWackyString());
                test.convertDigitsToRomanNumeralsInSubstring(1,1);
                System.out.println(test.getWackyString());
            }
            catch(MyIndexOutOfBoundsException e)
            {
                e.printStackTrace();
            }

            test.setWackyString("0123456789"); //Test on a string to make sure even/odd/countdigits is correct
            System.out.println(test.getWackyString()); //before
            System.out.println("Even: " + test.getEvenCharacters());
            System.out.println("Odd: " +test.getOddCharacters());
            System.out.println("Digit Count: " + test.countDigits());
            test.ramifyString();
            System.out.println(test.getWackyString()); //after

            test.setWackyString("abc!@#$"); //Test countDigit on chars
            System.out.println(test.getWackyString());
            System.out.println("Digit Count: " + test.countDigits()); 


            //ramifyString tests PRINTS BEFORE AND AFTER
            test.setWackyString("0 00 hey there 0"); //Testing edges for case 0
            System.out.println(test.getWackyString());
            test.ramifyString();
            System.out.println(test.getWackyString());

            test.setWackyString("00 00000 hey 0 there 00"); //Testing edges for case 00
            System.out.println(test.getWackyString());
            test.ramifyString();
            System.out.println(test.getWackyString());

            test.setWackyString("0000000000"); //Testing for all 0 string
            System.out.println(test.getWackyString());
            test.ramifyString();
            System.out.println(test.getWackyString());

            test.setWackyString("0 00000I00Love0Programming00 01230000 000 0!!!"); //Testing for mixture
            System.out.println(test.getWackyString());
            test.ramifyString();
            System.out.println(test.getWackyString());

            try{
                test.setWackyString(null);  //Testing on the null case.
            }
            catch(NullPointerException e)
            {
                e.printStackTrace();
            }


            try{
                test.setWackyString("One: 1, Two: 2, Three: 3, Four: 4, Five: 5, 6 7 8 9 0"); //Test all the roman numerals
                System.out.println(test.getLength());
                test.convertDigitsToRomanNumeralsInSubstring(1, 53);
                System.out.println(test.getWackyString());

                test.setWackyString("1 0 2 33 742 555"); //Testing for bad start position
                test.convertDigitsToRomanNumeralsInSubstring(0, 10);
                System.out.println(test.getWackyString());
            }
            catch(MyIndexOutOfBoundsException e)
            {
                e.printStackTrace();
            }
            catch(IllegalArgumentException e)
            {
                e.printStackTrace();
            }
            try{
                test.setWackyString("1 0 2 33 742 555"); //Testing for bad high end position throws custom exception
                test.convertDigitsToRomanNumeralsInSubstring(5, 40);
                System.out.println(test.getWackyString());
            }
            catch(MyIndexOutOfBoundsException e)
            {
                e.printStackTrace();
            }
            catch(IllegalArgumentException e)
            {
                e.printStackTrace();
            }
            try{
                test.setWackyString("1 0 2 33 742 555"); //Testing for bad low end position throws custom exception
                test.convertDigitsToRomanNumeralsInSubstring(5, 0);
                System.out.println(test.getWackyString());
            }
            catch(MyIndexOutOfBoundsException e)
            {
                e.printStackTrace();
            }
            catch(IllegalArgumentException e)
            {
                e.printStackTrace();
            }
            try{
                test.setWackyString("1 0 2 33 742 555"); //Testing for bad high start position throws custom exception
                test.convertDigitsToRomanNumeralsInSubstring(40, 45);
                System.out.println(test.getWackyString());
            }
            catch(MyIndexOutOfBoundsException e)
            {
                e.printStackTrace();
            }
            catch(IllegalArgumentException e)
            {
                e.printStackTrace();
            }
            try{
                test.setWackyString("1 0 2 33 742 555"); //Testing for swapped position in range throws illegalargument
                test.convertDigitsToRomanNumeralsInSubstring(7, 5);
                System.out.println(test.getWackyString());
            }
            catch(MyIndexOutOfBoundsException e)
            {
                e.printStackTrace();
            }
            catch(IllegalArgumentException e)
            {
                e.printStackTrace();
            }

            try{
                test.setWackyString("1 0 2 33 742 555"); //Testing for same position should be position of 7
                test.convertDigitsToRomanNumeralsInSubstring(10, 10);
                System.out.println(test.getWackyString());
            }
            catch(MyIndexOutOfBoundsException e)
            {
                e.printStackTrace();
            }
            catch(IllegalArgumentException e)
            {
                e.printStackTrace();
            }

        }
        catch(Exception e)
        {
            System.out.println("FATAL ERROR");
        }
        finally{

        }

    }
    public static void printHeading()
    {
        System.out.println("Name: Benjamin Leach");
        System.out.println("Project: 2");
        System.out.println("CMSC 256");
        System.out.println("Spring 2016");
    }



}