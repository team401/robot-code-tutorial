// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

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
}
