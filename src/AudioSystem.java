
public class AudioSystem {

    // Play audio using the shared configuration.
    public void playSound() {

        ConfigurationManager config =
                ConfigurationManager.getInstance();

        System.out.println(
                "Playing game audio at volume: "
                        + config.getVolume()
        );
    }

    // Modify the shared volume setting.
    public void adjustVolume(int newVolume) {

        ConfigurationManager config =
                ConfigurationManager.getInstance();

        config.setVolume(newVolume);

        System.out.println(
                "AudioSystem updated volume to: "
                        + config.getVolume()
        );
    }
}