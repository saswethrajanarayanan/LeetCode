class BrowserHistory {
    Stack<String> forwards;
    Stack<String> backwards;
    String current;
    public BrowserHistory(String homepage) {
        this.forwards = new Stack<>();
        this.backwards = new Stack<>();
        this.current = homepage;
    }
    
    public void visit(String url) {
        backwards.push(current);
        current = url;
        forwards = new Stack<>();
    }
    
    public String back(int steps) {
        if(steps > backwards.size()) {
            steps = backwards.size();
        }
        while(!backwards.isEmpty() && steps > 0) {
            forwards.push(current);
            current = backwards.pop();
            steps--;
        }
        return current;
    }
    
    public String forward(int steps) {
        if(steps > forwards.size()) {
            steps = forwards.size();
        }
        while(!forwards.isEmpty() && steps > 0) {
            backwards.push(current);
            current = forwards.pop();
            steps--;
        }
        return current;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */


