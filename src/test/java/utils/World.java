package utils;

public class World {

    private static CartEntryInfo cartEntryInfo;

    public static void saveCartEntryInfo(CartEntryInfo cartEntryInfo) {
        World.cartEntryInfo = cartEntryInfo;
    }

    public static CartEntryInfo getCartEntryInfo() {
        return World.cartEntryInfo;
    }
}
