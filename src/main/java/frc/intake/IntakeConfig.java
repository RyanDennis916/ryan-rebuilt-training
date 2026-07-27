package frc.intake;

import static edu.wpi.first.units.Units.Rotations;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.signals.InvertedValue;
import com.ctre.phoenix6.signals.NeutralModeValue;

public class IntakeConfig {
    public static final TalonFXConfiguration deployMotorConfig = new TalonFXConfiguration();
    public static final TalonFXConfiguration rollerMotorConfig = new TalonFXConfiguration();

    static {
        deployMotorConfig.CurrentLimits.StatorCurrentLimit = 40.0;
        deployMotorConfig.CurrentLimits.StatorCurrentLimitEnable = true;
        deployMotorConfig.MotorOutput.NeutralMode = NeutralModeValue.Coast;
        // + output = moves intake up/towards MAX_ANGLE
        // - output = moves intake down/towards MIN_ANGLE
        deployMotorConfig.MotorOutput.Inverted = InvertedValue.CounterClockwise_Positive;
        deployMotorConfig.Feedback.SensorToMechanismRatio = IntakeConst.GEAR_RATIO;

        rollerMotorConfig.CurrentLimits.StatorCurrentLimit = 40.0;
        rollerMotorConfig.CurrentLimits.StatorCurrentLimitEnable = true;
        rollerMotorConfig.MotorOutput.NeutralMode = NeutralModeValue.Coast;
        // + output = pulls fuel in
        // - output = pushes fuel out
        rollerMotorConfig.MotorOutput.Inverted = InvertedValue.CounterClockwise_Positive;

        deployMotorConfig.SoftwareLimitSwitch.ForwardSoftLimitEnable = true;
        deployMotorConfig.SoftwareLimitSwitch.ForwardSoftLimitThreshold =
                IntakeConst.MAX_ANGLE.in(Rotations);

        deployMotorConfig.SoftwareLimitSwitch.ReverseSoftLimitEnable = true;
        deployMotorConfig.SoftwareLimitSwitch.ReverseSoftLimitThreshold =
                IntakeConst.MIN_ANGLE.in(Rotations);
    }
}
