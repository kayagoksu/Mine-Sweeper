# Mine Sweeper

A simple Mine Sweeper game using Java and running in terminal.

## The Rules

1. The game is text-based.
2. The multidimensional array should be used.
3. The user should enter the dimensions.
4. The mine count should be the quarter of array's element count. For example, if the array is 4x3, then the mine count should be 3. How to calculate: The element count is row number x column number => 4 x 3 = 12. The mine count is element count / 4 => 12 / 4 = 3.
5. The user should select a point on the array, enter a value for the row and for the column.
6. If the selected point is out of the boundries of array, the user should re-enter the values.
7. If the selected point has a mine, it is game over.
8. If there is a mine connected to the selected point, the game should show the count of those mines. If there is no mine, the game should show as "0" on that point.
9. If the user selects all non-mine points, he should win the game.

## Screenshots

Starting game:

![Starting game](/src/img/1.png)

Winning Scenario:

![Starting game](/src/img/2.png)

Losing Scenario:

![Starting game](/src/img/3.png)
