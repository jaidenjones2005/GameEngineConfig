
public class GraphicsRenderer {

    // Render using the shared configuration.
    public void renderFrame() {

        ConfigurationManager config =
                ConfigurationManager.getInstance();

        System.out.println(
                "Rendering game at resolution: "
                        + config.getResolution()
        );

        System.out.println(
                "Fullscreen mode: "
                        + config.isFullscreen()
        );

        System.out.println(
                "Current shared volume setting: "
                        + config.getVolume()
        );
    }
}