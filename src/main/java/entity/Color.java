package entity;

public enum Color {
    BLACK((byte)0x00, (byte)0x00, (byte)0x00),
    WHITE((byte)0xFF, (byte)0xFF, (byte)0xFF),
    YELLOW((byte)0xFF, (byte)0xFF, (byte)0x00),
    GREEN((byte)0x00, (byte)0x80, (byte)0x00),
    BLUE((byte)0x00, (byte)0x00, (byte)0xFF),
    BROWN((byte)0xA5, (byte)0x2A, (byte)0x2A),
    RED((byte)0xFF, (byte)0x00, (byte)0x00),
    GRAY((byte)0x80, (byte)0x80, (byte)0x80),
    ORANGE((byte)0xFF, (byte)0xA5, (byte)0x00);

    private byte[] rgb;

    Color(byte r, byte g, byte b){
        rgb = new byte[]{r, g, b};
    }

    public byte[] getRgb() {
        return rgb;
    }
}
