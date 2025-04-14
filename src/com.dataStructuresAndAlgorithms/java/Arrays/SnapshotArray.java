package Arrays;

import java.util.ArrayList;
import java.util.List;

public class SnapshotArray {

    int length;
    int[] array;
    List<int[]> list = new ArrayList<>();

    public SnapshotArray(int length) {
        this.array = new int[length];
        for (int i = 0; i < length ; i++) {
            array[i] = 0;
        }
        this.length = length;

    }

    public void set(int index, int val) {
        array[index] = val;
    }

    public int snap() {
        list.add(array);
        return list.size()-1;
    }

    public int get(int index, int snap_id) {
        int[] ints = list.get(snap_id);
        return ints[index];
    }
}
