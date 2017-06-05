package org.learn.fluent.api;

public class MacBook extends DigitalDevice<MacBook>
{
    // Seems like all are optional parameters, since none of them are final
    // and not enforced via the constructor.
    private int    _ramInGB ;
    private String _cpuSpec ;
    private String _gpuSpec ;
    private int    _diskSpaceInGB;

    public MacBook()
    {
        ofType(TYPE.COMPUTER);
    }

    public MacBook withRAM(int ramInGB)
    {
        _ramInGB = ramInGB;
        return this;
    }

    public MacBook withCPU(String cpuSpec)
    {
        _cpuSpec = cpuSpec;
        return this;
    }

    public MacBook withGPU(String gpuSpec)
    {
        _gpuSpec = gpuSpec;
        return this;
    }

    public MacBook withStorage(int diskSpaceInGB)
    {
        _diskSpaceInGB = diskSpaceInGB;
        return this;
    }

    public int getRamInGB() {
        return _ramInGB;
    }

    public String getCpuSpec() {
        return _cpuSpec;
    }

    public String getGpuSpec() {
        return _gpuSpec;
    }

    public int getDiskSpaceInGB() {
        return _diskSpaceInGB;
    }

    @Override
    public String toString() {
        return "MacBook{" +
               "_type=" + getType() +
               ", _mfgDate=" + getManufacturingDate() +
               ", _ramInGB=" + _ramInGB +
               ", _cpuSpec='" + _cpuSpec + '\'' +
               ", _gpuSpec='" + _gpuSpec + '\'' +
               ", _diskSpaceInGB=" + _diskSpaceInGB +
               ", _display=" + getDisplaySpec() +
               '}';
    }
}
