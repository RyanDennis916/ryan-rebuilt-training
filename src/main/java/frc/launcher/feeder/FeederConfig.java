package frc.launcher.feeder;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.signals.InvertedValue;
import com.ctre.phoenix6.signals.NeutralModeValue;

public class FeederConfig {
    public static final TalonFXConfiguration motorConfig = new TalonFXConfiguration();

    public static final double SPEED = 0.5;

    static {
        motorConfig.CurrentLimits.StatorCurrentLimit = 80.0;
        motorConfig.MotorOutput.NeutralMode = NeutralModeValue.Coast;
        // positive = pulls up
        motorConfig.MotorOutput.Inverted = InvertedValue.Clockwise_Positive;
    }
}
