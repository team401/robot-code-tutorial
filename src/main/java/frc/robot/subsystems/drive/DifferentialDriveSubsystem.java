// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.drive;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import org.littletonrobotics.junction.Logger;


public class DifferentialDriveSubsystem extends SubsystemBase {
  private final DriveIO io;
  private final DriveIOInputsAutoLogged inputs = new DriveIOInputsAutoLogged();
  private double leftSpeed;
  private double rightSpeed;


  public DifferentialDriveSubsystem(DriveIO io) {
    this.io = io;
    leftSpeed = 0.0;
    rightSpeed = 0.0;
  }
  public void arcadeDrive(double forwardInput, double rotationInput) {
    var speeds = DifferentialDrive.arcadeDriveIK(forwardInput, rotationInput, true);
    leftSpeed = speeds.left;
    rightSpeed = speeds.right;
  }
  public void stop() {
    leftSpeed = 0.0;
    rightSpeed = 0.0;
  }
  @Override
  public void periodic() {
    io.updateInputs(inputs);
    Logger.processInputs("Drive", inputs);
    io.setVoltage(leftSpeed * 12.0, rightSpeed * 12.0);
  }
}
