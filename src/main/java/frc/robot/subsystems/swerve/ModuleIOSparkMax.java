package frc.robot.subsystems.swerve;

import com.ctre.phoenix6.configs.CANcoderConfiguration;
import com.ctre.phoenix6.configs.CANcoderConfigurator;
import com.ctre.phoenix6.hardware.CANcoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class ModuleIOSparkMax implements ModuleIO {
    // motors
    private final CANSparkMax driveMotor;
    private final CANSparkMax turnMotor;

    // encoders
    private final CANcoder turnEncoder;
    private final RelativeEncoder driveEncoder;


    public ModuleIOSparkMax (int driveId, int turnId, int turnEncoderId, double offsetRadians, boolean driveReversed, boolean turnReversed) {
        // init drive motor
        driveMotor = new CANSparkMax(driveId, MotorType.kBrushless);
        driveMotor.setIdleMode(IdleMode.kCoast);
        driveMotor.setInverted(driveReversed);
        driveMotor.setSmartCurrentLimit(70, 80, 1);

        // init turn motor
        turnMotor = new CANSparkMax(turnId, MotorType.kBrushless);
        turnMotor.setIdleMode(IdleMode.kCoast);
        turnMotor.setInverted(turnReversed);
        turnMotor.setSmartCurrentLimit(70, 80, 1);

        // init encoders
        turnEncoder = new CANcoder(turnEncoderId);
        driveEncoder = driveMotor.getEncoder();
    }
}
