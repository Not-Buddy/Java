import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * A simple command-line application to simulate a voting system.
 * It allows users to cast votes for predefined candidates and displays the final results.
 */
public class VotingSystem {

    // Map to store candidate names (String) and their corresponding vote count (Integer)
    private static Map<String, Integer> votes = new HashMap<>();

    // Array of candidates available for voting
    private static final String[] CANDIDATES = {"Candidate Alpha", "Candidate Beta", "Candidate Gamma"};

    public static void main(String[] args) {
        // Initialize vote counts for all candidates to zero
        for (String candidate : CANDIDATES) {
            votes.put(candidate, 0);
        }

        System.out.println("--- Welcome to the Simple Command-Line Voting System ---");

        try (Scanner scanner = new Scanner(System.in)) {
            boolean keepVoting = true;

            while (keepVoting) {
                displayCandidates();
                System.out.println("\nEnter the number of the candidate you wish to vote for (1-" + CANDIDATES.length + ") or 0 to view results and exit:");

                // Input validation loop
                if (scanner.hasNextInt()) {
                    int choice = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character

                    if (choice == 0) {
                        keepVoting = false;
                    } else if (choice >= 1 && choice <= CANDIDATES.length) {
                        // Valid vote
                        String votedCandidate = CANDIDATES[choice - 1];
                        // Increment the vote count for the chosen candidate
                        votes.put(votedCandidate, votes.get(votedCandidate) + 1);
                        System.out.println("Vote successfully cast for: " + votedCandidate);
                    } else {
                        // Invalid number outside the range
                        System.out.println("Invalid choice. Please enter a number between 1 and " + CANDIDATES.length + ", or 0 to exit.");
                    }
                } else {
                    // Handle non-integer input
                    System.out.println("Invalid input. Please enter a numerical choice.");
                    scanner.nextLine(); // Consume the invalid input to prevent infinite loop
                }
                System.out.println("-----------------------------------------------------");
            }
        } catch (Exception e) {
            System.err.println("An unexpected error occurred: " + e.getMessage());
        }

        displayResults();
    }

    /**
     * Prints the list of candidates with their assigned voting numbers.
     */
    private static void displayCandidates() {
        System.out.println("\n--- Candidates ---");
        for (int i = 0; i < CANDIDATES.length; i++) {
            // Display candidate number (1-based) and name
            System.out.println((i + 1) + ". " + CANDIDATES[i]);
        }
    }

    /**
     * Prints the final vote counts and declares the winner.
     */
    private static void displayResults() {
        System.out.println("\n=====================================================");
        System.out.println("                VOTING RESULTS");
        System.out.println("=====================================================");

        String winner = "";
        int maxVotes = -1;

        // Iterate through the results to print counts and find the winner
        for (Map.Entry<String, Integer> entry : votes.entrySet()) {
            String candidate = entry.getKey();
            int count = entry.getValue();
            System.out.printf("%-20s : %d votes\n", candidate, count);

            if (count > maxVotes) {
                maxVotes = count;
                winner = candidate;
            }
        }

        if (maxVotes > 0) {
            System.out.println("-----------------------------------------------------");
            System.out.println("The winner is: " + winner + " with " + maxVotes + " votes!");
        } else {
            System.out.println("No votes were cast in this election.");
        }
        System.out.println("=====================================================");
    }
}

