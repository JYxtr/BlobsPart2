import java.util.Scanner;

public class Input {
    private static char ESC;
    private static String BOLD;  // These correspond to
    private static String RED;   // the correct ANSI escape
    private static String CYAN;  // color codes for their name.
    private static String RESET; // Resets color to default :)
    private static String YELLOW;

    // Not only is Sca the best genre ever,
    // its how we'll get input from the user!
    private Scanner sca;

    public Input() {
        // Mkay. Boring stuff goes here:
        ESC = (char) 27;
        BOLD = ESC + "[01m";
        RED = ESC + "[31m";
        CYAN = ESC + "[36m";
        RESET = ESC + "[0m";
        YELLOW = ESC + "[32m";
        // More colors coming to a
        // class near you!

        // oooh a scanner for input? dope.
        sca = new Scanner(System.in);
    }

    // Reset to Initial State => Terminal color, text, etc all resets
    private void RIS() { System.out.print(ESC + "[2J" + ESC + "[H"); }

    public void bad() {
        System.out.println(BOLD + RED + "No. " + "Bad. " + "Stop. " + CYAN + "(input must be a number btw)" + RESET);
    }

    public boolean stay() {
        System.out.println(CYAN + "You should " + BOLD + "reconsider " + RESET + CYAN + "your choice...");
        System.out.println("Stay a little longer? " + RESET + BOLD + "(1/0): " + RESET);
        switch (get()) {
            case 1: return true;
            case 0: return false;
            default:
                RIS();
                System.out.println(YELLOW + "Sorry, either enter " + BOLD + "0" + RESET + YELLOW + " to quit or " + BOLD + "1" + RESET + YELLOW + " to stay.");
                return stay();
        }
    }
    
    public void display() { RIS(); }

    public short get() {
        System.out.print(BOLD + "Please, put your input below.\n" + RESET + "λ: ");
        short result;
        try {
            result = (short) Integer.parseInt(sca.nextLine());
        } catch (NumberFormatException e) {
            System.out.println(RED + BOLD + "Whoops, looks like you included a string in your response." + RESET);
            result = get();
        }
        return result;
    }
}