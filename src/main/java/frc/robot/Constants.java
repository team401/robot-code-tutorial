// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.kinematics.SwerveDriveKinematics;
import edu.wpi.first.math.util.Units;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  public static class OperatorConstants {
    public static final int kDriverControllerPort = 0;
  }
  public static class ArmConstants{
    // Unsure of actual motor assignments
    
    public static  int WristID = 5;
    public static  int leftID = 6;
    public static  int rightID = 7;
    public static  int topID = 8;
    //Taken from Nickleback 23
    
    public static final double intakePos = -35;
    public static final double upShootPos = -3;
    public static final double stowShootPos = 0;
    public static final double lowShootVolt = -0.1;
    public static final double midShootVolt = -0.2;
    public static final double highShootVolt = -0.75;
    public static final double intakeVolt = 0.2;
    public static final double spitVolt = 0.5;
    
    public static final double topShootPow = 0.5;
    public static final double topIntakePow = -0.75;
  
  }
  
  public static class DrivetrainConstants {
    public static final int frontLeftId = 1;
    public static final int frontRightId = 2;
    public static final int backLeftId = 3;
    public static final int backRightId = 4;
  }
  public static final class SwerveDriveConstants {

        public static final double trackWidth = Units.inchesToMeters(20.4);
        public static final double wheelBase = Units.inchesToMeters(22.4);

        public static final int frontLeftDriveID = 1;
        public static final int frontRightDriveID = 3;
		    public static final int backRightDriveID = 5;
		    public static final int backLeftDriveID = 7;
		
        public static final int frontLeftRotationMotorID = 2;
        public static final int frontRightRotationMotorID = 4;
        public static final int backRightRotationMotorID = 6;
        public static final int backLeftRotationMotorID = 8;

        public static final int frontLeftRotationEncoderID = 1; 
        public static final int frontRightRotationEncoderID = 2; 
        public static final int backRightRotationEncoderID = 3;
        public static final int backLeftRotationEncoderID = 4; 

        public static final double frontLeftAngleOffset = -2.3930100291016;
        public static final double frontRightAngleOffset = 2.560213934981135; 
        public static final double backRightAngleOffset = 2.389942067525829;
        public static final double backLeftAngleOffset = -0.582912699396544;

		public static final double autoDrivePercent = 0.6;
        public static final double driveWheelGearReduction = 6.12; // placeholder
        public static final double wheelRadiusM = Units.inchesToMeters(2);
    public static final double turnGearReduction = 1.0; // placeholder

        public static final SwerveDriveKinematics kinematics = 
            new SwerveDriveKinematics(
                new Translation2d(trackWidth / 2.0, wheelBase / 2.0),
                new Translation2d(trackWidth / 2.0, -wheelBase / 2.0),
                new Translation2d(-trackWidth / 2.0, wheelBase / 2.0),
                new Translation2d(-trackWidth / 2.0, -wheelBase / 2.0)
    );
  }
}
