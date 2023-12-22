package frc.robot.subsystems.swerve;

import org.littletonrobotics.junction.AutoLog;

import edu.wpi.first.math.geometry.Rotation2d;

public interface ModuleIO {
    @AutoLog
    public static class ModuleIOInputs {
        // rotation inputs
        public double turnVoltage = 0.0;
        public Rotation2d turnAbsolutePosition = new Rotation2d();
        public Rotation2d turnPosition = new Rotation2d();
        public double turnVelRadiansPerSec = 0.0;
        public double[] turnCurrentAmps = new double[] {};

        // drive inputs
        public double driveVoltage = 0.0;
        public double driveVelRadiansPerSec = 0.0;
        public double drivePositionRad = 0.0;
        public double[] driveCurrentAmps = new double[] {};
    }
    public default void updateInputs(ModuleIOInputs inputs) {}
    public default void setDriveVoltage(double volts) {}
    public default void setTurnVoltage(double volts) {}
    public default void setDriveBrakeMode(boolean braked) {}
    public default void setTurnBrakeMode(boolean braked) {}
}
