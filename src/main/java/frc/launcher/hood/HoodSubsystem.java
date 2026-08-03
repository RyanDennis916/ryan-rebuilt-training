package frc.launcher.hood;

import static edu.wpi.first.units.Units.Degrees;
import static edu.wpi.first.units.Units.Rotations;

import com.ctre.phoenix6.controls.MotionMagicVoltage;
import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.units.measure.Angle;
import edu.wpi.first.util.sendable.SendableBuilder;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class HoodSubsystem extends SubsystemBase {
    private final TalonFX motor = new TalonFX(HoodConst.MOTOR_ID);

    private Angle targetPitch;

    public HoodSubsystem() {
        motor.getConfigurator().apply(HoodConfig.motorConfig);
    }

    public void movePitch(Angle angle) {
        targetPitch =
                Rotations.of(
                        MathUtil.clamp(
                                angle.in(Rotations),
                                HoodConst.MIN_ANGLE.in(Rotations),
                                HoodConst.MAX_ANGLE.in(Rotations)));
        motor.setControl(new MotionMagicVoltage(targetPitch));
    }

    public void stow() {
        movePitch(HoodConst.MIN_ANGLE);
    }

    public Angle getMotorPitch() {
        return motor.getPosition().getValue();
    }

    public void initSendable(SendableBuilder builder) {
        builder.addDoubleProperty(
                "pitch (deg)",
                () -> getMotorPitch().in(Degrees),
                (angle) -> movePitch(Degrees.of(angle)));
        builder.addDoubleProperty(
                "target pitch (deg)",
                () -> getMotorPitch().in(Degrees),
                (targetPitch) -> movePitch(Degrees.of(targetPitch)));
    }
}
