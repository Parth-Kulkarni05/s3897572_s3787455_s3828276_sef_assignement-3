abstract class Employee {
    //fields
    private float bill;
    private String currenteventId;
    private String employeeId ;
    private String username ;
    private String password;
    private String position ;
    private boolean status = false;


    // constructor
    Employee(String employeeId, String username, String password, String position){
        this.employeeId = employeeId;
        setPassword(password);
        setUsername(username);
        this.position = position;
    }


    // methods

    public void sendbill(Event event, float bill) {
        setBill(bill);
        setCurrentEventId(event);
        System.out.println("event: " + this.currenteventId);
        System.out.println("bill: " + this.bill);
    }


    // employee login
    public void logIn(String username, String password) {
        // account validation
        if (username == this.username && password == this.password){          
            this.status = true;
            System.out.println("log in successfully");        
        }
        else{
            System.out.println("log in unsuccessfully"); 
        }      
    }

    // logout
    public void logOut(){
        // validation the login status
        if (this.status == true){           
            this.status = false;
            System.out.println("log out successfully");
        }
        else{ System.out.println("have not log in yet");} 
    }

    

    // geter, setter
    public String getPosition(){
        return this.position;
    }

    public String getEmployeeId(){
        return this.employeeId;
    }
    public String getPassword(){
        return this.password;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public String getUsername(){
        return this.username;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public void setBill(float bill){
        this.bill = bill;
    }
    public float getBill(){
        return this.bill;
    }

    public void setCurrentEventId(Event event){
        this.currenteventId = event.getEventId();
    }

    public String getCurrentEventId(){
        return this.currenteventId ;
    }

   

}
