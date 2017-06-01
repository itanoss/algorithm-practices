
class ResizableStringArray {
    private String[] data = new String[1];
    private int n = 0;
    private int capacity = 1;
    
    public void insert(String s) {
        if(n == capacity) {
            sizeUp();
        }
        data[n++] = s;
    }

    private void sizeUp() {
        this.capacity <<= 1;
        String[] newData = new String[capacity];
        for(int i = 0; i < n; ++i)
            newData[i] = data[i];
        this.data = newData;
    }

    public static void main(String[] args) {
        ResizableStringArray a = new ResizableStringArray();
        a.insert("hello");
        a.insert("world");
        a.insert("i");
        a.insert("am");
        a.insert("a");
        a.insert("boy");
        
        System.out.println(a.n);
        System.out.println(a.capacity);
    }
}
