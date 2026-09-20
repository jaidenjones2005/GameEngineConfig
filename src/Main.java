
public class Main {

    public static void main(String[] args) {

        System.out.println(
                "=== Game Engine Configuration ==="
        );

        System.out.println(
                "\nApplication started. No configuration requested yet."
        );

        // First request creates the Singleton.
        System.out.println("\nRequesting first instance...");

        ConfigurationManager config1 =
                ConfigurationManager.getInstance();

        // Second request reuses the same instance.
        System.out.println("\nRequesting second instance...");

        ConfigurationManager config2 =
                ConfigurationManager.getInstance();

        // Verify both references point to the same object.
        System.out.println(
                "\nAre both instances the same? "
                        + (config1 == config2)
        );

        // Verify shared configuration state.
        config1.setVolume(80);
        config1.setResolution("2560x1440");
        config1.setFullscreen(true);

        System.out.println("\nShared Configuration Test:");

        System.out.println(
                "Volume from config2: "
                        + config2.getVolume()
        );

        System.out.println(
                "Resolution from config2: "
                        + config2.getResolution()
        );

        System.out.println(
                "Fullscreen from config2: "
                        + config2.isFullscreen()
        );

        // Create independent game subsystems.
        AudioSystem audio = new AudioSystem();

        GraphicsRenderer graphics = new GraphicsRenderer();

        System.out.println("\n=== Initial Subsystem Status ===");

        audio.playSound();
        graphics.renderFrame();

        // Modify shared state through AudioSystem.
        System.out.println("\n=== Changing Volume ===");

        audio.adjustVolume(35);

        // Both subsystems should see the new value.
        System.out.println("\n=== Updated Subsystem Status ===");

        audio.playSound();
        graphics.renderFrame();

        // Modify graphics settings through main.
        System.out.println("\n=== Changing Graphics Settings ===");

        config1.setResolution("1280x720");
        config1.setFullscreen(false);

        graphics.renderFrame();

        System.out.println("\nPhase 3 Complete!");
    }
}