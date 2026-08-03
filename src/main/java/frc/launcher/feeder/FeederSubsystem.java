package frc.launcher.feeder;

import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.util.sendable.SendableBuilder;

public class FeederSubsystem {
    private final TalonFX motor = new TalonFX(FeederConst.MOTOR_ID, FeederConst.CAN_BUS);

    public FeederSubsystem() {
        motor.getConfigurator().apply(FeederConfig.motorConfig);
    }

    public void moveMotorSpeed(double speed) {
        motor.set(speed);
    }

    public void start() {
        moveMotorSpeed(FeederConfig.SPEED);
    }

    public void stop() {
        moveMotorSpeed(0);
    }

    public double getMotorSpeed() {
        return motor.get();
    }

    public void initSendable(SendableBuilder builder) {
        builder.addDoubleProperty("motor speed", this::getMotorSpeed, this::moveMotorSpeed);
    }
}
