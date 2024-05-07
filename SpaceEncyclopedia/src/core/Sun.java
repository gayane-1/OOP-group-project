package core;

public class Sun extends MovingObject
{
    public Sun() {
        name = "Sun";
        symbol = "\u2609";
        N0 = N1 = 0.0;
        i0 = i1 = 0.0;
        w0 = 282.9404;
        w1 = 4.70935E-5;
        a = 1.0;
        e0 = 0.016709;
        e1 = -1.151E-9;
        M0 = 356.0470;
        M1 = 0.9856002585;
    }

    double lonsun;

    /* The sun has a slightly simpler computation for getting the
    position, so it overrides this method.
    */
    void computePos(double d) {
        N = 0.0;
        i = 0.0;
        w = w0 + w1 * d;
        e = e0 + e1 * d;
        M = Converter.rev(M0 + M1 * d);

        E = M + e * (180 / Math.PI) * Converter.sin(M) *
                (1.0 + e * Converter.cos(M));

        xv = Converter.cos(E) - e;
        yv = Math.sqrt(1.0 - e * e) * Converter.sin(E);
        v = Converter.atan2(yv, xv);
        // System.out.println("vs = "+vs);
        r = Math.sqrt(xv * xv + yv * yv);
        lonsun = v + w;
        xh = r * Converter.cos(lonsun);
        yh = r * Converter.sin(lonsun);
        zh = 0.0;

        double ecl = 23.4394 - 3.563E-7 * d;
        xe = xh;
        ye = yh * Converter.cos(ecl);
        ze = yh * Converter.sin(ecl);
        RA = Converter.atan2(ye, xe);
        decl = Converter.atan2(ze, Math.sqrt(xe * xe + ye * ye));
        decl = Converter.rev(decl);
        if (decl > 180.0)
            decl = decl - 360.0;
    }

    public double getRA(double d) {
        computePos(d);
        return RA;
    }

    public double getDecl(double d) {
        computePos(d);
        return decl;
    }

    @SuppressWarnings("FieldCanBeLocal")
    private double L;
    double GMST0;
    @SuppressWarnings("FieldCanBeLocal")
    private double h;
    @SuppressWarnings("FieldCanBeLocal")
    private double preLHA;
    private double LHA;
    private double UT_Sun_in_south;

    void computeSetData(double lon, double lat) {
        L = M + w;
        if (L > 360.0)
            L %= 360.0;
        GMST0 = Converter.rev(L + 180.0);
        UT_Sun_in_south = (RA - GMST0 - lon) / 15.0;
        if (UT_Sun_in_south > 24.0)
            UT_Sun_in_south %= 24.0;
        else if (UT_Sun_in_south < 0.0)
            UT_Sun_in_south += 24.0;
        h = -0.833;
        preLHA = (Converter.sin(h) - Converter.sin(lat) * Converter.sin(decl)) / (Converter.cos(lat) * Converter.cos(decl));
        LHA = Converter.acos(preLHA) / 15.0;
    }

    @SuppressWarnings("unused")
    public double computeTransitTime(double lon, double lat, double d,
                                     double tzOff) {
        d = d - d % 1.0 + 0.5 + tzOff / 24.0;
        computePos(d);
        computeSetData(lon, lat);
        return UT_Sun_in_south;
    }

    @SuppressWarnings("WeakerAccess")
    public double computeRiseTime(double lon, double lat, double d,
                                  double tzOff) {
        // adjsut d to be noon local time
        d = d - d % 1.0 + 0.5 + tzOff / 24.0;
        computePos(d);
        computeSetData(lon, lat);
        return UT_Sun_in_south - LHA;
    }

    @SuppressWarnings("unused")
    public double computeSetTime(double lon, double lat, double d,
                                 double tzOff) {
        // adjsut d to be noon local time
        d = d - d % 1.0 + 0.5 + tzOff / 24.0;
        computePos(d);
        computeSetData(lon, lat);
        return UT_Sun_in_south + LHA;
    }

    void computePertubations(double d) {
        // don't do anything for this object
    }

}
