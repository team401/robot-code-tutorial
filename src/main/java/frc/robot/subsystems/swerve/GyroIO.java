package frc.robot.subsystems.swerve;

import org.littletonrobotics.junction.AutoLog;

import edu.wpi.first.math.geometry.Rotation2d;

public interface GyroIO {
    @AutoLog
    public static class GyroIOInputs {
        public Rotation2d yawPosition = new Rotation2d();
        public double yawVelRadiansPerSec = 0.0;
        public boolean connected = false;
    }

    public default void updateInputs(GyroIOInputs inputs) {}
}
