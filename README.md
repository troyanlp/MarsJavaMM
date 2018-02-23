# MarsJavaMM

## Getting Started

This program is a Rover Controller simulator where we pretend we land a number of Rovers on Mars and, given the positions and the size of the surface we will navigate, these can be controlled with certain commands.

### Instructions:

This program is based on the user input and it has to follow certain guidelines. This is an example of a file with inputs:<br />
5 5  -> This line indicates the size of the grid, each axys separated by a white space. <br />
1 2 N -> This line indicates the position of a Rover (1,2) and the direction its facing (North) separated by a white space.<br />
LMLMLMLMM -> This line indicates the orders we want to communicate to the Rover created above.<br />
3 3 E <br />
MMRMMRMRRM <br />

In this example we have created 2 Rovers, each one with its initial conditions and its orders.


This program has 2 ways to input the data:

#### 1. Console

This mode is selected by typing "console" at the start of the program.
The files are placed on a folder named "Test Files" and we can use any of the files included or created our own file (following the input guidelines) and place it in the folder.
First the program will ask for the file name (must be inside the "Test Files" folder) and after that we will see the output.

#### 2. File 

This mode is selected by typing "file" at the start of the program.
First the program will ask for the size of the grid. After that we can write as much Rover info as we want (following the input guidelines) and when we are done we just have to type "stop" and we will see the output.

### Indications:
- There won't be negative numbers in the input, wether console or file.
- The lowerleft square position is (0,0) so when we say that the size of the grid is N,M we're really saying there are N+1 horizontal cells and M+1 vertical cells because we have to count the square 0 for each axis.
- While indicating the initial conditions of a Rover, to state the direction we have the commands N (North), W (West), S (South) and E (East).
- We have 3 commands available to control a Rover: L (Turn Left), R (Turn Right) and M (Move). When the Rover turns it just changes the direction it's facing and when the Rover moves, it moves in the direction it's facing at that moment.
- If a command in the order line is not one of the stated above it will be ignored.
- If a Rover is placed outside of the given grid there will be an error message but if there are other valid Rovers, those will work normally. The error message is: "The Rover number X has an invalid initial position and was not created."
- If there's no input or there's just the grid size as input there will be the following error message: "No valid data!"
- If the name of the input file doesn't exist or isn't found the program will output: "File not found!"
- If the grid size values are wrong the program will output: "No valid grid size values."
- If the values of a file are wrong the program will output: "No valid file values."
- If the values written as console input are wrong the program will output: "No valid input values."


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