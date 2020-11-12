public class Noise {
    float samplerate; // частота сэмпла
    float wavefrequency; // частота волны
    float wavevolume; // громкость волны
    int samplelenght;
    float period; //период волны

    public Noise(float samplerate, float wavefrequency, float wavevolume, int samplelenght, float period) {
        this.samplerate = samplerate;
        this.wavefrequency = wavefrequency;
        this.wavevolume = wavevolume;
        this.samplelenght = samplelenght;
        this.period = period;
    }
}
