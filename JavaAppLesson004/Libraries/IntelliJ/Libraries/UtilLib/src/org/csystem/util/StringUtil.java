/*----------------------------------------------------------------------------------------------------------------------	
	 StringUtil sınıfı
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.util;

import java.util.Random;

import static java.lang.Character.*;

public class StringUtil	{
	private static final String MS_ALPHABET_EN;
	private static final String MS_ALPHABET_TR;

	static {
		MS_ALPHABET_EN = "abcdefghijklmnopqrstuwxvyz";
		MS_ALPHABET_TR = "abcçdefgğhıijklmnoöprsştuüvyz";
	}

	private StringUtil() {}

	public static String addAllCharsWith(String s, int n)
	{
		var sb = new StringBuilder(s);
		var length = sb.length();

		for (var i = 0; i < length; ++i) {
			var ch = sb.charAt(i);
			sb.setCharAt(i, (char)(ch + n));
		}

		return sb.toString();
	}

	public static String capitalize(String s)
	{
		if (s.isEmpty())
			return s;
		
		return toUpperCase(s.charAt(0)) + s.substring(1).toLowerCase();
	}

	public static String changeCase(String s)
	{
		var sb = new StringBuilder(s);
		var length = sb.length();

		for (var i = 0; i < length; ++i) {
			var ch = sb.charAt(i);

			if (!Character.isLetter(ch))
				continue;

			sb.setCharAt(i, Character.isUpperCase(ch) ? Character.toLowerCase(ch) : Character.toUpperCase(ch));
		}

		return sb.toString();
	}

	public static int getCount(String s1, String s2)
	{
		var count = 0;
		
		for (int index = -1; (index = s1.indexOf(s2, index + 1)) != -1; ++count)
			;		
		
		return count;
	}
	
	public static String getLetters(String s)
	{
		var len = s.length();
		var sb = new StringBuilder();
		
		for (var i = 0; i < len; ++i) {
			var c = s.charAt(i);
			if (isLetter(c))
				sb.append(c);
		}
		
		return sb.toString();
	}
	
	public static String getRandomText(Random r, int n, String str)
	{
		var sb = new StringBuilder(n);

		for (var i = 0; i < n; ++i)
			sb.append(str.charAt(r.nextInt(str.length())));

		return sb.toString();
	}
	
	public static String getRandomTextTR(int n)
	{
		var r = new Random();
		
		return getRandomTextTR(r, n);
	}
	
	public static String getRandomTextTR(Random r, int n)
	{
		return getRandomText(r, n, "abcçdefgğhıijklmnoöprsştuüvyzABCÇDEFGĞJHIİJKLMNOÖPRSŞTUÜVYZ");
	}
	
	public static String getRandomTextEN(int n)
	{
		var r = new Random();
		
		return getRandomTextEN(r, n);
	}
	
	public static String getRandomTextEN(Random r, int n)
	{
		return getRandomText(r, n, "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ");
	}

	public static boolean isIsogram(String str, String alphabet)
	{
		var counts = new int[alphabet.length()];
		var len = str.length();

		for (var i = 0; i < len; ++i) {
			var ch = Character.toLowerCase(str.charAt(i));

			var index = alphabet.indexOf(ch);

			if (index == -1)
				continue;

			++counts[index];

			if (counts[index] > 1)
				return false;
		}

		for (var val : counts)
			if (val == 0)
				return false;

		return true;
	}
	public static boolean isIsogramEN(String str)
	{
		var counts = new int[26];

		var len = str.length();

		for (var i = 0; i < len; ++i) {
			var ch = Character.toLowerCase(str.charAt(i));

			if (ch < 'a' || ch > 'z')
				continue;

			++counts[ch - 'a'];

			if (counts[ch - 'a'] > 1)
				return false;
		}

		for (var val : counts)
			if (val == 0)
				return false;

		return true;
	}

	public static boolean isIsogramTR(String str)
	{
		return isIsogram(str, MS_ALPHABET_TR);
	}

	public static boolean isPalindrome(String s)
	{
		var str = getLetters(s);
		
		if (str.isEmpty())
			return false;
		
		var first = 0;
		var last = str.length() - 1;
		
		while (first < last) {
			var chLeft = toLowerCase(str.charAt(first++));
			var chRight = toLowerCase(str.charAt(last--));
			
			if (chLeft != chRight)
				return false;
		}			
		
		return true;		
	}

	public static boolean isPangram(String str, String alphabet)
	{
		str = str.toLowerCase();

		var len = alphabet.length();

		for (var i = 0; i < len; ++i) {
			var c = alphabet.charAt(i);

			if (!str.contains(c + ""))
				return false;
		}

		return true;
	}

	public static boolean isPangramTR(String str)
	{
		return isPangram(str, MS_ALPHABET_TR);
	}

	public static boolean isPangramFR(String str)
	{
		return isPangram(str, MS_ALPHABET_EN);
	}

	public static boolean isPangramEN(String str)
	{
		return isPangram(str, MS_ALPHABET_EN);
	}
	
	public static String padLeft(String s, int len)
	{
		return padLeft(s, len, ' ');
	}

	public static String padLeft(String s, int len, char ch)
	{
		len -= s.length();
		
		if (len <= 0)
			return s;
		
		return repeat(len, ch) + s;				
	}
	
	public static String padRight(String s, int len)
	{
		return padRight(s, len, ' ');
	}
	
	public static String padRight(String s, int len, char ch)
	{
		len -= s.length();
		
		if (len <= 0)
			return s;
		
		return s + repeat(len, ch);
	}
	
	public static String repeat(int n, char ch)
	{
		var sb = new StringBuilder(n);

		while (n-- > 0)
			sb.append(ch);
		
		return sb.toString();
	}	
	
	public static String reverse(String s)
	{
		return new StringBuilder(s).reverse().toString();
	}

	public static String squeeze(String s1, String s2)
	{
		var sb = new StringBuilder();
		var length = s1.length();

		for (var i = 0; i < length; ++i) {
			var ch = s1.charAt(i);

			if (s2.indexOf(ch) == -1)
				sb.append(ch);
		}

		return sb.toString();
	}

	public static String [] split(String str, String delim)
	{
		return split(str, delim, StringSplitOptions.NONE);
	}

	public static String [] split(String str, String delim, StringSplitOptions options)
	{
		var re = new StringBuilder("[");
		var metas = "[]";

		for (var i = 0; i < delim.length(); ++i) {
			var c = delim.charAt(i);

			re.append(metas.contains(c + "") ? "\\" : "").append(c);
		}

		re.append("]");

		if (options == StringSplitOptions.REMOVE_EMPTY_ENTRIES)
			re.append("+");

		return str.split(re.toString());
	}

	public static String subtractAllCharsWith(String s, int n)
	{
		return addAllCharsWith(s, -n);
	}
	
	public static String trimLeft(String s)
	{
		var i = 0;
		var len = s.length();
		
		for (; i < len && isWhitespace(s.charAt(i)); ++i)
			;
		
		return s.substring(i);
	}
	
	public static String trimRight(String s)
	{
		var i = s.length() - 1;
		
		for (; i >= 0 && isWhitespace(s.charAt(i)); --i)
			;
		
		return s.substring(0, i + 1);
	}
}
