package exceptions;

/**
 * Created by lixianch on 2016/11/22.
 */
public class Switch {
    private boolean state = false;
    public boolean read(){
        return state;
    }
    public void on(){
        this.state = true;
        System.out.println(this);
    }
    public void off(){
        this.state = false;
        System.out.println(this);
    }
    public String toString(){
        return state ? "On" : "Off";
    }
}
