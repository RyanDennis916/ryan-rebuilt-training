package frc.intake;

import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class IntakeSubsystem extends SubsystemBase {
    private final TalonFX deployMotor = new TalonFX(IntakeConst.DEPLOY_MOTOR_ID);
    private final TalonFX rollerMotor = new TalonFX(IntakeConst.ROLLER_MOTOR_ID);

    public IntakeSubsystem() {
        deployMotor.getConfigurator().apply(IntakeConfig.deployMotorConfig);
        rollerMotor.getConfigurator().apply(IntakeConfig.rollerMotorConfig);
        deployMotor.setPosition(IntakeConst.MAX_ANGLE);
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
}
