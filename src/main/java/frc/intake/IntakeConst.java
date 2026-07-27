package frc.intake;

import static edu.wpi.first.units.Units.Degrees;

import edu.wpi.first.units.measure.Angle;

public class IntakeConst {
    public static final int DEPLOY_MOTOR_ID = 1;
    public static final int ROLLER_MOTOR_ID = 2;
    // Test values
    public static final int REVERSE_SPEED = -2;
    public static final int ROLLER_FORWARD_SPEED = 3;

    public static final Angle MIN_ANGLE = Degrees.of(0.0);
    public static final Angle MAX_ANGLE = Degrees.of(128.26);
    public static final double GEAR_RATIO = 96.0;
}
