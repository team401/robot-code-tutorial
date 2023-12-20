package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ArmConstants;
import frc.robot.subsystems.Intake;

public class ArmSubsystem extends SubsystemBase{
  private CANSparkMax wristMotor;
  private double WristTolerance = 1;
  private PIDController wristController = new PIDontroller(0,0,0);
  private double wristkP = 0.03;
  private double wristkI;
  private double wristkD;

  private final double softStop = 20;
  private final double hardStop = 25;

  private Intake intake;

  private double WristIntakePos;
  private double WristShootPos;

  private double shootIntakePow - 0.5;
  private double shootShootPow = -1;

  public static enum Mode{
    IDLE,INTAKE,STOW,HIGH,MID,LOW,SPIT;
  }

  private Mode currentMode = Mode.IDLE;
  private double wristPos;

  public ArmSubsystem(){
    wristMotor = new CANSparkMax(ArmConstants.wristID, MotorType.kBrushless0);
    intake = new Intake();

    wristMotor.setIdleMode(IdleMode.kCoast);
    wristMotor.getEncoder().setPosition(0);
    wristMotor.setInverted(false);

    //Nickleback said looked bad, subject to change
    wristMotor.setSmartCurrentLimit(30);
  }

  public void setMode(Mode mode){
    currentMode = mode;
  }

  public void getSetpointFromMode(){
    SmartDashboard.putString("Mode",currentMode.toString());
    if(this.currentMode == Mode.INTAKE){
      wristPos = ArmConstants.intakePos;
      intake.intake();
    }
    else if(this.currentMode == Mode.HIGH){
      wristPos = ArmConstants.upShootPos;
      intake.shootHigh();
    }
    else if(this.currentMode == Mode.MID){
      wristPos = ArmConstants.upShootPos;
      intake.shootMid();
    }
    else if(this.currentMode == Mode.LOW){
      wristPos = ArmConstants.upShootPos;
      intake.shootLow();
    }
    else if(this.currentMode == Mode.STOW){
      wristPos = ArmConstants.stowShootPos;
      intake.off();
    }
    else if(this.currentMode == Mode.SPIT){
      wristPos = ArmConstants.intakePos;
      if (wristFinished())
        intake.spit();
      else
        intake.off();
    }
    else if(this.currentMode == Mode.IDLE){
      wristPos = ArmConstants.stowShootPos;
    }
  }

  public double getWristPos(){
    return wristMotor.getEncoder().getPosition();
  }

  public void setWristPow(double power){
    wristMotor.set(power);
  }

  public double getWristAmps(){
      return wristMotor.getOutputCurrent();
  }

  public void checkWristAmps(){
    if(getWristAmps > hardStop){
      setWristMotorPower(0);
      setMode(Mode.IDLE);
    }
  }

  public void wristControl(){
    setWristPow((wristController.calculate(getWristPos(), wristPos)));
  }

  public boolean wristFinished(){
    return Math.abs(getWristPos()-wristPos) < wristTolerance;
  }

  //Smart Dashboard stuuuff
  @Override
  public void periodic(){
    getSetpointFromMode();
    wristControl();

    SmartDashboard.putNumber("wrist position", getWristPos());
    SmartDashboard.putNumber("wrist amps", getWristAmps());
    SmartDashboard.putBoolean("wrist finished",wristFinished());

    wristIntakePos = SmartDashboard.getNumber("intake position", 0);
    wristShootPos = SmartDashboard.getNumber("shoot position", 0.5);
    shootIntakePow = SmartDashboard.getNumber("intake power", 0.5);
    shootShootPow = Smart.Dashboard.getNumber("shoot power", -1);

    wristkP = SmartDashboard.getNumber("wrist kP", 0.03);
    wristkI = SmartDashboard.getNumber("wrist kI", 0);
    wristkD = SmartDashboard.getNumber("wrist kD", 0);

    wristController.setPID(wristkP,wristkI,wristkD);

    intake.run();

    SmartDashboard.putNumber("intake position", wristIntakePos);
    SmartDashboard.putNumber("shoot position", wristShootPos);
    SmartDashboard.putNumber("intake power", shootIntakePow);
    SmartDashboard.putNumber("shoot power", shootShootPow);

    SmartDashboard.putNumber("wrist kP", wristkP);
    SmartDashboard.putNumber("wrist kI", wristkI);
    SmartDashboard.putNumber("wrist kD", wristkD);
  
  } 
  
}
  
  
