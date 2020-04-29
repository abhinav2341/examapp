package com.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CommonUtil {

public Boolean checkDuplicateSection(String sectionName) {
Boolean status = false;

Connection con = null;
PreparedStatement ps = null;
try {
con = DB_utility.getDBConnection();
ps = con.prepareStatement("select * from section_table where upper(section) = upper(?)");
ps.setString(1, sectionName);
ResultSet rs = ps.executeQuery();
if(rs.next()) {
status = true;
}
rs.close();
ps.close(); ps =null;
con.close();con =null;	
}catch(Exception e) {
e.printStackTrace();
} finally {
try {
if(ps != null) {
ps.close();
ps = null;
}
} catch (SQLException e) {
// TODO Auto-generated catch block
e.printStackTrace();
}

try {
if(con != null) {
con.close();
con = null;
}
} catch (SQLException e) {
// TODO Auto-generated catch block
e.printStackTrace();
}
}
if(status) {
System.out.println("Duplicate section "+ sectionName+" found");
}
return status;
}

}