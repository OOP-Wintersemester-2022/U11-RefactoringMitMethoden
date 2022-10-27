import de.ur.mi.oop.app.GraphicsApp;
import de.ur.mi.oop.colors.Color;
import de.ur.mi.oop.colors.Colors;
import de.ur.mi.oop.graphics.Circle;
import de.ur.mi.oop.launcher.GraphicsAppLauncher;

public class Target extends GraphicsApp {

    /* Konstanten für Canvas-Aufbau */
    private static final int CANVAS_HEIGHT = 800;
    private static final int CANVAS_WIDTH = 800;
    private static final Color BACKGROUND_COLOR = Colors.WHITE;

    private static final int HORIZONTAL_CENTER = CANVAS_WIDTH / 2;
    private static final int VERTICAL_CENTER = CANVAS_HEIGHT / 2;

    /* Eigenschaften für die Wurfpfeil-Zielscheibe */
    private static final Color RING_COLOR_UNEVEN = Colors.RED;
    private static final Color RING_COLOR_EVEN = Colors.WHITE;
    private static final int NUM_RINGS = 15;
    private static final int INITIAL_RING_WIDTH = 10;

    /*
     * Die initialize-Methode wird einmalig zum Start des Programms
     * aufgerufen.
     */

    @Override
    public void initialize() {
        setupCanvas();
    }

    /*
     * Die draw-Methode wird so lange wiederholt aufgerufen, bis das Programm
     * beendet wird.
     */

    @Override
    public void draw() {
        drawBackground(BACKGROUND_COLOR);
        drawDartTarget();
    }

    private void setupCanvas() {
        setCanvasSize(CANVAS_WIDTH, CANVAS_HEIGHT);
        drawBackground(BACKGROUND_COLOR);
    }

    private void drawDartTarget() {
        for (int i = NUM_RINGS; i > 0; i--) {
            Color ringColor = getColor(i);
            drawRing(i, ringColor);
        }
    }

    private void drawRing(int ringIndex, Color ringColor) {
        int radius = (INITIAL_RING_WIDTH) + (ringIndex * INITIAL_RING_WIDTH);
        Circle ring = new Circle(HORIZONTAL_CENTER, VERTICAL_CENTER, radius, ringColor);
        ring.draw();
    }

    private Color getColor(int i) {
        if (i % 2 == 0) {
            return RING_COLOR_EVEN;
        } else {
            return RING_COLOR_UNEVEN;
        }
    }

    public static void main(String[] args) {
        GraphicsAppLauncher.launch();
    }
}