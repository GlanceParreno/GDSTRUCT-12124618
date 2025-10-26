public class SimpleHashtable {
    private SavedPlayer[] hashtable;

    public SimpleHashtable() {
        hashtable = new SavedPlayer[10];
    }

    public int hashKey(String key) {
        return key.length() % hashtable.length;
    }

    public int findKey(String key) {
        int hashedKey = hashKey(key);

        if (isOccupied(hashedKey) && hashtable[hashedKey].getKey().equals(key)) {
            return hashedKey;
        }

        int stoppingIndex = hashedKey;
        hashedKey = (hashedKey + 1) % hashtable.length;

        while (hashedKey != stoppingIndex &&
                isOccupied(hashedKey) &&
                !hashtable[hashedKey].getKey().equals(key)) {
            hashedKey = (hashedKey + 1) % hashtable.length;
        }

        if (isOccupied(hashedKey) && hashtable[hashedKey].getKey().equals(key)) {
            return hashedKey;
        }

        return -1;
    }

    public boolean isOccupied(int hashedKey) {
        return hashtable[hashedKey] != null;
    }

    public void put(String key, Player value) {
        int hashedKey = hashKey(key);

        if (isOccupied(hashedKey)) {
            int stoppingIndex = hashedKey;
            hashedKey = (hashedKey + 1) % hashtable.length;

            while (hashedKey != stoppingIndex && hashtable[hashedKey] != null) {
                hashedKey = (hashedKey + 1) % hashtable.length;
            }
        }

        if (isOccupied(hashedKey)) {
            System.out.println("Cannot put player " + key + ". Hashtable is full.");
        } else {
            hashtable[hashedKey] = new SavedPlayer(key, value);
        }
    }


    public Player get(String key) {
        int hashedKey = findKey(key);
        if (hashedKey == -1) {
            return null;
        }
        return hashtable[hashedKey].getValue();
    }

    public Player remove(String key) {
        int hashedKey = findKey(key);

        if (hashedKey == -1) {
            System.out.println("Key '" + key + "' not found.");
            return null;
        }

        Player removedPlayer = hashtable[hashedKey].getValue();
        System.out.println("Removing player: " + removedPlayer);

        // Remove entry
        hashtable[hashedKey] = null;

        // Rehash remaining entries to prevent broken probing chains
        SavedPlayer[] oldHashtable = hashtable;
        hashtable = new SavedPlayer[oldHashtable.length];

        for (SavedPlayer sp : oldHashtable) {
            if (sp != null) {
                put(sp.getKey(), sp.getValue());
            }
        }

        return removedPlayer;
    }

    public void printHashtable() {
        for (int i = 0; i < hashtable.length; i++) {
            Player player = null;
            if (hashtable[i] != null)
                player = hashtable[i].getValue();

            System.out.println("Element " + i + " = " + player);
        }
    }
}
