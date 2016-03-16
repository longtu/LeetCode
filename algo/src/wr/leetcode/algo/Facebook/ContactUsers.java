package wr.leetcode.algo.Facebook;

import java.util.*;

public class ContactUsers {


    /**
     * Method1: DFS + MAP
     */
    public List<List<String>> findUsersNaive (String[][][] inputs) {
        Map<String, Set<String>> email2Users = new HashMap<>();
        Map<String, Set<String>> user2Emails = new HashMap<>();
        for (String[][] row : inputs) {
            String user = row[0][0];
            String[] emails = row[1];

            Set<String> myEmails = new HashSet<>();
            for (String e : emails) {
                Set<String> eUsers = email2Users.getOrDefault(e, new HashSet<>());
                eUsers.add(user);
                email2Users.put(e, eUsers);
                myEmails.add(e);
            }
            user2Emails.put(user, myEmails);
        }

        Map<String, Integer> groups = new HashMap<>();
        int groupId = 0;
        for (String user : user2Emails.keySet()) {
            if(!groups.containsKey(user)) {
                dfs(user, groups, user2Emails, email2Users, ++groupId);
            }
        }

        ArrayList<List<String>> ret = new ArrayList<>();
        for (int i = 0; i < groupId; ++i) {
            ret.add(new LinkedList<>());
        }

        for (String user : groups.keySet()) {
            ret.get(groups.get(user)-1).add(user);
        }
        return ret;
    }

    public static void dfs(String start, Map<String, Integer> groups, Map<String,Set<String>> user2Emails,
                    Map<String, Set<String>> email2Users, int groupId ) {
        if (groups.containsKey(start)) {
            return;
        }
        groups.put(start, groupId);
        for(String email : user2Emails.get(start)) {
            for (String alias : email2Users.get(email)) {
                dfs(alias, groups, user2Emails, email2Users, groupId);
            }
        }
    }

    /**
     * Union Find approach
     */

    public List<List<String>> findUsers (String[][][] inputs) {
        Map<String, Integer> emailUsers = new HashMap<>();
        UnionFind uf = new UnionFind(inputs.length);

        int i = 0;
        for (String[][] input : inputs) {
            for (String email: input[1]) {
                if( !emailUsers.containsKey(email)) {
                    emailUsers.put(email, i);
                } else {
                    uf.merge(emailUsers.get(email),i);
                }
            }
            i++;
        }

        Map<Integer, List<String>> groups = new HashMap<>();
        for (int j = 0; j < inputs.length; ++j) {
            int id = uf.groupOf(j);
            List<String> names = groups.getOrDefault(id, new LinkedList<>());
            names.add(inputs[j][0][0]);
            groups.put(id, names);
        }
        return new ArrayList<>(groups.values());
    }

    class UnionFind {

        int[] groupId;

        public UnionFind(int n) {
            groupId = new int[n];
            for (int i = 0; i < n; ++i) {
                groupId[i] = i;
            }
        }

        public void merge(int l, int r) {
            int lId = groupOf(l);
            int rId = groupOf(r);
            groupId[rId] = lId;
        }

        public int groupOf( int i) {
            int ret = i;
            while( ret != groupId[ret]) {
                ret = groupId[ret];
            }
            while( groupId[i] != ret) {
                int next = groupId[i];
                groupId[i] = ret;
                i = next;
            }
            return ret;
        }
    }


    public static void main(String[] args) {
        String[][][] inputs = {
                {{"JohnS"}, {"john@gmail.com"}},
                {{"Mary"}, {"mary@gmail.com"}},
                {{"John"}, {"john@yahoo.com"}},
                {{"John"}, {"john@gmail.com", "john@yahoo.com", "john@hotmail.com"}},
                {{"Bob"}, {"bob@gmail.com"}}
        };
        List<List<String>> ret = new ContactUsers().findUsers(inputs);
        System.out.println(ret);

    }
}
