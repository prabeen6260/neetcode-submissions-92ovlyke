class Solution {
    public String predictPartyVictory(String senate) {
        // We use a Queue to simulate the round-robin voting process 🗳️
        Deque<Character> q = new ArrayDeque<>();
        int r_count = 0;
        int d_count = 0;

        // Initial setup: Count total senators and fill the queue
        for (char c : senate.toCharArray()) {
            if (c == 'R') {
                r_count++;
            } else {
                d_count++;
            }
            q.offer(c);
        }

        // Tracks "floating" bans that haven't been applied to a senator yet
        int r_ban = 0;
        int d_ban = 0;

        // The process continues as long as both parties have active members
        while (r_count > 0 && d_count > 0) {
            char c = q.poll();

            if (c == 'R') {
                if (r_ban > 0) {
                    // This Radiant senator was banned by a previous Dire senator 🚫
                    r_ban--;
                    r_count--;
                } else {
                    // This senator is free to vote and bans a Dire senator ⚔️
                    d_ban++;
                    q.offer('R'); // Moves to the back of the line for the next round
                }
            } else { // Current senator is 'D'
                if (d_ban > 0) {
                    // This Dire senator was banned by a previous Radiant senator 🚫
                    d_ban--;
                    d_count--;
                } else {
                    // This senator is free to vote and bans a Radiant senator ⚔️
                    r_ban++;
                    q.offer('D'); // Moves to the back of the line
                }
            }
        }

        // Once one count hits zero, the other party is the winner 🏆
        return r_count > 0 ? "Radiant" : "Dire";
    }
}