## Class: VendingMachine, Method: VendingMachine()
The observed failure:
For loop iterates out of bounds

The test that exposed it:
All tests in VendingMachineTest returned an out of bounds exception

The source-code fault that caused it:
for (int i = 0; i <= NUM_SLOTS; i++) {}

How you diagnosed the fault:
Understanding that all the methods were being affected encouraged me to identify a method that affects all code. This would be the constructor method. Looking at the VendingMachine constructor method, I saw a for loop. If starting at 0, a for loop can not iterate through all of the options while inclduing the last option. This will create an out of bounds error. 

The correction you made:
for (int i = 0; i < NUM_SLOTS; i++) {}
I removed the <= and replaced it with <

## Class: VendingMachine, Method: InsertMoney()

The observed failure:
Money greater than zero but less than one would not be accepted.

The test that exposed it:
void testInsert_LessThanOneGreaterThanZero_Money() {}

The source-code fault that caused it:
In the method insertMoney(), the if statement says if (amount < 1), throw an exception

How you diagnosed the fault:
Reading the Javadocs provided insight on how the program was supposed to function. Any amount of money greater than zero should be accepted, yet the if statement only accepted money greater than one.

The correction you made:
if (amount < 0)

## Class: VendingMachine, Method: ReturnChange()

The observed failure:
Not exactly a failure, but more of a concern. Change of any value can be returned, but logically only change greater than 

The test that exposed it:
void testInsert_LessThanOneGreaterThanZero_Money() {}

The source-code fault that caused it:
In the method insertMoney(), the if statement says if (amount < 1), throw an exception

How you diagnosed the fault:
Reading the Javadocs provided insight on how the program was supposed to function. Any amount of money greater than zero should be accepted, yet the if statement only accepted money greater than one.

The correction you made:
if (amount < 0)