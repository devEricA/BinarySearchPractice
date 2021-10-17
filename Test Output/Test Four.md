# Test Four - Binary Search
### Exactly the same as the first test
### except the Collections.sort (Line 96) was commented out. 
### Done to verify the fact that the list needs to be sorted prior to running the search. 

```
$ javac BinaryResearch.java 
$ java BinaryResearch 
Initializing the list with the contents of rockyou.txt....
It took 7752 miliseconds to load the list.

Enter a password to test :: 12345 
Good password. It's not in the rockyou list.
First binary search made. It took 1 miliseconds.

Do you have another password to test? (Y/N) :: y
Enter a password to test :: 123456
Good password. It's not in the rockyou list.
The binary search took 1 miliseconds.

Do you have another password to test? (Y/N) :: y
Enter a password to test :: 123456789
Good password. It's not in the rockyou list.
The binary search took 0 miliseconds.

Do you have another password to test? (Y/N) :: y
Enter a password to test :: Iloveyou
Good password. It's not in the rockyou list.
The binary search took 0 miliseconds.

Do you have another password to test? (Y/N) :: y
Enter a password to test :: joelito1
Good password. It's not in the rockyou list.
The binary search took 1 miliseconds.

Do you have another password to test? (Y/N) :: y
Enter a password to test :: alexag
Good password. It's not in the rockyou list.
The binary search took 0 miliseconds.

Do you have another password to test? (Y/N) :: y
Enter a password to test :: bowwezzy2
Good password. It's not in the rockyou list.
The binary search took 0 miliseconds.

Do you have another password to test? (Y/N) :: y
Enter a password to test :: zamara
Good password. It's not in the rockyou list.
The binary search took 0 miliseconds.

Do you have another password to test? (Y/N) :: y
Enter a password to test :: zach07
Good password. It's not in the rockyou list.
The binary search took 0 miliseconds.

Do you have another password to test? (Y/N) :: y
Enter a password to test :: AhaThisDoesNotExist
Good password. It's not in the rockyou list.
The binary search took 0 miliseconds.

Do you have another password to test? (Y/N) :: y
Enter a password to test :: YoThisAlsoDoesNotExist
Good password. It's not in the rockyou list.
The binary search took 1 miliseconds.

Do you have another password to test? (Y/N) :: y
Enter a password to test :: ILoveThatThisAlsoDoesNotExist
Good password. It's not in the rockyou list.
The binary search took 1 miliseconds.

Do you have another password to test? (Y/N) :: HaHaThisAlsoDoesNotExist
Enter a password to test :: y
Good password. It's not in the rockyou list.
The binary search took 1 miliseconds.

Do you have another password to test? (Y/N) :: y
Enter a password to test :: ZoWeMamaThisDoesNotExist
Good password. It's not in the rockyou list.
The binary search took 1 miliseconds.

Do you have another password to test? (Y/N) :: n
```