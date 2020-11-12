public class Triangle {
    float samplerate; // частота сэмпла
    float wavefrequency; // частота волны
    float wavevolume; // громкость волны
    int samplelenght;
    float period; //период волны

    public Triangle(float samplerate, float wavefrequency, float wavevolume, int samplelenght) {
        this.samplerate = samplerate;
        this.wavefrequency = wavefrequency;
        this.wavevolume = wavevolume;
        this.samplelenght = samplelenght;
        this.period = samplerate / wavefrequency / 2;
    }

    public double[] getTriangle() {
        float c = period * 2;
        int c2 = -1;
        float sr_2m = period;
        float sr = samplerate / wavefrequency / 4;
        double[] buffer = new double[samplelenght];

        for (int a = 0; a < samplelenght; a++) {
            if (c > sr_2m) {
                c = sr_2m;
                c2 = -1;
            }
            if (c < 0) {
                c = 0;
                c2 = 1;
            }
            buffer[a] = wavevolume * (c / sr) - wavevolume;
            c += c2;
        }
        return buffer;
    }
}
