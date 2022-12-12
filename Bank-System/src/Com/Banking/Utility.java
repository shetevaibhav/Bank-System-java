package Com.Banking;

public class Utility {
	
	    public static boolean validDate(String date)
	    {
	        String[] sa = date.split("/");
	        int d = Integer.parseInt(sa[0]);
	        if(d>=1 && d<=31)
	        {
	            //ok
	        }
	        else
	        {
	            return false;
	        }
	        int m = Integer.parseInt(sa[1]);
	        if(m>=1 && d<=12)
	        {
	            //ok
	        }
	        else
	        {
	            return false;
	        }

	        if(sa[2].length() ==4)
	        {

	        }
	        else
	        {
	            return false;
	        }
	        return true;

	    }

}
