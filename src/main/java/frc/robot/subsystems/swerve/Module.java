package frc.robot.subsystems.swerve;

import org.littletonrobotics.junction.Logger;

public class Module {
    private final ModuleIO io;
    private final int index;
    private final ModuleIOInputsAutoLogged inputs = new ModuleIOInputsAutoLogged();

    public Module (ModuleIO io, int index) {
        this.io = io;
        this.index = index;
    }

    public void periodic () {
        io.updateInputs(inputs);
        Logger.processInputs("Drive/Modules/" + Integer.toString(index), inputs);
    }
}
