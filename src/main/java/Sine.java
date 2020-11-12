import java.util.HashMap;
import java.util.Map;

public class Sine {
    float samplerate; // частота сэмпла
    float wavefrequency; // частота волны
    float wavevolume; // громкость волны
    int samplelenght;
    float period; //период волны

    public Sine(float samplerate, float wavefrequency, float wavevolume, int samplelenght) {
        this.samplerate = samplerate;
        this.wavefrequency = wavefrequency;
        this.wavevolume = wavevolume;
        this.period = samplerate / wavefrequency / 2;
        this.samplelenght = samplelenght;
    }

    public double[] getSine() {
        double[] buffer = new double[samplelenght];
        for (int a = 0; a < samplelenght; a++) //устанавливаем цикл на длину сэмпла
        {
            buffer[a] =  wavevolume * Math.sin(a * Math.PI / period);
        }
        return buffer;
    }
}
