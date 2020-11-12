import java.util.HashMap;
import java.util.Map;

public class Saw {
    float samplerate; // частота сэмпла
    float wavefrequency; // частота волны
    float wavevolume; // громкость волны
    int samplelenght;
    float period;

    public Saw(float samplerate, float wavefrequency, float wavevolume, int samplelenght) {
        this.samplerate = samplerate;
        this.wavefrequency = wavefrequency;
        this.wavevolume = wavevolume;
        this.samplelenght = samplelenght;
        this.period = samplerate / wavefrequency;
    }

    public double[] getSaw() {
        int c = 0; //Специальная переменная для проверки на окончание периода
        double[] buffer = new double[samplelenght];

        for (int a = 0;a < samplelenght; a++) //цикл на длину сэмпла
        {
            if (c >= period) c = 0; //если период закончился, то начать следующий
            buffer[a] =  (double) (wavevolume * (c / period) - wavevolume); //вычисление волны
            c++;
        }
        return buffer;
    }
}
