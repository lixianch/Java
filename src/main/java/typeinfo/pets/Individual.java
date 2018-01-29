package typeinfo.pets;

/**
 * Created by lixianch on 2016/12/1.
 */
public class Individual implements Comparable<Individual> {
    private static long counter;
    private final long id = counter++;
    private String name;
    public Individual(){}
    public Individual(String name){
        this.name = name;
    }
    public String toString(){
        return getClass().getName()+(name == null ? "" : name);
    }

    public long id(){
        return id;
    }

    @Override
    public int hashCode() {
        int result = 17;
        if(name != null)
            result = 37 * result + name.hashCode();
        result = 37 * result + (int)id;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Individual && ((Individual)obj).id() == id;
    }

    @Override
    public int compareTo(Individual o) {
        String first = getClass().getSimpleName();
        String firstarg = o.getClass().getSimpleName();
        int firstCompare = first.compareTo(firstarg);
        if(firstCompare != 0)
            return firstCompare;
        int secondCompare = name.compareTo(o.name);
        return secondCompare;
    }
}
