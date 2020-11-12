import java.awt.*;
import java.util.HashMap;


public class Main {

    static float samplerate = 4410.0f; // частота сэмпла
    static float wavefrequency = 100.0f; // частота волны
    static float wavevolume = 16.0f; // громкость волны
    static int samplelenght = 1638;
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            HashMap<String, double[]> map = new HashMap<String, double[]>() {{
                put("Sin", new Sine(samplerate, wavefrequency, wavevolume, samplelenght).getSine());
                put("Saw", new Saw(samplerate, wavefrequency, wavevolume, samplelenght).getSaw());
                put("Triangle", new Triangle(samplerate, wavefrequency, wavevolume, samplelenght).getTriangle());
            }};
            Drawer ex = new Drawer("Lab5", map);
            ex.setVisible(true);
        });
    }
}
