public class Point3d extends Point2d {
    private double zCoord;
    public Point3d(double x, double y, double z){
        xCoord = x;
        yCoord = y;
        zCoord = z;
    }
    public Point3d(){
        this(0,0,0);
    }
    public double getZ(){
        return zCoord;
    }
    public void setZ(double zValue){
        zCoord = zValue;
    }
    public boolean equals(Point3d a){
        if(this.xCoord == a.xCoord && this.yCoord == a.yCoord && this.zCoord == a.zCoord)
            return true;
        else return false;
    }
    public double distanceTo(Point3d a){
        return Math.sqrt((Math.pow((a.xCoord - this.xCoord),2))+(Math.pow((a.yCoord - this.yCoord),2))+(Math.pow((a.zCoord - this.zCoord),2)));
    }
}