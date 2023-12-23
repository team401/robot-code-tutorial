package frc.robot.subsystems.swerve;

import com.ctre.phoenix.sensors.PigeonIMU;

import edu.wpi.first.math.geometry.Rotation2d;
import frc.robot.Constants.SwerveDriveConstants;

public class GyroIOPigeonIMU implements GyroIO{
    private PigeonIMU gyro;

    private double degYawOffset = 0;
    private double degPitchOffset = 0;
     private double degRollOffset = 0;

    public GyroIOPigeonIMU () {
        gyro = new PigeonIMU(SwerveDriveConstants.PigeonIMUID);

        degYawOffset = gyro.getYaw();
        degRollOffset = gyro.getRoll();
        degPitchOffset = gyro.getPitch();
    }
    public void updateInputs (GyroIOInputs inputs) {
        inputs.yawPosition = Rotation2d.fromDegrees(gyro.getYaw() - degYawOffset);
        inputs.pitchPosition = Rotation2d.fromDegrees(gyro.getPitch() - degPitchOffset);
        inputs.rollPosition = Rotation2d.fromDegrees(gyro.getRoll() - degRollOffset);
    }
}
