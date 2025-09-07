public class RiderManager {
    private static RiderManager riderMgrInstance;
    
    // constructor
    private RiderManager() {}
    // Lazy way of creating single object
    public static RiderManager getRiderMgr() {
        // object of this class
        if (riderMgrInstance == null) {
            synchronized (RiderManager.class) {
                if (riderMgrInstance == null) {
                    riderMgrInstance = new RiderManager();
                }
            }
        }
        return riderMgrInstance;
    }

    void addRider(String name,Rider rider){

    }

    Rider getRider(String name){

    }
}