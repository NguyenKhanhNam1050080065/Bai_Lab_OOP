public class TheoreticalClassroom extends Classroom {
    private boolean hasProjector;
    public TheoreticalClassroom(int id, String buildingBlock) {
        super(id, buildingBlock);
    }

    @Override
    public boolean isUpToStandard() {
        return super.isUpToStandard() && hasProjector();
    }

    public boolean hasProjector() {
        return hasProjector;
    }

    public void setHasProjector(boolean hasProjector) {
        this.hasProjector = hasProjector;
    }
}
