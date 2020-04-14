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

public class ExcelRead {

    public FileInputStream fis = null;
    public List<Planet> planetList = null;

     public ExcelRead(String filename) {
        try {
            fis = new FileInputStream(filename);
            XSSFWorkbook workbook = new XSSFWorkbook(fis);
            planetList = readPlanetData(workbook.getSheetAt(0));
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

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
                    planet.setPlanet_node(c.getStringCellValue());
                else if (1 == c.getColumnIndex())
                    planet.setPlanet_name(c.getStringCellValue());
            }
            planets.add(planet);
        }
        return planets;
    }

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
                    route.setRoute_id((int)c.getNumericCellValue ());
                else if (1 == c.getColumnIndex())
                    route.setPlanet_origin(c.getStringCellValue());
                else if (2 == c.getColumnIndex())
                    route.setPlanet_destination(c.getStringCellValue());
                else if (3 == c.getColumnIndex())
                    route.setDistance(c.getNumericCellValue());
            }
            routes.add(route);
        }
        return routes;
    }

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
                    t.setRouteid((int)c.getNumericCellValue());
                else if (1 == c.getColumnIndex())
                    t.setPlanet_origin(c.getStringCellValue());
                else if (2 == c.getColumnIndex())
                    t.setPlanet_destination(c.getStringCellValue());
                else if (3 == c.getColumnIndex())
                    t.setTraffic_delay(c.getNumericCellValue());
            }
            traffic.add(t);
        }
        return traffic;
    }

}
