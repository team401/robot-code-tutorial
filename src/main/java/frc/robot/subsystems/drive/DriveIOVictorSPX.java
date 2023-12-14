package frc.robot.subsystems.drive;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import frc.robot.Constants.DrivetrainConstants;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;

public class DriveIOVictorSPX implements DriveIO {
    private WPI_VictorSPX frontLeft = new WPI_VictorSPX(DrivetrainConstants.frontLeftId);
    private WPI_VictorSPX frontRight = new WPI_VictorSPX(DrivetrainConstants.frontRightId);
    private WPI_VictorSPX backLeft = new WPI_VictorSPX(DrivetrainConstants.backLeftId);
    private WPI_VictorSPX backRight = new WPI_VictorSPX(DrivetrainConstants.backRightId);

    private MotorControllerGroup leftMotors = new MotorControllerGroup(frontLeft, backLeft);
    private MotorControllerGroup rightMotors = new MotorControllerGroup(frontRight, backRight);

    public DriveIOVictorSPX () {}

    public void setVoltage(double leftAppliedVolts, double rightAppliedVolts) {
        leftMotors.setVoltage(leftAppliedVolts);
        rightMotors.setVoltage(rightAppliedVolts);
    }

    public void updateInputs(DriveIOInputs inputs) {
        inputs.leftSpeed = leftMotors.get();
        inputs.rightSpeed = rightMotors.get();
    }
}