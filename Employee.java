abstract class Employee {
    //fields
    private float bill;
    private String currenteventId;
    private  String employeeId ;
    private  String username ;
    private String password;
    private  String position ;
    private  boolean status = false;
    protected boolean isServieBooked= false;


    // constructor
    Employee(String employeeId, String username, String password, String position){
        this.employeeId = employeeId;
        setPassword(password);
        setUsername(username);
        this.position = position;
    }


    // methods

    public void sendbill(Event event, float bill) {
        // if employee loged in, then they can start working
        // need to add condition when Finance manager class is created
        if (getLoginStatus() == true){  // && position is not finance manager object
            setBill(bill);
            setCurrentEventId(event);
            System.out.println("event: " + this.currenteventId);
            System.out.println("bill: " + this.bill);

        }else{ // have not loged in, can not do anything
            System.out.println("you have not loged in yet! please login frist"); 
        }   
    }


    // employee login
    public  void logIn(String username, String password) {
        // account validation
        if (username == getUsername() && password == getPassword()){          
            setLoginStatus(true);
            System.out.println("log in successfully");        
        }
        else{
            System.out.println("log in unsuccessfully"); 
        }      
    }

    // logout
    public void logOut(){
        // validation the login status
        if (getLoginStatus() == true){           
            setLoginStatus(false);
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

    public boolean getLoginStatus(){
        return this.status;
    }

    private void setLoginStatus(boolean status){
        this.status = status;
    }

    public boolean isServieBooked(){
        return this.isServieBooked;
    }


}
