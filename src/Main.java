
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ConfigurationManager config =
                ConfigurationManager.getInstance();

        AudioSystem audio = new AudioSystem();
        GraphicsRenderer graphics = new GraphicsRenderer();

        boolean running = true;

        System.out.println("=== Game Engine Console ===");

        while (running) {

            System.out.println("\n===== MAIN MENU =====");
            System.out.println("1. View engine and subsystem status");
            System.out.println("2. Modify configuration settings");
            System.out.println("3. Trigger subsystem actions");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            String choice = scanner.nextLine().trim();

            switch (choice) {

                case "1":
                    System.out.println("\n--- Current Settings ---");

                    System.out.println(
                            "Volume: " + config.getVolume()
                    );

                    System.out.println(
                            "Resolution: " + config.getResolution()
                    );

                    System.out.println(
                            "Fullscreen: " + config.isFullscreen()
                    );

                    System.out.println("\n--- Subsystem Status ---");
                    audio.playSound();
                    graphics.renderFrame();
                    break;

                case "2":
                    System.out.println("\n--- Modify Settings ---");
                    System.out.println("1. Change volume");
                    System.out.println("2. Change resolution");
                    System.out.println("3. Toggle fullscreen");
                    System.out.print("Choose a setting: ");

                    String setting = scanner.nextLine().trim();

                    switch (setting) {

                        case "1":
                            System.out.print(
                                    "Enter volume (0-100): "
                            );

                            String volumeInput =
                                    scanner.nextLine().trim();

                            try {
                                int volume =
                                        Integer.parseInt(volumeInput);

                                if (volume >= 0 && volume <= 100) {
                                    audio.adjustVolume(volume);
                                } else {
                                    System.out.println(
                                            "Volume must be between 0 and 100."
                                    );
                                }

                            } catch (NumberFormatException e) {
                                System.out.println(
                                        "Invalid input. Enter a whole number."
                                );
                            }
                            break;

                        case "2":
                            System.out.print(
                                    "Enter resolution (e.g. 1920x1080): "
                            );

                            String resolution =
                                    scanner.nextLine().trim();

                            if (resolution.isEmpty()) {
                                System.out.println(
                                        "Resolution cannot be empty."
                                );
                            } else {
                                config.setResolution(resolution);

                                System.out.println(
                                        "Resolution updated to: "
                                                + config.getResolution()
                                );
                            }
                            break;

                        case "3":
                            config.setFullscreen(
                                    !config.isFullscreen()
                            );

                            System.out.println(
                                    "Fullscreen mode: "
                                            + config.isFullscreen()
                            );
                            break;

                        default:
                            System.out.println(
                                    "Invalid setting option."
                            );
                    }
                    break;

                case "3":
                    System.out.println(
                            "\n--- Triggering Subsystems ---"
                    );

                    audio.playSound();
                    graphics.renderFrame();
                    break;

                case "4":
                    System.out.println(
                            "\nExiting Game Engine Console. Goodbye!"
                    );

                    running = false;
                    break;

                default:
                    System.out.println(
                            "Invalid option. Please choose 1-4."
                    );
            }
        }

        scanner.close();
    }
}