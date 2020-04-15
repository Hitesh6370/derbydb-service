package com.transportsystem.derbyDB.api.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.transportsystem.derbyDB.api.persistence.entity.Planet;
import com.transportsystem.derbyDB.api.persistence.entity.Route;
import com.transportsystem.derbyDB.api.persistence.entity.Traffic;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * The type Excel read.
 */
public class ExcelRead {

    /**
     * Instantiates a new Excel read.
     *
     * @param filename the filename
     */
    public ExcelRead(String filename) {
        try {
            FileInputStream fis = new FileInputStream(filename);
            XSSFWorkbook workbook = new XSSFWorkbook(fis);
            List<Planet> planetList = readPlanetData(workbook.getSheetAt(0));
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Read planet data list.
     *
     * @param sheet the sheet
     * @return the list
     */
    public List<Planet> readPlanetData(XSSFSheet sheet) {
        ArrayList<Planet> planets = new ArrayList<>();
        Iterator<Row> row = sheet.rowIterator();
        while (row.hasNext()) {
            Row r = row.next();
            if (r.getRowNum() == 0)
                continue;
            Planet planet = new Planet();
            Iterator<Cell> cell = r.cellIterator();
            while (cell.hasNext()) {
                Cell c = cell.next();
                if (0 == c.getColumnIndex())
                    planet.setPlanetNode(c.getStringCellValue());
                else if (1 == c.getColumnIndex())
                    planet.setPlanetName(c.getStringCellValue());
            }
            planets.add(planet);
        }
        return planets;
    }

    /**
     * Read routes data list.
     *
     * @param sheet the sheet
     * @return the list
     */
    public List<Route> readRoutesData(XSSFSheet sheet) {
        ArrayList<Route> routes = new ArrayList<>();
        Iterator<Row> row = sheet.rowIterator();
        while (row.hasNext()) {
            Row r = row.next();
            if (r.getRowNum() == 0)
                continue;
            Route route = new Route();
            Iterator<Cell> cell = r.cellIterator();
            while (cell.hasNext()) {
                Cell c = cell.next();
                if (0 == c.getColumnIndex())
                    route.setRouteId((int)c.getNumericCellValue ());
                else if (1 == c.getColumnIndex())
                    route.setPlanetOriginNode(c.getStringCellValue());
                else if (2 == c.getColumnIndex())
                    route.setPlanetDestinationNode(c.getStringCellValue());
                else if (3 == c.getColumnIndex())
                    route.setDuration(c.getNumericCellValue());
            }
            routes.add(route);
        }
        return routes;
    }

    /**
     * Read traffic data list.
     *
     * @param sheet the sheet
     * @return the list
     */
    public List<Traffic> readTrafficData(XSSFSheet sheet) {
        ArrayList<Traffic> traffic = new ArrayList<>();
        Iterator<Row> row = sheet.rowIterator();
        while (row.hasNext()) {
            Row r = row.next();
            if (r.getRowNum() == 0)
                continue;
            Traffic t = new Traffic();
            Iterator<Cell> cell = r.cellIterator();
            while (cell.hasNext()) {
                Cell c = cell.next();
                if (0 == c.getColumnIndex())
                    t.setRouteId((int)c.getNumericCellValue());
                else if (1 == c.getColumnIndex())
                    t.setPlanetOriginNode(c.getStringCellValue());
                else if (2 == c.getColumnIndex())
                    t.setPlanetDestinationNode(c.getStringCellValue());
                else if (3 == c.getColumnIndex())
                    t.setTrafficDelay(c.getNumericCellValue());
            }
            traffic.add(t);
        }
        return traffic;
    }

}
