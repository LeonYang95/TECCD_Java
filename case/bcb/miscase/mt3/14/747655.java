package au.org.ala.spatial.utils;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.LinearRing;
import com.vividsolutions.jts.geom.Polygon;
import com.vividsolutions.jts.geom.Point;
import com.vividsolutions.jts.io.WKTWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.geotools.geometry.jts.JTS;
import org.geotools.geometry.jts.JTSFactoryFinder;
import org.geotools.referencing.CRS;
import org.opengis.referencing.crs.CoordinateReferenceSystem;
import org.opengis.referencing.operation.MathTransform;

/**
 * Geometry utilities 
 * 
 * @author ajay
 */
public class GeometryUtil {

    private static String readGeoJSON(String feature) {
        StringBuffer content = new StringBuffer();
        try {
            URL url = new URL(feature);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.connect();
            BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = rd.readLine()) != null) {
                content.append(line);
            }
            conn.disconnect();
        } catch (Exception e) {
        }
        return content.toString();
    }

}
