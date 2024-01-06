import java.util.*;

public class Main {

    public static void main(String[] args) {


        Set<Task> tasks = TaskData.getData("all");
        sortAndPrint("All Data", tasks);

        Comparator<Task> sortByPriority = Comparator.comparing(Task::getPriority);
        Set<Task> annsTasks = TaskData.getData("Ann");
        sortAndPrint("Ann's Tasks", annsTasks, sortByPriority);

        sortAndPrint("All tasks intersects Ann's Task", getIntersect(tasks, annsTasks));
        sortAndPrint("All tasks - Ann's Task", getDifference(tasks, annsTasks));



    }

    private static void sortAndPrint(String header, Collection<Task> collection) {
        sortAndPrint(header, collection, null);
    }

    private static void sortAndPrint(String header, Collection<Task> collection,
                                     Comparator<Task> sorter) {

        String lineSeparator = "_".repeat(90);
        System.out.println(lineSeparator);
        System.out.println(header);
        System.out.println(lineSeparator);

        List<Task> list = new ArrayList<>(collection);
        list.sort(sorter);
        list.forEach(System.out::println);
    }

    public static Set<Task> getUnion(Collection<Task> a, Collection<Task> b){

        Set<Task> unionAB = new HashSet<>();
        unionAB.addAll(a);
        unionAB.addAll(b);
        return unionAB;
    }

    public static Set<Task> getIntersect(Collection<Task> a, Collection<Task> b){

        Set<Task> intersectAB = new HashSet<>(a);
        intersectAB.retainAll(b);
        return intersectAB;
    }

    public static Set<Task> getDifference(Collection<Task> a, Collection<Task> b){

        Set<Task> AminusB = new HashSet<>(a);
        AminusB.removeAll(b);
        return AminusB;
    }

}


