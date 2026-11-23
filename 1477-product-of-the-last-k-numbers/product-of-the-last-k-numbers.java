class ProductOfNumbers {
    List<Integer> prd;
    int curZero;
    int cnt;
    public ProductOfNumbers() {
        prd = new ArrayList<>();
        curZero = -1;
        cnt = 0;
    }
    
    public void add(int num) {
        cnt++;
        if (num == 0) {
            prd.add(1);
            curZero = cnt;
        } else {
            if(prd.size() == 0) prd.add(num);
            else prd.add(prd.get(prd.size() - 1) * num);
        }
    }
    
    public int getProduct(int k) {
        int n = prd.size();
        if(n - k < curZero) return 0;
        else if(n - k - 1 < 0) return prd.get(n - 1);
        else return prd.get(n - 1) / prd.get(n - k - 1);
    }
}
