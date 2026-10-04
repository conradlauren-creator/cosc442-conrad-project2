## Class: VendingMachine

Method: VendingMachine()

| Method / Behavior | Valid Case(s) | Exception / Invalid Case(s) | Boundary Case(s) | Oracle / Expected Result | JUnit Test(s) |
| ----- | ----- | ----- | ----- | ----- | ----- |
| VendingMachine() | 0-3 |  |  | 0, based on the final INITIAL\_BALANCE | N/A |

I said N/A because the entire program is based off of final values, meaning there is no input, and all of the variables are hardcoded. I did not include this in my test cases.

## Method: getSlotIndex

|  | List Cases | Boundary Case(s)  | Expected Result and How that was Determined | JUnit Test(s) |
| ----- | ----- | ----- | ----- | ----- |
| **Valid Cases** | A,B,C,D | A,D | Return slot index | getSlotIndex(“A”) |
| **Invalid Cases** | non-(A-D) characters | F | Return exception, the else statement throws an exception | getSlotIndex(“F”) |

Private method, not able to access from test cases.

## Method: addItem

|  | List Cases | Boundary Case(s)  | Expected Result and How that was Determined | JUnit Test(s) |
| ----- | ----- | ----- | ----- | ----- |
| **Valid Cases** | slot is null | null | no exception thrown based on the precondition | itemArray\[slotIndex\] \= null, a code of an index that is empty |
| **Invalid Cases** | slot is non-null, invalid code | non-null | Exception thrown based on the precondition not being met | itemArray\[slotIndex\] \= non-null, a code of an index that is already full, code is invalid |

## Method: getItem

|  | List Cases | Boundary Case(s)  | Expected Result and How that was Determined | JUnit Test(s) |
| ----- | ----- | ----- | ----- | ----- |
| **Valid Cases** | A,B,C,D | A,D | expect to return itemArray\[slotIndex\] based on how code can only be one of four options | getItem(“A”); |
| **Invalid Cases** | non-(A-D) characters | F | Exception Thrown based on code not being entered correctly | getItem(“F”); |

## Method: removeItem

|  | List Cases | Boundary Case(s)  | Expected Result and How that was Determined | JUnit Test(s) |
| ----- | ----- | ----- | ----- | ----- |
| **Valid Cases** | non-null | non-null | return item | a code of an index that is already full |
| **Invalid Cases** | null | null | throws exception, based on method description | a code of an index that is already empty |

## Method: insertMoney

|  | List Cases | Boundary Case(s)  | Expected Result and How that was Determined | JUnit Test(s) |
| ----- | ----- | ----- | ----- | ----- |
| **Valid Cases** | amount \>=1 | 1 | determined based on precondition | amount \= 1 |
| **Invalid Cases** | amount \<1 | 0 | throws exception, determined based on precondition | amount \= 0 |

## Method: getBalance

|  | List Cases | Boundary Case(s)  | Expected Result and How that was Determined | JUnit Test(s) |
| ----- | ----- | ----- | ----- | ----- |
| **Valid Cases** | balance\>=0, call getBalance and it returns the balance. nothing changes | 0 | returns balance, determined based on precondition | balance \= 0 |
| **Invalid Cases** | N/A | N/A | N/A | N/A |

\*can not test for invalid, either pass or fail, as there is no parameter

## Method: makePurchase

|  | List Cases | Boundary Case(s)  | Expected Result and How that was Determined | JUnit Test(s) |
| ----- | ----- | ----- | ----- | ----- |
| **Valid Cases** | purchase is less than current balance, balance \>=0, code validPurchase is greater than current balance | balance \= 10, purchase \= 5 | returns true, determined based on method descriptionReturns false, determined based on method description | purchase \<= balance, purchase \> balance |
| **Invalid Cases** | code not valid |  | returns false, determined based on method description |  |

## Method: returnChange

(Parameterized Test)
Parameterized Tests were chosen (values -1000000000, -1, 0, 1, 100, 1000000000) to test the way that returnChange would act under a variety of circumstances. There was no variation in the result that should be produced when it comes to the both positive, negative, and zero values, so they could all be included in one parameterized test. I chose large boundary values to test if the program would crash under unneccessarily large values.

|  | List Cases | Boundary Case(s)  | Expected Result and How that was Determined | JUnit Test(s) |
| ----- | ----- | ----- | ----- | ----- |
| **Valid Cases** | balance\>=0 | 0 | returns change, determined based on precondition | balance \= 0, 1, 1000000000 |
| **Invalid Cases** | balance \<0 | \-1 | should return 0 change, but will not | balance \= \-1, \-100, \-100000000 |

## Class: VendingMachineException

## Method: VendingMachineException

|  | List Cases | Boundary Case(s)  | Expected Result and How that was Determined | JUnit Test(s) |
| ----- | ----- | ----- | ----- | ----- |
| **Valid Cases** | reason \= “test for reason” | N/A | should return reason based on method description | VendingMachineException(“reason”) |
| **Invalid Cases** | N/A | N/A | N/A | N/A |

\*can not test for invalid, either pass or fail

## Class: VendingMachineItem

## Method: VendingMachineItem

|  | List Cases | Boundary Case(s)  | Expected Result and How that was Determined | JUnit Test(s) |
| ----- | ----- | ----- | ----- | ----- |
| **Valid Cases** | price \>= 0 | price \=0 | price is established, based on description and reading code | VendingMachineItem(“name”, 10\) |
| **Invalid Cases** | price \< 0 | price \=-1 | an exception is thrown, based on method comments | VendingMachineItem(“name”, \-1) |

I skipped getName() and getPrice() methods, as they repeat the same testing as getBalance() and do not have any substantial code