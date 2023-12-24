
package common;

/**
 *
 * 2-dimensional vector
 * objects are completely state-less
 *
 */
public class V2d implements java.io.Serializable {

    private double x;
    private double y;

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public V2d(final double x,final double y){
        this.x=x;
        this.y=y;
    }

    public V2d sum(V2d v){
        return new V2d(x+v.x,y+v.y);
    }

    public double module(){
        return (double)Math.sqrt(x*x+y*y);
    }

    public V2d getNormalized(){
        double module= this.module();;
        return new V2d(x/module,y/module);
    }

    public V2d mul(final double fact){
        return new V2d(x*fact,y*fact);
    }

    public String toString(){
        return "V2d("+x+","+y+")";
    }
}
