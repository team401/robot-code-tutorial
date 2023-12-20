package frc.robot.subsystems.drive;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj.simulation.DifferentialDrivetrainSim;
import edu.wpi.first.wpilibj.simulation.DifferentialDrivetrainSim.KitbotGearing;
import edu.wpi.first.wpilibj.simulation.DifferentialDrivetrainSim.KitbotMotor;
import edu.wpi.first.wpilibj.simulation.DifferentialDrivetrainSim.KitbotWheelSize;
import frc.robot.subsystems.drive.DriveIO.DriveIOInputs;

public class DriveIOSIm {
    private DifferentialDrivetrainSim driveSim = DifferentialDrivetrainSim.createKitbotSim(KitbotMotor.kDualCIMPerSide, KitbotGearing.k10p71, KitbotWheelSize.kSixInch, null);
    private double leftAppliedVolts = 0.0;
    private double rightAppliedVolts = 0.0;

    public void setVoltage(double leftVolts, double rightVolts) {
        leftAppliedVolts = MathUtil.clamp(leftVolts, -12.0, 12.0);
        rightAppliedVolts = MathUtil.clamp(rightVolts, -12.0, 12.0);
        driveSim.setInputs(leftAppliedVolts, rightAppliedVolts);
    }
    public void uodateInputs(DriveIOInputs inputs) {
        driveSim.update(0.02);
        inputs.leftSpeed = leftAppliedVolts / 12.0;
        inputs.rightSpeed = rightAppliedVolts / 12.0;
    }
}
