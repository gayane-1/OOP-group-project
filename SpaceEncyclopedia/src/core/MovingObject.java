package core;

public abstract class MovingObject extends CelestialObject {
    private double lastD;
    // These are the orbital elements that are set in the object's
    // constructor.
    double N0, N1;
    double i0, i1;
    double w0, w1;
    double a0, a1;
    double e0, e1;
    double M0, M1;

    // These are computed from the above elements for a given day
    double N;
    double i;
    double w;
    double a;
    double e;
    double M;
    double E;

    // used to compute true anomaly
    double xv;
    double yv;
    // true anomaly
    double v;
    double r;

    // heliocentric coordinates
    double xh;
    double yh;
    double zh;

    // ecliptic longitude and lattitude
    double lonecl;
    double latecl;

    // geocentric coordinates
    double xg;
    double yg;
    double zg;

    // equatorial coordinates
    double xe;
    double ye;
    double ze;

    // geocentic distance
    double rg;

    void computePos(double d) {
        // compute the orbital elements for this day.
        N = N0 + N1 * d;
        i = i0 + i1 * d;
        w = w0 + w1 * d;
        a = a0 + a1 * d;
        e = e0 + e1 * d;
        M = M0 + M1 * d;

        // compute the mean anomaly
        E = M + e * (180 / Math.PI) * Converter.sin(Converter.degToRad(M)) *
                (1.0 + e * Converter.cos(Converter.degToRad(M)));
        // iterate it if it's too big
        if (E > 0.055) {
            double E0 = E;
            double E1;
            for (; ;) {
                E1 = E0 - (E0 - e * (180 / Math.PI) * Converter.sin(E0) - M) /
                        (1 - e * Converter.cos(E0));
                if (Math.abs(E1 - E0) < 0.001) {
                    E = E1;
                    break;
                }
                E0 = E1;
            }
        }


        // needed for next two operations
        xv = a * Converter.cos(E) - e;
        yv = a * Math.sqrt(1.0 - e * e) * Converter.sin(E);

        // compute the true anomaly
        v = Converter.atan2(yv, xv);
        // compute the distance
        r = Math.sqrt(xv * xv + yv * yv);

        // compute the heliocentric position in space
        xh = r * (Converter.cos(N) * Converter.cos(v + w) -
                Converter.sin(N) * Converter.sin(v + w) * Converter.cos(i));
        yh = r * (Converter.sin(N) * Converter.cos(v + w) +
                Converter.cos(N) * Converter.sin(v + w) * Converter.cos(i));
        zh = r * (Converter.sin(v + w) * Converter.sin(i));

        // compute the ecliptic longitude and lattitude
        lonecl = Converter.atan2(yh, xh);
        latecl = Converter.atan2(zh, Math.sqrt(xh * xh + yh * yh));

        // call the pertubation method for this object.  This may do
        // nothing, or it may recompute lonecl, latecl, xh, yh and zh;
        this.computePertubations(d);

        // compute the position of the sun for this time
        sun.get().computePos(d);
        double xs = sun.get().r * Converter.cos(sun.get().lonsun);
        double ys = sun.get().r * Converter.sin(sun.get().lonsun);

        // compute the geocentric position
        xg = xh + xs;
        yg = yh + ys;
        zg = zh;

        // now convert to equatorial coordinates
        double ecl = 23.4393 - 3.563E-7 * d;
        xe = xg;
        ye = yg * Converter.cos(ecl) - zg * Converter.sin(ecl);
        ze = yg * Converter.sin(ecl) + zg * Converter.cos(ecl);

        // compute the right acension and declination
        RA = Converter.atan2(ye, xe);
        decl = Converter.atan2(ze, Math.sqrt(xe * xe + ye * ye));
        while (decl >= 360.0)
            decl -= 360.0;
        // compute the geocentric distance
        rg = Math.sqrt(xe * xe + ye * ye + ze * ze);
    }

    @SuppressWarnings("WeakerAccess")
    public double computeMeanAnomaly(double d)
    {
        return M0 + M1 * d;
    }

    public double getRA(double t) {
        if (lastD != t) {
            computePos(t);
            lastD = t;
        }
        return RA;
    }

    public double getDecl(double t) {
        if (lastD != t) {
            computePos(t);
            lastD = t;
        }
        return decl;
    }

    abstract void computePertubations(double d);

}
