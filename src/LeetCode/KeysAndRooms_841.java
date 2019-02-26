package LeetCode;
import java.util.*;

/**
 * There are N rooms and you start in room 0.  Each room has a distinct number in 0, 1, 2, ..., N-1, and each room may have some keys to access the next room.
 * Formally, each room i has a list of keys rooms[i], and each key rooms[i][j] is an integer in [0, 1, ..., N-1] where N = rooms.length.
 * A key rooms[i][j] = v opens the room with number v. Initially, all the rooms start locked (except for room 0). You can walk back and forth between rooms freely.
 * Return true if and only if you can enter every room.
 *
 * Example 1:
 * Input: [[1],[2],[3],[]]
 * Output: true
 * Explanation:
 * We start in room 0, and pick up key 1.
 * We then go to room 1, and pick up key 2.
 * We then go to room 2, and pick up key 3.
 * We then go to room 3.  Since we were able to go to every room, we return true.
 *
 * Example 2:
 * Input: [[1,3],[3,0,1],[2],[0]]
 * Output: false
 * Explanation: We can't enter the room with number 2.
 */
public class KeysAndRooms_841 {
    //DFS
    class Solution {
        public boolean canVisitAllRooms(List<List<Integer>> rooms) {
            if (rooms == null)
                return false;
            else if (rooms.size() == 1)
                return true;
            int N = rooms.size();
            boolean[] hasVisited = new boolean[N];
            dfs(rooms,0,hasVisited);
            for (boolean e : hasVisited) {
                if (e == false)
                    return false;
            }
            return true;
        }

        private void dfs(List<List<Integer>> rooms,int i, boolean[] hasVisited){
            if (hasVisited[i] == true)  return;
            hasVisited[i] = true;
            for (int room : rooms.get(i)) {
                dfs(rooms,room,hasVisited);
            }
        }
    }

    //DFS Stack
    class Solution_Stack {
        public boolean canVisitAllRooms(List<List<Integer>> rooms) {
            if (rooms == null)
                return false;
            else if (rooms.size() == 1)
                return true;
            Stack<Integer> dfs = new Stack<>();
            dfs.add(0);
            HashSet<Integer> visited = new HashSet<>();//记录去过的房间号，不重复
            visited.add(0);
            while (!dfs.isEmpty()){
                int room = dfs.pop();
                for (int key : rooms.get(room)) {
                    if (!visited.contains(key)){
                        dfs.add(key);
                        visited.add(key);
                        if (visited.size() == rooms.size())
                            return true;
                    }
                }
            }
            return visited.size() == rooms.size();
        }
    }

}
