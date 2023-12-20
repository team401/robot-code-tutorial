// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.ArcadeDrive;
import frc.robot.subsystems.drive.DriveIOVictorSPX;
import frc.robot.subsystems.drive.DifferentialDriveSubsystem;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;

public class RobotContainer {
  private final DifferentialDriveSubsystem driveSubsystem;

  private final CommandXboxController driverController =
      new CommandXboxController(OperatorConstants.kDriverControllerPort);

  public RobotContainer() {
    driveSubsystem = new DifferentialDriveSubsystem(new DriveIOVictorSPX());
    driveSubsystem.setDefaultCommand(new ArcadeDrive(
      driveSubsystem,
      () -> driverController.getLeftY(),
      () -> driverController.getLeftX()
    ));
  }
}
