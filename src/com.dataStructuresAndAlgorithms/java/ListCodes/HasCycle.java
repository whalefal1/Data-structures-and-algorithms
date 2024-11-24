package ListCodes;

import java.awt.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class HasCycle {

    //判断一个链表中是否存在环
    public boolean hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head!=null){
            if(!set.add(head)){
                return true;
            }
        }
        return false;
    }

}
