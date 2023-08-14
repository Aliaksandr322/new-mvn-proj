package enums;

public enum Severity {

    BlOCKER(1){
        @Override
        public String getTimeFrame() {
            return "Time to perform 3 hours";
        }
    },
    CRITICAL(2) {
        @Override
        public String getTimeFrame() {
            return "Time to perform 8 hours";
        }
    },
    NOT_CRITICAL(3){
        @Override
        public String getTimeFrame() {
            return "Time to perform 2 days";
        }
    },
    MINOR(4){
        @Override
        public String getTimeFrame() {
            return "Time to perform 2 week";
        }
    };

    private int priority;
    Severity(int priority){
        this.priority = priority;
    }

    public int getPriority(){
        return priority;
    }

    public abstract String getTimeFrame();

    public Severity getSeverity(int priority){
        switch (priority){
            case 1:
                return BlOCKER;
            case 2:
                return CRITICAL;
            case 3:
                return NOT_CRITICAL;
            case 4:
                return MINOR;
        }
        throw new IllegalArgumentException("Wrong priority");
    }

}

enum Planet {
    MERCURY (3.303e+23, 2.4397e6),
    VENUS   (4.869e+24, 6.0518e6),
    EARTH   (5.976e+24, 6.37814e6),
    MARS    (6.421e+23, 3.3972e6),
    JUPITER (1.9e+27,   7.1492e7),
    SATURN  (5.688e+26, 6.0268e7),
    URANUS  (8.686e+25, 2.5559e7),
    NEPTUNE (1.024e+26, 2.4746e7);

    private final double mass;   // in kilograms
    private final double radius; // in meters
    Planet(double mass, double radius) {
        this.mass = mass;
        this.radius = radius;
    }
    private double mass() { return mass; }
    private double radius() { return radius; }

    // universal gravitational constant  (m3 kg-1 s-2)
    public static final double G = 6.67300E-11;

    double surfaceGravity() {
        return G * mass / (radius * radius);
    }
    double surfaceWeight(double otherMass) {
        return otherMass * surfaceGravity();
    }
    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Usage: java Planet <earth_weight>");
            System.exit(-1);
        }
        double earthWeight = Double.parseDouble(args[0]);
        double mass = earthWeight/EARTH.surfaceGravity();
        for (Planet p : Planet.values())
            System.out.printf("Your weight on %s is %f%n",
                    p, p.surfaceWeight(mass));
    }
}
