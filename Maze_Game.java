import java.util.Random;
import java.util.Scanner;
import java.util.Stack;

public class Maze_Game {
    private static final char WALL = '#';
    private static final char PATH = '.';
    private static final char PLAYER = '@';
    private static final char HINT_PATH = '+';
    private static final int ROWS = 11;
    private static final int COLS = 21;

    public static void main(String[] args) {
        printGameOverview();

        System.out.println("Press any key to start the game...");
        new Scanner(System.in).nextLine(); // Wait for user input to start

        // Create a Scanner for user input
        Scanner scanner = new Scanner(System.in);

        boolean playAgain = true;

        // Main game loop
        do {
            char[][] maze = generateMaze(ROWS, COLS);
            int startX = 1;
            int startY = 0; // Initial player position
            int destX = ROWS - 2;
            int destY = COLS - 1; // Destination position
            generatePathDFS(maze, startX, startY+1, destX, destY); // randomly generate path using depth-first search and backtracking

            printMazeExteriorWalls(maze, startX, startY);
            System.out.println(""); // spacing

            // Create a memoized maze for hints
            char[][] hintMaze = new char[ROWS][COLS];
            copyMaze(maze, hintMaze);
            // Find the optimal path from the current position to the destination
            findOptimalPath(hintMaze, startX, startY, destX, destY); // path is computed only one time

            char move;
            String line;

            // Inner game loop
            while (true) {
                printMazeWithPlayerView(maze, startX, startY);
                System.out.print("Select movement: ");

                line = scanner.nextLine();
                if (line.length() == 0) {
                    move = '0';
                } else {
                    move = line.toUpperCase().charAt(0);
                }

                int newX = startX;
                int newY = startY;

                switch (move) {
                    case 'W':
                        newX = startX - 1;
                        break;
                    case 'S':
                        newX = startX + 1;
                        break;
                    case 'A':
                        newY = startY - 1;
                        break;
                    case 'D':
                        newY = startY + 1;
                        break;
                    case 'H':
                        printMazeWithPlayerView(hintMaze, startX, startY);
                        break;
                    default:
                        System.out.println("Invalid input. Please use W, A, S, D for movement or H for a hint.");
                }

                if (isValidMove(maze, startX, startY, newX, newY)) {
                    movePlayer(maze, startX, startY, newX, newY);
                    movePlayer(hintMaze, startX, startY, newX, newY);
                    startX = newX;
                    startY = newY;
                } else {
                    System.out.println("Invalid move. You can't pass through walls.");
                }

                System.out.println(""); // spacing

                if (startX == destX && startY == destY) {
                    System.out.println("Congratulations! You've reached the destination.");
                    break;
                }
            }

            System.out.print("Enter Y to play again: ");
            line = scanner.nextLine();
            if (line.length() == 0) {
                playAgain = false;
            } else if (line.toUpperCase().charAt(0) != 'Y') {
                playAgain = false;
            }

        } while (playAgain);
        System.out.println("Goodbye!");
        System.out.println(); // spacing

    } // end main

    public static void printGameOverview() {
        System.out.println("Welcome to the Maze Game!");
        System.out.println("You are represented by the '@' symbol.");
        System.out.println("Your goal is to reach the destination at maze[rows - 2][cols - 1].");
        System.out.println("Use the following keys for movement:");
        System.out.println("  W - Move North");
        System.out.println("  S - Move South");
        System.out.println("  A - Move West");
        System.out.println("  D - Move East");
        System.out.println("  H - Ask for a Hint");
        System.out.println("Navigate the maze and find your way to the destination.");
    } // end printGameOverview

    public static char[][] generateMaze(int rows, int cols) {
        char[][] maze = new char[rows][cols];

        // Initialize the maze with walls
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                maze[row][col] = WALL;
            }
        }

        // Set start and destination positions
        maze[1][0] = PLAYER;
        maze[rows - 2][cols - 1] = PATH;

        return maze;
    } // end generateMaze

    public static void generatePathDFS(char[][] maze, int startX, int startY, int destX, int destY) {
        Stack<Integer> stackX = new Stack<>();
        Stack<Integer> stackY = new Stack<>();
        Random random = new Random();
        int currentX = startX;
        int currentY = startY;

        stackX.push(currentX);
        stackY.push(currentY);

        while (!stackX.isEmpty()) {
            maze[currentX][currentY] = PATH;

            if (currentX == destX && currentY == destY) {
                return;
            }

            int[] directions = {0, 1, 2, 3};
            shuffleArray(directions, random);

            boolean moved = false;

            for (int direction : directions) {
                int newX = currentX;
                int newY = currentY;

                if (direction == 0 && currentX > 2) { // Move north
                    newX -= 2;
                } else if (direction == 1 && currentX < maze.length - 3) { // Move south
                    newX += 2;
                } else if (direction == 2 && currentY > 2) { // Move west
                    newY -= 2;
                } else if (direction == 3 && currentY < maze[0].length - 3) { // Move east
                    newY += 2;
                }

                if (maze[newX][newY] == WALL) {
                    maze[newX - (newX - currentX) / 2][newY - (newY - currentY) / 2] = PATH;
                    stackX.push(newX);
                    stackY.push(newY);
                    currentX = newX;
                    currentY = newY;
                    moved = true;
                    break;
                }
            }

            if (!moved) {
                stackX.pop();
                stackY.pop();
                if (!stackX.isEmpty()) {
                    currentX = stackX.peek();
                    currentY = stackY.peek();
                }
            }
        }
    } // end generatePathDFS

    public static void shuffleArray(int[] arr, Random random) {
        for (int i = arr.length - 1; i > 0; i--) {
            int index = random.nextInt(i + 1);
            int temp = arr[i];
            arr[i] = arr[index];
            arr[index] = temp;
        }
    } // end shuffleArray

    // Define a method to copy the maze
    public static void copyMaze(char[][] source, char[][] destination) {
        for (int i = 0; i < source.length; i++) {
            System.arraycopy(source[i], 0, destination[i], 0, source[i].length);
        }
    } // end copyMaze

    public static void movePlayer(char[][] maze, int startX, int startY, int destX, int destY) {
        maze[startX][startY] = PATH;
        maze[destX][destY] = PLAYER;
    } // end movePlayer

    public static boolean isValidMove(char[][] maze, int startX, int startY, int newX, int newY) {
        int rows = maze.length;
        int cols = maze[0].length;

        if (newX >= 0 && newX < rows && newY >= 0 && newY < cols) {
            return maze[newX][newY] != WALL;
        }

        return false;
    } // end isValidMove

    // Find the optimal path using DFS
    public static boolean findOptimalPath(char[][] maze, int currentX, int currentY, int destX, int destY) {
        // Check if we've reached the destination
        if (currentX == destX && currentY == destY) {
            return true;
        }

        // Check if we are out of bounds or hitting a wall
        if (currentX < 0 || currentX >= maze.length || currentY < 0 || currentY >= maze[0].length || maze[currentX][currentY] == WALL) {
            return false;
        }

        // Check if this cell has already been visited (memoization)
        if (maze[currentX][currentY] == HINT_PATH) {
            return false;
        }

        // Mark the current cell as visited
        maze[currentX][currentY] = HINT_PATH;

        // Try all possible directions
        if (findOptimalPath(maze, currentX - 1, currentY, destX, destY)) {
            return true;
        }
        if (findOptimalPath(maze, currentX + 1, currentY, destX, destY)) {
            return true;
        }
        if (findOptimalPath(maze, currentX, currentY - 1, destX, destY)) {
            return true;
        }
        if (findOptimalPath(maze, currentX, currentY + 1, destX, destY)) {
            return true;
        }

        // If none of the directions lead to the destination, backtrack
        maze[currentX][currentY] = PATH; // Mark as part of the memoized solution
        return false;
    } // end findOptimalPath

    public static void printMaze(char[][] maze, int playerX, int playerY) {
        int radius = 1; // The radius of the square around the player

        int startRow = Math.max(0, playerX - radius);
        int endRow = Math.min(maze.length - 1, playerX + radius);
        int startCol = Math.max(0, playerY - radius);
        int endCol = Math.min(maze[0].length - 1, playerY + radius);

        for (int row = startRow; row <= endRow; row++) {
            for (int col = startCol; col <= endCol; col++) {
                System.out.print(maze[row][col] + " ");
            }
            System.out.println();
        }
    } // end printMaze

    public static void printMazeWithPlayerView(char[][] maze, int playerX, int playerY) {
        int mazeRows = maze.length;
        int mazeCols = maze[0].length;

        int radius = 1; // The radius of the square around the player

        // Iterate through the 3x3 square around the player
        for (int row = Math.max(0, playerX - radius); row <= Math.min(mazeRows - 1, playerX + radius); row++) {
            for (int col = Math.max(0, playerY - radius); col <= Math.min(mazeCols - 1, playerY + radius); col++) {
                //if (playerX == col && playerY == row) {
                    //System.out.print(PLAYER + " ");
                //} else {
                    System.out.print(maze[row][col] + " ");
                //}
            }
            System.out.println();
        }
    } // end printMazeWithPlayerView

    // I was going to use this to show the 3x3 square within the maze
    public static void printMazeExteriorWalls(char[][] maze, int playerX, int playerY) {
        int mazeRows = maze.length;
        int mazeCols = maze[0].length;

        // Iterate through the maze and print the exterior walls
        for (int row = 0; row < mazeRows; row++) {
            for (int col = 0; col < mazeCols; col++) {
                boolean exteriorWall = (row == 0 || row == mazeRows - 1 || col == 0 || col == mazeCols-1);
                
                if (row == playerX && col == playerY) {
                    System.out.print(PLAYER + " ");
                } else if ((row == 1 && col == 0) || (row == mazeRows-2 && col == mazeCols-1)) {
                    System.out.print(PATH + " ");
                } else if (exteriorWall) {
                    System.out.print(WALL + " ");
                } else {
                    System.out.print("  "); // Empty space inside the maze
                }
            }
            System.out.println();
        }
    } // end printMazeExteriorWalls

    public static void printEntireMaze(char[][] maze) {
        for (int row = 0; row < maze.length; row++) {
            for (int col = 0; col < maze[row].length; col++) {
                System.out.print(maze[row][col] + " "); // Add a space
            }
            System.out.println();
        }
    } // end printEntireMaze
}
