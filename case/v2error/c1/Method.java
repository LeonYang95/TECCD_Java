public class Method{
    public Properties getProperties(Resource propertyResource){
        String sql = " SELECT value, dataProviderName, placeName, placeGeometry," + "        referencetime, " + "        validFrom, validTo, " + "        valueParameterName, valueParameterUnit, " + "        levelParameterName, levelUnitName, levelFrom, levelTo, " + "        dataVersion, confidenceCode, storetime, valueid, valuetype " + " FROM wci.read( array['hirlam 10'], 'POINT( 10.0 59.0 )', " + "                ('2000-01-03 01:00:00', '2000-01-03 01:00:00', 'exact'), " + "                NULL, " + "                array['instant pressure of air', " + "                      'instant temperature of air', " + "                      'instant velocity of air (u-component)', " + "                      'instant velocity of air (v-component)'], " + "                ( 2, 2, 'distance above ground', 'exact' ), " + "                array[-1], " + "                NULL::wci.returnFloat )";
    }





}