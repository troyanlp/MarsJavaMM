# MarsJavaMM

## Getting Started

### Assumptions:
- There won't be negative numbers in the input, wether console or file.
- The lowerleft square position is (0,0) so when we say that the size of the grid is N,M we're really saying there are N+1 horizontal cells and M+1 vertical cells because we have to count the square 0 for each axis.

### Instructions:


## Running the tests

This project includes 2 text files to test the program:

### InputExample.txt

This text file has the input example given with the problem. It's main purpose is to validate with the expected output:

Test Input: <br />
5 5 <br />
1 2 N <br />
LMLMLMLMM <br />
3 3 E <br />
MMRMMRMRRM <br />
 
Expected Output: <br />
1 3 N <br />
5 1 E <br />


### Testing.txt

This text file is to test possible bugs and unexpected behaviours like inserting a wrong command, initializing a Rover outside of the grid, trying to move outside of the grid...

Test Input: <br />
5 5 <br />
4 6 N <br />
LMLMLMLMM <br />
1 2 N <br />
LMiLkMLTMLSMMV <br />
6 4 N <br />
LMLMLMLMM <br />
3 3 E <br />
MMRMMRMRRM <br />
6 6 N <br />
LMLMLMLMM <br />

Expected Output: <br />
The Rover number 1 has an invalid initial position and was not created. <br />
1 3 N <br />
The Rover number 3 has an invalid initial position and was not created. <br />
5 1 E <br />
The Rover number 5 has an invalid initial position and was not created. <br />

## Built With
* [Eclipse](https://www.eclipse.org/) - The IDE used