package frc.intake;

import static edu.wpi.first.units.Units.Rotations;

import com.ctre.phoenix6.controls.MotionMagicVoltage;
import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.units.measure.Angle;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class IntakeSubsystem extends SubsystemBase {
    private final TalonFX deployMotor = new TalonFX(IntakeConst.DEPLOY_MOTOR_ID);
    private final TalonFX rollerMotor = new TalonFX(IntakeConst.ROLLER_MOTOR_ID);

    public IntakeSubsystem() {
        deployMotor.getConfigurator().apply(IntakeConfig.deployMotorConfig);
        rollerMotor.getConfigurator().apply(IntakeConfig.rollerMotorConfig);
        deployMotor.setPosition(IntakeConst.MAX_ANGLE);
    }

    public void moveAngle(Angle angle) {
        Angle targetAngle =
                Rotations.of(
                        MathUtil.clamp(
                                angle.in(Rotations),
                                IntakeConst.MIN_ANGLE.in(Rotations),
                                IntakeConst.MAX_ANGLE.in(Rotations)));
        deployMotor.setControl(new MotionMagicVoltage(targetAngle));
    }

    public void moveRollerSpeed(double speed) {
        rollerMotor.set(speed);
    }

    public void rollersOn() {
        moveRollerSpeed(IntakeConst.ROLLER_FORWARD_SPEED);
    }

    public void rollersOff() {
        moveRollerSpeed(0);
    }

    public void rollersReverse() {
        moveRollerSpeed(IntakeConst.REVERSE_SPEED);
    }

    public void moveDown() {
        moveAngle(IntakeConst.MIN_ANGLE);
    }

    public void moveUp() {
        moveAngle(IntakeConst.MAX_ANGLE);
    }

    public void deploy() {
        rollersOn();
        moveDown();
    }

    public void stow() {
        rollersOff();
        moveUp();
    }
}
