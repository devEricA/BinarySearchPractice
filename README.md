# Binary Search Practice
A Lab that analyzes the efficiency of BinarySearch.

Users of this program input passwords that they want to test. 

The program compares the password against passwords found rockyou.txt, a wordlist used by hackers to crack common passwords. 

If the password is in rockyou.txt, the program outputs "Bad Password." Else, it outputs "Good Password". 

Due to the large size of rockyou.txt, it cannot be stored on this repository.
Find and download rockyou text [here](https://gitlab.com/kalilinux/packages/wordlists/blob/kali/master/rockyou.txt.gz).
You will need to unzip it since it comes in a .gz package. 

## Problem
Algorithms that run in O(n) time are becoming obsolete in today's world.

This is evident as many of the search programming challenges report "Time Limit Exceeded" when an 0(n) algorithm is used for large test cases. 

Furthermore, companies with large scale operations are not going to want algorithms that take a while to produce a result. 

The goal of this project is to learn how to use a binary search approach for when it comes to programming challenges that involve searching. 


## Approach
This project uses the rockyou hacking word list as a test case, because this list contains over 14 million strings. 

This is not a case where I would want to use Linear Search, which is one of the O(n) runtime algorithms, because it would take so long to find one string. 

Because of this, we want to use Binary search for this case, even though we have to sort the list first. 

The list is sorted via the Collections.sort() method. 

## Explanation of approach
The runtime for Collections.sort() is O(n log<sub>2</sub> n). This is due to the fact that it utilizes Timsort, which has the worst case runtime of O(n log n). The average runtime for Binarysearch is O(log<sub>2</sub> n). The worst case runtime is O(n). As a result, the average runtime for finding one string in a list would be O(n (log<sub>2</sub> n)^2)) with this type of approach. 

Any additional searches that we would need to do would run in O(log<sub>2</sub> n), because the list is already sorted.

The only disadvantage of this approach is that the worst case runtime for the first search would be O(n^2 log<sub>2</sub> n).

## Tests Conducted
This program was compiled in a Linux Mint environment with <code>javac BinaryResearch.java</code> followed by <code>java BinaryResearch</code>.

This program was also developed using the IDE Visual Studio Code. 

The following Password inputs were used:
* 12345
* 123456
* 123456789
* Iloveyou
* joelito1
* alexag
* bowwezzy2
* zamara
* zach07
* AhaThisDoesNotExist
* YoThisAlsoDoesNotExist
* ILoveThatThisAlsoDoesNotExist
* HaHaThisAlsoDoesNotExist
* ZoWeMamaThisDoesNotExist

Five tests were run, using Binary Search, Linear Search and Index Of.

See the Test Output folder of this repository in order to see the tests and output in full detail. 
 
## Results
Collections.sort() placed a larger overhead than anticipated when it came to the first binary searches. This is evident as each of the first searches conducted in Binary search took well over 1500 miliseconds, because the list was in the process of being sorted. Thus, it turns out Binary search is not very effective for when it comes to one instance for unsorted lists. 

After the sorting of the list however, Binary search out-performed linear search in all cases and out-performed Index of in cases where passwords were not in rockyou.txt. 

Performance of Binary search and Index of were almost identical for cases where the password existed in rockyou.txt and the passwords were sorted. 

## Actions to take for the future
If programming challenges call for a search in a sorted list or for a large number of searches for one list, Binary search will be used. 

For other search cases, especially those that involve unsorted lists, I will need to take a deeper dive into the functionality of the IndexOf() function, since 
it's performance was on par with Binary Search for cases that existed within a list, no matter whether or not the list was sorted. 

I will also need to take a deeper dive into how string matching works. 
