import java.util.*;

public class Main {

    public static void main(String[] args) {


        Set<Task> tasks = TaskData.getData("all");
        sortAndPrint("All Data", tasks);

        Comparator<Task> sortByPriority = Comparator.comparing(Task::getPriority);
        Set<Task> annsTasks = TaskData.getData("Ann");
        sortAndPrint("Ann's Tasks", annsTasks, sortByPriority);

        Set<Task> bobsTasks = TaskData.getData("Bob");
        sortAndPrint("Bob's Tasks", bobsTasks);

//        sortAndPrint("All tasks intersects Ann's Task", getIntersect(tasks, annsTasks));
//        sortAndPrint("All tasks - Ann's Task", getDifference(tasks, annsTasks));

        List<Set<Task>> sets = List.of(annsTasks, bobsTasks, tasks);
        sortAndPrint("Ann's and Bob's Tasks", getUnion(sets));

        sortAndPrint("Ann's - Bob's", getDifference(annsTasks, bobsTasks));



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

    private static Set<Task> getUnion(List<Set<Task>> sets){

        Set<Task> unionAB = new HashSet<>();

        for(Set<Task> a : sets){
            unionAB.addAll(a);
        }
        return unionAB;
    }

    private static Set<Task> getIntersect(Collection<Task> a, Collection<Task> b){

        Set<Task> intersectAB = new HashSet<>(a);
        intersectAB.retainAll(b);
        return intersectAB;
    }

    private static Set<Task> getDifference(Collection<Task> a, Collection<Task> b){

        Set<Task> AminusB = new HashSet<>(a);
        AminusB.removeAll(b);
        return AminusB;
    }

}


