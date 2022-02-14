# Binary Search Practice
A lab that analyzes the efficiency of BinarySearch.

Users of this program input passwords that they want to test. 

The program compares the password against passwords found rockyou.txt, a wordlist used by hackers to crack common passwords. 

If the password is in rockyou.txt, the program outputs "Bad Password." Else, it outputs "Good Password". 

| :exclamation: IMPORTANT|
|:---------------------------|
| Before you run this lab for yourself, you must extract the rockyou.txt file out of the rockyou.txt.gz file included in this repo.|

## Problem
Algorithms that run in O(n) time are becoming obsolete in today's world.

This is evident as many of the search programming challenges report "Time Limit Exceeded" when an O(n) algorithm is used for large test cases. 

Furthermore, companies with large scale operations are not going to want algorithms that take a while to produce a result. 

The goal of this project is to learn how to use a binary search approach for when it comes to programming challenges that involve searching. 

## Approach
This project uses the rockyou hacking word list as a test case, because this list contains over 14 million strings. 

This is not a case where I would want to use an O(n) runtime algorithm (e.g linear search), because it would take so long to find one string. 

Because of this, we want to use binary search for this case, even though we have to sort the list first. 

The list is sorted via the Collections.sort() method. 

## Explanation of approach
The average runtime case for a binary search is O(log <sub>2</sub> n), which is a significant improvement over O(n). There may be a few cases where the runtime is O(n) (worst case for binary search), but it's better than having O(n) for all cases. 

A disadvantage of this approach is that the average runtime case for the first search would be O(n (log<sub>2</sub> n)^2)), and the worst case for the first search would be O(n^2 log2 n), because we have to factor in the runtime for sorting the list. In our case, we use Collections.sort(), a method that utilizes the [timsort](https://bugs.java.com/bugdatabase/view_bug.do?bug_id=6804124) sorting algorithm. Because we have to sort to list prior to finding the first case, we must add timsort's runtime for the search of the first case.  

However, any additional searches that we need to perform will be done in O(log <sub>2</sub> n), since we only need to sort the list for the first case. 

## Tests Conducted
This program was compiled in a Linux Mint environment using the CLI commands <code>javac BinaryResearch.java</code> and <code>java BinaryResearch</code>.

This program was also developed with Visual Studio Code. 

The following password inputs were used:
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

Five tests were run, using binary search, linear search and indexOf().

See the [Test Output](https://github.com/devEricA/BinarySearchPractice/tree/main/Test%20Output) folder of this repository in order to see the tests and output in full detail. 
 
## Results
Collections.sort() placed a larger overhead than anticipated when it came to the first binary searches. This is evident as each of the first searches conducted in binary search took well over 1000 miliseconds, because the list was in the process of being sorted. Thus, it turns out binary search is not very effective for cases where we need to find one object in an unsorted list. 

After the sorting of the list however, binary search out-performed linear search in all cases and out-performed indexOf() in cases where passwords were not in rockyou.txt. Thus, binary search is useful for when we need to find multiple objects in an unsorted list, and for finding objects in a list that is already sorted. 

Performances of binary search and indexOf() were almost identical for cases where the password existed in rockyou.txt. 

## Actions to take for the future
If programming challenges call for a search in a sorted list or for a large number of searches in a unsorted list, binary search will be used. 

For other search cases, especially those that involve unsorted lists, I will need to take a deeper dive into the functionality of the indexOf() function, since 
it's performance was on par with binary search for cases that existed within a list, no matter whether or not the list was sorted.

I will also need to take a look into how string matching works, and a look into binary traversals of lists. 
