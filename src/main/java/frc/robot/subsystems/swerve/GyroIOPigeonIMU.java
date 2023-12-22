package frc.robot.subsystems.swerve;

import com.ctre.phoenix.sensors.PigeonIMU;

import edu.wpi.first.math.geometry.Rotation2d;
import frc.robot.Constants.SwerveDriveConstants;

public class GyroIOPigeonIMU implements GyroIO{
    private PigeonIMU gyro;

    public GyroIOPigeonIMU () {
        gyro = new PigeonIMU(SwerveDriveConstants.PigeonIMUID);
    }
    public void updateInputs (GyroIOInputs inputs) {
        inputs.yawPosition = Rotation2d.fromDegrees(gyro.getYaw());
    }
}
