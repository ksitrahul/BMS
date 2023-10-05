 import java.util.*;  
import java.sql.*;  
public class cust_formDAO {

    public static Connection getConnection(){  
        Connection con=null;  
        try{  
            Class.forName("com.mysql.jdbc.Driver");  
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bms","root","root");  
        }catch(Exception c){System.out.println(c);}                                                                                    
        return con;  
    }  
    public static int save(cust_form c){  
        int status=0;  
        try{  
            Connection con=cust_formDAO.getConnection();  
            PreparedStatement ps=con.prepareStatement(  
                         "insert into cust_form  values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)");  
            ps.setString(1,c.getAccount_type());  
            ps.setString(2,c.getFirst_name()); 
            ps.setString(3,c.getLast_name()); 
            ps.setString(4,c.getAddress());
            ps.setString(5,c.getCity());
            ps.setString(6,c.getState());
            ps.setString(7,c.getPincode());
            ps.setString(8,c.getPhone_no());
            ps.setString(9,c.getAlt_no());
            ps.setString(10,c.getGender());
            ps.setString(11,c.getDob());
            ps.setString(12,c.getMarital_status());
            ps.setDouble(13,c.getAccount_no());
            ps.setString(14,c.getCust_id());
               
              
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return status;  
    }  
  public static int update( cust_form c){  
         int status=0;  
        try{  
            Connection con=cust_formDAO.getConnection();  
            PreparedStatement ps=con.prepareStatement( "update cust_form set (?,?,?,?,?,?,?,?,?,?,?,?,?,?)");       
         ps.setString(1,c.getAccount_type());  
            ps.setString(2,c.getFirst_name()); 
            ps.setString(3,c.getLast_name()); 
            ps.setString(4,c.getAddress());
            ps.setString(5,c.getCity());
            ps.setString(6,c.getState());
            ps.setString(7,c.getPincode());
            ps.setString(8,c.getPhone_no());
            ps.setString(9,c.getAlt_no());
            ps.setString(10,c.getGender());
            ps.setString(11,c.getDob());
            ps.setString(12,c.getMarital_status());
            ps.setDouble(13,c.getAccount_no());
            ps.setString(14,c.getCust_id());
              
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return status;  
    }  
    public static int delete(Double account_no){  
        
        int status=0;  
        try{  
            Connection con=cust_formDAO.getConnection();  
            PreparedStatement ps=con.prepareStatement("delete from cust_form where account_no='"+account_no+"'");  
           //ps.setString( 1,account_no);
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception c){c.printStackTrace();}  
          
        return status;  
    }  
    public static cust_form getcustomerById(Double account_no){  
        cust_form c=new cust_form();  
          
        try{  
            Connection con=cust_formDAO.getConnection();  
            PreparedStatement ps=con.prepareStatement("select * from cust_form where account_no='"+account_no+"'");  
            
            ResultSet rs=ps.executeQuery();  
            while(rs.next()){  
             c.setAccount_type(rs.getString(1));
                c.setFirst_name(rs.getString(2));
                c.setLast_name(rs.getString(3));
                c.setAddress(rs.getString(4));
                c.setCity(rs.getString(5));
                c.setState(rs.getString(6)); 
                c.setPincode(rs.getString(7)); 
                c.setPhone_no(rs.getString(8));
                c.setAlt_no(rs.getString(9));
                c.setGender(rs.getString(10));
                c.setDob(rs.getString(11));
                c.setMarital_status(rs.getString(12));
                c.setAccount_no(rs.getDouble(13));
                c.setCust_id(rs.getString(14));
           }  
           con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
         
        return c;  
    }  
    public static List<cust_form> getAllcustomer(){  
        List<cust_form> list=new ArrayList<cust_form>();  
          
        try{  
            Connection con=cust_formDAO.getConnection();  
            PreparedStatement ps=con.prepareStatement("select * from cust_form");  
           ResultSet rs=ps.executeQuery();  
            while(rs.next()){  
                cust_form c=new cust_form();  
             c.setAccount_type(rs.getString(1));
                c.setFirst_name(rs.getString(2));
                c.setLast_name(rs.getString(3));
                c.setAddress(rs.getString(4));
                c.setCity(rs.getString(5));
                c.setState(rs.getString(6)); 
                c.setPincode(rs.getString(7)); 
                c.setPhone_no(rs.getString(8));
                c.setAlt_no(rs.getString(9));
                c.setGender(rs.getString(10));
                c.setDob(rs.getString(11));
                c.setMarital_status(rs.getString(12));
                c.setAccount_no(rs.getDouble(13));
                c.setCust_id(rs.getString(14));
                list.add(c);  
            }  
            con.close();  
        }catch(Exception c){c.printStackTrace();}  
          
       return list;  
    }  
  
}  

