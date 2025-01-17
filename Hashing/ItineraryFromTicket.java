package Hashing;

import java.util.HashMap;;

public class ItineraryFromTicket {

    public static String getStart(HashMap<String, String> tickets){
        HashMap<String, String> revMap = new HashMap<>();

        for (String key: tickets.keySet()) {
            revMap.put(tickets.get(key), key);
        }

        for (String key: tickets.keySet()) {
            if (!revMap.containsKey(key)) {
                return key; // starting point
            }
        }

        return null;
    }

    public static void solve(HashMap<String, String> tickets){
        if (tickets == null || tickets.isEmpty()) {
            System.out.println("No tickets provided");
            return;
        }

        String start = getStart(tickets);
        if (start == null) {
            System.out.println("Invalid tickets");
            return;
        }

        StringBuilder sb = new StringBuilder(start);

        while (tickets.containsKey(start)) {
            sb.append(" -> ").append(tickets.get(start));
            start = tickets.get(start);
        }

        System.out.println(sb.toString());
    }
    
    public static void main(String[] args) {
        HashMap<String, String> tickets = new HashMap<>();
        tickets.put("Chennai", "Bengaluru");
        tickets.put("Mumbai", "Delhi");
        tickets.put("Goa", "Chennai");
        tickets.put("Delhi", "Goa");

        solve(tickets);
    }
}