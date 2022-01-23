public class BlobManager {
    private Input input;

    public BlobManager() {
        input = new Input();
    }

    public void run() {
        while (true) {
            input.display() ;
            switch (input.get()) {
                case 1: break;
                case 2: break;
                case 3: if (input.stay()) break; else return;  // Variables cleaned on next GC pass?
            }
        }
    }
}