package net.knsh.chroma.util;

public enum GlassType {
    Shotglass (15),
    Glass (40),
    Mug (75);

    private final int time;

    GlassType(int i) {
        this.time = i;
    }

    public int drinkTime() {
        return time;
    }
}
