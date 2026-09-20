
public class Main {

    public static void main(String[] args) {

        System.out.println(
                "=== Game Engine Configuration ==="
        );

        System.out.println(
                "\nApplication started. No configuration requested yet."
        );

        // First call creates the Singleton.
        System.out.println(
                "\nRequesting first instance..."
        );

        ConfigurationManager config1 =
                ConfigurationManager.getInstance();

        // Second call should reuse the same instance.
        System.out.println(
                "\nRequesting second instance..."
        );

        ConfigurationManager config2 =
                ConfigurationManager.getInstance();

        // Verify reference equality.
        System.out.println(
                "\nAre both instances the same?"
        );

        System.out.println(config1 == config2);

        // Display initial settings.
        System.out.println("\nInitial Settings:");

        System.out.println(
                "Volume: " + config1.getVolume()
        );

        System.out.println(
                "Resolution: " + config1.getResolution()
        );

        System.out.println(
                "Fullscreen: " + config1.isFullscreen()
        );

        // Modify settings through the first reference.
        config1.setVolume(80);
        config1.setResolution("2560x1440");
        config1.setFullscreen(true);

        // Read the changes through the second reference.
        System.out.println("\nSettings After Changes:");

        System.out.println(
                "Volume: " + config2.getVolume()
        );

        System.out.println(
                "Resolution: " + config2.getResolution()
        );

        System.out.println(
                "Fullscreen: " + config2.isFullscreen()
        );

        System.out.println("\nPhase 2 Complete!");
    }
}