// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Constants.DrivetrainConstants;


public class DifferentialDriveSubsystem extends SubsystemBase {
  // motors
  private final WPI_VictorSPX frontLeft;
  private final WPI_VictorSPX frontRight;
  private final WPI_VictorSPX backLeft;
  private final WPI_VictorSPX backRight;

  private final MotorControllerGroup leftDrive;
  private final MotorControllerGroup rightDrive;

  private final DifferentialDrive drive;

  private double forward;
  private double rotation;

  public DifferentialDriveSubsystem() {
    frontLeft = new WPI_VictorSPX(DrivetrainConstants.frontLeftId);
    frontRight = new WPI_VictorSPX(DrivetrainConstants.frontRightId);
    backLeft = new WPI_VictorSPX(DrivetrainConstants.backLeftId);
    backRight = new WPI_VictorSPX(DrivetrainConstants.backRightId);
    
    leftDrive = new MotorControllerGroup(frontLeft, backLeft);
    rightDrive = new MotorControllerGroup(frontRight, backRight);

    drive = new DifferentialDrive(leftDrive, rightDrive);

    forward = 0;
    rotation = 0;
  }
  public void arcadeDrive(double forwardInput, double rotationInput) {
    forward = forwardInput;
    rotation = rotationInput;
    drive.arcadeDrive(forwardInput, rotationInput);
  }
  @Override
  public void periodic() {
    SmartDashboard.putNumber("forward output", forward);
    SmartDashboard.putNumber("Rotation output", rotation);
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
