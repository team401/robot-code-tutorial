package frc.robot.subsystems;

import org.littletonrobotics.junction.AutoLog;

public interface DriveIO {
    @AutoLog
    public static class DriveIOInputs {
        public double leftSpeed = 0.0;
    
        public double rightSpeed = 0.0;
      }
    public default void setVoltage(double leftVolts, double rightVolts) {}

    public default void updateInputs(DriveIOInputs inputs) {}
}
