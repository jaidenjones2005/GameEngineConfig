
public class ConfigurationManager {

    // Eager initialization: created when the class loads.
    private static final ConfigurationManager instance =
            new ConfigurationManager();

    // Shared game settings
    private int volume;
    private String resolution;
    private boolean fullscreen;

    // Private constructor prevents outside instantiation.
    private ConfigurationManager() {
        volume = 50;
        resolution = "1920x1080";
        fullscreen = false;
    }

    // Global access to the one instance.
    public static ConfigurationManager getInstance() {
        return instance;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        if (volume >= 0 && volume <= 100) {
            this.volume = volume;
        } else {
            System.out.println("Volume must be between 0 and 100.");
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