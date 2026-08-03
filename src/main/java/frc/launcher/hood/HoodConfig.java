package frc.launcher.hood;

import static edu.wpi.first.units.Units.Rotations;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.signals.InvertedValue;
import com.ctre.phoenix6.signals.NeutralModeValue;

public class HoodConfig {
    public static final TalonFXConfiguration motorConfig = new TalonFXConfiguration();

    static {
        motorConfig.SoftwareLimitSwitch.ForwardSoftLimitEnable = true;
        motorConfig.SoftwareLimitSwitch.ForwardSoftLimitThreshold =
                HoodConst.MAX_ANGLE.in(Rotations);

        motorConfig.SoftwareLimitSwitch.ReverseSoftLimitEnable = true;
        motorConfig.SoftwareLimitSwitch.ReverseSoftLimitThreshold =
                HoodConst.MIN_ANGLE.in(Rotations);

        motorConfig.CurrentLimits.StatorCurrentLimit = 40.0;
        motorConfig.CurrentLimits.StatorCurrentLimitEnable = true;
        motorConfig.MotorOutput.NeutralMode = NeutralModeValue.Brake;

        // + output = towards max angle
        // - output = towards min angle

        motorConfig.MotorOutput.Inverted = InvertedValue.CounterClockwise_Positive;
        motorConfig.Feedback.SensorToMechanismRatio = HoodConst.GEAR_RATIO;
    }
}
