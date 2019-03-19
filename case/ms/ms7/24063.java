import java.sql.*;

/**
 * This file gives an example on querying data from an wdb database. The
 * example query returns data for a geographic point.
 *
 * The example illustrates how we connect to the database, initialize the wdb 
 * and query the database.
 *
 * wdb functions used in the example is wci.begin and wci.read.
 *
 * wci.begin 
 * ----------
 *   wci.begin('username')
 *
 * This function initialize the connection for querying the database. It 
 * sets up an session and initialize some defined default values for the user.
 *
 * The username my or may not be the same user we connected to the 
 * database as.
 *
 * wci.read
 * ---------
 * To select data from wdb the function wdi.read is used. This is
 * an overloaded function. The functions differ on the return type.
 * One funtion return data for a given geographical point and one
 * function return a reference to a field. The field is an binary
 * blob.
 *
 * The function signature to get point data.       
 * 
 * wci.read( dataprovider  text[],         - 'HIRLAM10', etc
 *           location      text,           - 'nearest POINT( 10.0 59.0 )'  
 *           referencetime wci.timeSpec,   - ('2008-03-06 12:00:00', '2008-03-06 12:00:00', 'exact')
 *           validtime     wci.timeSpec,   - ('2008-03-06 12:00:00', '2008-03-06 18:00:00', 'inside')
 *           parameter     text[],         - array['instantaneous pressure of air',
 *                                                 'instantaneous temperature of air',
 *                                                 'instantaneous velocity of air (u-component)',
 *                                                 'instantaneous velocity of air (v-component) ]
 *           level         wci.levelSpec,  - ( 2, 2, 'above ground', 'exact' )
 *           dataversion   integer[],      - array[-1] 
 *           returntype    wci.returnFloat - NULL::wci.returnFloat
 *        )
 *
 * wci.timespec  - (fromtime, totime, indeterminate type)
 * wci.levelspec - (fromlevel, tolevel, levelparameter,  indeterminate type)
 *
 * The 'indeterminate type' decribes the "fuzziness" in selecting from 
 * the range parameters from* and to*. Valid types are 'any', 'exact' and 'inside'. 
 *
 * 'any' match anything, regardless of the values of from* and to*.
 * 'exact' match exactly from* to to* with the same values in the data set.
 * 'inside' match all in the range from* to to*, inclusive the end points.
 * 
 * COMPILE
 *   javac wdbGetDataPoint.java
 *  
 * RUN
 *   java -classpath 'postgresql-8.1-412.jdbc3.jar:.' wdbGetDataPoint
 */
public class wdbGetDataPoint {

    public static void main(String[] args) {
        final String dbdriver = "org.postgresql.Driver";
        final String dbconnect = "jdbc:postgresql://prologdev1:5432/wdb";
        final String dbuser = "guest2";
        final String dbpasswd = "";
        Connection con = null;
        Statement statement = null;
        try {
            Class.forName(dbdriver);
            con = DriverManager.getConnection(dbconnect, dbuser, dbpasswd);
            statement = con.createStatement();
        } catch (Exception e) {
            System.out.println("FATAL: cant load the database driver <" + dbdriver + ">!");
            System.exit(1);
        }
        String wdbInit = "SELECT wci.begin('" + dbuser + "')";
        String sql = " SELECT value, dataProviderName, placeName, placeGeometry," + "        referencetime, " + "        validFrom, validTo, " + "        valueParameterName, valueParameterUnit, " + "        levelParameterName, levelUnitName, levelFrom, levelTo, " + "        dataVersion, confidenceCode, storetime, valueid, valuetype " + " FROM wci.read( array['hirlam 10'], 'POINT( 10.0 59.0 )', " + "                ('2000-01-03 01:00:00', '2000-01-03 01:00:00', 'exact'), " + "                NULL, " + "                array['instant pressure of air', " + "                      'instant temperature of air', " + "                      'instant velocity of air (u-component)', " + "                      'instant velocity of air (v-component)'], " + "                ( 2, 2, 'distance above ground', 'exact' ), " + "                array[-1], " + "                NULL::wci.returnFloat )";
        final String colNames[] = { "value", "dataProviderName", "placeName", "referencetime", "validFrom", "validTo", "valueParameterName", "valueParameterUnit", "levelParameterName", "levelUnitName", "levelFrom", "levelTo", "dataVersion" };
        ResultSet rs = null;
        try {
            statement.execute(wdbInit);
            rs = statement.executeQuery(sql);
            ResultSetMetaData rsMetaData = rs.getMetaData();
            String data;
            boolean first;
            while (rs.next()) {
                first = true;
                for (String name : colNames) {
                    data = rs.getString(name);
                    if (first) {
                        first = false;
                    } else {
                        System.out.print(", ");
                    }
                    if (data != null) System.out.print(data); else System.out.print("\\N");
                }
                System.out.println();
            }
        } catch (Exception ex) {
            System.out.println("SELECT error: " + ex);
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    System.out.println("EXCEPTION: rs.close: " + ex);
                }
            }
        }
    }

    public wdbGetDataPoint() {
    }
}
