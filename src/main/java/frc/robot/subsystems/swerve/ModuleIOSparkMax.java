package frc.robot.subsystems.swerve;

import com.ctre.phoenix6.hardware.CANcoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.util.Units;
import frc.robot.Constants.SwerveDriveConstants;

public class ModuleIOSparkMax implements ModuleIO {
    // motors
    private final CANSparkMax driveMotor;
    private final CANSparkMax turnMotor;

    // encoders
    private final RelativeEncoder turnRelativeEncoder;
    private final CANcoder turnAbsoluteEncoder;
    private final RelativeEncoder driveEncoder;

    private final double encoderOffsetRadians;


    public ModuleIOSparkMax (int index, boolean driveReversed, boolean turnReversed) {
        switch (index) {
            case 0:
                driveMotor = new CANSparkMax(SwerveDriveConstants.frontLeftDriveID, MotorType.kBrushless);
                turnMotor = new CANSparkMax(SwerveDriveConstants.frontLeftRotationMotorID, MotorType.kBrushless);
                turnAbsoluteEncoder = new CANcoder(SwerveDriveConstants.frontLeftRotationEncoderID);
                encoderOffsetRadians = SwerveDriveConstants.frontLeftAngleOffset;
                break;
            case 1:
                driveMotor = new CANSparkMax(SwerveDriveConstants.frontRightDriveID, MotorType.kBrushless);
                turnMotor = new CANSparkMax(SwerveDriveConstants.frontRightRotationMotorID, MotorType.kBrushless);
                turnAbsoluteEncoder = new CANcoder(SwerveDriveConstants.frontRightRotationEncoderID); 
                encoderOffsetRadians = SwerveDriveConstants.frontRightAngleOffset;
                break;
            case 2:
                driveMotor = new CANSparkMax(SwerveDriveConstants.backLeftDriveID, MotorType.kBrushless);
                turnMotor = new CANSparkMax(SwerveDriveConstants.backLeftRotationMotorID, MotorType.kBrushless);
                turnAbsoluteEncoder = new CANcoder(SwerveDriveConstants.backLeftRotationEncoderID);
                encoderOffsetRadians = SwerveDriveConstants.backLeftAngleOffset;
                break;
            case 3:
                driveMotor = new CANSparkMax(SwerveDriveConstants.backRightDriveID, MotorType.kBrushless);
                turnMotor = new CANSparkMax(SwerveDriveConstants.backRightRotationMotorID, MotorType.kBrushless);
                turnAbsoluteEncoder = new CANcoder(SwerveDriveConstants.backRightRotationEncoderID);
                encoderOffsetRadians = SwerveDriveConstants.backRightAngleOffset;
                break;
            default:
                throw new RuntimeException("Invalid module index");
        }

        // init drive motor
        driveMotor.setIdleMode(IdleMode.kCoast);
        driveMotor.setInverted(driveReversed);
        driveMotor.setSmartCurrentLimit(70, 80, 1);

        // init turn motor
        turnMotor.setIdleMode(IdleMode.kCoast);
        turnMotor.setInverted(turnReversed);
        turnMotor.setSmartCurrentLimit(70, 80, 1);

        // init encoders
        turnRelativeEncoder = turnMotor.getEncoder();
        driveEncoder = driveMotor.getEncoder();
    }

    public void updateInputs (ModuleIOInputs inputs) {
        // drive inputs
        inputs.drivePositionRad = Units.rotationsToRadians(driveEncoder.getPosition()) / SwerveDriveConstants.driveWheelGearReduction;
        inputs.driveVelRadiansPerSec = Units.rotationsPerMinuteToRadiansPerSecond(driveEncoder.getVelocity()) / SwerveDriveConstants.driveWheelGearReduction;
        inputs.driveVoltage = driveMotor.getAppliedOutput() * driveMotor.getBusVoltage();
        inputs.driveCurrentAmps = new double[] {driveMotor.getOutputCurrent()};

        // turn inputs
        inputs.turnPosition = Rotation2d.fromRotations(turnRelativeEncoder.getPosition() / SwerveDriveConstants.turnGearReduction);
        inputs.turnAbsolutePosition = Rotation2d.fromRadians(Units.degreesToRadians(turnAbsoluteEncoder.getAbsolutePosition().getValue()) - encoderOffsetRadians);
        inputs.turnVelRadiansPerSec = Units.rotationsPerMinuteToRadiansPerSecond(turnRelativeEncoder.getVelocity()) / SwerveDriveConstants.turnGearReduction;
        inputs.turnVoltage = turnMotor.getAppliedOutput() * turnMotor.getBusVoltage();
        inputs.turnCurrentAmps = new double[] {turnMotor.getOutputCurrent()};
    }
    public void setDriveVoltage(double voltage) {
        driveMotor.setVoltage(voltage);
    }
    public void setTurnVoltage(double voltage) {
        turnMotor.setVoltage(voltage);
    }
    public void setDriveBrakeMode(boolean brake) {
        driveMotor.setIdleMode(brake ? IdleMode.kBrake : IdleMode.kCoast);
    }
    public void setTurnBrakeMode(boolean brake) {
        turnMotor.setIdleMode(brake ? IdleMode.kBrake : IdleMode.kCoast);
    }
}
