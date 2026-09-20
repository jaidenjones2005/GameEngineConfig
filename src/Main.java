
public class Main {

    public static void main(String[] args) {

        System.out.println("=== Game Engine Configuration ===");

        // Request two references to the Singleton.
        ConfigurationManager config1 =
                ConfigurationManager.getInstance();

        ConfigurationManager config2 =
                ConfigurationManager.getInstance();

        // Verify that both references point to the same object.
        System.out.println("\nAre both instances the same?");
        System.out.println(config1 == config2);

        // Display the initial settings.
        System.out.println("\nInitial Settings:");
        System.out.println("Volume: " + config1.getVolume());
        System.out.println("Resolution: " + config1.getResolution());
        System.out.println("Fullscreen: " + config1.isFullscreen());

        // Modify settings through the first reference.
        config1.setVolume(80);
        config1.setResolution("2560x1440");
        config1.setFullscreen(true);

        // Read the settings through the second reference.
        System.out.println("\nSettings After Changes:");
        System.out.println("Volume: " + config2.getVolume());
        System.out.println("Resolution: " + config2.getResolution());
        System.out.println("Fullscreen: " + config2.isFullscreen());

        System.out.println("\nPhase 1 Complete!");
    }
}