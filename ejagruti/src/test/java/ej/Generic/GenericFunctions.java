package ej.Generic;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public class GenericFunctions
{

	public static String GenerateRandomNumber(int length)
	{
		Random r = new Random();
        List<Integer> digits=  new ArrayList<Integer>();
        String number = "";
        for (int i = 0; i < length; i++) {
            digits.add(i);
        }
        for (int i = length; i > 0; i--) {
            int randomDigit = r.nextInt(i);
            number+=digits.get(randomDigit);
            digits.remove(randomDigit);
        }
        System.out.println("Random no(1param):"+number);
        return number;
	}
	
	public static int GenerateRandomNumber(int minNumber,int maxNumber)
	{
		Random randomObj = new Random();
		int n=randomObj.ints(minNumber, maxNumber).findFirst().getAsInt();
		System.out.println("Random no(2parameters): "+n);
		return n;
	}

	public static String GenerateUniqueId()
	{		
		UUID uniqueKey = UUID.randomUUID();
	    String uid=uniqueKey.toString();
		System.out.println ("Unique ID: "+uid);

		return uid;
	}
	
	public static String GetDateTimeAsperGivenFormat(String Dateformat)
	{		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern(Dateformat);
		LocalDateTime now = LocalDateTime.now();
		String cdate=dtf.format(now);
		System.out.println("Current date: "+cdate);
		return cdate;
	}
		
		public static String GeneratePassward(int length)
		{
			final int MAX_LENGTH = length;
			java.util.Random r = new java.util.Random();
			String DIGITS = "23456789";
			String LOCASE_CHARACTERS = "abcdefghjkmnpqrstuvwxyz";
			String UPCASE_CHARACTERS = "ABCDEFGHJKMNPQRSTUVWXYZ";
			String SYMBOLS = "@#$%=:?";
			String ALL = DIGITS + LOCASE_CHARACTERS + UPCASE_CHARACTERS + SYMBOLS;
			char[] upcaseArray = UPCASE_CHARACTERS.toCharArray();
			char[] locaseArray = LOCASE_CHARACTERS.toCharArray();
			char[] digitsArray = DIGITS.toCharArray();
			char[] symbolsArray = SYMBOLS.toCharArray();
			char[] allArray = ALL.toCharArray();
			
			StringBuilder sb = new StringBuilder();
			// get at least one lowercase letter
			sb.append(locaseArray[r.nextInt(locaseArray.length)]);
			// get at least one uppercase letter
			sb.append(upcaseArray[r.nextInt(upcaseArray.length)]);
			// get at least one digit
			sb.append(digitsArray[r.nextInt(digitsArray.length)]);
			// get at least one symbol
			sb.append(symbolsArray[r.nextInt(symbolsArray.length)]);
			// fill in remaining with random letters
			for (int i = 0; i < MAX_LENGTH - 4; i++) {
			sb.append(allArray[r.nextInt(allArray.length)]);
			}
			System.out.println("Pwd="+sb);
			return sb.toString();
		}		
		
	public static void main(String[] args)
	{
		GenericFunctions.GenerateRandomNumber(5, 20);
		GenericFunctions.GeneratePassward(6);
		GenericFunctions.GetDateTimeAsperGivenFormat("dd/MM/yyyy_hh.mm.ss");
		GenericFunctions.GenerateUniqueId();
		GenericFunctions.GenerateRandomNumber(8);
	}
}
