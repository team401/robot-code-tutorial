package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import frc.robot.Constants.ArmConstants;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Intake {
  private CANSparkMax leftMotor;
  private CANSparkMax rightMotor;
  private CANSparkMax topMotor;
  private double intakePow;
  private final double CURRENT_LIMIT = 25;
  private double topIntakePow;

  public Intake(){
    leftMotor = new CANSparkMax(ArmConstants.leftID, MotorType.kBrushless0);
    rightMotor = new CANSparkMax(ArmConstants.rightID, MotorType.kBrushless0);
    topMotor = new CANSparkMax(ArmConstants.topID, MotorType.kBrushless0);
    
    leftMotor.follow(rightMotor, true);
    leftMotor.setSmartCurrentLimit(80);
    rightMotor.setSmartCurrentLimit(80);
    topMotor.setSmartCurrentLimit(10);

    rightMotor.setIdleMode(IdleMode.kCoast);
    leftMotor.setIdleMode(IdleMode.kCoast);
    topMotor.setIdleMode(IdleMode.kCoast);
  }

  public void intake(){
    intakePow = ArmConstants.intakeVolt;
    topIntakePow = ArmConstants.topIntakePow;
  }
  
  public void shootLow(){
    intakePow = ArmConstants.lowShootVolt;
    topIntakePow = ArmConstants.topShootPow;
  }
  
  public void shootMid(){
    intakePow = ArmConstants.midShootVolt;
    topIntakePow = ArmConstants.topShootPow;
  }
  
  public void shootHigh(){
    intakePow = ArmConstants.highShootVolt;
    topIntakePow = ArmConstants.topShootPow;
  }
  
  public void spit(){
    //Why negative? From Nickleback 23
    intakePow = -ArmConstants.topShootPower;
    topIntakePow = ArmConstants.topShootPower;
  }

  public void off(){
    intakePow = 0;
    topIntakePow = 0;
  }

  public void setIntakePow(double pow){
    rightMotor.set(-pow);
    topMotor.set(topIntakePow);
  }

  public double getIntakeAmps(){
    return rightMotor.getOutputCurrent();
  }

  public void checkIntakeAmps(){
    if (getIntakeMotorAmps() > CURRENT_LIMIT)
      setIntakePow(0);
  }

  public void run(){
    setIntakePow(intakePow);
    checkIntakeAmps();
  }
}

