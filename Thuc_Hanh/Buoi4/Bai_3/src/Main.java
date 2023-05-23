public class Main {
    public static double[] randomGrades(){
        return randomGrades(0.0);
    }
    public static double[] randomGrades(double lowerThreshold){
        double[] re = new double[5];
        for (int i = 0; i < 5; i++){
            re[i] = lowerThreshold + (Math.random() * (10.0 - lowerThreshold));
        }
        return re;
    }
    public static void main(String[] args) {
        HocVien hv = new HocVien();
        hv
                .add(new DiemHocVien("A", 2003, randomGrades(7.0)))
                .add(new DiemHocVien("B", 2003, randomGrades(5.0)))
                .add(new DiemHocVien("C", 2003, randomGrades(3.0)))
                .add(new DiemHocVien("D", 2003, randomGrades(8.0)));
        System.out.println("Diem hoc vien:");
        System.out.println(hv.scores());
        System.out.println("Thong tin hoc vien");
        System.out.println(hv.generalInfos());
    }
}