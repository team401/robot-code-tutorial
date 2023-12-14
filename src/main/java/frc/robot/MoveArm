package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ArmSubsystem;
import frc.robot.subsystems.ArmSubsystem.Mode;

public class MoveArm extends Command {
  private ArmSubsystem arm;
  private Mode mode;

  public MoveArm(ArmSubsystem arm, Mode mode){
    this.arm = arm;
    this.mode = mode;
  }

  @Override
  public void initialize(){
    arm.setMode(mode);
  }

  @Override
  public void end(){
    arm.setMode(Mode.STOW);
  }
}
    
    
  
