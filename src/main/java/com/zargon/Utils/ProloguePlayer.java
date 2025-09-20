package com.zargon.Utils;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

public class ProloguePlayer {
    // ===== Timing =====
    private static final int TYPE_DELAY_MS = 18;   // per character (normal)
    private static final int FAST_DELAY_MS = 0;    // per character (fast-forward)
    private static final int LINE_DELAY_MS = 250;  // pause after each line

    // ===== Colors =====
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String BLUE = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String BRIGHT_WHITE = "\u001B[97m";
    public static final String BRIGHT_YELLOW = "\u001B[93m";
    public static final String DIM = "\u001B[2m";

    // ===== Runtime UI colors =====
    private static final String PROMPT_COLOR = CYAN;
    private static final String HINT_COLOR = DIM + BRIGHT_WHITE;

    // ===== Runtime controls (changed by input watcher) =====
    private static volatile boolean fastForward = false;
    private static volatile boolean skipCurrentScreen = false;

    // ===== Color-coded prologue screens =====
    private static final List<String[]> SCREENS = List.of(
        new String[]{
            "The void hums with forgotten whispers.",
            "Between the sands of planet " + GREEN + "KI" + RESET + " and the fertile soil of planet " + GREEN + "Geb" + RESET + ",",
            "a thousand journeys cross the darkness."
        },
        new String[]{
            "At the center of it all floats " + PURPLE + "ZARGON " + RESET + ".",
            "A colossal station of steel and stone,",
            "its chambers echoing with the dreams of empire."
        },
        new String[]{
            "The " + RED + "Tartarians" + RESET + " of " + GREEN + "KI" + RESET + " rule with quiet cruelty.",
            "Their cities gleam with riches, temples, and technologies beyond imagination,",
            "while the poor toil unseen, trapped in the orbit of endless labor.",
            "To the elites,  " + PURPLE + "ZARGON " + RESET + " is a jewel of progress, the halfway gate to conquest.",
            "To others, it is a prison with no bars, a reminder that freedom drifts always just beyond reach."
        },
        new String[]{
            "Yet not all bow to " + RED + "Tartarians" + RESET + " power. In the tunnels beneath " + GREEN + "KI" + RESET + "’s cities, wispers stir in the dark.",
            "They call themselves the " + CYAN + "MERED" + RESET + " — rebels, outcasts... shadows.",
            "They slip among the elites like ghosts, undermining their masters, seeking to crack the Empire from within. The " + RED + "Tartarians" + RESET + " brand them as thieves and traitors.",
            "The " + CYAN + "MERED" + RESET + " call themselves free."
        },
        new String[]{
            "And you? You are neither elite nor rebel.",
            "You are a " + BLUE + "SCAVENGER" + RESET + ":",
            "No crown, no rebellion, no chains save the ones forged by necessity.",
            "Your job is simple: find, haul, deliver.",
            "Broken comets, hollowed moons, the scraps of forgotten worlds.",
            "Whatever can fuel the " + RED + "Tartarians" + RESET + " engines of expansion, you drag back from the cold.",
            "You are a trader of survival, a courier between " + GREEN + "KI" + RESET + ", " + PURPLE + "ZARGON" + RESET + ", and  " + GREEN + "Geb" + RESET + ".",
        },
        new String[]{
            "Your ship, a rickety vessel patched more times than you care to count,",
            "rattles as it enters the docking bay of " + PURPLE + "ZARGON" + RESET + ".",
            "Its cargo hold is heavy with materials pulled from the black, bound for " + GREEN + "Geb" + RESET + " where the " + RED + "Tartarians" + RESET + " have begun their great expansions:",
            "The pyramids of " + BRIGHT_YELLOW + "Ta-we" + RESET + ", rising against the sky in the lush lands of " + DIM + "Kemet" + RESET + ", and a distant outpost whispered as " + BRIGHT_YELLOW + "Olmec" + RESET + "."
        },
        new String[]{
            "The overseers of  " + PURPLE + "ZARGON " + RESET + " demand progress. The " + CYAN + "Mered" + RESET + " demand change.",
            "You demand nothing. You fly. You deliver. You endure."
        },
        new String[]{
            "Now, as your ship settles into the cold embrace of the landing clamps, your task is clear:",
            "Unload. Recharge. Wait."
        },
        new String[]{
            "In two days this battered craft is marked for " + GREEN + "Geb" + RESET + ".",
            "Two days before the wheel of empire turns again."
        },
        new String[]{
            "And in those two days,",
            "your path may be written among the stars…"
        }
    );

    public static void play() throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < SCREENS.size(); i++) {
            clearScreen();
            printHeader(i + 1, SCREENS.size(), fastForward);

            for (String line : SCREENS.get(i)) {
                typeLine(line);
                if (!fastForward) Thread.sleep(LINE_DELAY_MS);
                // if (skipCurrentScreen) {
                //     skipCurrentScreen = false;
                //     break;
                // }
            }

            // Prompt after screen
            if (i < SCREENS.size() - 1) {
                // showPrompt("[Press Enter to continue!]  (F=fast-forward, S=skip screen)");
                showPrompt("[Press Enter to continue!]");
            } else {
                showPrompt("End of Prolouge - [Press Enter to begin]");
            }

                // --- Single input point ---
                String cmd = in.readLine().trim().toLowerCase();
                if (cmd.equals("f")) {
                    fastForward = !fastForward;
                    i++;
                // } else if (cmd.equals("s")) {
                //     skipCurrentScreen = true; // mark to skip next time
                //     i--; // replay this screen and skip it immediately
                } else if (cmd.equals("q")) {
                    transientNotice("Prologue aborted by user.");
                    break; // exit prologue early
                }
            }
            // if just empty (Enter) → continue normally
    }

    private static void typeLine(String s) throws InterruptedException {
        int delay = fastForward ? FAST_DELAY_MS : TYPE_DELAY_MS;
        for (int i = 0; i < s.length(); ) {
            if (s.charAt(i) == '\u001B') {
                // Print the whole ANSI sequence instantly
                int end = i + 1;
                while (end < s.length() && s.charAt(end) != 'm') end++;
                if (end < s.length()) end++; // include 'm'
                System.out.print(s.substring(i, end));
                i = end;
            } else {
                System.out.print(s.charAt(i));
                System.out.flush();
                if (delay > 0) Thread.sleep(delay);
                i++;
            }
        }
        System.out.println();
    }

    private static void clearScreen() {
        System.out.print("\u001b[2J\u001b[H"); // ANSI clear + home
        System.out.flush();
    }

    private static void printHeader(int idx, int total, Boolean fastForward) {
        String title = PROMPT_COLOR + "[Prologue " + idx + "/" + total + "]" + RESET;
        String hint = " " + HINT_COLOR + "[F=fast-forward , Q-exit-prolouge, Enter=continue] FF: "  + (fastForward ? "ON" : "OFF") + RESET;
        System.out.println(title + hint + "\n");
    }

    private static void showPrompt(String msg) {
        System.out.println();
        System.out.println(PROMPT_COLOR + msg + RESET);
        System.out.flush();
    }

    private static void transientNotice(String msg) {
        // lightweight inline feedback; no newline to keep flow tight
        System.out.println();
        System.out.println(HINT_COLOR + msg + RESET);
        System.out.flush();
    }
}
