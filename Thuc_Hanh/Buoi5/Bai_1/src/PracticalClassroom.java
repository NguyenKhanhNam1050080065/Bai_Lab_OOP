public class PracticalClassroom extends Classroom{
    private int computerCount;
    public PracticalClassroom(int id, String buildingBlock) {
        super(id, buildingBlock);
    }
    @Override
    public boolean isUpToStandard() {
        return super.isUpToStandard() && (getArea() / getComputerCount() > 1.5);
    }

    public int getComputerCount() {
        return computerCount;
    }

    public void setComputerCount(int computerCount) {
        this.computerCount = computerCount;
    }
}
