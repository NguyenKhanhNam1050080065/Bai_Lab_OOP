import java.nio.charset.StandardCharsets;

public abstract class CanBo {
    private String name;
    private String job;
    public CanBo(String name, String job){
        this.name = name;
        this.job = job;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }
    public boolean nameSearch(String subString){
        byte[] fullBytes = name.getBytes(StandardCharsets.UTF_8);
        byte[] subBytes = subString.getBytes(StandardCharsets.UTF_8);
        if (fullBytes.length < subBytes.length || subBytes.length == 0) return false;
        int startScanning = -1;
        for (byte c : fullBytes){
            if (startScanning == -1 && c == subBytes[0]) {
                startScanning = 1; continue;
            }
            if (startScanning > -1){
                if (startScanning == subBytes.length) return true;
                if (c != subBytes[startScanning]) {
                    startScanning = -1; continue;
                }
                startScanning++;
            }
        }
        return true;
    }
}
