import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
    private static Connection con;
    public Connection getDatabseAccess() {
	connectDB();
	createMemberTable();
	createPackagesTable();
	createBillsTable();
	createBillsInstallemtTable();
	createTrainersTable();
	createMemberTrainerTable();
	createMemberPackageTable();
	createEnquiresTable();
	createTrainerSalaryTable();
	return con;
    }
    public static Connection connectDB(){
        //Code for connecting to db
       try{
           Class.forName("org.sqlite.JDBC");
           con = DriverManager.getConnection("jdbc:sqlite:GymDB.db");
           if(con!=null)
               System.out.println("CONNECCTED SUCCESFULLY!!!!");
           else
               System.out.println("ERROR IN CONNECTING");
       }catch(ClassNotFoundException | SQLException e){
           e.printStackTrace();
       } 
         return con;
    }
    
    public void createMemberTable(){
        try{
          String createQuery="CREATE TABLE IF NOT EXISTS member(member_id INTEGER PRIMARY KEY AUTOINCREMENT,"+
                                           "member_first_name VARCHAR,"+
                                           "member_last_name VARCHAR,"+
                                           "member_mob VARCHAR,"+
                                           "member_email VARCHAR,"+
                                           "member_address VARCHAR,"+
                                           "member_dob DATE,"+
                                           "member_bg VARCHAR,"+
                                           "member_gender VARCHAR,"+
                                           "member_height VARCHAR,"+
                                           "member_weight INT,"+
                                           "member_goal VARCHAR,"+
                                           "member_martial_status VARCHAR,"+
                                           "member_medical_issue VARCHAR,"+
                                           "member_referred_by INT"+
                                           "created_by INT,"+
                                           "created_at DATE,"+
                                           "deleted INT,"+
                                           "deleted_by INT,"+
                                           "updated_by INT,"+
                                           "updated_at DATE)"+"";
                                          
        Statement st=this.con.createStatement();
        st.executeUpdate(createQuery);
        System.out.println("Member table created successfully!!");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void createPackagesTable(){
        try{
          String createQuery="CREATE TABLE IF NOT EXISTS packages(package_id INTEGER PRIMARY KEY AUTOINCREMENT,"+
                                           "package_name VARCHAR,"+
                                           "package_duration INT,"+
                                           "package_fees INT"+
                                           "created_by INT,"+
                                           "created_at DATE,"+
                                           "deleted INT,"+
                                           "deleted_by INT,"+
                                           "updated_by INT,"+
                                           "updated_at DATE)"+"";

                                          
        Statement st=this.con.createStatement();
        st.executeUpdate(createQuery);
        System.out.println("Packages table created successfully!!");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void createTrainerSalaryTable(){
        try{
          String createQuery="CREATE TABLE IF NOT EXISTS trainer_salary(trainer_salary_id INTEGER PRIMARY KEY AUTOINCREMENT,"+
                                           "trainer_id INT,"+
                                           "salary_amount INT,"+
                                           "trainer_salary_date DATE"+
                                           "created_by INT,"+
                                           "created_at DATE,"+
                                           "deleted INT,"+
                                           "deleted_by INT,"+
                                           "updated_by INT,"+
                                           "updated_at DATE)"+"";

                                          
        Statement st=this.con.createStatement();
        st.executeUpdate(createQuery);
        System.out.println("Trainer Salary table created successfully!!");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    
    public void createTrainersTable(){
        try{
          String createQuery="CREATE TABLE IF NOT EXISTS packages(trainer_id INTEGER PRIMARY KEY AUTOINCREMENT,"+
        	  						  "trainer_first_name VARCHAR,"+
                                                                  "trainer_last_name VARCHAR,"+
                                                                  "trainer_mob VARCHAR,"+
                                                                  "trainer_email VARCHAR,"+
                                                                  "trainer_address VARCHAR,"+
                                                                  "trainer_dob DATE,"+
                                                                  "trainer_bg VARCHAR,"+
                                                                  "trainer_gender VARCHAR,"+
                                                                  "trainer_height VARCHAR,"+
                                                                  "trainer_weight INT,"+
                                                                  "trainer_martial_status VARCHAR,"+
                                                                  "trainer_medical_issue VARCHAR"+
                                                                  "created_by INT,"+
                                                                  "created_at DATE,"+
                                                                  "deleted INT,"+
                                                                  "deleted_by INT,"+
                                                                  "updated_by INT,"+
                                                                  "updated_at DATE)"+"";
  
        Statement st=this.con.createStatement();
        st.executeUpdate(createQuery);
        System.out.println("Trainers table created successfully!!");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void createBillsTable(){
        try{
          String createQuery="CREATE TABLE IF NOT EXISTS bills(bill_id INTEGER PRIMARY KEY AUTOINCREMENT,"+
                                           "member_id INT,"+
                                           "bill_regarding VARCHAR,"+
                                           "gst_applicable INT,"+
                                           "gst_amount VARCHAR,"+
                                           "bill_total_amount INT,"+
                                           "bill_installment_date DATE,"+
                                           "amount_paid VARCHAR,"+
                                           "bill_date VARCHAR,"+
                                           "received_by INT"+
                                           "created_by INT,"+
                                           "created_at DATE,"+
                                           "deleted INT,"+
                                           "deleted_by INT,"+
                                           "updated_by INT,"+
                                           "updated_at DATE)"+"";

                                          
        Statement st=this.con.createStatement();
        st.executeUpdate(createQuery);
        System.out.println("Bills table created successfully!!");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void createBillsInstallemtTable(){
        try{
          String createQuery="CREATE TABLE IF NOT EXISTS bills_installment(bill_installment_id INTEGER PRIMARY KEY AUTOINCREMENT,"+
                                           "bill_id INT,"+
                                           "bill_installment_no INT,"+
                                           "bill_installment_amount INT,"+
                                           "bill_installment_date DATE"+
                                           "created_by INT,"+
                                           "created_at DATE,"+
                                           "deleted INT,"+
                                           "deleted_by INT,"+
                                           "updated_by INT,"+
                                           "updated_at DATE)"+"";
          
        Statement st=this.con.createStatement();
        st.executeUpdate(createQuery);
        System.out.println("Bills Installment table created successfully!!");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void createMemberPackageTable(){
        try{
          String createQuery="CREATE TABLE IF NOT EXISTS member_package(member_package_ID INTEGER PRIMARY KEY AUTOINCREMENT,"+
                                           "member_id INT,"+
                                           "package_id INT,"+
                                           "package_start_date DATE"+
                                           "package_end_date DATE"+
                                           "created_by INT,"+
                                           "created_at DATE,"+
                                           "deleted INT,"+
                                           "deleted_by INT,"+
                                           "updated_by INT,"+
                                           "updated_at DATE)"+"";

                                          
        Statement st=this.con.createStatement();
        st.executeUpdate(createQuery);
        System.out.println("Member Packages created successfully!!");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void createMemberTrainerTable(){
        try{
          String createQuery="CREATE TABLE IF NOT EXISTS member_trainer(member_trainer_ID INTEGER PRIMARY KEY AUTOINCREMENT,"+
                                           "member_id INT,"+
                                           "trainer_id INT,"+
                                           "member_package_id INT"+
                                           "bill_id INT"+
                                           "created_by INT,"+
                                           "created_at DATE,"+
                                           "deleted INT,"+
                                           "deleted_by INT,"+
                                           "updated_by INT,"+
                                           "updated_at DATE)"+"";
                                           

                                          
        Statement st=this.con.createStatement();
        st.executeUpdate(createQuery);
        System.out.println("Member Trainer created successfully!!");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void createEnquiresTable(){
        try{
          String createQuery="CREATE TABLE IF NOT EXISTS enquires(enquire_ID INTEGER PRIMARY KEY AUTOINCREMENT,"+
                                           "enquire_name VARCHAR,"+
                                           "enquire_email VARCHAR,"+
                                           "enquire_phone VARCHAR"+
                                           "enquire_goal VARCHAR"+
                                           "enquire_date DATE"+
                                           "created_by INT,"+
                                           "created_at DATE,"+
                                           "deleted INT,"+
                                           "deleted_by INT,"+
                                           "updated_by INT,"+
                                           "updated_at DATE)"+"";
                                           

                                          
        Statement st=this.con.createStatement();
        st.executeUpdate(createQuery);
        System.out.println("Enquires created successfully!!");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
