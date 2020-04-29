# Reverse Polish notation Calculator

Command-line based RPN calculator

Numbers are pushed into the stack. Operators operate on numbers that are on the stack.
 
Available operators are `+`, `-`, `*`, `/`

Both numbers and operations are separated by space, ie:

`4 5 +`

`322 54 - 24 *`

- The `clear` operator removes all items from the stack.
- The `+`, `-`, `*`, `/` operators perform addition, subtraction, multiplication and division respectively on the top two items from the stack.
- The calculator exit when it receives a `q` command

If an operator cannot find a sufficient number of parameters on the stack, a warning message is displayed:
 
`operator <operator> doesn't have enough parameters`

## Requirements

- Implemented and tested using Java 8

- Tests require JUnit and Mockito

- Dependencies are managed by Maven


## Compile, Test, Run and Packaging

- Compile: `mvn compile`

- Test: `mvn test`

- Run: `mvn exec:java`

- Packaging: `mvn package`, compiled jar in *target/* folder
