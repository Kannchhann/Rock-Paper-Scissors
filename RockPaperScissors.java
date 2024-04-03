import java.util.Scanner;

public class RockPaperScissors {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] moves = {"rock", "paper", "scissors"};

        System.out.println("Let's play Rock, Paper, Scissors!");

        while (true) {
            System.out.println("\nEnter your move (rock, paper, or scissors):");
            String playerMove = scanner.nextLine().toLowerCase();

            if (!isValidMove(playerMove, moves)) {
                System.out.println("Invalid move. Please enter rock, paper, or scissors.");
                continue;
            }

            String computerMove = moves[(int) (Math.random() * moves.length)];

            System.out.println("Computer chooses " + computerMove + ".");

            String result = getResult(playerMove, computerMove);
            System.out.println(result);

            System.out.println("Do you want to play again? (yes/no):");
            String playAgain = scanner.nextLine().toLowerCase();
            if (!playAgain.equals("yes")) {
                break;
            }
        }

        System.out.println("Thanks for playing!");
        scanner.close();
    }

    private static boolean isValidMove(String move, String[] moves) {
        for (String validMove : moves) {
            if (validMove.equals(move)) {
                return true;
            }
        }
        return false;
    }

    private static String getResult(String playerMove, String computerMove) {
        if (playerMove.equals(computerMove)) {
            return "It's a tie!";
        } else if ((playerMove.equals("rock") && computerMove.equals("scissors")) ||
                   (playerMove.equals("paper") && computerMove.equals("rock")) ||
                   (playerMove.equals("scissors") && computerMove.equals("paper"))) {
            return "You win!";
        } else {
            return "You lose!";
        }
    }
}
