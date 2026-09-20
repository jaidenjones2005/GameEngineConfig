
public class ConfigurationManager {

    // Phase 2: Lazy initialization.
    // No instance exists until getInstance() is called.
    private static ConfigurationManager instance = null;

    // Shared game settings
    private int volume;
    private String resolution;
    private boolean fullscreen;

    // Private constructor prevents outside instantiation.
    private ConfigurationManager() {
        System.out.println(
                "ConfigurationManager instance created!"
        );

        volume = 50;
        resolution = "1920x1080";
        fullscreen = false;
    }

    // Create the instance only when first requested.
    public static ConfigurationManager getInstance() {

        if (instance == null) {
            instance = new ConfigurationManager();
        }

        return instance;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        if (volume >= 0 && volume <= 100) {
            this.volume = volume;
        } else {
            System.out.println(
                    "Volume must be between 0 and 100."
            );
        }
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public boolean isFullscreen() {
        return fullscreen;
    }

    public void setFullscreen(boolean fullscreen) {
        this.fullscreen = fullscreen;
    }
}