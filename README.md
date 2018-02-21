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

Test Input:
5 5
1 2 N
LMLMLMLMM
3 3 E
MMRMMRMRRM
 
Expected Output:
1 3 N
5 1 E


### Testing.txt

This text file is to test possible bugs and unexpected behaviours like inserting a wrong command, initializing a Rover outside of the grid, trying to move outside of the grid...

Test Input:
5 5
4 6 N
LMLMLMLMM
1 2 N
LMiLkMLTMLSMMV
6 4 N
LMLMLMLMM
3 3 E
MMRMMRMRRM
6 6 N
LMLMLMLMM

Expected Output:
The Rover number 1 has an invalid initial position and was not created.
1 3 N
The Rover number 3 has an invalid initial position and was not created.
5 1 E
The Rover number 5 has an invalid initial position and was not created.

## Built With
* [Eclipse](https://www.eclipse.org/) - The IDE used

## License

This project is licensed under the GNU General Public License - see the [LICENSE.md](LICENSE.md) file for details