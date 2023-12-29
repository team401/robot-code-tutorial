package frc.robot.subsystems.swerve;

public class Module {
    private final ModuleIO io;
    private final int index;
    private final ModuleIOInputsAutoLogged inputs = new ModuleIOInputsAutoLogged();

    public Module (ModuleIO io, int index) {
        this.io = io;
        this.index = index;
    }
}
