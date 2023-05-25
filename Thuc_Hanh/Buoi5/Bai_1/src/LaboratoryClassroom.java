public class LaboratoryClassroom extends Classroom{
    private String note;
    private double capacity;
    private boolean hasBasin;
    public LaboratoryClassroom(int id, String buildingBlock) {
        super(id, buildingBlock);
        note = "";
    }
    @Override
    public boolean isUpToStandard() {
        return super.isUpToStandard() && hasWashBasin();
    }

    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }

    public double getCapacity() {
        return capacity;
    }

    public boolean hasWashBasin() {
        return hasBasin;
    }

    public String getNote() {
        return note;
    }

    public void setHasWashBasin(boolean hasBasin) {
        this.hasBasin = hasBasin;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
