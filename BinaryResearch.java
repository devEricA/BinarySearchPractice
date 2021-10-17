import java.util.*;
import java.io.*;


public class BinaryResearch
{
    //Method to use Binary search
    public static boolean BiStringSearch(List<String> myList, String TGT){
        //Boundaries for searching
        int leftBound = 0, rightBound = myList.size()-1;

        //While the left bound is less than or equal to the right bound
        while(leftBound <= rightBound){
            //Get the position between the left and the right
            int middleIndex = leftBound + (rightBound - leftBound) / 2;

            //Get the string at that index and compare it to the one we are looking for
            int result = TGT.compareTo(myList.get(middleIndex));
            
            //If we found the string, return true
            if(result == 0)
            {
                return true;
            }

            //If we did not find the string, adjust the bounds 
            //based on the result of the comparison made
            if(result > 0)
            {
                //Alphabetically larger, move up left bound.
                leftBound = middleIndex + 1;
            }
            else 
            {
                //Alphabetically smaller, move down right bound. 
                rightBound = middleIndex - 1;
            }
        }
        //If we did not find the string, return false. 
        return false;
    }

    //Method to use Linear Search
    public static boolean LiStringSearch(List<String> myList, String TGT)
    {
        //For each string in the list.
        for(String s: myList)
        {
            //If we found the string, return true. 
            if(s.equals(TGT))
            {
                return true;
            }
        }
        //If we did not find the string, return false. 
        return false;
    }

    public static void main(String [] args) throws IOException{
        /*
        Create a file object that will be used to reference the file we are operating with.
        rockyou.txt is a hacking wordlist that is used to crack the most common passwords.
        It's a good test case for this scenario because it has over 14 million strings. 
        */
        Scanner file = new Scanner(new File("rockyou.txt"));

        //This ArrayList will eventually store the contents of the rockyou text file
        List <String> rockYouContents = new ArrayList<String>();

        // Read all contents from a file
        // This process is timed since it's O(n) execution time. 
        System.out.println("Initializing the list with the contents of rockyou.txt....");
        long startLoadTime = System.currentTimeMillis(); // Start time of list loading 
        while(file.hasNextLine())
        {
            //we do NOT trim the additions because there are passwords where the only difference is trailing spaces.
            rockYouContents.add(file.nextLine()); 
           
        }
        long endLoadTime = System.currentTimeMillis(); // End time of list loading
        file.close(); // Done with file

        //Printing out the time it took to load lists
        System.out.println("It took " + (endLoadTime - startLoadTime) + " miliseconds to load the list.");
        System.out.println(); 
        
        /*
        Binary search only works on sorted lists.
        This method is timed as well.
        According to https://bugs.java.com/bugdatabase/view_bug.do?bug_id=6804124,
        Collections.sort() uses Timsort, a method with runtime O(n log n)
        NOTE: This section is commented out when running the linear search trials and the indexOf,
        because linear search does not require the list to be sorted.
        */ 
        long startSortTime = System.currentTimeMillis(); // Start time of sort.
        Collections.sort(rockYouContents);
        long endSortTime = System.currentTimeMillis(); // End time of sort.

        /*
        When we calculate the time it took for the first search,
        we need to factor in the time it took to sort the list.
        This boolean is used to determine whether or not we need to add the sort time. 
        */
        boolean isFirstSearch = true;

        /*
        Start and End search times are declared here
        because further down the line we use a do while loop.
        We save memory by performing this declaraction
        as opposed to declaring inside the loop. 
        */
        long startSearchTime;
        long endSearchTime;

        //Choice input and do while loop to allow multiple password tests at once.  
        String choice;
        Scanner input = new Scanner(System.in);
        do{
        //Take in a user input of a string which will be used to run this particular test
        System.out.print("Enter a password to test :: ");
        String thePassword = input.nextLine();
        //BEGIN BINARY SEARCH CALL

        /*
        If the inputted password is in the list, then the password can be cracked by the use of it
        Thus, it's a bad password
        If the inputted password is not in the list, then the password cannot be cracked by the use of it
        Thus, it's a good password. 
        We also load the time for this search
        */
        startSearchTime = System.currentTimeMillis(); // Start time of search.
        if(BiStringSearch(rockYouContents, thePassword))
        {
            System.out.println("Bad password, it was found in the rockyou list.");
        }
        else
        {
            System.out.println("Good password. It's not in the rockyou list.");
        }
        endSearchTime = System.currentTimeMillis(); // End time of search

        //If this is our first search, add in the time for sorting.
        //else, we simply print out the search time
        if(isFirstSearch)
        {
            long totalTime = ((endSortTime - startSortTime) + (endSearchTime - startSearchTime));//Only used once, doesn't matter where it's declared. 
            System.out.println("First binary search made. It took " + totalTime + " miliseconds.");
            isFirstSearch = false;
        }
        else
        {
            System.out.println("The binary search took " + (endSearchTime - startSearchTime) + " miliseconds." );
        }

        //END OF BINARY SEARCH CALL

        // BEGIN LINEAR SEARCH CALL

        // /*
        // If the inputted password is in the list, then the password can be cracked by the use of it
        // Thus, it's a bad password
        // If the inputted password is not in the list, then the password cannot be cracked by the use of it
        // Thus, it's a good password. 
        // We also load the time for this search
        // */
        // startSearchTime = System.currentTimeMillis(); // Start time of search.
        // if(LiStringSearch(rockYouContents, thePassword))
        // {
        //     System.out.println("Bad password, it was found in the rockyou list.");
        // }
        // else
        // {
        //     System.out.println("Good password. It's not in the rockyou list.");
        // }
        // endSearchTime = System.currentTimeMillis(); // End time of search
        // System.out.println("The linear search took " + (endSearchTime - startSearchTime) + " miliseconds");
        
        // END LINEAR SEARCH CALL

        //BEGIN INDEX OF CALL

        // startSearchTime = System.currentTimeMillis(); // Start time of search.
        // if(rockYouContents.indexOf(thePassword) != -1)
        // {
        //     System.out.println("Bad password, it was found in the rockyou list.");
        // }
        // else
        // {
        //     System.out.println("Good password. It's not in the rockyou list.");
        // }
        // endSearchTime = System.currentTimeMillis(); // End time of search
        // System.out.println("Index Of took " + (endSearchTime - startSearchTime) + " miliseconds");
        //END INDEX OF CALL

        //Prompt to see if the user has another password to test.
        //If the user has another password, continue the loop.
        System.out.println();// Used to separate the prompt from the results. 
        System.out.print("Do you have another password to test? (Y/N) :: ");
        choice = input.nextLine();
        }while(!(choice.equals("N") || choice.equals("n")));
        input.close();

    }
}